package com.tencent.mobileqq.apollo.process.data;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.apollo.process.CmGameUtil;
import com.tencent.mobileqq.apollo.utils.ApolloConstant;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;
import com.tencent.widget.ActionSheetAdapter;
import cooperation.qzone.QZoneShareManager;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
import yxt;
import yxu;
import yxv;

public class CmGameCommonShare
  implements DialogInterface.OnDismissListener, AdapterView.OnItemClickListener, ActionSheet.OnButtonClickListener
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private ActionSheet jdField_a_of_type_ComTencentWidgetActionSheet;
  private String jdField_a_of_type_JavaLangString;
  private WeakReference jdField_a_of_type_JavaLangRefWeakReference;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private String jdField_b_of_type_JavaLangString;
  private WeakReference jdField_b_of_type_JavaLangRefWeakReference;
  private String c;
  private String d;
  
  public CmGameCommonShare(Context paramContext, AppInterface paramAppInterface)
  {
    try
    {
      this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference((Activity)paramContext);
      this.jdField_b_of_type_JavaLangRefWeakReference = new WeakReference(paramAppInterface);
      return;
    }
    catch (Throwable paramContext)
    {
      QLog.i("apollo_cmGame_CmGameCommonShare", 1, "[ApolloGameShare], errInfo->" + paramContext.getMessage());
    }
  }
  
  private int a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("apollo_cmGame_CmGameCommonShare", 2, "[parseShareParm],jsonStr:" + paramString);
    }
    if (TextUtils.isEmpty(paramString)) {
      return -1;
    }
    try
    {
      paramString = new JSONObject(paramString);
      this.jdField_b_of_type_JavaLangString = paramString.optString("extendInfo");
      this.c = paramString.optString("summary");
      this.jdField_a_of_type_JavaLangString = paramString.optString("localPicPath");
      this.jdField_b_of_type_Int = paramString.optInt("activityId");
      int i = paramString.optInt("reqCode");
      paramString = CmGameUtil.a(this.jdField_a_of_type_Int);
      if (paramString != null)
      {
        paramString.jdField_b_of_type_Int = this.jdField_b_of_type_Int;
        paramString.c = i;
      }
      return 0;
    }
    catch (Exception paramString)
    {
      QLog.i("apollo_cmGame_CmGameCommonShare", 1, "[showShareDialog], errInfo->" + paramString.getMessage());
    }
    return -3;
  }
  
  private AppInterface a()
  {
    if (this.jdField_b_of_type_JavaLangRefWeakReference == null) {
      return null;
    }
    return (AppInterface)this.jdField_b_of_type_JavaLangRefWeakReference.get();
  }
  
  private String a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    String str;
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      if (!this.jdField_a_of_type_JavaLangString.startsWith("GameSandBox:")) {
        break label84;
      }
      str = this.jdField_a_of_type_JavaLangString.substring("GameSandBox:".length() + "//".length());
      localStringBuilder.append(ApolloConstant.n);
      localStringBuilder.append(this.jdField_a_of_type_Int);
      localStringBuilder.append("/sandbox/");
      localStringBuilder.append(str);
    }
    for (;;)
    {
      return localStringBuilder.toString();
      label84:
      if (this.jdField_a_of_type_JavaLangString.startsWith("GameRes:"))
      {
        str = this.jdField_a_of_type_JavaLangString.substring("GameRes:".length() + "//".length());
        localStringBuilder.append(ApolloConstant.n);
        localStringBuilder.append(this.jdField_a_of_type_Int);
        localStringBuilder.append("/");
        localStringBuilder.append(str);
      }
    }
  }
  
  private String a(int paramInt)
  {
    return ApolloConstant.n + paramInt + "/shareQRCode_default.png";
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    CmGameLauncher localCmGameLauncher = CmGameUtil.a(this.jdField_a_of_type_Int);
    if (localCmGameLauncher != null) {
      localCmGameLauncher.a(paramInt1, paramInt2, 0, "");
    }
  }
  
  private void b()
  {
    Bundle localBundle = new Bundle();
    ArrayList localArrayList = new ArrayList();
    try
    {
      Object localObject = this.jdField_a_of_type_JavaLangString;
      File localFile = new File(a());
      if (localFile.isFile())
      {
        localObject = localFile;
        if (localFile.exists()) {}
      }
      else
      {
        localObject = new File(a(this.jdField_a_of_type_Int));
      }
      localArrayList.add(((File)localObject).getAbsolutePath());
      localBundle.putStringArrayList("images", localArrayList);
      localBundle.putString("summary", this.c);
      localBundle.putInt("req_type", 7);
      localBundle.putBoolean("key_need_save_draft", false);
      localObject = null;
      if (this.jdField_a_of_type_JavaLangRefWeakReference != null) {
        localObject = (Activity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      }
      if (localObject != null)
      {
        QZoneShareManager.a(a(), (Context)localObject, localBundle, this, 255);
        return;
      }
      a(1, 4);
      return;
    }
    catch (Exception localException)
    {
      QLog.d("apollo_cmGame_CmGameCommonShare", 1, "publishToQzone:", localException);
      a(1, 4);
    }
  }
  
  private void b(int paramInt)
  {
    ThreadManager.post(new yxv(this, paramInt), 5, null, true);
  }
  
  public void OnClick(View paramView, int paramInt)
  {
    a();
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentWidgetActionSheet != null) {
      this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
    }
  }
  
  public void a(int paramInt)
  {
    File localFile = new File(a(paramInt));
    if (localFile.exists()) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("apollo_cmGame_CmGameCommonShare", 2, new Object[] { "checkDefaultQRSharePic gameId:", Integer.valueOf(paramInt) });
    }
    ThreadManager.post(new yxt(this, paramInt, localFile), 5, null, true);
  }
  
  public void a(Drawable paramDrawable)
  {
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramDrawable;
    if (QLog.isColorLevel()) {
      QLog.d("apollo_cmGame_CmGameCommonShare", 2, new Object[] { "setGameIcon:", paramDrawable });
    }
  }
  
  public void a(String paramString, int paramInt, boolean paramBoolean)
  {
    ActionSheetAdapter localActionSheetAdapter = null;
    this.d = paramString;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Boolean = paramBoolean;
    paramInt = a(paramString);
    if (paramInt < 0)
    {
      QLog.i("apollo_cmGame_CmGameCommonShare", 1, "[showShareDialog], errInfo->parse err or param err, ret:" + paramInt);
      return;
    }
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(ActionSheetAdapter.a(0));
    localArrayList.add(ActionSheetAdapter.a(1));
    localArrayList.add(ActionSheetAdapter.a(2));
    localArrayList.add(ActionSheetAdapter.a(3));
    if (this.jdField_a_of_type_JavaLangRefWeakReference != null) {}
    for (paramString = (Activity)this.jdField_a_of_type_JavaLangRefWeakReference.get();; paramString = null)
    {
      if (paramString != null)
      {
        localActionSheetAdapter = new ActionSheetAdapter(paramString);
        localActionSheetAdapter.a(localArrayList);
      }
      if ((this.jdField_a_of_type_ComTencentWidgetActionSheet == null) && (paramString != null)) {
        this.jdField_a_of_type_ComTencentWidgetActionSheet = ActionSheetAdapter.a(paramString, localActionSheetAdapter, this, this, this, false);
      }
      if ((this.jdField_a_of_type_ComTencentWidgetActionSheet == null) || (this.jdField_a_of_type_ComTencentWidgetActionSheet.isShowing())) {
        break;
      }
      this.jdField_a_of_type_ComTencentWidgetActionSheet.setOnDismissListener(this);
      this.jdField_a_of_type_ComTencentWidgetActionSheet.show();
      return;
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public boolean a(int paramInt)
  {
    return new File(ApolloConstant.n + paramInt + "/shareQRCode_default.png").exists();
  }
  
  public void onDismiss(DialogInterface paramDialogInterface) {}
  
  public void onItemClick(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    long l = System.currentTimeMillis();
    if (l - this.jdField_a_of_type_Long < 1000L) {}
    do
    {
      return;
      this.jdField_a_of_type_Long = l;
      a();
      if (QLog.isColorLevel()) {
        QLog.d("apollo_cmGame_CmGameCommonShare", 2, new Object[] { "click type:", Long.valueOf(paramLong) });
      }
      if (paramLong == 1L)
      {
        b();
        return;
      }
      if (paramLong == 0L)
      {
        ThreadManager.post(new yxu(this), 5, null, true);
        return;
      }
      if (paramLong == 2L)
      {
        b(0);
        return;
      }
    } while (paramLong != 3L);
    b(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.process.data.CmGameCommonShare
 * JD-Core Version:    0.7.0.1
 */