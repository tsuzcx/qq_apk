import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForApollo;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.MessageForArkBabyqReply;
import com.tencent.mobileqq.data.MessageForFunnyFace;
import com.tencent.mobileqq.data.MessageForLightVideo;
import com.tencent.mobileqq.data.MessageForLimitChatConfirm;
import com.tencent.mobileqq.data.MessageForLongTextMsg;
import com.tencent.mobileqq.data.MessageForMarketFace;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForPoke;
import com.tencent.mobileqq.data.MessageForPokeEmo;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.data.MessageForReplyText;
import com.tencent.mobileqq.data.MessageForScribble;
import com.tencent.mobileqq.data.MessageForShakeWindow;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageForTroopStory;
import com.tencent.mobileqq.data.MessageRecord;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import tencent.im.msg.im_msg_body.RichText;

class amwi
{
  private int jdField_a_of_type_Int;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private MessageRecord jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
  private ArrayList<Integer> jdField_a_of_type_JavaUtilArrayList = new ArrayList(Arrays.asList(new Integer[] { Integer.valueOf(-1000), Integer.valueOf(-1049), Integer.valueOf(-2056), Integer.valueOf(-2000), Integer.valueOf(-2002), Integer.valueOf(-2007), Integer.valueOf(-2058), Integer.valueOf(-2039), Integer.valueOf(-2011), Integer.valueOf(-2051), Integer.valueOf(-7002), Integer.valueOf(-2010), Integer.valueOf(-2020), Integer.valueOf(-2022), Integer.valueOf(-2071), Integer.valueOf(-5008), Integer.valueOf(-5013), Integer.valueOf(-5014), Integer.valueOf(-5012), Integer.valueOf(-5018), Integer.valueOf(-1051), Integer.valueOf(-1052), Integer.valueOf(-1035), Integer.valueOf(-2057), Integer.valueOf(-7001), Integer.valueOf(-5016), Integer.valueOf(-5017), Integer.valueOf(-7005) }));
  private im_msg_body.RichText jdField_a_of_type_TencentImMsgIm_msg_body$RichText;
  
