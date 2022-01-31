package com.tencent.biz.pubaccount.readinjoy.model;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.UtilsForComponent;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import cooperation.readinjoy.ReadInJoyHelper;
import java.util.Iterator;
import java.util.List;
import tencent.im.oidb.cmd0x68b.oidb_cmd0x68b.FriendRecommendInfo;
import tencent.im.oidb.cmd0x68b.oidb_cmd0x68b.PackInfo;
import tencent.im.oidb.cmd0x68b.oidb_cmd0x68b.PackJumpInfo;
import tencent.im.oidb.cmd0x68b.oidb_cmd0x68b.SpecialTopicInfo;

public class ReadInJoyModelImpl
  implements IReadInJoyModel
{
  public int a;
  private Context jdField_a_of_type_AndroidContentContext;
  private ArticleInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
  private ReadInJoyBaseAdapter jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter;
  private boolean jdField_a_of_type_Boolean;
  public int b;
  private ArticleInfo b;
  private int c;
  private int d;
  private int e;
  
  public ReadInJoyModelImpl(Context paramContext, ArticleInfo paramArticleInfo1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean, int paramInt5, ArticleInfo paramArticleInfo2, ReadInJoyBaseAdapter paramReadInJoyBaseAdapter)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = paramArticleInfo1;
    this.c = paramInt1;
    this.jdField_a_of_type_Int = paramInt2;
    this.d = paramInt3;
    this.jdField_b_of_type_Int = paramInt4;
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.e = paramInt5;
    this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = paramArticleInfo2;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter = paramReadInJoyBaseAdapter;
  }
  
  private int a(ArticleInfo paramArticleInfo)
  {
    if (paramArticleInfo == null) {
      return 0;
    }
    if ((paramArticleInfo.mFeedIndexInGroup == paramArticleInfo.mGroupCount - 1L) && (paramArticleInfo.mPackInfoObj != null) && (paramArticleInfo.mPackInfoObj.pack_type.has()))
    {
      Object localObject;
      String str;
      if (paramArticleInfo.mPackInfoObj.pack_type.get() == 2)
      {
        if ((paramArticleInfo.mPackInfoObj.msg_special_topic_info.has()) && (((oidb_cmd0x68b.SpecialTopicInfo)paramArticleInfo.mPackInfoObj.msg_special_topic_info.get()).rpt_jumps.has()))
        {
          localObject = ((oidb_cmd0x68b.SpecialTopicInfo)paramArticleInfo.mPackInfoObj.msg_special_topic_info.get()).rpt_jumps.get();
          if ((localObject != null) && (((List)localObject).size() > 0))
          {
            str = ((oidb_cmd0x68b.PackJumpInfo)((List)localObject).get(0)).str_url.get();
            localObject = ((oidb_cmd0x68b.PackJumpInfo)((List)localObject).get(0)).str_wording.get();
            if ((!TextUtils.isEmpty(str)) && (!TextUtils.isEmpty((CharSequence)localObject))) {
              return 2;
            }
          }
        }
      }
      else if ((paramArticleInfo.mPackInfoObj.pack_type.get() == 3) && (paramArticleInfo.mPackInfoObj.msg_friend_recommend_info.has()) && (((oidb_cmd0x68b.FriendRecommendInfo)paramArticleInfo.mPackInfoObj.msg_friend_recommend_info.get()).rpt_jumps.has()))
      {
        localObject = ((oidb_cmd0x68b.FriendRecommendInfo)paramArticleInfo.mPackInfoObj.msg_friend_recommend_info.get()).rpt_jumps.get();
        if ((localObject != null) && (((List)localObject).size() > 0))
        {
          str = ((oidb_cmd0x68b.PackJumpInfo)((List)localObject).get(0)).str_url.get();
          localObject = ((oidb_cmd0x68b.PackJumpInfo)((List)localObject).get(0)).str_wording.get();
          if ((!TextUtils.isEmpty(str)) && (!TextUtils.isEmpty((CharSequence)localObject))) {
            return 3;
          }
        }
      }
    }
    if ((paramArticleInfo.mGroupId == -1L) && (paramArticleInfo.hasChannelInfo()) && (this.c != 0) && ((this.jdField_a_of_type_AndroidContentContext instanceof BaseActivity)) && (this.jdField_a_of_type_Int == 0)) {
      return 1;
    }
    return 0;
  }
  
  public int a()
  {
    return this.c;
  }
  
  public ArticleInfo a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
  }
  
  public ReadInJoyBaseAdapter a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter;
  }
  
  public boolean a()
  {
    boolean bool2 = true;
    boolean bool1;
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo == null) {
      bool1 = false;
    }
    do
    {
      do
      {
        do
        {
          return bool1;
          bool1 = bool2;
        } while (c() == 3);
        if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mGroupId == -1L) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mFeedIndexInGroup != 0L) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mGroupCount <= 0L)) {
          break;
        }
        bool1 = bool2;
      } while (c() == 1);
      bool1 = bool2;
    } while (c() == 2);
    return false;
  }
  
  public int b()
  {
    if (this.jdField_b_of_type_Int == this.e - 1) {
      return 71;
    }
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter.getItemViewType(this.jdField_b_of_type_Int + 1);
  }
  
  public boolean b()
  {
    return d() != 0;
  }
  
  public int c()
  {
    return UtilsForComponent.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
  }
  
  public boolean c()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo == null) {}
    while ((b()) || (d()) || (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mArticleFriendLikeText))) {
      return false;
    }
    return true;
  }
  
  public int d()
  {
    return a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
  }
  
  public boolean d()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo == null) {}
    while ((b()) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mCommentsObj == null) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mCommentsObj.size() <= 0)) {
      return false;
    }
    return true;
  }
  
  public int e()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public boolean e()
  {
    if (this.d == 7) {}
    while (((this.d == 3) && (!ReadInJoyUtils.f(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo))) || (g()) || (this.jdField_b_of_type_Int == this.e - 1)) {
      return false;
    }
    return true;
  }
  
  public int f()
  {
    return this.e;
  }
  
  public boolean f()
  {
    return d();
  }
  
  public boolean g()
  {
    if (this.d == 7) {}
    BaseArticleInfo localBaseArticleInfo;
    do
    {
      return false;
      localBaseArticleInfo = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter.a(this.jdField_a_of_type_Int);
    } while ((!this.jdField_a_of_type_Boolean) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo == null) || (localBaseArticleInfo == null) || (this.jdField_b_of_type_Int <= 0));
    if (ReadInJoyUtils.e(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo))
    {
      Iterator localIterator = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mGroupSubArticleList.iterator();
      while (localIterator.hasNext()) {
        if ((BaseArticleInfo)localIterator.next() == localBaseArticleInfo) {
          return true;
        }
      }
    }
    if (localBaseArticleInfo == this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public boolean h()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo == null) {}
    while ((!ReadInJoyHelper.a(this.d)) && ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mGroupId == -1L) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mGroupCount <= 0L) || ((c() != 1) && (c() != 2))) && (!UtilsForComponent.b(a()))) {
      return false;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.model.ReadInJoyModelImpl
 * JD-Core Version:    0.7.0.1
 */