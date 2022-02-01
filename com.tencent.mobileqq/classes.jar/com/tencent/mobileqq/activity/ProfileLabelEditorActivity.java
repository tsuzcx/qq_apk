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
  public static final int[][] a;
  public float a;
  public Context a;
  public GridView a;
  public LinearLayout a;
  public TextView a;
  public ProfileLabelEditorActivity.MyLabelGridViewAdapter a;
  private CardObserver a;
  public Card a;
  public ProfileLabelPanel.LabelStatusManager a;
  public ProfileLabelPanel a;
  public List<ProfileLabelInfo> a;
  public boolean a;
  public List<ProfileLabelTypeInfo> b = new ArrayList();
  public List<Long> c = new ArrayList();
  
  static
  {
    int[] arrayOfInt = { 2130850920, 2131167268 };
    jdField_a_of_type_Array2dOfInt = new int[][] { { 2130850917, 2131167267 }, arrayOfInt, { 2130850923, 2131167269 } };
  }
  
  public ProfileLabelEditorActivity()
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_ComTencentMobileqqAppCardObserver = new ProfileLabelEditorActivity.1(this);
  }
  
  /* Error */
  private String a(String paramString)
  {
    // Byte code:
    //   0: new 62	java/io/ByteArrayOutputStream
    //   3: dup
    //   4: invokespecial 63	java/io/ByteArrayOutputStream:<init>	()V
    //   7: astore 5
    //   9: aload_0
    //   10: getfield 65	com/tencent/mobileqq/activity/ProfileLabelEditorActivity:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   13: invokevirtual 71	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   16: aload_1
    //   17: invokevirtual 77	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
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
    //   39: invokevirtual 83	java/io/InputStream:read	([BII)I
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
    //   56: invokevirtual 87	java/io/ByteArrayOutputStream:write	([BII)V
    //   59: goto -29 -> 30
    //   62: aload_3
    //   63: astore_1
    //   64: new 89	java/lang/String
    //   67: dup
    //   68: aload 5
    //   70: invokevirtual 93	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   73: ldc 95
    //   75: invokespecial 98	java/lang/String:<init>	([BLjava/lang/String;)V
    //   78: astore 4
    //   80: aload_3
    //   81: ifnull +7 -> 88
    //   84: aload_3
    //   85: invokevirtual 101	java/io/InputStream:close	()V
    //   88: aload 5
    //   90: invokevirtual 102	java/io/ByteArrayOutputStream:close	()V
    //   93: aload 4
    //   95: areturn
    //   96: astore_1
    //   97: ldc 104
    //   99: iconst_1
    //   100: ldc 106
    //   102: aload_1
    //   103: invokestatic 112	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
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
    //   130: ldc 104
    //   132: iconst_1
    //   133: ldc 106
    //   135: aload 4
    //   137: invokestatic 112	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   140: aload_3
    //   141: ifnull +7 -> 148
    //   144: aload_3
    //   145: invokevirtual 101	java/io/InputStream:close	()V
    //   148: aload 5
    //   150: invokevirtual 102	java/io/ByteArrayOutputStream:close	()V
    //   153: aconst_null
    //   154: areturn
    //   155: astore_1
    //   156: ldc 104
    //   158: iconst_1
    //   159: ldc 106
    //   161: aload_1
    //   162: invokestatic 112	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   165: aconst_null
    //   166: areturn
    //   167: aload_1
    //   168: ifnull +7 -> 175
    //   171: aload_1
    //   172: invokevirtual 101	java/io/InputStream:close	()V
    //   175: aload 5
    //   177: invokevirtual 102	java/io/ByteArrayOutputStream:close	()V
    //   180: goto +13 -> 193
    //   183: astore_1
    //   184: ldc 104
    //   186: iconst_1
    //   187: ldc 106
    //   189: aload_1
    //   190: invokestatic 112	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   193: goto +5 -> 198
    //   196: aload_3
    //   197: athrow
    //   198: goto -2 -> 196
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	201	0	this	ProfileLabelEditorActivity
    //   0	201	1	paramString	String
    //   42	14	2	i	int
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
  
  private List<ProfileLabelInfo> a(String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqDataCard = ((FriendsManager)this.app.getManager(QQManagerFactory.FRIENDS_MANAGER)).a(paramString);
    paramString = this.jdField_a_of_type_ComTencentMobileqqDataCard;
    if (paramString != null)
    {
      this.jdField_a_of_type_JavaUtilList = paramString.getLabelList();
      paramString = this.jdField_a_of_type_JavaUtilList;
      if (paramString != null) {
        a(paramString);
      }
    }
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  private void a(String paramString)
  {
    if (paramString != null)
    {
      paramString = new JSONArray(paramString);
      int k = paramString.length();
      int i = 0;
      while (i < k)
      {
        Object localObject = paramString.optJSONObject(i);
        ProfileLabelTypeInfo localProfileLabelTypeInfo = new ProfileLabelTypeInfo();
        localProfileLabelTypeInfo.typeId = ((JSONObject)localObject).optString("id");
        localProfileLabelTypeInfo.typeName = ((JSONObject)localObject).optString("name");
        localProfileLabelTypeInfo.typeInfo = ((JSONObject)localObject).optString("classinfo");
        localObject = ((JSONObject)localObject).optJSONArray("taglist");
        int m = ((JSONArray)localObject).length();
        int j = 0;
        while (j < m)
        {
          JSONObject localJSONObject = ((JSONArray)localObject).getJSONObject(j);
          ProfileLabelInfo localProfileLabelInfo = new ProfileLabelInfo();
          localProfileLabelInfo.labelId = Long.valueOf(localJSONObject.optLong("id"));
          localProfileLabelInfo.labelName = localJSONObject.optString("name");
          localProfileLabelInfo.typeId = localProfileLabelTypeInfo.typeId;
          localProfileLabelTypeInfo.labels.add(localProfileLabelInfo);
          j += 1;
        }
        this.b.add(localProfileLabelTypeInfo);
        i += 1;
      }
    }
  }
  
  private void a(List<ProfileLabelInfo> paramList)
  {
    this.c.clear();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      ProfileLabelInfo localProfileLabelInfo = (ProfileLabelInfo)paramList.next();
      this.c.add(localProfileLabelInfo.labelId);
    }
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
    c(paramList1);
  }
  
  private void b()
  {
    if (a())
    {
      if (this.jdField_a_of_type_Boolean)
      {
        b(2131719452);
        return;
      }
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("saveEdit save labes num = ");
        localStringBuilder.append(this.jdField_a_of_type_JavaUtilList.size());
        QLog.d("ProfileLabelEditorActivity", 2, localStringBuilder.toString());
      }
      this.jdField_a_of_type_Boolean = true;
      ((CardHandler)this.app.getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER)).a(this.jdField_a_of_type_JavaUtilList);
      return;
    }
    finish();
  }
  
  private void b(List<ProfileLabelInfo> paramList)
  {
    Object localObject = this.jdField_a_of_type_JavaUtilList;
    if (localObject != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityProfileLabelEditorActivity$MyLabelGridViewAdapter = new ProfileLabelEditorActivity.MyLabelGridViewAdapter(this, (List)localObject);
      this.jdField_a_of_type_AndroidWidgetGridView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivityProfileLabelEditorActivity$MyLabelGridViewAdapter);
      a(this.jdField_a_of_type_JavaUtilList.size());
    }
    localObject = new File(BaseApplicationImpl.getApplication().getFilesDir(), "labelList");
    if (!((File)localObject).exists())
    {
      d();
      return;
    }
    localObject = new ByteArrayInputStream(FileUtils.fileToBytes((File)localObject));
    try
    {
      ObjectInputStream localObjectInputStream = new ObjectInputStream((InputStream)localObject);
      this.b = ((List)localObjectInputStream.readObject());
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
    if (!b())
    {
      if (QLog.isColorLevel()) {
        QLog.d("ProfileLabelEditorActivity", 2, "get available label list fail ");
      }
      d();
    }
    if (b()) {
      a(paramList, this.b);
    }
  }
  
  private boolean b()
  {
    List localList = this.b;
    return (localList != null) && (localList.size() > 0);
  }
  
  private void c()
  {
    ThreadManager.post(new ProfileLabelEditorActivity.3(this), 8, null, true);
  }
  
  private void c(List<ProfileLabelTypeInfo> paramList)
  {
    this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileLabelPanel = new ProfileLabelPanel(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileLabelPanel$LabelStatusManager, paramList, new ProfileLabelEditorActivity.4(this));
    paramList = new LinearLayout.LayoutParams(-1, (int)(this.jdField_a_of_type_Float * 202.0F));
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileLabelPanel, paramList);
  }
  
  private void d()
  {
    try
    {
      a(a("qvip_default_tags.json"));
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
  
  ProfileLabelInfo a(Long paramLong, List<ProfileLabelInfo> paramList)
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
  
  public void a()
  {
    super.setContentView(2131559580);
    getWindow().setBackgroundDrawable(null);
    super.setTitle(getString(2131719450));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131376809));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131378263));
    this.jdField_a_of_type_AndroidWidgetGridView = ((GridView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131378260));
    setRightButton(2131718368, new ProfileLabelEditorActivity.2(this));
    enableRightHighlight(true);
  }
  
  void a(int paramInt)
  {
    if (paramInt > 7) {
      return;
    }
    TextView localTextView = this.jdField_a_of_type_AndroidWidgetTextView;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(getString(2131719449));
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
      int i = 0;
      while (i < paramList.size())
      {
        if (((ProfileLabelInfo)paramList.get(i)).labelId.equals(paramProfileLabelInfo.labelId))
        {
          paramList.remove(i);
          ReportController.b(this.app, "CliOper", "", "", "card_mall", "0X80066C7", 0, 0, "2", "", "", "");
        }
        i += 1;
      }
    }
  }
  
  boolean a()
  {
    Object localObject = this.jdField_a_of_type_JavaUtilList;
    if ((localObject != null) && (this.c != null) && (((List)localObject).size() == this.c.size()))
    {
      localObject = new ArrayList();
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext()) {
        ((List)localObject).add(((ProfileLabelInfo)localIterator.next()).labelId);
      }
      if ((((List)localObject).containsAll(this.c)) && (this.c.containsAll((Collection)localObject))) {
        return false;
      }
    }
    return true;
  }
  
  boolean a(Long paramLong, List<ProfileLabelInfo> paramList)
  {
    return a(paramLong, paramList) != null;
  }
  
  boolean a(List<ProfileLabelInfo> paramList)
  {
    return paramList.size() >= 7;
  }
  
  void b(int paramInt)
  {
    QQToast.a(this.jdField_a_of_type_AndroidContentContext, paramInt, 1).b(getResources().getDimensionPixelSize(2131299168));
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
    addObserver(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver);
    this.jdField_a_of_type_AndroidContentContext = this;
    this.jdField_a_of_type_Float = getResources().getDisplayMetrics().density;
    this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileLabelPanel$LabelStatusManager = new ProfileLabelPanel.LabelStatusManager();
    getResources();
    a();
    c();
    ReportController.b(this.app, "CliOper", "", "", "card_mall", "0X80066C8", 0, 0, "", "", "", "");
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    this.app.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver);
    this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileLabelPanel$LabelStatusManager.a();
    this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileLabelPanel$LabelStatusManager = null;
  }
  
  protected boolean isWrapContent()
  {
    return false;
  }
  
  protected boolean onBackEvent()
  {
    if (a())
    {
      DialogUtil.a(this, 230).setMessage(getString(2131719448)).setPositiveButton(2131720490, new ProfileLabelEditorActivity.6(this)).setNegativeButton(2131694460, new ProfileLabelEditorActivity.5(this)).show();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ProfileLabelEditorActivity
 * JD-Core Version:    0.7.0.1
 */