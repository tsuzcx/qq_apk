import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.PicMessageExtraData;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.HashSet;
import java.util.Set;

public class aumo
  extends aumn
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
  }
  
  public aumo(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public aumo(QQAppInterface paramQQAppInterface, int paramInt)
  {
    super(paramQQAppInterface);
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public static aump a(MessageRecord paramMessageRecord, aywc paramaywc)
  {
    if (jdField_a_of_type_JavaUtilSet.contains(Integer.valueOf(paramaywc.e))) {
      try
      {
        long l = Long.valueOf(paramMessageRecord.getExtInfoFromExtStr("quick_send_original_size")).longValue();
        paramaywc = paramMessageRecord.getExtInfoFromExtStr("quick_send_original_md5");
        if ((l > 0L) && (!paramaywc.equals("")))
        {
          aump localaump = new aump();
          localaump.jdField_a_of_type_JavaLangString = paramaywc;
          localaump.jdField_a_of_type_Long = l;
          localaump.b = paramMessageRecord.getExtInfoFromExtStr("quick_send_thumb_md5");
          return localaump;
        }
      }
      catch (Exception paramMessageRecord)
      {
        paramMessageRecord.printStackTrace();
      }
    }
    return null;
  }
  
  public static void a(MessageRecord paramMessageRecord, aump paramaump)
  {
    if ((paramaump != null) && (paramMessageRecord != null))
    {
      paramMessageRecord.saveExtInfoToExtStr("quick_send_original_md5", paramaump.jdField_a_of_type_JavaLangString);
      paramMessageRecord.saveExtInfoToExtStr("quick_send_original_size", String.valueOf(paramaump.jdField_a_of_type_Long));
      paramMessageRecord.saveExtInfoToExtStr("quick_send_thumb_md5", paramaump.b);
    }
  }
  
  public auod a(Intent paramIntent)
  {
    auod localauod = super.a(paramIntent);
    if ((paramIntent != null) && (localauod != null))
    {
      aump localaump = new aump();
      localaump.jdField_a_of_type_JavaLangString = paramIntent.getStringExtra("quick_send_original_md5");
      localaump.jdField_a_of_type_Long = paramIntent.getLongExtra("quick_send_original_size", 0L);
      localaump.b = paramIntent.getStringExtra("quick_send_thumb_md5");
      localauod.a = localaump;
      localauod.r = paramIntent.getIntExtra("key_emotion_source_from", 0);
      localauod.n = paramIntent.getStringExtra("key_emotion_source_info");
      localauod.o = paramIntent.getStringExtra("key_emotion_source_weburl");
      localauod.p = paramIntent.getStringExtra("key_emotion_source_iconurl");
      localauod.q = paramIntent.getStringExtra("key_emotion_source_packagename");
      localauod.s = paramIntent.getIntExtra("key_emotion_source_epid", 0);
    }
    return localauod;
  }
  
  protected void a(MessageForPic paramMessageForPic)
  {
    if (paramMessageForPic.imageType == 2000) {
      return;
    }
    super.a(paramMessageForPic);
  }
  
  protected void a(MessageForPic paramMessageForPic, auod paramauod)
  {
    super.a(paramMessageForPic, paramauod);
    a(paramMessageForPic, paramauod.a);
    Object localObject = paramMessageForPic.picExtraData;
    paramauod = (auod)localObject;
    if (localObject == null) {
      paramauod = new PicMessageExtraData();
    }
    if (this.jdField_a_of_type_Int == 1042)
    {
      paramauod.imageBizType = 2;
      paramauod.textSummary = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131691289);
      paramMessageForPic.picExtraData = paramauod;
    }
    while (this.jdField_a_of_type_Int != 1047) {
      return;
    }
    paramauod.imageBizType = 7;
    localObject = aexb.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a();
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      paramauod.textSummary = ("[" + (String)localObject + "]");
    }
    paramMessageForPic.picExtraData = paramauod;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aumo
 * JD-Core Version:    0.7.0.1
 */