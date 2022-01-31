package com.tencent.biz.qqstory.playvideo.lrtbwidget;

import ajya;
import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import axpu;
import bcql;
import bfnx;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.playvideo.QQStoryVideoPlayerErrorView;
import com.tencent.biz.qqstory.playvideo.entrance.OpenPlayerBuilder.Data;
import com.tencent.biz.qqstory.playvideo.entrance.OpenPlayerBuilder.ReportData;
import com.tencent.biz.qqstory.playvideo.player.TextureVideoView;
import com.tencent.biz.qqstory.view.widget.QQStoryLoadingView;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.async.Boss;
import com.tribe.async.async.Bosses;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.Dispatcher.Dispatchable;
import com.tribe.async.reactive.Stream;
import java.io.File;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import stb;
import stf;
import stl;
import suj;
import tcs;
import tcw;
import tcz;
import tdr;
import teo;
import tep;
import tff;
import tln;
import tsh;
import tsi;
import ttd;
import two;
import uas;
import uay;
import uaz;
import ubb;
import ubc;
import ubd;
import ube;
import ubf;
import ubg;
import ubh;
import ubi;
import ubj;
import ubk;
import ubl;
import ubm;
import ubn;
import ubo;
import ubp;
import ubq;
import ubr;
import ubt;
import ubu;
import ubv;
import ubw;
import ubx;
import uby;
import ubz;
import ucg;
import ucz;
import udf;
import udm;
import ueb;
import uec;
import ued;
import uem;
import ved;
import vei;
import vxp;
import vzl;
import wbw;

