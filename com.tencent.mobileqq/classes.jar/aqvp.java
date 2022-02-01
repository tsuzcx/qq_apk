import android.graphics.Paint;
import android.text.TextUtils;
import android.util.LruCache;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.comment.DanmuItemBean;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.MessageForReplyText.SourceMsgInfo;
import com.tencent.mobileqq.data.MessageForText.AtTroopMemberInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.List<Ltencent.im.oidb.oidb_0xdea.Comment;>;
import tencent.im.msg.im_msg_body.AnonymousGroupMsg;
import tencent.im.msg.im_msg_body.Elem;
import tencent.im.msg.im_msg_body.MsgBody;
import tencent.im.msg.im_msg_body.RichText;
import tencent.im.oidb.oidb_0xdea.Comment;

public class aqvp
{
  private static aqvp jdField_a_of_type_Aqvp;
  public int a;
  public Paint a;
  private LruCache<String, aqvq> jdField_a_of_type_AndroidUtilLruCache;
  private aqvw jdField_a_of_type_Aqvw;
  
  private aqvp()
  {
    this.jdField_a_of_type_Int = bhtq.a(150.0F);
    if (this.jdField_a_of_type_AndroidUtilLruCache == null) {
      this.jdField_a_of_type_AndroidUtilLruCache = new LruCache(10485760);
    }
    if (BaseApplicationImpl.sProcessId == 1)
    {
      if (this.jdField_a_of_type_Aqvw == null) {
        this.jdField_a_of_type_Aqvw = new aqvw();
      }
      b();
    }
  }
  
  public static aqvp a()
  {
    if (jdField_a_of_type_Aqvp == null) {
      jdField_a_of_type_Aqvp = new aqvp();
    }
    return jdField_a_of_type_Aqvp;
  }
  
  public aqvq a(String paramString)
  {
    return (aqvq)this.jdField_a_of_type_AndroidUtilLruCache.get(paramString);
  }
  
