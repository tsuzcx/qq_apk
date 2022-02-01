import android.content.Intent;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.PicMessageExtraData;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.HashSet;
import java.util.Set;

public class azpd
  extends azpc
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
  
  public azpd(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public azpd(QQAppInterface paramQQAppInterface, int paramInt)
  {
    super(paramQQAppInterface);
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public static azpe a(MessageRecord paramMessageRecord, beyg parambeyg)
  {
    if (jdField_a_of_type_JavaUtilSet.contains(Integer.valueOf(parambeyg.e))) {
      try
      {
        long l = Long.valueOf(paramMessageRecord.getExtInfoFromExtStr("quick_send_original_size")).longValue();
        parambeyg = paramMessageRecord.getExtInfoFromExtStr("quick_send_original_md5");
        if ((l > 0L) && (!parambeyg.equals("")))
        {
          azpe localazpe = new azpe();
          localazpe.jdField_a_of_type_JavaLangString = parambeyg;
          localazpe.jdField_a_of_type_Long = l;
          localazpe.b = paramMessageRecord.getExtInfoFromExtStr("quick_send_thumb_md5");
          return localazpe;
        }
      }
      catch (Exception paramMessageRecord)
      {
        paramMessageRecord.printStackTrace();
      }
    }
    return null;
  }
  
  public static void a(MessageRecord paramMessageRecord, azpe paramazpe)
  {
    if ((paramazpe != null) && (paramMessageRecord != null))
    {
      paramMessageRecord.saveExtInfoToExtStr("quick_send_original_md5", paramazpe.jdField_a_of_type_JavaLangString);
      paramMessageRecord.saveExtInfoToExtStr("quick_send_original_size", String.valueOf(paramazpe.jdField_a_of_type_Long));
      paramMessageRecord.saveExtInfoToExtStr("quick_send_thumb_md5", paramazpe.b);
    }
  }
  
  public azqt a(Intent paramIntent)
  {
    azqt localazqt = super.a(paramIntent);
    if ((paramIntent != null) && (localazqt != null))
    {
      azpe localazpe = new azpe();
      localazpe.jdField_a_of_type_JavaLangString = paramIntent.getStringExtra("quick_send_original_md5");
      localazpe.jdField_a_of_type_Long = paramIntent.getLongExtra("quick_send_original_size", 0L);
      localazpe.b = paramIntent.getStringExtra("quick_send_thumb_md5");
      localazqt.jdField_a_of_type_Azpe = localazpe;
      localazqt.r = paramIntent.getIntExtra("key_emotion_source_from", 0);
      localazqt.k = paramIntent.getStringExtra("key_emotion_source_info");
      localazqt.l = paramIntent.getStringExtra("key_emotion_source_weburl");
      localazqt.m = paramIntent.getStringExtra("key_emotion_source_iconurl");
      localazqt.n = paramIntent.getStringExtra("key_emotion_source_packagename");
      localazqt.s = paramIntent.getIntExtra("key_emotion_source_epid", 0);
      if (localazqt.jdField_a_of_type_Azqs == null) {
        localazqt.jdField_a_of_type_Azqs = new azqs();
      }
      localazqt.jdField_a_of_type_Azqs.a = paramIntent.getBooleanExtra("quick_send_is_ad_emo", false);
      localazqt.jdField_a_of_type_Azqs.c = paramIntent.getStringExtra("quick_send_ad_emo_jump_url");
      localazqt.jdField_a_of_type_Azqs.d = paramIntent.getStringExtra("quick_send_ad_emo_desc_str");
    }
    return localazqt;
  }
  
  protected void a(MessageForPic paramMessageForPic)
  {
    if (paramMessageForPic.imageType == 2000) {
      return;
    }
    super.a(paramMessageForPic);
  }
  
  protected void a(MessageForPic paramMessageForPic, azqt paramazqt)
  {
    super.a(paramMessageForPic, paramazqt);
    a(paramMessageForPic, paramazqt.jdField_a_of_type_Azpe);
    PicMessageExtraData localPicMessageExtraData = paramMessageForPic.picExtraData;
    if (localPicMessageExtraData == null) {
      localPicMessageExtraData = new PicMessageExtraData();
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Int == 1042)
      {
        localPicMessageExtraData.imageBizType = 2;
        localPicMessageExtraData.textSummary = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131691126);
        paramMessageForPic.picExtraData = localPicMessageExtraData;
      }
      label294:
      do
      {
        do
        {
          return;
          if (this.jdField_a_of_type_Int == 1047)
          {
            if (paramazqt.c())
            {
              localPicMessageExtraData.imageBizType = 9;
              localPicMessageExtraData.setAdEmoJumpUrl(paramazqt.jdField_a_of_type_Azqs.c);
              localPicMessageExtraData.setAdEmoDescStr(paramazqt.jdField_a_of_type_Azqs.d);
            }
            for (;;)
            {
              paramazqt = aiti.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
              if (paramazqt != null)
              {
                paramazqt = paramazqt.a();
                if (!TextUtils.isEmpty(paramazqt)) {
                  localPicMessageExtraData.textSummary = ("[" + paramazqt + "]");
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
            localPicMessageExtraData.textSummary = BaseApplicationImpl.getApplication().getString(2131691126);
            paramMessageForPic.picExtraData = localPicMessageExtraData;
            return;
          }
          if (this.jdField_a_of_type_Int != 1049) {
            break label294;
          }
          localPicMessageExtraData.imageBizType = 4;
          paramazqt = BaseApplicationImpl.getApplication().getRuntime();
          if (!(paramazqt instanceof AppInterface)) {
            break;
          }
          paramazqt = aiyz.a((AppInterface)paramazqt).b();
        } while (TextUtils.isEmpty(paramazqt));
        localPicMessageExtraData.textSummary = ("[" + paramazqt + "]");
        paramMessageForPic.picExtraData = localPicMessageExtraData;
        return;
      } while (this.jdField_a_of_type_Int != 1054);
      localPicMessageExtraData.imageBizType = 10;
      localPicMessageExtraData.textSummary = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131691126);
      paramMessageForPic.picExtraData = localPicMessageExtraData;
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azpd
 * JD-Core Version:    0.7.0.1
 */