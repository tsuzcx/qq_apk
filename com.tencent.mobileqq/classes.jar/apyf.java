import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emoticonview.EmoticonMainPanel;
import com.tencent.mobileqq.emoticonview.RecommendEmotionAdapter.1;
import com.tencent.mobileqq.model.QueryTask;
import com.tencent.mobileqq.vas.VasQuickUpdateManager;
import com.tencent.mobileqq.vas.VasQuickUpdateManager.CallBacker;
import com.tencent.mobileqq.vaswebviewplugin.EmojiHomeUiPlugin;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.mobileqq.widget.ProgressButton;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView.LayoutParams;
import com.tencent.widget.ListView;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;

public class apyf
  extends apwo
  implements Handler.Callback, View.OnClickListener
{
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private aufn jdField_a_of_type_Aufn;
  public VasQuickUpdateManager.CallBacker a;
  protected ProgressButton a;
  public Object a;
  public ArrayList<Integer> a;
  public AtomicBoolean a;
  public MqqHandler a;
  boolean jdField_a_of_type_Boolean;
  public ArrayList<apyk> b;
  boolean b = false;
  private boolean c;
  protected List<ProgressButton> d;
  protected List<ImageView> e;
  protected int f;
  private List<bdrk> f;
  private final int jdField_g_of_type_Int = 2;
  private List<bdrk> jdField_g_of_type_JavaUtilList;
  private int i;
  
  public apyf(QQAppInterface paramQQAppInterface, Context paramContext, int paramInt1, int paramInt2, int paramInt3, apuc paramapuc, int paramInt4, boolean paramBoolean)
  {
    super(paramQQAppInterface, paramContext, paramInt1, paramInt2, paramInt3, paramapuc);
    this.jdField_a_of_type_JavaLangObject = new Object();
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    this.jdField_a_of_type_MqqOsMqqHandler = new bhsl(Looper.getMainLooper(), this, true);
    this.jdField_a_of_type_ComTencentMobileqqVasVasQuickUpdateManager$CallBacker = new apyj(this);
    this.i = paramInt4;
    this.jdField_d_of_type_JavaUtilList = new ArrayList();
    this.e = new ArrayList();
    this.jdField_f_of_type_JavaUtilList = new ArrayList();
    this.jdField_g_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_Aufn = ((aufn)paramQQAppInterface.getManager(14));
    paramQQAppInterface = paramQQAppInterface.getApplication().getSharedPreferences("recommendEmotion_sp_name", 0);
    this.jdField_c_of_type_Boolean = paramQQAppInterface.getBoolean("recommemd_red_effect", false);
    this.jdField_a_of_type_Boolean = paramQQAppInterface.getBoolean("is_red_when_click_recommend", false);
    this.b = paramBoolean;
  }
  
  private ImageView a(bdrk parambdrk)
  {
    if ((this.e == null) || (this.e.size() < 1) || (parambdrk == null) || (TextUtils.isEmpty(parambdrk.a)))
    {
      QLog.e("RecommendEmotionAdapter", 1, "getRedPointViewByEp view or ep error");
      return null;
    }
    if (QLog.isColorLevel()) {
      QLog.d("RecommendEmotionAdapter", 2, "getRedPointViewByEp");
    }
    Iterator localIterator = this.e.iterator();
    while (localIterator.hasNext())
    {
      ImageView localImageView = (ImageView)localIterator.next();
      bdrk localbdrk = a(localImageView);
      if ((localbdrk != null) && (parambdrk.a.equals(localbdrk.a))) {
        return localImageView;
      }
    }
    return null;
  }
  
  private LinearLayout a()
  {
    LinearLayout localLinearLayout = new LinearLayout(this.jdField_a_of_type_AndroidContentContext);
    Object localObject1 = new LinearLayout.LayoutParams(this.jdField_f_of_type_Int, (int)(148.0F * this.jdField_a_of_type_Float));
    localLinearLayout.setOrientation(1);
    localLinearLayout.setLayoutParams((ViewGroup.LayoutParams)localObject1);
    localObject1 = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams((int)(85.0F * this.jdField_a_of_type_Float), (int)(85.0F * this.jdField_a_of_type_Float));
    localLayoutParams.gravity = 1;
    ((RelativeLayout)localObject1).setId(2131374009);
    Object localObject2 = new URLImageView(this.jdField_a_of_type_AndroidContentContext);
    RelativeLayout.LayoutParams localLayoutParams1 = new RelativeLayout.LayoutParams(-1, -1);
    ((URLImageView)localObject2).setId(2131365719);
    ((URLImageView)localObject2).setAdjustViewBounds(true);
    ((RelativeLayout)localObject1).addView((View)localObject2, localLayoutParams1);
    localObject2 = new URLImageView(this.jdField_a_of_type_AndroidContentContext);
    localLayoutParams1 = new RelativeLayout.LayoutParams(-1, -1);
    ((URLImageView)localObject2).setId(2131365718);
    ((URLImageView)localObject2).setAdjustViewBounds(true);
    ((RelativeLayout)localObject1).addView((View)localObject2, localLayoutParams1);
    ((URLImageView)localObject2).setScaleType(ImageView.ScaleType.FIT_XY);
    localObject2 = new ImageView(this.jdField_a_of_type_AndroidContentContext);
    localLayoutParams1 = new RelativeLayout.LayoutParams(-2, -2);
    ((ImageView)localObject2).setId(2131374010);
    localLayoutParams1.addRule(10, -1);
    localLayoutParams1.addRule(11, -1);
    ((ImageView)localObject2).setBackgroundDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130849801));
    ((RelativeLayout)localObject1).addView((View)localObject2, localLayoutParams1);
    localLinearLayout.addView((View)localObject1, localLayoutParams);
    localObject1 = new TextView(this.jdField_a_of_type_AndroidContentContext);
    ((TextView)localObject1).setId(2131365720);
    localLayoutParams = new LinearLayout.LayoutParams(-2, (int)(18.0F * this.jdField_a_of_type_Float));
    localLayoutParams.gravity = 1;
    localLayoutParams.topMargin = ((int)(this.jdField_a_of_type_Float * 10.0F));
    ((TextView)localObject1).setTextSize(15.0F);
    ((TextView)localObject1).setTextColor(-16777216);
    ((TextView)localObject1).setGravity(17);
    ((TextView)localObject1).setMaxLines(1);
    ((TextView)localObject1).setEllipsize(TextUtils.TruncateAt.END);
    localLinearLayout.addView((View)localObject1, localLayoutParams);
    localObject1 = new ProgressButton(this.jdField_a_of_type_AndroidContentContext);
    ((ProgressButton)localObject1).setId(2131365717);
    localLayoutParams = new LinearLayout.LayoutParams(-2, (int)(25.0F * this.jdField_a_of_type_Float));
    localLayoutParams.topMargin = ((int)(this.jdField_a_of_type_Float * 10.0F));
    localLayoutParams.gravity = 1;
    ((ProgressButton)localObject1).setBackgroundDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130839142));
    ((ProgressButton)localObject1).setTextColor(-14894864);
    ((ProgressButton)localObject1).setPadding((int)(this.jdField_a_of_type_Float * 15.0F), 0, (int)(this.jdField_a_of_type_Float * 15.0F), 0);
    ((ProgressButton)localObject1).setEllipsize(TextUtils.TruncateAt.END);
    ((ProgressButton)localObject1).setTextSize(13.0F);
    ((ProgressButton)localObject1).setGravity(17);
    localLinearLayout.addView((View)localObject1, localLayoutParams);
    return localLinearLayout;
  }
  
  private bdrk a(View paramView)
  {
    if (paramView == null) {}
    do
    {
      return null;
      paramView = paramView.getTag();
    } while (paramView == null);
    if ((paramView instanceof bdrk)) {}
    for (paramView = (bdrk)paramView;; paramView = null) {
      return paramView;
    }
  }
  
  private ProgressButton a(EmoticonPackage paramEmoticonPackage)
  {
    if ((this.jdField_d_of_type_JavaUtilList == null) || (this.jdField_d_of_type_JavaUtilList.size() < 1) || (paramEmoticonPackage == null) || (TextUtils.isEmpty(paramEmoticonPackage.epId)))
    {
      QLog.e("RecommendEmotionAdapter", 1, "getProgressButton view or ep error");
      return null;
    }
    Iterator localIterator = this.jdField_d_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      ProgressButton localProgressButton = (ProgressButton)localIterator.next();
      bdrk localbdrk = a(localProgressButton);
      if ((localbdrk != null) && (paramEmoticonPackage.epId.equals(localbdrk.a))) {
        return localProgressButton;
      }
    }
    return null;
  }
  
  private void a(View paramView, bdrk parambdrk)
  {
    if ((paramView == null) || (parambdrk == null)) {
      return;
    }
    int j;
    Object localObject2;
    Object localObject3;
    Object localObject1;
    if (this.jdField_a_of_type_Aufn != null)
    {
      if (!a()) {
        break label799;
      }
      if (!this.jdField_g_of_type_JavaUtilList.contains(parambdrk))
      {
        this.jdField_a_of_type_Aufn.a(parambdrk);
        j = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getSharedPreferences("recommendEmotion_sp_name", 0).getInt("recommendRuleId", -1);
        int k = this.jdField_a_of_type_JavaUtilList.indexOf(parambdrk);
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c();
        localObject3 = parambdrk.a;
        String str = k + 1 + "";
        if (!this.jdField_a_of_type_Boolean) {
          break label791;
        }
        localObject1 = "1";
        label132:
        VasWebviewUtil.reportCommercialDrainage((String)localObject2, "ep_mall", "aioshow", "", 0, 0, 0, "", (String)localObject3, str, (String)localObject1, "", j + "", "", 0, 0, 0, 0);
        this.jdField_g_of_type_JavaUtilList.add(parambdrk);
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("RecommendEmotionAdapter", 2, "updateUI epid = " + parambdrk.a + "expose num = " + parambdrk.s);
      }
      paramView.setVisibility(0);
      if (parambdrk == paramView.getTag(2131379971)) {
        break;
      }
      paramView.setTag(2131379971, parambdrk);
      try
      {
        localObject1 = (URLImageView)paramView.findViewById(2131365719);
        localObject2 = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130846656);
        localObject3 = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130846657);
        ((URLImageView)localObject1).setImageDrawable(URLDrawable.getDrawable(parambdrk.b, (Drawable)localObject2, (Drawable)localObject3));
        ((URLImageView)localObject1).setTag(parambdrk);
        ((URLImageView)localObject1).setOnClickListener(this);
        localObject2 = (TextView)paramView.findViewById(2131365720);
        ((TextView)localObject2).setText(parambdrk.c);
        ((TextView)localObject2).setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166981));
        ((URLImageView)localObject1).setContentDescription(parambdrk.c);
        localObject1 = (ProgressButton)paramView.findViewById(2131365717);
        ((ProgressButton)localObject1).setText(parambdrk.d);
        ((ProgressButton)localObject1).setTag(parambdrk);
        ((ProgressButton)localObject1).setContentDescription(parambdrk.d);
        ((ProgressButton)localObject1).setOnClickListener(this);
        ((ProgressButton)localObject1).setProgressDrawable(((ProgressButton)localObject1).a(-16745986));
        if ((this.jdField_d_of_type_JavaUtilList != null) && (!this.jdField_d_of_type_JavaUtilList.contains(localObject1))) {
          this.jdField_d_of_type_JavaUtilList.add(localObject1);
        }
        localObject2 = (URLImageView)paramView.findViewById(2131365718);
        ((URLImageView)localObject2).setImageDrawable(null);
        ((URLImageView)localObject2).setVisibility(8);
        localObject2 = (ImageView)paramView.findViewById(2131374010);
        ((ImageView)localObject2).setVisibility(8);
        ((ImageView)localObject2).setTag(parambdrk);
        if (parambdrk.r == 1)
        {
          if (QLog.isColorLevel()) {
            QLog.d("RecommendEmotionAdapter", 2, "emoticon Effect mNeedShowRedEffect:" + this.jdField_c_of_type_Boolean + ", id:" + parambdrk.a);
          }
          j = this.jdField_a_of_type_JavaUtilList.indexOf(parambdrk);
          if ((this.jdField_c_of_type_Boolean) && (j < 2) && ((this.jdField_a_of_type_JavaUtilArrayList == null) || ((this.jdField_a_of_type_JavaUtilArrayList.size() < 2) && (this.jdField_a_of_type_JavaUtilArrayList.indexOf(Integer.valueOf(j)) < 0))))
          {
            localObject3 = new apyk(this);
            ((apyk)localObject3).jdField_a_of_type_AndroidViewView = paramView;
            ((apyk)localObject3).jdField_a_of_type_Bdrk = parambdrk;
            ((apyk)localObject3).jdField_a_of_type_Int = j;
            ThreadManager.post(new RecommendEmotionAdapter.1(this, (apyk)localObject3), 8, null, true);
          }
        }
        if ((this.e != null) && (!this.e.contains(localObject2))) {
          this.e.add(localObject2);
        }
        float f1 = ((apro)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(43)).a(parambdrk.a);
        if (f1 < 0.0F) {
          break label826;
        }
        ((ProgressButton)localObject1).setProgress((int)f1);
        ((ProgressButton)localObject1).setText(alud.a(2131713665));
        return;
      }
      catch (OutOfMemoryError paramView)
      {
        QLog.e("RecommendEmotionAdapter", 1, "updateUI oom e = " + paramView);
        return;
      }
      label791:
      localObject1 = "";
      break label132;
      label799:
      if (!this.jdField_f_of_type_JavaUtilList.contains(parambdrk)) {
        this.jdField_f_of_type_JavaUtilList.add(parambdrk);
      }
    }
    label826:
    ((ProgressButton)localObject1).setText(parambdrk.d);
    ((ProgressButton)localObject1).setProgress(0);
  }
  
  private void a(bdrk parambdrk, int paramInt)
  {
    boolean bool = true;
    Intent localIntent1 = null;
    if (parambdrk.n == 4)
    {
      localIntent1 = new Intent();
      localIntent1.putExtra("EXTRA_KEY_IS_SMALL_EMOTICON", true);
    }
    Intent localIntent2;
    if (paramInt == 1)
    {
      localIntent2 = localIntent1;
      if (localIntent1 == null) {
        localIntent2 = new Intent();
      }
      localIntent2.putExtra("EXTRA_KEY_IS_KANDIAN_EMOTICON", true);
    }
    for (;;)
    {
      if ((this.jdField_a_of_type_AndroidContentContext instanceof Activity))
      {
        if (parambdrk.n == 4) {}
        for (;;)
        {
          EmojiHomeUiPlugin.openEmojiDetailPage((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), 8, parambdrk.a, false, localIntent2, bool);
          return;
          bool = false;
        }
      }
      QLog.e("RecommendEmotionAdapter", 1, "openEmoticonDetailPage error : context not activity");
      return;
      localIntent2 = localIntent1;
    }
  }
  
  private boolean a()
  {
    boolean bool = false;
    if (apwr.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Apwv) == this.jdField_c_of_type_Int) {
      bool = true;
    }
    return bool;
  }
  
  private boolean a(bdrk parambdrk)
  {
    return ((apro)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(43)).a(parambdrk.a) >= 0.0F;
  }
  
  private void d()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getSharedPreferences("recommendEmotion_sp_name", 0);
    ((SharedPreferences)localObject).edit().putBoolean("isClickRecommendRedpoint", true).commit();
    int j = ((SharedPreferences)localObject).getInt("recommendRuleId", -1);
    String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c();
    if (this.jdField_a_of_type_Boolean) {}
    for (localObject = "1";; localObject = "")
    {
      VasWebviewUtil.reportCommercialDrainage(str, "ep_mall", "PageView", "", 0, 0, 0, "", "", "", (String)localObject, "", j + "", "", 0, 0, 0, 0);
      EmoticonMainPanel.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.i);
      return;
    }
  }
  
  public View a(aptf paramaptf, int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    this.jdField_f_of_type_Int = (this.jdField_d_of_type_Int / this.jdField_a_of_type_Int);
    System.currentTimeMillis();
    paramViewGroup = (apyl)paramaptf;
    paramaptf = paramView;
    int j;
    if (paramView == null)
    {
      paramView = apxa.a().a(this.jdField_c_of_type_Int);
      if (paramView == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("RecommendEmotionAdapter", 2, "getEmotionView position = " + paramInt + ";view from inflater");
        }
        paramView = new LinearLayout(this.jdField_a_of_type_AndroidContentContext);
        paramView.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
        paramView.setOrientation(0);
        j = 0;
      }
    }
    for (;;)
    {
      paramaptf = paramView;
      if (j < this.jdField_a_of_type_Int)
      {
        try
        {
          paramaptf = a();
          paramaptf.setVisibility(8);
          localObject = new LinearLayout.LayoutParams(this.jdField_f_of_type_Int, -1);
          if (paramInt == 0) {}
          for (((LinearLayout.LayoutParams)localObject).topMargin = ((int)(22.0F * this.jdField_a_of_type_Float));; ((LinearLayout.LayoutParams)localObject).topMargin = ((int)(20.0F * this.jdField_a_of_type_Float)))
          {
            paramView.addView(paramaptf, (ViewGroup.LayoutParams)localObject);
            break;
          }
          paramaptf = paramView;
        }
        catch (Exception paramaptf)
        {
          QLog.e("RecommendEmotionAdapter", 1, "getEmotionView ; position = " + paramInt + "; has exception ,e = " + paramaptf.getMessage());
          paramView = null;
          return paramView;
        }
        catch (OutOfMemoryError paramaptf)
        {
          QLog.e("RecommendEmotionAdapter", 1, "getEmotionView oom");
        }
        if (QLog.isColorLevel())
        {
          QLog.d("RecommendEmotionAdapter", 2, "getEmotionView position = " + paramInt + ";view from cache");
          paramaptf = paramView;
        }
      }
      a(this.jdField_c_of_type_Int, paramaptf);
      paramView = (ViewGroup)paramaptf;
      paramViewGroup.a = new LinearLayout[this.jdField_a_of_type_Int];
      j = 0;
      while (j < this.jdField_a_of_type_Int)
      {
        paramViewGroup.a[j] = ((LinearLayout)paramView.getChildAt(j));
        j += 1;
      }
      paramaptf.setTag(paramViewGroup);
      j = 0;
      int k;
      for (;;)
      {
        paramView = paramaptf;
        if (j >= this.jdField_a_of_type_Int) {
          break;
        }
        k = this.jdField_a_of_type_Int * paramInt + j;
        if (k <= this.jdField_a_of_type_JavaUtilList.size() - 1) {
          break label440;
        }
        paramViewGroup.a[j].setTag(null);
        paramViewGroup.a[j].setVisibility(8);
        j += 1;
      }
      label440:
      Object localObject = paramViewGroup.a[j];
      paramView = (apws)this.jdField_a_of_type_JavaUtilList.get(k);
      if ((paramView instanceof bdrk)) {}
      for (paramView = (bdrk)paramView;; paramView = null)
      {
        a((View)localObject, paramView);
        if (paramView == null) {
          break;
        }
        azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "ep_mall", "0X8005813", 0, 0, paramView.a, paramInt + "", "", paramView.r + "");
        break;
      }
      j += 1;
    }
  }
  
  public aptf a()
  {
    return new apyl();
  }
  
  public void a()
  {
    super.a();
    if (this.jdField_d_of_type_JavaUtilList != null)
    {
      this.jdField_d_of_type_JavaUtilList.clear();
      this.jdField_d_of_type_JavaUtilList = null;
    }
    if (this.e != null)
    {
      this.e.clear();
      this.e = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
      ((VasQuickUpdateManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(184)).removeCallBacker(this.jdField_a_of_type_ComTencentMobileqqVasVasQuickUpdateManager$CallBacker);
    }
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      this.jdField_a_of_type_JavaUtilArrayList = null;
    }
    if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null) {
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = null;
    }
  }
  
  public void a(int paramInt)
  {
    if (paramInt == 17)
    {
      if (QLog.isColorLevel()) {
        QLog.d("RecommendEmotionAdapter", 2, "paback");
      }
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetProgressButton == null) {
        QLog.e("RecommendEmotionAdapter", 1, "payBack view is null");
      }
    }
    else
    {
      return;
    }
    bdrk localbdrk = a(this.jdField_a_of_type_ComTencentMobileqqWidgetProgressButton);
    if (localbdrk == null)
    {
      QLog.e("RecommendEmotionAdapter", 1, "payBack pkg is null");
      return;
    }
    azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "ep_mall", "0X800613B", 0, 0, localbdrk.a, "", "", "0");
    a(this.jdField_a_of_type_ComTencentMobileqqWidgetProgressButton, localbdrk, true, this.i);
  }
  
  public void a(EmoticonPackage paramEmoticonPackage, int paramInt)
  {
    if ((paramInt != 0) || (paramEmoticonPackage == null)) {
      return;
    }
    Message localMessage = Message.obtain();
    localMessage.what = 101;
    localMessage.obj = paramEmoticonPackage;
    this.jdField_a_of_type_MqqOsMqqHandler.sendMessage(localMessage);
  }
  
  public void a(EmoticonPackage paramEmoticonPackage, int paramInt1, int paramInt2)
  {
    if (paramEmoticonPackage == null) {
      return;
    }
    Message localMessage = Message.obtain();
    localMessage.what = 100;
    localMessage.obj = paramEmoticonPackage;
    this.jdField_a_of_type_MqqOsMqqHandler.sendMessage(localMessage);
  }
  
  public void a(ProgressButton paramProgressButton, bdrk parambdrk, boolean paramBoolean, int paramInt)
  {
    if ((paramProgressButton == null) || (parambdrk == null) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("RecommendEmotionAdapter", 2, "downloadOrPay epid = " + parambdrk.a);
    }
    if ((parambdrk.o == 2) || (parambdrk.o == 6))
    {
      a(parambdrk, paramInt);
      azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "ep_mall", "0X800613D", 0, 0, parambdrk.a, "", "", parambdrk.r + "");
      paramInt = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getSharedPreferences("recommendEmotion_sp_name", 0).getInt("recommendRuleId", -1);
      int j = this.jdField_a_of_type_JavaUtilList.indexOf(parambdrk);
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c();
      parambdrk = parambdrk.a;
      String str = j + 1 + "";
      if (this.jdField_a_of_type_Boolean) {}
      for (paramProgressButton = "1";; paramProgressButton = "")
      {
        VasWebviewUtil.reportCommercialDrainage((String)localObject, "ep_mall", "0X800613D", "", 0, 0, 0, "", parambdrk, str, paramProgressButton, "", paramInt + "", "", 0, 0, 0, 0);
        return;
      }
    }
    Object localObject = (apro)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(43);
    ((aufn)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(14)).a(parambdrk.a, -1, new apyg(this, parambdrk, paramBoolean, (apro)localObject, paramProgressButton, paramInt));
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("RecommendEmotionAdapter", 2, "refreshPanelData");
    }
    new QueryTask(new apyh(this), new apyi(this)).a(null);
  }
  
  public void c()
  {
    Object localObject;
    if (this.i == 0)
    {
      d();
      if (this.jdField_f_of_type_JavaUtilList.size() <= 0) {
        break label126;
      }
      if (QLog.isColorLevel()) {
        QLog.d("RecommendEmotionAdapter", 2, "onAdapterSelected invisiableExposeList size > 0");
      }
      localObject = this.jdField_f_of_type_JavaUtilList.iterator();
      while (((Iterator)localObject).hasNext())
      {
        bdrk localbdrk = (bdrk)((Iterator)localObject).next();
        if (!this.jdField_g_of_type_JavaUtilList.contains(localbdrk))
        {
          this.jdField_g_of_type_JavaUtilList.add(localbdrk);
          if (this.jdField_a_of_type_Aufn != null) {
            this.jdField_a_of_type_Aufn.a(localbdrk);
          }
        }
      }
      this.jdField_f_of_type_JavaUtilList.clear();
    }
    label387:
    label390:
    for (;;)
    {
      return;
      label126:
      localObject = a();
      if (localObject != null)
      {
        int j = ((ListView)localObject).getFirstVisiblePosition();
        int k = ((ListView)localObject).getLastVisiblePosition();
        if (QLog.isColorLevel()) {
          QLog.d("RecommendEmotionAdapter", 2, "onAdapterSelected firstShowPosition = " + j + ";lastShowPosition = " + k);
        }
        if (this.jdField_a_of_type_JavaUtilList != null)
        {
          this.jdField_g_of_type_JavaUtilList.clear();
          j = this.jdField_a_of_type_Int * j;
          int n = this.jdField_a_of_type_Int * (k + 1) - 1;
          if (QLog.isColorLevel()) {
            QLog.d("RecommendEmotionAdapter", 2, "onAdapterSelected firstDataPosition = " + j + ";lastDataPosition = " + n);
          }
          if (j <= n)
          {
            k = 1;
            label277:
            if (j >= this.jdField_a_of_type_JavaUtilList.size()) {
              break label387;
            }
          }
          for (int m = 1;; m = 0)
          {
            if ((k & m) == 0) {
              break label390;
            }
            localObject = (apws)this.jdField_a_of_type_JavaUtilList.get(j);
            if ((localObject != null) && ((localObject instanceof bdrk)))
            {
              localObject = (bdrk)localObject;
              if (this.jdField_a_of_type_Aufn != null) {
                this.jdField_a_of_type_Aufn.a((bdrk)localObject);
              }
              if (!this.jdField_g_of_type_JavaUtilList.contains(localObject)) {
                this.jdField_g_of_type_JavaUtilList.add(localObject);
              }
            }
            j += 1;
            break;
            k = 0;
            break label277;
          }
        }
      }
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return true;
      paramMessage = (EmoticonPackage)paramMessage.obj;
      if (paramMessage == null) {
        return true;
      }
      Object localObject1 = a(paramMessage);
      if (localObject1 == null) {
        return true;
      }
      Object localObject2 = apro.a(((BaseActivity)this.jdField_a_of_type_AndroidContentContext).getAppRuntime(), paramMessage.epId);
      if (localObject2 == null) {
        return true;
      }
      int j = (int)((apta)localObject2).a();
      if (QLog.isColorLevel()) {
        QLog.d("RecommendEmotionAdapter", 2, "handleMessage refreashProgress epid = " + paramMessage.epId + ";progress = " + j);
      }
      if (j == 100) {
        azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "ep_mall", "0X800581C", 0, 0, paramMessage.epId, "", "", "");
      }
      ((ProgressButton)localObject1).setProgress(j);
      ((ProgressButton)localObject1).setProgressDrawable(((ProgressButton)localObject1).a(-16745986));
      continue;
      paramMessage = (EmoticonPackage)paramMessage.obj;
      if (paramMessage == null) {
        return true;
      }
      paramMessage = a(paramMessage);
      if (paramMessage == null) {
        return true;
      }
      localObject1 = a(paramMessage);
      if (localObject1 == null) {
        return true;
      }
      paramMessage.setProgress(0);
      paramMessage.setText(((bdrk)localObject1).d);
      b();
      azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "ep_mall", "0X8005816", 0, 1, ((bdrk)localObject1).a, "", "", "");
      continue;
      if ((paramMessage.obj instanceof apyk))
      {
        paramMessage = (apyk)paramMessage.obj;
        if ((paramMessage == null) || (paramMessage.jdField_a_of_type_Boolean)) {
          return true;
        }
        paramMessage.jdField_a_of_type_Boolean = true;
        if ((paramMessage.jdField_a_of_type_AndroidViewView == null) || (paramMessage.jdField_a_of_type_Bdrk == null) || (paramMessage.jdField_a_of_type_JavaIoFile == null) || (paramMessage.jdField_a_of_type_AndroidViewView.getVisibility() != 0)) {
          return true;
        }
        if (((URLImageView)paramMessage.jdField_a_of_type_AndroidViewView.findViewById(2131365719)).getTag() != paramMessage.jdField_a_of_type_Bdrk) {
          return true;
        }
        if ((this.jdField_a_of_type_JavaUtilArrayList != null) && ((this.jdField_a_of_type_JavaUtilArrayList.size() >= 2) || (this.jdField_a_of_type_JavaUtilArrayList.indexOf(Integer.valueOf(paramMessage.jdField_a_of_type_Int)) >= 0))) {
          return true;
        }
        localObject1 = paramMessage.jdField_a_of_type_JavaIoFile.getAbsolutePath();
        try
        {
          localObject1 = new URL("vasapngdownloader", (String)localObject1, "local_recommendEffect");
          if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null)
          {
            localObject2 = Bitmap.createBitmap(10, 10, Bitmap.Config.ARGB_8888);
            this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = new BitmapDrawable(this.jdField_a_of_type_AndroidContentContext.getResources(), (Bitmap)localObject2);
          }
          localObject2 = (URLImageView)paramMessage.jdField_a_of_type_AndroidViewView.findViewById(2131365718);
          URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
          localURLDrawableOptions.mUseApngImage = true;
          j = (int)(85.0F * this.jdField_a_of_type_Float);
          localURLDrawableOptions.mRequestHeight = j;
          localURLDrawableOptions.mRequestWidth = j;
          localURLDrawableOptions.mLoadingDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
          localURLDrawableOptions.mFailedDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
          Bundle localBundle = new Bundle();
          localBundle.putInt("key_loop", 1);
          localBundle.putBoolean("key_once_clear", true);
          localBundle.putLong("bundle_key_bid", 1003L);
          localBundle.putString("bundle_key_scid", "emotionRecommendEffect");
          localURLDrawableOptions.mExtraInfo = localBundle;
          localObject1 = URLDrawable.getDrawable((URL)localObject1, localURLDrawableOptions);
          ((URLImageView)localObject2).setVisibility(0);
          ((URLImageView)localObject2).setImageDrawable((Drawable)localObject1);
          if (this.jdField_a_of_type_JavaUtilArrayList == null) {
            this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
          }
          this.jdField_a_of_type_JavaUtilArrayList.add(Integer.valueOf(paramMessage.jdField_a_of_type_Int));
          if (this.jdField_c_of_type_Boolean)
          {
            this.jdField_c_of_type_Boolean = false;
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getSharedPreferences("recommendEmotion_sp_name", 0).edit().putBoolean("recommemd_red_effect", false).commit();
          }
        }
        catch (Exception paramMessage)
        {
          QLog.e("RecommendEmotionAdapter", 1, "MSG_SHOW_RECOMMEND_EFFECT err:" + paramMessage.toString());
        }
      }
    }
  }
  
  public void onClick(View paramView)
  {
    bdrk localbdrk = a(paramView);
    if (localbdrk == null) {}
    ImageView localImageView;
    do
    {
      do
      {
        return;
        localImageView = a(localbdrk);
        if ((paramView instanceof URLImageView))
        {
          int j = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getSharedPreferences("recommendEmotion_sp_name", 0).getInt("recommendRuleId", -1);
          int k = this.jdField_a_of_type_JavaUtilList.indexOf(localbdrk);
          String str1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c();
          String str2 = localbdrk.a;
          String str3 = k + 1 + "";
          if (this.jdField_a_of_type_Boolean) {}
          for (paramView = "1";; paramView = "")
          {
            VasWebviewUtil.reportCommercialDrainage(str1, "ep_mall", "0X80065DD", "", 0, 0, 0, "", str2, str3, paramView, "", j + "", "", 0, 0, 0, 0);
            azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "ep_mall", "0X80065DD", 0, 0, localbdrk.a, "", "", localbdrk.r + "");
            a(localbdrk, this.i);
            if ((localImageView == null) || (localImageView.getVisibility() != 0)) {
              break;
            }
            localImageView.setVisibility(8);
            localbdrk.r = 0;
            this.jdField_a_of_type_Aufn.i(localbdrk.a, this.i);
            return;
          }
        }
      } while (!(paramView instanceof ProgressButton));
      azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "ep_mall", "0X8005814", 0, 0, localbdrk.a, "", "", localbdrk.r + "");
      a((ProgressButton)paramView, localbdrk, false, this.i);
    } while ((localImageView == null) || (localImageView.getVisibility() != 0));
    localImageView.setVisibility(8);
    localbdrk.r = 0;
    this.jdField_a_of_type_Aufn.i(localbdrk.a, this.i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apyf
 * JD-Core Version:    0.7.0.1
 */