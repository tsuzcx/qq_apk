package com.tencent.mobileqq.activity;

import Override;
import aeuq;
import aeur;
import aeus;
import aeut;
import aeuu;
import aeuw;
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
import anip;
import aniz;
import anmw;
import azjr;
import bcst;
import bglp;
import bgmg;
import bgpa;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.profile.ProfileLabelInfo;
import com.tencent.mobileqq.profile.ProfileLabelTypeInfo;
import com.tencent.mobileqq.profile.view.ProfileLabelPanel;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.List<Lcom.tencent.mobileqq.profile.ProfileLabelInfo;>;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ProfileLabelEditorActivity
  extends IphoneTitleBarActivity
{
  public float a;
  public aeuw a;
  public Context a;
  public GridView a;
  public LinearLayout a;
  public TextView a;
  private aniz a;
  public azjr a;
  public Card a;
  public ProfileLabelPanel a;
  public List<ProfileLabelInfo> a;
  public boolean a;
  public List<ProfileLabelTypeInfo> b = new ArrayList();
  public List<Long> c = new ArrayList();
  
  public ProfileLabelEditorActivity()
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_Aniz = new aeuq(this);
  }
  
  /* Error */
  private String a(String paramString)
  {
    // Byte code:
    //   0: new 50	java/io/ByteArrayOutputStream
    //   3: dup
    //   4: invokespecial 51	java/io/ByteArrayOutputStream:<init>	()V
    //   7: astore 5
    //   9: aload_0
    //   10: getfield 53	com/tencent/mobileqq/activity/ProfileLabelEditorActivity:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   13: invokevirtual 59	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   16: aload_1
    //   17: invokevirtual 65	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
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
    //   39: invokevirtual 71	java/io/InputStream:read	([BII)I
    //   42: istore_2
    //   43: iload_2
    //   44: iconst_m1
    //   45: if_icmpeq +46 -> 91
    //   48: aload_3
    //   49: astore_1
    //   50: aload 5
    //   52: aload 4
    //   54: iconst_0
    //   55: iload_2
    //   56: invokevirtual 75	java/io/ByteArrayOutputStream:write	([BII)V
    //   59: goto -29 -> 30
    //   62: astore 4
    //   64: aload_3
    //   65: astore_1
    //   66: ldc 77
    //   68: iconst_1
    //   69: ldc 79
    //   71: aload 4
    //   73: invokestatic 85	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   76: aload_3
    //   77: ifnull +7 -> 84
    //   80: aload_3
    //   81: invokevirtual 88	java/io/InputStream:close	()V
    //   84: aload 5
    //   86: invokevirtual 89	java/io/ByteArrayOutputStream:close	()V
    //   89: aconst_null
    //   90: areturn
    //   91: aload_3
    //   92: astore_1
    //   93: new 91	java/lang/String
    //   96: dup
    //   97: aload 5
    //   99: invokevirtual 95	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   102: ldc 97
    //   104: invokespecial 100	java/lang/String:<init>	([BLjava/lang/String;)V
    //   107: astore 4
    //   109: aload_3
    //   110: ifnull +7 -> 117
    //   113: aload_3
    //   114: invokevirtual 88	java/io/InputStream:close	()V
    //   117: aload 5
    //   119: invokevirtual 89	java/io/ByteArrayOutputStream:close	()V
    //   122: aload 4
    //   124: areturn
    //   125: astore_1
    //   126: ldc 77
    //   128: iconst_1
    //   129: ldc 79
    //   131: aload_1
    //   132: invokestatic 85	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   135: aload 4
    //   137: areturn
    //   138: astore_1
    //   139: ldc 77
    //   141: iconst_1
    //   142: ldc 79
    //   144: aload_1
    //   145: invokestatic 85	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   148: goto -59 -> 89
    //   151: astore_3
    //   152: aconst_null
    //   153: astore_1
    //   154: aload_1
    //   155: ifnull +7 -> 162
    //   158: aload_1
    //   159: invokevirtual 88	java/io/InputStream:close	()V
    //   162: aload 5
    //   164: invokevirtual 89	java/io/ByteArrayOutputStream:close	()V
    //   167: aload_3
    //   168: athrow
    //   169: astore_1
    //   170: ldc 77
    //   172: iconst_1
    //   173: ldc 79
    //   175: aload_1
    //   176: invokestatic 85	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   179: goto -12 -> 167
    //   182: astore_3
    //   183: goto -29 -> 154
    //   186: astore 4
    //   188: aconst_null
    //   189: astore_3
    //   190: goto -126 -> 64
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	193	0	this	ProfileLabelEditorActivity
    //   0	193	1	paramString	String
    //   42	14	2	i	int
    //   20	94	3	localInputStream	InputStream
    //   151	17	3	localObject1	Object
    //   182	1	3	localObject2	Object
    //   189	1	3	localObject3	Object
    //   28	25	4	arrayOfByte	byte[]
    //   62	10	4	localIOException1	IOException
    //   107	29	4	str	String
    //   186	1	4	localIOException2	IOException
    //   7	156	5	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    // Exception table:
    //   from	to	target	type
    //   23	30	62	java/io/IOException
    //   32	43	62	java/io/IOException
    //   50	59	62	java/io/IOException
    //   93	109	62	java/io/IOException
    //   113	117	125	java/lang/Exception
    //   117	122	125	java/lang/Exception
    //   80	84	138	java/lang/Exception
    //   84	89	138	java/lang/Exception
    //   9	21	151	finally
    //   158	162	169	java/lang/Exception
    //   162	167	169	java/lang/Exception
    //   23	30	182	finally
    //   32	43	182	finally
    //   50	59	182	finally
    //   66	76	182	finally
    //   93	109	182	finally
    //   9	21	186	java/io/IOException
  }
  
  private List<ProfileLabelInfo> a(String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqDataCard = ((anmw)this.app.getManager(51)).b(paramString);
    if (this.jdField_a_of_type_ComTencentMobileqqDataCard != null)
    {
      this.jdField_a_of_type_JavaUtilList = this.jdField_a_of_type_ComTencentMobileqqDataCard.getLabelList();
      if (this.jdField_a_of_type_JavaUtilList != null) {
        a(this.jdField_a_of_type_JavaUtilList);
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
        b(2131718396);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ProfileLabelEditorActivity", 2, "saveEdit save labes num = " + this.jdField_a_of_type_JavaUtilList.size());
      }
      this.jdField_a_of_type_Boolean = true;
      ((anip)this.app.a(2)).a(this.jdField_a_of_type_JavaUtilList);
      return;
    }
    finish();
  }
  
  private void b(List<ProfileLabelInfo> paramList)
  {
    if (this.jdField_a_of_type_JavaUtilList != null)
    {
      this.jdField_a_of_type_Aeuw = new aeuw(this, this.jdField_a_of_type_JavaUtilList);
      this.jdField_a_of_type_AndroidWidgetGridView.setAdapter(this.jdField_a_of_type_Aeuw);
      a(this.jdField_a_of_type_JavaUtilList.size());
    }
    Object localObject = new File(BaseApplicationImpl.getApplication().getFilesDir(), "labelList");
    if ((localObject == null) || (!((File)localObject).exists())) {
      d();
    }
    for (;;)
    {
      return;
      localObject = new ByteArrayInputStream(bgmg.a((File)localObject));
      try
      {
        ObjectInputStream localObjectInputStream = new ObjectInputStream((InputStream)localObject);
        this.b = ((List)localObjectInputStream.readObject());
        localObjectInputStream.close();
        ((ByteArrayInputStream)localObject).close();
        if (!b())
        {
          if (QLog.isColorLevel()) {
            QLog.d("ProfileLabelEditorActivity", 2, "get available label list fail ");
          }
          d();
        }
        if (!b()) {
          continue;
        }
        a(paramList, this.b);
        return;
      }
      catch (IOException localIOException)
      {
        for (;;)
        {
          localIOException.printStackTrace();
        }
      }
      catch (ClassNotFoundException localClassNotFoundException)
      {
        for (;;)
        {
          localClassNotFoundException.printStackTrace();
        }
      }
    }
  }
  
  private boolean b()
  {
    return (this.b != null) && (this.b.size() > 0);
  }
  
  private void c()
  {
    ThreadManager.post(new ProfileLabelEditorActivity.3(this), 8, null, true);
  }
  
  private void c(List<ProfileLabelTypeInfo> paramList)
  {
    this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileLabelPanel = new ProfileLabelPanel(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Azjr, paramList, new aeus(this));
    paramList = new LinearLayout.LayoutParams(-1, (int)(202.0F * this.jdField_a_of_type_Float));
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileLabelPanel, paramList);
  }
  
  private void d()
  {
    try
    {
      a(a("qvip_default_tags.json"));
      return;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public ProfileLabelInfo a(Long paramLong, List<ProfileLabelInfo> paramList)
  {
    Object localObject1 = null;
    Object localObject2 = null;
    if (paramList != null)
    {
      Iterator localIterator = paramList.iterator();
      paramList = localObject2;
      localObject1 = paramList;
      if (localIterator.hasNext())
      {
        localObject1 = (ProfileLabelInfo)localIterator.next();
        if (!((ProfileLabelInfo)localObject1).labelId.equals(paramLong)) {
          break label61;
        }
        paramList = (List<ProfileLabelInfo>)localObject1;
      }
    }
    label61:
    for (;;)
    {
      break;
      return localObject1;
    }
  }
  
  public void a()
  {
    super.setContentView(2131559586);
    getWindow().setBackgroundDrawable(null);
    super.setTitle(getString(2131718394));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131376788));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131378231));
    this.jdField_a_of_type_AndroidWidgetGridView = ((GridView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131378228));
    setRightButton(2131717397, new aeur(this));
    enableRightHighlight(true);
  }
  
  public void a(int paramInt)
  {
    if (paramInt > 7) {
      return;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setText(getString(2131718393) + " (" + paramInt + "/" + 7 + ")");
  }
  
  public void a(ProfileLabelInfo paramProfileLabelInfo, List<ProfileLabelInfo> paramList)
  {
    if (paramList != null)
    {
      int i = 0;
      while (i < paramList.size())
      {
        if (((ProfileLabelInfo)paramList.get(i)).labelId.equals(paramProfileLabelInfo.labelId))
        {
          paramList.remove(i);
          bcst.b(this.app, "CliOper", "", "", "card_mall", "0X80066C7", 0, 0, "2", "", "", "");
        }
        i += 1;
      }
    }
  }
  
  boolean a()
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (this.c != null) && (this.jdField_a_of_type_JavaUtilList.size() == this.c.size()))
    {
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext()) {
        localArrayList.add(((ProfileLabelInfo)localIterator.next()).labelId);
      }
      if ((localArrayList.containsAll(this.c)) && (this.c.containsAll(localArrayList))) {
        return false;
      }
    }
    return true;
  }
  
  public boolean a(Long paramLong, List<ProfileLabelInfo> paramList)
  {
    return a(paramLong, paramList) != null;
  }
  
  public boolean a(List<ProfileLabelInfo> paramList)
  {
    return paramList.size() >= 7;
  }
  
  public void b(int paramInt)
  {
    QQToast.a(this.jdField_a_of_type_AndroidContentContext, paramInt, 1).b(getResources().getDimensionPixelSize(2131298998));
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool);
    return bool;
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    addObserver(this.jdField_a_of_type_Aniz);
    this.jdField_a_of_type_AndroidContentContext = this;
    this.jdField_a_of_type_Float = getResources().getDisplayMetrics().density;
    this.jdField_a_of_type_Azjr = new azjr();
    getResources();
    a();
    c();
    bcst.b(this.app, "CliOper", "", "", "card_mall", "0X80066C8", 0, 0, "", "", "", "");
    return true;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    this.app.removeObserver(this.jdField_a_of_type_Aniz);
    this.jdField_a_of_type_Azjr.a();
    this.jdField_a_of_type_Azjr = null;
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  public boolean onBackEvent()
  {
    if (a())
    {
      bglp.a(this, 230).setMessage(getString(2131718392)).setPositiveButton(2131719210, new aeuu(this)).setNegativeButton(2131693977, new aeut(this)).show();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ProfileLabelEditorActivity
 * JD-Core Version:    0.7.0.1
 */