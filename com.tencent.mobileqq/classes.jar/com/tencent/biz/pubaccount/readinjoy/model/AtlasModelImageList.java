package com.tencent.biz.pubaccount.readinjoy.model;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.comment.data.AtlasCommentData;
import com.tencent.biz.pubaccount.readinjoy.comment.data.BaseCommentData;
import com.tencent.biz.pubaccount.readinjoy.comment.data.CommentData;
import com.tencent.biz.pubaccount.readinjoy.common.TimeSliceHelper;
import com.tencent.biz.pubaccount.readinjoy.struct.DislikeInfo;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.oidb.cmd0xc46.oidb_cmd0xc46.Comment;
import tencent.im.oidb.gallery.gallery.AttachComment;
import tencent.im.oidb.gallery.gallery.GalleryInfo;
import tencent.im.oidb.gallery.gallery.PictureInfo;
import tencent.im.oidb.gallery.gallery.SocialInfo;
import tencent.im.oidb.gallery.gallery_report.OnePicReported;

public class AtlasModelImageList
  extends AtlasModel
{
  public static final String TAG = "AtlasModelImageList";
  public int biuCount;
  public long channelId;
  public int commentCount;
  public final TimeSliceHelper commentTimeMonitor = new TimeSliceHelper();
  public ByteStringMicro cookie;
  public int currentPage = 0;
  public boolean descExpanded;
  public ArrayList<DislikeInfo> dislikeInfos;
  private int enterTimes;
  public gallery.GalleryInfo galleryInfo;
  public boolean hasMoreData = false;
  public boolean hasReportExpCard = false;
  public boolean hasReportExposed0xbe1 = false;
  public boolean hasReportRelationTopic;
  public List<AtlasModelImage> imageList;
  public boolean isAD;
  public boolean isLoadingMore = false;
  public boolean isLoadingRecommend = false;
  private boolean isNeedShowWriteCommentBtn = false;
  public boolean isNoMoreData = false;
  private int isReadEnd = 2;
  public boolean isShowWebConf;
  public int likeCount = -1;
  public int likeStatus = -1;
  public long mClickTime;
  public long mGoAwayTime;
  public AtlasModelRecommend mModelRecommend = new AtlasModelRecommend();
  public long mPageGroupId;
  public AtlasModelImageList.ParsedInfo mParsedInfo;
  private long mPauseTime = -1L;
  private long mReadTime;
  public boolean needShowComment;
  public List<gallery.GalleryInfo> nextGalleryInfo = new ArrayList();
  public long noUseTime = 0L;
  public ArrayList<AtlasCommentData> parsedComments = new ArrayList();
  public int recType;
  public long recommendSeq = -1L;
  public String relationTopicIconUrl;
  public String relationTopicName;
  public String relationTopicWebUrl;
  public boolean requestedForData = false;
  public String rowKey;
  public int sightNum = 1;
  public int source;
  public String webConfId;
  
  public AtlasModelImageList(gallery.GalleryInfo paramGalleryInfo, List<AtlasModelImage> paramList, boolean paramBoolean, int paramInt, String paramString)
  {
    this.type = 3;
    Object localObject = paramList;
    if (paramList == null) {
      localObject = new ArrayList();
    }
    this.mParsedInfo = new AtlasModelImageList.ParsedInfo();
    this.galleryInfo = paramGalleryInfo;
    this.imageList = ((List)localObject);
    this.hasMoreData = paramBoolean;
    this.source = paramInt;
    this.rowKey = paramString;
    this.mParsedInfo.jdField_a_of_type_Long = paramGalleryInfo.uint64_article_id.get();
    this.mParsedInfo.jdField_b_of_type_Long = paramGalleryInfo.int32_reason.get();
    this.mParsedInfo.jdField_a_of_type_JavaLangString = String.valueOf(paramGalleryInfo.uint64_publisher_uin.get());
    this.mParsedInfo.jdField_b_of_type_JavaLangString = paramGalleryInfo.bytes_row_key.get().toStringUtf8();
    TimeSliceHelper.a(paramString, this.commentTimeMonitor);
  }
  
  private void a()
  {
    QLog.d("AtlasModelImageList", 1, new Object[] { "onEnterDetail, rowKey = ", this.rowKey });
    this.enterTimes += 1;
    if (a(this.currentPage)) {
      ((AtlasModelImage)this.imageList.get(this.currentPage)).onSlideEnter(0);
    }
  }
  
  private boolean a(int paramInt)
  {
    return (paramInt >= 0) && (paramInt < this.imageList.size());
  }
  
  public static void convertBaseCommentData(oidb_cmd0xc46.Comment paramComment, BaseCommentData paramBaseCommentData)
  {
    if ((paramComment == null) || (paramBaseCommentData == null)) {}
    do
    {
      return;
      if (paramComment.comment_id.has()) {
        paramBaseCommentData.commentId = paramComment.comment_id.get();
      }
      if (paramComment.author_id.has()) {
        paramBaseCommentData.uin = paramComment.author_id.get();
      }
      if (paramComment.create_time.has()) {
        paramBaseCommentData.commentTime = paramComment.create_time.get();
      }
      if (paramComment.content.has()) {
        paramBaseCommentData.commentContent = paramComment.content.get();
      }
      if (paramComment.like_num.has()) {
        paramBaseCommentData.likeCnt = paramComment.like_num.get();
      }
      if (paramComment.like.has()) {
        paramBaseCommentData.like = paramComment.like.get();
      }
      if (paramComment.dislike.has()) {
        paramBaseCommentData.disLike = paramComment.dislike.get();
      }
      if (paramComment.anonymous.has()) {
        paramBaseCommentData.anonymous = paramComment.anonymous.get();
      }
      if (paramComment.author_selection.has()) {
        paramBaseCommentData.authorSelection = paramComment.author_selection.get();
      }
      if (paramComment.rank.has()) {
        paramBaseCommentData.rank = paramComment.rank.get();
      }
      if (paramComment.level.has()) {
        paramBaseCommentData.level = paramComment.level.get();
      }
      if (paramComment.author_comment.has()) {
        paramBaseCommentData.authorComment = paramComment.author_comment.get();
      }
      if (paramComment.nick_name.has()) {
        paramBaseCommentData.nickName = paramComment.nick_name.get();
      }
      if (paramComment.avatar.has()) {
        paramBaseCommentData.avatar = paramComment.avatar.get();
      }
      if (paramComment.myself.has()) {
        paramBaseCommentData.myself = paramComment.myself.get();
      }
      if (paramComment.homepage.has()) {
        paramBaseCommentData.homepage = paramComment.homepage.get();
      }
      if (paramComment.awesome.has()) {
        paramBaseCommentData.awesome = paramComment.awesome.get();
      }
      if (paramComment.rowkey.has()) {
        paramBaseCommentData.rowKey = paramComment.rowkey.get();
      }
      if (paramComment.content_source.has()) {
        paramBaseCommentData.contentSrc = paramComment.content_source.get();
      }
    } while (!paramComment.passthrough.has());
    paramBaseCommentData.passthrough = paramComment.passthrough.get().toStringUtf8();
  }
  
  public static String getGallerySummary(Context paramContext, List<AtlasModelImage> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {
      return paramContext.getString(2131718270);
    }
    paramContext = paramList.iterator();
    while (paramContext.hasNext())
    {
      paramList = ((AtlasModelImage)paramContext.next()).pictureInfo.bytes_pic_desc.get().toStringUtf8();
      if (!TextUtils.isEmpty(paramList)) {
        return paramList;
      }
    }
    return HardCodeUtil.a(2131700864);
  }
  
  public void afterDispearReported()
  {
    this.mClickTime = 0L;
    this.hasReportRelationTopic = false;
    Iterator localIterator = this.imageList.iterator();
    while (localIterator.hasNext()) {
      ((AtlasModelImage)localIterator.next()).onePicReported = null;
    }
    QLog.d("AtlasModelImageList", 1, new Object[] { "afterDisappearReported, clear clickTime, rowKey = ", this.rowKey });
  }
  
  public int getDataSize()
  {
    if (this.imageList == null) {
      return 0;
    }
    return this.imageList.size();
  }
  
  public boolean getIsNeedShowWriteCommentBtn()
  {
    return this.isNeedShowWriteCommentBtn;
  }
  
  public List<gallery_report.OnePicReported> getOnePicReporteds()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.imageList.iterator();
    while (localIterator.hasNext())
    {
      AtlasModelImage localAtlasModelImage = (AtlasModelImage)localIterator.next();
      if (localAtlasModelImage.onePicReported != null) {
        localArrayList.add(localAtlasModelImage.onePicReported);
      }
    }
    return localArrayList;
  }
  
  public long getPicCount()
  {
    return this.galleryInfo.uint64_pic_count.get();
  }
  
  public int getReadCount()
  {
    int k;
    if ((this.imageList == null) || (this.currentPage < 0))
    {
      QLog.e("AtlasModelImageList", 2, "AtlasModelImageList.imageList.isEmpty rowkey = " + this.rowKey);
      k = 0;
      return k;
    }
    int j = 0;
    for (int i = 0;; i = k)
    {
      k = i;
      if (j >= this.imageList.size()) {
        break;
      }
      k = i;
      if (((AtlasModelImage)this.imageList.get(j)).isExposed()) {
        k = i + 1;
      }
      j += 1;
    }
  }
  
  public JSONArray getReadDetails()
  {
    JSONArray localJSONArray = new JSONArray();
    if ((this.imageList == null) || (this.currentPage < 0))
    {
      QLog.e("AtlasModelImageList", 2, "AtlasModelImageList.imageList.isEmpty rowkey = " + this.rowKey);
      return localJSONArray;
    }
    int i = 0;
    for (;;)
    {
      AtlasModelImage localAtlasModelImage;
      JSONObject localJSONObject;
      if (i < this.imageList.size())
      {
        localAtlasModelImage = (AtlasModelImage)this.imageList.get(i);
        if (localAtlasModelImage.isExposed()) {
          localJSONObject = new JSONObject();
        }
      }
      try
      {
        localJSONObject.put("index", String.valueOf(i));
        localJSONObject.put("come_in_time", localAtlasModelImage.modelEnterTime + "");
        localJSONObject.put("load_completed_time", localAtlasModelImage.modelImageShowTime + "");
        localJSONObject.put("go_away_time", localAtlasModelImage.modelExitTime + "");
        localJSONObject.put("pic_type", localAtlasModelImage.picType + "");
        localJSONObject.put("slide_pos", localAtlasModelImage.mSlidePos + "");
        localJSONArray.put(localJSONObject);
        label278:
        i += 1;
        continue;
        return localJSONArray;
      }
      catch (JSONException localJSONException)
      {
        break label278;
      }
    }
  }
  
  public long getReadTime()
  {
    return this.mReadTime;
  }
  
  public int getReportIndex()
  {
    return Math.min(this.imageList.size(), this.currentPage + 1);
  }
  
  public void initEnterTimes(int paramInt)
  {
    this.enterTimes = paramInt;
  }
  
  public boolean isCurrentLastImg()
  {
    return this.currentPage == this.imageList.size() - 1;
  }
  
  public boolean isCurrentNormalModel()
  {
    return this.currentPage < this.imageList.size();
  }
  
  public boolean isOnlyOneDesc()
  {
    return this.galleryInfo.int32_pic_desc.get() == 1;
  }
  
  public int isReadEnd()
  {
    return this.isReadEnd;
  }
  
  public int isReadRepeated()
  {
    if (this.enterTimes > 1) {
      return 1;
    }
    return 0;
  }
  
  public void onBindData()
  {
    a();
    QLog.d("AtlasModelImageList", 1, new Object[] { "onBindData, rowKey = ", this.rowKey });
  }
  
  public void onDispear()
  {
    this.commentTimeMonitor.b();
    this.mGoAwayTime = System.currentTimeMillis();
    this.mReadTime += Math.max(0L, this.mGoAwayTime - this.mClickTime);
    if (a(this.currentPage)) {
      ((AtlasModelImage)this.imageList.get(this.currentPage)).onSlideExit();
    }
    QLog.d("AtlasModelImageList", 1, new Object[] { "onDisappear, mReadTime = ", Long.valueOf(this.mReadTime), ", rowKey = ", this.rowKey });
  }
  
  public void onEnter()
  {
    updateClickTime();
    a();
    QLog.d("AtlasModelImageList", 1, new Object[] { "onEnter, mClickTime = ", Long.valueOf(this.mClickTime), ", rowKey = ", this.rowKey });
  }
  
  public void onPause()
  {
    this.mPauseTime = System.currentTimeMillis();
    this.commentTimeMonitor.b();
  }
  
  public void onResume()
  {
    if (this.mPauseTime > 0L)
    {
      this.noUseTime += System.currentTimeMillis() - this.mPauseTime;
      this.mPauseTime = -1L;
    }
    this.commentTimeMonitor.a();
  }
  
  public void onSlideItem(int paramInt1, int paramInt2)
  {
    if (paramInt1 != this.currentPage)
    {
      if (a(this.currentPage)) {
        ((AtlasModelImage)this.imageList.get(this.currentPage)).onSlideExit();
      }
      this.currentPage = paramInt1;
      if (a(this.currentPage)) {
        ((AtlasModelImage)this.imageList.get(this.currentPage)).onSlideEnter(paramInt2);
      }
    }
    this.sightNum = Math.min(this.imageList.size(), Math.max(this.currentPage + 1, this.sightNum));
    if (this.currentPage >= this.imageList.size() - 1) {
      this.isReadEnd = 1;
    }
  }
  
  public boolean onceEnter()
  {
    return this.mClickTime != 0L;
  }
  
  public void parseCommentFromPB()
  {
    if (!this.parsedComments.isEmpty()) {}
    for (;;)
    {
      return;
      int j = this.galleryInfo.social_info.attach_comments.size();
      int i = 0;
      while ((i < j) && (i < 3))
      {
        gallery.AttachComment localAttachComment = (gallery.AttachComment)this.galleryInfo.social_info.attach_comments.get(i);
        AtlasCommentData localAtlasCommentData = new AtlasCommentData();
        localAtlasCommentData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataCommentData = new CommentData();
        convertBaseCommentData((oidb_cmd0xc46.Comment)localAttachComment.comment_info.get(), localAtlasCommentData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataCommentData);
        localAtlasCommentData.jdField_a_of_type_JavaUtilList = localAttachComment.comment_icons.get();
        this.parsedComments.add(localAtlasCommentData);
        i += 1;
      }
    }
  }
  
  public void setIsNeedShowWriteCommentBtn(boolean paramBoolean)
  {
    this.isNeedShowWriteCommentBtn = paramBoolean;
  }
  
  public boolean showRelationTopic()
  {
    return (this.isShowWebConf) && (!TextUtils.isEmpty(this.relationTopicName));
  }
  
  public String toString()
  {
    return "rowkey :" + this.rowKey + ",currentPage :" + this.currentPage + ",imageList :" + this.imageList + ",mModelRecommend :" + this.mModelRecommend;
  }
  
  public void updateClickTime()
  {
    if (this.mClickTime == 0L)
    {
      this.mClickTime = System.currentTimeMillis();
      QLog.d("AtlasModelImageList", 1, new Object[] { "updateClickTime, mClickTime = ", Long.valueOf(this.mClickTime), ", rowKey = ", this.rowKey });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.model.AtlasModelImageList
 * JD-Core Version:    0.7.0.1
 */