package androidx.appcompat.view;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.MenuInflater;
import androidx.annotation.RestrictTo;
import androidx.core.view.ActionProvider;
import org.xmlpull.v1.XmlPullParser;

@RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class SupportMenuInflater
  extends MenuInflater
{
  static final Class<?>[] ACTION_PROVIDER_CONSTRUCTOR_SIGNATURE = ACTION_VIEW_CONSTRUCTOR_SIGNATURE;
  static final Class<?>[] ACTION_VIEW_CONSTRUCTOR_SIGNATURE = { Context.class };
  static final String LOG_TAG = "SupportMenuInflater";
  static final int NO_ID = 0;
  private static final String XML_GROUP = "group";
  private static final String XML_ITEM = "item";
  private static final String XML_MENU = "menu";
  final Object[] mActionProviderConstructorArguments;
  final Object[] mActionViewConstructorArguments;
  Context mContext;
  private Object mRealOwner;
  
  public SupportMenuInflater(Context paramContext)
  {
    super(paramContext);
    this.mContext = paramContext;
    this.mActionViewConstructorArguments = new Object[] { paramContext };
    this.mActionProviderConstructorArguments = this.mActionViewConstructorArguments;
  }
  
  private Object findRealOwner(Object paramObject)
  {
    if ((paramObject instanceof Activity)) {
      return paramObject;
    }
    Object localObject = paramObject;
    if ((paramObject instanceof ContextWrapper)) {
      localObject = findRealOwner(((ContextWrapper)paramObject).getBaseContext());
    }
    return localObject;
  }
  
  private void parseMenu(XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet, Menu paramMenu)
  {
    SupportMenuInflater.MenuState localMenuState = new SupportMenuInflater.MenuState(this, paramMenu);
    int i = paramXmlPullParser.getEventType();
    do
    {
      if (i == 2)
      {
        paramMenu = paramXmlPullParser.getName();
        if (paramMenu.equals("menu"))
        {
          i = paramXmlPullParser.next();
          break;
        }
        paramXmlPullParser = new StringBuilder();
        paramXmlPullParser.append("Expecting menu, got ");
        paramXmlPullParser.append(paramMenu);
        throw new RuntimeException(paramXmlPullParser.toString());
      }
      j = paramXmlPullParser.next();
      i = j;
    } while (j != 1);
    i = j;
    Object localObject = null;
    int j = 0;
    int k = 0;
    int n = i;
    while (j == 0) {
      if (n != 1)
      {
        int m;
        if (n != 2)
        {
          if (n != 3)
          {
            i = k;
            paramMenu = (Menu)localObject;
            m = j;
          }
          else
          {
            String str = paramXmlPullParser.getName();
            if ((k != 0) && (str.equals(localObject)))
            {
              paramMenu = null;
              i = 0;
              m = j;
            }
            else if (str.equals("group"))
            {
              localMenuState.resetGroup();
              i = k;
              paramMenu = (Menu)localObject;
              m = j;
            }
            else if (str.equals("item"))
            {
              i = k;
              paramMenu = (Menu)localObject;
              m = j;
              if (!localMenuState.hasAddedItem()) {
                if ((localMenuState.itemActionProvider != null) && (localMenuState.itemActionProvider.hasSubMenu()))
                {
                  localMenuState.addSubMenuItem();
                  i = k;
                  paramMenu = (Menu)localObject;
                  m = j;
                }
                else
                {
                  localMenuState.addItem();
                  i = k;
                  paramMenu = (Menu)localObject;
                  m = j;
                }
              }
            }
            else
            {
              i = k;
              paramMenu = (Menu)localObject;
              m = j;
              if (str.equals("menu"))
              {
                m = 1;
                i = k;
                paramMenu = (Menu)localObject;
              }
            }
          }
        }
        else if (k != 0)
        {
          i = k;
          paramMenu = (Menu)localObject;
          m = j;
        }
        else
        {
          paramMenu = paramXmlPullParser.getName();
          if (paramMenu.equals("group"))
          {
            localMenuState.readGroup(paramAttributeSet);
            i = k;
            paramMenu = (Menu)localObject;
            m = j;
          }
          else if (paramMenu.equals("item"))
          {
            localMenuState.readItem(paramAttributeSet);
            i = k;
            paramMenu = (Menu)localObject;
            m = j;
          }
          else if (paramMenu.equals("menu"))
          {
            parseMenu(paramXmlPullParser, paramAttributeSet, localMenuState.addSubMenuItem());
            i = k;
            paramMenu = (Menu)localObject;
            m = j;
          }
          else
          {
            i = 1;
            m = j;
          }
        }
        n = paramXmlPullParser.next();
        k = i;
        localObject = paramMenu;
        j = m;
      }
      else
      {
        throw new RuntimeException("Unexpected end of document");
      }
    }
  }
  
  Object getRealOwner()
  {
    if (this.mRealOwner == null) {
      this.mRealOwner = findRealOwner(this.mContext);
    }
    return this.mRealOwner;
  }
  
  /* Error */
  public void inflate(@androidx.annotation.LayoutRes int paramInt, Menu paramMenu)
  {
    // Byte code:
    //   0: aload_2
    //   1: instanceof 161
    //   4: ifne +10 -> 14
    //   7: aload_0
    //   8: iload_1
    //   9: aload_2
    //   10: invokespecial 163	android/view/MenuInflater:inflate	(ILandroid/view/Menu;)V
    //   13: return
    //   14: aconst_null
    //   15: astore 4
    //   17: aconst_null
    //   18: astore 5
    //   20: aconst_null
    //   21: astore_3
    //   22: aload_0
    //   23: getfield 52	androidx/appcompat/view/SupportMenuInflater:mContext	Landroid/content/Context;
    //   26: invokevirtual 167	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   29: iload_1
    //   30: invokevirtual 173	android/content/res/Resources:getLayout	(I)Landroid/content/res/XmlResourceParser;
    //   33: astore 6
    //   35: aload 6
    //   37: astore_3
    //   38: aload 6
    //   40: astore 4
    //   42: aload 6
    //   44: astore 5
    //   46: aload_0
    //   47: aload 6
    //   49: aload 6
    //   51: invokestatic 179	android/util/Xml:asAttributeSet	(Lorg/xmlpull/v1/XmlPullParser;)Landroid/util/AttributeSet;
    //   54: aload_2
    //   55: invokespecial 146	androidx/appcompat/view/SupportMenuInflater:parseMenu	(Lorg/xmlpull/v1/XmlPullParser;Landroid/util/AttributeSet;Landroid/view/Menu;)V
    //   58: aload 6
    //   60: ifnull +10 -> 70
    //   63: aload 6
    //   65: invokeinterface 184 1 0
    //   70: return
    //   71: astore_2
    //   72: goto +33 -> 105
    //   75: astore_2
    //   76: aload 4
    //   78: astore_3
    //   79: new 186	android/view/InflateException
    //   82: dup
    //   83: ldc 188
    //   85: aload_2
    //   86: invokespecial 191	android/view/InflateException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   89: athrow
    //   90: astore_2
    //   91: aload 5
    //   93: astore_3
    //   94: new 186	android/view/InflateException
    //   97: dup
    //   98: ldc 188
    //   100: aload_2
    //   101: invokespecial 191	android/view/InflateException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   104: athrow
    //   105: aload_3
    //   106: ifnull +9 -> 115
    //   109: aload_3
    //   110: invokeinterface 184 1 0
    //   115: aload_2
    //   116: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	117	0	this	SupportMenuInflater
    //   0	117	1	paramInt	int
    //   0	117	2	paramMenu	Menu
    //   21	89	3	localObject1	Object
    //   15	62	4	localObject2	Object
    //   18	74	5	localObject3	Object
    //   33	31	6	localXmlResourceParser	android.content.res.XmlResourceParser
    // Exception table:
    //   from	to	target	type
    //   22	35	71	finally
    //   46	58	71	finally
    //   79	90	71	finally
    //   94	105	71	finally
    //   22	35	75	java/io/IOException
    //   46	58	75	java/io/IOException
    //   22	35	90	org/xmlpull/v1/XmlPullParserException
    //   46	58	90	org/xmlpull/v1/XmlPullParserException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.appcompat.view.SupportMenuInflater
 * JD-Core Version:    0.7.0.1
 */