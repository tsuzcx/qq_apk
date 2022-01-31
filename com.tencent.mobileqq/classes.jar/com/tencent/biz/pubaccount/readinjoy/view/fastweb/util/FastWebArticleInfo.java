package com.tencent.biz.pubaccount.readinjoy.view.fastweb.util;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.FusionBiuInfo;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.AuthorData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.BaseData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.ProteusBookData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.RelatedSearchData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.TitleData;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;
import osg;
import paf;
import rjw;
import rka;
import rmi;
import rnn;
import tencent.im.oidb.cmd0xad6.oidb_cmd0xad6.Article;
import tencent.im.oidb.cmd0xad6.oidb_cmd0xad6.ArticleCommonInfo;
import tencent.im.oidb.cmd0xad6.oidb_cmd0xad6.ArticleCover;
import tencent.im.oidb.cmd0xad6.oidb_cmd0xad6.ArticleExtInfo;
import tencent.im.oidb.cmd0xad6.oidb_cmd0xad6.RspArticle;
import tencent.im.oidb.cmd0xad6.oidb_cmd0xad6.RspBody;

public class FastWebArticleInfo
  implements Parcelable
{
  public static final Parcelable.Creator<FastWebArticleInfo> CREATOR = new rmi();
  public int a;
  public long a;
  public SparseArray<rnn> a;
  public FusionBiuInfo a;
  public RelatedSearchData a;
  public String a;
  public List<rjw> a;
  private Map<String, JSONObject> a;
  public boolean a;
  public int b;
  public long b;
  public String b;
  private List<String> b;
  public boolean b;
  public int c;
  public long c;
  public String c;
  public boolean c;
  public long d;
  public String d;
  public String e;
  public String f;
  public String g;
  public String h;
  public String i;
  public String j;
  public String k;
  public String l;
  public String m;
  public String n;
  public String o;
  public String p = "";
  public String q;
  public String r;
  
  public FastWebArticleInfo()
  {
    this.jdField_b_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    this.jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  }
  
  /* Error */
  private byte[] a(byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: invokestatic 81	java/lang/System:currentTimeMillis	()J
    //   5: lstore 4
    //   7: new 83	java/io/ByteArrayInputStream
    //   10: dup
    //   11: aload_1
    //   12: invokespecial 86	java/io/ByteArrayInputStream:<init>	([B)V
    //   15: astore 7
    //   17: new 88	java/io/ByteArrayOutputStream
    //   20: dup
    //   21: invokespecial 89	java/io/ByteArrayOutputStream:<init>	()V
    //   24: astore 6
    //   26: new 91	java/util/zip/GZIPInputStream
    //   29: dup
    //   30: aload 7
    //   32: invokespecial 94	java/util/zip/GZIPInputStream:<init>	(Ljava/io/InputStream;)V
    //   35: astore 7
    //   37: sipush 1024
    //   40: newarray byte
    //   42: astore 8
    //   44: aload 7
    //   46: aload 8
    //   48: invokevirtual 98	java/util/zip/GZIPInputStream:read	([B)I
    //   51: istore_2
    //   52: iload_2
    //   53: iconst_m1
    //   54: if_icmpeq +170 -> 224
    //   57: aload 6
    //   59: aload 8
    //   61: iconst_0
    //   62: iload_2
    //   63: invokevirtual 102	java/io/ByteArrayOutputStream:write	([BII)V
    //   66: goto -22 -> 44
    //   69: astore 6
    //   71: aload 6
    //   73: invokevirtual 105	java/io/IOException:printStackTrace	()V
    //   76: iconst_0
    //   77: newarray byte
    //   79: astore 6
    //   81: invokestatic 81	java/lang/System:currentTimeMillis	()J
    //   84: lload 4
    //   86: lsub
    //   87: lstore 4
    //   89: new 58	java/util/HashMap
    //   92: dup
    //   93: invokespecial 59	java/util/HashMap:<init>	()V
    //   96: astore 7
    //   98: aload 7
    //   100: ldc 107
    //   102: invokestatic 112	onh:a	()Ljava/lang/String;
    //   105: invokevirtual 116	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   108: pop
    //   109: aload 7
    //   111: ldc 118
    //   113: aload_0
    //   114: getfield 120	com/tencent/biz/pubaccount/readinjoy/view/fastweb/util/FastWebArticleInfo:j	Ljava/lang/String;
    //   117: invokevirtual 116	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   120: pop
    //   121: aload 7
    //   123: ldc 122
    //   125: new 124	java/lang/StringBuilder
    //   128: dup
    //   129: invokespecial 125	java/lang/StringBuilder:<init>	()V
    //   132: lload 4
    //   134: invokevirtual 129	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   137: ldc 63
    //   139: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   142: invokevirtual 135	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   145: invokevirtual 116	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   148: pop
    //   149: aload 7
    //   151: ldc 137
    //   153: ldc 139
    //   155: iconst_1
    //   156: anewarray 4	java/lang/Object
    //   159: dup
    //   160: iconst_0
    //   161: aload_1
    //   162: arraylength
    //   163: i2d
    //   164: ldc2_w 140
    //   167: dmul
    //   168: aload 6
    //   170: arraylength
    //   171: i2d
    //   172: ddiv
    //   173: invokestatic 147	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   176: aastore
    //   177: invokestatic 153	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   180: invokevirtual 116	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   183: pop
    //   184: iload_3
    //   185: ifeq +66 -> 251
    //   188: iconst_1
    //   189: istore_2
    //   190: aload 7
    //   192: ldc 155
    //   194: iload_2
    //   195: invokestatic 158	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   198: invokevirtual 116	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   201: pop
    //   202: invokestatic 164	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   205: invokestatic 169	axrn:a	(Landroid/content/Context;)Laxrn;
    //   208: aconst_null
    //   209: ldc 171
    //   211: iload_3
    //   212: lload 4
    //   214: lconst_0
    //   215: aload 7
    //   217: aconst_null
    //   218: invokevirtual 174	axrn:a	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;)V
    //   221: aload 6
    //   223: areturn
    //   224: aload 6
    //   226: invokevirtual 178	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   229: astore 6
    //   231: iconst_1
    //   232: istore_3
    //   233: goto -152 -> 81
    //   236: astore 6
    //   238: aload 6
    //   240: invokevirtual 179	java/lang/Throwable:printStackTrace	()V
    //   243: iconst_0
    //   244: newarray byte
    //   246: astore 6
    //   248: goto -167 -> 81
    //   251: iconst_0
    //   252: istore_2
    //   253: goto -63 -> 190
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	256	0	this	FastWebArticleInfo
    //   0	256	1	paramArrayOfByte	byte[]
    //   51	202	2	i1	int
    //   1	232	3	bool	boolean
    //   5	208	4	l1	long
    //   24	34	6	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    //   69	3	6	localIOException	java.io.IOException
    //   79	151	6	arrayOfByte1	byte[]
    //   236	3	6	localThrowable	java.lang.Throwable
    //   246	1	6	arrayOfByte2	byte[]
    //   15	201	7	localObject	Object
    //   42	18	8	arrayOfByte3	byte[]
    // Exception table:
    //   from	to	target	type
    //   7	44	69	java/io/IOException
    //   44	52	69	java/io/IOException
    //   57	66	69	java/io/IOException
    //   224	231	69	java/io/IOException
    //   7	44	236	java/lang/Throwable
    //   44	52	236	java/lang/Throwable
    //   57	66	236	java/lang/Throwable
    //   224	231	236	java/lang/Throwable
  }
  
  public AuthorData a(ArticleInfo paramArticleInfo, FastWebArticleInfo paramFastWebArticleInfo)
  {
    AuthorData localAuthorData = new AuthorData(paramArticleInfo, paramFastWebArticleInfo);
    if (c())
    {
      localAuthorData.jdField_b_of_type_JavaLangString = paramArticleInfo.mSubscribeName;
      localAuthorData.jdField_c_of_type_JavaLangString = paramArticleInfo.getSubscribeUin();
      localAuthorData.jdField_a_of_type_JavaLangString = "";
      if (TextUtils.isEmpty(localAuthorData.jdField_b_of_type_JavaLangString))
      {
        if (!TextUtils.isEmpty(this.e)) {
          break label127;
        }
        paramFastWebArticleInfo = this.h;
        localAuthorData.jdField_b_of_type_JavaLangString = paramFastWebArticleInfo;
        paramArticleInfo.mSubscribeName = localAuthorData.jdField_b_of_type_JavaLangString;
      }
    }
    for (;;)
    {
      localAuthorData.jdField_d_of_type_JavaLangString = this.f;
      localAuthorData.jdField_a_of_type_Long = this.jdField_a_of_type_Long;
      localAuthorData.jdField_a_of_type_Boolean = osg.a().a(paramArticleInfo.getSubscribeUin());
      localAuthorData.V = this.q;
      localAuthorData.t = 1;
      localAuthorData.jdField_b_of_type_Float = 1.0F;
      return localAuthorData;
      label127:
      paramFastWebArticleInfo = this.e;
      break;
      localAuthorData.jdField_b_of_type_JavaLangString = this.e;
      localAuthorData.jdField_c_of_type_JavaLangString = paramArticleInfo.getSubscribeUin();
      localAuthorData.jdField_a_of_type_JavaLangString = this.g;
      localAuthorData.e = this.h;
    }
  }
  
  public TitleData a(ArticleInfo paramArticleInfo)
  {
    TitleData localTitleData = new TitleData();
    localTitleData.jdField_a_of_type_JavaLangString = this.jdField_c_of_type_JavaLangString;
    localTitleData.b = paramArticleInfo;
    localTitleData.V = this.q;
    localTitleData.t = 1;
    localTitleData.s = 1;
    return localTitleData;
  }
  
  public List<String> a()
  {
    return this.jdField_b_of_type_JavaUtilList;
  }
  
  public JSONObject a(String paramString)
  {
    return (JSONObject)this.jdField_a_of_type_JavaUtilMap.get(paramString);
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    this.jdField_b_of_type_Long = paramLong1;
    this.jdField_a_of_type_Long = paramLong2;
  }
  
  public void a(ArticleInfo paramArticleInfo)
  {
    ThreadManager.executeOnNetWorkThread(new FastWebArticleInfo.2(this, paramArticleInfo));
  }
  
  public void a(String paramString, JSONObject paramJSONObject)
  {
    this.jdField_a_of_type_JavaUtilMap.put(paramString, paramJSONObject);
  }
  
  public void a(List<BaseData> paramList)
  {
    if (paramList != null)
    {
      this.jdField_b_of_type_JavaUtilList.clear();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        Object localObject = (BaseData)paramList.next();
        if (((BaseData)localObject).p == 18)
        {
          localObject = (ProteusBookData)localObject;
          if (((ProteusBookData)localObject).jdField_b_of_type_JavaLangString != null) {
            this.jdField_b_of_type_JavaUtilList.add(((ProteusBookData)localObject).jdField_b_of_type_JavaLangString);
          }
        }
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_c_of_type_Boolean = paramBoolean;
  }
  
  public boolean a()
  {
    return this.jdField_c_of_type_Boolean;
  }
  
  public boolean a(oidb_cmd0xad6.RspBody paramRspBody, int paramInt)
  {
    for (;;)
    {
      try
      {
        Object localObject = (oidb_cmd0xad6.Article)((oidb_cmd0xad6.RspArticle)paramRspBody.msg_rsp_article.get()).msg_article.get();
        oidb_cmd0xad6.ArticleCommonInfo localArticleCommonInfo = (oidb_cmd0xad6.ArticleCommonInfo)((oidb_cmd0xad6.Article)localObject).msg_article_common.get();
        this.jdField_c_of_type_JavaLangString = localArticleCommonInfo.bytes_title.get().toStringUtf8();
        this.jdField_d_of_type_JavaLangString = localArticleCommonInfo.bytes_desc.get().toStringUtf8();
        this.e = localArticleCommonInfo.bytes_account_name.get().toStringUtf8();
        this.g = localArticleCommonInfo.bytes_account_icon.get().toStringUtf8();
        this.h = localArticleCommonInfo.bytes_account_author.get().toStringUtf8();
        this.f = localArticleCommonInfo.bytes_date.get().toStringUtf8();
        this.i = localArticleCommonInfo.bytes_share_words.get().toStringUtf8();
        this.j = localArticleCommonInfo.bytes_row_key.get().toStringUtf8();
        this.jdField_b_of_type_Int = localArticleCommonInfo.uint32_article_flag.get();
        this.l = localArticleCommonInfo.bytes_tags.get().toStringUtf8();
        this.o = localArticleCommonInfo.bytes_article_id.get().toStringUtf8();
        this.jdField_d_of_type_Long = localArticleCommonInfo.uint64_public_uin.get();
        this.q = localArticleCommonInfo.bytes_proteus_json_data.get().toStringUtf8();
        if ((localArticleCommonInfo.msg_cover.has()) && (((oidb_cmd0xad6.ArticleCover)localArticleCommonInfo.msg_cover.get()).bytes_cover_url.has())) {
          this.r = ((oidb_cmd0xad6.ArticleCover)localArticleCommonInfo.msg_cover.get()).bytes_cover_url.get().toStringUtf8();
        }
        if (localArticleCommonInfo.bytes_original_url.has()) {
          this.k = localArticleCommonInfo.bytes_original_url.get().toStringUtf8();
        }
        paramRspBody = (oidb_cmd0xad6.ArticleExtInfo)paramRspBody.msg_ext_info.get();
        if (((oidb_cmd0xad6.Article)localObject).uint32_zip.get() == 1)
        {
          localObject = a(((oidb_cmd0xad6.Article)localObject).bytes_html.get().toByteArray());
          if (localObject.length > 0)
          {
            this.jdField_a_of_type_JavaLangString = new String((byte[])localObject, "UTF-8");
            this.jdField_a_of_type_Long = paramRspBody.uint64_read_count.get();
            this.jdField_b_of_type_Long = paramRspBody.uint64_comment.get();
            this.jdField_b_of_type_JavaLangString = paramRspBody.bytes_comment_url.get().toStringUtf8();
            if (paramInt == 3)
            {
              this.jdField_b_of_type_Boolean = true;
              this.jdField_c_of_type_Boolean = false;
              return true;
            }
          }
          else
          {
            QLog.d(paf.jdField_a_of_type_JavaLangString, 1, "uncompress article content data error !");
            return false;
          }
        }
        else
        {
          this.jdField_a_of_type_JavaLangString = ((oidb_cmd0xad6.Article)localObject).bytes_html.get().toStringUtf8();
          continue;
        }
        this.jdField_b_of_type_Boolean = false;
      }
      catch (Exception paramRspBody)
      {
        paramRspBody.printStackTrace();
        QLog.d("Q.readinjoy.fast_web", 2, "parse server resp value error : " + paramRspBody);
        return false;
      }
    }
  }
  
  public boolean b()
  {
    return (this.jdField_b_of_type_Int & 0x1) == 0;
  }
  
  public boolean c()
  {
    return (this.jdField_b_of_type_Int & 0x2) != 0;
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
    localStringBuilder1.append("desc : ").append(this.jdField_d_of_type_JavaLangString).append("\n");
    localStringBuilder1.append("accountName : ").append(this.e).append("\n");
    localStringBuilder1.append("accoountAuthor : ").append(this.h).append("\n");
    localStringBuilder1.append("publicTime : ").append(this.f).append("\n");
    localStringBuilder1.append("accountIcon : ").append(this.g).append("\n");
    localStringBuilder1.append("commentCnt : ").append(this.jdField_b_of_type_Long).append("\n");
    localStringBuilder1.append("commentUrl : ").append(this.jdField_b_of_type_JavaLangString).append("\n");
    localStringBuilder1.append("shareWord : ").append(this.i).append("\n");
    localStringBuilder1.append("readCnt : ").append(this.jdField_a_of_type_Long).append("\n");
    localStringBuilder1.append("flag : ").append(this.jdField_b_of_type_Int).append("\n");
    localStringBuilder1.append("tags : ").append(this.l).append("\n");
    localStringBuilder1.append("content : ").append(this.jdField_a_of_type_JavaLangString).append("\n");
    StringBuilder localStringBuilder2 = localStringBuilder1.append("isFavorite : ");
    if (this.jdField_c_of_type_Boolean) {}
    for (int i1 = 1;; i1 = 0)
    {
      localStringBuilder2.append(i1).append("\n");
      localStringBuilder1.append("cashFlag : ").append(this.jdField_c_of_type_Int).append("\n");
      localStringBuilder1.append("cashInfo : ").append(this.p).append("\n");
      localStringBuilder1.append("proteusJsonData : ").append(this.q).append("\n");
      return localStringBuilder1.toString();
    }
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i1 = 1;
    paramParcel.writeString(this.jdField_a_of_type_JavaLangString);
    paramParcel.writeLong(this.jdField_a_of_type_Long);
    paramParcel.writeLong(this.jdField_b_of_type_Long);
    paramParcel.writeString(this.jdField_b_of_type_JavaLangString);
    paramParcel.writeString(this.jdField_c_of_type_JavaLangString);
    paramParcel.writeString(this.jdField_d_of_type_JavaLangString);
    paramParcel.writeString(this.e);
    paramParcel.writeString(this.f);
    paramParcel.writeString(this.h);
    paramParcel.writeString(this.g);
    paramParcel.writeString(this.j);
    paramParcel.writeString(this.i);
    paramParcel.writeInt(this.jdField_b_of_type_Int);
    paramParcel.writeString(this.l);
    if (this.jdField_b_of_type_Boolean)
    {
      paramInt = 1;
      paramParcel.writeInt(paramInt);
      paramParcel.writeString(this.o);
      paramParcel.writeLong(this.jdField_d_of_type_Long);
      if (!this.jdField_c_of_type_Boolean) {
        break label254;
      }
    }
    Iterator localIterator;
    Object localObject;
    label254:
    for (paramInt = i1;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      paramParcel.writeString(this.q);
      if (this.jdField_a_of_type_JavaUtilList == null) {
        break label259;
      }
      paramParcel.writeInt(this.jdField_a_of_type_JavaUtilList.size());
      localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        localObject = (rjw)localIterator.next();
        paramParcel.writeString(((rjw)localObject).jdField_a_of_type_JavaLangString);
        paramParcel.writeLong(((rjw)localObject).jdField_a_of_type_Long);
        paramParcel.writeString(((rjw)localObject).jdField_b_of_type_JavaLangString);
      }
      paramInt = 0;
      break;
    }
    label259:
    paramParcel.writeInt(0);
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataRelatedSearchData != null) {
      if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataRelatedSearchData.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataRelatedSearchData.jdField_a_of_type_JavaUtilList.size() > 0))
      {
        paramParcel.writeInt(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataRelatedSearchData.jdField_a_of_type_JavaUtilList.size());
        localIterator = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataRelatedSearchData.jdField_a_of_type_JavaUtilList.iterator();
        while (localIterator.hasNext())
        {
          localObject = (rka)localIterator.next();
          paramParcel.writeString(((rka)localObject).jdField_a_of_type_JavaLangString);
          paramParcel.writeString(((rka)localObject).jdField_b_of_type_JavaLangString);
          paramParcel.writeFloat(((rka)localObject).jdField_a_of_type_Float);
          paramParcel.writeString(((rka)localObject).jdField_c_of_type_JavaLangString);
          paramParcel.writeInt(((rka)localObject).jdField_a_of_type_Int);
        }
        paramParcel.writeString(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataRelatedSearchData.jdField_a_of_type_JavaLangString);
      }
    }
    for (;;)
    {
      paramParcel.writeInt(this.jdField_c_of_type_Int);
      paramParcel.writeString(this.p);
      return;
      paramParcel.writeInt(0);
      continue;
      paramParcel.writeInt(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.FastWebArticleInfo
 * JD-Core Version:    0.7.0.1
 */