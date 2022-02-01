import android.text.TextUtils;
import com.tencent.beacon.event.UserAction;
import com.tencent.mobileqq.now.livehomepage.NowQQLiveHomepageProto.RcmdAnchor;
import com.tencent.mobileqq.now.livehomepage.NowQQLiveHomepageProto.RecommendItem;
import com.tencent.mobileqq.now.livehomepage.NowQQLiveHomepageProto.RecommendPageReq;
import com.tencent.mobileqq.now.livehomepage.NowQQLiveHomepageProto.RecommendPageRsp;
import com.tencent.mobileqq.now.livehomepage.NowQQLiveHomepageProto.RoomRichTitle;
import com.tencent.mobileqq.now.livehomepage.NowQQLiveHomepageProto.UserExtraInfo;
import com.tencent.mobileqq.now.livehomepage.NowQQLiveHomepageProto.UserMsgInfo;
import com.tencent.mobileqq.now.livehomepage.NowQQLiveHomepageProto.UserTag;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.manager.LoginManager;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;

public class ayee
{
  private static int f;
  public final int a;
  private long jdField_a_of_type_Long;
  private final String jdField_a_of_type_JavaLangString = ayee.class.getSimpleName();
  private final List<ayeh> jdField_a_of_type_JavaUtilList = new CopyOnWriteArrayList();
  private Set<String> jdField_a_of_type_JavaUtilSet = new HashSet();
  private volatile boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private final String jdField_b_of_type_JavaLangString = "78711";
  private int c;
  private final int d;
  private int e;
  
  public ayee()
  {
    this.jdField_a_of_type_Int = 2;
    this.jdField_d_of_type_Int = 60000;
  }
  
  private ayeh a(NowQQLiveHomepageProto.RcmdAnchor paramRcmdAnchor)
  {
    boolean bool2 = true;
    ayeh localayeh = new ayeh();
    localayeh.j = paramRcmdAnchor.string_head_img_url.get();
    localayeh.jdField_b_of_type_JavaLangString = paramRcmdAnchor.string_room_img_url.get();
    localayeh.jdField_b_of_type_Int = paramRcmdAnchor.hall_room_id.get();
    localayeh.jdField_c_of_type_JavaLangString = paramRcmdAnchor.string_name.get();
    localayeh.jdField_c_of_type_Int = paramRcmdAnchor.uint32_watch_count.get();
    localayeh.jdField_d_of_type_JavaLangString = paramRcmdAnchor.string_location.get();
    localayeh.jdField_f_of_type_JavaLangString = paramRcmdAnchor.string_id.get();
    localayeh.jdField_a_of_type_Long = paramRcmdAnchor.imsdk_tiny_id.get();
    localayeh.m = paramRcmdAnchor.rtmp_url.get();
    boolean bool1;
    if (paramRcmdAnchor.allow_play.get() == 1) {
      bool1 = true;
    }
    for (;;)
    {
      localayeh.jdField_b_of_type_Boolean = bool1;
      if (paramRcmdAnchor.video_preview.get() == 1)
      {
        bool1 = bool2;
        localayeh.jdField_c_of_type_Boolean = bool1;
        localayeh.jdField_d_of_type_Int = paramRcmdAnchor.microphone_flag.get();
        localayeh.jdField_g_of_type_JavaLangString = paramRcmdAnchor.icon_url.get();
        localayeh.jdField_a_of_type_JavaUtilList = paramRcmdAnchor.rich_title.elements.get();
        localayeh.i = paramRcmdAnchor.string_description.get();
        localayeh.h = paramRcmdAnchor.award_pendant_url.get();
        if (paramRcmdAnchor.extra_info.has())
        {
          NowQQLiveHomepageProto.UserExtraInfo localUserExtraInfo = (NowQQLiveHomepageProto.UserExtraInfo)paramRcmdAnchor.extra_info.get();
          if ((localUserExtraInfo.medal_info_list.has()) && (localUserExtraInfo.medal_info_list.get() != null) && (localUserExtraInfo.medal_info_list.size() > 0)) {
            localayeh.a(localUserExtraInfo.medal_info_list.get());
          }
        }
        localayeh.jdField_e_of_type_Int = paramRcmdAnchor.user_tag.color.get();
      }
      try
      {
        if (!TextUtils.isEmpty(paramRcmdAnchor.user_tag.change_color.get())) {
          localayeh.jdField_f_of_type_Int = Integer.parseInt(paramRcmdAnchor.user_tag.change_color.get(), 16);
        }
        localayeh.k = paramRcmdAnchor.user_tag.pic_url.get();
        localayeh.l = paramRcmdAnchor.user_tag.wording.get();
        localayeh.jdField_e_of_type_JavaLangString = paramRcmdAnchor.string_jump_url.get();
        localayeh.jdField_g_of_type_Int = paramRcmdAnchor.user_tag.type.get();
        localayeh.n = paramRcmdAnchor.advertising_sign.get();
        return localayeh;
        bool1 = false;
        continue;
        bool1 = false;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        for (;;)
        {
          QLog.e(this.jdField_a_of_type_JavaLangString, 2, localNumberFormatException, new Object[0]);
        }
      }
    }
  }
  
