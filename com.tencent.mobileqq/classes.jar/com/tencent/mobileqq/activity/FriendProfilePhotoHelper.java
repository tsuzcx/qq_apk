package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Handler.Callback;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.photo.PhotoUtils;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.CardHandler.CardTransProcessorHandler;
import com.tencent.mobileqq.app.CardHandler.CoverTransCallback;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.profile.CustomCoverFragment;
import com.tencent.mobileqq.profile.ProfileCardManager;
import com.tencent.mobileqq.troop.utils.HummerParser;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.WeakReferenceHandler;
import java.nio.ByteBuffer;
import java.util.ArrayList;

public class FriendProfilePhotoHelper
  implements CardHandler.CoverTransCallback
{
  public static final String a = "FriendProfilePhotoHelper";
  public int a;
  public Uri a;
  Handler.Callback a;
  public FriendProfilePhotoHelper.ProfilePhotoCallback a;
  public CardHandler.CardTransProcessorHandler a;
  public final QBaseActivity a;
  public QQAppInterface a;
  public QQProgressDialog a;
  public WeakReferenceHandler a;
  public Runnable a;
  public boolean a;
  public byte[] a;
  public String b;
  
  public FriendProfilePhotoHelper(QBaseActivity paramQBaseActivity, FriendProfilePhotoHelper.ProfilePhotoCallback paramProfilePhotoCallback)
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_ArrayOfByte = null;
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_JavaLangRunnable = new FriendProfilePhotoHelper.2(this);
    this.jdField_a_of_type_AndroidOsHandler$Callback = new FriendProfilePhotoHelper.3(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity = paramQBaseActivity;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)paramQBaseActivity.getAppRuntime());
    this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfilePhotoHelper$ProfilePhotoCallback = paramProfilePhotoCallback;
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler = new WeakReferenceHandler(Looper.getMainLooper(), this.jdField_a_of_type_AndroidOsHandler$Callback);
    paramQBaseActivity = (CardHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER);
    if (paramQBaseActivity != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppCardHandler$CardTransProcessorHandler = paramQBaseActivity.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this);
    }
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppCardHandler$CardTransProcessorHandler != null)
    {
      ((CardHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER)).a(this.jdField_a_of_type_ComTencentMobileqqAppCardHandler$CardTransProcessorHandler);
      this.jdField_a_of_type_ComTencentMobileqqAppCardHandler$CardTransProcessorHandler = null;
    }
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_ArrayOfByte = null;
    this.b = "";
    this.jdField_a_of_type_Int = 0;
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, String.format("onSendFailed resultCode=%s", new Object[] { Integer.valueOf(paramInt) }));
    }
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    c();
    int i = 2131720147;
    if (paramInt == 1503) {
      i = 2131699165;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfilePhotoHelper$ProfilePhotoCallback.notifyUser(i, 1);
  }
  
  public void a(int paramInt, Intent paramIntent)
  {
    if (!NetworkUtil.isNetSupport(BaseApplication.getContext()))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfilePhotoHelper$ProfilePhotoCallback.notifyUser(2131694475, 1);
      return;
    }
    if (paramIntent == null) {
      return;
    }
    int i = paramIntent.getIntExtra("req_code_key", 0);
    if (i == 1025)
    {
      ArrayList localArrayList = paramIntent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS");
      if ((localArrayList != null) && (localArrayList.size() > 0))
      {
        CardHandler localCardHandler = (CardHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER);
        if (paramIntent.getBooleanExtra("action_cover_pick_gallery", false))
        {
          localCardHandler.a((String)localArrayList.get(0));
          b();
          this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 30000L);
          return;
        }
        localCardHandler.a(localArrayList);
        b();
      }
    }
    else if (i == 1020)
    {
      if ((paramInt == -1) && (paramIntent != null))
      {
        paramIntent = paramIntent.getStringExtra("key_cover_selected_img_path");
        if (!TextUtils.isEmpty(paramIntent)) {
          a(paramIntent);
        }
      }
    }
    else if (i == 1021)
    {
      if (paramInt == -1)
      {
        this.jdField_a_of_type_AndroidNetUri = ((Uri)paramIntent.getParcelableExtra("upload_uri_key"));
        a(ImageUtil.b(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, this.jdField_a_of_type_AndroidNetUri));
      }
    }
    else if ((i == 2002) && (paramInt == -1))
    {
      paramIntent = ProfileCardManager.a(paramIntent.getStringExtra("card_url_key"));
      this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfilePhotoHelper$ProfilePhotoCallback.updateCover(paramIntent);
    }
  }
  
  public void a(Intent paramIntent, ArrayList<String> paramArrayList)
  {
    if (paramIntent.getBooleanExtra("action_cover_pick_gallery", false))
    {
      b(paramArrayList);
      return;
    }
    a(paramArrayList);
  }
  
  public void a(Card paramCard)
  {
    if (paramCard != null)
    {
      paramCard = paramCard.getCoverData(this.jdField_a_of_type_Int);
      String str = (String)paramCard[0];
      if ((!TextUtils.isEmpty(str)) && (!str.equals(this.b)))
      {
        this.b = str;
        this.jdField_a_of_type_Int = ((Integer)paramCard[1]).intValue();
      }
    }
  }
  
  protected void a(String paramString)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("Business_Origin", 101);
    localIntent.putExtra("action_cover_pick_gallery", true);
    localIntent.putExtra("PhotoConst.32_Bit_Config", true);
    QBaseActivity localQBaseActivity = this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity;
    PhotoUtils.startPhotoEdit(localIntent, localQBaseActivity, localQBaseActivity.getClass().getName(), ProfileCardUtil.c(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity), ProfileCardUtil.d(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity), ProfileCardUtil.c(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity), ProfileCardUtil.d(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity), paramString, ProfileCardUtil.a());
  }
  
  public void a(ArrayList<String> paramArrayList)
  {
    if (!NetworkUtil.isNetSupport(BaseApplication.getContext()))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfilePhotoHelper$ProfilePhotoCallback.notifyUser(2131694475, 1);
      return;
    }
    ((CardHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER)).a(paramArrayList);
    b();
  }
  
  public void a(boolean paramBoolean)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("is_default_key", paramBoolean);
    PublicFragmentActivity.Launcher.a(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, localIntent, PublicFragmentActivity.class, CustomCoverFragment.class, 1024);
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    this.jdField_a_of_type_ArrayOfByte = paramArrayOfByte;
    this.jdField_a_of_type_Boolean = true;
    ThreadManager.excute(new FriendProfilePhotoHelper.1(this), 16, null, false);
  }
  
  protected void b()
  {
    try
    {
      if (!this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.isFinishing())
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getTitleBarHeight());
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.setCancelable(false);
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.c(2131690840);
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
        return;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void b(ArrayList<String> paramArrayList)
  {
    if (!NetworkUtil.isNetSupport(BaseApplication.getContext()))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfilePhotoHelper$ProfilePhotoCallback.notifyUser(2131694475, 1);
      return;
    }
    ((CardHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER)).a((String)paramArrayList.get(0));
    b();
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 30000L);
  }
  
  public void b(byte[] paramArrayOfByte)
  {
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    c();
    this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfilePhotoHelper$ProfilePhotoCallback.notifyUser(2131720146, 2);
    if (paramArrayOfByte != null)
    {
      Object localObject3 = ByteBuffer.wrap(paramArrayOfByte);
      int j = ((ByteBuffer)localObject3).get();
      if (j != 0)
      {
        if (QLog.isColorLevel())
        {
          paramArrayOfByte = jdField_a_of_type_JavaLangString;
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("error retCode:");
          ((StringBuilder)localObject1).append(j);
          QLog.d(paramArrayOfByte, 2, ((StringBuilder)localObject1).toString());
        }
        return;
      }
      Object localObject1 = new byte[4];
      Object localObject2 = new byte[4];
      int k = 0;
      j = 0;
      while (j < 4)
      {
        int i = ((ByteBuffer)localObject3).get();
        localObject1[j] = i;
        localObject2[(3 - j)] = i;
        j += 1;
      }
      int m = (int)HummerParser.a((byte[])localObject1);
      if (m <= paramArrayOfByte.length - 5)
      {
        j = m;
        if (m >= 0) {}
      }
      else
      {
        j = (int)HummerParser.a((byte[])localObject2);
      }
      if (QLog.isColorLevel())
      {
        localObject3 = jdField_a_of_type_JavaLangString;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("len:");
        localStringBuilder.append(j);
        localStringBuilder.append(" bLength:");
        localStringBuilder.append(HexUtil.bytes2HexStr((byte[])localObject1));
        localStringBuilder.append(" bFlipLength:");
        localStringBuilder.append(HexUtil.bytes2HexStr((byte[])localObject2));
        QLog.d((String)localObject3, 2, localStringBuilder.toString());
      }
      if ((j <= paramArrayOfByte.length - 5) && (j >= 0))
      {
        localObject1 = new byte[j];
        while (k < j)
        {
          localObject1[k] = paramArrayOfByte[(k + 5)];
          k += 1;
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfilePhotoHelper$ProfilePhotoCallback.onUploadResult((byte[])localObject1);
        return;
      }
      if (QLog.isColorLevel())
      {
        localObject1 = jdField_a_of_type_JavaLangString;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("长度超出! len:");
        ((StringBuilder)localObject2).append(j);
        ((StringBuilder)localObject2).append(" extraInfo.length:");
        ((StringBuilder)localObject2).append(paramArrayOfByte.length);
        QLog.d((String)localObject1, 2, ((StringBuilder)localObject2).toString());
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "send finish extraInfo is null");
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfilePhotoHelper$ProfilePhotoCallback.onUploadResult(null);
  }
  
  protected void c()
  {
    QQProgressDialog localQQProgressDialog = this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
    if ((localQQProgressDialog != null) && (localQQProgressDialog.isShowing())) {
      try
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.FriendProfilePhotoHelper
 * JD-Core Version:    0.7.0.1
 */