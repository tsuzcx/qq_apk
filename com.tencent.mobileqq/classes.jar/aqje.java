import android.os.Message;
import android.widget.TextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.facetoface.Face2FaceAddFriendActivity;
import com.tencent.mobileqq.facetoface.Face2FaceFriendBubbleView;
import com.tencent.mobileqq.facetoface.Face2FaceTroopDetailView;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import tencent.im.nearfield_group.nearfield_group.BusiRespHead;

public class aqje
  extends alxk
{
  public aqje(Face2FaceAddFriendActivity paramFace2FaceAddFriendActivity) {}
  
  public void a(aqkt paramaqkt)
  {
    Object localObject;
    boolean bool;
    if (QLog.isColorLevel())
    {
      localObject = Face2FaceAddFriendActivity.jdField_b_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder().append("onRecvTroopPush, from_type=").append(this.a.jdField_b_of_type_Int).append(",groupProfile isNull=");
      if (paramaqkt == null)
      {
        bool = true;
        QLog.d((String)localObject, 2, bool + ",show_type=");
      }
    }
    else if ((this.a.jdField_b_of_type_Int == 0) && (paramaqkt != null) && (!this.a.jdField_b_of_type_JavaUtilList.contains(paramaqkt)))
    {
      this.a.jdField_b_of_type_JavaUtilList.add(paramaqkt);
      if (this.a.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size() != this.a.jdField_d_of_type_JavaUtilList.size()) {
        break label162;
      }
      Face2FaceAddFriendActivity.a(this.a, paramaqkt);
    }
    for (;;)
    {
      paramaqkt = this.a;
      paramaqkt.k += 1;
      return;
      bool = false;
      break;
      label162:
      localObject = Face2FaceAddFriendActivity.a(this.a).obtainMessage();
      ((Message)localObject).what = 10;
      ((Message)localObject).obj = paramaqkt;
      Face2FaceAddFriendActivity.a(this.a).sendEmptyMessageDelayed(10, 5000L);
    }
  }
  
  public void a(aqkx paramaqkx)
  {
    Object localObject;
    boolean bool;
    if (QLog.isColorLevel())
    {
      localObject = Face2FaceAddFriendActivity.jdField_b_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder().append("onRecvMemberPush, from_type=").append(this.a.jdField_b_of_type_Int).append(",fromTroopUin=").append(this.a.jdField_d_of_type_JavaLangString).append(",userProfile isNull=");
      if (paramaqkx == null)
      {
        bool = true;
        QLog.d((String)localObject, 2, bool + "total:" + (this.a.jdField_a_of_type_JavaUtilList.size() + 1));
      }
    }
    else
    {
      if (paramaqkx != null) {
        break label108;
      }
    }
    label108:
    do
    {
      long l1;
      long l2;
      long l3;
      do
      {
        return;
        bool = false;
        break;
        l1 = System.currentTimeMillis();
        l2 = l1 - this.a.jdField_f_of_type_Long;
        if ((this.a.jdField_f_of_type_Long == 0L) || (l2 >= 1000L) || (paramaqkx.a != 0L)) {
          break label269;
        }
        localObject = Message.obtain();
        ((Message)localObject).what = 16;
        ((Message)localObject).obj = paramaqkx;
        l3 = 1000L - l2;
        Face2FaceAddFriendActivity.a(this.a).sendMessageDelayed((Message)localObject, l3);
        paramaqkx.a = l1;
        this.a.jdField_f_of_type_Long = (l1 + l3);
      } while (!QLog.isColorLevel());
      QLog.d(Face2FaceAddFriendActivity.jdField_b_of_type_JavaLangString, 2, "onRecvMemberPush, delay=" + l2 + ", delayed=" + l3 + ",mLastToopMemberPushStamp=" + this.a.jdField_f_of_type_Long);
      return;
      if (paramaqkx.a == 0L) {
        this.a.jdField_f_of_type_Long = l1;
      }
    } while ((this.a.jdField_b_of_type_Int != 1) || (this.a.jdField_a_of_type_JavaUtilList.contains(paramaqkx)));
    label269:
    this.a.jdField_a_of_type_JavaUtilList.add(paramaqkx);
    if ((this.a.l) && (this.a.jdField_a_of_type_Aqku != null))
    {
      this.a.jdField_a_of_type_AndroidWidgetTextView.setText(String.valueOf(this.a.jdField_a_of_type_JavaUtilList.size()));
      this.a.jdField_a_of_type_Aqku.a(paramaqkx);
      return;
    }
    Face2FaceAddFriendActivity.a(this.a, paramaqkx);
    this.a.e();
  }
  
  public void a(nearfield_group.BusiRespHead paramBusiRespHead)
  {
    boolean bool;
    if (QLog.isColorLevel())
    {
      String str = Face2FaceAddFriendActivity.jdField_b_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder().append("onCloseFace2faceTroop, respHead isNull=");
      if (paramBusiRespHead == null)
      {
        bool = true;
        QLog.d(str, 2, bool);
      }
    }
    else
    {
      if (paramBusiRespHead != null) {
        break label59;
      }
    }
    label59:
    int i;
    int j;
    int k;
    do
    {
      return;
      bool = false;
      break;
      i = paramBusiRespHead.int32_reply_code.get();
      j = paramBusiRespHead.int32_seq.get();
      k = paramBusiRespHead.int32_version.get();
      paramBusiRespHead = paramBusiRespHead.str_result.get();
    } while (!QLog.isColorLevel());
    QLog.d(Face2FaceAddFriendActivity.jdField_a_of_type_JavaLangString, 2, "onCloseFace2faceTroop, ret=" + i + ",seqNo=" + j + ",ver=" + k + ",errInfo=" + paramBusiRespHead + ",from_type=" + this.a.jdField_b_of_type_Int + ",fromTroopUin=" + this.a.jdField_d_of_type_JavaLangString);
  }
  
  public void a(nearfield_group.BusiRespHead paramBusiRespHead, String paramString)
  {
    if ((this.a.jdField_a_of_type_Bety != null) && (this.a.jdField_a_of_type_Bety.isShowing()))
    {
      this.a.jdField_a_of_type_Bety.dismiss();
      this.a.jdField_a_of_type_Bety = null;
    }
    if (paramBusiRespHead == null)
    {
      this.a.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceTroopDetailView.a(-1, "", paramString, this.a.isFinishing());
      if (QLog.isColorLevel()) {
        QLog.d(Face2FaceAddFriendActivity.jdField_b_of_type_JavaLangString, 2, "onJoinTroop, respHead isNull=true, troopCode=" + paramString);
      }
    }
    int i;
    String str;
    do
    {
      return;
      i = paramBusiRespHead.int32_reply_code.get();
      int j = paramBusiRespHead.int32_seq.get();
      int k = paramBusiRespHead.int32_version.get();
      str = paramBusiRespHead.str_result.get();
      if (QLog.isColorLevel()) {
        QLog.d(Face2FaceAddFriendActivity.jdField_b_of_type_JavaLangString, 2, "onJoinTroop, ret=" + i + ", seqNo=" + j + ",ver=" + k + ",errInfo=" + str + ",troopCode=" + paramString + ",from_type=" + this.a.jdField_b_of_type_Int + ",fromTroopUin=" + this.a.jdField_d_of_type_JavaLangString);
      }
    } while (this.a.jdField_b_of_type_Int != 0);
    if (i == 0)
    {
      Iterator localIterator = this.a.jdField_a_of_type_Aqke.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        paramBusiRespHead = (Face2FaceFriendBubbleView)localIterator.next();
        if ((paramBusiRespHead != null) && (paramBusiRespHead.a() == 2) && (paramString.equals(paramBusiRespHead.b())))
        {
          paramBusiRespHead.setStatusWithAnimation(2);
          paramBusiRespHead = paramBusiRespHead.a();
          if (!(paramBusiRespHead instanceof aqkt)) {
            break label477;
          }
        }
      }
    }
    label477:
    for (paramBusiRespHead = paramBusiRespHead.e + "_" + ((aqkt)paramBusiRespHead).jdField_b_of_type_JavaLangString;; paramBusiRespHead = paramString)
    {
      this.a.jdField_a_of_type_Aqke.a(paramBusiRespHead);
      paramBusiRespHead = Face2FaceAddFriendActivity.a(this.a).obtainMessage();
      paramBusiRespHead.what = 11;
      paramBusiRespHead.arg1 = 2;
      Face2FaceAddFriendActivity.a(this.a).sendMessageDelayed(paramBusiRespHead, this.a.a());
      break;
      azqs.b(null, "P_CliOper", "Grp_set", "", "Radar_grp_guest", "suc_join", 0, 0, paramString, "8.3.5", "", this.a.app.getCurrentAccountUin());
      this.a.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceTroopDetailView.a(i, str, paramString, this.a.isFinishing());
      return;
    }
  }
  
  public void a(nearfield_group.BusiRespHead paramBusiRespHead, List<aqkt> paramList)
  {
    boolean bool2 = false;
    int i;
    boolean bool1;
    if (paramList == null)
    {
      i = 0;
      if (QLog.isColorLevel())
      {
        String str = Face2FaceAddFriendActivity.jdField_b_of_type_JavaLangString;
        StringBuilder localStringBuilder = new StringBuilder().append("onOpenFace2faceTroop, respHead isNull=");
        if (paramBusiRespHead != null) {
          break label179;
        }
        bool1 = true;
        label42:
        localStringBuilder = localStringBuilder.append(bool1).append(", troopList isNull=");
        bool1 = bool2;
        if (paramList == null) {
          bool1 = true;
        }
        QLog.d(str, 2, bool1 + ", troopList.size=" + i);
      }
      if (paramBusiRespHead != null) {
        break label185;
      }
      this.a.jdField_f_of_type_Int = 2;
      Face2FaceAddFriendActivity.d(this.a);
      if (this.a.jdField_b_of_type_Int == 1) {
        bdgm.a(this.a, 230, this.a.getString(2131720808), alud.a(2131704684), 2131690648, 2131692278, new aqjf(this), null).show();
      }
    }
    label179:
    label185:
    do
    {
      do
      {
        return;
        i = paramList.size();
        break;
        bool1 = false;
        break label42;
        i = paramBusiRespHead.int32_reply_code.get();
        int j = paramBusiRespHead.int32_seq.get();
        int k = paramBusiRespHead.int32_version.get();
        paramBusiRespHead = paramBusiRespHead.str_result.get();
        if (QLog.isColorLevel()) {
          QLog.d(Face2FaceAddFriendActivity.jdField_b_of_type_JavaLangString, 2, "onOpenFace2faceTroop, ret=" + i + ",seqNo=" + j + ",ver=" + k + ",errInfo=" + paramBusiRespHead + ",from_type=" + this.a.jdField_b_of_type_Int + ",fromTroopUin=" + this.a.jdField_d_of_type_JavaLangString);
        }
        if (i != 0) {
          break label421;
        }
        this.a.jdField_f_of_type_Int = 1;
      } while (this.a.jdField_b_of_type_Int != 0);
      if ((paramList != null) && (paramList.size() > 0)) {
        paramBusiRespHead = paramList.iterator();
      }
      for (;;)
      {
        if (paramBusiRespHead.hasNext())
        {
          paramList = (aqkw)paramBusiRespHead.next();
          if (!this.a.jdField_b_of_type_JavaUtilList.contains(paramList)) {}
        }
        else
        {
          this.a.c = true;
          Face2FaceAddFriendActivity.d(this.a);
          return;
        }
        this.a.jdField_b_of_type_JavaUtilList.add(paramList);
      }
      this.a.jdField_f_of_type_Int = 2;
      Face2FaceAddFriendActivity.d(this.a);
    } while (this.a.jdField_b_of_type_Int != 1);
    label421:
    bdgm.a(this.a, 230, this.a.getString(2131720808), alud.a(2131704677), 2131690648, 2131692278, new aqjg(this), null).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqje
 * JD-Core Version:    0.7.0.1
 */