public class VideoViewVideoHolder
  extends uaz
  implements View.OnClickListener
{
  public static final SparseArray<int[]> a;
  public static final String[] a;
  private static final String[] jdField_b_of_type_ArrayOfJavaLangString = { "SE", "VI", "DD", "SV", "VD", "SP", "VP", "HC" };
  private long jdField_a_of_type_Long;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  private Button jdField_a_of_type_AndroidWidgetButton;
  public ImageView a;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  public QQStoryVideoPlayerErrorView a;
  public QQStoryLoadingView a;
  public Stream a;
  private Map<String, Long> jdField_a_of_type_JavaUtilMap = new VideoViewVideoHolder.12(this);
  private tln jdField_a_of_type_Tln = new tln();
  private tsi jdField_a_of_type_Tsi;
  public ttd a;
  public ubv a;
  private ucg jdField_a_of_type_Ucg;
  public ucz a;
  private udm jdField_a_of_type_Udm = new udm();
  public wbw a;
  private int[] jdField_a_of_type_ArrayOfInt = new int[6];
  private long jdField_b_of_type_Long;
  private View jdField_b_of_type_AndroidViewView;
  private Button jdField_b_of_type_AndroidWidgetButton;
  public ImageView b;
  public String b;
  public int c;
  private long jdField_c_of_type_Long;
  private Button jdField_c_of_type_AndroidWidgetButton;
  public String c;
  private boolean jdField_c_of_type_Boolean;
  public int d;
  private long jdField_d_of_type_Long;
  private String jdField_d_of_type_JavaLangString;
  private boolean jdField_d_of_type_Boolean;
  private int jdField_e_of_type_Int = 0;
  private String jdField_e_of_type_JavaLangString;
  private boolean jdField_e_of_type_Boolean;
  private int jdField_f_of_type_Int;
  private String jdField_f_of_type_JavaLangString;
  private boolean jdField_f_of_type_Boolean;
  private int g;
  private int h;
  private int i;
  private int j;
  private int k;
  private int l;
  private int m;
  private int n;
  
  static
  {
    jdField_a_of_type_ArrayOfJavaLangString = new String[] { "s_Idle", "s_VideoInfo", "s_VideoInfo_OK", "s_DoodleDown", "s_DoodleDown_OK", "s_VideoFile", "s_VideoFile_OK", "s_Prepare", "s_Prepare_OK", "s_Starting", "s_Playing_OK", "s_Pause", "s_Complete_OK" };
    jdField_a_of_type_AndroidUtilSparseArray = new ubc();
  }
  
  public VideoViewVideoHolder(ViewGroup paramViewGroup)
  {
    super(paramViewGroup);
    this.jdField_a_of_type_Ubv = new ubv(this, null);
    this.jdField_a_of_type_ComTribeAsyncReactiveStream = null;
    this.jdField_b_of_type_JavaLangString = null;
    this.jdField_d_of_type_Int = 3;
    this.jdField_a_of_type_Ttd = new ubf(this);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131364810));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131369812));
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryLoadingView = ((QQStoryLoadingView)paramViewGroup.findViewById(2131369486));
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoQQStoryVideoPlayerErrorView = ((QQStoryVideoPlayerErrorView)paramViewGroup.findViewById(2131379048));
    this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131377024);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131377023));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131377021));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131377025));
    this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_c_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131377022));
    this.jdField_c_of_type_AndroidWidgetButton.setOnClickListener(this);
  }
  
  private void a(long paramLong, String paramString)
  {
    a("HC", SystemClock.uptimeMillis());
    this.jdField_e_of_type_Boolean = true;
    ved.b(this.jdField_a_of_type_JavaLangString, "hideCover, hide loading view");
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryLoadingView.setVisibility(8);
    h();
    ved.d(this.jdField_a_of_type_JavaLangString, "CheckVideoViewRealStartRunnable, %s, currentPosition=%d, outputTimeOutCount=%d", new Object[] { paramString, Long.valueOf(paramLong), Integer.valueOf(ueb.a(a()).a().jdField_a_of_type_Int) });
    this.jdField_f_of_type_JavaLangString = this.jdField_a_of_type_Uas.jdField_a_of_type_JavaLangString;
    k();
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(new VideoViewVideoHolder.11(this), 600L);
    this.jdField_a_of_type_Ucg.c(this, this.jdField_a_of_type_Ucz);
  }
  
  private static void a(@NonNull View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    Object localObject = paramView.getLayoutParams();
    if ((localObject instanceof ViewGroup.MarginLayoutParams))
    {
      localObject = (ViewGroup.MarginLayoutParams)localObject;
      ((ViewGroup.MarginLayoutParams)localObject).width = paramInt1;
      ((ViewGroup.MarginLayoutParams)localObject).height = paramInt2;
      ((ViewGroup.MarginLayoutParams)localObject).leftMargin = paramInt3;
      ((ViewGroup.MarginLayoutParams)localObject).rightMargin = paramInt3;
      ((ViewGroup.MarginLayoutParams)localObject).topMargin = paramInt4;
      ((ViewGroup.MarginLayoutParams)localObject).bottomMargin = paramInt4;
      paramView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
  }
  
  private void a(ErrorMessage paramErrorMessage)
  {
    ved.d(this.jdField_a_of_type_JavaLangString, "onError. %d : %s", new Object[] { Integer.valueOf(paramErrorMessage.errorCode), paramErrorMessage.errorMsg });
    if (paramErrorMessage.errorCode == 0) {
      return;
    }
    switch (paramErrorMessage.errorCode)
    {
    default: 
      return;
    case 2: 
    case 3: 
    case 6: 
    case 8: 
    case 10: 
    case 11: 
    case 12: 
    case 13: 
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoQQStoryVideoPlayerErrorView.setVisibility(0);
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoQQStoryVideoPlayerErrorView.a(1);
      this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryLoadingView.setVisibility(8);
      this.jdField_a_of_type_Ucz.a(8);
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoQQStoryVideoPlayerErrorView.setOnTipsClickListener(new ubp(this, paramErrorMessage));
      return;
    case 4: 
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoQQStoryVideoPlayerErrorView.setVisibility(0);
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoQQStoryVideoPlayerErrorView.setTipsText(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoQQStoryVideoPlayerErrorView.getResources().getString(2131699698));
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoQQStoryVideoPlayerErrorView.setOnTipsClickListener(null);
      this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryLoadingView.setVisibility(8);
      this.jdField_a_of_type_Ucz.a(8);
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      return;
    case 5: 
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoQQStoryVideoPlayerErrorView.setVisibility(8);
      this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryLoadingView.setVisibility(8);
      this.jdField_a_of_type_Ucz.a(8);
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      return;
    case 7: 
    case 14: 
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoQQStoryVideoPlayerErrorView.setVisibility(0);
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoQQStoryVideoPlayerErrorView.a(1);
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoQQStoryVideoPlayerErrorView.setOnTipsClickListener(null);
      this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryLoadingView.setVisibility(8);
      this.jdField_a_of_type_Ucz.a(8);
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoQQStoryVideoPlayerErrorView.setOnTipsClickListener(new ubq(this));
      return;
    }
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoQQStoryVideoPlayerErrorView.setVisibility(0);
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoQQStoryVideoPlayerErrorView.a(1);
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryLoadingView.setVisibility(8);
    this.jdField_a_of_type_Ucz.a(8);
    this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoQQStoryVideoPlayerErrorView.setOnTipsClickListener(new ubd(this));
  }
  
  private void a(@NonNull StoryVideoItem paramStoryVideoItem)
  {
    int i1 = paramStoryVideoItem.mVideoWidth;
    int i2 = paramStoryVideoItem.mVideoHeight;
    if ((TextUtils.equals(this.jdField_d_of_type_JavaLangString, paramStoryVideoItem.mVid)) || ((this.g == i1) && (this.h == i2) && (this.g > 0) && (this.h > 0) && (this.i == paramStoryVideoItem.playerScaleType)))
    {
      this.jdField_d_of_type_JavaLangString = paramStoryVideoItem.mVid;
      return;
    }
    Object localObject1 = this.jdField_a_of_type_Ucz.a();
    boolean bool = localObject1 instanceof TextureVideoView;
    int i3 = 0;
    int i7 = vzl.b(this.jdField_a_of_type_AndroidViewView.getContext());
    int i5 = vzl.c(this.jdField_a_of_type_AndroidViewView.getContext());
    double d1 = i1 / i2;
    double d2 = i7 / i5;
    int i4;
    label174:
    label184:
    label205:
    float f2;
    label269:
    int i6;
    label277:
    int i8;
    int i9;
    int i10;
    int i11;
    int i12;
    Object localObject2;
    if ((bool) && (i1 > 0) && (i2 > 0)) {
      if (d1 < 1.0D)
      {
        i3 = 1;
        if (d2 >= 1.0D) {
          break label763;
        }
        i4 = 1;
        if (i3 == i4) {
          break label769;
        }
        bool = true;
        this.jdField_c_of_type_Boolean = bool;
        if (!this.jdField_c_of_type_Boolean) {
          break label921;
        }
        d1 = i2 / i1;
        if (paramStoryVideoItem.playerScaleType != 1) {
          break label808;
        }
        float f1 = i7 / i2;
        f2 = i5 / i1;
        if (f1 >= f2) {
          break label775;
        }
        i4 = (int)(i2 * f1);
        i3 = (int)(i1 * f1);
        i1 = (i5 - i3) / 2;
        i2 = 0;
        i5 = i3;
        i6 = i4;
        i7 = i1;
        i8 = i2;
        i9 = i3;
        i10 = i4;
        i11 = i5;
        i12 = i6;
        if (this.jdField_c_of_type_Boolean)
        {
          localObject2 = new Matrix();
          ((Matrix)localObject2).setScale(i3 / i4, i4 / i3, i4 / 2.0F, i3 / 2.0F);
          ((Matrix)localObject2).postRotate(90.0F, i4 / 2.0F, i3 / 2.0F);
          ((TextureVideoView)localObject1).setTransform((Matrix)localObject2);
          i12 = i6;
          i11 = i5;
          i10 = i4;
          i9 = i3;
          i8 = i2;
          i7 = i1;
        }
      }
    }
    for (;;)
    {
      this.jdField_d_of_type_JavaLangString = paramStoryVideoItem.mVid;
      this.i = paramStoryVideoItem.playerScaleType;
      this.h = paramStoryVideoItem.mVideoHeight;
      this.g = paramStoryVideoItem.mVideoWidth;
      a(ajya.a(2131716447) + i12 + ajya.a(2131716442) + i11 + ajya.a(2131716444) + String.valueOf(this.jdField_c_of_type_Boolean));
      localObject2 = new StringBuilder().append(ajya.a(2131716441)).append(paramStoryVideoItem.mVideoDuration).append(ajya.a(2131716461)).append(paramStoryVideoItem.mVideoBytes);
      if (paramStoryVideoItem.mIsPicture == 1) {}
      for (localObject1 = ajya.a(2131716455);; localObject1 = "")
      {
        a((String)localObject1);
        this.jdField_a_of_type_ArrayOfInt[0] = i12;
        this.jdField_a_of_type_ArrayOfInt[1] = i11;
        this.jdField_a_of_type_ArrayOfInt[2] = i10;
        this.jdField_a_of_type_ArrayOfInt[3] = i9;
        this.jdField_a_of_type_ArrayOfInt[4] = i8;
        this.jdField_a_of_type_ArrayOfInt[5] = i7;
        ved.b(this.jdField_a_of_type_JavaLangString, "updateViewParam, videoWidth/videoHeight=%d/%d, layoutWidth/layoutHeight=%d/%d, leftMargin=%d, topMargin=%d, vid=%s", new Object[] { Integer.valueOf(this.jdField_a_of_type_ArrayOfInt[0]), Integer.valueOf(this.jdField_a_of_type_ArrayOfInt[1]), Integer.valueOf(this.jdField_a_of_type_ArrayOfInt[2]), Integer.valueOf(this.jdField_a_of_type_ArrayOfInt[3]), Integer.valueOf(this.jdField_a_of_type_ArrayOfInt[4]), Integer.valueOf(this.jdField_a_of_type_ArrayOfInt[5]), paramStoryVideoItem.mVid });
        a(this.jdField_a_of_type_Ucz.a(), i10, i9, i8, i7);
        a(this.jdField_a_of_type_AndroidWidgetImageView, i10, i9, i8, i7);
        a(this.jdField_b_of_type_AndroidWidgetImageView, i10, i9, i8, i7);
        return;
        i3 = 0;
        break;
        label763:
        i4 = 0;
        break label174;
        label769:
        bool = false;
        break label184;
        label775:
        i4 = (int)(i2 * f2);
        i3 = (int)(i1 * f2);
        i1 = 0;
        i2 = (i7 - i4) / 2;
        break label269;
        label808:
        if (d2 >= d1)
        {
          i3 = (int)(i7 / d1);
          i4 = (int)(1.0D * (i5 - i3) / 2.0D + 0.5D);
          i6 = i2;
          i5 = i1;
          i1 = i4;
          i2 = 0;
          i4 = i7;
          break label277;
        }
        i4 = (int)(d1 * i5);
        i7 = (int)(1.0D * (i7 - i4) / 2.0D + 0.5D);
        i3 = i5;
        i6 = i2;
        i5 = i1;
        i1 = 0;
        i2 = i7;
        break label277;
      }
      label921:
      i3 = i1;
      i1 = i2;
      i2 = i3;
      break label205;
      i8 = 0;
      i9 = -1;
      i10 = -1;
      i7 = i3;
      i11 = i2;
      i12 = i1;
    }
  }
  
  private void a(@NonNull String paramString)
  {
    ved.b(this.jdField_a_of_type_JavaLangString, paramString);
  }
  
  private void a(String paramString, long paramLong)
  {
    if (this.jdField_f_of_type_Boolean)
    {
      this.jdField_a_of_type_JavaUtilMap.put(paramString, Long.valueOf(paramLong));
      i();
    }
  }
  
  private void a(uas paramuas, ucz paramucz, int paramInt)
  {
    if (!TextUtils.equals(this.jdField_f_of_type_JavaLangString, this.jdField_a_of_type_Uas.jdField_a_of_type_JavaLangString)) {
      return;
    }
    String str = vei.a(a());
    udm localudm = paramucz.a();
    long l1;
    long l2;
    if (localudm.jdField_d_of_type_Long == 0L)
    {
      l1 = paramucz.b();
      if (paramInt != 1) {
        break label102;
      }
      l2 = l1;
    }
    for (;;)
    {
      Bosses.get().postJob(new ubh(this, this.jdField_a_of_type_JavaLangString, paramuas, l1, l2, paramInt, str));
      return;
      l1 = localudm.jdField_d_of_type_Long;
      break;
      label102:
      if (localudm.jdField_d_of_type_Long == 0L) {
        l2 = paramucz.a();
      } else {
        l2 = localudm.e;
      }
    }
  }
  
  private boolean a(int paramInt)
  {
    return a(paramInt, (int[])jdField_a_of_type_AndroidUtilSparseArray.get(this.jdField_e_of_type_Int));
  }
  
  public static boolean a(int paramInt, int[] paramArrayOfInt)
  {
    boolean bool2 = false;
    int i2 = paramArrayOfInt.length;
    int i1 = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i1 < i2)
      {
        if (paramArrayOfInt[i1] == paramInt) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i1 += 1;
    }
  }
  
  private void b(int paramInt)
  {
    Object localObject = this.jdField_a_of_type_Uas.a();
    if (localObject == null)
    {
      b().setVisibility(8);
      return;
    }
    localObject = ((StoryVideoItem)localObject).getVideoLinkInfo();
    if ((localObject != null) && (((teo)localObject).a()) && (((teo)localObject).a.a()) && (a().mReportData.from != 86))
    {
      b().setVisibility(paramInt);
      return;
    }
    b().setVisibility(8);
  }
  
  private void b(StoryVideoItem paramStoryVideoItem)
  {
    if ((!TextUtils.isEmpty(paramStoryVideoItem.mOwnerUid)) && (!StoryVideoItem.isFakeVid(paramStoryVideoItem.mVid))) {
      this.jdField_a_of_type_Tln.a(paramStoryVideoItem.mVid, paramStoryVideoItem.mOwnerUid, a().mReportData.from, false, paramStoryVideoItem.mCreateTime);
    }
    for (;;)
    {
      String str = paramStoryVideoItem.mOwnerUid;
      Object localObject = str;
      if (this.jdField_a_of_type_Uas.jdField_a_of_type_Tff != null)
      {
        localObject = str;
        if (this.jdField_a_of_type_Uas.jdField_a_of_type_Tff.jdField_a_of_type_Int == 13) {
          localObject = this.jdField_a_of_type_Uas.jdField_a_of_type_Tff.jdField_a_of_type_JavaLangString;
        }
      }
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        localObject = new tdr((String)localObject, paramStoryVideoItem);
        stb.a().dispatch((Dispatcher.Dispatchable)localObject);
      }
      ((tcw)tcz.a(5)).b(paramStoryVideoItem.mVid);
      ved.b(this.jdField_a_of_type_JavaLangString, "Do play video. vid = %s", paramStoryVideoItem.mVid);
      return;
      if (QLog.isColorLevel()) {
        QLog.i(this.jdField_a_of_type_JavaLangString, 2, "not report play, vid = " + paramStoryVideoItem.mVid + " mOwnerUid:" + paramStoryVideoItem.mOwnerUid + ", myUin:" + QQStoryContext.a().b());
      }
    }
  }
  
  private void b(uas paramuas, ucz paramucz, int paramInt)
  {
    StoryVideoItem localStoryVideoItem = paramuas.a();
    if (localStoryVideoItem == null) {
      ved.e(this.jdField_a_of_type_JavaLangString, "video info empty , report error! vid :%s", new Object[] { paramuas.jdField_a_of_type_JavaLangString });
    }
    while (!TextUtils.equals(this.jdField_f_of_type_JavaLangString, this.jdField_a_of_type_Uas.jdField_a_of_type_JavaLangString)) {
      return;
    }
    paramuas = vei.a(a());
    udm localudm = paramucz.a();
    long l1;
    long l2;
    if (localudm.jdField_d_of_type_Long == 0L)
    {
      l1 = paramucz.b();
      if (paramInt != 1) {
        break label133;
      }
      l2 = l1;
    }
    for (;;)
    {
      Bosses.get().postJob(new ubi(this, this.jdField_a_of_type_JavaLangString, localStoryVideoItem, l1, l2, paramInt, paramuas));
      return;
      l1 = localudm.jdField_d_of_type_Long;
      break;
      label133:
      if (localudm.jdField_d_of_type_Long == 0L) {
        l2 = paramucz.a();
      } else {
        l2 = localudm.e;
      }
    }
  }
  
  private boolean b(int paramInt)
  {
    if (Looper.myLooper() == Looper.getMainLooper()) {}
    for (boolean bool = true;; bool = false)
    {
      vxp.a(bool, "not - main - thread");
      if (!a(paramInt, (int[])jdField_a_of_type_AndroidUtilSparseArray.get(this.jdField_e_of_type_Int))) {
        break;
      }
      ved.d(this.jdField_a_of_type_JavaLangString, "changeState : %s => %s", new Object[] { jdField_a_of_type_ArrayOfJavaLangString[this.jdField_e_of_type_Int], jdField_a_of_type_ArrayOfJavaLangString[paramInt] });
      this.jdField_e_of_type_Int = paramInt;
      return true;
    }
    ved.d(this.jdField_a_of_type_JavaLangString, new Throwable(), "changeState not allow ! current = %s, new = %s", new Object[] { jdField_a_of_type_ArrayOfJavaLangString[this.jdField_e_of_type_Int], jdField_a_of_type_ArrayOfJavaLangString[paramInt] });
    axpu.a(new IllegalStateException("changeState ! " + jdField_a_of_type_ArrayOfJavaLangString[this.jdField_e_of_type_Int] + " -- " + jdField_a_of_type_ArrayOfJavaLangString[paramInt]));
    vxp.a(false, "changeState not allow. current=" + jdField_a_of_type_ArrayOfJavaLangString[this.jdField_e_of_type_Int] + ", new=" + jdField_a_of_type_ArrayOfJavaLangString[paramInt]);
    return false;
  }
  
  private void d(boolean paramBoolean)
  {
    boolean bool;
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      bool = true;
      vxp.a(bool, "not - main - thread");
      ved.a(this.jdField_a_of_type_JavaLangString, "checkStateAndGoAhead. %s => %s. reset=%s", jdField_a_of_type_ArrayOfJavaLangString[this.jdField_e_of_type_Int], jdField_a_of_type_ArrayOfJavaLangString[this.jdField_c_of_type_Int], Boolean.valueOf(paramBoolean));
      if (!paramBoolean) {
        break label134;
      }
      this.jdField_b_of_type_JavaLangString = (jdField_a_of_type_ArrayOfJavaLangString[this.jdField_e_of_type_Int] + " - " + jdField_a_of_type_ArrayOfJavaLangString[0]);
      this.jdField_a_of_type_ComTribeAsyncReactiveStream = Stream.of("");
      this.jdField_a_of_type_ComTribeAsyncReactiveStream.map(new ubx(this, null)).subscribe(new ubj(this));
    }
    label134:
    do
    {
      return;
      bool = false;
      break;
      if (this.jdField_e_of_type_Int == this.jdField_c_of_type_Int)
      {
        ved.a(this.jdField_a_of_type_JavaLangString, "checkStateAndGoAhead. DONE => %s", jdField_a_of_type_ArrayOfJavaLangString[this.jdField_c_of_type_Int]);
        return;
      }
      if (this.jdField_a_of_type_ComTribeAsyncReactiveStream != null)
      {
        ved.d(this.jdField_a_of_type_JavaLangString, "checkStateAndGoAhead. do nothing. waiting ...");
        return;
      }
      if (this.jdField_c_of_type_Int == 0)
      {
        d(true);
        return;
      }
      if (this.jdField_c_of_type_Int == 2)
      {
        if (this.jdField_e_of_type_Int == 0)
        {
          this.jdField_b_of_type_JavaLangString = (jdField_a_of_type_ArrayOfJavaLangString[0] + " - " + jdField_a_of_type_ArrayOfJavaLangString[2]);
          this.jdField_a_of_type_ComTribeAsyncReactiveStream = Stream.of(this.jdField_a_of_type_Uas);
          this.jdField_a_of_type_ComTribeAsyncReactiveStream.map(new ubr(this, null)).map(new uby(this, null)).subscribe(new ubk(this));
          return;
        }
        d(true);
        return;
      }
      if ((this.jdField_c_of_type_Int == 8) || (this.jdField_c_of_type_Int == 10))
      {
        if (this.jdField_e_of_type_Int == 0)
        {
          if (this.jdField_a_of_type_Uas != null)
          {
            this.jdField_b_of_type_JavaLangString = (jdField_a_of_type_ArrayOfJavaLangString[0] + " - " + jdField_a_of_type_ArrayOfJavaLangString[6]);
            this.jdField_a_of_type_ComTribeAsyncReactiveStream = Stream.of(this.jdField_a_of_type_Uas);
            this.jdField_a_of_type_ComTribeAsyncReactiveStream.map(new ubr(this, null)).map(new uby(this, null)).map(new ubt(this, this.jdField_a_of_type_Ubv)).map(new ubw(this, this.jdField_a_of_type_Ubv, b())).subscribe(new ubl(this));
            return;
          }
          ved.e(this.jdField_a_of_type_JavaLangString, "mData is null");
          a(new ErrorMessage(0, "mData is null. un bind !"));
          return;
        }
        StoryVideoItem localStoryVideoItem;
        if (this.jdField_e_of_type_Int == 2)
        {
          if (this.jdField_a_of_type_Uas != null)
          {
            localStoryVideoItem = ((tcw)tcz.a(5)).b(this.jdField_a_of_type_Uas.jdField_a_of_type_JavaLangString);
            if (localStoryVideoItem != null)
            {
              this.jdField_b_of_type_JavaLangString = (jdField_a_of_type_ArrayOfJavaLangString[2] + " - " + jdField_a_of_type_ArrayOfJavaLangString[6]);
              this.jdField_a_of_type_ComTribeAsyncReactiveStream = Stream.of(localStoryVideoItem);
              this.jdField_a_of_type_ComTribeAsyncReactiveStream.map(new ubt(this, this.jdField_a_of_type_Ubv)).map(new ubw(this, this.jdField_a_of_type_Ubv, b())).subscribe(new ubm(this));
              return;
            }
            ved.e(this.jdField_a_of_type_JavaLangString, "mData is null");
            a(new ErrorMessage(0, "Go To VideoFile. storyVideoItem is null. un bind !"));
            return;
          }
          ved.e(this.jdField_a_of_type_JavaLangString, "mData is null");
          a(new ErrorMessage(0, "Go To VideoFile. mData is null. un bind !"));
          return;
        }
        if (this.jdField_e_of_type_Int < 6)
        {
          d(true);
          return;
        }
        if (this.jdField_e_of_type_Int == 6)
        {
          localStoryVideoItem = ((tcw)tcz.a(5)).b(this.jdField_a_of_type_Uas.jdField_a_of_type_JavaLangString);
          if (localStoryVideoItem != null)
          {
            this.jdField_b_of_type_JavaLangString = (jdField_a_of_type_ArrayOfJavaLangString[6] + " - " + jdField_a_of_type_ArrayOfJavaLangString[8]);
            this.jdField_a_of_type_ComTribeAsyncReactiveStream = Stream.of(localStoryVideoItem);
            this.jdField_a_of_type_ComTribeAsyncReactiveStream.map(new ubz(this, null)).subscribe(new ubn(this));
            return;
          }
          a(new ErrorMessage(12, "no videoInfo " + this.jdField_a_of_type_Uas.jdField_a_of_type_JavaLangString));
          return;
        }
        if ((this.jdField_e_of_type_Int == 7) || (this.jdField_e_of_type_Int == 9) || (this.jdField_e_of_type_Int == 12))
        {
          d(true);
          return;
        }
        if ((this.jdField_c_of_type_Int == 8) && ((this.jdField_e_of_type_Int == 11) || (this.jdField_e_of_type_Int == 10)))
        {
          d(true);
          return;
        }
        if ((this.jdField_c_of_type_Int == 10) && ((this.jdField_e_of_type_Int == 11) || (this.jdField_e_of_type_Int == 8)))
        {
          ved.a(this.jdField_a_of_type_JavaLangString, "requestChangeState. current=%s, target=%s, start play", jdField_a_of_type_ArrayOfJavaLangString[this.jdField_e_of_type_Int], jdField_a_of_type_ArrayOfJavaLangString[this.jdField_c_of_type_Int]);
          localStoryVideoItem = ((tcw)tcz.a(5)).b(this.jdField_a_of_type_Uas.jdField_a_of_type_JavaLangString);
          if (localStoryVideoItem != null)
          {
            this.jdField_b_of_type_JavaLangString = (jdField_a_of_type_ArrayOfJavaLangString[this.jdField_e_of_type_Int] + " - " + jdField_a_of_type_ArrayOfJavaLangString[10]);
            this.jdField_a_of_type_ComTribeAsyncReactiveStream = Stream.of(localStoryVideoItem);
            this.jdField_a_of_type_ComTribeAsyncReactiveStream.map(new VideoViewVideoHolder.VideoStartSegment(this, null)).subscribe(new ubo(this));
            return;
          }
          a(new ErrorMessage(12, "no videoInfo " + this.jdField_a_of_type_Uas.jdField_a_of_type_JavaLangString));
          return;
        }
        ved.e(this.jdField_a_of_type_JavaLangString, "state error. currentTargetState = %s, currentState = %s", new Object[] { jdField_a_of_type_ArrayOfJavaLangString[this.jdField_c_of_type_Int], jdField_a_of_type_ArrayOfJavaLangString[this.jdField_e_of_type_Int] });
        return;
      }
    } while (this.jdField_c_of_type_Int != 11);
    if (this.jdField_e_of_type_Int == 10)
    {
      ved.a(this.jdField_a_of_type_JavaLangString, "requestChangeState. current=%s, target=%s, pause video", jdField_a_of_type_ArrayOfJavaLangString[this.jdField_e_of_type_Int], jdField_a_of_type_ArrayOfJavaLangString[this.jdField_c_of_type_Int]);
      b(11);
      this.jdField_a_of_type_Ucz.c();
      return;
    }
    ved.d(this.jdField_a_of_type_JavaLangString, "requestChangeState. current=%s, target=%s, ERROR !", new Object[] { jdField_a_of_type_ArrayOfJavaLangString[this.jdField_e_of_type_Int], jdField_a_of_type_ArrayOfJavaLangString[this.jdField_c_of_type_Int] });
  }
  
  private void g()
  {
    d(false);
  }
  
  private void h()
  {
    Object localObject;
    long l1;
    int i1;
    String str;
    if (this.jdField_a_of_type_JavaUtilMap.containsKey("SE"))
    {
      localObject = "SE";
      l1 = ((Long)this.jdField_a_of_type_JavaUtilMap.get("SE")).longValue();
      String[] arrayOfString = jdField_b_of_type_ArrayOfJavaLangString;
      int i2 = arrayOfString.length;
      i1 = 0;
      if (i1 < i2)
      {
        str = arrayOfString[i1];
        if (!str.equals("SE")) {}
      }
    }
    for (;;)
    {
      i1 += 1;
      break;
      if (this.jdField_a_of_type_JavaUtilMap.containsKey(str))
      {
        a(String.format((Locale)null, ajya.a(2131716462), new Object[] { localObject, str, Long.valueOf(((Long)this.jdField_a_of_type_JavaUtilMap.get(str)).longValue() - l1) }));
        l1 = ((Long)this.jdField_a_of_type_JavaUtilMap.get(str)).longValue();
        localObject = str;
        continue;
        if (this.jdField_f_of_type_Boolean) {
          a(String.format((Locale)null, ajya.a(2131716443), new Object[] { Long.valueOf(((Long)this.jdField_a_of_type_JavaUtilMap.get("HC")).longValue() - ((Long)this.jdField_a_of_type_JavaUtilMap.get("SE")).longValue()) }));
        }
        return;
      }
    }
  }
  
  private void i()
  {
    this.jdField_b_of_type_AndroidViewView.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
    this.jdField_b_of_type_AndroidWidgetButton.setVisibility(8);
    this.jdField_c_of_type_AndroidWidgetButton.setVisibility(8);
  }
  
  private void j()
  {
    boolean bool1;
    if ((this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryLoadingView != null) && ((this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryLoadingView.getVisibility() == 0) || (this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryLoadingView.a() == 0)))
    {
      bool1 = true;
      if ((this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoQQStoryVideoPlayerErrorView == null) || (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoQQStoryVideoPlayerErrorView.getVisibility() != 0)) {
        break label224;
      }
    }
    label224:
    for (boolean bool2 = true;; bool2 = false)
    {
      int i1 = this.n;
      int i2 = this.j;
      int i3 = this.k;
      int i4 = this.jdField_a_of_type_Ucz.a();
      String str1 = this.jdField_f_of_type_JavaLangString;
      String str2 = this.jdField_a_of_type_Uas.jdField_a_of_type_JavaLangString;
      String str3 = this.jdField_e_of_type_JavaLangString;
      String str4 = this.jdField_c_of_type_JavaLangString;
      long l1 = this.jdField_d_of_type_Long;
      int i5 = this.l;
      int i6 = this.m;
      int i7 = a().mReportData.from;
      Long localLong = (Long)this.jdField_a_of_type_JavaUtilMap.get("SE");
      udm localudm = new udm(this.jdField_a_of_type_Ucz.a());
      Bosses.get().postJob(new ubg(this, this.jdField_a_of_type_JavaLangString, bool1, i1, localLong, bool2, i2, i3, i4, str1, str2, i7, i5, i6, localudm, l1, str3, str4));
      return;
      bool1 = false;
      break;
    }
  }
  
  private void k()
  {
    if (!this.jdField_f_of_type_Boolean) {
      return;
    }
    this.jdField_f_of_type_Boolean = false;
    int i1;
    StringBuilder localStringBuilder;
    long l2;
    long l1;
    int i2;
    label265:
    Object localObject2;
    if ((!a().mReportData.hasReportFirstVideoTime) && ((TextUtils.equals(this.jdField_a_of_type_Uas.jdField_a_of_type_JavaLangString, a().jdField_a_of_type_JavaLangString)) || (TextUtils.isEmpty(a().jdField_a_of_type_JavaLangString))))
    {
      i1 = 1;
      if (!a().mReportData.hasReportFirstVideoTime) {
        a().mReportData.hasReportFirstVideoTime = true;
      }
      localStringBuilder = new StringBuilder();
      l2 = a().mReportData.startActivityTimeStamp;
      long l3 = a().mReportData.activityOnCreateTimeStamp;
      long l4 = a().mReportData.initViewPagerUiTimeStamp;
      l1 = a().mReportData.initViewPagerDataTimeStamp;
      localStringBuilder.append("staAct").append(" ").append(0).append(" ");
      localStringBuilder.append("onCre").append(" ").append(l3 - l2).append(" ");
      localStringBuilder.append("initUi").append(" ").append(l4 - l2).append(" ");
      localStringBuilder.append("initData").append(" ").append(l1 - l2).append(" ");
      localObject1 = jdField_b_of_type_ArrayOfJavaLangString;
      int i3 = localObject1.length;
      i2 = 0;
      if (i2 >= i3) {
        break label380;
      }
      localObject2 = localObject1[i2];
      if (!this.jdField_a_of_type_JavaUtilMap.containsKey(localObject2)) {
        break label349;
      }
      l1 = ((Long)this.jdField_a_of_type_JavaUtilMap.get(localObject2)).longValue();
      localStringBuilder.append(localObject2).append(" ").append(l1 - l2).append(" ");
    }
    for (;;)
    {
      i2 += 1;
      break label265;
      i1 = 0;
      break;
      label349:
      localStringBuilder.append(localObject2).append(" ").append(l1 - l2).append(" ");
    }
    label380:
    if (i1 != 0)
    {
      l1 = ((Long)this.jdField_a_of_type_JavaUtilMap.get("HC")).longValue() - l2;
      a(ajya.a(2131716448) + l1);
      if (i1 == 0) {
        break label666;
      }
      localObject1 = "CL ";
      if (this.jdField_a_of_type_Ucz.a() != 0) {
        break label674;
      }
      localObject1 = (String)localObject1 + "LO ";
      localObject1 = (String)localObject1 + this.jdField_a_of_type_Ucz.b();
      localObject1 = (String)localObject1 + " ";
      if (!b()) {
        break label739;
      }
    }
    label443:
    label478:
    label739:
    for (Object localObject1 = (String)localObject1 + "TVK";; localObject1 = (String)localObject1 + "TEX")
    {
      this.jdField_b_of_type_Long = l1;
      vei.b("play_video", "start_wait_time", a().mReportData.from, (int)l1, new String[] { localObject1, localStringBuilder.toString(), vei.a(a()), this.jdField_a_of_type_Uas.jdField_a_of_type_JavaLangString });
      return;
      l1 = ((Long)this.jdField_a_of_type_JavaUtilMap.get("HC")).longValue() - ((Long)this.jdField_a_of_type_JavaUtilMap.get("SE")).longValue();
      break;
      localObject1 = "SL ";
      break label443;
      if (this.jdField_a_of_type_Ucz.a() == 1)
      {
        localObject1 = (String)localObject1 + "ST ";
        break label478;
      }
      localObject1 = (String)localObject1 + "3 ";
      break label478;
    }
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_Uas.c())
    {
      if (this.jdField_e_of_type_Int != 10) {
        break label127;
      }
      if (this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryLoadingView.getVisibility() == 0) {
        ved.d(this.jdField_a_of_type_JavaLangString, "toggle video, PLAYING = > PAUSE. ignore because loading while playing");
      }
    }
    else
    {
      return 0;
    }
    ved.d(this.jdField_a_of_type_JavaLangString, "toggle video, PLAYING = > PAUSE");
    a().setVisibility(0);
    a(11, "toggle pause");
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryLoadingView.setVisibility(8);
    b(0);
    vei.a("play_video", "exp_tips", 0, 0, new String[] { "", "", "", this.jdField_a_of_type_Uas.jdField_a_of_type_JavaLangString });
    return 2;
    label127:
    if ((this.jdField_e_of_type_Int == 11) && (a().getVisibility() == 0))
    {
      ved.d(this.jdField_a_of_type_JavaLangString, "toggle video, PAUSE = > PLAYING");
      a().setVisibility(8);
      a(10, "toggle start");
      b(8);
      return 1;
    }
    ved.d(this.jdField_a_of_type_JavaLangString, "toggle video, ignore. isPlaying=%s, hideCover=%s, visibility=%d", new Object[] { Boolean.valueOf(this.jdField_a_of_type_Ucz.a()), Boolean.valueOf(this.jdField_e_of_type_Boolean), Integer.valueOf(a().getVisibility()) });
    b(8);
    return 0;
  }
  
  public View a()
  {
    ubb localubb = (ubb)a(ubb.class);
    if (localubb != null) {
      return localubb.jdField_b_of_type_AndroidViewView;
    }
    return new View(a());
  }
  
  public View a(ViewGroup paramViewGroup)
  {
    return paramViewGroup;
  }
  
  public void a(int paramInt)
  {
    i();
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    super.a(paramInt1, paramInt2);
    a(ajya.a(2131716456) + this.jdField_a_of_type_Int + "-" + this.jdField_b_of_type_Int);
  }
  
  public void a(int paramInt1, int paramInt2, @NonNull uas paramuas, StoryPlayerGroupHolder paramStoryPlayerGroupHolder)
  {
    String str;
    if (this.jdField_a_of_type_Uas != null)
    {
      str = this.jdField_a_of_type_Uas.jdField_a_of_type_JavaLangString;
      super.a(paramInt1, paramInt2, paramuas, paramStoryPlayerGroupHolder);
      ved.a(this.jdField_a_of_type_JavaLangString, "onBind, newVer=%d, newHor=%d, data=%s", Integer.valueOf(this.jdField_a_of_type_Int), Integer.valueOf(this.jdField_b_of_type_Int), paramuas);
      i();
      this.jdField_a_of_type_JavaUtilMap.clear();
      if (paramuas.jdField_a_of_type_JavaLangString.equals(str)) {
        break label95;
      }
    }
    label95:
    for (boolean bool = true;; bool = false)
    {
      a(2, bool, "onBind");
      return;
      str = null;
      break;
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    a(paramInt, false, paramString);
  }
  
  public void a(int paramInt, boolean paramBoolean, String paramString)
  {
    boolean bool;
    if ((paramInt == 2) || (paramInt == 8) || (paramInt == 10) || (paramInt == 11) || (paramInt == 0))
    {
      bool = true;
      vxp.a(bool);
      ved.a(this.jdField_a_of_type_JavaLangString, "requestChangeState. START. current=%s, newTarget=%s. reset=%s, reason=%s", jdField_a_of_type_ArrayOfJavaLangString[this.jdField_e_of_type_Int], jdField_a_of_type_ArrayOfJavaLangString[paramInt], Boolean.valueOf(paramBoolean), paramString);
      if ((this.jdField_c_of_type_Int != paramInt) || (paramBoolean))
      {
        this.jdField_c_of_type_Int = paramInt;
        if (!paramBoolean) {
          break label177;
        }
        if (this.jdField_a_of_type_ComTribeAsyncReactiveStream == null) {
          break label169;
        }
        ved.a(this.jdField_a_of_type_JavaLangString, "cancel current stream : %s. current state = %s", this.jdField_b_of_type_JavaLangString, jdField_a_of_type_ArrayOfJavaLangString[this.jdField_e_of_type_Int]);
        this.jdField_a_of_type_ComTribeAsyncReactiveStream.cancel();
        this.jdField_b_of_type_JavaLangString = null;
        this.jdField_a_of_type_ComTribeAsyncReactiveStream = null;
        g();
      }
    }
    for (;;)
    {
      ved.a(this.jdField_a_of_type_JavaLangString, "requestChangeState. DONE. current=%s, newTarget=%s. reset=%s, reason=%s", jdField_a_of_type_ArrayOfJavaLangString[this.jdField_e_of_type_Int], jdField_a_of_type_ArrayOfJavaLangString[paramInt], Boolean.valueOf(paramBoolean), paramString);
      return;
      bool = false;
      break;
      label169:
      d(true);
      continue;
      label177:
      if (this.jdField_a_of_type_ComTribeAsyncReactiveStream != null) {
        ved.b(this.jdField_a_of_type_JavaLangString, "just waiting");
      } else {
        g();
      }
    }
  }
  
  public void a(ucg paramucg)
  {
    this.jdField_a_of_type_Ucg = paramucg;
  }
  
  protected View b()
  {
    uay localuay = (uay)a(uay.class);
    if (localuay != null) {
      return localuay.jdField_a_of_type_AndroidViewView;
    }
    return new View(a());
  }
  
  public void b()
  {
    super.b();
    Activity localActivity = a();
    if (b()) {}
    for (this.jdField_a_of_type_Ucz = new udf(new ued(localActivity, String.valueOf(System.identityHashCode(this))));; this.jdField_a_of_type_Ucz = new udf(new uem(localActivity, String.valueOf(System.identityHashCode(this)))))
    {
      ved.a(this.jdField_a_of_type_JavaLangString, "create video view, use-TVK=%s videoView=%s", Boolean.valueOf(b()), this.jdField_a_of_type_Ucz);
      ((ViewGroup)this.jdField_a_of_type_AndroidViewView).addView(this.jdField_a_of_type_Ucz.a(), 0, new RelativeLayout.LayoutParams(-1, -1));
      a(new ube(this));
      return;
    }
  }
  
  public void b(boolean paramBoolean)
  {
    super.b(paramBoolean);
    if (paramBoolean)
    {
      this.jdField_f_of_type_Boolean = true;
      this.jdField_a_of_type_JavaUtilMap.clear();
      a("SE", SystemClock.uptimeMillis());
      this.jdField_b_of_type_Long = 0L;
      this.jdField_a_of_type_Long = 0L;
      this.jdField_d_of_type_Int = 3;
      this.n = 1;
      this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryLoadingView.setVisibility(8);
      this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryLoadingView.setVisibilityDelay(0, 1000L, "onSelectedChanged true");
      vei.b("play_video", "onSelectedState", 0, 0, new String[] { jdField_a_of_type_ArrayOfJavaLangString[this.jdField_e_of_type_Int] });
      a(10, "selected");
      vei.a("play_video", "exp", 0, 0, new String[] { "", "", "", this.jdField_a_of_type_Uas.jdField_a_of_type_JavaLangString });
    }
    for (;;)
    {
      this.l = 0;
      this.jdField_c_of_type_Long = 0L;
      this.m = 0;
      return;
      this.jdField_e_of_type_Boolean = false;
      f();
      j();
      this.jdField_f_of_type_JavaLangString = null;
      this.jdField_a_of_type_JavaUtilMap.clear();
      this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryLoadingView.setVisibility(8);
      a().setVisibility(8);
      b().setVisibility(8);
      a(0, true, "unSelected");
    }
  }
  
  public void c()
  {
    super.c();
    a(0, true, "unBind");
    if (this.jdField_a_of_type_Wbw != null) {
      this.jdField_a_of_type_Wbw.dismiss();
    }
  }
  
  public void c(boolean paramBoolean)
  {
    ved.d(this.jdField_a_of_type_JavaLangString, "setRepeatWhilePlayDone = %s", new Object[] { Boolean.valueOf(paramBoolean) });
    this.jdField_d_of_type_Boolean = paramBoolean;
  }
  
  public void d()
  {
    if ((this.jdField_e_of_type_Int == 11) && (a().getVisibility() != 0)) {
      a(10, "call resume");
    }
  }
  
  public void e()
  {
    if ((this.jdField_e_of_type_Int == 10) && (a().getVisibility() != 0)) {
      a(11, "call Pause");
    }
  }
  
  public boolean e()
  {
    if ((!d()) || (!c()) || (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGroupHolder == null)) {
      return false;
    }
    tcs localtcs = (tcs)tcz.a(10);
    if ((this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGroupHolder.a.size() > 1) && (!localtcs.a()))
    {
      e();
      if (this.jdField_a_of_type_Wbw != null) {
        this.jdField_a_of_type_Wbw.dismiss();
      }
      this.jdField_a_of_type_Wbw = new wbw(a());
      this.jdField_a_of_type_Wbw.a(true);
      this.jdField_a_of_type_Wbw.a(ajya.a(2131716449));
      this.jdField_a_of_type_Wbw.setOnDismissListener(new ubu(this, this.jdField_d_of_type_Boolean));
      this.jdField_a_of_type_Wbw.show();
      localtcs.a(true);
      return true;
    }
    if ((a().a().getCount() > 1) && (!localtcs.b()))
    {
      e();
      if (this.jdField_a_of_type_Wbw != null) {
        this.jdField_a_of_type_Wbw.dismiss();
      }
      this.jdField_a_of_type_Wbw = new wbw(a());
      this.jdField_a_of_type_Wbw.a(ajya.a(2131716451));
      this.jdField_a_of_type_Wbw.setOnDismissListener(new ubu(this, this.jdField_d_of_type_Boolean));
      this.jdField_a_of_type_Wbw.show();
      localtcs.b(true);
      return true;
    }
    return false;
  }
  
  public void f()
  {
    if (!this.jdField_a_of_type_Uas.c()) {
      return;
    }
    int i1 = a().mReportData.from;
    if (tsh.a(i1)) {
      b(this.jdField_a_of_type_Uas, this.jdField_a_of_type_Ucz, this.jdField_d_of_type_Int);
    }
    for (;;)
    {
      ved.a(this.jdField_a_of_type_JavaLangString, "report video player done! vid :%s , from :%d , op_result: %d", this.jdField_a_of_type_Uas.jdField_a_of_type_JavaLangString, Integer.valueOf(i1), Integer.valueOf(this.jdField_d_of_type_Int));
      return;
      a(this.jdField_a_of_type_Uas, this.jdField_a_of_type_Ucz, this.jdField_d_of_type_Int);
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    Object localObject;
    do
    {
      do
      {
        do
        {
          return;
          ((ClipboardManager)paramView.getContext().getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("VideoInfo(" + this.jdField_a_of_type_Uas.jdField_a_of_type_JavaLangString + ")", this.jdField_a_of_type_Uas.jdField_a_of_type_JavaLangString));
          bcql.a(paramView.getContext(), 2131694466, 0).a();
          return;
          localObject = ((stf)tcz.a(4)).b();
        } while ((localObject == null) || (this.jdField_c_of_type_JavaLangString == null));
        localObject = ((stl)tcz.a(28)).a(bfnx.a(this.jdField_c_of_type_JavaLangString, "authkey", (String)localObject).replace("https://", "http://"));
      } while ((localObject == null) || (localObject.length <= 0));
      ((ClipboardManager)paramView.getContext().getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("VideoUrl(" + this.jdField_a_of_type_Uas.jdField_a_of_type_JavaLangString + ")", localObject[0]));
      bcql.a(paramView.getContext(), 2131694466, 0).a();
      return;
      localObject = suj.a(this.jdField_a_of_type_Uas.jdField_a_of_type_JavaLangString, 0, false, false);
    } while ((localObject == null) || (!((File)localObject).exists()));
    Intent localIntent = new Intent("android.intent.action.VIEW");
    localIntent.addFlags(268435456);
    localIntent.setDataAndType(Uri.parse(((File)localObject).getParent()), "resource/folder");
    try
    {
      if (localIntent.resolveActivityInfo(a().getPackageManager(), 0) != null)
      {
        a(localIntent);
        return;
      }
    }
    catch (ActivityNotFoundException paramView)
    {
      paramView.printStackTrace();
      return;
    }
    bcql.a(paramView.getContext(), ajya.a(2131716459), 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.lrtbwidget.VideoViewVideoHolder
 * JD-Core Version:    0.7.0.1
 */