package com.tencent.mobileqq.activity.aio;

import afud;
import afur;
import afws;
import afwt;
import afwu;
import afwv;
import afww;
import agar;
import agas;
import agau;
import ahvz;
import alqs;
import alqt;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.text.method.LinkMovementMethod;
import android.text.style.ImageSpan;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ProgressBar;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import anmw;
import anni;
import apyb;
import aqye;
import aqyf;
import aruy;
import aruz;
import awwm;
import axbp;
import axci;
import bbdx;
import bcnj;
import bcst;
import bfup;
import bggq;
import bgsu;
import bgtn;
import bgtv;
import bgyg;
import bhbe;
import bhyj;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.aio.helper.AIOLongShotHelper;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.NamePlateCfgInfo;
import com.tencent.mobileqq.emoticon.EmojiStickerManager;
import com.tencent.mobileqq.emoticon.EmojiStickerManager.StickerInfo;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.troop.honor.widget.TroopHonorView;
import com.tencent.mobileqq.troop.troopMemberLevel.TroopMemberNewLevelView;
import com.tencent.mobileqq.troop.widget.TroopRobotNextTipsView;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.vas.avatar.VasAvatar;
import com.tencent.mobileqq.widget.ColorNickTextView;
import com.tencent.mobileqq.widget.MosaicURLImageView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.HorizontalListView;
import java.util.ArrayList;
import java.util.Iterator;

