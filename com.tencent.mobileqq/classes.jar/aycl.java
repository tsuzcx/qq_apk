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

public class aycl
  extends ayck
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
  
  public aycl(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public aycl(QQAppInterface paramQQAppInterface, int paramInt)
  {
    super(paramQQAppInterface);
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public static aycm a(MessageRecord paramMessageRecord, TransferRequest paramTransferRequest)
  {
    if (jdField_a_of_type_JavaUtilSet.contains(Integer.valueOf(paramTransferRequest.mBusiType))) {
      try
      {
        long l = Long.valueOf(paramMessageRecord.getExtInfoFromExtStr("quick_send_original_size")).longValue();
        paramTransferRequest = paramMessageRecord.getExtInfoFromExtStr("quick_send_original_md5");
        if ((l > 0L) && (!paramTransferRequest.equals("")))
        {
          aycm localaycm = new aycm();
          localaycm.jdField_a_of_type_JavaLangString = paramTransferRequest;
          localaycm.jdField_a_of_type_Long = l;
          localaycm.b = paramMessageRecord.getExtInfoFromExtStr("quick_send_thumb_md5");
          return localaycm;
        }
      }
      catch (Exception paramMessageRecord)
      {
        paramMessageRecord.printStackTrace();
      }
    }
    return null;
  }
  
  public static void a(MessageRecord paramMessageRecord, aycm paramaycm)
  {
    if ((paramaycm != null) && (paramMessageRecord != null))
    {
      paramMessageRecord.saveExtInfoToExtStr("quick_send_original_md5", paramaycm.jdField_a_of_type_JavaLangString);
      paramMessageRecord.saveExtInfoToExtStr("quick_send_original_size", String.valueOf(paramaycm.jdField_a_of_type_Long));
      paramMessageRecord.saveExtInfoToExtStr("quick_send_thumb_md5", paramaycm.b);
    }
  }
  
  public ayeb a(Intent paramIntent)
  {
    ayeb localayeb = super.a(paramIntent);
    if ((paramIntent != null) && (localayeb != null))
    {
      aycm localaycm = new aycm();
      localaycm.jdField_a_of_type_JavaLangString = paramIntent.getStringExtra("quick_send_original_md5");
      localaycm.jdField_a_of_type_Long = paramIntent.getLongExtra("quick_send_original_size", 0L);
      localaycm.b = paramIntent.getStringExtra("quick_send_thumb_md5");
      localayeb.jdField_a_of_type_Aycm = localaycm;
      localayeb.r = paramIntent.getIntExtra("key_emotion_source_from", 0);
      localayeb.k = paramIntent.getStringExtra("key_emotion_source_info");
      localayeb.l = paramIntent.getStringExtra("key_emotion_source_weburl");
      localayeb.m = paramIntent.getStringExtra("key_emotion_source_iconurl");
      localayeb.n = paramIntent.getStringExtra("key_emotion_source_packagename");
      localayeb.s = paramIntent.getIntExtra("key_emotion_source_epid", 0);
      if (localayeb.jdField_a_of_type_Ayea == null) {
        localayeb.jdField_a_of_type_Ayea = new ayea();
      }
      localayeb.jdField_a_of_type_Ayea.a = paramIntent.getBooleanExtra("quick_send_is_ad_emo", false);
      localayeb.jdField_a_of_type_Ayea.c = paramIntent.getStringExtra("quick_send_ad_emo_jump_url");
      localayeb.jdField_a_of_type_Ayea.d = paramIntent.getStringExtra("quick_send_ad_emo_desc_str");
      localayeb.jdField_a_of_type_Ayea.b = paramIntent.getBooleanExtra("quick_send_is_emo_search", false);
    }
    return localayeb;
  }
  
  protected void a(MessageForPic paramMessageForPic)
  {
    if (paramMessageForPic.imageType == 2000) {
      return;
    }
    super.a(paramMessageForPic);
  }
  
  protected void a(MessageForPic paramMessageForPic, ayeb paramayeb)
  {
    super.a(paramMessageForPic, paramayeb);
    a(paramMessageForPic, paramayeb.jdField_a_of_type_Aycm);
    PicMessageExtraData localPicMessageExtraData = paramMessageForPic.picExtraData;
    if (localPicMessageExtraData == null) {
      localPicMessageExtraData = new PicMessageExtraData();
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Int == 1042) {
        if (paramayeb.d())
        {
          localPicMessageExtraData.imageBizType = 13;
          localPicMessageExtraData.textSummary = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131691165);
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
            if (paramayeb.c())
            {
              localPicMessageExtraData.imageBizType = 9;
              localPicMessageExtraData.setAdEmoJumpUrl(paramayeb.jdField_a_of_type_Ayea.c);
              localPicMessageExtraData.setAdEmoDescStr(paramayeb.jdField_a_of_type_Ayea.d);
            }
            for (;;)
            {
              paramayeb = ahns.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
              if (paramayeb != null)
              {
                paramayeb = paramayeb.a();
                if (!TextUtils.isEmpty(paramayeb)) {
                  localPicMessageExtraData.textSummary = ("[" + paramayeb + "]");
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
            localPicMessageExtraData.textSummary = BaseApplicationImpl.getApplication().getString(2131691165);
            paramMessageForPic.picExtraData = localPicMessageExtraData;
            return;
          }
          if (this.jdField_a_of_type_Int != 1049) {
            break label312;
          }
          localPicMessageExtraData.imageBizType = 4;
          paramayeb = BaseApplicationImpl.getApplication().getRuntime();
          if (!(paramayeb instanceof AppInterface)) {
            break label306;
          }
          paramayeb = ahtj.a((AppInterface)paramayeb).b();
        } while (TextUtils.isEmpty(paramayeb));
        localPicMessageExtraData.textSummary = ("[" + paramayeb + "]");
        paramMessageForPic.picExtraData = localPicMessageExtraData;
        return;
      } while (this.jdField_a_of_type_Int != 1054);
      localPicMessageExtraData.imageBizType = 10;
      localPicMessageExtraData.textSummary = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131691165);
      paramMessageForPic.picExtraData = localPicMessageExtraData;
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aycl
 * JD-Core Version:    0.7.0.1
 */