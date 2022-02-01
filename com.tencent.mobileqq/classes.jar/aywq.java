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

public class aywq
  extends aywp
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
  
  public aywq(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public aywq(QQAppInterface paramQQAppInterface, int paramInt)
  {
    super(paramQQAppInterface);
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public static aywr a(MessageRecord paramMessageRecord, bdzn parambdzn)
  {
    if (jdField_a_of_type_JavaUtilSet.contains(Integer.valueOf(parambdzn.e))) {
      try
      {
        long l = Long.valueOf(paramMessageRecord.getExtInfoFromExtStr("quick_send_original_size")).longValue();
        parambdzn = paramMessageRecord.getExtInfoFromExtStr("quick_send_original_md5");
        if ((l > 0L) && (!parambdzn.equals("")))
        {
          aywr localaywr = new aywr();
          localaywr.jdField_a_of_type_JavaLangString = parambdzn;
          localaywr.jdField_a_of_type_Long = l;
          localaywr.b = paramMessageRecord.getExtInfoFromExtStr("quick_send_thumb_md5");
          return localaywr;
        }
      }
      catch (Exception paramMessageRecord)
      {
        paramMessageRecord.printStackTrace();
      }
    }
    return null;
  }
  
  public static void a(MessageRecord paramMessageRecord, aywr paramaywr)
  {
    if ((paramaywr != null) && (paramMessageRecord != null))
    {
      paramMessageRecord.saveExtInfoToExtStr("quick_send_original_md5", paramaywr.jdField_a_of_type_JavaLangString);
      paramMessageRecord.saveExtInfoToExtStr("quick_send_original_size", String.valueOf(paramaywr.jdField_a_of_type_Long));
      paramMessageRecord.saveExtInfoToExtStr("quick_send_thumb_md5", paramaywr.b);
    }
  }
  
  public ayyg a(Intent paramIntent)
  {
    ayyg localayyg = super.a(paramIntent);
    if ((paramIntent != null) && (localayyg != null))
    {
      aywr localaywr = new aywr();
      localaywr.jdField_a_of_type_JavaLangString = paramIntent.getStringExtra("quick_send_original_md5");
      localaywr.jdField_a_of_type_Long = paramIntent.getLongExtra("quick_send_original_size", 0L);
      localaywr.b = paramIntent.getStringExtra("quick_send_thumb_md5");
      localayyg.jdField_a_of_type_Aywr = localaywr;
      localayyg.r = paramIntent.getIntExtra("key_emotion_source_from", 0);
      localayyg.k = paramIntent.getStringExtra("key_emotion_source_info");
      localayyg.l = paramIntent.getStringExtra("key_emotion_source_weburl");
      localayyg.m = paramIntent.getStringExtra("key_emotion_source_iconurl");
      localayyg.n = paramIntent.getStringExtra("key_emotion_source_packagename");
      localayyg.s = paramIntent.getIntExtra("key_emotion_source_epid", 0);
      if (localayyg.jdField_a_of_type_Ayyf == null) {
        localayyg.jdField_a_of_type_Ayyf = new ayyf();
      }
      localayyg.jdField_a_of_type_Ayyf.a = paramIntent.getBooleanExtra("quick_send_is_ad_emo", false);
      localayyg.jdField_a_of_type_Ayyf.c = paramIntent.getStringExtra("quick_send_ad_emo_jump_url");
      localayyg.jdField_a_of_type_Ayyf.d = paramIntent.getStringExtra("quick_send_ad_emo_desc_str");
    }
    return localayyg;
  }
  
  protected void a(MessageForPic paramMessageForPic)
  {
    if (paramMessageForPic.imageType == 2000) {
      return;
    }
    super.a(paramMessageForPic);
  }
  
  protected void a(MessageForPic paramMessageForPic, ayyg paramayyg)
  {
    super.a(paramMessageForPic, paramayyg);
    a(paramMessageForPic, paramayyg.jdField_a_of_type_Aywr);
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
            if (paramayyg.c())
            {
              localPicMessageExtraData.imageBizType = 9;
              localPicMessageExtraData.setAdEmoJumpUrl(paramayyg.jdField_a_of_type_Ayyf.c);
              localPicMessageExtraData.setAdEmoDescStr(paramayyg.jdField_a_of_type_Ayyf.d);
            }
            for (;;)
            {
              paramayyg = aijp.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
              if (paramayyg != null)
              {
                paramayyg = paramayyg.a();
                if (!TextUtils.isEmpty(paramayyg)) {
                  localPicMessageExtraData.textSummary = ("[" + paramayyg + "]");
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
          paramayyg = BaseApplicationImpl.getApplication().getRuntime();
          if (!(paramayyg instanceof AppInterface)) {
            break;
          }
          paramayyg = ains.a((AppInterface)paramayyg).b();
        } while (TextUtils.isEmpty(paramayyg));
        localPicMessageExtraData.textSummary = ("[" + paramayyg + "]");
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
 * Qualified Name:     aywq
 * JD-Core Version:    0.7.0.1
 */