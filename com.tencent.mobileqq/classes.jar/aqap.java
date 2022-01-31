import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.CustomEmotionData;
import com.tencent.mobileqq.data.MessageForMarketFace;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.PicMessageExtraData;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

public class aqap
  extends aqae
{
  public MessageRecord a;
  private boolean a;
  
  public aqap(MessageRecord paramMessageRecord)
  {
    this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = paramMessageRecord;
  }
  
  public int a(List<aqae> paramList)
  {
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      aqae localaqae = (aqae)localIterator.next();
      if ((localaqae instanceof aqap))
      {
        MessageRecord localMessageRecord = ((aqap)localaqae).jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
        if (localMessageRecord.uniseq == this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.uniseq) {
          if (((localMessageRecord instanceof MessageForPic)) && ((this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord instanceof MessageForPic)) && (((MessageForPic)localMessageRecord).md5 != null))
          {
            if (((MessageForPic)localMessageRecord).md5.equals(((MessageForPic)this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord).md5)) {
              return paramList.indexOf(localaqae);
            }
          }
          else {
            return paramList.indexOf(localaqae);
          }
        }
      }
    }
    return paramList.size() - 1;
  }
  
  public long a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.uniseq;
  }
  
  public Drawable a(Context paramContext)
  {
    aqam localaqam = new aqam(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord);
    paramContext = aqag.a(paramContext, localaqam);
    this.jdField_a_of_type_Boolean = localaqam.c;
    return paramContext;
  }
  
  public apuf a()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord instanceof MessageForMarketFace)) {
      return aqag.a((MessageForMarketFace)this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord);
    }
    return null;
  }
  
  public CustomEmotionData a()
  {
    if (((this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord instanceof MessageForPic)) && (((MessageForPic)this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord).md5 != null))
    {
      Object localObject = BaseApplicationImpl.getApplication().getRuntime();
      if ((localObject instanceof QQAppInterface))
      {
        localObject = ((apon)((QQAppInterface)localObject).getManager(149)).a();
        if (localObject != null)
        {
          localObject = ((List)localObject).iterator();
          while (((Iterator)localObject).hasNext())
          {
            CustomEmotionData localCustomEmotionData = (CustomEmotionData)((Iterator)localObject).next();
            if (((MessageForPic)this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord).md5.equalsIgnoreCase(localCustomEmotionData.md5)) {
              return localCustomEmotionData;
            }
          }
        }
      }
    }
    return null;
  }
  
  public String a()
  {
    if (((this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord instanceof MessageForPic)) && (((MessageForPic)this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord).picExtraData != null)) {
      return ((MessageForPic)this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord).picExtraData.mTemplateId;
    }
    return null;
  }
  
  public void a(Bundle paramBundle, int paramInt)
  {
    super.a(paramBundle, paramInt);
    paramBundle.putString("cur_msg_uin", this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.frienduin);
    paramBundle.putInt("cur_msg_uin_type", this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.istroop);
    paramBundle.putLong("cur_msg_uniseq", this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.uniseq);
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord instanceof MessageForMarketFace;
  }
  
  public boolean a(aqae paramaqae)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if ((paramaqae instanceof aqap))
    {
      paramaqae = ((aqap)paramaqae).jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
      bool1 = bool2;
      if (paramaqae != null)
      {
        bool1 = bool2;
        if (this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord != null)
        {
          bool1 = bool2;
          if (paramaqae.shmsgseq == this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.shmsgseq)
          {
            bool1 = bool2;
            if (paramaqae.msgUid == this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.msgUid) {
              bool1 = true;
            }
          }
        }
      }
    }
    return bool1;
  }
  
  public aqae b(Bundle paramBundle)
  {
    if (paramBundle.containsKey("cur_msg_uniseq"))
    {
      QLog.d("MsgEmoticonPreviewData", 1, "doRestoreSaveInstanceState");
      String str = paramBundle.getString("cur_msg_uin");
      int i = paramBundle.getInt("cur_msg_uin_type");
      long l = paramBundle.getLong("cur_msg_uniseq");
      paramBundle = BaseApplicationImpl.getApplication().getRuntime();
      if ((paramBundle instanceof QQAppInterface)) {
        return new aqap(((QQAppInterface)paramBundle).a().b(str, i, l));
      }
    }
    return null;
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public boolean c()
  {
    if (((this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord instanceof MessageForPic)) && (((MessageForPic)this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord).picExtraData != null))
    {
      int i = ((MessageForPic)this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord).picExtraData.from;
      if ((i == 1) || (i == 2)) {
        return true;
      }
    }
    return false;
  }
  
  public boolean d()
  {
    if (((this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord instanceof MessageForPic)) && (((MessageForPic)this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord).picExtraData != null)) {
      return ((MessageForPic)this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord).picExtraData.isSelfieFace();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqap
 * JD-Core Version:    0.7.0.1
 */