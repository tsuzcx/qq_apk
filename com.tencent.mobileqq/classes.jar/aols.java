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

public class aols
  extends akbh
{
  public aols(Face2FaceAddFriendActivity paramFace2FaceAddFriendActivity) {}
  
  public void a(aonh paramaonh)
  {
    Object localObject;
    boolean bool;
    if (QLog.isColorLevel())
    {
      localObject = Face2FaceAddFriendActivity.jdField_b_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder().append("onRecvTroopPush, from_type=").append(this.a.jdField_b_of_type_Int).append(",groupProfile isNull=");
      if (paramaonh == null)
      {
        bool = true;
        QLog.d((String)localObject, 2, bool + ",show_type=");
      }
    }
    else if ((this.a.jdField_b_of_type_Int == 0) && (paramaonh != null) && (!this.a.jdField_b_of_type_JavaUtilList.contains(paramaonh)))
    {
      this.a.jdField_b_of_type_JavaUtilList.add(paramaonh);
      if (this.a.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size() != this.a.jdField_d_of_type_JavaUtilList.size()) {
        break label162;
      }
      Face2FaceAddFriendActivity.a(this.a, paramaonh);
    }
    for (;;)
    {
      paramaonh = this.a;
      paramaonh.k += 1;
      return;
      bool = false;
      break;
      label162:
      localObject = Face2FaceAddFriendActivity.a(this.a).obtainMessage();
      ((Message)localObject).what = 10;
      ((Message)localObject).obj = paramaonh;
      Face2FaceAddFriendActivity.a(this.a).sendEmptyMessageDelayed(10, 5000L);
    }
  }
  
  public void a(aonl paramaonl)
  {
    Object localObject;
    boolean bool;
    if (QLog.isColorLevel())
    {
      localObject = Face2FaceAddFriendActivity.jdField_b_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder().append("onRecvMemberPush, from_type=").append(this.a.jdField_b_of_type_Int).append(",fromTroopUin=").append(this.a.jdField_d_of_type_JavaLangString).append(",userProfile isNull=");
      if (paramaonl == null)
      {
        bool = true;
        QLog.d((String)localObject, 2, bool + "total:" + (this.a.jdField_a_of_type_JavaUtilList.size() + 1));
      }
    }
    else
    {
      if (paramaonl != null) {
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
        if ((this.a.jdField_f_of_type_Long == 0L) || (l2 >= 1000L) || (paramaonl.a != 0L)) {
          break label269;
        }
        localObject = Message.obtain();
        ((Message)localObject).what = 16;
        ((Message)localObject).obj = paramaonl;
        l3 = 1000L - l2;
        Face2FaceAddFriendActivity.a(this.a).sendMessageDelayed((Message)localObject, l3);
        paramaonl.a = l1;
        this.a.jdField_f_of_type_Long = (l1 + l3);
      } while (!QLog.isColorLevel());
      QLog.d(Face2FaceAddFriendActivity.jdField_b_of_type_JavaLangString, 2, "onRecvMemberPush, delay=" + l2 + ", delayed=" + l3 + ",mLastToopMemberPushStamp=" + this.a.jdField_f_of_type_Long);
      return;
      if (paramaonl.a == 0L) {
        this.a.jdField_f_of_type_Long = l1;
      }
    } while ((this.a.jdField_b_of_type_Int != 1) || (this.a.jdField_a_of_type_JavaUtilList.contains(paramaonl)));
    label269:
    this.a.jdField_a_of_type_JavaUtilList.add(paramaonl);
    if ((this.a.l) && (this.a.jdField_a_of_type_Aoni != null))
    {
      this.a.jdField_a_of_type_AndroidWidgetTextView.setText(String.valueOf(this.a.jdField_a_of_type_JavaUtilList.size()));
      this.a.jdField_a_of_type_Aoni.a(paramaonl);
      return;
    }
    Face2FaceAddFriendActivity.a(this.a, paramaonl);
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
    if ((this.a.jdField_a_of_type_Bcpq != null) && (this.a.jdField_a_of_type_Bcpq.isShowing()))
    {
      this.a.jdField_a_of_type_Bcpq.dismiss();
      this.a.jdField_a_of_type_Bcpq = null;
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
      Iterator localIterator = this.a.jdField_a_of_type_Aoms.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        paramBusiRespHead = (Face2FaceFriendBubbleView)localIterator.next();
        if ((paramBusiRespHead != null) && (paramBusiRespHead.a() == 2) && (paramString.equals(paramBusiRespHead.b())))
        {
          paramBusiRespHead.setStatusWithAnimation(2);
          paramBusiRespHead = paramBusiRespHead.a();
          if (!(paramBusiRespHead instanceof aonh)) {
            break label477;
          }
        }
      }
    }
    label477:
    for (paramBusiRespHead = paramBusiRespHead.e + "_" + ((aonh)paramBusiRespHead).jdField_b_of_type_JavaLangString;; paramBusiRespHead = paramString)
    {
      this.a.jdField_a_of_type_Aoms.a(paramBusiRespHead);
      paramBusiRespHead = Face2FaceAddFriendActivity.a(this.a).obtainMessage();
      paramBusiRespHead.what = 11;
      paramBusiRespHead.arg1 = 2;
      Face2FaceAddFriendActivity.a(this.a).sendMessageDelayed(paramBusiRespHead, this.a.a());
      break;
      axqw.b(null, "P_CliOper", "Grp_set", "", "Radar_grp_guest", "suc_join", 0, 0, paramString, "8.2.8", "", this.a.app.getCurrentAccountUin());
      this.a.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceTroopDetailView.a(i, str, paramString, this.a.isFinishing());
      return;
    }
  }
  
  public void a(nearfield_group.BusiRespHead paramBusiRespHead, List<aonh> paramList)
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
        bbcv.a(this.a, 230, this.a.getString(2131720249), ajyc.a(2131704289), 2131690596, 2131692201, new aolt(this), null).show();
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
          paramList = (aonk)paramBusiRespHead.next();
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
    bbcv.a(this.a, 230, this.a.getString(2131720249), ajyc.a(2131704282), 2131690596, 2131692201, new aolu(this), null).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aols
 * JD-Core Version:    0.7.0.1
 */