  public QQAppInterface a()
  {
    if (BaseApplicationImpl.sProcessId == 1) {
      return (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    }
    return null;
  }
  
  public String a(long paramLong1, long paramLong2)
  {
    return String.valueOf(paramLong1) + paramLong2;
  }
  
  public List<DanmuItemBean> a(List<oidb_0xdea.Comment> paramList, long paramLong)
  {
    if ((paramList == null) || (paramList.isEmpty())) {
      return null;
    }
    QQAppInterface localQQAppInterface = a();
    if (localQQAppInterface == null) {
      return null;
    }
    ArrayList localArrayList = new ArrayList(paramList.size());
    bcrt localbcrt = new bcrt();
    Iterator localIterator = paramList.iterator();
    Object localObject1;
    if (localIterator.hasNext()) {
      localObject1 = (oidb_0xdea.Comment)localIterator.next();
    }
    for (;;)
    {
      long l1;
      long l2;
      int i;
      try
      {
        paramList = new im_msg_body.MsgBody();
        paramList.mergeFrom(((oidb_0xdea.Comment)localObject1).bytes_comment_msg.get().toByteArray());
        Object localObject2 = new im_msg_body.RichText();
        ((im_msg_body.RichText)localObject2).mergeFrom(((im_msg_body.RichText)paramList.rich_text.get()).toByteArray());
        localObject2 = ((im_msg_body.RichText)localObject2).elems.get();
        l1 = ((oidb_0xdea.Comment)localObject1).uint64_comment_uin.get();
        l2 = ((oidb_0xdea.Comment)localObject1).uint64_seq.get();
        long l3 = ((oidb_0xdea.Comment)localObject1).uint32_comment_ctime.get();
        long l4 = ((oidb_0xdea.Comment)localObject1).uint64_comment_location.get();
        paramList = new bfoy();
        paramList.jdField_a_of_type_JavaLangString = String.valueOf(paramLong);
        paramList.jdField_a_of_type_Int = 1;
        Object localObject3 = localbcrt.a((List)localObject2, new StringBuilder(), l2, paramList);
        if (TextUtils.isEmpty(((bcru)localObject3).jdField_a_of_type_JavaLangString)) {
          break;
        }
        if ((TextUtils.isEmpty(((bcru)localObject3).jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo.mAnonymousNickName)) && (((bcru)localObject3).jdField_a_of_type_ComTencentMobileqqDataMessageForText$AtTroopMemberInfo != null) && (!TextUtils.isEmpty(((bcru)localObject3).jdField_a_of_type_JavaLangString)) && (((bcru)localObject3).jdField_a_of_type_JavaLangString.length() > ((bcru)localObject3).jdField_a_of_type_ComTencentMobileqqDataMessageForText$AtTroopMemberInfo.textLen + 1) && (((bcru)localObject3).jdField_a_of_type_JavaLangString.startsWith(((bcru)localObject3).b)))
        {
          paramList = ((bcru)localObject3).jdField_a_of_type_JavaLangString.substring(((bcru)localObject3).jdField_a_of_type_ComTencentMobileqqDataMessageForText$AtTroopMemberInfo.textLen + 1);
          if (!TextUtils.isEmpty(paramList)) {
            ((bcru)localObject3).jdField_a_of_type_JavaLangString = paramList;
          }
        }
        paramList = ((oidb_0xdea.Comment)localObject1).bytes_nick.get().toStringUtf8();
        i = ((oidb_0xdea.Comment)localObject1).uint32_source.get();
        if (TextUtils.isEmpty(paramList))
        {
          localObject1 = bhlg.h(localQQAppInterface, String.valueOf(paramLong), String.valueOf(l1));
          paramList = (List<oidb_0xdea.Comment>)localObject1;
          if (QLog.isColorLevel())
          {
            QLog.d("DanmuDataHolder", 2, new Object[] { "decodeCommentList, use local nickname, seq:", Long.valueOf(l2) });
            paramList = (List<oidb_0xdea.Comment>)localObject1;
          }
          paramList = aqvy.a(this.jdField_a_of_type_AndroidGraphicsPaint, paramList, this.jdField_a_of_type_Int);
          localObject1 = new DanmuItemBean(l1, l2, l3, l4, ((bcru)localObject3).jdField_a_of_type_JavaLangString, paramList);
          localArrayList.add(localObject1);
          localObject2 = ((List)localObject2).iterator();
          if (!((Iterator)localObject2).hasNext()) {
            break;
          }
          paramList = (im_msg_body.Elem)((Iterator)localObject2).next();
          if (!paramList.anon_group_msg.has()) {
            continue;
          }
          localObject3 = (im_msg_body.AnonymousGroupMsg)paramList.anon_group_msg.get();
          paramList = ((im_msg_body.AnonymousGroupMsg)localObject3).str_anon_nick.get().toByteArray();
          if (((im_msg_body.AnonymousGroupMsg)localObject3).uint32_flags.get() <= 0) {
            break label786;
          }
          bool = true;
          ((DanmuItemBean)localObject1).jdField_a_of_type_Boolean = bool;
          if (paramList != null) {
            break label731;
          }
          paramList = "";
          ((DanmuItemBean)localObject1).c = paramList;
          ((DanmuItemBean)localObject1).jdField_a_of_type_Int = ((im_msg_body.AnonymousGroupMsg)localObject3).uint32_head_portrait.get();
          QLog.d("DanmuDataHolder", 1, new Object[] { "decodeCommentList, 匿名消息,", localObject1 });
          continue;
        }
      }
      catch (Exception paramList)
      {
        QLog.d("DanmuDataHolder", 1, "decodeCommentList, e:" + paramList);
      }
      if (i == 4)
      {
        localObject1 = ((anyw)localQQAppInterface.getManager(51)).b(String.valueOf(l1));
        if ((localObject1 != null) && (((Friends)localObject1).isFriend()) && (!TextUtils.isEmpty(((Friends)localObject1).remark)))
        {
          localObject1 = ((Friends)localObject1).remark;
          paramList = (List<oidb_0xdea.Comment>)localObject1;
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("DanmuDataHolder", 2, new Object[] { "decodeCommentList, use local remake, seq:", Long.valueOf(l2) });
          paramList = (List<oidb_0xdea.Comment>)localObject1;
          continue;
          label731:
          paramList = new String(paramList);
          continue;
          if (QLog.isColorLevel()) {
            QLog.d("DanmuDataHolder", 2, "decodeCommentList, " + localArrayList.toString());
          }
          return localArrayList;
        }
      }
      continue;
      label786:
      boolean bool = false;
    }
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidUtilLruCache.evictAll();
  }
  
  public void a(aqvo paramaqvo, aqvu paramaqvu)
  {
    if ((paramaqvo.a == 0L) || (paramaqvo.b == 0L))
    {
      if (QLog.isColorLevel()) {
        QLog.d("DanmuDataHolder", 2, String.format("request, bad parameter, topicUin:%s, groupUin:%s", new Object[] { Long.valueOf(paramaqvo.a), Long.valueOf(paramaqvo.b) }));
      }
      return;
    }
    Object localObject = a().a(paramaqvo.b, paramaqvo.a);
    aqvq localaqvq = a().a((String)localObject);
    localObject = localaqvq;
    if (localaqvq == null)
    {
      localObject = new aqvq(this).a(paramaqvo).d(0).e(0).a(paramaqvu).a();
      QLog.d("DanmuDataHolder", 2, "request start, reqHolder is null, create it");
    }
    this.jdField_a_of_type_Aqvw.a((aqvq)localObject);
  }
  
  public void a(String paramString, aqvq paramaqvq)
  {
    this.jdField_a_of_type_AndroidUtilLruCache.put(paramString, paramaqvq);
  }
  
  public aqvq b(String paramString)
  {
    aqvq localaqvq = new aqvq(this);
    a(paramString, localaqvq);
    return localaqvq;
  }
  
  public void b()
  {
    QQAppInterface localQQAppInterface = a();
    if ((this.jdField_a_of_type_AndroidGraphicsPaint == null) && (localQQAppInterface != null)) {
      this.jdField_a_of_type_AndroidGraphicsPaint = ((TextView)LayoutInflater.from(localQQAppInterface.getApp()).inflate(2131558923, null).findViewById(2131364772)).getPaint();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqvp
 * JD-Core Version:    0.7.0.1
 */