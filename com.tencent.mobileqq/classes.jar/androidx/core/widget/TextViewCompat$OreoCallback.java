package androidx.core.widget;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.text.Editable;
import android.view.ActionMode;
import android.view.ActionMode.Callback;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import androidx.annotation.RequiresApi;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@RequiresApi(26)
class TextViewCompat$OreoCallback
  implements ActionMode.Callback
{
  private static final int MENU_ITEM_ORDER_PROCESS_TEXT_INTENT_ACTIONS_START = 100;
  private final ActionMode.Callback mCallback;
  private boolean mCanUseMenuBuilderReferences;
  private boolean mInitializedMenuBuilderReferences;
  private Class<?> mMenuBuilderClass;
  private Method mMenuBuilderRemoveItemAtMethod;
  private final TextView mTextView;
  
  TextViewCompat$OreoCallback(ActionMode.Callback paramCallback, TextView paramTextView)
  {
    this.mCallback = paramCallback;
    this.mTextView = paramTextView;
    this.mInitializedMenuBuilderReferences = false;
  }
  
  private Intent createProcessTextIntent()
  {
    return new Intent().setAction("android.intent.action.PROCESS_TEXT").setType("text/plain");
  }
  
  private Intent createProcessTextIntentForResolveInfo(ResolveInfo paramResolveInfo, TextView paramTextView)
  {
    Intent localIntent = createProcessTextIntent();
    if (!isEditable(paramTextView)) {}
    for (boolean bool = true;; bool = false) {
      return localIntent.putExtra("android.intent.extra.PROCESS_TEXT_READONLY", bool).setClassName(paramResolveInfo.activityInfo.packageName, paramResolveInfo.activityInfo.name);
    }
  }
  
  private List<ResolveInfo> getSupportedActivities(Context paramContext, PackageManager paramPackageManager)
  {
    ArrayList localArrayList = new ArrayList();
    if (!(paramContext instanceof Activity)) {
      return localArrayList;
    }
    paramPackageManager = paramPackageManager.queryIntentActivities(createProcessTextIntent(), 0).iterator();
    while (paramPackageManager.hasNext())
    {
      ResolveInfo localResolveInfo = (ResolveInfo)paramPackageManager.next();
      if (isSupportedActivity(localResolveInfo, paramContext)) {
        localArrayList.add(localResolveInfo);
      }
    }
    return localArrayList;
  }
  
  private boolean isEditable(TextView paramTextView)
  {
    return ((paramTextView instanceof Editable)) && (paramTextView.onCheckIsTextEditor()) && (paramTextView.isEnabled());
  }
  
  private boolean isSupportedActivity(ResolveInfo paramResolveInfo, Context paramContext)
  {
    boolean bool2 = false;
    boolean bool1;
    if (paramContext.getPackageName().equals(paramResolveInfo.activityInfo.packageName)) {
      bool1 = true;
    }
    do
    {
      do
      {
        return bool1;
        bool1 = bool2;
      } while (!paramResolveInfo.activityInfo.exported);
      if (paramResolveInfo.activityInfo.permission == null) {
        break;
      }
      bool1 = bool2;
    } while (paramContext.checkSelfPermission(paramResolveInfo.activityInfo.permission) != 0);
    return true;
  }
  
  /* Error */
  private void recomputeProcessTextMenuItems(Menu paramMenu)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 33	androidx/core/widget/TextViewCompat$OreoCallback:mTextView	Landroid/widget/TextView;
    //   4: invokevirtual 169	android/widget/TextView:getContext	()Landroid/content/Context;
    //   7: astore 5
    //   9: aload 5
    //   11: invokevirtual 173	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   14: astore 4
    //   16: aload_0
    //   17: getfield 35	androidx/core/widget/TextViewCompat$OreoCallback:mInitializedMenuBuilderReferences	Z
    //   20: ifne +45 -> 65
    //   23: aload_0
    //   24: iconst_1
    //   25: putfield 35	androidx/core/widget/TextViewCompat$OreoCallback:mInitializedMenuBuilderReferences	Z
    //   28: aload_0
    //   29: ldc 175
    //   31: invokestatic 181	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   34: putfield 183	androidx/core/widget/TextViewCompat$OreoCallback:mMenuBuilderClass	Ljava/lang/Class;
    //   37: aload_0
    //   38: aload_0
    //   39: getfield 183	androidx/core/widget/TextViewCompat$OreoCallback:mMenuBuilderClass	Ljava/lang/Class;
    //   42: ldc 185
    //   44: iconst_1
    //   45: anewarray 177	java/lang/Class
    //   48: dup
    //   49: iconst_0
    //   50: getstatic 190	java/lang/Integer:TYPE	Ljava/lang/Class;
    //   53: aastore
    //   54: invokevirtual 194	java/lang/Class:getDeclaredMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   57: putfield 196	androidx/core/widget/TextViewCompat$OreoCallback:mMenuBuilderRemoveItemAtMethod	Ljava/lang/reflect/Method;
    //   60: aload_0
    //   61: iconst_1
    //   62: putfield 198	androidx/core/widget/TextViewCompat$OreoCallback:mCanUseMenuBuilderReferences	Z
    //   65: aload_0
    //   66: getfield 198	androidx/core/widget/TextViewCompat$OreoCallback:mCanUseMenuBuilderReferences	Z
    //   69: ifeq +112 -> 181
    //   72: aload_0
    //   73: getfield 183	androidx/core/widget/TextViewCompat$OreoCallback:mMenuBuilderClass	Ljava/lang/Class;
    //   76: aload_1
    //   77: invokevirtual 201	java/lang/Class:isInstance	(Ljava/lang/Object;)Z
    //   80: ifeq +101 -> 181
    //   83: aload_0
    //   84: getfield 196	androidx/core/widget/TextViewCompat$OreoCallback:mMenuBuilderRemoveItemAtMethod	Ljava/lang/reflect/Method;
    //   87: astore_3
    //   88: aload_1
    //   89: invokeinterface 207 1 0
    //   94: iconst_1
    //   95: isub
    //   96: istore_2
    //   97: iload_2
    //   98: iflt +106 -> 204
    //   101: aload_1
    //   102: iload_2
    //   103: invokeinterface 211 2 0
    //   108: astore 6
    //   110: aload 6
    //   112: invokeinterface 216 1 0
    //   117: ifnull +38 -> 155
    //   120: ldc 43
    //   122: aload 6
    //   124: invokeinterface 216 1 0
    //   129: invokevirtual 219	android/content/Intent:getAction	()Ljava/lang/String;
    //   132: invokevirtual 145	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   135: ifeq +20 -> 155
    //   138: aload_3
    //   139: aload_1
    //   140: iconst_1
    //   141: anewarray 4	java/lang/Object
    //   144: dup
    //   145: iconst_0
    //   146: iload_2
    //   147: invokestatic 223	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   150: aastore
    //   151: invokevirtual 229	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   154: pop
    //   155: iload_2
    //   156: iconst_1
    //   157: isub
    //   158: istore_2
    //   159: goto -62 -> 97
    //   162: astore_3
    //   163: aload_0
    //   164: aconst_null
    //   165: putfield 183	androidx/core/widget/TextViewCompat$OreoCallback:mMenuBuilderClass	Ljava/lang/Class;
    //   168: aload_0
    //   169: aconst_null
    //   170: putfield 196	androidx/core/widget/TextViewCompat$OreoCallback:mMenuBuilderRemoveItemAtMethod	Ljava/lang/reflect/Method;
    //   173: aload_0
    //   174: iconst_0
    //   175: putfield 198	androidx/core/widget/TextViewCompat$OreoCallback:mCanUseMenuBuilderReferences	Z
    //   178: goto -113 -> 65
    //   181: aload_1
    //   182: invokevirtual 233	java/lang/Object:getClass	()Ljava/lang/Class;
    //   185: ldc 185
    //   187: iconst_1
    //   188: anewarray 177	java/lang/Class
    //   191: dup
    //   192: iconst_0
    //   193: getstatic 190	java/lang/Integer:TYPE	Ljava/lang/Class;
    //   196: aastore
    //   197: invokevirtual 194	java/lang/Class:getDeclaredMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   200: astore_3
    //   201: goto -113 -> 88
    //   204: aload_0
    //   205: aload 5
    //   207: aload 4
    //   209: invokespecial 235	androidx/core/widget/TextViewCompat$OreoCallback:getSupportedActivities	(Landroid/content/Context;Landroid/content/pm/PackageManager;)Ljava/util/List;
    //   212: astore_3
    //   213: iconst_0
    //   214: istore_2
    //   215: iload_2
    //   216: aload_3
    //   217: invokeinterface 236 1 0
    //   222: if_icmpge +63 -> 285
    //   225: aload_3
    //   226: iload_2
    //   227: invokeinterface 240 2 0
    //   232: checkcast 68	android/content/pm/ResolveInfo
    //   235: astore 5
    //   237: aload_1
    //   238: iconst_0
    //   239: iconst_0
    //   240: iload_2
    //   241: bipush 100
    //   243: iadd
    //   244: aload 5
    //   246: aload 4
    //   248: invokevirtual 244	android/content/pm/ResolveInfo:loadLabel	(Landroid/content/pm/PackageManager;)Ljava/lang/CharSequence;
    //   251: invokeinterface 247 5 0
    //   256: aload_0
    //   257: aload 5
    //   259: aload_0
    //   260: getfield 33	androidx/core/widget/TextViewCompat$OreoCallback:mTextView	Landroid/widget/TextView;
    //   263: invokespecial 249	androidx/core/widget/TextViewCompat$OreoCallback:createProcessTextIntentForResolveInfo	(Landroid/content/pm/ResolveInfo;Landroid/widget/TextView;)Landroid/content/Intent;
    //   266: invokeinterface 253 2 0
    //   271: iconst_1
    //   272: invokeinterface 257 2 0
    //   277: iload_2
    //   278: iconst_1
    //   279: iadd
    //   280: istore_2
    //   281: goto -66 -> 215
    //   284: astore_1
    //   285: return
    //   286: astore_1
    //   287: return
    //   288: astore_1
    //   289: return
    //   290: astore_3
    //   291: goto -128 -> 163
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	294	0	this	OreoCallback
    //   0	294	1	paramMenu	Menu
    //   96	185	2	i	int
    //   87	52	3	localMethod	Method
    //   162	1	3	localClassNotFoundException	java.lang.ClassNotFoundException
    //   200	26	3	localObject1	Object
    //   290	1	3	localNoSuchMethodException	java.lang.NoSuchMethodException
    //   14	233	4	localPackageManager	PackageManager
    //   7	251	5	localObject2	Object
    //   108	15	6	localMenuItem	MenuItem
    // Exception table:
    //   from	to	target	type
    //   28	65	162	java/lang/ClassNotFoundException
    //   65	88	284	java/lang/IllegalAccessException
    //   88	97	284	java/lang/IllegalAccessException
    //   101	155	284	java/lang/IllegalAccessException
    //   181	201	284	java/lang/IllegalAccessException
    //   65	88	286	java/lang/NoSuchMethodException
    //   88	97	286	java/lang/NoSuchMethodException
    //   101	155	286	java/lang/NoSuchMethodException
    //   181	201	286	java/lang/NoSuchMethodException
    //   65	88	288	java/lang/reflect/InvocationTargetException
    //   88	97	288	java/lang/reflect/InvocationTargetException
    //   101	155	288	java/lang/reflect/InvocationTargetException
    //   181	201	288	java/lang/reflect/InvocationTargetException
    //   28	65	290	java/lang/NoSuchMethodException
  }
  
  public boolean onActionItemClicked(ActionMode paramActionMode, MenuItem paramMenuItem)
  {
    return this.mCallback.onActionItemClicked(paramActionMode, paramMenuItem);
  }
  
  public boolean onCreateActionMode(ActionMode paramActionMode, Menu paramMenu)
  {
    return this.mCallback.onCreateActionMode(paramActionMode, paramMenu);
  }
  
  public void onDestroyActionMode(ActionMode paramActionMode)
  {
    this.mCallback.onDestroyActionMode(paramActionMode);
  }
  
  public boolean onPrepareActionMode(ActionMode paramActionMode, Menu paramMenu)
  {
    recomputeProcessTextMenuItems(paramMenu);
    return this.mCallback.onPrepareActionMode(paramActionMode, paramMenu);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     androidx.core.widget.TextViewCompat.OreoCallback
 * JD-Core Version:    0.7.0.1
 */