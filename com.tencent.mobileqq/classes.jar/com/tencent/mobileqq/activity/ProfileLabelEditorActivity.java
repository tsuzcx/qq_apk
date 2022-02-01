package com.tencent.mobileqq.activity;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.Window;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.profile.ProfileLabelTypeInfo;
import com.tencent.mobileqq.profile.view.ProfileLabelPanel;
import com.tencent.mobileqq.profile.view.ProfileLabelPanel.LabelStatusManager;
import com.tencent.mobileqq.profilecard.entity.ProfileLabelInfo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.List<Lcom.tencent.mobileqq.profilecard.entity.ProfileLabelInfo;>;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ProfileLabelEditorActivity
  extends IphoneTitleBarActivity
{
  public static final int[][] a = { { 2130852769, 2131168266 }, { 2130852772, 2131168267 }, { 2130852775, 2131168268 } };
  public LinearLayout b;
  public TextView c;
  public GridView d;
  public ProfileLabelEditorActivity.MyLabelGridViewAdapter e;
  public ProfileLabelPanel f;
  public float g;
  public boolean h;
  public Card i;
  public Context j;
  public ProfileLabelPanel.LabelStatusManager k;
  public List<ProfileLabelInfo> l = new ArrayList();
  public List<ProfileLabelTypeInfo> m = new ArrayList();
  public List<Long> n = new ArrayList();
  private CardObserver o = new ProfileLabelEditorActivity.1(this);
  
  private List<ProfileLabelInfo> a(String paramString)
  {
    this.i = ((FriendsManager)this.app.getManager(QQManagerFactory.FRIENDS_MANAGER)).f(paramString);
    paramString = this.i;
    if (paramString != null)
    {
      this.l = paramString.getLabelList();
      paramString = this.l;
      if (paramString != null) {
        b(paramString);
      }
    }
    return this.l;
  }
  
  private void a(List<ProfileLabelInfo> paramList, List<ProfileLabelTypeInfo> paramList1)
  {
    Iterator localIterator1 = paramList1.iterator();
    while (localIterator1.hasNext())
    {
      Iterator localIterator2 = ((ProfileLabelTypeInfo)localIterator1.next()).labels.iterator();
      while (localIterator2.hasNext())
      {
        ProfileLabelInfo localProfileLabelInfo = (ProfileLabelInfo)localIterator2.next();
        localProfileLabelInfo.labelStatus = ProfileLabelInfo.STATUS_NORMAL;
        if (a(localProfileLabelInfo.labelId, paramList)) {
          localProfileLabelInfo.labelStatus = ProfileLabelInfo.STATUS_CHECKED;
        }
      }
    }
    d(paramList1);
  }
  
  /* Error */
  private String b(String paramString)
  {
    // Byte code:
    //   0: new 160	java/io/ByteArrayOutputStream
    //   3: dup
    //   4: invokespecial 161	java/io/ByteArrayOutputStream:<init>	()V
    //   7: astore 5
    //   9: aload_0
    //   10: getfield 163	com/tencent/mobileqq/activity/ProfileLabelEditorActivity:j	Landroid/content/Context;
    //   13: invokevirtual 169	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   16: aload_1
    //   17: invokevirtual 175	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   20: astore_3
    //   21: aload_3
    //   22: astore_1
    //   23: sipush 4096
    //   26: newarray byte
    //   28: astore 4
    //   30: aload_3
    //   31: astore_1
    //   32: aload_3
    //   33: aload 4
    //   35: iconst_0
    //   36: sipush 4096
    //   39: invokevirtual 181	java/io/InputStream:read	([BII)I
    //   42: istore_2
    //   43: iload_2
    //   44: iconst_m1
    //   45: if_icmpeq +17 -> 62
    //   48: aload_3
    //   49: astore_1
    //   50: aload 5
    //   52: aload 4
    //   54: iconst_0
    //   55: iload_2
    //   56: invokevirtual 185	java/io/ByteArrayOutputStream:write	([BII)V
    //   59: goto -29 -> 30
    //   62: aload_3
    //   63: astore_1
    //   64: new 187	java/lang/String
    //   67: dup
    //   68: aload 5
    //   70: invokevirtual 191	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   73: ldc 193
    //   75: invokespecial 196	java/lang/String:<init>	([BLjava/lang/String;)V
    //   78: astore 4
    //   80: aload_3
    //   81: ifnull +7 -> 88
    //   84: aload_3
    //   85: invokevirtual 199	java/io/InputStream:close	()V
    //   88: aload 5
    //   90: invokevirtual 200	java/io/ByteArrayOutputStream:close	()V
    //   93: aload 4
    //   95: areturn
    //   96: astore_1
    //   97: ldc 202
    //   99: iconst_1
    //   100: ldc 204
    //   102: aload_1
    //   103: invokestatic 209	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   106: aload 4
    //   108: areturn
    //   109: astore_3
    //   110: goto +57 -> 167
    //   113: astore 4
    //   115: goto +13 -> 128
    //   118: astore_3
    //   119: aconst_null
    //   120: astore_1
    //   121: goto +46 -> 167
    //   124: astore 4
    //   126: aconst_null
    //   127: astore_3
    //   128: aload_3
    //   129: astore_1
    //   130: ldc 202
    //   132: iconst_1
    //   133: ldc 204
    //   135: aload 4
    //   137: invokestatic 209	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   140: aload_3
    //   141: ifnull +7 -> 148
    //   144: aload_3
    //   145: invokevirtual 199	java/io/InputStream:close	()V
    //   148: aload 5
    //   150: invokevirtual 200	java/io/ByteArrayOutputStream:close	()V
    //   153: aconst_null
    //   154: areturn
    //   155: astore_1
    //   156: ldc 202
    //   158: iconst_1
    //   159: ldc 204
    //   161: aload_1
    //   162: invokestatic 209	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   165: aconst_null
    //   166: areturn
    //   167: aload_1
    //   168: ifnull +7 -> 175
    //   171: aload_1
    //   172: invokevirtual 199	java/io/InputStream:close	()V
    //   175: aload 5
    //   177: invokevirtual 200	java/io/ByteArrayOutputStream:close	()V
    //   180: goto +13 -> 193
    //   183: astore_1
    //   184: ldc 202
    //   186: iconst_1
    //   187: ldc 204
    //   189: aload_1
    //   190: invokestatic 209	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   193: goto +5 -> 198
    //   196: aload_3
    //   197: athrow
    //   198: goto -2 -> 196
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	201	0	this	ProfileLabelEditorActivity
    //   0	201	1	paramString	String
    //   42	14	2	i1	int
    //   20	65	3	localInputStream	InputStream
    //   109	1	3	localObject1	Object
    //   118	1	3	localObject2	Object
    //   127	70	3	localObject3	Object
    //   28	79	4	localObject4	Object
    //   113	1	4	localIOException1	IOException
    //   124	12	4	localIOException2	IOException
    //   7	169	5	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    // Exception table:
    //   from	to	target	type
    //   84	88	96	java/lang/Exception
    //   88	93	96	java/lang/Exception
    //   23	30	109	finally
    //   32	43	109	finally
    //   50	59	109	finally
    //   64	80	109	finally
    //   130	140	109	finally
    //   23	30	113	java/io/IOException
    //   32	43	113	java/io/IOException
    //   50	59	113	java/io/IOException
    //   64	80	113	java/io/IOException
    //   9	21	118	finally
    //   9	21	124	java/io/IOException
    //   144	148	155	java/lang/Exception
    //   148	153	155	java/lang/Exception
    //   171	175	183	java/lang/Exception
    //   175	180	183	java/lang/Exception
  }
  
  private void b(List<ProfileLabelInfo> paramList)
  {
    this.n.clear();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      ProfileLabelInfo localProfileLabelInfo = (ProfileLabelInfo)paramList.next();
      this.n.add(localProfileLabelInfo.labelId);
    }
  }
  
  private void c()
  {
    if (b())
    {
      if (this.h)
      {
        b(2131917012);
        return;
      }
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("saveEdit save labes num = ");
        localStringBuilder.append(this.l.size());
        QLog.d("ProfileLabelEditorActivity", 2, localStringBuilder.toString());
      }
      this.h = true;
      ((CardHandler)this.app.getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER)).a(this.l);
      return;
    }
    finish();
  }
  
  private void c(String paramString)
  {
    if (paramString != null)
    {
      paramString = new JSONArray(paramString);
      int i3 = paramString.length();
      int i1 = 0;
      while (i1 < i3)
      {
        Object localObject = paramString.optJSONObject(i1);
        ProfileLabelTypeInfo localProfileLabelTypeInfo = new ProfileLabelTypeInfo();
        localProfileLabelTypeInfo.typeId = ((JSONObject)localObject).optString("id");
        localProfileLabelTypeInfo.typeName = ((JSONObject)localObject).optString("name");
        localProfileLabelTypeInfo.typeInfo = ((JSONObject)localObject).optString("classinfo");
        localObject = ((JSONObject)localObject).optJSONArray("taglist");
        int i4 = ((JSONArray)localObject).length();
        int i2 = 0;
        while (i2 < i4)
        {
          JSONObject localJSONObject = ((JSONArray)localObject).getJSONObject(i2);
          ProfileLabelInfo localProfileLabelInfo = new ProfileLabelInfo();
          localProfileLabelInfo.labelId = Long.valueOf(localJSONObject.optLong("id"));
          localProfileLabelInfo.labelName = localJSONObject.optString("name");
          localProfileLabelInfo.typeId = localProfileLabelTypeInfo.typeId;
          localProfileLabelTypeInfo.labels.add(localProfileLabelInfo);
          i2 += 1;
        }
        this.m.add(localProfileLabelTypeInfo);
        i1 += 1;
      }
    }
  }
  
  private void c(List<ProfileLabelInfo> paramList)
  {
    Object localObject = this.l;
    if (localObject != null)
    {
      this.e = new ProfileLabelEditorActivity.MyLabelGridViewAdapter(this, (List)localObject);
      this.d.setAdapter(this.e);
      a(this.l.size());
    }
    localObject = new File(BaseApplicationImpl.getApplication().getFilesDir(), "labelList");
    if (!((File)localObject).exists())
    {
      f();
      return;
    }
    localObject = new ByteArrayInputStream(FileUtils.fileToBytes((File)localObject));
    try
    {
      ObjectInputStream localObjectInputStream = new ObjectInputStream((InputStream)localObject);
      this.m = ((List)localObjectInputStream.readObject());
      localObjectInputStream.close();
      ((ByteArrayInputStream)localObject).close();
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      localClassNotFoundException.printStackTrace();
    }
    catch (IOException localIOException)
    {
      localIOException.printStackTrace();
    }
    if (!e())
    {
      if (QLog.isColorLevel()) {
        QLog.d("ProfileLabelEditorActivity", 2, "get available label list fail ");
      }
      f();
    }
    if (e()) {
      a(paramList, this.m);
    }
  }
  
  private void d()
  {
    ThreadManager.post(new ProfileLabelEditorActivity.3(this), 8, null, true);
  }
  
  private void d(List<ProfileLabelTypeInfo> paramList)
  {
    this.f = new ProfileLabelPanel(this.j, this.k, paramList, new ProfileLabelEditorActivity.4(this));
    paramList = new LinearLayout.LayoutParams(-1, (int)(this.g * 202.0F));
    this.b.addView(this.f, paramList);
  }
  
  private boolean e()
  {
    List localList = this.m;
    return (localList != null) && (localList.size() > 0);
  }
  
  private void f()
  {
    try
    {
      c(b("qvip_default_tags.json"));
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      return;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
  }
  
  public void a()
  {
    super.setContentView(2131625608);
    getWindow().setBackgroundDrawable(null);
    super.setTitle(getString(2131917010));
    this.b = ((LinearLayout)findViewById(2131445137));
    this.c = ((TextView)this.b.findViewById(2131446782));
    this.d = ((GridView)this.b.findViewById(2131446779));
    setRightButton(2131915860, new ProfileLabelEditorActivity.2(this));
    enableRightHighlight(true);
  }
  
  void a(int paramInt)
  {
    if (paramInt > 7) {
      return;
    }
    TextView localTextView = this.c;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(getString(2131917009));
    localStringBuilder.append(" (");
    localStringBuilder.append(paramInt);
    localStringBuilder.append("/");
    localStringBuilder.append(7);
    localStringBuilder.append(")");
    localTextView.setText(localStringBuilder.toString());
  }
  
  void a(ProfileLabelInfo paramProfileLabelInfo, List<ProfileLabelInfo> paramList)
  {
    if (paramList != null)
    {
      int i1 = 0;
      while (i1 < paramList.size())
      {
        if (((ProfileLabelInfo)paramList.get(i1)).labelId.equals(paramProfileLabelInfo.labelId))
        {
          paramList.remove(i1);
          ReportController.b(this.app, "CliOper", "", "", "card_mall", "0X80066C7", 0, 0, "2", "", "", "");
        }
        i1 += 1;
      }
    }
  }
  
  boolean a(Long paramLong, List<ProfileLabelInfo> paramList)
  {
    return b(paramLong, paramList) != null;
  }
  
  boolean a(List<ProfileLabelInfo> paramList)
  {
    return paramList.size() >= 7;
  }
  
  ProfileLabelInfo b(Long paramLong, List<ProfileLabelInfo> paramList)
  {
    Object localObject1 = null;
    Object localObject2 = null;
    if (paramList != null)
    {
      Iterator localIterator = paramList.iterator();
      paramList = localObject2;
      for (;;)
      {
        localObject1 = paramList;
        if (!localIterator.hasNext()) {
          break;
        }
        localObject1 = (ProfileLabelInfo)localIterator.next();
        if (((ProfileLabelInfo)localObject1).labelId.equals(paramLong)) {
          paramList = (List<ProfileLabelInfo>)localObject1;
        }
      }
    }
    return localObject1;
  }
  
  void b(int paramInt)
  {
    QQToast.makeText(this.j, paramInt, 1).show(getResources().getDimensionPixelSize(2131299920));
  }
  
  boolean b()
  {
    Object localObject = this.l;
    if ((localObject != null) && (this.n != null) && (((List)localObject).size() == this.n.size()))
    {
      localObject = new ArrayList();
      Iterator localIterator = this.l.iterator();
      while (localIterator.hasNext()) {
        ((List)localObject).add(((ProfileLabelInfo)localIterator.next()).labelId);
      }
      if ((((List)localObject).containsAll(this.n)) && (this.n.containsAll((Collection)localObject))) {
        return false;
      }
    }
    return true;
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    addObserver(this.o);
    this.j = this;
    this.g = getResources().getDisplayMetrics().density;
    this.k = new ProfileLabelPanel.LabelStatusManager();
    getResources();
    a();
    d();
    ReportController.b(this.app, "CliOper", "", "", "card_mall", "0X80066C8", 0, 0, "", "", "", "");
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    this.app.removeObserver(this.o);
    this.k.b();
    this.k = null;
  }
  
  protected boolean isWrapContent()
  {
    return false;
  }
  
  protected boolean onBackEvent()
  {
    if (b())
    {
      DialogUtil.a(this, 230).setMessage(getString(2131917008)).setPositiveButton(2131918207, new ProfileLabelEditorActivity.6(this)).setNegativeButton(2131892140, new ProfileLabelEditorActivity.5(this)).show();
      return true;
    }
    finish();
    return false;
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ProfileLabelEditorActivity
 * JD-Core Version:    0.7.0.1
 */