  public amwi(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord, im_msg_body.RichText paramRichText, int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = paramMessageRecord;
    this.jdField_a_of_type_TencentImMsgIm_msg_body$RichText = paramRichText;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  private void A()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.msgtype == -2058)
    {
      if (!(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord instanceof MessageForMarketFace)) {
        break label52;
      }
      this.jdField_a_of_type_TencentImMsgIm_msg_body$RichText = bblf.a((MessageForMarketFace)this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord);
      this.jdField_a_of_type_Int = ((MessageForMarketFace)this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord).msgVia;
    }
    label52:
    do
    {
      return;
      if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord instanceof MessageForText))
      {
        this.jdField_a_of_type_TencentImMsgIm_msg_body$RichText = bblf.a((MessageForText)this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord);
        this.jdField_a_of_type_Int = ((MessageForText)this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord).msgVia;
        return;
      }
    } while (!(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord instanceof MessageForPic));
    this.jdField_a_of_type_TencentImMsgIm_msg_body$RichText = bblf.a((MessageForPic)this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord);
    this.jdField_a_of_type_Int = ((MessageForPic)this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord).msgVia;
  }
  
  private static im_msg_body.RichText a(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord)
  {
    Object localObject = null;
    Iterator localIterator = paramQQAppInterface.getMessageFacade().getRegistry().d().iterator();
    while (localIterator.hasNext())
    {
      im_msg_body.RichText localRichText = ((abyd)localIterator.next()).a(paramMessageRecord, paramQQAppInterface);
      localObject = localRichText;
      if (localRichText != null) {
        localObject = localRichText;
      }
    }
    return localObject;
  }
  
  private void a()
  {
    if (!this.jdField_a_of_type_JavaUtilArrayList.contains(Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.msgtype))) {
      this.jdField_a_of_type_TencentImMsgIm_msg_body$RichText = a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord);
    }
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.msgtype == -7005) {
      this.jdField_a_of_type_TencentImMsgIm_msg_body$RichText = bblf.b((MessageForLimitChatConfirm)this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord);
    }
  }
  
  private void c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.msgtype == -5017) {
      this.jdField_a_of_type_TencentImMsgIm_msg_body$RichText = bblf.b((MessageForArkApp)this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord, false);
    }
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.msgtype == -5016) {
      this.jdField_a_of_type_TencentImMsgIm_msg_body$RichText = bblf.c((MessageForArkBabyqReply)this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord, false);
    }
  }
  
  private void e()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.msgtype == -7001) {
      this.jdField_a_of_type_TencentImMsgIm_msg_body$RichText = bblf.g((MessageForScribble)this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord);
    }
  }
  
  private void f()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.msgtype == -2057) {
      this.jdField_a_of_type_TencentImMsgIm_msg_body$RichText = bblf.a((MessageForTroopStory)this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord);
    }
  }
  
  private void g()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.msgtype == -1035) {
      this.jdField_a_of_type_TencentImMsgIm_msg_body$RichText = bblf.a((MessageForMixedMsg)this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord);
    }
  }
  
  private void h()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.msgtype == -1052) {
      this.jdField_a_of_type_TencentImMsgIm_msg_body$RichText = new im_msg_body.RichText();
    }
  }
  
  private void i()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.msgtype == -1051) {
      this.jdField_a_of_type_TencentImMsgIm_msg_body$RichText = bblf.a((MessageForLongTextMsg)this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord, true);
    }
  }
  
  private void j()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.msgtype == -5018) {
      this.jdField_a_of_type_TencentImMsgIm_msg_body$RichText = bblf.f((MessageForPokeEmo)this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord);
    }
  }
  
  private void k()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.msgtype == -5012) {
      this.jdField_a_of_type_TencentImMsgIm_msg_body$RichText = bblf.e((MessageForPoke)this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord);
    }
  }
  
  private void l()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.msgtype == -5014) {
      this.jdField_a_of_type_TencentImMsgIm_msg_body$RichText = bblf.d((ChatMessage)this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord);
    }
  }
  
  private void m()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.msgtype == -5013) {
      this.jdField_a_of_type_TencentImMsgIm_msg_body$RichText = bblf.c((ChatMessage)this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord);
    }
  }
  
  private void n()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.msgtype == -5008) {
      this.jdField_a_of_type_TencentImMsgIm_msg_body$RichText = bblf.a((ChatMessage)this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord, false);
    }
  }
  
  private void o()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.msgtype == -2071) {
      this.jdField_a_of_type_TencentImMsgIm_msg_body$RichText = bblf.a((MessageForLightVideo)this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord);
    }
  }
  
  private void p()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.msgtype == -2022) {
      this.jdField_a_of_type_TencentImMsgIm_msg_body$RichText = bblf.a((MessageForShortVideo)this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord);
    }
  }
  
  private void q()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.msgtype == -2020) {
      this.jdField_a_of_type_TencentImMsgIm_msg_body$RichText = bblf.a((MessageForShakeWindow)this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord);
    }
  }
  
  private void r()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.msgtype == -2010) {
      this.jdField_a_of_type_TencentImMsgIm_msg_body$RichText = bblf.a((MessageForFunnyFace)this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord);
    }
  }
  
  private void s()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.msgtype == -2011) || (this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.msgtype == -2051) || (this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.msgtype == -7002)) {
      this.jdField_a_of_type_TencentImMsgIm_msg_body$RichText = bblf.a((MessageForStructing)this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord);
    }
  }
  
  private void t()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.msgtype == -2039) {
      this.jdField_a_of_type_TencentImMsgIm_msg_body$RichText = bblf.a((MessageForApollo)this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord);
    }
  }
  
  private void u()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.msgtype == -2007)
    {
      this.jdField_a_of_type_TencentImMsgIm_msg_body$RichText = bblf.a((MessageForMarketFace)this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord);
      this.jdField_a_of_type_Int = ((MessageForMarketFace)this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord).msgVia;
    }
  }
  
  private void v()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.msgtype == -2002)
    {
      this.jdField_a_of_type_TencentImMsgIm_msg_body$RichText = bblf.a((MessageForPtt)this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord);
      this.jdField_a_of_type_Int = ((MessageForPtt)this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord).msgVia;
    }
  }
  
  private void w()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.msgtype == -2000)
    {
      this.jdField_a_of_type_TencentImMsgIm_msg_body$RichText = bblf.a((MessageForPic)this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord);
      this.jdField_a_of_type_Int = ((MessageForPic)this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord).msgVia;
    }
  }
  
  private void x()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.msgtype == -2056) {
      this.jdField_a_of_type_TencentImMsgIm_msg_body$RichText = bblf.a((MessageForText)this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord);
    }
  }
  
  private void y()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.msgtype == -1049)
    {
      this.jdField_a_of_type_TencentImMsgIm_msg_body$RichText = bblf.a((MessageForReplyText)this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord);
      this.jdField_a_of_type_Int = ((MessageForReplyText)this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord).msgVia;
    }
  }
  
  private void z()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.msgtype == -1000)
    {
      this.jdField_a_of_type_TencentImMsgIm_msg_body$RichText = bblf.a((MessageForText)this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord);
      this.jdField_a_of_type_Int = ((MessageForText)this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord).msgVia;
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public amwi a()
  {
    z();
    y();
    x();
    w();
    v();
    u();
    A();
    t();
    s();
    r();
    q();
    p();
    o();
    n();
    m();
    l();
    k();
    j();
    i();
    h();
    g();
    f();
    e();
    d();
    c();
    b();
    a();
    return this;
  }
  
  public im_msg_body.RichText a()
  {
    return this.jdField_a_of_type_TencentImMsgIm_msg_body$RichText;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amwi
 * JD-Core Version:    0.7.0.1
 */