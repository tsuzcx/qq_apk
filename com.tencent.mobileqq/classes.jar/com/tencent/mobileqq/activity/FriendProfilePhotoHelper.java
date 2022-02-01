package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Handler.Callback;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.photo.PhotoUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.CardHandler.CardTransProcessorHandler;
import com.tencent.mobileqq.app.CardHandler.CoverTransCallback;
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
  public static final String a;
  public int a;
  public Uri a;
  Handler.Callback a;
  public FriendProfilePhotoHelper.ProfilePhotoCallback a;
  public final BaseActivity a;
  public CardHandler.CardTransProcessorHandler a;
  public QQAppInterface a;
  public QQProgressDialog a;
  public WeakReferenceHandler a;
  public Runnable a;
  public boolean a;
  public byte[] a;
  public String b;
  
  static
  {
    jdField_a_of_type_JavaLangString = FriendProfilePhotoHelper.class.getSimpleName();
  }
  
  public FriendProfilePhotoHelper(BaseActivity paramBaseActivity, FriendProfilePhotoHelper.ProfilePhotoCallback paramProfilePhotoCallback)
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_ArrayOfByte = null;
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_JavaLangRunnable = new FriendProfilePhotoHelper.2(this);
    this.jdField_a_of_type_AndroidOsHandler$Callback = new FriendProfilePhotoHelper.3(this);
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = paramBaseActivity;
    this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfilePhotoHelper$ProfilePhotoCallback = paramProfilePhotoCallback;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app;
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler = new WeakReferenceHandler(Looper.getMainLooper(), this.jdField_a_of_type_AndroidOsHandler$Callback);
    paramBaseActivity = (CardHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER);
    if (paramBaseActivity != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppCardHandler$CardTransProcessorHandler = paramBaseActivity.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this);
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
    int i = 2131720408;
    if (paramInt == 1503) {
      i = 2131699060;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfilePhotoHelper$ProfilePhotoCallback.notifyUser(i, 1);
  }
  
  public void a(int paramInt, Intent paramIntent)
  {
    if (!NetworkUtil.d(BaseApplication.getContext())) {
      this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfilePhotoHelper$ProfilePhotoCallback.notifyUser(2131694510, 1);
    }
    label21:
    int i;
    do
    {
      do
      {
        do
        {
          do
          {
            ArrayList localArrayList;
            do
            {
              break label21;
              break label21;
              break label21;
              do
              {
                return;
              } while (paramIntent == null);
              i = paramIntent.getIntExtra("req_code_key", 0);
              if (i != 1025) {
                break;
              }
              localArrayList = paramIntent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS");
            } while ((localArrayList == null) || (localArrayList.size() <= 0));
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
            return;
            if (i != 1020) {
              break;
            }
          } while ((paramInt != -1) || (paramIntent == null));
          paramIntent = paramIntent.getStringExtra("key_cover_selected_img_path");
        } while (TextUtils.isEmpty(paramIntent));
        a(paramIntent);
        return;
        if (i != 1021) {
          break;
        }
      } while (paramInt != -1);
      this.jdField_a_of_type_AndroidNetUri = ((Uri)paramIntent.getParcelableExtra("upload_uri_key"));
      a(ImageUtil.b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_AndroidNetUri));
      return;
    } while ((i != 2002) || (paramInt != -1));
    paramIntent = ProfileCardManager.a(paramIntent.getStringExtra("card_url_key"));
    this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfilePhotoHelper$ProfilePhotoCallback.updateCover(paramIntent);
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
    PhotoUtils.startPhotoEdit(localIntent, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getClass().getName(), ProfileCardUtil.c(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity), ProfileCardUtil.d(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity), ProfileCardUtil.c(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity), ProfileCardUtil.d(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity), paramString, ProfileCardUtil.a());
  }
  
  public void a(ArrayList<String> paramArrayList)
  {
    if (!NetworkUtil.d(BaseApplication.getContext()))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfilePhotoHelper$ProfilePhotoCallback.notifyUser(2131694510, 1);
      return;
    }
    ((CardHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER)).a(paramArrayList);
    b();
  }
  
  public void a(boolean paramBoolean)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("is_default_key", paramBoolean);
    PublicFragmentActivity.Launcher.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, localIntent, PublicFragmentActivity.class, CustomCoverFragment.class, 1024);
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
      if (!this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.isFinishing())
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getTitleBarHeight());
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.setCancelable(false);
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.c(2131690911);
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void b(ArrayList<String> paramArrayList)
  {
    if (!NetworkUtil.d(BaseApplication.getContext()))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfilePhotoHelper$ProfilePhotoCallback.notifyUser(2131694510, 1);
      return;
    }
    ((CardHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER)).a((String)paramArrayList.get(0));
    b();
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 30000L);
  }
  
  public void b(byte[] paramArrayOfByte)
  {
    int k = 0;
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    c();
    this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfilePhotoHelper$ProfilePhotoCallback.notifyUser(2131720407, 2);
    if (paramArrayOfByte != null)
    {
      Object localObject = ByteBuffer.wrap(paramArrayOfByte);
      int j = ((ByteBuffer)localObject).get();
      if (j != 0) {
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "error retCode:" + j);
        }
      }
      do
      {
        return;
        byte[] arrayOfByte1 = new byte[4];
        byte[] arrayOfByte2 = new byte[4];
        j = 0;
        while (j < 4)
        {
          int i = ((ByteBuffer)localObject).get();
          arrayOfByte1[j] = i;
          arrayOfByte2[(3 - j)] = i;
          j += 1;
        }
        int m = (int)HummerParser.a(arrayOfByte1);
        if (m <= paramArrayOfByte.length - 5)
        {
          j = m;
          if (m >= 0) {}
        }
        else
        {
          j = (int)HummerParser.a(arrayOfByte2);
        }
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "len:" + j + " bLength:" + HexUtil.bytes2HexStr(arrayOfByte1) + " bFlipLength:" + HexUtil.bytes2HexStr(arrayOfByte2));
        }
        if ((j <= paramArrayOfByte.length - 5) && (j >= 0)) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d(jdField_a_of_type_JavaLangString, 2, "长度超出! len:" + j + " extraInfo.length:" + paramArrayOfByte.length);
      return;
      localObject = new byte[j];
      while (k < j)
      {
        localObject[k] = paramArrayOfByte[(k + 5)];
        k += 1;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfilePhotoHelper$ProfilePhotoCallback.onUploadResult((byte[])localObject);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "send finish extraInfo is null");
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfilePhotoHelper$ProfilePhotoCallback.onUploadResult(null);
  }
  
  protected void c()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {}
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = null;
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.FriendProfilePhotoHelper
 * JD-Core Version:    0.7.0.1
 */