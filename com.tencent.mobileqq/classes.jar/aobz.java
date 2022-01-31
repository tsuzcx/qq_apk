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

public class aobz
  extends aoai
  implements Handler.Callback, View.OnClickListener
{
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private askf jdField_a_of_type_Askf;
  public VasQuickUpdateManager.CallBacker a;
  protected ProgressButton a;
  public Object a;
  public ArrayList<Integer> a;
  public AtomicBoolean a;
  public MqqHandler a;
  boolean jdField_a_of_type_Boolean;
  public ArrayList<aoce> b;
  boolean b = false;
  private boolean c;
  protected List<ProgressButton> d;
  protected List<ImageView> e;
  protected int f;
  private List<bboh> f;
  private final int jdField_g_of_type_Int = 2;
  private List<bboh> jdField_g_of_type_JavaUtilList;
  private int i;
  
  public aobz(QQAppInterface paramQQAppInterface, Context paramContext, int paramInt1, int paramInt2, int paramInt3, anyg paramanyg, int paramInt4, boolean paramBoolean)
  {
    super(paramQQAppInterface, paramContext, paramInt1, paramInt2, paramInt3, paramanyg);
    this.jdField_a_of_type_JavaLangObject = new Object();
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    this.jdField_a_of_type_MqqOsMqqHandler = new bfnk(Looper.getMainLooper(), this, true);
    this.jdField_a_of_type_ComTencentMobileqqVasVasQuickUpdateManager$CallBacker = new aocd(this);
    this.i = paramInt4;
    this.jdField_d_of_type_JavaUtilList = new ArrayList();
    this.e = new ArrayList();
    this.jdField_f_of_type_JavaUtilList = new ArrayList();
    this.jdField_g_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_Askf = ((askf)paramQQAppInterface.getManager(14));
    paramQQAppInterface = paramQQAppInterface.getApplication().getSharedPreferences("recommendEmotion_sp_name", 0);
    this.jdField_c_of_type_Boolean = paramQQAppInterface.getBoolean("recommemd_red_effect", false);
    this.jdField_a_of_type_Boolean = paramQQAppInterface.getBoolean("is_red_when_click_recommend", false);
    this.b = paramBoolean;
  }
  
  private ImageView a(bboh parambboh)
  {
    if ((this.e == null) || (this.e.size() < 1) || (parambboh == null) || (TextUtils.isEmpty(parambboh.a)))
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
      bboh localbboh = a(localImageView);
      if ((localbboh != null) && (parambboh.a.equals(localbboh.a))) {
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
    ((RelativeLayout)localObject1).setId(2131373505);
    Object localObject2 = new URLImageView(this.jdField_a_of_type_AndroidContentContext);
    RelativeLayout.LayoutParams localLayoutParams1 = new RelativeLayout.LayoutParams(-1, -1);
    ((URLImageView)localObject2).setId(2131365633);
    ((URLImageView)localObject2).setAdjustViewBounds(true);
    ((RelativeLayout)localObject1).addView((View)localObject2, localLayoutParams1);
    localObject2 = new URLImageView(this.jdField_a_of_type_AndroidContentContext);
    localLayoutParams1 = new RelativeLayout.LayoutParams(-1, -1);
    ((URLImageView)localObject2).setId(2131365632);
    ((URLImageView)localObject2).setAdjustViewBounds(true);
    ((RelativeLayout)localObject1).addView((View)localObject2, localLayoutParams1);
    ((URLImageView)localObject2).setScaleType(ImageView.ScaleType.FIT_XY);
    localObject2 = new ImageView(this.jdField_a_of_type_AndroidContentContext);
    localLayoutParams1 = new RelativeLayout.LayoutParams(-2, -2);
    ((ImageView)localObject2).setId(2131373506);
    localLayoutParams1.addRule(10, -1);
    localLayoutParams1.addRule(11, -1);
    ((ImageView)localObject2).setBackgroundDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130849297));
    ((RelativeLayout)localObject1).addView((View)localObject2, localLayoutParams1);
    localLinearLayout.addView((View)localObject1, localLayoutParams);
    localObject1 = new TextView(this.jdField_a_of_type_AndroidContentContext);
    ((TextView)localObject1).setId(2131365634);
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
    ((ProgressButton)localObject1).setId(2131365631);
    localLayoutParams = new LinearLayout.LayoutParams(-2, (int)(25.0F * this.jdField_a_of_type_Float));
    localLayoutParams.topMargin = ((int)(this.jdField_a_of_type_Float * 10.0F));
    localLayoutParams.gravity = 1;
    ((ProgressButton)localObject1).setBackgroundDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130839060));
    ((ProgressButton)localObject1).setTextColor(-14894864);
    ((ProgressButton)localObject1).setPadding((int)(this.jdField_a_of_type_Float * 15.0F), 0, (int)(this.jdField_a_of_type_Float * 15.0F), 0);
    ((ProgressButton)localObject1).setEllipsize(TextUtils.TruncateAt.END);
    ((ProgressButton)localObject1).setTextSize(13.0F);
    ((ProgressButton)localObject1).setGravity(17);
    localLinearLayout.addView((View)localObject1, localLayoutParams);
    return localLinearLayout;
  }
  
  private bboh a(View paramView)
  {
    if (paramView == null) {}
    do
    {
      return null;
      paramView = paramView.getTag();
    } while (paramView == null);
    if ((paramView instanceof bboh)) {}
    for (paramView = (bboh)paramView;; paramView = null) {
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
      bboh localbboh = a(localProgressButton);
      if ((localbboh != null) && (paramEmoticonPackage.epId.equals(localbboh.a))) {
        return localProgressButton;
      }
    }
    return null;
  }
  
  private void a(View paramView, bboh parambboh)
  {
    if ((paramView == null) || (parambboh == null)) {
      return;
    }
    int j;
    Object localObject2;
    Object localObject3;
    Object localObject1;
    if (this.jdField_a_of_type_Askf != null)
    {
      if (!a()) {
        break label799;
      }
      if (!this.jdField_g_of_type_JavaUtilList.contains(parambboh))
      {
        this.jdField_a_of_type_Askf.a(parambboh);
        j = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getSharedPreferences("recommendEmotion_sp_name", 0).getInt("recommendRuleId", -1);
        int k = this.jdField_a_of_type_JavaUtilList.indexOf(parambboh);
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c();
        localObject3 = parambboh.a;
        String str = k + 1 + "";
        if (!this.jdField_a_of_type_Boolean) {
          break label791;
        }
        localObject1 = "1";
        label132:
        VasWebviewUtil.reportCommercialDrainage((String)localObject2, "ep_mall", "aioshow", "", 0, 0, 0, "", (String)localObject3, str, (String)localObject1, "", j + "", "", 0, 0, 0, 0);
        this.jdField_g_of_type_JavaUtilList.add(parambboh);
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("RecommendEmotionAdapter", 2, "updateUI epid = " + parambboh.a + "expose num = " + parambboh.s);
      }
      paramView.setVisibility(0);
      if (parambboh == paramView.getTag(2131379213)) {
        break;
      }
      paramView.setTag(2131379213, parambboh);
      try
      {
        localObject1 = (URLImageView)paramView.findViewById(2131365633);
        localObject2 = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130846204);
        localObject3 = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130846205);
        ((URLImageView)localObject1).setImageDrawable(URLDrawable.getDrawable(parambboh.b, (Drawable)localObject2, (Drawable)localObject3));
        ((URLImageView)localObject1).setTag(parambboh);
        ((URLImageView)localObject1).setOnClickListener(this);
        localObject2 = (TextView)paramView.findViewById(2131365634);
        ((TextView)localObject2).setText(parambboh.c);
        ((TextView)localObject2).setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166931));
        ((URLImageView)localObject1).setContentDescription(parambboh.c);
        localObject1 = (ProgressButton)paramView.findViewById(2131365631);
        ((ProgressButton)localObject1).setText(parambboh.d);
        ((ProgressButton)localObject1).setTag(parambboh);
        ((ProgressButton)localObject1).setContentDescription(parambboh.d);
        ((ProgressButton)localObject1).setOnClickListener(this);
        ((ProgressButton)localObject1).setProgressDrawable(((ProgressButton)localObject1).a(-16745986));
        if ((this.jdField_d_of_type_JavaUtilList != null) && (!this.jdField_d_of_type_JavaUtilList.contains(localObject1))) {
          this.jdField_d_of_type_JavaUtilList.add(localObject1);
        }
        localObject2 = (URLImageView)paramView.findViewById(2131365632);
        ((URLImageView)localObject2).setImageDrawable(null);
        ((URLImageView)localObject2).setVisibility(8);
        localObject2 = (ImageView)paramView.findViewById(2131373506);
        ((ImageView)localObject2).setVisibility(8);
        ((ImageView)localObject2).setTag(parambboh);
        if (parambboh.r == 1)
        {
          if (QLog.isColorLevel()) {
            QLog.d("RecommendEmotionAdapter", 2, "emoticon Effect mNeedShowRedEffect:" + this.jdField_c_of_type_Boolean + ", id:" + parambboh.a);
          }
          j = this.jdField_a_of_type_JavaUtilList.indexOf(parambboh);
          if ((this.jdField_c_of_type_Boolean) && (j < 2) && ((this.jdField_a_of_type_JavaUtilArrayList == null) || ((this.jdField_a_of_type_JavaUtilArrayList.size() < 2) && (this.jdField_a_of_type_JavaUtilArrayList.indexOf(Integer.valueOf(j)) < 0))))
          {
            localObject3 = new aoce(this);
            ((aoce)localObject3).jdField_a_of_type_AndroidViewView = paramView;
            ((aoce)localObject3).jdField_a_of_type_Bboh = parambboh;
            ((aoce)localObject3).jdField_a_of_type_Int = j;
            ThreadManager.post(new RecommendEmotionAdapter.1(this, (aoce)localObject3), 8, null, true);
          }
        }
        if ((this.e != null) && (!this.e.contains(localObject2))) {
          this.e.add(localObject2);
        }
        float f1 = ((anvx)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(43)).a(parambboh.a);
        if (f1 < 0.0F) {
          break label826;
        }
        ((ProgressButton)localObject1).setProgress((int)f1);
        ((ProgressButton)localObject1).setText(ajya.a(2131713281));
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
      if (!this.jdField_f_of_type_JavaUtilList.contains(parambboh)) {
        this.jdField_f_of_type_JavaUtilList.add(parambboh);
      }
    }
    label826:
    ((ProgressButton)localObject1).setText(parambboh.d);
    ((ProgressButton)localObject1).setProgress(0);
  }
  
  private void a(bboh parambboh, int paramInt)
  {
    boolean bool = true;
    Intent localIntent1 = null;
    if (parambboh.n == 4)
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
        if (parambboh.n == 4) {}
        for (;;)
        {
          EmojiHomeUiPlugin.openEmojiDetailPage((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), 8, parambboh.a, false, localIntent2, bool);
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
    if (aoal.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Aoap) == this.jdField_c_of_type_Int) {
      bool = true;
    }
    return bool;
  }
  
  private boolean a(bboh parambboh)
  {
    return ((anvx)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(43)).a(parambboh.a) >= 0.0F;
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
  
  public View a(anxj paramanxj, int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    this.jdField_f_of_type_Int = (this.jdField_d_of_type_Int / this.jdField_a_of_type_Int);
    System.currentTimeMillis();
    paramViewGroup = (aocf)paramanxj;
    paramanxj = paramView;
    int j;
    if (paramView == null)
    {
      paramView = aoau.a().a(this.jdField_c_of_type_Int);
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
      paramanxj = paramView;
      if (j < this.jdField_a_of_type_Int)
      {
        try
        {
          paramanxj = a();
          paramanxj.setVisibility(8);
          localObject = new LinearLayout.LayoutParams(this.jdField_f_of_type_Int, -1);
          if (paramInt == 0) {}
          for (((LinearLayout.LayoutParams)localObject).topMargin = ((int)(22.0F * this.jdField_a_of_type_Float));; ((LinearLayout.LayoutParams)localObject).topMargin = ((int)(20.0F * this.jdField_a_of_type_Float)))
          {
            paramView.addView(paramanxj, (ViewGroup.LayoutParams)localObject);
            break;
          }
          paramanxj = paramView;
        }
        catch (Exception paramanxj)
        {
          QLog.e("RecommendEmotionAdapter", 1, "getEmotionView ; position = " + paramInt + "; has exception ,e = " + paramanxj.getMessage());
          paramView = null;
          return paramView;
        }
        catch (OutOfMemoryError paramanxj)
        {
          QLog.e("RecommendEmotionAdapter", 1, "getEmotionView oom");
        }
        if (QLog.isColorLevel())
        {
          QLog.d("RecommendEmotionAdapter", 2, "getEmotionView position = " + paramInt + ";view from cache");
          paramanxj = paramView;
        }
      }
      a(this.jdField_c_of_type_Int, paramanxj);
      paramView = (ViewGroup)paramanxj;
      paramViewGroup.a = new LinearLayout[this.jdField_a_of_type_Int];
      j = 0;
      while (j < this.jdField_a_of_type_Int)
      {
        paramViewGroup.a[j] = ((LinearLayout)paramView.getChildAt(j));
        j += 1;
      }
      paramanxj.setTag(paramViewGroup);
      j = 0;
      int k;
      for (;;)
      {
        paramView = paramanxj;
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
      paramView = (aoam)this.jdField_a_of_type_JavaUtilList.get(k);
      if ((paramView instanceof bboh)) {}
      for (paramView = (bboh)paramView;; paramView = null)
      {
        a((View)localObject, paramView);
        if (paramView == null) {
          break;
        }
        axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "ep_mall", "0X8005813", 0, 0, paramView.a, paramInt + "", "", paramView.r + "");
        break;
      }
      j += 1;
    }
  }
  
  public anxj a()
  {
    return new aocf();
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
    bboh localbboh = a(this.jdField_a_of_type_ComTencentMobileqqWidgetProgressButton);
    if (localbboh == null)
    {
      QLog.e("RecommendEmotionAdapter", 1, "payBack pkg is null");
      return;
    }
    axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "ep_mall", "0X800613B", 0, 0, localbboh.a, "", "", "0");
    a(this.jdField_a_of_type_ComTencentMobileqqWidgetProgressButton, localbboh, true, this.i);
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
  
  public void a(ProgressButton paramProgressButton, bboh parambboh, boolean paramBoolean, int paramInt)
  {
    if ((paramProgressButton == null) || (parambboh == null) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("RecommendEmotionAdapter", 2, "downloadOrPay epid = " + parambboh.a);
    }
    if ((parambboh.o == 2) || (parambboh.o == 6))
    {
      a(parambboh, paramInt);
      axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "ep_mall", "0X800613D", 0, 0, parambboh.a, "", "", parambboh.r + "");
      paramInt = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getSharedPreferences("recommendEmotion_sp_name", 0).getInt("recommendRuleId", -1);
      int j = this.jdField_a_of_type_JavaUtilList.indexOf(parambboh);
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c();
      parambboh = parambboh.a;
      String str = j + 1 + "";
      if (this.jdField_a_of_type_Boolean) {}
      for (paramProgressButton = "1";; paramProgressButton = "")
      {
        VasWebviewUtil.reportCommercialDrainage((String)localObject, "ep_mall", "0X800613D", "", 0, 0, 0, "", parambboh, str, paramProgressButton, "", paramInt + "", "", 0, 0, 0, 0);
        return;
      }
    }
    Object localObject = (anvx)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(43);
    ((askf)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(14)).a(parambboh.a, -1, new aoca(this, parambboh, paramBoolean, (anvx)localObject, paramProgressButton, paramInt));
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("RecommendEmotionAdapter", 2, "refreshPanelData");
    }
    new QueryTask(new aocb(this), new aocc(this)).a(null);
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
        bboh localbboh = (bboh)((Iterator)localObject).next();
        if (!this.jdField_g_of_type_JavaUtilList.contains(localbboh))
        {
          this.jdField_g_of_type_JavaUtilList.add(localbboh);
          if (this.jdField_a_of_type_Askf != null) {
            this.jdField_a_of_type_Askf.a(localbboh);
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
            localObject = (aoam)this.jdField_a_of_type_JavaUtilList.get(j);
            if ((localObject != null) && ((localObject instanceof bboh)))
            {
              localObject = (bboh)localObject;
              if (this.jdField_a_of_type_Askf != null) {
                this.jdField_a_of_type_Askf.a((bboh)localObject);
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
      Object localObject2 = anvx.a(((BaseActivity)this.jdField_a_of_type_AndroidContentContext).getAppRuntime(), paramMessage.epId);
      if (localObject2 == null) {
        return true;
      }
      int j = (int)((anxf)localObject2).a();
      if (QLog.isColorLevel()) {
        QLog.d("RecommendEmotionAdapter", 2, "handleMessage refreashProgress epid = " + paramMessage.epId + ";progress = " + j);
      }
      if (j == 100) {
        axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "ep_mall", "0X800581C", 0, 0, paramMessage.epId, "", "", "");
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
      paramMessage.setText(((bboh)localObject1).d);
      b();
      axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "ep_mall", "0X8005816", 0, 1, ((bboh)localObject1).a, "", "", "");
      continue;
      if ((paramMessage.obj instanceof aoce))
      {
        paramMessage = (aoce)paramMessage.obj;
        if ((paramMessage == null) || (paramMessage.jdField_a_of_type_Boolean)) {
          return true;
        }
        paramMessage.jdField_a_of_type_Boolean = true;
        if ((paramMessage.jdField_a_of_type_AndroidViewView == null) || (paramMessage.jdField_a_of_type_Bboh == null) || (paramMessage.jdField_a_of_type_JavaIoFile == null) || (paramMessage.jdField_a_of_type_AndroidViewView.getVisibility() != 0)) {
          return true;
        }
        if (((URLImageView)paramMessage.jdField_a_of_type_AndroidViewView.findViewById(2131365633)).getTag() != paramMessage.jdField_a_of_type_Bboh) {
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
          localObject2 = (URLImageView)paramMessage.jdField_a_of_type_AndroidViewView.findViewById(2131365632);
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
    bboh localbboh = a(paramView);
    if (localbboh == null) {}
    ImageView localImageView;
    do
    {
      do
      {
        return;
        localImageView = a(localbboh);
        if ((paramView instanceof URLImageView))
        {
          int j = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getSharedPreferences("recommendEmotion_sp_name", 0).getInt("recommendRuleId", -1);
          int k = this.jdField_a_of_type_JavaUtilList.indexOf(localbboh);
          String str1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c();
          String str2 = localbboh.a;
          String str3 = k + 1 + "";
          if (this.jdField_a_of_type_Boolean) {}
          for (paramView = "1";; paramView = "")
          {
            VasWebviewUtil.reportCommercialDrainage(str1, "ep_mall", "0X80065DD", "", 0, 0, 0, "", str2, str3, paramView, "", j + "", "", 0, 0, 0, 0);
            axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "ep_mall", "0X80065DD", 0, 0, localbboh.a, "", "", localbboh.r + "");
            a(localbboh, this.i);
            if ((localImageView == null) || (localImageView.getVisibility() != 0)) {
              break;
            }
            localImageView.setVisibility(8);
            localbboh.r = 0;
            this.jdField_a_of_type_Askf.i(localbboh.a, this.i);
            return;
          }
        }
      } while (!(paramView instanceof ProgressButton));
      axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "ep_mall", "0X8005814", 0, 0, localbboh.a, "", "", localbboh.r + "");
      a((ProgressButton)paramView, localbboh, false, this.i);
    } while ((localImageView == null) || (localImageView.getVisibility() != 0));
    localImageView.setVisibility(8);
    localbboh.r = 0;
    this.jdField_a_of_type_Askf.i(localbboh.a, this.i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aobz
 * JD-Core Version:    0.7.0.1
 */