  public int a(int paramInt, byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return -1;
    }
    QLog.d(this.jdField_a_of_type_JavaLangString, 2, "parse data");
    if (paramInt <= 0)
    {
      this.jdField_a_of_type_JavaUtilSet.clear();
      this.jdField_a_of_type_JavaUtilList.clear();
      this.jdField_b_of_type_Int = 0;
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "clear state");
    }
    for (;;)
    {
      NowQQLiveHomepageProto.RecommendPageRsp localRecommendPageRsp;
      NowQQLiveHomepageProto.RecommendItem localRecommendItem;
      try
      {
        localRecommendPageRsp = new NowQQLiveHomepageProto.RecommendPageRsp();
        localRecommendPageRsp.mergeFrom(paramArrayOfByte);
        this.jdField_c_of_type_Int = localRecommendPageRsp.uint32_new_timestamp.get();
        jdField_f_of_type_Int = localRecommendPageRsp.rcmd_col_mode.get();
        paramArrayOfByte = localRecommendPageRsp.rpt_msg_rcmd.get().iterator();
        if (paramArrayOfByte.hasNext())
        {
          localRecommendItem = (NowQQLiveHomepageProto.RecommendItem)paramArrayOfByte.next();
          if (this.jdField_a_of_type_JavaUtilSet.contains(localRecommendItem.string_key.get()))
          {
            QLog.d(this.jdField_a_of_type_JavaLangString, 2, "去重： " + localRecommendItem.string_key.get());
            continue;
          }
          this.jdField_a_of_type_JavaUtilSet.add(localRecommendItem.string_key.get());
        }
      }
      catch (InvalidProtocolBufferMicroException paramArrayOfByte)
      {
        paramArrayOfByte.printStackTrace();
        return -1;
      }
      NowQQLiveHomepageProto.RcmdAnchor localRcmdAnchor;
      Object localObject;
      int i;
      switch (localRecommendItem.uint32_type.get())
      {
      case 0: 
        localRcmdAnchor = (NowQQLiveHomepageProto.RcmdAnchor)localRecommendItem.msg_anchor.get();
        localObject = localRcmdAnchor.string_id.get();
        if ((localObject != null) && (((String)localObject).equals(LoginManager.getInstance().getAccount())))
        {
          QLog.d(this.jdField_a_of_type_JavaLangString, 2, "主页过滤自己");
        }
        else
        {
          localObject = a(localRcmdAnchor);
          ((ayeh)localObject).jdField_a_of_type_JavaLangString = localRecommendItem.string_key.get();
          i = this.jdField_b_of_type_Int;
          this.jdField_b_of_type_Int = (i + 1);
          ((ayeh)localObject).jdField_a_of_type_Int = i;
          ((ayeh)localObject).o = localRcmdAnchor.union_channel_sign.get();
          this.jdField_a_of_type_JavaUtilList.add(localObject);
        }
        break;
      case 5: 
        localRcmdAnchor = (NowQQLiveHomepageProto.RcmdAnchor)localRecommendItem.msg_anchor.get();
        localObject = localRcmdAnchor.string_id.get();
        if ((localObject != null) && (((String)localObject).equals(LoginManager.getInstance().getAccount())))
        {
          QLog.d(this.jdField_a_of_type_JavaLangString, 2, "主页过滤自己");
        }
        else
        {
          localObject = a(localRcmdAnchor);
          ((ayeh)localObject).jdField_a_of_type_JavaLangString = localRecommendItem.string_key.get();
          i = this.jdField_b_of_type_Int;
          this.jdField_b_of_type_Int = (i + 1);
          ((ayeh)localObject).jdField_a_of_type_Int = i;
          ((ayeh)localObject).o = localRcmdAnchor.union_channel_sign.get();
          QLog.d(this.jdField_a_of_type_JavaLangString, 2, "NewRcmdDataMgr, parseData()  Double----anchor_union_channel_sign = " + ((ayeh)localObject).o);
          this.jdField_a_of_type_JavaUtilList.add(localObject);
          continue;
          QLog.d(this.jdField_a_of_type_JavaLangString, 2, "第" + paramInt + "开始拉取:" + localRecommendPageRsp.rpt_msg_rcmd.get().size() + "个数据;" + this.jdField_a_of_type_JavaUtilList.size() + "行");
          return -1;
        }
        break;
      }
    }
  }
  
  public List<ayeh> a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public void a(int paramInt, ayeg paramayeg, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Boolean) {}
    NowQQLiveHomepageProto.RecommendPageReq localRecommendPageReq;
    do
    {
      return;
      if (paramBoolean)
      {
        this.jdField_e_of_type_Int += 1;
        if (this.jdField_e_of_type_Int >= 3)
        {
          paramayeg.b();
          return;
        }
      }
      this.jdField_a_of_type_Boolean = true;
      localRecommendPageReq = new NowQQLiveHomepageProto.RecommendPageReq();
    } while (TextUtils.isEmpty(LoginManager.getInstance().getAccount()));
    localRecommendPageReq.uint32_last_update.set(this.jdField_c_of_type_Int);
    localRecommendPageReq.uint32_index.set(paramInt);
    NowQQLiveHomepageProto.UserMsgInfo localUserMsgInfo = new NowQQLiveHomepageProto.UserMsgInfo();
    localUserMsgInfo.type.set(1);
    localUserMsgInfo.desc.set(String.valueOf(2));
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(localUserMsgInfo);
    localRecommendPageReq.user_msg_info.set(localArrayList);
    localRecommendPageReq.channel.set("78711");
    localRecommendPageReq.rcmd_col_mode.set(jdField_f_of_type_Int);
    localRecommendPageReq.device_id.set(biuf.c());
    localRecommendPageReq.qimei.set(UserAction.getQIMEI());
    aydp.a().a(20736, 100, localRecommendPageReq.toByteArray(), new ayef(this, paramInt, paramayeg));
  }
  
  public void a(ayeg paramayeg)
  {
    if (System.currentTimeMillis() > this.jdField_a_of_type_Long + 60000L) {
      a(0, paramayeg, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayee
 * JD-Core Version:    0.7.0.1
 */