package com.tencent.biz.pubaccount.readinjoy.view.fastweb.util;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.ArticleTopicData.TopicInfo;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.TitleData;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import mmn;
import mmo;
import tencent.im.oidb.cmd0xad6.oidb_cmd0xad6.Article;
import tencent.im.oidb.cmd0xad6.oidb_cmd0xad6.ArticleCommonInfo;
import tencent.im.oidb.cmd0xad6.oidb_cmd0xad6.ArticleExtInfo;
import tencent.im.oidb.cmd0xad6.oidb_cmd0xad6.RspArticle;
import tencent.im.oidb.cmd0xad6.oidb_cmd0xad6.RspBody;

public class FastWebArticleInfo
  implements Parcelable
{
  public static final Parcelable.Creator CREATOR = new mmn();
  public int a;
  public long a;
  public String a;
  public List a;
  public boolean a;
  public long b;
  public String b;
  public boolean b;
  public long c;
  public String c;
  public String d;
  public String e;
  public String f;
  public String g;
  public String h;
  public String i;
  public String j;
  public String k;
  public String l;
  
  public TitleData a(ArticleInfo paramArticleInfo)
  {
    TitleData localTitleData = new TitleData();
    if (c())
    {
      localTitleData.jdField_c_of_type_JavaLangString = paramArticleInfo.mSubscribeName;
      localTitleData.jdField_b_of_type_JavaLangString = "";
    }
    for (;;)
    {
      localTitleData.jdField_a_of_type_JavaLangString = this.jdField_c_of_type_JavaLangString;
      localTitleData.d = this.f;
      localTitleData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = paramArticleInfo;
      localTitleData.jdField_a_of_type_Long = this.jdField_a_of_type_Long;
      return localTitleData;
      localTitleData.jdField_c_of_type_JavaLangString = this.e;
      localTitleData.jdField_b_of_type_JavaLangString = this.g;
      localTitleData.e = this.h;
    }
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    this.jdField_b_of_type_Long = paramLong1;
    this.jdField_a_of_type_Long = paramLong2;
  }
  
  public void a(ArticleInfo paramArticleInfo)
  {
    ThreadManager.executeOnNetWorkThread(new mmo(this, paramArticleInfo));
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
  
  public boolean a()
  {
    return this.jdField_b_of_type_Boolean;
  }
  
  public boolean a(oidb_cmd0xad6.RspBody paramRspBody, int paramInt)
  {
    try
    {
      Object localObject = (oidb_cmd0xad6.Article)((oidb_cmd0xad6.RspArticle)paramRspBody.msg_rsp_article.get()).msg_article.get();
      paramRspBody = (oidb_cmd0xad6.ArticleExtInfo)paramRspBody.msg_ext_info.get();
      this.jdField_a_of_type_JavaLangString = ((oidb_cmd0xad6.Article)localObject).bytes_html.get().toStringUtf8();
      localObject = (oidb_cmd0xad6.ArticleCommonInfo)((oidb_cmd0xad6.Article)localObject).msg_article_common.get();
      this.jdField_c_of_type_JavaLangString = ((oidb_cmd0xad6.ArticleCommonInfo)localObject).bytes_title.get().toStringUtf8();
      this.d = ((oidb_cmd0xad6.ArticleCommonInfo)localObject).bytes_desc.get().toStringUtf8();
      this.e = ((oidb_cmd0xad6.ArticleCommonInfo)localObject).bytes_account_name.get().toStringUtf8();
      this.g = ((oidb_cmd0xad6.ArticleCommonInfo)localObject).bytes_account_icon.get().toStringUtf8();
      this.h = ((oidb_cmd0xad6.ArticleCommonInfo)localObject).bytes_account_author.get().toStringUtf8();
      this.f = ((oidb_cmd0xad6.ArticleCommonInfo)localObject).bytes_date.get().toStringUtf8();
      this.i = ((oidb_cmd0xad6.ArticleCommonInfo)localObject).bytes_share_words.get().toStringUtf8();
      this.j = ((oidb_cmd0xad6.ArticleCommonInfo)localObject).bytes_row_key.get().toStringUtf8();
      this.jdField_a_of_type_Int = ((oidb_cmd0xad6.ArticleCommonInfo)localObject).uint32_article_flag.get();
      this.k = ((oidb_cmd0xad6.ArticleCommonInfo)localObject).bytes_tags.get().toStringUtf8();
      this.l = ((oidb_cmd0xad6.ArticleCommonInfo)localObject).bytes_article_id.get().toStringUtf8();
      this.jdField_c_of_type_Long = ((oidb_cmd0xad6.ArticleCommonInfo)localObject).uint64_public_uin.get();
      this.jdField_a_of_type_Long = paramRspBody.uint64_read_count.get();
      this.jdField_b_of_type_Long = paramRspBody.uint64_comment.get();
      this.jdField_b_of_type_JavaLangString = paramRspBody.bytes_comment_url.get().toStringUtf8();
      if (paramInt == 3) {}
      for (this.jdField_a_of_type_Boolean = true;; this.jdField_a_of_type_Boolean = false)
      {
        this.jdField_b_of_type_Boolean = false;
        return true;
      }
      return false;
    }
    catch (Exception paramRspBody)
    {
      paramRspBody.printStackTrace();
      QLog.d("Q.readinjoy.fast_web", 2, "parse server resp value error : " + paramRspBody);
    }
  }
  
  public boolean b()
  {
    return (this.jdField_a_of_type_Int & 0x1) == 0;
  }
  
  public boolean c()
  {
    return (this.jdField_a_of_type_Int & 0x2) != 0;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder1 = new StringBuilder(1024);
    localStringBuilder1.append("rowKey : ").append(this.j).append("\n");
    localStringBuilder1.append("title : ").append(this.jdField_c_of_type_JavaLangString).append("\n");
    localStringBuilder1.append("desc : ").append(this.d).append("\n");
    localStringBuilder1.append("accountName : ").append(this.e).append("\n");
    localStringBuilder1.append("accoountAuthor : ").append(this.h).append("\n");
    localStringBuilder1.append("publicTime : ").append(this.f).append("\n");
    localStringBuilder1.append("accountIcon : ").append(this.g).append("\n");
    localStringBuilder1.append("commentCnt : ").append(this.jdField_b_of_type_Long).append("\n");
    localStringBuilder1.append("commentUrl : ").append(this.jdField_b_of_type_JavaLangString).append("\n");
    localStringBuilder1.append("shareWord : ").append(this.i).append("\n");
    localStringBuilder1.append("readCnt : ").append(this.jdField_a_of_type_Long).append("\n");
    localStringBuilder1.append("flag : ").append(this.jdField_a_of_type_Int).append("\n");
    localStringBuilder1.append("tags : ").append(this.k).append("\n");
    localStringBuilder1.append("content : ").append(this.jdField_a_of_type_JavaLangString).append("\n");
    StringBuilder localStringBuilder2 = localStringBuilder1.append("isFavorite : ");
    if (this.jdField_b_of_type_Boolean) {}
    for (int m = 1;; m = 0)
    {
      localStringBuilder2.append(m).append("\n");
      return localStringBuilder1.toString();
    }
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int m = 1;
    paramParcel.writeString(this.jdField_a_of_type_JavaLangString);
    paramParcel.writeLong(this.jdField_a_of_type_Long);
    paramParcel.writeLong(this.jdField_b_of_type_Long);
    paramParcel.writeString(this.jdField_b_of_type_JavaLangString);
    paramParcel.writeString(this.jdField_c_of_type_JavaLangString);
    paramParcel.writeString(this.d);
    paramParcel.writeString(this.e);
    paramParcel.writeString(this.f);
    paramParcel.writeString(this.h);
    paramParcel.writeString(this.g);
    paramParcel.writeString(this.j);
    paramParcel.writeString(this.i);
    paramParcel.writeInt(this.jdField_a_of_type_Int);
    paramParcel.writeString(this.k);
    if (this.jdField_a_of_type_Boolean)
    {
      paramInt = 1;
      paramParcel.writeInt(paramInt);
      paramParcel.writeString(this.l);
      paramParcel.writeLong(this.jdField_c_of_type_Long);
      if (!this.jdField_b_of_type_Boolean) {
        break label246;
      }
    }
    label246:
    for (paramInt = m;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      if (this.jdField_a_of_type_JavaUtilList == null) {
        break label251;
      }
      paramParcel.writeInt(this.jdField_a_of_type_JavaUtilList.size());
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        ArticleTopicData.TopicInfo localTopicInfo = (ArticleTopicData.TopicInfo)localIterator.next();
        paramParcel.writeString(localTopicInfo.jdField_a_of_type_JavaLangString);
        paramParcel.writeLong(localTopicInfo.jdField_a_of_type_Long);
        paramParcel.writeString(localTopicInfo.jdField_b_of_type_JavaLangString);
      }
      paramInt = 0;
      break;
    }
    label251:
    paramParcel.writeInt(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.FastWebArticleInfo
 * JD-Core Version:    0.7.0.1
 */