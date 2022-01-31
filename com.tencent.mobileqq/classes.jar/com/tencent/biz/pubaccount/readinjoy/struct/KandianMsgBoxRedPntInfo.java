package com.tencent.biz.pubaccount.readinjoy.struct;

import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import java.io.Serializable;
import mqq.app.AppRuntime;
import obz;
import org.json.JSONException;
import org.json.JSONObject;
import ppn;
import tencent.im.oidb.cmd0xbe4.oidb_cmd0xbe4.MsgBody;
import tencent.im.oidb.cmd0xbe4.oidb_cmd0xbe4.MsgContent;
import tencent.im.oidb.cmd0xbe4.oidb_cmd0xbe4.MsgFolderInfo;
import tencent.im.oidb.cmd0xbe4.oidb_cmd0xbe4.MsgGetRsp;

public class KandianMsgBoxRedPntInfo
  implements Serializable
{
  public static final int DATA_TYPE_CARD = 1;
  public static final int DATA_TYPE_TIPS = 0;
  public static final String SP_KEY = "kandian_msg_box_sp_key_new";
  private static final long serialVersionUID = -3014381608481056753L;
  public boolean canDoAnimation = true;
  public int dataType = 0;
  public String feedsID;
  public int feedsType;
  public boolean isExpose;
  public boolean isRead;
  public String mArticlePicUrl;
  public String mCardSummary;
  public String mExtraData;
  public String mIconUrl;
  public String mJumpUrl;
  public int mMsgCnt;
  public long mMsgTime;
  public int mMsgType;
  public boolean mNeedShowInFolder;
  public String mOrangeWord;
  public int mRedType;
  public long mSeq;
  public String mSummary;
  public long mUin;
  public int messageType;
  public int sysMsgFrom;
  public String sysMsgID;
  
  public static KandianMsgBoxRedPntInfo createFromJSON(String paramString)
  {
    try
    {
      KandianMsgBoxRedPntInfo localKandianMsgBoxRedPntInfo = new KandianMsgBoxRedPntInfo();
      paramString = new JSONObject(paramString);
      localKandianMsgBoxRedPntInfo.mSeq = paramString.getLong("_red_ext_seq");
      localKandianMsgBoxRedPntInfo.mUin = paramString.getLong("_red_ext_from_uin");
      localKandianMsgBoxRedPntInfo.mMsgType = paramString.getInt("_red_ext_msg_type");
      localKandianMsgBoxRedPntInfo.mMsgTime = paramString.getLong("_red_ext_msg_time");
      localKandianMsgBoxRedPntInfo.mIconUrl = paramString.getString("_red_ext_pic_url");
      localKandianMsgBoxRedPntInfo.mJumpUrl = paramString.getString("_red_ext_jump_url");
      localKandianMsgBoxRedPntInfo.mNeedShowInFolder = false;
      localKandianMsgBoxRedPntInfo.mRedType = paramString.getInt("_red_ext_red_type");
      localKandianMsgBoxRedPntInfo.mOrangeWord = paramString.getString("_red_ext_orange_word");
      localKandianMsgBoxRedPntInfo.mSummary = paramString.getString("_red_ext_summary");
      if ((!TextUtils.isEmpty(localKandianMsgBoxRedPntInfo.mSummary)) && (!TextUtils.isEmpty(localKandianMsgBoxRedPntInfo.mOrangeWord))) {
        localKandianMsgBoxRedPntInfo.mNeedShowInFolder = true;
      }
      localKandianMsgBoxRedPntInfo.mMsgCnt = paramString.getInt("_red_ext_unread");
      return localKandianMsgBoxRedPntInfo;
    }
    catch (JSONException paramString) {}
    return null;
  }
  
  public static KandianMsgBoxRedPntInfo createFromPB(oidb_cmd0xbe4.MsgGetRsp paramMsgGetRsp)
  {
    if (paramMsgGetRsp == null) {
      return null;
    }
    KandianMsgBoxRedPntInfo localKandianMsgBoxRedPntInfo = new KandianMsgBoxRedPntInfo();
    localKandianMsgBoxRedPntInfo.mMsgCnt = ((int)paramMsgGetRsp.uint64_unread.get());
    oidb_cmd0xbe4.MsgBody localMsgBody = (oidb_cmd0xbe4.MsgBody)paramMsgGetRsp.msg_body.get();
    if (localMsgBody == null) {
      return null;
    }
    localKandianMsgBoxRedPntInfo.mSeq = localMsgBody.uint64_seq.get();
    localKandianMsgBoxRedPntInfo.mMsgType = localMsgBody.uint32_msg_type.get();
    localKandianMsgBoxRedPntInfo.mMsgTime = localMsgBody.uint64_msg_time.get();
    if (localMsgBody.bytes_pic_url.has()) {
      localKandianMsgBoxRedPntInfo.mIconUrl = localMsgBody.bytes_pic_url.get().toStringUtf8();
    }
    if (localMsgBody.bytes_jump_url.has()) {
      localKandianMsgBoxRedPntInfo.mJumpUrl = localMsgBody.bytes_jump_url.get().toStringUtf8();
    }
    localKandianMsgBoxRedPntInfo.mUin = localMsgBody.uint64_from_uin.get();
    boolean bool;
    label198:
    label222:
    oidb_cmd0xbe4.MsgContent localMsgContent;
    if (localMsgBody.msg_folder_info.has())
    {
      paramMsgGetRsp = (oidb_cmd0xbe4.MsgFolderInfo)localMsgBody.msg_folder_info.get();
      if (paramMsgGetRsp.uint32_show_folder.get() == 1)
      {
        bool = true;
        localKandianMsgBoxRedPntInfo.mNeedShowInFolder = bool;
        if (!paramMsgGetRsp.bytes_summary.has()) {
          break label416;
        }
        localKandianMsgBoxRedPntInfo.mSummary = paramMsgGetRsp.bytes_summary.get().toStringUtf8();
        if (!paramMsgGetRsp.bytes_orange_word.has()) {
          break label424;
        }
        localKandianMsgBoxRedPntInfo.mOrangeWord = paramMsgGetRsp.bytes_orange_word.get().toStringUtf8();
      }
    }
    else if (localMsgBody.msg_content.has())
    {
      localKandianMsgBoxRedPntInfo.dataType = 1;
      localMsgContent = (oidb_cmd0xbe4.MsgContent)localMsgBody.msg_content.get();
      if (!localMsgContent.str_desc.has()) {
        break label432;
      }
      paramMsgGetRsp = localMsgContent.str_desc.get();
      label269:
      localKandianMsgBoxRedPntInfo.mCardSummary = paramMsgGetRsp;
      if (!localMsgContent.str_feeds_pic.has()) {
        break label439;
      }
      paramMsgGetRsp = localMsgContent.str_feeds_pic.get();
      label294:
      localKandianMsgBoxRedPntInfo.mArticlePicUrl = paramMsgGetRsp;
      localKandianMsgBoxRedPntInfo.sysMsgFrom = localMsgContent.uint32_sys_from.get();
      if (!localMsgContent.string_sys_activityid.has()) {
        break label446;
      }
      paramMsgGetRsp = localMsgContent.string_sys_activityid.get();
      label331:
      localKandianMsgBoxRedPntInfo.sysMsgID = paramMsgGetRsp;
      if (!localMsgContent.string_feeds_id.has()) {
        break label453;
      }
    }
    label416:
    label424:
    label432:
    label439:
    label446:
    label453:
    for (paramMsgGetRsp = localMsgContent.string_feeds_id.get();; paramMsgGetRsp = "")
    {
      localKandianMsgBoxRedPntInfo.feedsID = paramMsgGetRsp;
      localKandianMsgBoxRedPntInfo.feedsType = localMsgContent.uint32_feed_type.get();
      localKandianMsgBoxRedPntInfo.messageType = localMsgContent.uint32_type.get();
      if (localMsgBody.bytes_ext_data.has()) {
        localKandianMsgBoxRedPntInfo.mExtraData = localMsgBody.bytes_ext_data.get().toStringUtf8();
      }
      return localKandianMsgBoxRedPntInfo;
      bool = false;
      break;
      localKandianMsgBoxRedPntInfo.mNeedShowInFolder = false;
      break label198;
      localKandianMsgBoxRedPntInfo.mNeedShowInFolder = false;
      break label222;
      paramMsgGetRsp = "";
      break label269;
      paramMsgGetRsp = "";
      break label294;
      paramMsgGetRsp = "";
      break label331;
    }
  }
  
  public static KandianMsgBoxRedPntInfo getRedPntInfoFromSp()
  {
    AppRuntime localAppRuntime = obz.a();
    KandianMsgBoxRedPntInfo localKandianMsgBoxRedPntInfo2 = (KandianMsgBoxRedPntInfo)obz.a(localAppRuntime, "kandian_msg_box_sp_key_new", true);
    KandianMsgBoxRedPntInfo localKandianMsgBoxRedPntInfo1 = localKandianMsgBoxRedPntInfo2;
    if (localKandianMsgBoxRedPntInfo2 == null)
    {
      ppn localppn1 = ppn.d();
      ppn localppn2 = ppn.a();
      if (localppn1 == null)
      {
        localKandianMsgBoxRedPntInfo1 = localKandianMsgBoxRedPntInfo2;
        if (localppn2 == null) {}
      }
      else
      {
        localKandianMsgBoxRedPntInfo1 = new KandianMsgBoxRedPntInfo();
        localKandianMsgBoxRedPntInfo1.mSeq = -1L;
        localKandianMsgBoxRedPntInfo1.mNeedShowInFolder = false;
        if (localppn2 != null)
        {
          localKandianMsgBoxRedPntInfo1.mMsgCnt += localppn2.a;
          localKandianMsgBoxRedPntInfo1.mUin = localppn2.e;
          localKandianMsgBoxRedPntInfo1.mMsgTime = System.currentTimeMillis();
          localKandianMsgBoxRedPntInfo1.mMsgType = 1;
          localppn2.a(localAppRuntime);
        }
        if (localppn1 != null)
        {
          localKandianMsgBoxRedPntInfo1.mMsgCnt += localppn1.a;
          localKandianMsgBoxRedPntInfo1.mMsgType = 2;
          localppn1.d((QQAppInterface)localAppRuntime);
        }
        localKandianMsgBoxRedPntInfo1.asyncWriteToSP();
      }
    }
    return localKandianMsgBoxRedPntInfo1;
  }
  
  public void asyncWriteToSP()
  {
    obz.a("kandian_msg_box_sp_key_new", this, true);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass())) {
        return false;
      }
      paramObject = (KandianMsgBoxRedPntInfo)paramObject;
    } while ((this.mSeq == paramObject.mSeq) && (this.mMsgCnt == paramObject.mMsgCnt) && (this.mMsgTime == paramObject.mMsgTime) && (this.mUin == paramObject.mUin) && (this.mMsgType == paramObject.mMsgType) && (this.mNeedShowInFolder == paramObject.mNeedShowInFolder) && (this.mRedType == paramObject.mRedType) && (this.dataType == paramObject.dataType) && (this.sysMsgFrom == paramObject.sysMsgFrom) && (this.feedsType == paramObject.feedsType) && (this.messageType == paramObject.messageType) && (TextUtils.equals(this.mJumpUrl, paramObject.mJumpUrl)) && (TextUtils.equals(this.mIconUrl, paramObject.mIconUrl)) && (TextUtils.equals(this.mSummary, paramObject.mSummary)) && (TextUtils.equals(this.mOrangeWord, paramObject.mOrangeWord)) && (TextUtils.equals(this.mCardSummary, paramObject.mCardSummary)) && (TextUtils.equals(this.mArticlePicUrl, paramObject.mArticlePicUrl)) && (TextUtils.equals(this.mExtraData, paramObject.mExtraData)) && (TextUtils.equals(this.sysMsgID, paramObject.sysMsgID)) && (TextUtils.equals(this.feedsID, paramObject.feedsID)) && (this.isExpose == paramObject.isExpose));
    return false;
  }
  
  public int hashCode()
  {
    return (int)(this.mSeq + this.mUin + this.mMsgCnt + this.mSummary.hashCode());
  }
  
  public void removeFromSP()
  {
    obz.a("kandian_msg_box_sp_key_new", true);
  }
  
  public String toString()
  {
    return "KandianMsgBoxRedPntInfo{mSeq=" + this.mSeq + ", mMsgCnt=" + this.mMsgCnt + ", mMsgTime=" + this.mMsgTime + ", mUin=" + this.mUin + ", mMsgType=" + this.mMsgType + ", mJumpUrl='" + this.mJumpUrl + '\'' + ", mIconUrl='" + this.mIconUrl + '\'' + ", isRead=" + this.isRead + ", mNeedShowInFolder=" + this.mNeedShowInFolder + ", mRedType=" + this.mRedType + ", mSummary='" + this.mSummary + '\'' + ", mOrangeWord='" + this.mOrangeWord + '\'' + ", canDoAnimation=" + this.canDoAnimation + ", mCardSummary='" + this.mCardSummary + '\'' + ", mArticlePicUrl='" + this.mArticlePicUrl + '\'' + ", mExtraData='" + this.mExtraData + '\'' + ", isExpose='" + this.isExpose + '\'' + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.struct.KandianMsgBoxRedPntInfo
 * JD-Core Version:    0.7.0.1
 */