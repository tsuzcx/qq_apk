import android.content.Intent;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.PicMessageExtraData;
import com.tencent.mobileqq.transfile.TransferRequest;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.HashSet;
import java.util.Set;

public class azix
  extends aziw
{
  private static final Set<Integer> a;
  protected int a;
  
  static
  {
    jdField_a_of_type_JavaUtilSet = new HashSet();
    jdField_a_of_type_JavaUtilSet.add(Integer.valueOf(1042));
    jdField_a_of_type_JavaUtilSet.add(Integer.valueOf(5));
    jdField_a_of_type_JavaUtilSet.add(Integer.valueOf(1030));
    jdField_a_of_type_JavaUtilSet.add(Integer.valueOf(1047));
    jdField_a_of_type_JavaUtilSet.add(Integer.valueOf(1054));
    jdField_a_of_type_JavaUtilSet.add(Integer.valueOf(1044));
    jdField_a_of_type_JavaUtilSet.add(Integer.valueOf(1049));
  }
  
  public azix(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public azix(QQAppInterface paramQQAppInterface, int paramInt)
  {
    super(paramQQAppInterface);
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public static aziy a(MessageRecord paramMessageRecord, TransferRequest paramTransferRequest)
  {
    if (jdField_a_of_type_JavaUtilSet.contains(Integer.valueOf(paramTransferRequest.mBusiType))) {
      try
      {
        long l = Long.valueOf(paramMessageRecord.getExtInfoFromExtStr("quick_send_original_size")).longValue();
        paramTransferRequest = paramMessageRecord.getExtInfoFromExtStr("quick_send_original_md5");
        if ((l > 0L) && (!paramTransferRequest.equals("")))
        {
          aziy localaziy = new aziy();
          localaziy.jdField_a_of_type_JavaLangString = paramTransferRequest;
          localaziy.jdField_a_of_type_Long = l;
          localaziy.b = paramMessageRecord.getExtInfoFromExtStr("quick_send_thumb_md5");
          return localaziy;
        }
      }
      catch (Exception paramMessageRecord)
      {
        paramMessageRecord.printStackTrace();
      }
    }
    return null;
  }
  
  public static void a(MessageRecord paramMessageRecord, aziy paramaziy)
  {
    if ((paramaziy != null) && (paramMessageRecord != null))
    {
      paramMessageRecord.saveExtInfoToExtStr("quick_send_original_md5", paramaziy.jdField_a_of_type_JavaLangString);
      paramMessageRecord.saveExtInfoToExtStr("quick_send_original_size", String.valueOf(paramaziy.jdField_a_of_type_Long));
      paramMessageRecord.saveExtInfoToExtStr("quick_send_thumb_md5", paramaziy.b);
    }
  }
  
  public azkn a(Intent paramIntent)
  {
    azkn localazkn = super.a(paramIntent);
    if ((paramIntent != null) && (localazkn != null))
    {
      aziy localaziy = new aziy();
      localaziy.jdField_a_of_type_JavaLangString = paramIntent.getStringExtra("quick_send_original_md5");
      localaziy.jdField_a_of_type_Long = paramIntent.getLongExtra("quick_send_original_size", 0L);
      localaziy.b = paramIntent.getStringExtra("quick_send_thumb_md5");
      localazkn.jdField_a_of_type_Aziy = localaziy;
      localazkn.r = paramIntent.getIntExtra("key_emotion_source_from", 0);
      localazkn.k = paramIntent.getStringExtra("key_emotion_source_info");
      localazkn.l = paramIntent.getStringExtra("key_emotion_source_weburl");
      localazkn.m = paramIntent.getStringExtra("key_emotion_source_iconurl");
      localazkn.n = paramIntent.getStringExtra("key_emotion_source_packagename");
      localazkn.s = paramIntent.getIntExtra("key_emotion_source_epid", 0);
      if (localazkn.jdField_a_of_type_Azkm == null) {
        localazkn.jdField_a_of_type_Azkm = new azkm();
      }
      localazkn.jdField_a_of_type_Azkm.a = paramIntent.getBooleanExtra("quick_send_is_ad_emo", false);
      localazkn.jdField_a_of_type_Azkm.c = paramIntent.getStringExtra("quick_send_ad_emo_jump_url");
      localazkn.jdField_a_of_type_Azkm.d = paramIntent.getStringExtra("quick_send_ad_emo_desc_str");
      localazkn.jdField_a_of_type_Azkm.b = paramIntent.getBooleanExtra("quick_send_is_emo_search", false);
    }
    return localazkn;
  }
  
  protected void a(MessageForPic paramMessageForPic)
  {
    if (paramMessageForPic.imageType == 2000) {
      return;
    }
    super.a(paramMessageForPic);
  }
  
  protected void a(MessageForPic paramMessageForPic, azkn paramazkn)
  {
    super.a(paramMessageForPic, paramazkn);
    a(paramMessageForPic, paramazkn.jdField_a_of_type_Aziy);
    PicMessageExtraData localPicMessageExtraData = paramMessageForPic.picExtraData;
    if (localPicMessageExtraData == null) {
      localPicMessageExtraData = new PicMessageExtraData();
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Int == 1042) {
        if (paramazkn.d())
        {
          localPicMessageExtraData.imageBizType = 13;
          localPicMessageExtraData.textSummary = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131691250);
          paramMessageForPic.picExtraData = localPicMessageExtraData;
        }
      }
      label306:
      label312:
      do
      {
        do
        {
          return;
          localPicMessageExtraData.imageBizType = 2;
          break;
          if (this.jdField_a_of_type_Int == 1047)
          {
            if (paramazkn.c())
            {
              localPicMessageExtraData.imageBizType = 9;
              localPicMessageExtraData.setAdEmoJumpUrl(paramazkn.jdField_a_of_type_Azkm.c);
              localPicMessageExtraData.setAdEmoDescStr(paramazkn.jdField_a_of_type_Azkm.d);
            }
            for (;;)
            {
              paramazkn = aiin.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
              if (paramazkn != null)
              {
                paramazkn = paramazkn.a();
                if (!TextUtils.isEmpty(paramazkn)) {
                  localPicMessageExtraData.textSummary = ("[" + paramazkn + "]");
                }
              }
              paramMessageForPic.picExtraData = localPicMessageExtraData;
              return;
              localPicMessageExtraData.imageBizType = 7;
            }
          }
          if (this.jdField_a_of_type_Int == 1044)
          {
            localPicMessageExtraData.imageBizType = 3;
            localPicMessageExtraData.textSummary = BaseApplicationImpl.getApplication().getString(2131691250);
            paramMessageForPic.picExtraData = localPicMessageExtraData;
            return;
          }
          if (this.jdField_a_of_type_Int != 1049) {
            break label312;
          }
          localPicMessageExtraData.imageBizType = 4;
          paramazkn = BaseApplicationImpl.getApplication().getRuntime();
          if (!(paramazkn instanceof AppInterface)) {
            break label306;
          }
          paramazkn = aioi.a((AppInterface)paramazkn).b();
        } while (TextUtils.isEmpty(paramazkn));
        localPicMessageExtraData.textSummary = ("[" + paramazkn + "]");
        paramMessageForPic.picExtraData = localPicMessageExtraData;
        return;
      } while (this.jdField_a_of_type_Int != 1054);
      localPicMessageExtraData.imageBizType = 10;
      localPicMessageExtraData.textSummary = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131691250);
      paramMessageForPic.picExtraData = localPicMessageExtraData;
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azix
 * JD-Core Version:    0.7.0.1
 */