package com.tencent.biz.pubaccount.readinjoy.rebuild.cmp;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;

public class ComponentContentPgcVideo
  extends ComponentContentBigImageVideo
{
  public ComponentContentPgcVideo(Context paramContext)
  {
    super(paramContext);
  }
  
  public ComponentContentPgcVideo(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public ComponentContentPgcVideo(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public View a(Context paramContext)
  {
    return LayoutInflater.from(paramContext).inflate(2130969570, this, true);
  }
  
  /* Error */
  public void b()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: aload_0
    //   3: getfield 35	com/tencent/biz/pubaccount/readinjoy/rebuild/cmp/ComponentContentPgcVideo:jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt	Lcom/tencent/biz/pubaccount/readinjoy/rebuild/cmp/CmpCtxt;
    //   6: getfield 40	com/tencent/biz/pubaccount/readinjoy/rebuild/cmp/CmpCtxt:a	Lcom/tencent/biz/pubaccount/readinjoy/model/IReadInJoyModel;
    //   9: ifnull +247 -> 256
    //   12: aload_0
    //   13: getfield 35	com/tencent/biz/pubaccount/readinjoy/rebuild/cmp/ComponentContentPgcVideo:jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt	Lcom/tencent/biz/pubaccount/readinjoy/rebuild/cmp/CmpCtxt;
    //   16: getfield 40	com/tencent/biz/pubaccount/readinjoy/rebuild/cmp/CmpCtxt:a	Lcom/tencent/biz/pubaccount/readinjoy/model/IReadInJoyModel;
    //   19: invokeinterface 45 1 0
    //   24: ifnull +232 -> 256
    //   27: aload_0
    //   28: getfield 35	com/tencent/biz/pubaccount/readinjoy/rebuild/cmp/ComponentContentPgcVideo:jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt	Lcom/tencent/biz/pubaccount/readinjoy/rebuild/cmp/CmpCtxt;
    //   31: getfield 40	com/tencent/biz/pubaccount/readinjoy/rebuild/cmp/CmpCtxt:a	Lcom/tencent/biz/pubaccount/readinjoy/model/IReadInJoyModel;
    //   34: invokeinterface 45 1 0
    //   39: astore 6
    //   41: aload 6
    //   43: ifnull +213 -> 256
    //   46: aload 6
    //   48: getfield 51	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mJsonVideoList	Ljava/lang/String;
    //   51: invokestatic 57	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   54: ifne +202 -> 256
    //   57: new 59	org/json/JSONObject
    //   60: dup
    //   61: aload 6
    //   63: getfield 51	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mJsonVideoList	Ljava/lang/String;
    //   66: invokespecial 62	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   69: ldc 64
    //   71: invokevirtual 68	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   74: astore 6
    //   76: aload 6
    //   78: ifnull +233 -> 311
    //   81: aload 6
    //   83: invokevirtual 74	org/json/JSONArray:length	()I
    //   86: ifle +225 -> 311
    //   89: aload 6
    //   91: iconst_0
    //   92: invokevirtual 78	org/json/JSONArray:optJSONObject	(I)Lorg/json/JSONObject;
    //   95: astore 6
    //   97: aload 6
    //   99: ifnull +212 -> 311
    //   102: aload 6
    //   104: ldc 80
    //   106: invokevirtual 84	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   109: istore_1
    //   110: aload 6
    //   112: ldc 86
    //   114: invokevirtual 84	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   117: istore_2
    //   118: iload_2
    //   119: ifeq +137 -> 256
    //   122: iload_1
    //   123: ifeq +133 -> 256
    //   126: aload_0
    //   127: invokevirtual 90	com/tencent/biz/pubaccount/readinjoy/rebuild/cmp/ComponentContentPgcVideo:getLayoutParams	()Landroid/view/ViewGroup$LayoutParams;
    //   130: astore 6
    //   132: aload_0
    //   133: invokevirtual 94	com/tencent/biz/pubaccount/readinjoy/rebuild/cmp/ComponentContentPgcVideo:getResources	()Landroid/content/res/Resources;
    //   136: invokevirtual 100	android/content/res/Resources:getDisplayMetrics	()Landroid/util/DisplayMetrics;
    //   139: astore 7
    //   141: aload 7
    //   143: getfield 106	android/util/DisplayMetrics:widthPixels	I
    //   146: aload 7
    //   148: getfield 109	android/util/DisplayMetrics:heightPixels	I
    //   151: invokestatic 115	java/lang/Math:min	(II)I
    //   154: istore 4
    //   156: ldc 116
    //   158: aload_0
    //   159: invokevirtual 94	com/tencent/biz/pubaccount/readinjoy/rebuild/cmp/ComponentContentPgcVideo:getResources	()Landroid/content/res/Resources;
    //   162: invokestatic 121	com/tencent/mobileqq/activity/aio/AIOUtils:a	(FLandroid/content/res/Resources;)I
    //   165: istore 5
    //   167: aload_0
    //   168: getfield 124	com/tencent/biz/pubaccount/readinjoy/rebuild/cmp/ComponentContentPgcVideo:jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView	Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;
    //   171: invokevirtual 127	com/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView:getLayoutParams	()Landroid/view/ViewGroup$LayoutParams;
    //   174: astore 7
    //   176: iload_2
    //   177: iconst_4
    //   178: imul
    //   179: iload_1
    //   180: iconst_3
    //   181: imul
    //   182: if_icmple +5 -> 187
    //   185: iconst_1
    //   186: istore_3
    //   187: iload_3
    //   188: ifeq +90 -> 278
    //   191: iload 4
    //   193: iload 5
    //   195: iconst_2
    //   196: imul
    //   197: isub
    //   198: istore_2
    //   199: iload_2
    //   200: bipush 9
    //   202: imul
    //   203: bipush 16
    //   205: idiv
    //   206: istore_1
    //   207: aload 7
    //   209: iload_2
    //   210: putfield 131	android/view/ViewGroup$LayoutParams:width	I
    //   213: aload 7
    //   215: iload_1
    //   216: putfield 133	android/view/ViewGroup$LayoutParams:height	I
    //   219: aload 6
    //   221: iload_2
    //   222: putfield 131	android/view/ViewGroup$LayoutParams:width	I
    //   225: aload 6
    //   227: iload_1
    //   228: putfield 133	android/view/ViewGroup$LayoutParams:height	I
    //   231: aload_0
    //   232: getfield 124	com/tencent/biz/pubaccount/readinjoy/rebuild/cmp/ComponentContentPgcVideo:jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView	Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;
    //   235: getstatic 139	android/widget/ImageView$ScaleType:CENTER_CROP	Landroid/widget/ImageView$ScaleType;
    //   238: invokevirtual 143	com/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView:setScaleType	(Landroid/widget/ImageView$ScaleType;)V
    //   241: aload_0
    //   242: getfield 124	com/tencent/biz/pubaccount/readinjoy/rebuild/cmp/ComponentContentPgcVideo:jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView	Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;
    //   245: aload 7
    //   247: invokevirtual 147	com/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView:setLayoutParams	(Landroid/view/ViewGroup$LayoutParams;)V
    //   250: aload_0
    //   251: aload 6
    //   253: invokevirtual 148	com/tencent/biz/pubaccount/readinjoy/rebuild/cmp/ComponentContentPgcVideo:setLayoutParams	(Landroid/view/ViewGroup$LayoutParams;)V
    //   256: return
    //   257: astore 6
    //   259: iconst_0
    //   260: istore_1
    //   261: ldc 150
    //   263: iconst_2
    //   264: aload 6
    //   266: iconst_0
    //   267: anewarray 152	java/lang/Object
    //   270: invokestatic 158	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   273: iconst_0
    //   274: istore_2
    //   275: goto -157 -> 118
    //   278: iload 4
    //   280: iload 5
    //   282: iconst_2
    //   283: imul
    //   284: isub
    //   285: bipush 9
    //   287: iadd
    //   288: iconst_2
    //   289: idiv
    //   290: istore_2
    //   291: iload 4
    //   293: iload 5
    //   295: iconst_2
    //   296: imul
    //   297: isub
    //   298: iconst_3
    //   299: idiv
    //   300: iconst_2
    //   301: imul
    //   302: istore_1
    //   303: goto -96 -> 207
    //   306: astore 6
    //   308: goto -47 -> 261
    //   311: iconst_0
    //   312: istore_1
    //   313: iconst_0
    //   314: istore_2
    //   315: goto -197 -> 118
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	318	0	this	ComponentContentPgcVideo
    //   109	204	1	i	int
    //   117	198	2	j	int
    //   1	187	3	k	int
    //   154	144	4	m	int
    //   165	132	5	n	int
    //   39	213	6	localObject1	java.lang.Object
    //   257	8	6	localJSONException1	org.json.JSONException
    //   306	1	6	localJSONException2	org.json.JSONException
    //   139	107	7	localObject2	java.lang.Object
    // Exception table:
    //   from	to	target	type
    //   57	76	257	org/json/JSONException
    //   81	97	257	org/json/JSONException
    //   102	110	257	org/json/JSONException
    //   110	118	306	org/json/JSONException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentContentPgcVideo
 * JD-Core Version:    0.7.0.1
 */