public class BaseChatItemLayout
  extends ChatItemAnimLayout
  implements agas, alqs
{
  public static final int A;
  public static int B;
  public static int C;
  public static int D;
  public static int E;
  public static int F;
  public static int G;
  public static int H;
  public static int I;
  public static int J;
  public static int K;
  public static int L;
  public static int M;
  public static int N;
  public static int O;
  public static int P;
  public static int Q;
  public static int R;
  public static int S;
  public static int T;
  public static int U;
  public static int V;
  public static int W;
  public static final float a;
  public static final int a;
  public static afww a;
  public static CompoundButton.OnCheckedChangeListener a;
  public static boolean a;
  private static final int ab;
  private static final int ac;
  public static final float b;
  public static final int b;
  public static final float c;
  public static final int c;
  @Deprecated
  public static final float d;
  public static int d;
  public static int e;
  public static int f;
  public static int g;
  public static final int h;
  public static final int i;
  public static final int j;
  public static final int k;
  public static final int l;
  public static final int m;
  public static final int n;
  public static final int o;
  public static final int p;
  public static final int q;
  public static final int r;
  public static final int s;
  public static final int t;
  public static final int u;
  public static final int v;
  public static final int w;
  public static final int x;
  public static int y;
  public static final int z;
  int X = 0;
  int Y;
  afwv jdField_a_of_type_Afwv = null;
  private alqt jdField_a_of_type_Alqt;
  private Paint jdField_a_of_type_AndroidGraphicsPaint;
  private Rect jdField_a_of_type_AndroidGraphicsRect;
  private MotionEvent jdField_a_of_type_AndroidViewMotionEvent;
  View jdField_a_of_type_AndroidViewView;
  public CheckBox a;
  public ImageView a;
  LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  public ProgressBar a;
  public TextView a;
  public aruz a;
  public URLImageView a;
  ChatMessage jdField_a_of_type_ComTencentMobileqqDataChatMessage;
  public TroopHonorView a;
  public TroopMemberNewLevelView a;
  TroopRobotNextTipsView jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopRobotNextTipsView;
  public VasAvatar a;
  public ArrayList<aruy> a;
  private int[] jdField_a_of_type_ArrayOfInt = new int[2];
  private int ad = -1;
  private int ae = -1;
  private int af = -1;
  private int ag = -1;
  private int ah = -1;
  private int ai = -1;
  private int aj;
  private int ak = -1;
  private int al = -1;
  private int am = -1;
  private int an;
  private int ao;
  private int ap;
  private int aq;
  View jdField_b_of_type_AndroidViewView;
  public ImageView b;
  LinearLayout jdField_b_of_type_AndroidWidgetLinearLayout;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  URLImageView jdField_b_of_type_ComTencentImageURLImageView;
  public ImageView c;
  public TextView c;
  public ImageView d;
  TextView jdField_d_of_type_AndroidWidgetTextView;
  private boolean jdField_d_of_type_Boolean;
  ImageView jdField_e_of_type_AndroidWidgetImageView;
  public TextView e;
  private boolean jdField_e_of_type_Boolean;
  ImageView jdField_f_of_type_AndroidWidgetImageView;
  TextView jdField_f_of_type_AndroidWidgetTextView;
  private boolean jdField_f_of_type_Boolean;
  private TextView jdField_g_of_type_AndroidWidgetTextView;
  private boolean jdField_g_of_type_Boolean;
  private TextView jdField_h_of_type_AndroidWidgetTextView;
  private boolean jdField_h_of_type_Boolean = this.jdField_g_of_type_Boolean;
  private boolean i;
  private boolean j;
  
  static
  {
    jdField_a_of_type_Int = bgtn.b(5.0F);
    ab = bgtn.b(2.0F);
    ac = bgtn.b(18.0F);
    BaseApplication localBaseApplication = BaseApplicationImpl.getContext();
    DisplayMetrics localDisplayMetrics = localBaseApplication.getResources().getDisplayMetrics();
    jdField_d_of_type_Float = localDisplayMetrics.density;
    jdField_a_of_type_Float = localBaseApplication.getResources().getDimensionPixelSize(2131296401);
    jdField_b_of_type_Float = localBaseApplication.getResources().getDimensionPixelSize(2131298952);
    jdField_c_of_type_Float = localBaseApplication.getResources().getDimensionPixelSize(2131296401);
    jdField_h_of_type_Int = localBaseApplication.getResources().getDimensionPixelSize(2131296330);
    jdField_i_of_type_Int = localBaseApplication.getResources().getDimensionPixelSize(2131296329);
    jdField_j_of_type_Int = localBaseApplication.getResources().getDimensionPixelSize(2131296328);
    k = localBaseApplication.getResources().getDimensionPixelSize(2131296327);
    l = localBaseApplication.getResources().getDimensionPixelSize(2131296326);
    m = localBaseApplication.getResources().getDimensionPixelSize(2131296397);
    n = localBaseApplication.getResources().getDimensionPixelSize(2131296396);
    o = localBaseApplication.getResources().getDimensionPixelSize(2131296395);
    p = localBaseApplication.getResources().getDimensionPixelSize(2131296394);
    s = localBaseApplication.getResources().getDimensionPixelSize(2131296386);
    r = localBaseApplication.getResources().getDimensionPixelSize(2131296336);
    q = localBaseApplication.getResources().getDimensionPixelSize(2131296379);
    jdField_b_of_type_Int = localDisplayMetrics.widthPixels;
    jdField_c_of_type_Int = localDisplayMetrics.heightPixels;
    jdField_d_of_type_Int = Math.min(localDisplayMetrics.widthPixels, localDisplayMetrics.heightPixels);
    jdField_e_of_type_Int = (int)(jdField_d_of_type_Int - 108.0F * jdField_d_of_type_Float);
    jdField_f_of_type_Int = jdField_e_of_type_Int - jdField_j_of_type_Int - k;
    jdField_g_of_type_Int = jdField_f_of_type_Int - s * 2;
    t = localBaseApplication.getResources().getDimensionPixelSize(2131296373);
    u = localBaseApplication.getResources().getDimensionPixelSize(2131296374);
    v = localBaseApplication.getResources().getDimensionPixelSize(2131296375);
    w = localBaseApplication.getResources().getDimensionPixelSize(2131296371);
    x = localBaseApplication.getResources().getDimensionPixelSize(2131296361);
    y = localBaseApplication.getResources().getDimensionPixelSize(2131296359);
    B = localBaseApplication.getResources().getDimensionPixelSize(2131298903);
    B = Math.min(B, jdField_f_of_type_Int);
    int i1 = jdField_d_of_type_Int - t - u - localBaseApplication.getResources().getDimensionPixelSize(2131298898) * 2;
    int i2 = jdField_j_of_type_Int + k + B;
    z = Math.min(i1, i2);
    if (jdField_d_of_type_Int < 1441) {}
    for (A = i1;; A = Math.min(i1, i2))
    {
      C = localBaseApplication.getResources().getDimensionPixelSize(2131296369);
      D = localBaseApplication.getResources().getDimensionPixelSize(2131296368);
      E = localBaseApplication.getResources().getDimensionPixelSize(2131296367);
      F = localBaseApplication.getResources().getDimensionPixelSize(2131296357);
      G = localBaseApplication.getResources().getDimensionPixelSize(2131296356);
      H = localBaseApplication.getResources().getDimensionPixelSize(2131296355);
      I = localBaseApplication.getResources().getDimensionPixelSize(2131296350);
      J = localBaseApplication.getResources().getDimensionPixelSize(2131296352);
      K = localBaseApplication.getResources().getDimensionPixelSize(2131296351);
      M = localBaseApplication.getResources().getDimensionPixelSize(2131296354);
      L = localBaseApplication.getResources().getDimensionPixelSize(2131296353);
      N = localBaseApplication.getResources().getDimensionPixelSize(2131296404);
      O = localBaseApplication.getResources().getDimensionPixelSize(2131296403);
      P = localBaseApplication.getResources().getDimensionPixelSize(2131296405);
      Q = afur.a(26.0F, localBaseApplication.getResources());
      R = localBaseApplication.getResources().getDimensionPixelSize(2131296360);
      S = localBaseApplication.getResources().getDimensionPixelSize(2131296378);
      T = localBaseApplication.getResources().getDimensionPixelSize(2131296376);
      U = localBaseApplication.getResources().getDimensionPixelSize(2131296377);
      V = localBaseApplication.getResources().getDimensionPixelSize(2131296363);
      W = localBaseApplication.getResources().getDimensionPixelSize(2131296362);
      jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener = new afwu();
      return;
    }
  }
  
  public BaseChatItemLayout(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public BaseChatItemLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public BaseChatItemLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setWillNotDraw(false);
    setClipChildren(false);
    setClipToPadding(false);
  }
  
  private int a(float paramFloat1, float paramFloat2)
  {
    int i1 = 2;
    int i2 = this.ad - jdField_a_of_type_Int * 3;
    int i3 = this.ad + jdField_a_of_type_Int * 3;
    int i4 = this.ae - ac - jdField_a_of_type_Int * 2;
    int i5 = this.ae;
    if ((paramFloat1 >= i2) && (paramFloat1 <= i3) && (paramFloat2 >= i4) && (paramFloat2 <= i5) && (this.jdField_d_of_type_Boolean)) {
      i1 = 1;
    }
    int i6;
    int i7;
    int i8;
    int i9;
    do
    {
      return i1;
      if (QLog.isColorLevel()) {
        QLog.d("BaseChatItemLayout", 2, "isTouchOnCursor, left=" + i2 + ",right=" + i3 + ",top=" + i4 + ", bottom=" + i5 + ", x=" + paramFloat1 + ",y=" + paramFloat2);
      }
      i2 = this.af;
      i3 = jdField_a_of_type_Int;
      i4 = this.af;
      i5 = jdField_a_of_type_Int;
      i6 = this.ag;
      i7 = ac;
      i8 = this.ag;
      i9 = jdField_a_of_type_Int;
    } while ((paramFloat1 >= i2 - i3 * 3) && (paramFloat1 <= i4 + i5 * 3) && (paramFloat2 >= i6 - i7) && (paramFloat2 <= i8 + i9 * 2) && (this.jdField_e_of_type_Boolean));
    return -1;
  }
  
  private SpannableStringBuilder a(CharSequence paramCharSequence1, TextView paramTextView, int paramInt, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, CharSequence paramCharSequence2, ColorStateList paramColorStateList, boolean paramBoolean4)
  {
    if ((paramCharSequence1 == null) || ((!paramBoolean1) && (!paramBoolean2) && (!paramBoolean3)))
    {
      paramTextView = null;
      return paramTextView;
    }
    paramColorStateList = paramTextView.getEllipsize();
    if (paramColorStateList != null)
    {
      if (!paramBoolean1) {
        break label284;
      }
      paramInt = (int)(paramInt - Math.ceil(13.0F * jdField_d_of_type_Float));
    }
    label130:
    label274:
    label284:
    for (;;)
    {
      int i1 = paramInt;
      if (paramBoolean2) {
        i1 = (int)(paramInt - Math.ceil(15.0F * jdField_d_of_type_Float));
      }
      if (paramBoolean3) {
        i1 = afur.a(136.0F, getContext().getResources());
      }
      paramInt = i1;
      if (i1 < 0) {
        paramInt = 0;
      }
      paramCharSequence1 = new SpannableStringBuilder(TextUtils.ellipsize(paramCharSequence1, paramTextView.getPaint(), paramInt, paramColorStateList));
      if (paramBoolean1)
      {
        paramTextView = getResources().getDrawable(2130847415);
        paramTextView.setBounds(0, 0, (int)(13.0F * jdField_d_of_type_Float), (int)(13.0F * jdField_d_of_type_Float));
        paramTextView = new ImageSpan(paramTextView, 0);
        paramColorStateList = new SpannableString(" ");
        paramColorStateList.setSpan(paramTextView, 0, 1, 33);
        if ((paramCharSequence1.length() <= 1) || (paramCharSequence1.charAt(paramCharSequence1.length() - 1) != ':')) {
          break label274;
        }
        paramCharSequence1.insert(paramCharSequence1.length() - 1, paramColorStateList);
      }
      for (;;)
      {
        paramTextView = paramCharSequence1;
        if (!paramBoolean3) {
          break;
        }
        paramTextView = paramCharSequence1;
        if (TextUtils.isEmpty(paramCharSequence2)) {
          break;
        }
        paramCharSequence1.append(paramCharSequence2);
        return paramCharSequence1;
        paramCharSequence1 = new SpannableStringBuilder(paramCharSequence1);
        break label130;
        paramCharSequence1.append(paramColorStateList);
      }
    }
  }
  
  private void a(Canvas paramCanvas)
  {
    Object localObject = findViewById(2131364379);
    if (localObject != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqDataChatMessage = ((ChatMessage)((View)localObject).getTag(2131364423));
      this.an = ((View)localObject).getLeft();
      this.ao = ((View)localObject).getMeasuredWidth();
      this.ap = ((View)localObject).getTop();
      this.aq = ((View)localObject).getMeasuredHeight();
    }
    int i2;
    int i1;
    int i3;
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      i2 = 0;
      i1 = 0;
      if (i2 <= this.jdField_a_of_type_JavaUtilArrayList.size() - 1)
      {
        aruy localaruy = (aruy)this.jdField_a_of_type_JavaUtilArrayList.get(i2);
        label151:
        int i4;
        boolean bool;
        if ((this.jdField_a_of_type_ComTencentMobileqqDataChatMessage != null) && (this.jdField_a_of_type_ComTencentMobileqqDataChatMessage.stickerHidden))
        {
          if (localaruy.jdField_a_of_type_Int + this.an + localaruy.jdField_c_of_type_Int / 2 < getMeasuredWidth() / 2)
          {
            i3 = -400;
            localaruy.jdField_e_of_type_Int = i3;
            localaruy.jdField_f_of_type_Int = 0;
          }
        }
        else
        {
          i4 = paramCanvas.getSaveCount();
          paramCanvas.save();
          i3 = localaruy.jdField_a_of_type_Int + this.an;
          int i5 = (int)((localaruy.jdField_a_of_type_Float - 1.0F) * localaruy.jdField_c_of_type_Int);
          int i6 = (int)((localaruy.jdField_a_of_type_Float - 1.0F) * localaruy.jdField_d_of_type_Int);
          paramCanvas.translate(localaruy.jdField_e_of_type_Int + i3 - i5 / 2, localaruy.jdField_b_of_type_Int - i6 / 2);
          paramCanvas.rotate((float)localaruy.jdField_a_of_type_Double, localaruy.jdField_c_of_type_Int * localaruy.jdField_a_of_type_Float / 2.0F, localaruy.jdField_d_of_type_Int * localaruy.jdField_a_of_type_Float / 2.0F);
          localaruy.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setAlpha(localaruy.jdField_f_of_type_Int);
          localaruy.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setBounds(0, 0, (int)(localaruy.jdField_c_of_type_Int * localaruy.jdField_a_of_type_Float), (int)(localaruy.jdField_d_of_type_Int * localaruy.jdField_a_of_type_Float));
          localaruy.jdField_a_of_type_AndroidGraphicsDrawableDrawable.draw(paramCanvas);
          paramCanvas.restoreToCount(i4);
          if ((!localaruy.jdField_a_of_type_Boolean) && ((!(localaruy.jdField_a_of_type_AndroidGraphicsDrawableDrawable instanceof URLDrawable)) || (((URLDrawable)localaruy.jdField_a_of_type_AndroidGraphicsDrawableDrawable).getStatus() == 1)))
          {
            if ((localaruy.jdField_c_of_type_Int - localaruy.jdField_g_of_type_Int >= 0) && (localaruy.jdField_d_of_type_Int - localaruy.jdField_h_of_type_Int >= 0)) {
              break label677;
            }
            bool = true;
            label417:
            localaruy.jdField_a_of_type_Boolean = bool;
            if (localaruy.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiStickerManager$StickerInfo != null) {
              localaruy.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiStickerManager$StickerInfo.isShown = localaruy.jdField_a_of_type_Boolean;
            }
            if (!localaruy.jdField_a_of_type_Boolean)
            {
              i4 = paramCanvas.getSaveCount();
              paramCanvas.save();
              paramCanvas.translate(localaruy.jdField_e_of_type_Int + i3 - localaruy.jdField_c_of_type_Int / 2 + localaruy.jdField_g_of_type_Int, localaruy.jdField_b_of_type_Int - localaruy.jdField_d_of_type_Int / 2 + localaruy.jdField_h_of_type_Int);
              paramCanvas.clipRect(0, 0, localaruy.jdField_c_of_type_Int, localaruy.jdField_d_of_type_Int);
              if (localaruy.jdField_b_of_type_AndroidGraphicsDrawableDrawable != null) {
                break label683;
              }
            }
          }
        }
        label677:
        label683:
        for (localObject = EmojiStickerManager.a().a(getContext()).mutate();; localObject = localaruy.jdField_b_of_type_AndroidGraphicsDrawableDrawable)
        {
          ((Drawable)localObject).setBounds(0, 0, localaruy.jdField_c_of_type_Int, localaruy.jdField_d_of_type_Int);
          ((Drawable)localObject).draw(paramCanvas);
          paramCanvas.restoreToCount(i4);
          localaruy.jdField_g_of_type_Int += EmojiStickerManager.jdField_j_of_type_Int;
          localaruy.jdField_h_of_type_Int += EmojiStickerManager.jdField_j_of_type_Int;
          localaruy.jdField_a_of_type_Float -= EmojiStickerManager.jdField_a_of_type_Float;
          if (localaruy.jdField_a_of_type_Float < 1.0F) {
            localaruy.jdField_a_of_type_Float = 1.0F;
          }
          if (localaruy.jdField_a_of_type_Boolean) {
            localaruy.jdField_a_of_type_Float = 1.0F;
          }
          if (localaruy.jdField_a_of_type_Boolean) {
            break label808;
          }
          i1 = 1;
          i2 += 1;
          break;
          i3 = 400;
          break label151;
          bool = false;
          break label417;
        }
      }
      h();
    }
    for (;;)
    {
      if ((EmojiStickerManager.jdField_b_of_type_Boolean) || ((!EmojiStickerManager.jdField_b_of_type_Boolean) && (this.jdField_g_of_type_Boolean)))
      {
        i3 = paramCanvas.getSaveCount();
        paramCanvas.clipRect(this.an, this.ap, this.an + this.ao, this.ap + this.aq);
        if (!this.jdField_g_of_type_Boolean) {
          break label798;
        }
      }
      label798:
      for (i2 = Color.parseColor("#19000000");; i2 = Color.parseColor("#00000000"))
      {
        paramCanvas.drawColor(i2);
        paramCanvas.restoreToCount(i3);
        if (!EmojiStickerManager.jdField_b_of_type_Boolean) {
          this.jdField_g_of_type_Boolean = false;
        }
        if (i1 != 0) {
          invalidate();
        }
        return;
      }
      label808:
      break;
      i1 = 0;
    }
  }
  
  private boolean a(float paramFloat1, float paramFloat2)
  {
    if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() > 0))
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext())
      {
        aruy localaruy = (aruy)localIterator.next();
        int i2 = localaruy.jdField_a_of_type_Int;
        int i3 = this.an;
        int i4 = (int)((localaruy.jdField_a_of_type_Float - 1.0F) * localaruy.jdField_c_of_type_Int);
        int i1 = (int)((localaruy.jdField_a_of_type_Float - 1.0F) * localaruy.jdField_d_of_type_Int);
        i2 = i2 + i3 + localaruy.jdField_e_of_type_Int - i4 / 2;
        i1 = localaruy.jdField_b_of_type_Int - i1 / 2;
        if ((paramFloat1 > i2) && (paramFloat1 < i2 + localaruy.jdField_a_of_type_Float * localaruy.jdField_c_of_type_Int) && (paramFloat2 > i1))
        {
          float f1 = i1;
          float f2 = localaruy.jdField_a_of_type_Float;
          if (paramFloat2 < localaruy.jdField_d_of_type_Int * f2 + f1) {
            return true;
          }
        }
      }
    }
    return false;
  }
  
  private boolean a(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2)
  {
    if (paramMotionEvent2.getEventTime() - paramMotionEvent1.getEventTime() > 200L) {}
    int i1;
    int i2;
    do
    {
      return false;
      i1 = (int)paramMotionEvent1.getX() - (int)paramMotionEvent2.getX();
      i2 = (int)paramMotionEvent1.getY() - (int)paramMotionEvent2.getY();
    } while (i1 * i1 + i2 * i2 >= 10000);
    return true;
  }
  
  private void c(int paramInt1, int paramInt2, int paramInt3)
  {
    int i2;
    int i1;
    if (this.ak == 1)
    {
      i2 = this.al;
      i1 = this.jdField_a_of_type_Alqt.a(paramInt1, paramInt2);
      if (paramInt3 == -1) {
        this.jdField_a_of_type_Alqt.a(this.ak, false);
      }
      if (QLog.isColorLevel()) {
        QLog.d("BaseChatItemLayout", 2, "updateCursorLocation, touchIndex=" + i1 + ", type=" + this.ak);
      }
      if (i1 != -1) {
        break label109;
      }
    }
    label109:
    do
    {
      do
      {
        do
        {
          return;
          i2 = this.am;
          break;
          if (i1 == i2) {
            break label562;
          }
          if (this.ak == 1) {
            if (i1 < this.al)
            {
              paramInt3 = this.am;
              this.al = i1;
            }
          }
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.d("BaseChatItemLayout", 2, "update selection, s=" + i1 + ", e=" + paramInt3);
            }
            this.jdField_a_of_type_Alqt.a(i1, paramInt3);
            this.jdField_a_of_type_Alqt.b(paramInt1, paramInt2);
            if (this.ak != 1) {
              break label530;
            }
            if (this.ah == -1) {
              break;
            }
            this.jdField_a_of_type_Alqt.a(paramInt1, this.ah, true);
            return;
            if ((i1 > this.al) && (i1 < this.am))
            {
              paramInt3 = this.am;
              this.al = i1;
            }
            else if (i1 == this.al)
            {
              i1 = this.al;
              paramInt3 = this.am;
            }
            else if (i1 == this.am)
            {
              i1 = this.am - 1;
              paramInt3 = this.am;
            }
            else
            {
              i2 = this.am;
              this.al = this.am;
              this.am = i1;
              this.ak = 2;
              this.jdField_a_of_type_Alqt.a(this.ak);
              paramInt3 = i1;
              i1 = i2;
              continue;
              if (i1 > this.am)
              {
                i2 = this.al;
                this.am = i1;
                paramInt3 = i1;
                i1 = i2;
              }
              else if ((i1 < this.am) && (i1 > this.al))
              {
                i2 = this.al;
                this.am = i1;
                paramInt3 = i1;
                i1 = i2;
              }
              else if (i1 == this.am)
              {
                i1 = this.al;
                paramInt3 = this.am;
              }
              else if (i1 == this.al)
              {
                i1 = this.al;
                paramInt3 = this.al + 1;
              }
              else
              {
                paramInt3 = this.al;
                this.am = this.al;
                this.al = i1;
                this.ak = 1;
                this.jdField_a_of_type_Alqt.a(this.ak);
              }
            }
          }
        } while ((this.ak != 2) || (this.ai == -1));
        this.jdField_a_of_type_Alqt.a(paramInt1, this.ai, true);
        return;
        if (this.ak != 1) {
          break label594;
        }
      } while (this.ah == -1);
      this.jdField_a_of_type_Alqt.a(paramInt1, this.ah, false);
      return;
    } while ((this.ak != 2) || (this.ai == -1));
    label530:
    label562:
    label594:
    this.jdField_a_of_type_Alqt.a(paramInt1, this.ai, false);
  }
  
  private void d(int paramInt)
  {
    if (this.Y != paramInt)
    {
      this.Y = paramInt;
      if (this.jdField_a_of_type_ComTencentMobileqqVasAvatarVasAvatar != null) {
        ((RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqVasAvatarVasAvatar.getLayoutParams()).addRule(3, this.Y);
      }
      if (this.jdField_a_of_type_ComTencentImageURLImageView != null) {
        ((RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentImageURLImageView.getLayoutParams()).addRule(3, this.Y);
      }
      if (this.jdField_c_of_type_AndroidWidgetTextView != null) {
        ((RelativeLayout.LayoutParams)this.jdField_c_of_type_AndroidWidgetTextView.getLayoutParams()).addRule(3, this.Y);
      }
      if (this.jdField_g_of_type_AndroidWidgetTextView != null) {
        ((RelativeLayout.LayoutParams)this.jdField_g_of_type_AndroidWidgetTextView.getLayoutParams()).addRule(3, this.Y);
      }
      if (this.jdField_a_of_type_AndroidWidgetLinearLayout != null) {
        ((RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetLinearLayout.getLayoutParams()).addRule(3, this.Y);
      }
      if (this.jdField_b_of_type_AndroidWidgetLinearLayout != null) {
        ((RelativeLayout.LayoutParams)this.jdField_b_of_type_AndroidWidgetLinearLayout.getLayoutParams()).addRule(3, this.Y);
      }
      if ((this.jdField_b_of_type_AndroidViewView != null) && ((this.jdField_e_of_type_AndroidWidgetTextView == null) || (this.jdField_e_of_type_AndroidWidgetTextView.getVisibility() != 0)))
      {
        ((RelativeLayout.LayoutParams)this.jdField_b_of_type_AndroidViewView.getLayoutParams()).addRule(3, this.Y);
        if (QLog.isColorLevel()) {
          QLog.d("BubbleView", 2, " setTopId mTopId = " + this.Y);
        }
      }
    }
  }
  
  private void e()
  {
    Object localObject2 = null;
    AIOLongShotHelper localAIOLongShotHelper = AIOLongShotHelper.a();
    Object localObject1 = localObject2;
    if (localAIOLongShotHelper != null)
    {
      localObject1 = localObject2;
      if (localAIOLongShotHelper.a())
      {
        localObject1 = localObject2;
        if (localAIOLongShotHelper.b()) {
          localObject1 = new bhyj(10);
        }
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqVasAvatarVasAvatar.setMosaicEffect((bhyj)localObject1);
  }
  
  private void e(int paramInt)
  {
    if (paramInt > 0)
    {
      String str = bgtv.a(bgyg.a("extendnameplateiconurl", this.jdField_f_of_type_AndroidWidgetImageView), String.valueOf(paramInt));
      this.jdField_f_of_type_AndroidWidgetImageView.setVisibility(0);
      VipUtils.a(getResources(), this.jdField_f_of_type_AndroidWidgetImageView, str, getResources().getDrawable(2130847051));
      str = bgyg.a("extendnameplatejumpurl_" + paramInt, this.jdField_f_of_type_AndroidWidgetImageView);
      this.jdField_f_of_type_AndroidWidgetImageView.setTag(str);
    }
  }
  
  private void f()
  {
    int i6 = 0;
    if (this.jdField_e_of_type_AndroidWidgetTextView == null) {
      return;
    }
    int i1;
    int i2;
    label49:
    int i3;
    label68:
    int i4;
    if (this.jdField_e_of_type_AndroidWidgetImageView != null) {
      if (this.jdField_e_of_type_AndroidWidgetImageView.getVisibility() == 0)
      {
        i1 = 1;
        if (this.jdField_f_of_type_AndroidWidgetTextView == null) {
          break label166;
        }
        if (this.jdField_f_of_type_AndroidWidgetTextView.getVisibility() != 0) {
          break label161;
        }
        i2 = 1;
        if (this.jdField_a_of_type_ComTencentMobileqqTroopHonorWidgetTroopHonorView == null) {
          break label176;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqTroopHonorWidgetTroopHonorView.getVisibility() != 0) {
          break label171;
        }
        i3 = 1;
        if (this.jdField_c_of_type_AndroidWidgetTextView == null) {
          break label187;
        }
        if (this.jdField_c_of_type_AndroidWidgetTextView.getVisibility() != 0) {
          break label181;
        }
        i4 = 1;
      }
    }
    for (;;)
    {
      int i5 = i6;
      if (this.jdField_a_of_type_ComTencentMobileqqTroopTroopMemberLevelTroopMemberNewLevelView != null)
      {
        i5 = i6;
        if (this.jdField_a_of_type_ComTencentMobileqqTroopTroopMemberLevelTroopMemberNewLevelView.getVisibility() == 0) {
          i5 = 1;
        }
      }
      if ((i1 == 0) && (i2 == 0) && (i3 == 0) && (i4 == 0) && (i5 == 0)) {
        break label193;
      }
      this.jdField_e_of_type_AndroidWidgetTextView.setMaxWidth(jdField_f_of_type_Int / 2);
      return;
      i1 = 0;
      break;
      i1 = 0;
      break;
      label161:
      i2 = 0;
      break label49;
      label166:
      i2 = 0;
      break label49;
      label171:
      i3 = 0;
      break label68;
      label176:
      i3 = 0;
      break label68;
      label181:
      i4 = 0;
      continue;
      label187:
      i4 = 0;
    }
    label193:
    this.jdField_e_of_type_AndroidWidgetTextView.setMaxWidth(jdField_f_of_type_Int);
  }
  
  private void g()
  {
    if (this.jdField_a_of_type_Alqt == null) {
      throw new IllegalStateException("Has no bound delegate!");
    }
  }
  
  private void h()
  {
    boolean bool;
    aruy localaruy;
    if ((this.jdField_i_of_type_Boolean) && (this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() > 0))
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      bool = false;
      if (localIterator.hasNext())
      {
        localaruy = (aruy)localIterator.next();
        if (localaruy.jdField_a_of_type_Int + this.an + localaruy.jdField_c_of_type_Int / 2 < getMeasuredWidth() / 2) {
          if (Math.abs(localaruy.jdField_e_of_type_Int) > 200)
          {
            localaruy.jdField_e_of_type_Int -= EmojiStickerManager.jdField_i_of_type_Int;
            localaruy.jdField_f_of_type_Int -= Math.abs(EmojiStickerManager.jdField_i_of_type_Int / 2);
            localaruy.jdField_f_of_type_Int = Math.min(255, Math.max(0, localaruy.jdField_f_of_type_Int));
            label138:
            if (localaruy.jdField_e_of_type_Int > 0)
            {
              localaruy.jdField_e_of_type_Int = 0;
              if (EmojiStickerManager.jdField_a_of_type_AndroidViewView == null) {
                localaruy.jdField_f_of_type_Int = 255;
              }
              this.jdField_i_of_type_Boolean = false;
              bool = false;
            }
            label170:
            if (localaruy.jdField_e_of_type_Int < -400)
            {
              localaruy.jdField_e_of_type_Int = -400;
              localaruy.jdField_f_of_type_Int = 0;
              this.jdField_i_of_type_Boolean = false;
              bool = true;
            }
            if (localaruy.jdField_e_of_type_Int <= 400) {
              break label446;
            }
            localaruy.jdField_e_of_type_Int = 400;
            localaruy.jdField_f_of_type_Int = 0;
            this.jdField_i_of_type_Boolean = false;
            bool = true;
          }
        }
      }
    }
    label424:
    label446:
    for (;;)
    {
      break;
      localaruy.jdField_f_of_type_Int += Math.abs(EmojiStickerManager.jdField_i_of_type_Int / 2);
      localaruy.jdField_f_of_type_Int = Math.min(255, Math.max(0, localaruy.jdField_f_of_type_Int));
      localaruy.jdField_e_of_type_Int += EmojiStickerManager.jdField_i_of_type_Int;
      break label138;
      if (Math.abs(localaruy.jdField_e_of_type_Int) < 200)
      {
        localaruy.jdField_f_of_type_Int += Math.abs(EmojiStickerManager.jdField_i_of_type_Int / 2);
        localaruy.jdField_f_of_type_Int = Math.min(255, Math.max(0, localaruy.jdField_f_of_type_Int));
      }
      for (localaruy.jdField_e_of_type_Int -= EmojiStickerManager.jdField_i_of_type_Int;; localaruy.jdField_e_of_type_Int += EmojiStickerManager.jdField_i_of_type_Int)
      {
        if (localaruy.jdField_e_of_type_Int >= 0) {
          break label424;
        }
        localaruy.jdField_e_of_type_Int = 0;
        if (EmojiStickerManager.jdField_a_of_type_AndroidViewView == null) {
          localaruy.jdField_f_of_type_Int = 255;
        }
        this.jdField_i_of_type_Boolean = false;
        bool = false;
        break;
        localaruy.jdField_f_of_type_Int -= Math.abs(EmojiStickerManager.jdField_i_of_type_Int / 2);
        localaruy.jdField_f_of_type_Int = Math.min(255, Math.max(0, localaruy.jdField_f_of_type_Int));
      }
      break label170;
      if (this.jdField_a_of_type_ComTencentMobileqqDataChatMessage != null) {
        this.jdField_a_of_type_ComTencentMobileqqDataChatMessage.stickerHidden = bool;
      }
      invalidate();
      return;
    }
  }
  
  public int a()
  {
    return this.Y;
  }
  
  public int a(float paramFloat1, float paramFloat2, int paramInt1, int paramInt2)
  {
    if ((!this.jdField_d_of_type_Boolean) && (!this.jdField_e_of_type_Boolean)) {
      return -1;
    }
    return new agar(this, this.jdField_a_of_type_Alqt).a(paramFloat1, paramFloat2, paramInt1, paramInt2);
  }
  
  public int a(int paramInt)
  {
    if (paramInt == 1) {
      return this.ad;
    }
    return this.af;
  }
  
  @NonNull
  public View a()
  {
    return this;
  }
  
  public LinearLayout a()
  {
    return this.jdField_a_of_type_AndroidWidgetLinearLayout;
  }
  
  public TextView a()
  {
    return this.jdField_c_of_type_AndroidWidgetTextView;
  }
  
  protected void a()
  {
    RelativeLayout.LayoutParams localLayoutParams;
    if ((this.jdField_a_of_type_ComTencentImageURLImageView != null) && (this.jdField_a_of_type_ComTencentImageURLImageView.getVisibility() == 0))
    {
      localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentImageURLImageView.getLayoutParams();
      if (this.X != 1) {
        break label59;
      }
      localLayoutParams.addRule(11);
      localLayoutParams.addRule(9, 0);
    }
    for (;;)
    {
      localLayoutParams.addRule(3, this.Y);
      return;
      label59:
      localLayoutParams.addRule(9);
      localLayoutParams.addRule(11, 0);
      if ((this.jdField_a_of_type_AndroidWidgetCheckBox != null) && (this.jdField_a_of_type_AndroidWidgetCheckBox.getVisibility() != 8)) {
        localLayoutParams.leftMargin = afur.a(25.0F, getContext().getResources());
      } else {
        localLayoutParams.leftMargin = 0;
      }
    }
  }
  
  public void a(int paramInt)
  {
    if (paramInt == 1) {
      this.jdField_d_of_type_Boolean = false;
    }
    for (;;)
    {
      invalidate();
      return;
      this.jdField_e_of_type_Boolean = false;
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() > 0))
    {
      int i1;
      label45:
      aruy localaruy;
      int i2;
      if ((this.jdField_a_of_type_ComTencentMobileqqDataChatMessage != null) && (this.jdField_a_of_type_ComTencentMobileqqDataChatMessage.stickerHidden))
      {
        i1 = 1;
        Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
        if (!localIterator.hasNext()) {
          break label419;
        }
        localaruy = (aruy)localIterator.next();
        if ((this.jdField_a_of_type_ComTencentMobileqqDataChatMessage != null) && (i1 != 0))
        {
          if (localaruy.jdField_a_of_type_Int + this.an + localaruy.jdField_c_of_type_Int / 2 >= getMeasuredWidth() / 2) {
            break label267;
          }
          i2 = -400;
          label110:
          localaruy.jdField_e_of_type_Int = i2;
          localaruy.jdField_f_of_type_Int = 0;
        }
        if ((paramInt2 != EmojiStickerManager.jdField_h_of_type_Int) || (localaruy.jdField_e_of_type_Int != 0))
        {
          if (paramInt2 != EmojiStickerManager.jdField_g_of_type_Int) {
            break label290;
          }
          if (localaruy.jdField_a_of_type_Int + this.an + localaruy.jdField_c_of_type_Int / 2 >= getMeasuredWidth() / 2) {
            break label275;
          }
          localaruy.jdField_e_of_type_Int -= paramInt1;
          localaruy.jdField_f_of_type_Int -= Math.abs(paramInt1 / 2);
          localaruy.jdField_f_of_type_Int = Math.min(255, Math.max(0, localaruy.jdField_f_of_type_Int));
        }
      }
      label267:
      label275:
      label290:
      while (paramInt2 != EmojiStickerManager.jdField_h_of_type_Int) {
        for (;;)
        {
          if (localaruy.jdField_e_of_type_Int < -400) {
            localaruy.jdField_e_of_type_Int = -400;
          }
          if (localaruy.jdField_e_of_type_Int <= 400) {
            break label45;
          }
          localaruy.jdField_e_of_type_Int = 400;
          break label45;
          i1 = 0;
          break;
          i2 = 400;
          break label110;
          localaruy.jdField_e_of_type_Int += paramInt1;
        }
      }
      if (localaruy.jdField_a_of_type_Int + this.an + localaruy.jdField_c_of_type_Int / 2 < getMeasuredWidth() / 2)
      {
        localaruy.jdField_e_of_type_Int += paramInt1;
        if (localaruy.jdField_e_of_type_Int > 0) {
          localaruy.jdField_e_of_type_Int = 0;
        }
      }
      for (;;)
      {
        localaruy.jdField_f_of_type_Int += Math.abs(paramInt1 / 2);
        localaruy.jdField_f_of_type_Int = Math.min(255, Math.max(0, localaruy.jdField_f_of_type_Int));
        break;
        localaruy.jdField_e_of_type_Int -= paramInt1;
        if (localaruy.jdField_e_of_type_Int < 0) {
          localaruy.jdField_e_of_type_Int = 0;
        }
      }
      label419:
      if ((i1 != 0) && (this.jdField_a_of_type_ComTencentMobileqqDataChatMessage != null)) {
        this.jdField_a_of_type_ComTencentMobileqqDataChatMessage.stickerHidden = false;
      }
      invalidate();
    }
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt3 == 2)
    {
      this.al = (paramInt1 - paramInt2);
      return;
    }
    this.am = (paramInt1 + paramInt2);
  }
  
  public void a(alqt paramalqt)
  {
    this.jdField_a_of_type_Alqt = paramalqt;
  }
  
  public void a(Context paramContext, BaseAdapter paramBaseAdapter)
  {
    paramBaseAdapter = (ImageView)findViewById(2131364402);
    Object localObject;
    if (paramBaseAdapter == null)
    {
      localObject = new ImageView(paramContext);
      ((ImageView)localObject).setId(2131364402);
      ((ImageView)localObject).setImageResource(2130838074);
      paramBaseAdapter = new RelativeLayout.LayoutParams(V, V);
      paramBaseAdapter.leftMargin = (paramContext.getResources().getDisplayMetrics().widthPixels + W - getPaddingLeft());
      paramBaseAdapter.addRule(15, 2131364379);
      addView((View)localObject, paramBaseAdapter);
      ((ImageView)localObject).setVisibility(4);
      paramContext = (Context)localObject;
    }
    for (;;)
    {
      if (this.jdField_b_of_type_AndroidViewView != null) {
        this.jdField_b_of_type_AndroidViewView.post(new BaseChatItemLayout.1(this, paramBaseAdapter, paramContext));
      }
      return;
      if ((getScrollX() != 0) && ((paramContext instanceof FragmentActivity)))
      {
        paramContext = ((FragmentActivity)paramContext).getChatFragment();
        if (paramContext != null)
        {
          paramContext = paramContext.a();
          if (paramContext != null)
          {
            paramContext = (apyb)paramContext.a(50);
            if (paramContext != null) {
              paramContext.a(this);
            }
          }
        }
      }
      localObject = (RelativeLayout.LayoutParams)paramBaseAdapter.getLayoutParams();
      paramContext = paramBaseAdapter;
      paramBaseAdapter = (BaseAdapter)localObject;
    }
  }
  
  protected void a(ImageView paramImageView, boolean paramBoolean)
  {
    if (paramImageView != null)
    {
      paramImageView = (RelativeLayout.LayoutParams)paramImageView.getLayoutParams();
      if (paramBoolean)
      {
        paramImageView.addRule(0, 2131364379);
        paramImageView.addRule(1, 0);
      }
    }
    else
    {
      return;
    }
    paramImageView.addRule(1, 2131364379);
    paramImageView.addRule(0, 0);
  }
  
  protected void a(ProgressBar paramProgressBar, boolean paramBoolean)
  {
    if (paramProgressBar != null)
    {
      paramProgressBar = (RelativeLayout.LayoutParams)paramProgressBar.getLayoutParams();
      if (paramBoolean)
      {
        paramProgressBar.addRule(0, 2131364379);
        paramProgressBar.addRule(1, 0);
      }
    }
    else
    {
      return;
    }
    paramProgressBar.addRule(1, 2131364379);
    paramProgressBar.addRule(0, 0);
  }
  
  void a(QQAppInterface paramQQAppInterface, boolean paramBoolean1, int paramInt, boolean paramBoolean2)
  {
    if (paramBoolean1)
    {
      if (this.jdField_d_of_type_AndroidWidgetTextView == null)
      {
        this.jdField_d_of_type_AndroidWidgetTextView = new TextView(getContext());
        this.jdField_d_of_type_AndroidWidgetTextView.setId(2131364415);
        this.jdField_d_of_type_AndroidWidgetTextView.setGravity(16);
        this.jdField_d_of_type_AndroidWidgetTextView.setIncludeFontPadding(false);
        this.jdField_d_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(afur.a(2.0F, this.jdField_d_of_type_AndroidWidgetTextView.getContext().getResources()));
        this.jdField_d_of_type_AndroidWidgetTextView.setPadding(afur.a(4.0F, this.jdField_d_of_type_AndroidWidgetTextView.getContext().getResources()), 0, afur.a(4.0F, this.jdField_d_of_type_AndroidWidgetTextView.getContext().getResources()), 0);
        this.jdField_d_of_type_AndroidWidgetTextView.setText("LV" + paramInt);
        this.jdField_d_of_type_AndroidWidgetTextView.setTextColor(-1);
        paramQQAppInterface = this.jdField_d_of_type_AndroidWidgetTextView.getContext().getResources().getDrawable(2130845508);
        arrayOfInt = axci.a(this.jdField_d_of_type_AndroidWidgetTextView.getContext());
        i2 = Color.parseColor("#FFCC59");
        i1 = i2;
        if (arrayOfInt != null)
        {
          i1 = i2;
          if (paramInt < arrayOfInt.length) {
            i1 = arrayOfInt[paramInt];
          }
        }
        this.jdField_d_of_type_AndroidWidgetTextView.setBackgroundDrawable(bfup.a(this.jdField_d_of_type_AndroidWidgetTextView.getContext().getResources(), i1, paramQQAppInterface));
        this.jdField_d_of_type_AndroidWidgetTextView.setTextSize(1, 10.0F);
        paramQQAppInterface = new RelativeLayout.LayoutParams(-2, -2);
        paramQQAppInterface.bottomMargin = bggq.a(getContext(), 1.0F);
        paramQQAppInterface.topMargin = bggq.a(getContext(), 1.0F);
        paramQQAppInterface.addRule(6, 2131364397);
        if (this.jdField_b_of_type_AndroidViewView != null)
        {
          ((RelativeLayout.LayoutParams)this.jdField_b_of_type_AndroidViewView.getLayoutParams()).addRule(3, 2131364397);
          if (QLog.isColorLevel()) {
            QLog.d("BubbleView", 2, " setTroopMemberGlamour mTopId = R.id.chat_item_nick_name");
          }
        }
        addView(this.jdField_d_of_type_AndroidWidgetTextView, paramQQAppInterface);
      }
      paramQQAppInterface = (RelativeLayout.LayoutParams)this.jdField_d_of_type_AndroidWidgetTextView.getLayoutParams();
      if (b())
      {
        paramQQAppInterface.rightMargin = afur.a(2.0F, getContext().getResources());
        if ((this.jdField_g_of_type_AndroidWidgetTextView != null) && (this.jdField_g_of_type_AndroidWidgetTextView.getVisibility() == 0))
        {
          paramQQAppInterface.addRule(0, 2131364397);
          paramQQAppInterface.addRule(1, 0);
          paramQQAppInterface.leftMargin = afur.a(2.0F, getContext().getResources());
          paramQQAppInterface = (RelativeLayout.LayoutParams)this.jdField_g_of_type_AndroidWidgetTextView.getLayoutParams();
          paramQQAppInterface.addRule(0, 2131364415);
          paramQQAppInterface.addRule(1, 0);
          this.jdField_d_of_type_AndroidWidgetTextView.setText("LV" + paramInt);
          this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
        }
      }
    }
    while ((this.jdField_d_of_type_AndroidWidgetTextView == null) || (this.jdField_d_of_type_AndroidWidgetTextView.getVisibility() == 8)) {
      for (;;)
      {
        int[] arrayOfInt;
        int i2;
        int i1;
        return;
        paramQQAppInterface.leftMargin = 0;
        paramQQAppInterface.addRule(0, 2131364397);
        paramQQAppInterface.addRule(1, 0);
        continue;
        if ((this.jdField_g_of_type_AndroidWidgetTextView != null) && (this.jdField_g_of_type_AndroidWidgetTextView.getVisibility() == 0))
        {
          paramQQAppInterface.leftMargin = afur.a(2.0F, getContext().getResources());
          paramQQAppInterface.rightMargin = 0;
          paramQQAppInterface.addRule(1, 2131364389);
          paramQQAppInterface.addRule(0, 0);
        }
        else
        {
          paramQQAppInterface.leftMargin = E;
          paramQQAppInterface.rightMargin = 0;
          paramQQAppInterface.addRule(1, 2131364388);
          paramQQAppInterface.addRule(0, 0);
        }
      }
    }
    this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
  }
  
  void a(QQAppInterface paramQQAppInterface, boolean paramBoolean, String paramString)
  {
    if (paramBoolean)
    {
      if (this.jdField_d_of_type_AndroidWidgetTextView == null)
      {
        this.jdField_d_of_type_AndroidWidgetTextView = new TextView(getContext());
        this.jdField_d_of_type_AndroidWidgetTextView.setId(2131364415);
        this.jdField_d_of_type_AndroidWidgetTextView.setGravity(16);
        this.jdField_d_of_type_AndroidWidgetTextView.setIncludeFontPadding(false);
        this.jdField_d_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(afur.a(2.0F, this.jdField_d_of_type_AndroidWidgetTextView.getContext().getResources()));
        this.jdField_d_of_type_AndroidWidgetTextView.setPadding(afur.a(4.0F, this.jdField_d_of_type_AndroidWidgetTextView.getContext().getResources()), 0, afur.a(4.0F, this.jdField_d_of_type_AndroidWidgetTextView.getContext().getResources()), 0);
        this.jdField_d_of_type_AndroidWidgetTextView.setText(paramString);
        this.jdField_d_of_type_AndroidWidgetTextView.setTextColor(-1);
        paramQQAppInterface = this.jdField_d_of_type_AndroidWidgetTextView.getContext().getResources().getDrawable(2130845508);
        i1 = Color.parseColor("#12B7F5");
        this.jdField_d_of_type_AndroidWidgetTextView.setBackgroundDrawable(bfup.a(this.jdField_d_of_type_AndroidWidgetTextView.getContext().getResources(), i1, paramQQAppInterface));
        this.jdField_d_of_type_AndroidWidgetTextView.setTextSize(1, 10.0F);
        paramQQAppInterface = new RelativeLayout.LayoutParams(-2, -2);
        paramQQAppInterface.bottomMargin = bggq.a(getContext(), 1.0F);
        paramQQAppInterface.topMargin = bggq.a(getContext(), 1.0F);
        paramQQAppInterface.addRule(6, 2131364397);
        if (this.jdField_b_of_type_AndroidViewView != null)
        {
          ((RelativeLayout.LayoutParams)this.jdField_b_of_type_AndroidViewView.getLayoutParams()).addRule(3, 2131364397);
          if (QLog.isColorLevel()) {
            QLog.d("BubbleView", 2, " setTroopMemberGlamour mTopId = R.id.chat_item_nick_name");
          }
        }
        addView(this.jdField_d_of_type_AndroidWidgetTextView, paramQQAppInterface);
      }
      paramQQAppInterface = (RelativeLayout.LayoutParams)this.jdField_d_of_type_AndroidWidgetTextView.getLayoutParams();
      if (b())
      {
        paramQQAppInterface.rightMargin = afur.a(2.0F, getContext().getResources());
        if ((this.jdField_g_of_type_AndroidWidgetTextView != null) && (this.jdField_g_of_type_AndroidWidgetTextView.getVisibility() == 0))
        {
          paramQQAppInterface.addRule(0, 2131364397);
          paramQQAppInterface.addRule(1, 0);
          paramQQAppInterface.leftMargin = afur.a(2.0F, getContext().getResources());
          paramQQAppInterface = (RelativeLayout.LayoutParams)this.jdField_g_of_type_AndroidWidgetTextView.getLayoutParams();
          paramQQAppInterface.addRule(0, 2131364415);
          paramQQAppInterface.addRule(1, 0);
          this.jdField_d_of_type_AndroidWidgetTextView.setText(paramString);
          this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
        }
      }
    }
    while ((this.jdField_d_of_type_AndroidWidgetTextView == null) || (this.jdField_d_of_type_AndroidWidgetTextView.getVisibility() == 8)) {
      for (;;)
      {
        int i1;
        return;
        paramQQAppInterface.leftMargin = 0;
        paramQQAppInterface.addRule(0, 2131364397);
        paramQQAppInterface.addRule(1, 0);
        continue;
        if ((this.jdField_g_of_type_AndroidWidgetTextView != null) && (this.jdField_g_of_type_AndroidWidgetTextView.getVisibility() == 0))
        {
          paramQQAppInterface.leftMargin = afur.a(2.0F, getContext().getResources());
          paramQQAppInterface.rightMargin = 0;
          paramQQAppInterface.addRule(1, 2131364389);
          paramQQAppInterface.addRule(0, 0);
        }
        else
        {
          paramQQAppInterface.leftMargin = E;
          paramQQAppInterface.rightMargin = 0;
          paramQQAppInterface.addRule(1, 2131364388);
          paramQQAppInterface.addRule(0, 0);
        }
      }
    }
    this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
  }
  
  void a(QQAppInterface paramQQAppInterface, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1) {
      if (!paramBoolean2) {}
    }
    while (this.jdField_a_of_type_AndroidViewView == null)
    {
      do
      {
        return;
        if (this.jdField_a_of_type_AndroidViewView == null)
        {
          this.jdField_a_of_type_AndroidViewView = bbdx.a(getContext());
          if (this.jdField_a_of_type_AndroidViewView != null)
          {
            this.jdField_a_of_type_AndroidViewView.setId(2131364419);
            paramQQAppInterface = new RelativeLayout.LayoutParams(-2, bggq.a(getContext(), 16.0F));
            paramQQAppInterface.addRule(6, 2131364397);
            addView(this.jdField_a_of_type_AndroidViewView, paramQQAppInterface);
            paramQQAppInterface = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidViewView.getLayoutParams();
            paramQQAppInterface.topMargin = afur.a(-1.0F, getContext().getResources());
            paramQQAppInterface.leftMargin = afur.a(4.0F, getContext().getResources());
            paramQQAppInterface.addRule(1, 2131364397);
          }
        }
      } while (this.jdField_a_of_type_AndroidViewView == null);
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      return;
    }
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
  }
  
  public void a(Object paramObject, QQAppInterface paramQQAppInterface, ChatMessage paramChatMessage)
  {
    if ((paramChatMessage.istroop == 1) || (paramChatMessage.istroop == 3000))
    {
      paramChatMessage.isShowQimStyleAvater = ahvz.a().a(paramObject, paramQQAppInterface, paramChatMessage);
      paramChatMessage.isShowQIMStyleGroup = ahvz.a().a(paramObject, paramQQAppInterface, paramChatMessage, false);
      if (!paramChatMessage.isShowQimStyleAvater) {
        break label359;
      }
      paramObject = ahvz.a().b(1);
      if (paramObject != null) {
        break label65;
      }
    }
    label65:
    label359:
    do
    {
      do
      {
        return;
        int i1 = getContext().getResources().getDimensionPixelSize(2131296361);
        int i2 = afur.a(28.0F, getContext().getResources());
        if (this.jdField_a_of_type_AndroidWidgetImageView == null)
        {
          this.jdField_a_of_type_AndroidWidgetImageView = new ImageView(getContext());
          this.jdField_a_of_type_AndroidWidgetImageView.setId(2131364400);
          this.jdField_a_of_type_AndroidWidgetImageView.setScaleType(ImageView.ScaleType.FIT_XY);
          int i3 = afur.a(13.0F, getContext().getResources());
          this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramObject);
          paramObject = new RelativeLayout.LayoutParams(i3, i3);
          paramObject.topMargin = (i1 + i2);
          paramObject.leftMargin = i2;
          paramObject.addRule(7, 2131364388);
          paramObject.addRule(8, 2131364388);
          addView(this.jdField_a_of_type_AndroidWidgetImageView, paramObject);
        }
        while (paramChatMessage.istroop == 1)
        {
          bcst.b(paramQQAppInterface, "CliOper", "", "", "0X80085A6", "0X80085A6", 1, 0, "", "", "", "");
          return;
          RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams();
          localLayoutParams.topMargin = (i1 + i2);
          localLayoutParams.leftMargin = i2;
          localLayoutParams.addRule(7, 2131364388);
          localLayoutParams.addRule(8, 2131364388);
          this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramObject);
        }
      } while (paramChatMessage.istroop != 3000);
      bcst.b(paramQQAppInterface, "CliOper", "", "", "0X80085A5", "0X80085A5", 1, 0, "", "", "", "");
      return;
      paramChatMessage.isShowQimStyleAvater = false;
    } while (this.jdField_a_of_type_AndroidWidgetImageView == null);
    this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(null);
  }
  
  void a(String paramString, int paramInt)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      if (this.jdField_g_of_type_AndroidWidgetTextView == null)
      {
        this.jdField_g_of_type_AndroidWidgetTextView = new TextView(getContext());
        this.jdField_g_of_type_AndroidWidgetTextView.setId(2131364389);
        this.jdField_g_of_type_AndroidWidgetTextView.setTextSize(2, 12.0F);
        this.jdField_g_of_type_AndroidWidgetTextView.setIncludeFontPadding(false);
        this.jdField_g_of_type_AndroidWidgetTextView.setPadding(afur.a(5.0F, getContext().getResources()), 0, afur.a(5.0F, getContext().getResources()), 0);
        this.jdField_g_of_type_AndroidWidgetTextView.setEllipsize(TextUtils.TruncateAt.END);
        this.jdField_g_of_type_AndroidWidgetTextView.setSingleLine();
        this.jdField_g_of_type_AndroidWidgetTextView.setGravity(17);
        localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
        localLayoutParams.topMargin = this.jdField_g_of_type_AndroidWidgetTextView.getContext().getResources().getDimensionPixelSize(2131296369);
        localLayoutParams.bottomMargin = this.jdField_g_of_type_AndroidWidgetTextView.getContext().getResources().getDimensionPixelSize(2131296368);
        localLayoutParams.addRule(3, this.Y);
        if (this.jdField_b_of_type_AndroidViewView != null) {
          ((RelativeLayout.LayoutParams)this.jdField_b_of_type_AndroidViewView.getLayoutParams()).addRule(3, 2131364397);
        }
        addView(this.jdField_g_of_type_AndroidWidgetTextView, localLayoutParams);
      }
      localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_g_of_type_AndroidWidgetTextView.getLayoutParams();
      localLayoutParams.leftMargin = this.jdField_g_of_type_AndroidWidgetTextView.getContext().getResources().getDimensionPixelSize(2131296367);
      localLayoutParams.rightMargin = 0;
      localLayoutParams.addRule(1, 2131364388);
      localLayoutParams.addRule(0, 0);
      this.jdField_g_of_type_AndroidWidgetTextView.setTextColor(-1);
      axbp.a(this.jdField_g_of_type_AndroidWidgetTextView, paramInt);
      this.jdField_g_of_type_AndroidWidgetTextView.setPadding(afur.a(5.0F, getContext().getResources()), 0, afur.a(5.0F, getContext().getResources()), 0);
      if (this.jdField_g_of_type_AndroidWidgetTextView.getVisibility() != 0) {
        this.jdField_g_of_type_AndroidWidgetTextView.setVisibility(0);
      }
      this.jdField_g_of_type_AndroidWidgetTextView.setText(paramString);
      this.jdField_g_of_type_AndroidWidgetTextView.setContentDescription(paramString);
    }
    while ((this.jdField_g_of_type_AndroidWidgetTextView == null) || (this.jdField_g_of_type_AndroidWidgetTextView.getVisibility() == 4))
    {
      RelativeLayout.LayoutParams localLayoutParams;
      return;
    }
    this.jdField_g_of_type_AndroidWidgetTextView.setVisibility(4);
  }
  
  protected void a(boolean paramBoolean, int paramInt)
  {
    RelativeLayout.LayoutParams localLayoutParams;
    if (this.jdField_b_of_type_AndroidViewView != null)
    {
      localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_b_of_type_AndroidViewView.getLayoutParams();
      if (!paramBoolean) {
        break label76;
      }
      localLayoutParams.addRule(0, 2131364388);
      localLayoutParams.addRule(1, 0);
    }
    for (;;)
    {
      localLayoutParams.addRule(3, paramInt);
      if (QLog.isColorLevel()) {
        QLog.d("BubbleView", 2, " setHearIconPosition mTopId = " + paramInt);
      }
      return;
      label76:
      localLayoutParams.addRule(1, 2131364388);
      localLayoutParams.addRule(0, 0);
    }
  }
  
  void a(boolean paramBoolean1, CharSequence paramCharSequence1, ColorStateList paramColorStateList1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, CharSequence paramCharSequence2, ColorStateList paramColorStateList2, String paramString)
  {
    a(paramBoolean1, paramCharSequence1, paramColorStateList1, paramBoolean2, paramBoolean3, paramBoolean4, paramBoolean5, paramCharSequence2, paramColorStateList2, paramString, -100, -100, -100, -100, -100, -100, -100);
  }
  
  public void a(boolean paramBoolean1, CharSequence paramCharSequence1, ColorStateList paramColorStateList1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, CharSequence paramCharSequence2, ColorStateList paramColorStateList2, String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7)
  {
    if (paramBoolean1)
    {
      if (this.jdField_a_of_type_AndroidWidgetLinearLayout == null)
      {
        this.jdField_a_of_type_AndroidWidgetLinearLayout = new RightLinearLayout(getContext());
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setOrientation(0);
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setGravity(53);
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setId(2131364397);
        paramString = new RelativeLayout.LayoutParams(-2, -2);
        paramString.topMargin = getContext().getResources().getDimensionPixelSize(2131296369);
        paramString.bottomMargin = getContext().getResources().getDimensionPixelSize(2131296368);
        paramString.addRule(3, this.Y);
        if (this.jdField_b_of_type_AndroidViewView != null)
        {
          ((RelativeLayout.LayoutParams)this.jdField_b_of_type_AndroidViewView.getLayoutParams()).addRule(3, 2131364397);
          if (QLog.isColorLevel()) {
            QLog.d("BubbleView", 2, " setNick mTopId = R.id.chat_item_nick_name");
          }
        }
        addView(this.jdField_a_of_type_AndroidWidgetLinearLayout, paramString);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqTroopHonorWidgetTroopHonorView == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqTroopHonorWidgetTroopHonorView = new TroopHonorView(getContext());
        this.jdField_a_of_type_ComTencentMobileqqTroopHonorWidgetTroopHonorView.setId(2131364416);
        paramString = new RelativeLayout.LayoutParams(-2, -2);
        paramString.leftMargin = bgtn.a(2.0F);
        this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(this.jdField_a_of_type_ComTencentMobileqqTroopHonorWidgetTroopHonorView, paramString);
      }
      if (this.jdField_f_of_type_AndroidWidgetTextView == null)
      {
        this.jdField_f_of_type_AndroidWidgetTextView = new TextView(getContext());
        this.jdField_f_of_type_AndroidWidgetTextView.setId(2131364370);
        this.jdField_f_of_type_AndroidWidgetTextView.setGravity(48);
        this.jdField_f_of_type_AndroidWidgetTextView.setTextSize(2, 12.0F);
        this.jdField_f_of_type_AndroidWidgetTextView.setIncludeFontPadding(false);
        this.jdField_f_of_type_AndroidWidgetTextView.setEllipsize(TextUtils.TruncateAt.END);
        this.jdField_f_of_type_AndroidWidgetTextView.setSingleLine();
        this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(this.jdField_f_of_type_AndroidWidgetTextView, new LinearLayout.LayoutParams(-2, -2));
      }
      if (this.jdField_f_of_type_AndroidWidgetImageView == null)
      {
        this.jdField_f_of_type_AndroidWidgetImageView = new ImageView(getContext());
        this.jdField_f_of_type_AndroidWidgetImageView.setId(2131380987);
        paramString = new LinearLayout.LayoutParams(-2, -2);
        paramString.leftMargin = afur.a(1.0F, getContext().getResources());
        this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(this.jdField_f_of_type_AndroidWidgetImageView, paramString);
        this.jdField_f_of_type_AndroidWidgetImageView.setOnClickListener(new afws(this));
      }
      if (this.jdField_e_of_type_AndroidWidgetImageView == null)
      {
        this.jdField_e_of_type_AndroidWidgetImageView = new ImageView(getContext());
        this.jdField_e_of_type_AndroidWidgetImageView.setId(2131380990);
        paramString = new LinearLayout.LayoutParams(-2, -2);
        paramString.leftMargin = afur.a(5.0F, getContext().getResources());
        this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(this.jdField_e_of_type_AndroidWidgetImageView, paramString);
        this.jdField_e_of_type_AndroidWidgetImageView.setOnClickListener(new afwt(this));
      }
      if (this.jdField_e_of_type_AndroidWidgetTextView == null)
      {
        this.jdField_e_of_type_AndroidWidgetTextView = new ColorNickTextView(getContext());
        this.jdField_e_of_type_AndroidWidgetTextView.setId(2131364396);
        this.jdField_e_of_type_AndroidWidgetTextView.setGravity(48);
        this.jdField_e_of_type_AndroidWidgetTextView.setTextSize(2, 12.0F);
        this.jdField_e_of_type_AndroidWidgetTextView.setIncludeFontPadding(false);
        this.jdField_e_of_type_AndroidWidgetTextView.setEllipsize(TextUtils.TruncateAt.END);
        this.jdField_e_of_type_AndroidWidgetTextView.setSingleLine();
        this.jdField_e_of_type_AndroidWidgetTextView.setMaxWidth(jdField_f_of_type_Int);
        this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(this.jdField_e_of_type_AndroidWidgetTextView, new LinearLayout.LayoutParams(-2, -2));
      }
      if (this.jdField_a_of_type_ComTencentMobileqqTroopTroopMemberLevelTroopMemberNewLevelView == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqTroopTroopMemberLevelTroopMemberNewLevelView = new TroopMemberNewLevelView(getContext());
        this.jdField_a_of_type_ComTencentMobileqqTroopTroopMemberLevelTroopMemberNewLevelView.setId(2131364418);
        this.jdField_a_of_type_ComTencentMobileqqTroopTroopMemberLevelTroopMemberNewLevelView.setGravity(16);
        paramString = new RelativeLayout.LayoutParams(-2, -2);
        paramString.rightMargin = bgtn.a(2.0F);
        this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(this.jdField_a_of_type_ComTencentMobileqqTroopTroopMemberLevelTroopMemberNewLevelView, paramString);
      }
      paramString = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetLinearLayout.getLayoutParams();
      if (paramBoolean2)
      {
        paramString.rightMargin = this.jdField_a_of_type_AndroidWidgetLinearLayout.getContext().getResources().getDimensionPixelSize(2131296367);
        paramString.leftMargin = 0;
        paramString.addRule(0, 2131364388);
        paramString.addRule(1, 0);
        if (this.jdField_a_of_type_AndroidWidgetLinearLayout.getVisibility() != 0)
        {
          this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
          if (this.jdField_b_of_type_AndroidViewView != null)
          {
            ((RelativeLayout.LayoutParams)this.jdField_b_of_type_AndroidViewView.getLayoutParams()).addRule(3, 2131364397);
            if (QLog.isColorLevel()) {
              QLog.d("BubbleView", 2, " setNick mTopId = R.id.chat_item_nick_name_layout");
            }
          }
        }
        this.jdField_e_of_type_AndroidWidgetImageView.setVisibility(8);
        this.jdField_f_of_type_AndroidWidgetImageView.setVisibility(8);
        paramCharSequence2 = a("", this.jdField_f_of_type_AndroidWidgetTextView, jdField_f_of_type_Int, paramBoolean3, paramBoolean4, paramBoolean5, paramCharSequence2, paramColorStateList2, paramBoolean2);
        if (paramCharSequence2 == null) {
          break label1449;
        }
        this.jdField_f_of_type_AndroidWidgetTextView.setText(paramCharSequence2);
        this.jdField_f_of_type_AndroidWidgetTextView.setVisibility(0);
        label875:
        this.jdField_e_of_type_AndroidWidgetTextView.setText(paramCharSequence1);
        this.jdField_e_of_type_AndroidWidgetTextView.setTag(paramCharSequence1);
        if (paramColorStateList1 != null) {
          this.jdField_e_of_type_AndroidWidgetTextView.setTextColor(paramColorStateList1);
        }
        if ((aqyf.c().jdField_a_of_type_Boolean) && (!bcnj.b()))
        {
          paramBoolean1 = ((anmw)BaseActivity.sTopActivity.app.getManager(51)).jdField_c_of_type_Boolean;
          if ((paramInt3 == 0) || (paramInt3 == -100)) {
            break label1481;
          }
          if (!paramBoolean1) {
            break label1461;
          }
          this.jdField_e_of_type_AndroidWidgetTextView.setTextColor(getResources().getColor(2131167123));
          label969:
          this.jdField_e_of_type_AndroidWidgetImageView.setVisibility(0);
          paramInt1 = 3;
          if ((paramInt3 & 0x2) != 0) {
            paramInt1 = 259;
          }
          paramCharSequence1 = bgtv.a(paramInt1, paramInt4, paramInt5);
          VipUtils.a(getResources(), this.jdField_e_of_type_AndroidWidgetImageView, paramCharSequence1, getResources().getDrawable(2130847054));
          NamePlateCfgInfo.vipNamePlateExposeReport(BaseActivity.sTopActivity.app, paramInt5);
          paramCharSequence1 = new NamePlateCfgInfo(paramInt1, paramInt5);
          this.jdField_e_of_type_AndroidWidgetImageView.setTag(paramCharSequence1);
          e(paramInt6);
        }
        if (BaseActivity.sTopActivity == null) {
          break label1809;
        }
        paramCharSequence1 = BaseActivity.sTopActivity.app;
        label1077:
        if ((paramCharSequence1 != null) && (((((TroopManager)paramCharSequence1.getManager(52)).jdField_d_of_type_Boolean) && (paramInt7 == 0)) || ((paramInt7 == -100) && (paramInt3 != 0) && (paramInt3 != -100) && (!bcnj.b()))))
        {
          this.jdField_e_of_type_AndroidWidgetImageView.setVisibility(0);
          paramInt1 = 3;
          if ((paramInt3 & 0x2) != 0) {
            paramInt1 = 259;
          }
          NamePlateCfgInfo.vipNamePlateExposeReport(BaseActivity.sTopActivity.app, paramInt5);
          paramCharSequence1 = bgtv.a(paramInt1, paramInt4, paramInt5);
          VipUtils.a(getResources(), this.jdField_e_of_type_AndroidWidgetImageView, paramCharSequence1, getResources().getDrawable(2130847054));
          paramCharSequence1 = new NamePlateCfgInfo(paramInt1, paramInt5);
          this.jdField_e_of_type_AndroidWidgetImageView.setTag(paramCharSequence1);
          e(paramInt6);
        }
        paramCharSequence1 = AIOLongShotHelper.a();
        if ((paramCharSequence1 == null) || (!paramCharSequence1.a()) || (!paramCharSequence1.b())) {
          break label1814;
        }
        ((ColorNickTextView)this.jdField_e_of_type_AndroidWidgetTextView).setMosaicEffect(new bhyj(10));
        label1262:
        f();
      }
    }
    label1449:
    label1461:
    label1481:
    do
    {
      do
      {
        return;
        if ((this.jdField_d_of_type_AndroidWidgetTextView != null) && (this.jdField_d_of_type_AndroidWidgetTextView.getVisibility() == 0))
        {
          paramString.leftMargin = afur.a(4.0F, getContext().getResources());
          paramString.addRule(1, 2131364415);
        }
        for (;;)
        {
          paramString.rightMargin = 0;
          paramString.addRule(0, 0);
          break;
          if ((this.jdField_c_of_type_AndroidWidgetTextView != null) && (this.jdField_c_of_type_AndroidWidgetTextView.getVisibility() == 0))
          {
            paramString.leftMargin = afur.a(2.0F, getContext().getResources());
            paramString.addRule(1, 2131364417);
          }
          else if ((this.jdField_g_of_type_AndroidWidgetTextView != null) && (this.jdField_g_of_type_AndroidWidgetTextView.getVisibility() == 0))
          {
            paramString.leftMargin = afur.a(2.0F, getContext().getResources());
            paramString.addRule(1, 2131364389);
          }
          else
          {
            paramString.leftMargin = this.jdField_e_of_type_AndroidWidgetTextView.getContext().getResources().getDimensionPixelSize(2131296367);
            paramString.addRule(1, 2131364388);
          }
        }
        this.jdField_f_of_type_AndroidWidgetTextView.setVisibility(8);
        break label875;
        this.jdField_e_of_type_AndroidWidgetTextView.setTextColor(getResources().getColor(2131166993));
        break label969;
        paramCharSequence1 = new NamePlateCfgInfo();
        paramCharSequence1.mNamePlateId = paramInt5;
        switch (VipUtils.a(paramInt1))
        {
        default: 
          this.jdField_e_of_type_AndroidWidgetTextView.setTextColor(getResources().getColor(2131166993));
          this.jdField_e_of_type_AndroidWidgetImageView.setVisibility(8);
          this.jdField_e_of_type_AndroidWidgetImageView.setTag(paramCharSequence1);
          break;
        case 1: 
        case 3: 
          if (paramBoolean1) {
            this.jdField_e_of_type_AndroidWidgetTextView.setTextColor(getResources().getColor(2131167123));
          }
          for (;;)
          {
            this.jdField_e_of_type_AndroidWidgetImageView.setVisibility(8);
            paramCharSequence1.mVipType = 1;
            break;
            this.jdField_e_of_type_AndroidWidgetTextView.setTextColor(getResources().getColor(2131166993));
          }
        case 2: 
          if (paramBoolean1) {
            this.jdField_e_of_type_AndroidWidgetTextView.setTextColor(getResources().getColor(2131167123));
          }
          for (;;)
          {
            this.jdField_e_of_type_AndroidWidgetImageView.setVisibility(0);
            paramColorStateList1 = bgtv.a(2, paramInt2, paramInt5);
            VipUtils.a(getResources(), this.jdField_e_of_type_AndroidWidgetImageView, paramColorStateList1, getResources().getDrawable(2130847052));
            paramCharSequence1.mVipType = 2;
            break;
            this.jdField_e_of_type_AndroidWidgetTextView.setTextColor(getResources().getColor(2131166993));
          }
        case 4: 
          if (paramBoolean1) {
            this.jdField_e_of_type_AndroidWidgetTextView.setTextColor(getResources().getColor(2131167123));
          }
          for (;;)
          {
            this.jdField_e_of_type_AndroidWidgetImageView.setVisibility(0);
            paramColorStateList1 = bgtv.a(258, paramInt2, paramInt5);
            VipUtils.a(getResources(), this.jdField_e_of_type_AndroidWidgetImageView, paramColorStateList1, getResources().getDrawable(2130847054));
            paramCharSequence1.mVipType = 258;
            break;
            this.jdField_e_of_type_AndroidWidgetTextView.setTextColor(getResources().getColor(2131166993));
          }
          paramCharSequence1 = null;
          break label1077;
          ((ColorNickTextView)this.jdField_e_of_type_AndroidWidgetTextView).setMosaicEffect(null);
          break label1262;
        }
      } while (this.jdField_a_of_type_AndroidWidgetLinearLayout == null);
      if (this.jdField_a_of_type_AndroidWidgetLinearLayout.getVisibility() != 8)
      {
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
        if (this.jdField_b_of_type_AndroidViewView != null)
        {
          ((RelativeLayout.LayoutParams)this.jdField_b_of_type_AndroidViewView.getLayoutParams()).addRule(3, this.Y);
          if (QLog.isColorLevel()) {
            QLog.d("BubbleView", 2, " setNick mTopId = " + this.Y);
          }
        }
      }
    } while (this.jdField_e_of_type_AndroidWidgetTextView == null);
    label1809:
    label1814:
    ((ColorNickTextView)this.jdField_e_of_type_AndroidWidgetTextView).setMosaicEffect(null);
  }
  
  public boolean a()
  {
    return (this.jdField_c_of_type_AndroidWidgetImageView != null) && (this.jdField_c_of_type_AndroidWidgetImageView.getVisibility() == 0);
  }
  
  public boolean a(int paramInt)
  {
    if (paramInt == 1) {
      return this.jdField_d_of_type_Boolean;
    }
    return this.jdField_e_of_type_Boolean;
  }
  
  public boolean a(Drawable paramDrawable, int paramInt1, int paramInt2, int paramInt3, int paramInt4, double paramDouble, String paramString, boolean paramBoolean, float paramFloat, EmojiStickerManager.StickerInfo paramStickerInfo)
  {
    if (this.jdField_a_of_type_JavaUtilArrayList == null) {
      this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    }
    if (this.jdField_a_of_type_JavaUtilArrayList.size() < EmojiStickerManager.jdField_f_of_type_Int)
    {
      aruy localaruy = new aruy();
      if (paramDrawable != null)
      {
        localaruy.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramDrawable.mutate();
        paramDrawable.setCallback(this);
      }
      localaruy.jdField_a_of_type_Int = paramInt1;
      localaruy.jdField_b_of_type_Int = paramInt2;
      localaruy.jdField_c_of_type_Int = paramInt3;
      localaruy.jdField_d_of_type_Int = paramInt4;
      localaruy.jdField_a_of_type_Double = paramDouble;
      localaruy.jdField_a_of_type_JavaLangString = paramString;
      localaruy.jdField_a_of_type_Boolean = paramBoolean;
      localaruy.jdField_a_of_type_Float = paramFloat;
      localaruy.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiStickerManager$StickerInfo = paramStickerInfo;
      this.jdField_a_of_type_JavaUtilArrayList.add(localaruy);
      return true;
    }
    return false;
  }
  
  @TargetApi(16)
  public void addChildrenForAccessibility(ArrayList<View> paramArrayList)
  {
    int i2;
    int i1;
    do
    {
      try
      {
        super.addChildrenForAccessibility(paramArrayList);
        return;
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        i2 = getChildCount();
        i1 = 0;
      }
    } while (i1 >= i2);
    View localView = getChildAt(i1);
    if (localView.getVisibility() == 0)
    {
      if (!localView.includeForAccessibility()) {
        break label57;
      }
      paramArrayList.add(localView);
    }
    for (;;)
    {
      i1 += 1;
      break;
      label57:
      localView.addChildrenForAccessibility(paramArrayList);
    }
  }
  
  public int b(int paramInt)
  {
    if (paramInt == 1) {
      return this.ae;
    }
    return this.ag;
  }
  
  public View b()
  {
    return this.jdField_b_of_type_AndroidViewView;
  }
  
  public TextView b()
  {
    return this.jdField_e_of_type_AndroidWidgetTextView;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      this.jdField_i_of_type_Boolean = false;
      this.jdField_a_of_type_JavaUtilArrayList.clear();
    }
  }
  
  public void b(int paramInt)
  {
    this.aj = paramInt;
  }
  
  public void b(int paramInt1, int paramInt2, int paramInt3)
  {
    g();
    getLocationInWindow(this.jdField_a_of_type_ArrayOfInt);
    boolean bool;
    if ((paramInt1 != -1) && (paramInt2 != -1))
    {
      bool = true;
      if (paramInt3 != 1) {
        break label118;
      }
      this.ad = (paramInt1 - this.jdField_a_of_type_ArrayOfInt[0]);
      this.ae = (paramInt2 - this.jdField_a_of_type_ArrayOfInt[1]);
      this.jdField_d_of_type_Boolean = bool;
      label60:
      if (this.jdField_a_of_type_AndroidGraphicsPaint == null) {
        this.jdField_a_of_type_AndroidGraphicsPaint = new Paint(1);
      }
      if (this.jdField_a_of_type_AndroidGraphicsRect == null) {
        this.jdField_a_of_type_AndroidGraphicsRect = new Rect();
      }
      if (paramInt3 != 1) {
        break label151;
      }
      this.ah = paramInt2;
    }
    for (;;)
    {
      invalidate();
      return;
      bool = false;
      break;
      label118:
      this.af = (paramInt1 - this.jdField_a_of_type_ArrayOfInt[0]);
      this.ag = (paramInt2 - this.jdField_a_of_type_ArrayOfInt[1]);
      this.jdField_e_of_type_Boolean = bool;
      break label60;
      label151:
      if (paramInt3 == 2)
      {
        this.ai = paramInt2;
      }
      else
      {
        this.ah = -1;
        this.ai = -1;
      }
    }
  }
  
  protected void b(boolean paramBoolean, int paramInt)
  {
    RelativeLayout.LayoutParams localLayoutParams;
    int i1;
    if ((this.jdField_a_of_type_ComTencentMobileqqVasAvatarVasAvatar != null) && (this.jdField_a_of_type_ComTencentMobileqqVasAvatarVasAvatar.getVisibility() == 0))
    {
      localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqVasAvatarVasAvatar.getLayoutParams();
      i1 = afur.a(5.0F, getContext().getResources());
      if (paramBoolean)
      {
        localLayoutParams.addRule(11);
        localLayoutParams.addRule(9, 0);
        localLayoutParams.rightMargin = i1;
        localLayoutParams.leftMargin = 0;
        localLayoutParams.addRule(3, paramInt);
      }
    }
    else
    {
      return;
    }
    localLayoutParams.addRule(9);
    localLayoutParams.addRule(11, 0);
    if ((this.jdField_a_of_type_AndroidWidgetCheckBox != null) && (this.jdField_a_of_type_AndroidWidgetCheckBox.getVisibility() != 8)) {}
    for (localLayoutParams.leftMargin = afur.a(30.0F, getContext().getResources());; localLayoutParams.leftMargin = i1)
    {
      localLayoutParams.rightMargin = 0;
      break;
    }
  }
  
  public boolean b()
  {
    return this.X == 1;
  }
  
  public void c()
  {
    this.jdField_i_of_type_Boolean = true;
    invalidate();
  }
  
  public void c(int paramInt)
  {
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext())
      {
        aruy localaruy = (aruy)localIterator.next();
        localaruy.jdField_b_of_type_Int += paramInt;
      }
    }
  }
  
  public boolean c()
  {
    return (this.jdField_a_of_type_JavaUtilArrayList == null) || (this.jdField_a_of_type_JavaUtilArrayList.size() < EmojiStickerManager.jdField_e_of_type_Int);
  }
  
  public void d()
  {
    setPendantImageVisible(false);
    View localView = findViewById(2131365738);
    if ((localView != null) && (localView.getVisibility() != 8)) {
      localView.setVisibility(8);
    }
    localView = findViewById(2131366854);
    if ((localView != null) && (localView.getVisibility() != 8)) {
      localView.setVisibility(8);
    }
    localView = findViewById(2131366853);
    if ((localView != null) && (localView.getVisibility() != 8)) {
      localView.setVisibility(8);
    }
  }
  
  public boolean d()
  {
    return (this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() > 0);
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    super.dispatchDraw(paramCanvas);
    try
    {
      a(paramCanvas);
      if (this.jdField_d_of_type_Boolean)
      {
        this.jdField_a_of_type_AndroidGraphicsRect.set(this.ad - ab, this.ae - ac, this.ad, this.ae);
        this.jdField_a_of_type_AndroidGraphicsPaint.setColor(this.aj);
        paramCanvas.drawRect(this.jdField_a_of_type_AndroidGraphicsRect, this.jdField_a_of_type_AndroidGraphicsPaint);
        paramCanvas.drawCircle(this.jdField_a_of_type_AndroidGraphicsRect.centerX(), this.jdField_a_of_type_AndroidGraphicsRect.top - jdField_a_of_type_Int, jdField_a_of_type_Int, this.jdField_a_of_type_AndroidGraphicsPaint);
      }
      if (this.jdField_e_of_type_Boolean)
      {
        this.jdField_a_of_type_AndroidGraphicsRect.set(this.af, this.ag - ac, this.af + ab, this.ag);
        this.jdField_a_of_type_AndroidGraphicsPaint.setColor(this.aj);
        paramCanvas.drawRect(this.jdField_a_of_type_AndroidGraphicsRect, this.jdField_a_of_type_AndroidGraphicsPaint);
        paramCanvas.drawCircle(this.jdField_a_of_type_AndroidGraphicsRect.centerX(), this.jdField_a_of_type_AndroidGraphicsRect.bottom + jdField_a_of_type_Int, jdField_a_of_type_Int, this.jdField_a_of_type_AndroidGraphicsPaint);
      }
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      for (;;)
      {
        QLog.e("BaseChatItemLayout", 1, "dispatchDraw oom");
      }
    }
  }
  
  public void invalidateDrawable(Drawable paramDrawable)
  {
    invalidate();
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.jdField_b_of_type_Boolean) {}
    do
    {
      do
      {
        return true;
        if (!jdField_a_of_type_Boolean) {
          break;
        }
        if (paramMotionEvent.getAction() != 0) {
          break label100;
        }
      } while (!QLog.isDevelopLevel());
      QLog.d("MultiMsg_TAG", 4, "BaseChatItemLayout onInterceptTouchEvent...down ");
      return true;
    } while (a(paramMotionEvent.getX(), paramMotionEvent.getY()));
    if (((this.jdField_d_of_type_Boolean) || (this.jdField_e_of_type_Boolean)) && (a(paramMotionEvent.getX(), paramMotionEvent.getY()) != -1))
    {
      g();
      this.jdField_a_of_type_Alqt.c();
      return true;
    }
    label100:
    return super.onInterceptTouchEvent(paramMotionEvent);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    int i1;
    if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() > 0))
    {
      this.jdField_i_of_type_Boolean = false;
      paramInt1 = getMeasuredHeight();
      i1 = getChildCount() - 1;
      if (i1 >= 0)
      {
        Object localObject = getChildAt(i1);
        if ((localObject == null) || (((View)localObject).getId() != 2131364379)) {
          break label254;
        }
        localObject = (RelativeLayout.LayoutParams)((View)localObject).getLayoutParams();
        paramInt2 = 0;
        int i3 = 0;
        while (paramInt2 < this.jdField_a_of_type_JavaUtilArrayList.size())
        {
          aruy localaruy = (aruy)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt2);
          localaruy.jdField_f_of_type_Int = 255;
          localaruy.jdField_e_of_type_Int = 0;
          int i2 = paramInt1;
          if (localaruy.jdField_b_of_type_Int + localaruy.jdField_d_of_type_Int > paramInt1)
          {
            i3 = 1;
            ((RelativeLayout.LayoutParams)localObject).bottomMargin = (localaruy.jdField_b_of_type_Int + localaruy.jdField_d_of_type_Int - paramInt1);
            i2 = localaruy.jdField_b_of_type_Int + localaruy.jdField_d_of_type_Int;
          }
          paramInt2 += 1;
          paramInt1 = i2;
        }
        if (i3 == 0)
        {
          ((RelativeLayout.LayoutParams)localObject).bottomMargin = 0;
          paramInt2 = paramInt1;
        }
      }
    }
    for (;;)
    {
      i1 -= 1;
      paramInt1 = paramInt2;
      break;
      setMeasuredDimension(getMeasuredWidth(), paramInt1);
      paramInt2 = paramInt1;
      if (QLog.isColorLevel())
      {
        QLog.d("BaseChatItemLayout", 2, "onMeasure bubbleBottm = " + paramInt1);
        paramInt2 = paramInt1;
        continue;
        return;
        label254:
        paramInt2 = paramInt1;
      }
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.jdField_b_of_type_Boolean)
    {
      if ((paramMotionEvent.getAction() == 1) && (!this.jdField_c_of_type_Boolean))
      {
        if (this.jdField_a_of_type_Afwv != null)
        {
          this.jdField_a_of_type_Afwv.a_(this.jdField_a_of_type_ComTencentMobileqqDataChatMessage);
          QQToast.a(BaseApplication.getContext(), 0, anni.a(2131699794), 0).a();
        }
      }
      else {
        return true;
      }
      if (BaseActivity.sTopActivity != null) {}
      for (paramMotionEvent = BaseActivity.sTopActivity.app;; paramMotionEvent = null)
      {
        bcst.b(paramMotionEvent, "dc00898", "", "", "0X800A5A7", "0X800A5A7", 0, 0, "8", "", "", "");
        break;
      }
    }
    if (jdField_a_of_type_Boolean)
    {
      afud.a(this, paramMotionEvent);
      return true;
    }
    if (a(paramMotionEvent.getX(), paramMotionEvent.getY()))
    {
      if (paramMotionEvent.getAction() == 0) {
        if ((this.jdField_a_of_type_AndroidViewMotionEvent != null) && (a(this.jdField_a_of_type_AndroidViewMotionEvent, paramMotionEvent)))
        {
          this.jdField_j_of_type_Boolean = true;
          if (this.jdField_a_of_type_Aruz != null) {
            this.jdField_a_of_type_Aruz.a(this);
          }
        }
      }
      for (;;)
      {
        return true;
        if (paramMotionEvent.getAction() == 1)
        {
          this.jdField_a_of_type_AndroidViewMotionEvent = MotionEvent.obtain(paramMotionEvent);
          if (this.jdField_j_of_type_Boolean)
          {
            this.jdField_j_of_type_Boolean = false;
            this.jdField_a_of_type_AndroidViewMotionEvent = null;
          }
        }
      }
    }
    if ((this.jdField_d_of_type_Boolean) || (this.jdField_e_of_type_Boolean))
    {
      int i1 = paramMotionEvent.getAction();
      int i2;
      if (!this.jdField_f_of_type_Boolean)
      {
        i2 = a(paramMotionEvent.getX(), paramMotionEvent.getY());
        if ((i2 != -1) && (i1 == 0))
        {
          g();
          this.jdField_f_of_type_Boolean = true;
          this.ak = i2;
          this.al = this.jdField_a_of_type_Alqt.b();
          this.am = this.jdField_a_of_type_Alqt.c();
          if (paramMotionEvent.getSource() != -1) {
            this.jdField_a_of_type_Alqt.a(this.ak, false);
          }
          if (this.jdField_a_of_type_Alqt.a()) {
            this.jdField_a_of_type_Alqt.b();
          }
          return true;
        }
      }
      else
      {
        g();
        if ((i1 == 1) || (i1 == 3))
        {
          this.jdField_f_of_type_Boolean = false;
          this.ah = -1;
          this.ai = -1;
          this.jdField_a_of_type_Alqt.a(-1, true);
          this.jdField_a_of_type_Alqt.a();
          if (i1 == 1)
          {
            if (paramMotionEvent.getSource() != -1) {
              break label462;
            }
            i1 = 2;
            bcst.b(null, "dc00898", "", "", "0X800AE7B", "0X800AE7B", i1, 0, "", "", "", "");
          }
        }
        label462:
        while (i1 != 2) {
          for (;;)
          {
            return true;
            i1 = 1;
          }
        }
        int i3 = (int)paramMotionEvent.getRawX();
        i2 = (int)paramMotionEvent.getRawY();
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        if (this.ak == 1)
        {
          i4 = this.ad;
          i5 = jdField_a_of_type_Int;
          i6 = this.ad;
          i7 = jdField_a_of_type_Int;
          i8 = this.ae;
          i9 = ac;
          i10 = jdField_a_of_type_Int;
          int i11 = this.ae;
          int i12 = ac;
          i1 = i2;
          if (i3 >= i4 - i5 * 3)
          {
            i1 = i2;
            if (i3 <= i6 + i7 * 3)
            {
              i1 = i2;
              if (i2 >= i8 - i9 - i10 * 2)
              {
                i1 = i2;
                if (i2 <= i11 - i12)
                {
                  i1 = i2;
                  if (this.jdField_d_of_type_Boolean) {
                    i1 = i2 + jdField_a_of_type_Int * 2;
                  }
                }
              }
            }
          }
        }
        for (;;)
        {
          c(i3, i1, paramMotionEvent.getSource());
          break;
          i1 = i2;
          if (this.ak == 2)
          {
            i4 = this.af;
            i5 = jdField_a_of_type_Int;
            i6 = this.af;
            i7 = jdField_a_of_type_Int;
            i8 = this.ag;
            i9 = this.ag;
            i10 = jdField_a_of_type_Int;
            i1 = i2;
            if (i3 >= i4 - i5 * 3)
            {
              i1 = i2;
              if (i3 <= i6 + i7 * 3)
              {
                i1 = i2;
                if (i2 >= i8)
                {
                  i1 = i2;
                  if (i2 <= i9 + i10 * 2)
                  {
                    i1 = i2;
                    if (this.jdField_e_of_type_Boolean) {
                      i1 = i2 - jdField_a_of_type_Int * 2;
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void setBubbleView(View paramView)
  {
    RelativeLayout.LayoutParams localLayoutParams;
    if (this.jdField_b_of_type_AndroidViewView != paramView)
    {
      removeView(this.jdField_b_of_type_AndroidViewView);
      if ((paramView instanceof HorizontalListView)) {
        break label188;
      }
      addView(paramView);
      this.jdField_b_of_type_AndroidViewView = paramView;
      this.jdField_b_of_type_AndroidViewView.setId(2131364379);
      if (!(paramView instanceof HorizontalListView))
      {
        localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_b_of_type_AndroidViewView.getLayoutParams();
        int i1 = paramView.getContext().getResources().getDimensionPixelSize(2131296331);
        localLayoutParams.leftMargin = i1;
        localLayoutParams.rightMargin = i1;
        if (this.X != 1) {
          break label197;
        }
        localLayoutParams.addRule(0, 2131364388);
        localLayoutParams.addRule(1, 0);
      }
    }
    label107:
    paramView = (RelativeLayout.LayoutParams)this.jdField_b_of_type_AndroidViewView.getLayoutParams();
    if ((this.jdField_e_of_type_AndroidWidgetTextView != null) && (this.jdField_e_of_type_AndroidWidgetTextView.getVisibility() == 0))
    {
      paramView.addRule(3, 2131364397);
      paramView.topMargin = 0;
      if (QLog.isColorLevel()) {
        QLog.d("BubbleView", 2, " setBubbleView mTopId = R.id.chat_item_nick_name_layout, bubbleView = " + this.jdField_b_of_type_AndroidViewView.isPressed());
      }
    }
    label188:
    label197:
    do
    {
      return;
      addView(paramView, 0);
      break;
      localLayoutParams.addRule(1, 2131364388);
      localLayoutParams.addRule(0, 0);
      break label107;
      paramView.addRule(3, this.Y);
    } while (!QLog.isColorLevel());
    QLog.d("BubbleView", 2, " setBubbleView mTopId  = " + this.Y + ", bubbleView = " + this.jdField_b_of_type_AndroidViewView.isPressed());
  }
  
  public void setCheckBox(int paramInt, ChatMessage paramChatMessage, BaseChatItemLayout paramBaseChatItemLayout, QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, ViewGroup paramViewGroup)
  {
    boolean bool = jdField_a_of_type_Boolean;
    if (jdField_a_of_type_Boolean) {
      if (this.jdField_a_of_type_AndroidWidgetCheckBox == null)
      {
        this.jdField_a_of_type_AndroidWidgetCheckBox = new CheckBox(getContext());
        this.jdField_a_of_type_AndroidWidgetCheckBox.setButtonDrawable(2130839088);
        this.jdField_a_of_type_AndroidWidgetCheckBox.setId(2131364405);
        this.jdField_a_of_type_AndroidWidgetCheckBox.setOnCheckedChangeListener(jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
        paramBaseChatItemLayout = new RelativeLayout.LayoutParams(afur.a(24.0F, getContext().getResources()), afur.a(24.0F, getContext().getResources()));
        paramBaseChatItemLayout.topMargin = x;
        paramBaseChatItemLayout.addRule(9);
        paramBaseChatItemLayout.addRule(3, this.Y);
        addView(this.jdField_a_of_type_AndroidWidgetCheckBox, paramBaseChatItemLayout);
        this.jdField_a_of_type_AndroidWidgetCheckBox.setTag(paramChatMessage);
        if (!bool) {
          break label281;
        }
        paramBaseChatItemLayout = AIOLongShotHelper.a();
        if ((paramBaseChatItemLayout == null) || (!paramBaseChatItemLayout.a())) {
          break label245;
        }
        this.jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(8);
        this.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(paramBaseChatItemLayout.a(paramChatMessage));
      }
    }
    label245:
    while (this.jdField_a_of_type_AndroidWidgetCheckBox == null)
    {
      for (;;)
      {
        return;
        paramBaseChatItemLayout = new RelativeLayout.LayoutParams(afur.a(24.0F, getContext().getResources()), afur.a(24.0F, getContext().getResources()));
        paramBaseChatItemLayout.topMargin = x;
        paramBaseChatItemLayout.addRule(9);
        paramBaseChatItemLayout.addRule(3, this.Y);
        this.jdField_a_of_type_AndroidWidgetCheckBox.setLayoutParams(paramBaseChatItemLayout);
      }
      this.jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(0);
      if (awwm.a().a(paramChatMessage))
      {
        this.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(true);
        return;
      }
      this.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(false);
      return;
      this.jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(4);
      return;
    }
    label281:
    this.jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(8);
  }
  
  public void setFailedIconResource(int paramInt, View.OnClickListener paramOnClickListener)
  {
    setFailedIconResource(paramInt, paramOnClickListener, null);
  }
  
  public void setFailedIconResource(int paramInt, View.OnClickListener paramOnClickListener, Object paramObject)
  {
    RelativeLayout.LayoutParams localLayoutParams;
    if (this.jdField_c_of_type_AndroidWidgetImageView == null)
    {
      this.jdField_c_of_type_AndroidWidgetImageView = new ImageView(getContext());
      this.jdField_c_of_type_AndroidWidgetImageView.setId(2131364386);
      this.jdField_c_of_type_AndroidWidgetImageView.setContentDescription(getContext().getString(2131689891));
      localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams.bottomMargin = afur.a(16.0F, getContext().getResources());
      localLayoutParams.addRule(8, 2131364379);
      if (this.X != 1) {
        break label157;
      }
      localLayoutParams.addRule(0, 2131364379);
      localLayoutParams.addRule(1, 0);
    }
    for (;;)
    {
      addView(this.jdField_c_of_type_AndroidWidgetImageView, localLayoutParams);
      this.jdField_c_of_type_AndroidWidgetImageView.setImageResource(paramInt);
      this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(paramOnClickListener);
      this.jdField_c_of_type_AndroidWidgetImageView.setTag(paramObject);
      return;
      label157:
      localLayoutParams.addRule(1, 2131364379);
      localLayoutParams.addRule(0, 0);
    }
  }
  
  public void setFailedIconVisable(boolean paramBoolean, View.OnClickListener paramOnClickListener)
  {
    if (paramBoolean) {
      setFailedIconResource(2130838259, paramOnClickListener);
    }
    for (;;)
    {
      if ((jdField_a_of_type_Boolean) && (this.jdField_c_of_type_AndroidWidgetImageView != null)) {
        this.jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(null);
      }
      return;
      if (this.jdField_c_of_type_AndroidWidgetImageView != null)
      {
        this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
        this.jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(null);
      }
    }
  }
  
  public void setGrayTipsText(boolean paramBoolean, ChatMessage paramChatMessage, CharSequence paramCharSequence, ColorStateList paramColorStateList, int paramInt)
  {
    if (paramBoolean) {
      if (this.jdField_b_of_type_AndroidWidgetTextView == null)
      {
        this.jdField_b_of_type_AndroidWidgetTextView = new TextView(getContext());
        this.jdField_b_of_type_AndroidWidgetTextView.setId(2131364387);
        int i1 = afur.a(12.0F, getContext().getResources());
        int i2 = afur.a(5.0F, getContext().getResources());
        this.jdField_b_of_type_AndroidWidgetTextView.setBackgroundResource(2130844771);
        this.jdField_b_of_type_AndroidWidgetTextView.setTextSize(2, 13.0F);
        if (paramColorStateList != null) {
          this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(paramColorStateList);
        }
        this.jdField_b_of_type_AndroidWidgetTextView.setPadding(i1, i2, i1, i2);
        this.jdField_b_of_type_AndroidWidgetTextView.setGravity(17);
        this.jdField_b_of_type_AndroidWidgetTextView.setMovementMethod(new LinkMovementMethod());
        if (paramInt <= 0)
        {
          paramInt = -2;
          paramColorStateList = new RelativeLayout.LayoutParams(paramInt, -2);
          paramColorStateList.bottomMargin = getContext().getResources().getDimensionPixelOffset(2131296403);
          paramInt = afur.a(45.0F, getContext().getResources());
          paramColorStateList.leftMargin = paramInt;
          paramColorStateList.rightMargin = paramInt;
          paramColorStateList.addRule(14);
          paramColorStateList.addRule(3, 2131364410);
          addView(this.jdField_b_of_type_AndroidWidgetTextView, paramColorStateList);
        }
      }
      else
      {
        this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
        if ((paramCharSequence != null) && (!paramCharSequence.equals(this.jdField_b_of_type_AndroidWidgetTextView.getTag())))
        {
          this.jdField_b_of_type_AndroidWidgetTextView.setText(paramCharSequence);
          this.jdField_b_of_type_AndroidWidgetTextView.setTag(paramCharSequence);
        }
        d(2131364387);
        label282:
        if ((this.Y != 2131364410) || (this.jdField_a_of_type_AndroidWidgetTextView == null)) {
          break label409;
        }
        paramCharSequence = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams();
        paramInt = N;
        if (paramChatMessage.isFirstMsg) {
          paramInt = N + P;
        }
        paramCharSequence.topMargin = paramInt;
      }
    }
    label409:
    while ((this.Y != 2131364387) || (this.jdField_b_of_type_AndroidWidgetTextView == null))
    {
      return;
      paramInt = afur.a(paramInt, getContext().getResources());
      break;
      if (this.jdField_b_of_type_AndroidWidgetTextView == null) {
        break label282;
      }
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      if ((this.jdField_a_of_type_AndroidWidgetTextView != null) && (this.jdField_a_of_type_AndroidWidgetTextView.getVisibility() == 0)) {}
      for (paramInt = 2131364410;; paramInt = 0)
      {
        d(paramInt);
        break;
      }
    }
    paramChatMessage = (RelativeLayout.LayoutParams)this.jdField_b_of_type_AndroidWidgetTextView.getLayoutParams();
    paramChatMessage.topMargin = afur.a(10.0F, getContext().getResources());
    this.jdField_b_of_type_AndroidWidgetTextView.setLayoutParams(paramChatMessage);
  }
  
  public void setHeadIconVisible(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqVasAvatarVasAvatar != null)
    {
      if (paramBoolean) {
        this.jdField_a_of_type_ComTencentMobileqqVasAvatarVasAvatar.setVisibility(0);
      }
    }
    else if (this.jdField_a_of_type_AndroidWidgetLinearLayout != null)
    {
      if (!paramBoolean) {
        break label77;
      }
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
    }
    for (;;)
    {
      AIOLongShotHelper localAIOLongShotHelper = AIOLongShotHelper.a();
      boolean bool = paramBoolean;
      if (localAIOLongShotHelper != null)
      {
        bool = paramBoolean;
        if (localAIOLongShotHelper.c()) {
          bool = false;
        }
      }
      setPendantImageVisible(bool);
      return;
      this.jdField_a_of_type_ComTencentMobileqqVasAvatarVasAvatar.setVisibility(8);
      break;
      label77:
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    }
  }
  
  public void setHeaderIcon(Object paramObject)
  {
    int i1 = getContext().getResources().getDimensionPixelSize(2131296361);
    int i2 = afur.a(5.0F, getContext().getResources());
    RelativeLayout.LayoutParams localLayoutParams;
    if (this.jdField_a_of_type_ComTencentMobileqqVasAvatarVasAvatar == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqVasAvatarVasAvatar = new VasAvatar(getContext());
      this.jdField_a_of_type_ComTencentMobileqqVasAvatarVasAvatar.setId(2131364388);
      this.jdField_a_of_type_ComTencentMobileqqVasAvatarVasAvatar.setScaleType(ImageView.ScaleType.FIT_XY);
      localLayoutParams = new RelativeLayout.LayoutParams(R, R);
      localLayoutParams.topMargin = i1;
      localLayoutParams.addRule(3, 2131364387);
      if (this.X == 1)
      {
        localLayoutParams.addRule(11);
        localLayoutParams.addRule(9, 0);
        localLayoutParams.rightMargin = i2;
        localLayoutParams.leftMargin = 0;
        localLayoutParams.addRule(3, this.Y);
        addView(this.jdField_a_of_type_ComTencentMobileqqVasAvatarVasAvatar, localLayoutParams);
        label153:
        if (!(paramObject instanceof Drawable)) {
          break label407;
        }
        this.jdField_a_of_type_ComTencentMobileqqVasAvatarVasAvatar.setImageDrawable((Drawable)paramObject);
      }
    }
    for (;;)
    {
      if (this.jdField_b_of_type_AndroidWidgetImageView != null) {
        this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      }
      e();
      return;
      localLayoutParams.addRule(9);
      localLayoutParams.addRule(11, 0);
      if ((this.jdField_a_of_type_AndroidWidgetCheckBox != null) && (this.jdField_a_of_type_AndroidWidgetCheckBox.getVisibility() != 8)) {}
      for (localLayoutParams.leftMargin = afur.a(30.0F, getContext().getResources());; localLayoutParams.leftMargin = i2)
      {
        localLayoutParams.rightMargin = 0;
        break;
      }
      localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqVasAvatarVasAvatar.getLayoutParams();
      localLayoutParams.topMargin = i1;
      localLayoutParams.addRule(3, 2131364387);
      if (this.X == 1)
      {
        localLayoutParams.addRule(11);
        localLayoutParams.addRule(9, 0);
        localLayoutParams.rightMargin = i2;
        localLayoutParams.leftMargin = 0;
        localLayoutParams.addRule(3, this.Y);
        break label153;
      }
      localLayoutParams.addRule(9);
      localLayoutParams.addRule(11, 0);
      if ((this.jdField_a_of_type_AndroidWidgetCheckBox != null) && (this.jdField_a_of_type_AndroidWidgetCheckBox.getVisibility() != 8)) {}
      for (localLayoutParams.leftMargin = afur.a(30.0F, getContext().getResources());; localLayoutParams.leftMargin = i2)
      {
        localLayoutParams.rightMargin = 0;
        break;
      }
      label407:
      this.jdField_a_of_type_ComTencentMobileqqVasAvatarVasAvatar.setLoader(null, (bhbe)paramObject);
    }
  }
  
  public void setHearIconPosition(int paramInt)
  {
    int i1 = 0;
    if (this.X != paramInt)
    {
      this.X = paramInt;
      if (paramInt != 1) {
        break label181;
      }
    }
    label181:
    for (boolean bool = true;; bool = false)
    {
      paramInt = i1;
      if (this.jdField_a_of_type_AndroidWidgetTextView != null)
      {
        paramInt = i1;
        if (this.jdField_a_of_type_AndroidWidgetTextView.getVisibility() == 0) {
          paramInt = this.jdField_a_of_type_AndroidWidgetTextView.getId();
        }
      }
      i1 = paramInt;
      if (this.jdField_b_of_type_AndroidWidgetTextView != null)
      {
        i1 = paramInt;
        if (this.jdField_b_of_type_AndroidWidgetTextView.getVisibility() == 0) {
          i1 = this.jdField_b_of_type_AndroidWidgetTextView.getId();
        }
      }
      if (this.jdField_a_of_type_AndroidWidgetCheckBox != null) {
        ((RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetCheckBox.getLayoutParams()).addRule(9);
      }
      b(bool, i1);
      a();
      paramInt = i1;
      if (this.jdField_a_of_type_AndroidWidgetLinearLayout != null)
      {
        paramInt = i1;
        if (this.jdField_a_of_type_AndroidWidgetLinearLayout.getVisibility() == 0)
        {
          ((RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetLinearLayout.getLayoutParams()).addRule(3, i1);
          paramInt = this.jdField_a_of_type_AndroidWidgetLinearLayout.getId();
        }
      }
      a(bool, paramInt);
      a(this.jdField_a_of_type_AndroidWidgetProgressBar, bool);
      a(this.jdField_c_of_type_AndroidWidgetImageView, bool);
      return;
    }
  }
  
  public void setMiniAioShieldItemTouchListener(afwv paramafwv)
  {
    this.jdField_a_of_type_Afwv = paramafwv;
  }
  
  public void setNetIconVisible(boolean paramBoolean) {}
  
  public void setPendantImage(Drawable paramDrawable)
  {
    if (this.jdField_a_of_type_ComTencentImageURLImageView == null)
    {
      this.jdField_a_of_type_ComTencentImageURLImageView = new MosaicURLImageView(getContext());
      this.jdField_a_of_type_ComTencentImageURLImageView.setId(2131364399);
      this.jdField_a_of_type_ComTencentImageURLImageView.setScaleType(ImageView.ScaleType.FIT_XY);
      localLayoutParams = new RelativeLayout.LayoutParams(S, T);
      localLayoutParams.addRule(3, 2131364387);
      localLayoutParams.topMargin = U;
      if (this.X == 1)
      {
        localLayoutParams.addRule(11);
        localLayoutParams.addRule(9, 0);
        localLayoutParams.rightMargin = 0;
        localLayoutParams.leftMargin = 0;
      }
      for (;;)
      {
        localLayoutParams.addRule(3, this.Y);
        addView(this.jdField_a_of_type_ComTencentImageURLImageView, localLayoutParams);
        this.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(0);
        this.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(paramDrawable);
        paramDrawable = AIOLongShotHelper.a();
        if ((paramDrawable != null) && (paramDrawable.c())) {
          this.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(8);
        }
        if (ThemeUtil.isNowThemeIsNight(null, false, null)) {
          this.jdField_a_of_type_ComTencentImageURLImageView.setColorFilter(1996488704);
        }
        return;
        localLayoutParams.addRule(9);
        localLayoutParams.addRule(11, 0);
        if ((this.jdField_a_of_type_AndroidWidgetCheckBox != null) && (this.jdField_a_of_type_AndroidWidgetCheckBox.getVisibility() != 8)) {
          localLayoutParams.leftMargin = afur.a(25.0F, getContext().getResources());
        } else {
          localLayoutParams.leftMargin = 0;
        }
      }
    }
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentImageURLImageView.getLayoutParams();
    localLayoutParams.addRule(3, 2131364387);
    if (this.X == 1)
    {
      localLayoutParams.addRule(11);
      localLayoutParams.addRule(9, 0);
      localLayoutParams.rightMargin = 0;
      localLayoutParams.leftMargin = 0;
    }
    for (;;)
    {
      localLayoutParams.addRule(3, this.Y);
      break;
      localLayoutParams.addRule(9);
      localLayoutParams.addRule(11, 0);
      if ((this.jdField_a_of_type_AndroidWidgetCheckBox != null) && (this.jdField_a_of_type_AndroidWidgetCheckBox.getVisibility() != 8)) {
        localLayoutParams.leftMargin = afur.a(25.0F, getContext().getResources());
      } else {
        localLayoutParams.leftMargin = 0;
      }
    }
  }
  
  public void setPendantImageVisible(boolean paramBoolean)
  {
    URLImageView localURLImageView;
    if (this.jdField_a_of_type_ComTencentImageURLImageView != null)
    {
      localURLImageView = this.jdField_a_of_type_ComTencentImageURLImageView;
      if (!paramBoolean) {
        break label24;
      }
    }
    label24:
    for (int i1 = 0;; i1 = 8)
    {
      localURLImageView.setVisibility(i1);
      return;
    }
  }
  
  public void setProgressVisable(boolean paramBoolean)
  {
    if (paramBoolean) {
      if (this.jdField_a_of_type_AndroidWidgetProgressBar == null)
      {
        this.jdField_a_of_type_AndroidWidgetProgressBar = new ProgressBar(getContext(), null, 0);
        this.jdField_a_of_type_AndroidWidgetProgressBar.setId(2131364406);
        this.jdField_a_of_type_AndroidWidgetProgressBar.setIndeterminate(true);
        this.jdField_a_of_type_AndroidWidgetProgressBar.setIndeterminateDrawable(getResources().getDrawable(2130839402));
        i1 = afur.a(16.0F, getContext().getResources());
        localLayoutParams = new RelativeLayout.LayoutParams(i1, i1);
        localLayoutParams.bottomMargin = afur.a(18.0F, getContext().getResources());
        localLayoutParams.addRule(8, 2131364379);
        if (this.X == 1)
        {
          localLayoutParams.rightMargin = afur.a(4.0F, getContext().getResources());
          localLayoutParams.addRule(0, 2131364379);
          localLayoutParams.addRule(1, 0);
          addView(this.jdField_a_of_type_AndroidWidgetProgressBar, localLayoutParams);
        }
      }
      else
      {
        this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
      }
    }
    while (this.jdField_a_of_type_AndroidWidgetProgressBar == null) {
      for (;;)
      {
        int i1;
        RelativeLayout.LayoutParams localLayoutParams;
        return;
        localLayoutParams.leftMargin = afur.a(4.0F, getContext().getResources());
        localLayoutParams.addRule(1, 2131364379);
        localLayoutParams.addRule(0, 0);
      }
    }
    this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
  }
  
  public void setRobotNextTipsView(boolean paramBoolean, Context paramContext, QQAppInterface paramQQAppInterface, ChatMessage paramChatMessage)
  {
    if (paramBoolean)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopRobotNextTipsView == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopRobotNextTipsView = new TroopRobotNextTipsView(getContext(), paramContext, paramQQAppInterface);
        paramContext = new RelativeLayout.LayoutParams(jdField_e_of_type_Int, -2);
        i2 = o;
        i1 = p;
        if (paramChatMessage.isSend())
        {
          i2 = p;
          i1 = o;
        }
        paramContext.addRule(3, 2131364379);
        paramContext.addRule(5, 2131364379);
        this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopRobotNextTipsView.setPadding(i2, 0, i1, 0);
        addView(this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopRobotNextTipsView, paramContext);
      }
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopRobotNextTipsView.a(paramChatMessage);
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopRobotNextTipsView.setVisibility(0);
    }
    while (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopRobotNextTipsView == null)
    {
      int i2;
      int i1;
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopRobotNextTipsView.setVisibility(8);
  }
  
  public void setStickerPressStatus(boolean paramBoolean)
  {
    this.jdField_g_of_type_Boolean = paramBoolean;
    if (this.jdField_g_of_type_Boolean != this.jdField_h_of_type_Boolean) {
      invalidate();
    }
    this.jdField_h_of_type_Boolean = this.jdField_g_of_type_Boolean;
  }
  
  public void setTailMessage(boolean paramBoolean, CharSequence paramCharSequence, View.OnClickListener paramOnClickListener)
  {
    setTailMessage(paramBoolean, paramCharSequence, paramOnClickListener, true);
  }
  
  public void setTailMessage(boolean paramBoolean1, CharSequence paramCharSequence, View.OnClickListener paramOnClickListener, boolean paramBoolean2)
  {
    if (paramBoolean1) {
      if (this.jdField_h_of_type_AndroidWidgetTextView == null)
      {
        this.jdField_h_of_type_AndroidWidgetTextView = new TextView(getContext());
        this.jdField_h_of_type_AndroidWidgetTextView.setId(2131364408);
        if (paramBoolean2)
        {
          this.jdField_h_of_type_AndroidWidgetTextView.setBackgroundResource(2130849720);
          this.jdField_h_of_type_AndroidWidgetTextView.setTextSize(2, 13.0F);
          this.jdField_h_of_type_AndroidWidgetTextView.setTextColor(-1);
          this.jdField_h_of_type_AndroidWidgetTextView.setGravity(17);
          this.jdField_h_of_type_AndroidWidgetTextView.setPadding(24, 0, 24, 0);
          localObject = new RelativeLayout.LayoutParams(-2, -2);
          ((RelativeLayout.LayoutParams)localObject).addRule(3, 2131364379);
          ((RelativeLayout.LayoutParams)localObject).addRule(5, 2131364379);
          ((RelativeLayout.LayoutParams)localObject).addRule(7, 0);
          ((RelativeLayout.LayoutParams)localObject).bottomMargin = jdField_i_of_type_Int;
          addView(this.jdField_h_of_type_AndroidWidgetTextView, (ViewGroup.LayoutParams)localObject);
          localObject = new View(getContext());
          localLayoutParams = new RelativeLayout.LayoutParams(0, 0);
          localLayoutParams.addRule(3, 2131364408);
          localLayoutParams.addRule(5, 2131364379);
          addView((View)localObject, localLayoutParams);
        }
      }
      else
      {
        this.jdField_h_of_type_AndroidWidgetTextView.setVisibility(0);
        if (paramCharSequence != this.jdField_h_of_type_AndroidWidgetTextView.getTag()) {
          this.jdField_h_of_type_AndroidWidgetTextView.setText(paramCharSequence);
        }
        paramCharSequence = (RelativeLayout.LayoutParams)this.jdField_h_of_type_AndroidWidgetTextView.getLayoutParams();
        if (this.X != 1) {
          break label274;
        }
        paramCharSequence.leftMargin = k;
        this.jdField_h_of_type_AndroidWidgetTextView.setOnClickListener(paramOnClickListener);
      }
    }
    label274:
    while (this.jdField_h_of_type_AndroidWidgetTextView == null) {
      for (;;)
      {
        Object localObject;
        RelativeLayout.LayoutParams localLayoutParams;
        return;
        this.jdField_h_of_type_AndroidWidgetTextView.setBackgroundResource(2130841560);
        continue;
        paramCharSequence.leftMargin = jdField_j_of_type_Int;
      }
    }
    this.jdField_h_of_type_AndroidWidgetTextView.setVisibility(8);
  }
  
  public void setTimeStamp(boolean paramBoolean, ChatMessage paramChatMessage, ColorStateList paramColorStateList, CharSequence paramCharSequence)
  {
    if (paramChatMessage == null) {}
    label310:
    do
    {
      return;
      long l1 = paramChatMessage.time;
      if ((paramBoolean) && (l1 > 0L))
      {
        if (this.jdField_a_of_type_AndroidWidgetTextView == null)
        {
          this.jdField_a_of_type_AndroidWidgetTextView = new TextView(getContext());
          this.jdField_a_of_type_AndroidWidgetTextView.setId(2131364410);
          i1 = afur.a(14.0F, getContext().getResources());
          this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(2, 12.0F);
          this.jdField_a_of_type_AndroidWidgetTextView.setPadding(i1, 0, i1, 0);
          this.jdField_a_of_type_AndroidWidgetTextView.setGravity(17);
          RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
          localLayoutParams.topMargin = N;
          localLayoutParams.bottomMargin = O;
          localLayoutParams.addRule(14);
          addView(this.jdField_a_of_type_AndroidWidgetTextView, localLayoutParams);
          this.jdField_a_of_type_AndroidWidgetTextView.setTag(Long.valueOf(0L));
        }
        if (paramColorStateList != null) {
          this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(paramColorStateList);
        }
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
        if (((Long)this.jdField_a_of_type_AndroidWidgetTextView.getTag()).longValue() != l1)
        {
          if (paramCharSequence != null) {
            this.jdField_a_of_type_AndroidWidgetTextView.setText(paramCharSequence);
          }
        }
        else {
          if ((this.jdField_b_of_type_AndroidWidgetTextView == null) || (this.jdField_b_of_type_AndroidWidgetTextView.getVisibility() != 0)) {
            break label310;
          }
        }
        for (i1 = 2131364387;; i1 = 2131364410)
        {
          d(i1);
          paramColorStateList = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams();
          i1 = N;
          if (paramChatMessage.isFirstMsg) {
            i1 = N + P;
          }
          paramColorStateList.topMargin = i1;
          agau.a(null, paramChatMessage);
          return;
          paramColorStateList = bgsu.a(getContext(), 3, l1 * 1000L);
          this.jdField_a_of_type_AndroidWidgetTextView.setText(paramColorStateList);
          break;
        }
      }
    } while (this.jdField_a_of_type_AndroidWidgetTextView == null);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    if ((this.jdField_b_of_type_AndroidWidgetTextView != null) && (this.jdField_b_of_type_AndroidWidgetTextView.getVisibility() == 0)) {}
    for (int i1 = 2131364387;; i1 = 0)
    {
      d(i1);
      return;
    }
  }
  
  public void setTroopMemberLevel(QQAppInterface paramQQAppInterface, boolean paramBoolean1, String paramString, boolean paramBoolean2, int paramInt1, int paramInt2)
  {
    Object localObject;
    TroopManager localTroopManager;
    if (paramBoolean1)
    {
      if (this.jdField_c_of_type_AndroidWidgetTextView == null)
      {
        this.jdField_c_of_type_AndroidWidgetTextView = new ColorNickTextView(getContext());
        this.jdField_c_of_type_AndroidWidgetTextView.setId(2131364417);
        this.jdField_c_of_type_AndroidWidgetTextView.setTextSize(2, 12.0F);
        this.jdField_c_of_type_AndroidWidgetTextView.setIncludeFontPadding(false);
        this.jdField_c_of_type_AndroidWidgetTextView.setPadding(afur.a(4.0F, getContext().getResources()), 0, afur.a(4.0F, getContext().getResources()), 0);
        this.jdField_c_of_type_AndroidWidgetTextView.setEllipsize(TextUtils.TruncateAt.END);
        this.jdField_c_of_type_AndroidWidgetTextView.setSingleLine();
        this.jdField_c_of_type_AndroidWidgetTextView.setGravity(17);
        this.jdField_c_of_type_AndroidWidgetTextView.setHorizontallyScrolling(false);
        localObject = new RelativeLayout.LayoutParams(-2, -2);
        ((RelativeLayout.LayoutParams)localObject).topMargin = C;
        ((RelativeLayout.LayoutParams)localObject).bottomMargin = D;
        ((RelativeLayout.LayoutParams)localObject).addRule(3, this.Y);
        if (this.jdField_b_of_type_AndroidViewView != null)
        {
          ((RelativeLayout.LayoutParams)this.jdField_b_of_type_AndroidViewView.getLayoutParams()).addRule(3, 2131364397);
          if (QLog.isColorLevel()) {
            QLog.d("BubbleView", 2, " setTroopMemberLevel mTopId = R.id.chat_item_nick_name_layout");
          }
        }
        addView(this.jdField_c_of_type_AndroidWidgetTextView, (ViewGroup.LayoutParams)localObject);
      }
      localObject = (RelativeLayout.LayoutParams)this.jdField_c_of_type_AndroidWidgetTextView.getLayoutParams();
      if ((paramBoolean2) || (b()))
      {
        ((RelativeLayout.LayoutParams)localObject).rightMargin = afur.a(2.0F, getContext().getResources());
        ((RelativeLayout.LayoutParams)localObject).addRule(0, 2131364397);
        ((RelativeLayout.LayoutParams)localObject).addRule(1, 0);
        if (jdField_a_of_type_Boolean)
        {
          ((RelativeLayout.LayoutParams)localObject).leftMargin = Q;
          ((RelativeLayout.LayoutParams)localObject).addRule(4, 2131364396);
          this.jdField_c_of_type_AndroidWidgetTextView.setTextColor(paramInt2);
          if (paramInt1 != -1)
          {
            localTroopManager = (TroopManager)paramQQAppInterface.getManager(52);
            if (localTroopManager == null) {
              break label612;
            }
          }
        }
      }
    }
    label612:
    for (paramQQAppInterface = localTroopManager.a(paramInt1, paramString);; paramQQAppInterface = null)
    {
      localObject = paramQQAppInterface;
      if (paramQQAppInterface == null)
      {
        paramQQAppInterface = bfup.a(getResources(), paramInt1);
        localObject = paramQQAppInterface;
        if (localTroopManager != null)
        {
          localTroopManager.a(paramInt1, paramString, paramQQAppInterface);
          localObject = paramQQAppInterface;
        }
      }
      this.jdField_c_of_type_AndroidWidgetTextView.setBackgroundDrawable((Drawable)localObject);
      this.jdField_c_of_type_AndroidWidgetTextView.setPadding(afur.a(4.0F, getContext().getResources()), 0, afur.a(4.0F, getContext().getResources()), 0);
      if (this.jdField_c_of_type_AndroidWidgetTextView.getVisibility() != 0) {
        this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      }
      this.jdField_c_of_type_AndroidWidgetTextView.setText(paramString);
      this.jdField_c_of_type_AndroidWidgetTextView.setContentDescription(anni.a(2131699768) + paramString);
      paramQQAppInterface = AIOLongShotHelper.a();
      if ((paramQQAppInterface != null) && (paramQQAppInterface.a()) && (paramQQAppInterface.b())) {
        ((ColorNickTextView)this.jdField_c_of_type_AndroidWidgetTextView).setMosaicEffect(new bhyj(10));
      }
      do
      {
        do
        {
          return;
          ((RelativeLayout.LayoutParams)localObject).leftMargin = 0;
          break;
          ((RelativeLayout.LayoutParams)localObject).leftMargin = E;
          ((RelativeLayout.LayoutParams)localObject).rightMargin = 0;
          ((RelativeLayout.LayoutParams)localObject).addRule(1, 2131364388);
          ((RelativeLayout.LayoutParams)localObject).addRule(0, 0);
          break;
          ((ColorNickTextView)this.jdField_c_of_type_AndroidWidgetTextView).setMosaicEffect(null);
          return;
        } while (this.jdField_c_of_type_AndroidWidgetTextView == null);
        if (this.jdField_c_of_type_AndroidWidgetTextView.getVisibility() != 8) {
          this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
        }
      } while (this.jdField_c_of_type_AndroidWidgetTextView == null);
      ((ColorNickTextView)this.jdField_c_of_type_AndroidWidgetTextView).setMosaicEffect(null);
      return;
    }
  }
  
  public void setUnread(boolean paramBoolean, View.OnClickListener paramOnClickListener, Object paramObject)
  {
    if (paramBoolean) {
      if (this.jdField_d_of_type_AndroidWidgetImageView != null) {
        this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(0);
      }
    }
    while (this.jdField_d_of_type_AndroidWidgetImageView == null)
    {
      return;
      this.jdField_d_of_type_AndroidWidgetImageView = new ImageView(getContext());
      paramOnClickListener = new RelativeLayout.LayoutParams(-2, -2);
      paramOnClickListener.topMargin = afur.a(8.0F, getContext().getResources());
      paramOnClickListener.leftMargin = afur.a(-3.0F, getContext().getResources());
      paramOnClickListener.addRule(6, 2131364379);
      paramOnClickListener.addRule(1, 2131364379);
      addView(this.jdField_d_of_type_AndroidWidgetImageView, paramOnClickListener);
      this.jdField_d_of_type_AndroidWidgetImageView.setImageResource(2130850389);
      return;
    }
    this.jdField_d_of_type_AndroidWidgetImageView.setOnClickListener(null);
    this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
    this.jdField_d_of_type_AndroidWidgetImageView = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.BaseChatItemLayout
 * JD-Core Version:    0.7.0.1
 */