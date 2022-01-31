import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.util.DisplayMetrics;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.music.QQPlayerService;
import com.tencent.mobileqq.music.SongInfo;
import com.tencent.mobileqq.search.activity.PublicAcntSearchActivity;
import com.tencent.mobileqq.search.presenter.SearchTemplatePresenter.10;
import com.tencent.mobileqq.search.presenter.SearchTemplatePresenter.11;
import com.tencent.mobileqq.search.presenter.SearchTemplatePresenter.12;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.widget.SquareImageView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.HorizontalListView;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import mqq.app.AppRuntime;
import org.json.JSONObject;

public class ayro
  implements aurc, ayqo<ayod, aywk>
{
  public static int a;
  private long jdField_a_of_type_Long;
  public ColorDrawable a;
  public Drawable a;
  private ayjq jdField_a_of_type_Ayjq;
  private bdbb jdField_a_of_type_Bdbb;
  private WeakReference<ImageView> jdField_a_of_type_JavaLangRefWeakReference;
  
  public ayro(bdbb parambdbb, ayjq paramayjq)
  {
    this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable = new ColorDrawable(Color.parseColor("#e7e7e7"));
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = bayu.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
    this.jdField_a_of_type_Bdbb = parambdbb;
    this.jdField_a_of_type_Ayjq = paramayjq;
  }
  
  private float a(String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      return 7.0F;
    }
    return 3.5F;
  }
  
  private int a(ayot paramayot, ayxd paramayxd)
  {
    if ((paramayot == null) || (paramayot.jdField_a_of_type_Ayou == null) || (paramayxd == null) || (paramayxd.jdField_a_of_type_AndroidWidgetRelativeLayout == null))
    {
      if ((paramayxd != null) && (paramayxd.jdField_a_of_type_AndroidWidgetButton != null)) {
        paramayxd.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
      }
      if ((paramayxd != null) && (paramayxd.jdField_a_of_type_AndroidWidgetImageView != null)) {
        paramayxd.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      }
      return 0;
    }
    if (paramayot.jdField_a_of_type_Ayou.jdField_a_of_type_Int == 1)
    {
      if (paramayxd.jdField_a_of_type_AndroidWidgetButton != null) {
        paramayxd.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
      }
      if (paramayxd.jdField_a_of_type_AndroidWidgetImageView != null) {
        paramayxd.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      }
      return 0;
    }
    boolean bool = ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null);
    Context localContext = paramayxd.jdField_a_of_type_AndroidWidgetRelativeLayout.getContext();
    int i;
    if (paramayot.jdField_a_of_type_Ayou.jdField_a_of_type_Int == 2)
    {
      if (paramayxd.jdField_a_of_type_AndroidWidgetImageView != null) {
        paramayxd.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      }
      if (paramayxd.jdField_a_of_type_AndroidWidgetButton == null) {
        return 0;
      }
      if (!TextUtils.isEmpty(paramayot.jdField_a_of_type_Ayou.jdField_a_of_type_JavaLangCharSequence))
      {
        paramayxd.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
        paramayxd.jdField_a_of_type_AndroidWidgetButton.setText(paramayot.jdField_a_of_type_Ayou.jdField_a_of_type_JavaLangCharSequence);
        paramayxd.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(new ayrv(this, localContext, paramayot));
      }
      for (;;)
      {
        i = (int)(0 + (ayvm.a(paramayxd.jdField_a_of_type_AndroidWidgetButton, paramayot.jdField_a_of_type_Ayou.jdField_a_of_type_JavaLangCharSequence) + bdaq.a(localContext, 32.0F) + bdaq.a(localContext, 15.0F)));
        if (!bool) {
          break;
        }
        paramayxd.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130842893);
        paramayxd.jdField_a_of_type_AndroidWidgetButton.setTextColor(Color.parseColor("#6991B8"));
        return i;
        paramayxd.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
      }
      paramayxd.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130842892);
      paramayxd.jdField_a_of_type_AndroidWidgetButton.setTextColor(Color.parseColor("#000000"));
      return i;
    }
    int j;
    if (paramayot.jdField_a_of_type_Ayou.jdField_a_of_type_Int == 3)
    {
      if (paramayxd.jdField_a_of_type_AndroidWidgetButton != null) {
        paramayxd.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
      }
      if ((paramayxd.jdField_a_of_type_AndroidWidgetRelativeLayout == null) || (paramayxd.jdField_a_of_type_AndroidWidgetImageView == null)) {
        return 0;
      }
      int k = ((Integer)paramayxd.a().getTag(2131379972)).intValue();
      SongInfo localSongInfo1 = new SongInfo();
      i = 0;
      j = i;
      for (;;)
      {
        try
        {
          JSONObject localJSONObject = new JSONObject(paramayot.h);
          j = i;
          localSongInfo1.jdField_b_of_type_JavaLangString = localJSONObject.optString("audio_url");
          j = i;
          localSongInfo1.jdField_c_of_type_JavaLangString = localJSONObject.optString("title");
          j = i;
          localSongInfo1.d = localJSONObject.optString("desc");
          j = i;
          localSongInfo1.e = localJSONObject.optString("image_url");
          j = i;
          if (TextUtils.isEmpty(localJSONObject.optString("id"))) {
            continue;
          }
          i = 1;
          if (i != 0)
          {
            j = i;
            localSongInfo1.jdField_a_of_type_Long = Long.parseLong(localJSONObject.optString("id"));
          }
          j = i;
          int m = localJSONObject.optInt("playable");
          if (m != 1) {
            continue;
          }
          j = 1;
        }
        catch (Exception localException)
        {
          i = j;
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("Q.uniteSearch.SearchTemplatePresenter", 2, localException.toString());
          j = 0;
          continue;
          SongInfo localSongInfo2 = QQPlayerService.b();
          if (localSongInfo2 == null) {
            continue;
          }
          ayvm.jdField_a_of_type_Long = localSongInfo2.jdField_a_of_type_Long;
          continue;
          paramayxd.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130849086);
          continue;
          if (this.jdField_a_of_type_Long != ayvm.jdField_a_of_type_Long) {
            continue;
          }
          paramayxd.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130849087);
          continue;
          paramayxd.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130849085);
          continue;
          paramayxd.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
          continue;
        }
        this.jdField_a_of_type_Long = localSongInfo1.jdField_a_of_type_Long;
        QQPlayerService.a(this);
        if (QQPlayerService.a() == 2) {
          continue;
        }
        ayvm.jdField_a_of_type_Long = -1L;
        if (!bool) {
          continue;
        }
        if (this.jdField_a_of_type_Long != ayvm.jdField_a_of_type_Long) {
          continue;
        }
        paramayxd.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130849088);
        if ((j == 0) || (i == 0) || (TextUtils.isEmpty(localSongInfo1.jdField_b_of_type_JavaLangString))) {
          continue;
        }
        paramayxd.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        paramayxd.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(new ayrw(this, paramayxd, k, localContext, bool, localSongInfo1, paramayot));
        return bdaq.a(localContext, 39.0F) + 0;
        i = 0;
        continue;
        j = 0;
      }
    }
    paramayxd.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
    return 0;
  }
  
  private int a(ayot paramayot, ayxd paramayxd, int paramInt1, int paramInt2)
  {
    if ((paramayxd == null) || (paramayot == null) || (paramayxd.jdField_a_of_type_AndroidWidgetLinearLayout == null)) {
      return 0;
    }
    Context localContext = paramayxd.jdField_a_of_type_AndroidWidgetLinearLayout.getContext();
    int i = localContext.getResources().getDisplayMetrics().widthPixels - paramInt1 - paramInt2 - bdaq.a(localContext, 30.0F);
    if ((paramayot.jdField_a_of_type_JavaUtilArrayList != null) && (paramayot.jdField_a_of_type_JavaUtilArrayList.size() > 0))
    {
      paramayxd.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      if ((paramayot.jdField_a_of_type_Ayov != null) && (paramayot.jdField_a_of_type_JavaUtilArrayList != null) && (paramayot.jdField_a_of_type_JavaUtilArrayList.size() > 0))
      {
        paramayxd.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(0);
        if (paramayxd.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView != null) {
          paramayxd.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView.setVisibility(8);
        }
        if (paramayot.jdField_a_of_type_Ayov.jdField_a_of_type_Int == 1)
        {
          if (paramayxd.jdField_b_of_type_AndroidWidgetTextView != null) {
            paramayxd.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
          }
          if ((paramayxd.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView == null) || (TextUtils.isEmpty(paramayot.jdField_a_of_type_Ayov.jdField_a_of_type_JavaLangString))) {
            break label1007;
          }
          paramayxd.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView.setVisibility(0);
          a(paramayxd.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView, paramayot.jdField_a_of_type_Ayov.jdField_a_of_type_JavaLangString);
          paramInt1 = i - bdaq.a(localContext, 24.0F);
        }
      }
    }
    for (;;)
    {
      Object localObject1;
      if ((paramayxd.jdField_a_of_type_AndroidWidgetTextView != null) && (!TextUtils.isEmpty(((ayow)paramayot.jdField_a_of_type_JavaUtilArrayList.get(0)).jdField_a_of_type_JavaLangCharSequence)))
      {
        localObject1 = ((ayow)paramayot.jdField_a_of_type_JavaUtilArrayList.get(0)).jdField_a_of_type_JavaLangCharSequence;
        if (!((ayow)paramayot.jdField_a_of_type_JavaUtilArrayList.get(0)).jdField_a_of_type_Boolean) {
          break label635;
        }
        localObject1 = ayvm.a(paramayxd.jdField_a_of_type_AndroidWidgetTextView, paramInt1, 1, ((CharSequence)localObject1).toString(), paramayot.jdField_a_of_type_Ayvb.jdField_a_of_type_JavaUtilList, false, false, true);
        label297:
        paramayxd.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject1);
      }
      for (paramInt1 = 1;; paramInt1 = 0)
      {
        if (paramayxd.c != null) {
          break label677;
        }
        return paramayxd.jdField_a_of_type_AndroidWidgetLinearLayout.getHeight();
        if (paramayot.jdField_a_of_type_Ayov.jdField_a_of_type_Int == 2)
        {
          if (paramayxd.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView != null) {
            paramayxd.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView.setVisibility(8);
          }
          if ((paramayxd.jdField_b_of_type_AndroidWidgetTextView == null) || (TextUtils.isEmpty(paramayot.jdField_a_of_type_Ayov.jdField_a_of_type_JavaLangCharSequence))) {
            break label1007;
          }
          if (ayvm.e(paramayot.jdField_a_of_type_Ayov.jdField_b_of_type_JavaLangString)) {}
          for (localObject1 = paramayot.jdField_a_of_type_Ayov.jdField_b_of_type_JavaLangString;; localObject1 = "#fd7f32")
          {
            ((GradientDrawable)paramayxd.jdField_b_of_type_AndroidWidgetTextView.getBackground()).setColor(Color.parseColor((String)localObject1));
            paramayxd.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
            paramayxd.jdField_b_of_type_AndroidWidgetTextView.setText(paramayot.jdField_a_of_type_Ayov.jdField_a_of_type_JavaLangCharSequence);
            paramInt1 = (int)(i - (ayvm.a(paramayxd.jdField_b_of_type_AndroidWidgetTextView, paramayot.jdField_a_of_type_Ayov.jdField_a_of_type_JavaLangCharSequence) + bdaq.a(localContext, 10.0F)));
            break;
          }
        }
        if (paramayot.jdField_a_of_type_Ayov.jdField_a_of_type_Int != 3) {
          break label1007;
        }
        if (paramayxd.jdField_b_of_type_AndroidWidgetTextView != null) {
          paramayxd.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
        }
        if ((paramayxd.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView == null) || (TextUtils.isEmpty(paramayot.jdField_a_of_type_Ayov.jdField_a_of_type_JavaLangString))) {
          break label1007;
        }
        paramayxd.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView.setVisibility(0);
        if ((paramayot.jdField_a_of_type_Ayov.jdField_b_of_type_Int > 0) && (paramayot.jdField_a_of_type_Ayov.jdField_c_of_type_Int > 0))
        {
          a(paramayxd.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView, paramayot.jdField_a_of_type_Ayov.jdField_b_of_type_Int, paramayot.jdField_a_of_type_Ayov.jdField_c_of_type_Int, paramayot.jdField_a_of_type_Ayov.jdField_a_of_type_JavaLangString);
          paramInt1 = i - bdaq.a(localContext, bdaq.a(localContext, paramayot.jdField_a_of_type_Ayov.jdField_b_of_type_Int) + 4);
          break;
        }
        a(paramayxd.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView, paramayot.jdField_a_of_type_Ayov.jdField_a_of_type_JavaLangString);
        paramInt1 = i - bdaq.a(localContext, 24.0F);
        break;
        label635:
        localObject1 = ayvm.a(paramayxd.jdField_a_of_type_AndroidWidgetTextView, paramInt1, ((CharSequence)localObject1).toString());
        break label297;
        if (paramayxd.jdField_b_of_type_AndroidWidgetLinearLayout != null) {
          paramayxd.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
        }
      }
      label677:
      paramayxd.c.removeAllViews();
      ayow localayow;
      TextView localTextView;
      if ((paramayot.jdField_a_of_type_JavaUtilArrayList != null) && (paramayot.jdField_a_of_type_JavaUtilArrayList.size() > 0)) {
        while (paramInt1 < paramayot.jdField_a_of_type_JavaUtilArrayList.size())
        {
          localayow = (ayow)paramayot.jdField_a_of_type_JavaUtilArrayList.get(paramInt1);
          localTextView = new TextView(localContext);
          a(localTextView, localayow.jdField_a_of_type_JavaLangString, localayow.jdField_a_of_type_Int);
          localObject1 = localayow.jdField_a_of_type_JavaLangCharSequence;
          if (TextUtils.isEmpty((CharSequence)localObject1))
          {
            paramInt1 += 1;
          }
          else
          {
            if (!ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null)) {
              break label1004;
            }
            localObject1 = ((CharSequence)localObject1).toString();
          }
        }
      }
      label952:
      label1004:
      for (;;)
      {
        paramInt2 = localayow.jdField_a_of_type_Int;
        if ((localContext instanceof PublicAcntSearchActivity)) {
          paramInt2 = 1;
        }
        Object localObject2 = localObject1;
        if (localayow.jdField_a_of_type_Boolean) {
          if ((!localayow.jdField_a_of_type_JavaLangString.equals("A")) && (!localayow.jdField_a_of_type_JavaLangString.equals("B"))) {
            break label952;
          }
        }
        for (boolean bool = true;; bool = false)
        {
          localObject2 = ayvm.a(localTextView, i, paramInt2, ((CharSequence)localObject1).toString(), paramayot.jdField_a_of_type_Ayvb.jdField_a_of_type_JavaUtilList, false, bool, true);
          if (paramInt1 != 0) {
            localTextView.setPadding(0, bdaq.a(localContext, 7.0F - a(((ayow)paramayot.jdField_a_of_type_JavaUtilArrayList.get(paramInt1 - 1)).jdField_a_of_type_JavaLangString, localayow.jdField_a_of_type_JavaLangString)), 0, 0);
          }
          localTextView.setText((CharSequence)localObject2);
          paramayxd.c.addView(localTextView);
          break;
        }
        paramayxd.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
        b(paramayot, paramayxd);
        paramInt1 = View.MeasureSpec.makeMeasureSpec(0, 0);
        paramInt2 = View.MeasureSpec.makeMeasureSpec(0, 0);
        paramayxd.jdField_a_of_type_AndroidWidgetLinearLayout.measure(paramInt1, paramInt2);
        return paramayxd.jdField_a_of_type_AndroidWidgetLinearLayout.getMeasuredHeight();
      }
      label1007:
      paramInt1 = i;
    }
  }
  
  private StateListDrawable a(String paramString)
  {
    Object localObject;
    if (ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null)) {
      localObject = "#040E1C";
    }
    for (paramString = "#194A90";; paramString = "#E5E6E7")
    {
      StateListDrawable localStateListDrawable = new StateListDrawable();
      paramString = new ColorDrawable(Color.parseColor(paramString));
      localObject = new ColorDrawable(Color.parseColor((String)localObject));
      localStateListDrawable.addState(new int[] { 16842919, 16842910 }, paramString);
      localStateListDrawable.addState(new int[0], (Drawable)localObject);
      return localStateListDrawable;
      localObject = paramString;
      if (!ayvm.e(paramString)) {
        localObject = "#F1F1F1";
      }
    }
  }
  
  public static Pair<Integer, Integer> a(ayod paramayod, aywk paramaywk, boolean paramBoolean, int paramInt)
  {
    if ((paramaywk == null) || (paramaywk.jdField_b_of_type_AndroidWidgetRelativeLayout == null) || (paramaywk.jdField_b_of_type_ComTencentMobileqqWidgetSquareImageView == null) || (paramayod == null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.uniteSearch.SearchTemplatePresenter", 2, "bindUniversalTemplateLeftImageview or item is null");
      }
      return new Pair(Integer.valueOf(0), Integer.valueOf(0));
    }
    SquareImageView localSquareImageView = paramaywk.jdField_b_of_type_ComTencentMobileqqWidgetSquareImageView;
    ayoe localayoe = paramayod.jdField_a_of_type_Ayoe;
    if ((localayoe == null) || (TextUtils.isEmpty(localayoe.jdField_a_of_type_JavaLangString)))
    {
      paramaywk.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      return new Pair(Integer.valueOf(0), Integer.valueOf(0));
    }
    paramaywk.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
    Object localObject = localSquareImageView.getContext();
    paramayod = a(localSquareImageView, localayoe.jdField_a_of_type_Int, localayoe.jdField_a_of_type_JavaLangString, localayoe.jdField_b_of_type_Int, paramBoolean, paramInt, paramayod);
    paramInt = ((Integer)paramayod.first).intValue();
    int i = ((Integer)paramayod.second).intValue();
    paramayod = localSquareImageView.getLayoutParams();
    paramayod.width = paramInt;
    paramayod.height = i;
    localSquareImageView.setLayoutParams(paramayod);
    paramayod = (RelativeLayout.LayoutParams)paramaywk.jdField_b_of_type_AndroidWidgetRelativeLayout.getLayoutParams();
    paramayod.width = paramInt;
    paramayod.height = i;
    paramaywk.jdField_b_of_type_AndroidWidgetRelativeLayout.setLayoutParams(paramayod);
    int j = bdaq.a((Context)localObject, 10.0F);
    if ((!TextUtils.isEmpty(localayoe.jdField_a_of_type_JavaLangCharSequence)) && (paramaywk.e != null)) {
      if (ayvm.e(localayoe.jdField_b_of_type_JavaLangString))
      {
        paramayod = localayoe.jdField_b_of_type_JavaLangString;
        ((GradientDrawable)paramaywk.e.getBackground()).setColor(Color.parseColor(paramayod));
        paramaywk.e.setVisibility(0);
        paramaywk.e.setText(localayoe.jdField_a_of_type_JavaLangCharSequence);
        label303:
        if (paramaywk.jdField_c_of_type_AndroidWidgetImageView != null)
        {
          if (!localayoe.jdField_a_of_type_Boolean) {
            break label565;
          }
          paramaywk.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
        }
        label326:
        if (paramaywk.f != null)
        {
          if (TextUtils.isEmpty(localayoe.jdField_b_of_type_JavaLangCharSequence)) {
            break label577;
          }
          paramaywk.f.setVisibility(0);
          paramaywk.f.setText(localayoe.jdField_b_of_type_JavaLangCharSequence);
        }
        label364:
        if (paramaywk.jdField_c_of_type_ComTencentMobileqqWidgetSquareImageView != null)
        {
          if (TextUtils.isEmpty(localayoe.jdField_c_of_type_JavaLangString)) {
            break label589;
          }
          paramaywk.jdField_c_of_type_ComTencentMobileqqWidgetSquareImageView.setVisibility(0);
          paramayod = URLDrawable.URLDrawableOptions.obtain();
          localObject = new ColorDrawable(-1);
          paramayod.mFailedDrawable = ((Drawable)localObject);
          paramayod.mLoadingDrawable = ((Drawable)localObject);
          paramayod.mRequestWidth = paramaywk.jdField_c_of_type_ComTencentMobileqqWidgetSquareImageView.getLayoutParams().width;
          paramayod.mRequestHeight = paramaywk.jdField_c_of_type_ComTencentMobileqqWidgetSquareImageView.getLayoutParams().height;
          paramayod = URLDrawable.getDrawable(localayoe.jdField_c_of_type_JavaLangString, paramayod);
          if ((paramayod.getStatus() != 1) && (paramayod.getStatus() != 0)) {
            paramayod.restartDownload();
          }
          paramaywk.jdField_c_of_type_ComTencentMobileqqWidgetSquareImageView.setImageDrawable(paramayod);
        }
        label481:
        if (paramaywk.g != null)
        {
          if (TextUtils.isEmpty(localayoe.jdField_c_of_type_JavaLangCharSequence)) {
            break label601;
          }
          paramaywk.g.setVisibility(0);
          paramaywk.g.setText(localayoe.jdField_c_of_type_JavaLangCharSequence);
        }
      }
    }
    for (;;)
    {
      return new Pair(Integer.valueOf(paramInt + j), Integer.valueOf(i));
      paramayod = "#fd7f32";
      break;
      if (paramaywk.e == null) {
        break label303;
      }
      paramaywk.e.setVisibility(8);
      break label303;
      label565:
      paramaywk.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
      break label326;
      label577:
      paramaywk.f.setVisibility(8);
      break label364;
      label589:
      paramaywk.jdField_c_of_type_ComTencentMobileqqWidgetSquareImageView.setVisibility(8);
      break label481;
      label601:
      paramaywk.g.setVisibility(8);
    }
  }
  
  public static Pair<Integer, Integer> a(SquareImageView paramSquareImageView, int paramInt1, String paramString, int paramInt2, boolean paramBoolean, int paramInt3, ayod paramayod)
  {
    int j = 0;
    int i = 0;
    if ((paramSquareImageView == null) || (TextUtils.isEmpty(paramString))) {
      return new Pair(Integer.valueOf(0), Integer.valueOf(0));
    }
    Object localObject = paramSquareImageView.getContext();
    ColorDrawable localColorDrawable;
    switch (paramInt1)
    {
    default: 
      paramInt1 = bdaq.a((Context)localObject, 60.0F);
      i = bdaq.a((Context)localObject, 60.0F);
      j = 0;
      localColorDrawable = new ColorDrawable(Color.parseColor("#e7e7e7"));
      if (paramBoolean)
      {
        paramInt1 = (int)(i * 1.0F / paramInt1 * paramInt3);
        if (j != 0)
        {
          i = (int)(paramInt3 * 0.2D / 2.0D);
          paramSquareImageView.setPadding(bdaq.a((Context)localObject, 3.0F), bdaq.a((Context)localObject, 3.0F), bdaq.a((Context)localObject, 3.0F), bdaq.a((Context)localObject, 3.0F));
          paramayod = (RelativeLayout.LayoutParams)paramSquareImageView.getLayoutParams();
          i -= bdaq.a((Context)localObject, 3.0F);
          paramayod.rightMargin = i;
          paramayod.leftMargin = i;
          paramayod.topMargin = i;
          paramSquareImageView.setLayoutParams(paramayod);
        }
      }
      break;
    }
    for (;;)
    {
      paramSquareImageView.setImageScale(paramInt3 * 1.0F / paramInt1, 0.0F);
      for (;;)
      {
        try
        {
          if (TextUtils.isEmpty(paramString)) {
            continue;
          }
          paramayod = URLDrawable.URLDrawableOptions.obtain();
          paramayod.mRequestWidth = paramInt3;
          paramayod.mRequestHeight = paramInt1;
          if (j == 0) {
            continue;
          }
          localObject = new GradientDrawable();
          ((GradientDrawable)localObject).setShape(0);
          ((GradientDrawable)localObject).setCornerRadius(paramInt3 / 2.0F);
          ((GradientDrawable)localObject).setColor(-1579033);
          paramayod.mLoadingDrawable = ((Drawable)localObject);
          paramayod.mFailedDrawable = ((Drawable)localObject);
          paramayod.mPlayGifImage = true;
          if (j == 0) {
            continue;
          }
          paramayod.mMemoryCacheKeySuffix = ("isAvatar" + paramInt3 + paramInt1);
          paramayod = URLDrawable.getDrawable(paramString, paramayod);
          paramayod.setDecodeHandler(bcyz.a);
        }
        catch (Exception paramayod)
        {
          QLog.e("Q.uniteSearch.SearchTemplatePresenter", 1, "imageUrl is not valid. imageUrl=" + paramString, paramayod);
          localObject = localColorDrawable;
          continue;
          paramayod.mMemoryCacheKeySuffix = ("isNotAvatar" + paramInt3 + paramInt1 + paramInt2);
          paramayod = URLDrawable.getDrawable(paramString, paramayod);
          paramayod.setTag(bcyz.b(paramInt3, paramInt1, paramInt2));
          paramayod.setDecodeHandler(bcyz.i);
          continue;
        }
        localObject = paramayod;
        if (paramayod.getStatus() != 1)
        {
          localObject = paramayod;
          if (paramayod.getStatus() != 0)
          {
            paramayod.restartDownload();
            localObject = paramayod;
          }
        }
        paramSquareImageView.setImageDrawable((Drawable)localObject);
        return new Pair(Integer.valueOf(paramInt3), Integer.valueOf(paramInt1));
        paramInt1 = bdaq.a((Context)localObject, 60.0F);
        i = bdaq.a((Context)localObject, 60.0F);
        j = 0;
        break;
        paramInt1 = bdaq.a((Context)localObject, 50.0F);
        i = bdaq.a((Context)localObject, 50.0F);
        j = 0;
        break;
        if ((paramSquareImageView.getContext() instanceof PublicAcntSearchActivity))
        {
          paramInt1 = bdaq.a(paramSquareImageView.getContext(), 50.0F);
          i = bdaq.a(paramSquareImageView.getContext(), 50.0F);
          j = 1;
          break;
        }
        paramInt1 = bdaq.a((Context)localObject, 60.0F);
        i = bdaq.a((Context)localObject, 60.0F);
        continue;
        paramInt1 = bdaq.a((Context)localObject, 50.0F);
        i = bdaq.a((Context)localObject, 50.0F);
        j = 1;
        break;
        paramInt1 = bdaq.a((Context)localObject, 60.0F);
        i = bdaq.a((Context)localObject, 85.0F);
        j = 0;
        break;
        paramInt1 = bdaq.a((Context)localObject, 113.0F);
        i = bdaq.a((Context)localObject, 60.0F);
        j = 0;
        break;
        paramInt1 = bdaq.a((Context)localObject, 100.0F);
        i = bdaq.a((Context)localObject, 141.0F);
        j = 0;
        break;
        paramInt1 = j;
        if ((paramayod instanceof ayot))
        {
          paramInt1 = bdaq.a((Context)localObject, paramayod.jdField_a_of_type_Ayoe.jdField_c_of_type_Int / 2);
          i = bdaq.a((Context)localObject, paramayod.jdField_a_of_type_Ayoe.d / 2);
        }
        if ((paramInt2 == paramayod.jdField_a_of_type_Ayoe.jdField_c_of_type_Int / 2) && (paramInt2 == paramayod.jdField_a_of_type_Ayoe.d / 2))
        {
          j = 1;
          break;
        }
        j = 0;
        break;
        paramInt1 = bdaq.a((Context)localObject, 220.0F);
        i = bdaq.a((Context)localObject, 136.0F);
        j = 0;
        break;
        paramInt1 = bdaq.a((Context)localObject, 162.0F);
        i = bdaq.a((Context)localObject, 162.0F);
        j = 0;
        break;
        paramInt1 = bdaq.a((Context)localObject, 162.0F);
        i = bdaq.a((Context)localObject, 228.0F);
        j = 0;
        break;
        paramInt1 = bdaq.a((Context)localObject, 162.0F);
        i = bdaq.a((Context)localObject, 162.0F);
        j = 1;
        break;
        paramayod.mFailedDrawable = localColorDrawable;
        paramayod.mLoadingDrawable = localColorDrawable;
        paramSquareImageView.setBackgroundColor(0);
      }
      paramInt3 = paramInt1;
      paramInt1 = i;
    }
  }
  
  private void a(TextView paramTextView, String paramString, int paramInt)
  {
    if ((paramTextView == null) || (TextUtils.isEmpty(paramString)) || (paramInt <= 0)) {
      return;
    }
    Context localContext = paramTextView.getContext();
    paramTextView.setMaxLines(paramInt);
    paramTextView.setEllipsize(TextUtils.TruncateAt.END);
    boolean bool = ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null);
    if (paramString.equals("A"))
    {
      paramTextView.setTextSize(1, 17.0F);
      if (bool) {
        paramTextView.setTextColor(Color.parseColor("#737373"));
      }
      for (;;)
      {
        paramTextView.setIncludeFontPadding(false);
        return;
        paramTextView.setTextColor(localContext.getResources().getColor(2131166904));
      }
    }
    if (paramString.equals("B"))
    {
      paramTextView.setTextSize(1, 15.0F);
      if (bool) {
        paramTextView.setTextColor(Color.parseColor("#737373"));
      }
      for (;;)
      {
        paramTextView.setIncludeFontPadding(false);
        return;
        paramTextView.setTextColor(localContext.getResources().getColor(2131166904));
      }
    }
    if (paramString.equals("C"))
    {
      paramTextView.setTextSize(1, 14.0F);
      if (bool) {
        paramTextView.setTextColor(Color.parseColor("#4A4A4A"));
      }
      for (;;)
      {
        paramTextView.setIncludeFontPadding(false);
        return;
        paramTextView.setTextColor(localContext.getResources().getColor(2131166905));
      }
    }
    if (paramString.equals("D"))
    {
      paramTextView.setTextSize(1, 13.0F);
      if (bool) {
        paramTextView.setTextColor(Color.parseColor("#4A4A4A"));
      }
      for (;;)
      {
        paramTextView.setIncludeFontPadding(false);
        return;
        paramTextView.setTextColor(localContext.getResources().getColor(2131166905));
      }
    }
    if (paramString.equals("E"))
    {
      paramTextView.setTextSize(1, 12.0F);
      if (bool) {
        paramTextView.setTextColor(Color.parseColor("#4A4A4A"));
      }
      for (;;)
      {
        paramTextView.setIncludeFontPadding(false);
        return;
        paramTextView.setTextColor(localContext.getResources().getColor(2131166905));
      }
    }
    if (paramString.equals("F"))
    {
      paramTextView.setTextSize(1, 12.0F);
      paramTextView.setIncludeFontPadding(false);
      if (bool)
      {
        paramTextView.setTextColor(Color.parseColor("#4A4A4A"));
        return;
      }
      paramTextView.setTextColor(localContext.getResources().getColor(2131167043));
      return;
    }
    paramTextView.setTextSize(1, 17.0F);
    paramTextView.setTextColor(localContext.getResources().getColor(2131166910));
    paramTextView.setIncludeFontPadding(false);
  }
  
  private void a(ayob paramayob, aywi paramaywi)
  {
    Object localObject1 = BaseApplicationImpl.getApplication().getRuntime();
    Object localObject3 = paramaywi.a().getContext();
    label59:
    int i;
    Object localObject2;
    int m;
    int n;
    label322:
    Object localObject4;
    int k;
    int j;
    if (ThemeUtil.isNowThemeIsNight((AppRuntime)localObject1, false, null))
    {
      paramaywi.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#737373"));
      if (!TextUtils.isEmpty(paramayob.jdField_a_of_type_JavaLangCharSequence)) {
        break label593;
      }
      paramaywi.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      if (paramayob.jdField_a_of_type_Aynw == null) {
        break label775;
      }
      paramaywi.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      paramaywi.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      i = (int)(bdgk.k() - xsm.a((Context)localObject3, 30.0F)) / 2 - xsm.a((Context)localObject3, 3.0F);
      localObject1 = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject1).mPlayGifImage = true;
      ((URLDrawable.URLDrawableOptions)localObject1).mFailedDrawable = new ColorDrawable(Color.parseColor("#e7e7e7"));
      ((URLDrawable.URLDrawableOptions)localObject1).mLoadingDrawable = new ColorDrawable(Color.parseColor("#e7e7e7"));
      ((URLDrawable.URLDrawableOptions)localObject1).mRequestWidth = i;
      ((URLDrawable.URLDrawableOptions)localObject1).mRequestHeight = i;
      localObject2 = URLDrawable.getDrawable(paramayob.jdField_a_of_type_Aynw.jdField_a_of_type_JavaLangString, (URLDrawable.URLDrawableOptions)localObject1);
      paramaywi.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable((Drawable)localObject2);
      if ((((URLDrawable)localObject2).getStatus() != 1) && (((URLDrawable)localObject2).getStatus() != 0)) {
        ((URLDrawable)localObject2).restartDownload();
      }
      localObject2 = (LinearLayout.LayoutParams)paramaywi.jdField_a_of_type_ComTencentImageURLImageView.getLayoutParams();
      ((LinearLayout.LayoutParams)localObject2).height = i;
      ((LinearLayout.LayoutParams)localObject2).width = i;
      paramaywi.jdField_a_of_type_ComTencentImageURLImageView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
      paramaywi.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(0);
      if (paramayob.jdField_a_of_type_JavaUtilList == null) {
        return;
      }
      m = Math.min(paramayob.jdField_a_of_type_JavaUtilList.size(), 4);
      n = (i - xsm.a((Context)localObject3, 3.0F)) / 2;
      localObject2 = new int[4];
      Object tmp295_293 = localObject2;
      tmp295_293[0] = 2131367955;
      Object tmp301_295 = tmp295_293;
      tmp301_295[1] = 2131367956;
      Object tmp307_301 = tmp301_295;
      tmp307_301[2] = 2131367957;
      Object tmp313_307 = tmp307_301;
      tmp313_307[3] = 2131367958;
      tmp313_307;
      i = 0;
      if (i >= m) {
        break label748;
      }
      localObject3 = (SquareImageView)paramaywi.jdField_b_of_type_AndroidWidgetLinearLayout.findViewById(localObject2[i]);
      localObject4 = ((aynw)paramayob.jdField_a_of_type_JavaUtilList.get(i)).jdField_a_of_type_JavaLangString;
      ((URLDrawable.URLDrawableOptions)localObject1).mPlayGifImage = true;
      ((URLDrawable.URLDrawableOptions)localObject1).mFailedDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
      ((URLDrawable.URLDrawableOptions)localObject1).mLoadingDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
      ((URLDrawable.URLDrawableOptions)localObject1).mRequestWidth = n;
      ((URLDrawable.URLDrawableOptions)localObject1).mRequestHeight = n;
      localObject4 = URLDrawable.getDrawable((String)localObject4, (URLDrawable.URLDrawableOptions)localObject1);
      ((SquareImageView)localObject3).setImageDrawable((Drawable)localObject4);
      if ((((URLDrawable)localObject4).getStatus() != 1) && (((URLDrawable)localObject4).getStatus() != 0)) {
        ((URLDrawable)localObject4).restartDownload();
      }
      localObject4 = (LinearLayout.LayoutParams)((SquareImageView)localObject3).getLayoutParams();
      ((LinearLayout.LayoutParams)localObject4).height = n;
      ((LinearLayout.LayoutParams)localObject4).width = n;
      ((SquareImageView)localObject3).setLayoutParams((ViewGroup.LayoutParams)localObject4);
      ((SquareImageView)localObject3).setVisibility(0);
      if ((i != 3) || (paramayob.jdField_a_of_type_Int <= 4)) {
        break label731;
      }
      ((SquareImageView)localObject3).setFilterColor(Color.parseColor("#66000000"));
      k = paramayob.jdField_a_of_type_Int - 4;
      localObject4 = new StringBuilder().append("+");
      j = k;
      if (k > 99) {
        j = 99;
      }
      ((SquareImageView)localObject3).setFilterText(j);
      ((SquareImageView)localObject3).setFilterTextSize(bdaq.a(paramaywi.a().getContext(), 20.0F));
    }
    for (;;)
    {
      i += 1;
      break label322;
      paramaywi.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#262626"));
      break;
      label593:
      i = (int)(paramaywi.jdField_a_of_type_AndroidWidgetTextView.getContext().getResources().getDisplayMetrics().widthPixels - bdaq.a(paramaywi.jdField_a_of_type_AndroidWidgetTextView.getContext(), 30.0F) - ayvm.a(paramaywi.jdField_a_of_type_AndroidWidgetTextView, paramayob.jdField_a_of_type_JavaLangString));
      localObject2 = ayvm.a(paramaywi.jdField_a_of_type_AndroidWidgetTextView, i, 1, paramayob.jdField_a_of_type_JavaLangCharSequence.toString(), paramayob.jdField_a_of_type_Ayvb.jdField_a_of_type_JavaUtilList, false, false, true);
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      if (paramayob.jdField_a_of_type_JavaLangString == null) {
        paramayob.jdField_a_of_type_JavaLangString = "";
      }
      paramaywi.jdField_a_of_type_AndroidWidgetTextView.setText(new SpannableStringBuilder((CharSequence)localObject1).append(paramayob.jdField_a_of_type_JavaLangString));
      paramaywi.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      break label59;
      label731:
      ((SquareImageView)localObject3).setFilterColor(-1);
      ((SquareImageView)localObject3).setFilterText("");
    }
    label748:
    while (i < 4)
    {
      paramaywi.jdField_b_of_type_AndroidWidgetLinearLayout.findViewById(localObject2[i]).setVisibility(4);
      i += 1;
    }
    label775:
    paramaywi.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    paramaywi.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
    if (paramayob.jdField_a_of_type_JavaUtilList != null)
    {
      m = Math.min(paramayob.jdField_a_of_type_JavaUtilList.size(), paramaywi.jdField_a_of_type_Int);
      n = (int)(bdgk.k() - xsm.a(paramaywi.a().getContext(), (m - 1) * 2 + 27));
      i = 0;
      if (i < m)
      {
        localObject1 = (SquareImageView)paramaywi.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(i);
        localObject2 = ((aynw)paramayob.jdField_a_of_type_JavaUtilList.get(i)).jdField_a_of_type_JavaLangString;
        localObject4 = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject4).mPlayGifImage = true;
        ((URLDrawable.URLDrawableOptions)localObject4).mFailedDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
        ((URLDrawable.URLDrawableOptions)localObject4).mLoadingDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
        ((URLDrawable.URLDrawableOptions)localObject4).mRequestWidth = n;
        ((URLDrawable.URLDrawableOptions)localObject4).mRequestHeight = n;
        ((URLDrawable.URLDrawableOptions)localObject4).mMemoryCacheKeySuffix = "fourPic";
        localObject2 = URLDrawable.getDrawable((String)localObject2, (URLDrawable.URLDrawableOptions)localObject4);
        ((SquareImageView)localObject1).setImageDrawable((Drawable)localObject2);
        if ((((URLDrawable)localObject2).getStatus() != 1) && (((URLDrawable)localObject2).getStatus() != 0)) {
          ((URLDrawable)localObject2).restartDownload();
        }
        if (paramayob.jdField_b_of_type_Int != 0)
        {
          ((SquareImageView)localObject1).setImageScale(n / 4 * 1.0F / bdaq.a((Context)localObject3, paramayob.jdField_b_of_type_Int / 2), 0.0F);
          label1007:
          ((SquareImageView)localObject1).setVisibility(0);
          if ((i != paramaywi.jdField_a_of_type_Int - 1) || (paramayob.jdField_a_of_type_Int <= paramaywi.jdField_a_of_type_Int)) {
            break label1136;
          }
          ((SquareImageView)localObject1).setFilterColor(Color.parseColor("#66000000"));
          k = paramayob.jdField_a_of_type_Int - paramaywi.jdField_a_of_type_Int;
          localObject2 = new StringBuilder().append("+");
          j = k;
          if (k > 99) {
            j = 99;
          }
          ((SquareImageView)localObject1).setFilterText(j);
          ((SquareImageView)localObject1).setFilterTextSize(bdaq.a(paramaywi.a().getContext(), 20.0F));
        }
        for (;;)
        {
          i += 1;
          break;
          ((SquareImageView)localObject1).setImageScale(1.0F, 0.0F);
          break label1007;
          label1136:
          ((SquareImageView)localObject1).setFilterColor(-1);
          ((SquareImageView)localObject1).setFilterText("");
        }
      }
      while (i < paramaywi.jdField_a_of_type_Int)
      {
        paramaywi.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(i).setVisibility(4);
        i += 1;
      }
    }
  }
  
  private void a(ayoc paramayoc, aywj paramaywj)
  {
    Object localObject = paramaywj.a().getContext();
    int i;
    if (!TextUtils.isEmpty(paramayoc.i))
    {
      paramaywj.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      a((Context)localObject, (SquareImageView)paramaywj.jdField_a_of_type_AndroidWidgetImageView, paramaywj.jdField_b_of_type_AndroidWidgetImageView, paramaywj.jdField_b_of_type_AndroidWidgetTextView, paramayoc.jdField_a_of_type_Int, paramayoc.i, paramayoc.jdField_b_of_type_JavaLangString, ((Context)localObject).getResources().getDimensionPixelSize(2131298229));
      i = ((Context)localObject).getResources().getDimensionPixelSize(2131298229);
      if ((paramayoc.jdField_a_of_type_Int == 6) || (paramayoc.jdField_a_of_type_Int == 8)) {
        i = bdaq.a((Context)localObject, 100.0F);
      }
      if (paramaywj.jdField_a_of_type_AndroidWidgetRelativeLayout.getVisibility() != 8) {
        break label317;
      }
      i = 0;
      label127:
      float f = ((Context)localObject).getResources().getDisplayMetrics().widthPixels - bdaq.a((Context)localObject, 30.0F);
      CharSequence localCharSequence = ayvm.a(paramaywj.jdField_a_of_type_AndroidWidgetTextView, f, 2, paramayoc.jdField_a_of_type_JavaLangCharSequence.toString(), paramayoc.jdField_a_of_type_Ayvb.jdField_a_of_type_JavaUtilList, false, true);
      paramaywj.jdField_a_of_type_AndroidWidgetTextView.setText(localCharSequence);
      f = ((Context)localObject).getResources().getDisplayMetrics().widthPixels - bdaq.a((Context)localObject, 30.0F) - i;
      localObject = ayvm.a(paramaywj.c, f, 2, paramayoc.jdField_b_of_type_JavaLangCharSequence.toString(), paramayoc.jdField_a_of_type_Ayvb.jdField_a_of_type_JavaUtilList, false, false);
      if (!ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null)) {
        break label333;
      }
      paramaywj.c.setTextColor(Color.parseColor("#4A4A4A"));
      paramaywj.jdField_d_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#4A4A4A"));
    }
    for (;;)
    {
      a(paramaywj.c, (CharSequence)localObject, true);
      a(paramaywj.jdField_d_of_type_AndroidWidgetTextView, paramayoc.jdField_c_of_type_JavaLangCharSequence);
      return;
      paramaywj.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      break;
      label317:
      i += bdaq.a((Context)localObject, 10.0F);
      break label127;
      label333:
      paramaywj.c.setTextColor(Color.parseColor("#737373"));
      paramaywj.jdField_d_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#737373"));
    }
  }
  
  private void a(ayof paramayof, aywl paramaywl)
  {
    Context localContext = paramaywl.a().getContext();
    int j;
    int i;
    if (paramayof.jdField_a_of_type_Int == 1)
    {
      j = bdaq.a(localContext, 375.0F);
      i = bdaq.a(localContext, 150.0F);
    }
    for (;;)
    {
      int k;
      if ((j == 0) || (i == 0))
      {
        i = bdaq.a(localContext, 375.0F);
        j = bdaq.a(localContext, 150.0F);
        k = i;
        i = j;
      }
      for (;;)
      {
        if (!TextUtils.isEmpty(paramayof.jdField_b_of_type_JavaLangString))
        {
          localObject = URLDrawable.URLDrawableOptions.obtain();
          ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
          ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
          ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = k;
          ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = i;
          ((URLDrawable.URLDrawableOptions)localObject).mPlayGifImage = true;
          localObject = URLDrawable.getDrawable(paramayof.jdField_b_of_type_JavaLangString, (URLDrawable.URLDrawableOptions)localObject);
          paramaywl.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable((Drawable)localObject);
          if ((((URLDrawable)localObject).getStatus() != 1) && (((URLDrawable)localObject).getStatus() != 0)) {
            ((URLDrawable)localObject).restartDownload();
          }
          label164:
          paramaywl.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(0);
          localObject = (LinearLayout.LayoutParams)paramaywl.jdField_a_of_type_AndroidWidgetRelativeLayout.getLayoutParams();
          ((LinearLayout.LayoutParams)localObject).height = ((int)(i * xsm.a(localContext) * 1.0F / k));
          paramaywl.jdField_a_of_type_AndroidWidgetRelativeLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
          paramaywl.jdField_a_of_type_AndroidWidgetRelativeLayout.setPadding(0, 0, 0, 0);
          if (TextUtils.isEmpty(paramayof.jdField_a_of_type_JavaLangCharSequence)) {
            break label522;
          }
          paramaywl.jdField_b_of_type_AndroidWidgetTextView.setText(paramayof.jdField_a_of_type_JavaLangCharSequence);
          paramaywl.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
          label253:
          if (TextUtils.isEmpty(paramayof.jdField_b_of_type_JavaLangCharSequence)) {
            break label534;
          }
          paramaywl.c.setText(paramayof.jdField_b_of_type_JavaLangCharSequence);
          paramaywl.c.setVisibility(0);
          label282:
          if (TextUtils.isEmpty(paramayof.j)) {
            break label599;
          }
          paramaywl.jdField_d_of_type_AndroidWidgetTextView.setText(paramayof.j);
        }
        try
        {
          if (!paramayof.k.startsWith("#")) {
            paramayof.k = ("#" + paramayof.k);
          }
          paramaywl.jdField_d_of_type_AndroidWidgetTextView.setBackgroundColor(Color.parseColor(paramayof.k));
        }
        catch (Exception localException)
        {
          for (;;)
          {
            label365:
            paramaywl.jdField_d_of_type_AndroidWidgetTextView.setBackgroundColor(Color.parseColor("#FF00FF00"));
            if (QLog.isColorLevel()) {
              QLog.e("Q.uniteSearch.SearchTemplatePresenter", 2, "bigImageItem.topLeftTagColor = " + paramayof.k);
            }
          }
        }
        paramaywl.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
        Object localObject = ((ViewGroup)paramaywl.a()).getChildAt(((ViewGroup)paramaywl.a()).getChildCount() - 1);
        if ((localObject != null) && ((((View)localObject).getLayoutParams() instanceof LinearLayout.LayoutParams)))
        {
          if (paramayof.b() != 0) {
            break label611;
          }
          ((LinearLayout.LayoutParams)((View)localObject).getLayoutParams()).topMargin = 0;
          paramaywl.jdField_a_of_type_AndroidWidgetRelativeLayout.setPadding(0, 0, 0, bdaq.a(localContext, 6.0F));
        }
        label522:
        label534:
        label599:
        label611:
        while (paramayof.b() != 2)
        {
          return;
          if (paramayof.jdField_a_of_type_Int == 2)
          {
            j = bdaq.a(localContext, 375.0F);
            i = bdaq.a(localContext, 180.0F);
            break;
          }
          if (paramayof.jdField_a_of_type_Int != 0) {
            break label639;
          }
          j = bdaq.a(localContext, paramayof.jdField_a_of_type_Float / 2.0F);
          i = bdaq.a(localContext, paramayof.jdField_b_of_type_Float / 2.0F);
          break;
          paramaywl.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
          break label164;
          paramaywl.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
          break label253;
          paramaywl.c.setVisibility(8);
          break label282;
          paramaywl.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
          break label365;
        }
        ((LinearLayout.LayoutParams)localException.getLayoutParams()).bottomMargin = 0;
        return;
        k = j;
      }
      label639:
      i = 0;
      j = 0;
    }
  }
  
  private void a(ayoh paramayoh, aywn paramaywn)
  {
    Object localObject1 = paramaywn.a().getContext();
    Object localObject2 = paramaywn.a();
    if (paramayoh.jdField_b_of_type_Boolean) {
      ((View)localObject2).setPadding(((View)localObject2).getPaddingLeft(), xsm.a(((View)localObject2).getContext(), 6.0F), ((View)localObject2).getPaddingRight(), xsm.a(((View)localObject2).getContext(), 6.0F));
    }
    Object localObject3;
    int i;
    Object localObject4;
    for (;;)
    {
      localObject2 = (LinearLayout)((View)localObject2).findViewById(2131371984);
      localObject3 = new ArrayList();
      i = 0;
      while (i < ((LinearLayout)localObject2).getChildCount())
      {
        localObject4 = ((LinearLayout)localObject2).getChildAt(i).findViewById(2131368018);
        if ((localObject4 instanceof SquareImageView)) {
          ((List)localObject3).add((SquareImageView)localObject4);
        }
        i += 1;
      }
      ((View)localObject2).setPadding(((View)localObject2).getPaddingLeft(), xsm.a(((View)localObject2).getContext(), 3.0F), ((View)localObject2).getPaddingRight(), xsm.a(((View)localObject2).getContext(), 3.0F));
    }
    if (!((List)localObject3).isEmpty())
    {
      if (paramayoh.jdField_c_of_type_Boolean)
      {
        i = 0;
        while (i < ((List)localObject3).size())
        {
          ((SquareImageView)((List)localObject3).get(i)).setRoundRect(xsm.a((Context)localObject1, 4.0F));
          i += 1;
        }
      }
      i = 0;
      while (i < ((List)localObject3).size())
      {
        ((SquareImageView)((List)localObject3).get(i)).setRoundRect(0);
        i += 1;
      }
    }
    if (!TextUtils.isEmpty(paramayoh.i)) {
      a((Context)localObject1, (SquareImageView)paramaywn.b(), paramaywn.jdField_b_of_type_AndroidWidgetImageView, paramaywn.jdField_a_of_type_AndroidWidgetTextView, paramayoh.jdField_a_of_type_Int, paramayoh.i, null, bdaq.a((Context)localObject1, 32.0F));
    }
    label687:
    Object localObject5;
    if (!TextUtils.isEmpty(paramayoh.jdField_a_of_type_JavaLangString))
    {
      localObject2 = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
      ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
      ((URLDrawable.URLDrawableOptions)localObject2).mRequestWidth = paramaywn.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams().width;
      ((URLDrawable.URLDrawableOptions)localObject2).mRequestHeight = paramaywn.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams().height;
      localObject2 = URLDrawable.getDrawable(paramayoh.jdField_a_of_type_JavaLangString, (URLDrawable.URLDrawableOptions)localObject2);
      paramaywn.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject2);
      if ((((URLDrawable)localObject2).getStatus() != 1) && (((URLDrawable)localObject2).getStatus() != 0)) {
        ((URLDrawable)localObject2).restartDownload();
      }
      paramaywn.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      i = ((Context)localObject1).getResources().getDimensionPixelSize(2131298229);
      if ((paramayoh.jdField_a_of_type_Int == 6) || (paramayoh.jdField_a_of_type_Int == 8)) {
        i = bdaq.a((Context)localObject1, 100.0F);
      }
      localObject2 = ayvm.a(paramaywn.a(), 10.0F * ayvm.a(paramaywn.a(), alud.a(2131714056)), 1, paramayoh.jdField_a_of_type_JavaLangCharSequence.toString(), paramayoh.jdField_a_of_type_Ayvb.jdField_a_of_type_JavaUtilList, false, false, true);
      paramaywn.a().setText((CharSequence)localObject2);
      paramaywn.a().setEllipsize(null);
      float f1 = ((Context)localObject1).getResources().getDisplayMetrics().widthPixels - bdaq.a((Context)localObject1, 40.0F) - i;
      localObject2 = ayvm.a(paramaywn.b(), f1, 2, paramayoh.jdField_b_of_type_JavaLangCharSequence.toString(), "", false, false, true);
      a(paramaywn.b(), (CharSequence)localObject2, false);
      if (TextUtils.isEmpty(paramayoh.jdField_c_of_type_JavaLangCharSequence)) {
        break label1047;
      }
      f1 = ((Context)localObject1).getResources().getDisplayMetrics().widthPixels - bdaq.a((Context)localObject1, 30.0F);
      localObject2 = ayvm.a(paramaywn.c(), f1, 2, paramayoh.jdField_c_of_type_JavaLangCharSequence.toString(), paramayoh.jdField_a_of_type_Ayvb.jdField_a_of_type_JavaUtilList, false, false);
      paramaywn.c().setText((CharSequence)localObject2);
      paramaywn.c().setVisibility(0);
      if (paramayoh.jdField_a_of_type_JavaUtilList == null) {
        break label1479;
      }
      if (paramayoh.jdField_a_of_type_JavaUtilList.size() != 1) {
        break label1071;
      }
      paramaywn.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(0);
      paramaywn.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      localObject3 = paramaywn.a().getResources();
      if (jdField_a_of_type_Int == 0) {
        jdField_a_of_type_Int = ((Resources)localObject3).getDisplayMetrics().widthPixels;
      }
      localObject2 = paramaywn.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView;
      ((SquareImageView)localObject2).setImageScale((float)(1.0D / paramayoh.jdField_a_of_type_Double), 0.0F);
      f1 = ((Resources)localObject3).getDimension(2131298222);
      float f2 = ((Resources)localObject3).getDimension(2131298222);
      i = bdaq.a(paramaywn.a().getContext(), 2.0F);
      j = paramaywn.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount();
      j = (int)(jdField_a_of_type_Int - f1 - f2 - (j - 1) * i) / j;
      i = (int)(j * paramayoh.jdField_b_of_type_Double);
      j = (int)(j * paramayoh.jdField_b_of_type_Double);
      ((SquareImageView)localObject2).setLayoutParams(new FrameLayout.LayoutParams(i, j));
      localObject3 = (aynw)paramayoh.jdField_a_of_type_JavaUtilList.get(0);
      localObject4 = ((aynw)localObject3).jdField_a_of_type_JavaLangString;
      localObject5 = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject5).mFailedDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
      ((URLDrawable.URLDrawableOptions)localObject5).mLoadingDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
      ((URLDrawable.URLDrawableOptions)localObject5).mRequestWidth = i;
      ((URLDrawable.URLDrawableOptions)localObject5).mRequestHeight = j;
      ((URLDrawable.URLDrawableOptions)localObject5).mPlayGifImage = true;
      localObject4 = URLDrawable.getDrawable((String)localObject4, (URLDrawable.URLDrawableOptions)localObject5);
      ((SquareImageView)localObject2).setImageDrawable((Drawable)localObject4);
      if ((((URLDrawable)localObject4).getStatus() != 1) && (((URLDrawable)localObject4).getStatus() != 0)) {
        ((URLDrawable)localObject4).restartDownload();
      }
      if (((aynw)localObject3).jdField_a_of_type_Int != 2) {
        break label1059;
      }
      paramaywn.jdField_d_of_type_AndroidWidgetImageView.setVisibility(0);
    }
    for (;;)
    {
      if ((paramayoh.jdField_c_of_type_JavaUtilList != null) || (!TextUtils.equals(paramayoh.k, "0")) || (!TextUtils.equals(paramayoh.m, "0"))) {
        break label1500;
      }
      paramaywn.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      return;
      paramaywn.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      break;
      label1047:
      paramaywn.c().setVisibility(8);
      break label687;
      label1059:
      paramaywn.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
      continue;
      label1071:
      paramaywn.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(8);
      paramaywn.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      int m = paramaywn.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount();
      i = 0;
      j = i;
      if (i < paramayoh.jdField_a_of_type_JavaUtilList.size())
      {
        j = i;
        if (i < m)
        {
          localObject3 = paramaywn.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(i);
          ((View)localObject3).setVisibility(0);
          localObject2 = (SquareImageView)((View)localObject3).findViewById(2131368018);
          localObject3 = (ImageView)((View)localObject3).findViewById(2131369137);
          ((SquareImageView)localObject2).setImageScale((float)(1.0D / paramayoh.jdField_a_of_type_Double), 0.0F);
          localObject4 = (aynw)paramayoh.jdField_a_of_type_JavaUtilList.get(i);
          localObject5 = ((aynw)localObject4).jdField_a_of_type_JavaLangString;
          URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
          localURLDrawableOptions.mRequestHeight = 200;
          localURLDrawableOptions.mRequestWidth = 200;
          localURLDrawableOptions.mFailedDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
          localURLDrawableOptions.mLoadingDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
          localURLDrawableOptions.mPlayGifImage = true;
          localObject5 = URLDrawable.getDrawable((String)localObject5, localURLDrawableOptions);
          ((SquareImageView)localObject2).setImageDrawable((Drawable)localObject5);
          if ((((URLDrawable)localObject5).getStatus() != 1) && (((URLDrawable)localObject5).getStatus() != 0)) {
            ((URLDrawable)localObject5).restartDownload();
          }
          ((SquareImageView)localObject2).setVisibility(0);
          if (((aynw)localObject4).jdField_a_of_type_Int == 2)
          {
            ((ImageView)localObject3).setVisibility(0);
            label1312:
            if ((i != m - 1) || (paramayoh.jdField_b_of_type_Int <= m)) {
              break label1433;
            }
            ((ImageView)localObject3).setVisibility(8);
            ((SquareImageView)localObject2).setFilterColor(Color.parseColor("#66000000"));
            int k = paramayoh.jdField_b_of_type_Int - m;
            j = k;
            if (k > 99) {
              j = 99;
            }
            ((SquareImageView)localObject2).setFilterText("+" + j);
            ((SquareImageView)localObject2).setFilterTextSize(bdaq.a(((SquareImageView)localObject2).getContext(), 20.0F));
          }
          for (;;)
          {
            i += 1;
            break;
            ((ImageView)localObject3).setVisibility(8);
            break label1312;
            label1433:
            ((SquareImageView)localObject2).setFilterColor(-1);
            ((SquareImageView)localObject2).setFilterText("");
          }
        }
      }
      while (j < m)
      {
        paramaywn.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(j).setVisibility(4);
        j += 1;
      }
      continue;
      label1479:
      paramaywn.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(8);
      paramaywn.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    }
    label1500:
    if (paramayoh.jdField_c_of_type_JavaUtilList != null)
    {
      paramaywn.jdField_a_of_type_AndroidWidgetRelativeLayout.removeAllViews();
      i = paramayoh.jdField_c_of_type_JavaUtilList.size() - 1;
      if (i < 0) {
        break label1758;
      }
      if (i <= 0) {
        break label2130;
      }
    }
    label1929:
    label2084:
    label2096:
    label2108:
    label2120:
    label2130:
    for (int j = bdaq.a((Context)localObject1, 11.0F) * i;; j = 0)
    {
      localObject2 = (SquareImageView)LayoutInflater.from((Context)localObject1).inflate(2131559677, null, false);
      localObject3 = new RelativeLayout.LayoutParams(bdaq.a((Context)localObject1, 16.0F), bdaq.a((Context)localObject1, 16.0F));
      ((RelativeLayout.LayoutParams)localObject3).leftMargin = j;
      paramaywn.jdField_a_of_type_AndroidWidgetRelativeLayout.addView((View)localObject2, paramayoh.jdField_c_of_type_JavaUtilList.size() - 1 - i, (ViewGroup.LayoutParams)localObject3);
      localObject3 = (String)paramayoh.jdField_c_of_type_JavaUtilList.get(i);
      localObject4 = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject4).mFailedDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
      ((URLDrawable.URLDrawableOptions)localObject4).mLoadingDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
      ((URLDrawable.URLDrawableOptions)localObject4).mRequestWidth = ((SquareImageView)localObject2).getLayoutParams().width;
      ((URLDrawable.URLDrawableOptions)localObject4).mRequestHeight = ((SquareImageView)localObject2).getLayoutParams().height;
      localObject3 = URLDrawable.getDrawable((String)localObject3, (URLDrawable.URLDrawableOptions)localObject4);
      ((URLDrawable)localObject3).setDecodeHandler(bcyz.a);
      ((SquareImageView)localObject2).setImageDrawable((Drawable)localObject3);
      if ((((URLDrawable)localObject3).getStatus() != 1) && (((URLDrawable)localObject3).getStatus() != 0)) {
        ((URLDrawable)localObject3).restartDownload();
      }
      ((SquareImageView)localObject2).setVisibility(0);
      i -= 1;
      break;
      paramaywn.jdField_a_of_type_AndroidWidgetRelativeLayout.removeAllViews();
      label1758:
      if (!TextUtils.isEmpty(paramayoh.jdField_b_of_type_JavaLangString))
      {
        paramaywn.jdField_b_of_type_AndroidWidgetTextView.setText(paramayoh.jdField_b_of_type_JavaLangString);
        paramaywn.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
        if (TextUtils.isEmpty(paramayoh.j)) {
          break label2084;
        }
        localObject1 = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject1).mFailedDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
        ((URLDrawable.URLDrawableOptions)localObject1).mLoadingDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
        ((URLDrawable.URLDrawableOptions)localObject1).mRequestWidth = paramaywn.jdField_a_of_type_ComTencentImageURLImageView.getLayoutParams().width;
        ((URLDrawable.URLDrawableOptions)localObject1).mRequestHeight = paramaywn.jdField_a_of_type_ComTencentImageURLImageView.getLayoutParams().height;
        localObject1 = URLDrawable.getDrawable(paramayoh.j, (URLDrawable.URLDrawableOptions)localObject1);
        paramaywn.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable((Drawable)localObject1);
        if ((((URLDrawable)localObject1).getStatus() != 1) && (((URLDrawable)localObject1).getStatus() != 0)) {
          ((URLDrawable)localObject1).restartDownload();
        }
        paramaywn.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(0);
        label1900:
        if (TextUtils.isEmpty(paramayoh.k)) {
          break label2096;
        }
        paramaywn.c.setText(paramayoh.k);
        paramaywn.c.setVisibility(0);
        if (TextUtils.isEmpty(paramayoh.l)) {
          break label2108;
        }
        localObject1 = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject1).mFailedDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
        ((URLDrawable.URLDrawableOptions)localObject1).mLoadingDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
        ((URLDrawable.URLDrawableOptions)localObject1).mRequestWidth = paramaywn.jdField_b_of_type_ComTencentImageURLImageView.getLayoutParams().width;
        ((URLDrawable.URLDrawableOptions)localObject1).mRequestHeight = paramaywn.jdField_b_of_type_ComTencentImageURLImageView.getLayoutParams().height;
        localObject1 = URLDrawable.getDrawable(paramayoh.l, (URLDrawable.URLDrawableOptions)localObject1);
        paramaywn.jdField_b_of_type_ComTencentImageURLImageView.setImageDrawable((Drawable)localObject1);
        if ((((URLDrawable)localObject1).getStatus() != 1) && (((URLDrawable)localObject1).getStatus() != 0)) {
          ((URLDrawable)localObject1).restartDownload();
        }
        paramaywn.jdField_b_of_type_ComTencentImageURLImageView.setVisibility(0);
      }
      for (;;)
      {
        if (TextUtils.isEmpty(paramayoh.m)) {
          break label2120;
        }
        paramaywn.jdField_d_of_type_AndroidWidgetTextView.setText(paramayoh.m);
        paramaywn.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
        return;
        paramaywn.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
        break;
        paramaywn.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(8);
        break label1900;
        paramaywn.c.setVisibility(8);
        break label1929;
        paramaywn.jdField_b_of_type_ComTencentImageURLImageView.setVisibility(8);
      }
      paramaywn.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
      return;
    }
  }
  
  private void a(ayon paramayon, aywt paramaywt)
  {
    Object localObject = paramaywt.a();
    Context localContext = ((View)localObject).getContext();
    if (((localObject instanceof LinearLayout)) && (((LinearLayout)localObject).getChildCount() == 1))
    {
      localObject = ((LinearLayout)localObject).getChildAt(0);
      ((View)localObject).setPadding(((View)localObject).getPaddingLeft(), 0, ((View)localObject).getPaddingRight(), 0);
    }
    if (!TextUtils.isEmpty(paramayon.jdField_b_of_type_JavaLangString))
    {
      localObject = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
      ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
      ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = bdaq.a(localContext, 50.0F);
      ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = bdaq.a(localContext, 50.0F);
      ((URLDrawable.URLDrawableOptions)localObject).mMemoryCacheKeySuffix = "leftIcon";
      localObject = URLDrawable.getDrawable(paramayon.jdField_b_of_type_JavaLangString, (URLDrawable.URLDrawableOptions)localObject);
      paramaywt.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable((Drawable)localObject);
      if ((((URLDrawable)localObject).getStatus() != 1) && (((URLDrawable)localObject).getStatus() != 0)) {
        ((URLDrawable)localObject).restartDownload();
      }
      paramaywt.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(0);
      if (TextUtils.isEmpty(paramayon.j)) {
        break label504;
      }
      paramaywt.jdField_a_of_type_AndroidWidgetTextView.setText(paramayon.j);
      paramaywt.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      label204:
      if (TextUtils.isEmpty(paramayon.g)) {
        break label516;
      }
      paramaywt.jdField_b_of_type_AndroidWidgetTextView.setText(paramayon.g);
      paramaywt.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      label233:
      if (TextUtils.isEmpty(paramayon.k)) {
        break label528;
      }
      paramaywt.c.setVisibility(0);
      paramaywt.c.setText(paramayon.k);
      label262:
      if (TextUtils.isEmpty(paramayon.l)) {
        break label540;
      }
      localObject = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
      ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
      ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = bdaq.a(localContext, 30.0F);
      ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = bdaq.a(localContext, 30.0F);
      ((URLDrawable.URLDrawableOptions)localObject).mMemoryCacheKeySuffix = "rightIcon";
      localObject = URLDrawable.getDrawable(paramayon.l, (URLDrawable.URLDrawableOptions)localObject);
      paramaywt.jdField_b_of_type_ComTencentImageURLImageView.setImageDrawable((Drawable)localObject);
      if ((((URLDrawable)localObject).getStatus() != 1) && (((URLDrawable)localObject).getStatus() != 0)) {
        ((URLDrawable)localObject).restartDownload();
      }
      paramaywt.jdField_b_of_type_ComTencentImageURLImageView.setVisibility(0);
      label377:
      paramaywt.a(paramayon);
      if (!ThemeUtil.isInNightMode(BaseApplicationImpl.getApplication().getRuntime())) {
        break label552;
      }
      paramaywt.jdField_a_of_type_AndroidWidgetLinearLayout.setBackgroundResource(2130839209);
      paramaywt.jdField_b_of_type_AndroidWidgetLinearLayout.setBackgroundResource(2130839209);
      paramaywt.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#737373"));
      paramaywt.c.setTextColor(Color.parseColor("#4A4A4A"));
    }
    for (;;)
    {
      if (paramaywt.jdField_b_of_type_AndroidWidgetTextView != null) {
        paramaywt.jdField_b_of_type_AndroidWidgetTextView.setTextColor(ayvm.b());
      }
      paramaywt.jdField_a_of_type_AndroidWidgetLinearLayout.setOnClickListener(new ayrs(this, paramayon, localContext));
      paramaywt.jdField_b_of_type_AndroidWidgetLinearLayout.setOnClickListener(new ayrt(this, paramayon, localContext));
      return;
      paramaywt.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(8);
      break;
      label504:
      paramaywt.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      break label204;
      label516:
      paramaywt.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      break label233;
      label528:
      paramaywt.c.setVisibility(8);
      break label262;
      label540:
      paramaywt.jdField_b_of_type_ComTencentImageURLImageView.setVisibility(8);
      break label377;
      label552:
      paramaywt.jdField_a_of_type_AndroidWidgetLinearLayout.setBackgroundResource(2130839208);
      paramaywt.jdField_b_of_type_AndroidWidgetLinearLayout.setBackgroundResource(2130839208);
      paramaywt.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#262626"));
      paramaywt.c.setTextColor(Color.parseColor("#737373"));
    }
  }
  
  private void a(ayoo paramayoo, aywv paramaywv)
  {
    Object localObject = paramaywv.a();
    Context localContext = ((View)localObject).getContext();
    if (((localObject instanceof LinearLayout)) && (((LinearLayout)localObject).getChildCount() == 1))
    {
      localObject = ((LinearLayout)localObject).getChildAt(0);
      ((View)localObject).setPadding(((View)localObject).getPaddingLeft(), 0, ((View)localObject).getPaddingRight(), 0);
    }
    if (!TextUtils.isEmpty(paramayoo.jdField_b_of_type_JavaLangString))
    {
      localObject = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
      ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
      ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = bdaq.a(localContext, 40.0F);
      ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = bdaq.a(localContext, 40.0F);
      ((URLDrawable.URLDrawableOptions)localObject).mMemoryCacheKeySuffix = "leftIcon";
      localObject = URLDrawable.getDrawable(paramayoo.jdField_b_of_type_JavaLangString, (URLDrawable.URLDrawableOptions)localObject);
      paramaywv.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable((Drawable)localObject);
      if ((((URLDrawable)localObject).getStatus() != 1) && (((URLDrawable)localObject).getStatus() != 0)) {
        ((URLDrawable)localObject).restartDownload();
      }
      paramaywv.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(0);
      if (TextUtils.isEmpty(paramayoo.j)) {
        break label363;
      }
      paramaywv.jdField_a_of_type_AndroidWidgetTextView.setText(paramayoo.j);
      paramaywv.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      label204:
      if (TextUtils.isEmpty(paramayoo.g)) {
        break label375;
      }
      paramaywv.c.setText(paramayoo.g);
      paramaywv.c.setVisibility(0);
      label233:
      if (TextUtils.isEmpty(paramayoo.k)) {
        break label387;
      }
      paramaywv.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
      paramaywv.jdField_d_of_type_AndroidWidgetTextView.setText(paramayoo.k);
      label262:
      if (!paramayoo.jdField_b_of_type_Boolean) {
        break label399;
      }
      paramaywv.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    }
    for (;;)
    {
      aysc.a(null, 0, paramayoo.jdField_c_of_type_Int, "0X8009D5C", 0, 0, null, null);
      if ((paramayoo.jdField_a_of_type_JavaUtilList != null) && (paramayoo.jdField_a_of_type_JavaUtilList.size() > 0)) {
        aysc.a(null, 0, paramayoo.jdField_c_of_type_Int, "0X8009D5E", 0, 0, null, null);
      }
      paramaywv.a(paramayoo);
      paramaywv.jdField_a_of_type_AndroidWidgetLinearLayout.setOnClickListener(new ayrr(this, paramayoo, localContext));
      return;
      paramaywv.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(8);
      break;
      label363:
      paramaywv.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      break label204;
      label375:
      paramaywv.c.setVisibility(8);
      break label233;
      label387:
      paramaywv.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
      break label262;
      label399:
      paramaywv.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    }
  }
  
  private void a(ayoq paramayoq, ayxb paramayxb)
  {
    if ((paramayoq == null) || (paramayxb == null)) {
      return;
    }
    paramayxb.jdField_a_of_type_AndroidWidgetLinearLayout.setPadding(paramayxb.jdField_a_of_type_AndroidWidgetLinearLayout.getPaddingLeft(), 0, paramayxb.jdField_a_of_type_AndroidWidgetLinearLayout.getPaddingRight(), 0);
    Object localObject = (RelativeLayout.LayoutParams)paramayxb.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams();
    boolean bool = ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null);
    if (paramayoq.jdField_b_of_type_Boolean)
    {
      ((RelativeLayout.LayoutParams)localObject).addRule(5, 0);
      ((RelativeLayout.LayoutParams)localObject).addRule(14);
      localObject = paramayxb.jdField_a_of_type_AndroidWidgetTextView.getContext();
      int i = ((Context)localObject).getResources().getDisplayMetrics().widthPixels - bdaq.a((Context)localObject, 38.0F);
      if (TextUtils.isEmpty(paramayoq.jdField_b_of_type_JavaLangCharSequence)) {
        break label310;
      }
      paramayxb.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      if (!bool) {
        break label296;
      }
      paramayxb.jdField_b_of_type_AndroidWidgetTextView.setText(paramayoq.jdField_b_of_type_JavaLangCharSequence.toString());
      label148:
      float f1 = i;
      float f2 = ayvm.a(paramayxb.jdField_b_of_type_AndroidWidgetTextView, paramayoq.jdField_b_of_type_JavaLangCharSequence);
      i = (int)(f1 - (bdaq.a((Context)localObject, 10.0F) + f2));
      label182:
      if (TextUtils.isEmpty(paramayoq.jdField_a_of_type_JavaLangCharSequence)) {
        break label334;
      }
      paramayxb.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      localObject = paramayoq.jdField_a_of_type_JavaLangCharSequence;
      if (paramayoq.jdField_b_of_type_Boolean) {
        break label346;
      }
      localObject = ayvm.a(paramayxb.jdField_a_of_type_AndroidWidgetTextView, i, (CharSequence)localObject);
    }
    label296:
    label310:
    label334:
    label346:
    for (;;)
    {
      if (bool) {
        paramayxb.jdField_a_of_type_AndroidWidgetTextView.setText(((CharSequence)localObject).toString());
      }
      for (;;)
      {
        paramayxb.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundDrawable(a(paramayoq.jdField_a_of_type_JavaLangString));
        paramayxb.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(new ayru(this, paramayoq, paramayxb));
        return;
        ((RelativeLayout.LayoutParams)localObject).addRule(14, 0);
        ((RelativeLayout.LayoutParams)localObject).addRule(5);
        break;
        paramayxb.jdField_b_of_type_AndroidWidgetTextView.setText(paramayoq.jdField_b_of_type_JavaLangCharSequence);
        break label148;
        paramayxb.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
        break label182;
        paramayxb.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
        continue;
        paramayxb.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      }
    }
  }
  
  private void a(ayor paramayor, ayxa paramayxa)
  {
    if ((paramayor == null) || (paramayxa == null)) {}
    while ((TextUtils.isEmpty(paramayor.jdField_a_of_type_JavaLangString)) || (paramayxa.jdField_a_of_type_AndroidWidgetTextView == null)) {
      return;
    }
    Context localContext = paramayxa.jdField_a_of_type_AndroidWidgetTextView.getContext();
    int j = localContext.getResources().getDisplayMetrics().widthPixels - bdaq.a(localContext, 40.0F);
    int i;
    if ((!TextUtils.isEmpty(paramayor.e)) && (paramayxa.jdField_a_of_type_AndroidWidgetLinearLayout != null))
    {
      paramayxa.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      i = j - bdaq.a(localContext, 26.0F);
    }
    for (;;)
    {
      paramayor = ayvm.a(paramayxa.jdField_a_of_type_AndroidWidgetTextView, i, paramayor.jdField_a_of_type_JavaLangString);
      paramayxa.jdField_a_of_type_AndroidWidgetTextView.setText(paramayor);
      return;
      i = j;
      if (paramayxa.jdField_a_of_type_AndroidWidgetLinearLayout != null)
      {
        paramayxa.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
        i = j;
      }
    }
  }
  
  private void a(ayot paramayot, ayxd paramayxd)
  {
    Context localContext = paramayxd.jdField_b_of_type_AndroidWidgetRelativeLayout.getContext();
    Object localObject = (RelativeLayout.LayoutParams)paramayxd.jdField_a_of_type_AndroidWidgetLinearLayout.getLayoutParams();
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)paramayxd.jdField_b_of_type_AndroidWidgetRelativeLayout.getLayoutParams();
    if (paramayot.jdField_b_of_type_Boolean)
    {
      ((RelativeLayout.LayoutParams)localObject).addRule(15);
      localLayoutParams.addRule(15);
      localLayoutParams.addRule(10, 0);
      localLayoutParams.addRule(10, 0);
    }
    for (;;)
    {
      localObject = a(paramayot, paramayxd, false, 0);
      if (((Integer)((Pair)localObject).first).intValue() != 0) {
        ((RelativeLayout.LayoutParams)paramayxd.jdField_b_of_type_AndroidWidgetRelativeLayout.getLayoutParams()).rightMargin = bdaq.a(localContext, 10.0F);
      }
      int i = a(paramayot, paramayxd);
      int j = a(paramayot, paramayxd, ((Integer)((Pair)localObject).first).intValue(), i);
      i = j;
      if (((Integer)((Pair)localObject).second).intValue() > j) {
        i = ((Integer)((Pair)localObject).second).intValue();
      }
      if (paramayxd.jdField_a_of_type_AndroidWidgetRelativeLayout != null) {
        ((RelativeLayout.LayoutParams)paramayxd.jdField_a_of_type_AndroidWidgetRelativeLayout.getLayoutParams()).height = i;
      }
      return;
      ((RelativeLayout.LayoutParams)localObject).addRule(10);
      localLayoutParams.addRule(10);
      ((RelativeLayout.LayoutParams)localObject).addRule(15, 0);
      localLayoutParams.addRule(15, 0);
    }
  }
  
  private void a(ayox paramayox, ayxe paramayxe)
  {
    Object localObject1 = paramayxe.a().getContext();
    Object localObject2 = paramayxe.a();
    if (paramayox.jdField_b_of_type_Boolean) {
      ((View)localObject2).setPadding(((View)localObject2).getPaddingLeft(), xsm.a(((View)localObject2).getContext(), 9.0F), ((View)localObject2).getPaddingRight(), xsm.a(((View)localObject2).getContext(), 9.0F));
    }
    Object localObject3;
    int i;
    Object localObject4;
    for (;;)
    {
      localObject2 = (LinearLayout)((View)localObject2).findViewById(2131371984);
      localObject3 = new ArrayList();
      i = 0;
      while (i < ((LinearLayout)localObject2).getChildCount())
      {
        localObject4 = ((LinearLayout)localObject2).getChildAt(i).findViewById(2131368018);
        if ((localObject4 instanceof SquareImageView)) {
          ((List)localObject3).add((SquareImageView)localObject4);
        }
        i += 1;
      }
      ((View)localObject2).setPadding(((View)localObject2).getPaddingLeft(), xsm.a(((View)localObject2).getContext(), 6.0F), ((View)localObject2).getPaddingRight(), xsm.a(((View)localObject2).getContext(), 6.0F));
    }
    if (!((List)localObject3).isEmpty())
    {
      if (paramayox.jdField_c_of_type_Boolean)
      {
        i = 0;
        while (i < ((List)localObject3).size())
        {
          ((SquareImageView)((List)localObject3).get(i)).setRoundRect(xsm.a((Context)localObject1, 4.0F));
          i += 1;
        }
      }
      i = 0;
      while (i < ((List)localObject3).size())
      {
        ((SquareImageView)((List)localObject3).get(i)).setRoundRect(0);
        i += 1;
      }
    }
    label496:
    int j;
    if (ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null))
    {
      paramayxe.a().setTextColor(Color.parseColor("#6991B8"));
      paramayxe.c().setTextColor(Color.parseColor("#44608A"));
      paramayxe.b().setTextColor(Color.parseColor("#44608A"));
      if (!TextUtils.isEmpty(paramayox.i)) {
        a((Context)localObject1, (SquareImageView)paramayxe.b(), paramayxe.jdField_b_of_type_AndroidWidgetImageView, paramayxe.jdField_a_of_type_AndroidWidgetTextView, paramayox.jdField_a_of_type_Int, paramayox.i, null, bdaq.a((Context)localObject1, 21.0F));
      }
      if (TextUtils.isEmpty(paramayox.jdField_a_of_type_JavaLangString)) {
        break label1085;
      }
      localObject2 = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
      ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
      ((URLDrawable.URLDrawableOptions)localObject2).mRequestWidth = paramayxe.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams().width;
      ((URLDrawable.URLDrawableOptions)localObject2).mRequestHeight = paramayxe.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams().height;
      localObject2 = URLDrawable.getDrawable(paramayox.jdField_a_of_type_JavaLangString, (URLDrawable.URLDrawableOptions)localObject2);
      paramayxe.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject2);
      if ((((URLDrawable)localObject2).getStatus() != 1) && (((URLDrawable)localObject2).getStatus() != 0)) {
        ((URLDrawable)localObject2).restartDownload();
      }
      paramayxe.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      i = ((Context)localObject1).getResources().getDimensionPixelSize(2131298229);
      if ((paramayox.jdField_a_of_type_Int == 6) || (paramayox.jdField_a_of_type_Int == 8)) {
        i = bdaq.a((Context)localObject1, 100.0F);
      }
      localObject2 = ayvm.a(paramayxe.a(), 10.0F * ayvm.a(paramayxe.a(), alud.a(2131714055)), 1, paramayox.jdField_a_of_type_JavaLangCharSequence.toString(), paramayox.jdField_a_of_type_Ayvb.jdField_a_of_type_JavaUtilList, false, false, true);
      paramayxe.a().setText((CharSequence)localObject2);
      paramayxe.a().setEllipsize(null);
      float f1 = ((Context)localObject1).getResources().getDisplayMetrics().widthPixels - bdaq.a((Context)localObject1, 40.0F) - i;
      localObject2 = ayvm.a(paramayxe.b(), f1, 2, paramayox.jdField_b_of_type_JavaLangCharSequence.toString(), "", false, false, true);
      a(paramayxe.b(), (CharSequence)localObject2, false);
      if (TextUtils.isEmpty(paramayox.jdField_c_of_type_JavaLangCharSequence)) {
        break label1097;
      }
      f1 = ((Context)localObject1).getResources().getDisplayMetrics().widthPixels - bdaq.a((Context)localObject1, 30.0F);
      localObject2 = ayvm.a(paramayxe.c(), f1, 2, paramayox.jdField_c_of_type_JavaLangCharSequence.toString(), paramayox.jdField_a_of_type_Ayvb.jdField_a_of_type_JavaUtilList, false, false);
      paramayxe.c().setText((CharSequence)localObject2);
      paramayxe.c().setVisibility(0);
      label740:
      if (paramayox.jdField_a_of_type_JavaUtilList == null) {
        break label1546;
      }
      if (paramayox.jdField_a_of_type_JavaUtilList.size() != 1) {
        break label1119;
      }
      paramayxe.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(0);
      paramayxe.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      localObject2 = paramayxe.a().getResources();
      if (jdField_a_of_type_Int == 0) {
        jdField_a_of_type_Int = ((Resources)localObject2).getDisplayMetrics().widthPixels;
      }
      localObject1 = paramayxe.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView;
      ((SquareImageView)localObject1).setImageScale((float)(1.0D / paramayox.jdField_a_of_type_Double), 0.0F);
      f1 = ((Resources)localObject2).getDimension(2131298222);
      float f2 = ((Resources)localObject2).getDimension(2131298222);
      i = bdaq.a(paramayxe.a().getContext(), 2.0F);
      j = paramayxe.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount();
      j = (int)(jdField_a_of_type_Int - f1 - f2 - (j - 1) * i) / j;
      i = (int)(j * paramayox.jdField_b_of_type_Double);
      j = (int)(j * paramayox.jdField_b_of_type_Double);
      ((SquareImageView)localObject1).setLayoutParams(new FrameLayout.LayoutParams(i, j));
      paramayox = (aynw)paramayox.jdField_a_of_type_JavaUtilList.get(0);
      localObject2 = paramayox.jdField_a_of_type_JavaLangString;
      localObject3 = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject3).mFailedDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
      ((URLDrawable.URLDrawableOptions)localObject3).mLoadingDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
      ((URLDrawable.URLDrawableOptions)localObject3).mRequestWidth = i;
      ((URLDrawable.URLDrawableOptions)localObject3).mRequestHeight = j;
      ((URLDrawable.URLDrawableOptions)localObject3).mPlayGifImage = true;
      localObject2 = URLDrawable.getDrawable((String)localObject2, (URLDrawable.URLDrawableOptions)localObject3);
      ((SquareImageView)localObject1).setImageDrawable((Drawable)localObject2);
      if ((((URLDrawable)localObject2).getStatus() != 1) && (((URLDrawable)localObject2).getStatus() != 0)) {
        ((URLDrawable)localObject2).restartDownload();
      }
      if (paramayox.jdField_a_of_type_Int != 2) {
        break label1109;
      }
      paramayxe.jdField_d_of_type_AndroidWidgetImageView.setVisibility(0);
    }
    for (;;)
    {
      return;
      paramayxe.a().setTextColor(Color.parseColor("#262626"));
      paramayxe.c().setTextColor(Color.parseColor("#737373"));
      paramayxe.b().setTextColor(Color.parseColor("#737373"));
      break;
      label1085:
      paramayxe.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      break label496;
      label1097:
      paramayxe.c().setVisibility(8);
      break label740;
      label1109:
      paramayxe.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
      return;
      label1119:
      paramayxe.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(8);
      paramayxe.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      int m = paramayxe.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount();
      i = 0;
      j = i;
      if (i < paramayox.jdField_a_of_type_JavaUtilList.size())
      {
        j = i;
        if (i < m)
        {
          localObject3 = paramayxe.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(i);
          ((View)localObject3).setVisibility(0);
          localObject2 = (SquareImageView)((View)localObject3).findViewById(2131368018);
          localObject3 = (ImageView)((View)localObject3).findViewById(2131369137);
          j = xsm.a((Context)localObject1) / m;
          int k = (int)(j * paramayox.jdField_a_of_type_Double);
          ((SquareImageView)localObject2).setImageScale((float)(1.0D / paramayox.jdField_a_of_type_Double), 0.0F);
          localObject4 = (aynw)paramayox.jdField_a_of_type_JavaUtilList.get(i);
          Object localObject5 = ((aynw)localObject4).jdField_a_of_type_JavaLangString;
          URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
          localURLDrawableOptions.mFailedDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
          localURLDrawableOptions.mLoadingDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
          localURLDrawableOptions.mRequestWidth = j;
          localURLDrawableOptions.mRequestHeight = k;
          localURLDrawableOptions.mPlayGifImage = true;
          localObject5 = URLDrawable.getDrawable((String)localObject5, localURLDrawableOptions);
          ((SquareImageView)localObject2).setImageDrawable((Drawable)localObject5);
          if ((((URLDrawable)localObject5).getStatus() != 1) && (((URLDrawable)localObject5).getStatus() != 0)) {
            ((URLDrawable)localObject5).restartDownload();
          }
          ((SquareImageView)localObject2).setVisibility(0);
          if (((aynw)localObject4).jdField_a_of_type_Int == 2)
          {
            ((ImageView)localObject3).setVisibility(0);
            label1379:
            if ((i != m - 1) || (paramayox.jdField_b_of_type_Int <= m)) {
              break label1500;
            }
            ((ImageView)localObject3).setVisibility(8);
            ((SquareImageView)localObject2).setFilterColor(Color.parseColor("#66000000"));
            k = paramayox.jdField_b_of_type_Int - m;
            j = k;
            if (k > 99) {
              j = 99;
            }
            ((SquareImageView)localObject2).setFilterText("+" + j);
            ((SquareImageView)localObject2).setFilterTextSize(bdaq.a(((SquareImageView)localObject2).getContext(), 20.0F));
          }
          for (;;)
          {
            i += 1;
            break;
            ((ImageView)localObject3).setVisibility(8);
            break label1379;
            label1500:
            ((SquareImageView)localObject2).setFilterColor(-1);
            ((SquareImageView)localObject2).setFilterText("");
          }
        }
      }
      while (j < m)
      {
        paramayxe.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(j).setVisibility(4);
        j += 1;
      }
    }
    label1546:
    paramayxe.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(8);
    paramayxe.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
  }
  
  private void a(SquareImageView paramSquareImageView, int paramInt1, int paramInt2, String paramString)
  {
    if ((paramSquareImageView == null) || (TextUtils.isEmpty(paramString))) {
      return;
    }
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mFailedDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
    localURLDrawableOptions.mLoadingDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
    paramSquareImageView.getLayoutParams().width = bdaq.a(paramSquareImageView.getContext(), paramInt1);
    paramSquareImageView.getLayoutParams().height = bdaq.a(paramSquareImageView.getContext(), paramInt2);
    paramSquareImageView.setImageScale(paramInt1 / paramInt2, 0.0F);
    localURLDrawableOptions.mRequestWidth = paramSquareImageView.getLayoutParams().width;
    localURLDrawableOptions.mRequestHeight = paramSquareImageView.getLayoutParams().height;
    paramSquareImageView.setImageDrawable(URLDrawable.getDrawable(paramString, localURLDrawableOptions));
  }
  
  private void a(SquareImageView paramSquareImageView, String paramString)
  {
    if ((paramSquareImageView == null) || (TextUtils.isEmpty(paramString))) {
      return;
    }
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mFailedDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
    localURLDrawableOptions.mLoadingDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
    localURLDrawableOptions.mRequestWidth = paramSquareImageView.getLayoutParams().width;
    localURLDrawableOptions.mRequestHeight = paramSquareImageView.getLayoutParams().height;
    paramSquareImageView.setImageDrawable(URLDrawable.getDrawable(paramString, localURLDrawableOptions));
  }
  
  private void b(ayot paramayot, ayxd paramayxd)
  {
    if ((paramayot == null) || (paramayot.jdField_a_of_type_Ayou == null) || (paramayxd == null)) {
      if ((paramayxd != null) && (paramayxd.jdField_b_of_type_AndroidWidgetButton != null)) {
        paramayxd.jdField_b_of_type_AndroidWidgetButton.setVisibility(8);
      }
    }
    while (paramayxd.jdField_b_of_type_AndroidWidgetButton == null) {
      return;
    }
    Context localContext = paramayxd.jdField_b_of_type_AndroidWidgetButton.getContext();
    if ((paramayot.jdField_a_of_type_Ayou.jdField_a_of_type_Int == 1) && (!TextUtils.isEmpty(paramayot.jdField_a_of_type_Ayou.jdField_a_of_type_JavaLangCharSequence)))
    {
      paramayxd.jdField_b_of_type_AndroidWidgetButton.setVisibility(0);
      paramayxd.jdField_b_of_type_AndroidWidgetButton.setText(paramayot.jdField_a_of_type_Ayou.jdField_a_of_type_JavaLangCharSequence);
      paramayxd.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(new ayrx(this, localContext, paramayot));
      return;
    }
    paramayxd.jdField_b_of_type_AndroidWidgetButton.setVisibility(8);
  }
  
  public void a(Context paramContext, SquareImageView paramSquareImageView, ImageView paramImageView, TextView paramTextView, int paramInt1, String paramString1, String paramString2, int paramInt2)
  {
    switch (paramInt1)
    {
    default: 
      return;
    case 1: 
      a(paramSquareImageView, paramImageView, paramTextView, paramInt2, paramInt2, false, paramString1, null, 0, false);
      return;
    case 2: 
      a(paramSquareImageView, paramImageView, paramTextView, paramInt2, (int)(paramInt2 * 1.4F), false, paramString1, null, 0, false);
      return;
    case 3: 
      a(paramSquareImageView, paramImageView, paramTextView, paramInt2, paramInt2, false, paramString1, null, 2130841976, false);
      return;
    case 4: 
      a(paramSquareImageView, paramImageView, paramTextView, paramInt2, paramInt2, false, paramString1, null, 2130841976, false);
      return;
    case 5: 
      a(paramSquareImageView, paramImageView, paramTextView, paramInt2, paramInt2, false, paramString1, null, 0, true);
      return;
    case 6: 
      paramInt1 = bdaq.a(paramContext, 62.0F);
      a(paramSquareImageView, paramImageView, paramTextView, bdaq.a(paramContext, 100.0F), paramInt1, false, paramString1, null, 2130841976, false);
      return;
    case 7: 
      a(paramSquareImageView, paramImageView, paramTextView, bdaq.a(paramContext, 100.0F), bdaq.a(paramContext, 62.0F), false, paramString1, paramString2, 0, false);
      return;
    }
    a(paramSquareImageView, paramImageView, paramTextView, bdaq.a(paramContext, 100.0F), bdaq.a(paramContext, 62.0F), false, paramString1, null, 0, false);
  }
  
  public void a(ImageView paramImageView)
  {
    if (paramImageView == null) {}
    Animation localAnimation;
    do
    {
      return;
      localAnimation = AnimationUtils.loadAnimation(paramImageView.getContext(), 2130772193);
    } while (localAnimation == null);
    localAnimation.setInterpolator(new LinearInterpolator());
    paramImageView.startAnimation(localAnimation);
  }
  
  public void a(TextView paramTextView, CharSequence paramCharSequence)
  {
    a(paramTextView, paramCharSequence, true);
  }
  
  public void a(TextView paramTextView, CharSequence paramCharSequence, boolean paramBoolean)
  {
    if (!paramBoolean) {
      paramTextView.setEllipsize(null);
    }
    if (!TextUtils.isEmpty(paramCharSequence))
    {
      paramTextView.setText(paramCharSequence);
      if (paramTextView.getVisibility() != 0) {
        paramTextView.setVisibility(0);
      }
    }
    while (paramTextView.getVisibility() == 8) {
      return;
    }
    paramTextView.setVisibility(8);
  }
  
  public void a(ayod paramayod, aywk paramaywk)
  {
    ayvp.a(paramayod.a(), paramayod.b(), paramaywk.a(), paramayod.jdField_a_of_type_Boolean, paramayod.r, paramayod.f);
    switch (paramayod.d())
    {
    }
    for (;;)
    {
      b(paramayod, paramaywk);
      if (TextUtils.isEmpty(paramayod.i)) {
        c(paramayod, paramaywk);
      }
      return;
      a((ayob)paramayod, (aywi)paramaywk);
      continue;
      a((ayox)paramayod, (ayxe)paramaywk);
      continue;
      a((ayoc)paramayod, (aywj)paramaywk);
      continue;
      a((ayok)paramayod, (aywq)paramaywk);
      continue;
      a((ayot)paramayod, (ayxd)paramaywk);
      continue;
      a((ayoq)paramayod, (ayxb)paramaywk);
      continue;
      a((ayor)paramayod, (ayxa)paramaywk);
      continue;
      a((ayoh)paramayod, (aywn)paramaywk);
      continue;
      a((ayof)paramayod, (aywl)paramaywk);
      continue;
      a((ayoi)paramayod, (aywo)paramaywk);
      continue;
      a((ayos)paramayod, (ayxc)paramaywk);
      continue;
      a((ayop)paramayod, (aywy)paramaywk);
      continue;
      a((ayon)paramayod, (aywt)paramaywk);
      continue;
      a((ayoo)paramayod, (aywv)paramaywk);
      continue;
      a((ayom)paramayod, (ayws)paramaywk);
    }
  }
  
  public void a(ayod paramayod, aywk paramaywk, Bitmap paramBitmap)
  {
    if (paramaywk.b() != null) {
      paramaywk.b().setImageBitmap(paramBitmap);
    }
  }
  
  protected void a(ayoi paramayoi, aywo paramaywo)
  {
    if ((paramayoi.jdField_a_of_type_JavaUtilArrayList == null) || (paramayoi.jdField_a_of_type_JavaUtilArrayList.size() == 0))
    {
      if (QLog.isColorLevel()) {
        QLog.e("Q.uniteSearch.SearchTemplatePresenter", 2, "bindHorSlidingContainerTemplateView, containerItem.horizontalModelItems is empty");
      }
      return;
    }
    ayjr localayjr2 = (ayjr)paramaywo.jdField_a_of_type_ComTencentWidgetHorizontalListView.getAdapter();
    ayjr localayjr1;
    if (localayjr2 != null)
    {
      localayjr1 = localayjr2;
      if (localayjr2.a() == paramayoi.jdField_a_of_type_JavaUtilArrayList) {}
    }
    else
    {
      localayjr1 = new ayjr(paramayoi, this.jdField_a_of_type_Ayjq.jdField_b_of_type_Int, paramaywo.jdField_a_of_type_ComTencentWidgetHorizontalListView);
      paramaywo.jdField_a_of_type_ComTencentWidgetHorizontalListView.setAdapter(localayjr1);
    }
    if (localayjr1.a() != paramayoi.jdField_a_of_type_JavaUtilArrayList)
    {
      paramaywo.jdField_a_of_type_Ayoi = paramayoi;
      paramaywo.jdField_a_of_type_ComTencentWidgetHorizontalListView.resetCurrentX(paramayoi.jdField_b_of_type_Int);
    }
    localayjr1.a(paramayoi.jdField_a_of_type_JavaUtilArrayList);
  }
  
  protected void a(ayok paramayok, aywq paramaywq)
  {
    paramaywq.a().getContext();
    paramaywq.a();
    if ((paramayok.jdField_a_of_type_JavaUtilArrayList == null) || (paramayok.jdField_a_of_type_JavaUtilArrayList.size() == 0)) {
      if (QLog.isColorLevel()) {
        QLog.e("Q.uniteSearch.SearchTemplatePresenter", 2, "bindHorizontalContainerTemplateView, containerItem.horizontalModelItems is empty");
      }
    }
    for (;;)
    {
      return;
      paramaywq.a(paramayok);
      if (paramayok.jdField_a_of_type_JavaUtilArrayList.size() != paramaywq.jdField_a_of_type_JavaUtilArrayList.size()) {
        QLog.e("Q.uniteSearch.SearchTemplatePresenter", 2, "bindHorizontalContainerTemplateView, view.size != model.size");
      }
      int j = paramayok.jdField_a_of_type_JavaUtilArrayList.size();
      int i = 0;
      while (i < j)
      {
        ((ayoj)paramayok.jdField_a_of_type_JavaUtilArrayList.get(i)).a((aywp)paramaywq.jdField_a_of_type_JavaUtilArrayList.get(i));
        i += 1;
      }
    }
  }
  
  protected void a(ayom paramayom, ayws paramayws)
  {
    Object localObject2 = (LinearLayout)paramayws.b();
    Object localObject1;
    Object localObject3;
    aywg localaywg;
    if ((localObject2 != null) && (paramayom.a != null))
    {
      ((LinearLayout)localObject2).removeAllViews();
      if (((LinearLayout)localObject2).getParent() != null) {
        ((View)((LinearLayout)localObject2).getParent()).setPadding(0, 0, 0, 0);
      }
      localObject1 = paramayom.a;
      paramayom = paramayws.a().getContext();
      localObject3 = LayoutInflater.from(paramayom).inflate(2131562611, null);
      localaywg = new aywg((View)localObject3);
      Object localObject4 = ((View)localObject3).findViewById(2131368483);
      int i = bdoo.a(6.0F);
      ((View)localObject4).setPadding(0, i, 0, i);
      ((LinearLayout)localObject2).addView((View)localObject3);
      if (((aynz)localObject1).c() != null) {
        break label559;
      }
      if (localaywg.c() != null) {
        localaywg.c().setVisibility(8);
      }
      if (localaywg.a() != null) {
        localaywg.a().setVisibility(8);
      }
      localObject2 = localaywg.a();
      if (localObject2 != null) {
        ((URLImageView)localObject2).setVisibility(8);
      }
      localObject2 = localaywg.e();
      if (localObject2 != null)
      {
        ((TextView)localObject2).setVisibility(0);
        if (!TextUtils.isEmpty(((aynz)localObject1).a())) {
          ((TextView)localObject2).setText(((aynz)localObject1).a());
        }
      }
      if ((localaywg.b() != null) && (!TextUtils.isEmpty(((aynz)localObject1).g())))
      {
        localObject2 = ((aynz)localObject1).g();
        localObject3 = new ColorDrawable(Color.parseColor("#e7e7e7"));
        localObject4 = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject4).mRequestWidth = bdaq.a(paramayom, 50.0F);
        ((URLDrawable.URLDrawableOptions)localObject4).mRequestHeight = bdaq.a(paramayom, 50.0F);
        ((URLDrawable.URLDrawableOptions)localObject4).mFailedDrawable = ((Drawable)localObject3);
        ((URLDrawable.URLDrawableOptions)localObject4).mLoadingDrawable = ((Drawable)localObject3);
        if (!bhsz.a((String)localObject2)) {
          break label684;
        }
        localObject2 = URLDrawable.getDrawable((String)localObject2, (URLDrawable.URLDrawableOptions)localObject4);
        ((URLDrawable)localObject2).setTag(bcyz.b(bdaq.a(paramayom, 50.0F), bdaq.a(paramayws.a().getContext(), 50.0F), bdaq.a(paramayom, 3.0F)));
        ((URLDrawable)localObject2).setDecodeHandler(bcyz.i);
        localaywg.b().setImageDrawable((Drawable)localObject2);
        if ((((URLDrawable)localObject2).getStatus() != 1) && (((URLDrawable)localObject2).getStatus() != 0)) {
          ((URLDrawable)localObject2).restartDownload();
        }
      }
    }
    for (;;)
    {
      localaywg.a().setOnClickListener(new ayrq(this, (aynz)localObject1));
      if ((localaywg.a() != null) && (((aynz)localObject1).c()))
      {
        paramayws = ((aynz)localObject1).h();
        localObject1 = new ColorDrawable(Color.parseColor("#e7e7e7"));
        localObject2 = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject2).mRequestWidth = bdaq.a(paramayom, 40.0F);
        ((URLDrawable.URLDrawableOptions)localObject2).mRequestHeight = bdaq.a(paramayom, 12.0F);
        ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = ((Drawable)localObject1);
        ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = ((Drawable)localObject1);
        paramayws = URLDrawable.getDrawable(paramayws, (URLDrawable.URLDrawableOptions)localObject2);
        paramayws.setTag(bcyz.b(bdaq.a(paramayom, 38.0F), bdaq.a(paramayom, 12.0F), 0));
        paramayws.setDecodeHandler(bcyz.i);
        localaywg.a().setImageDrawable(paramayws);
        if ((paramayws.getStatus() != 1) && (paramayws.getStatus() != 0)) {
          paramayws.restartDownload();
        }
      }
      return;
      label559:
      if ((localaywg.c() != null) && (!TextUtils.isEmpty(((aynz)localObject1).c())))
      {
        localaywg.c().setVisibility(0);
        localaywg.c().setText(((aynz)localObject1).c());
      }
      for (;;)
      {
        if (localaywg.a() != null) {
          localaywg.a().setVisibility(0);
        }
        localObject2 = localaywg.e();
        if (localObject2 != null) {
          ((TextView)localObject2).setVisibility(8);
        }
        if (TextUtils.isEmpty(((aynz)localObject1).a())) {
          break;
        }
        localaywg.a().setText(((aynz)localObject1).a());
        break;
        if (localaywg.c() != null) {
          localaywg.c().setVisibility(8);
        }
      }
      label684:
      localaywg.b().setImageDrawable((Drawable)localObject3);
    }
  }
  
  protected void a(ayop paramayop, aywy paramaywy)
  {
    Object localObject1 = paramaywy.a().getContext();
    if (ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null))
    {
      paramaywy.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#737373"));
      paramaywy.jdField_b_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#4A4A4A"));
      if (TextUtils.isEmpty(paramayop.jdField_b_of_type_JavaLangString)) {
        break label290;
      }
      Object localObject2 = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
      ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
      ((URLDrawable.URLDrawableOptions)localObject2).mRequestWidth = bdaq.a((Context)localObject1, 18.0F);
      ((URLDrawable.URLDrawableOptions)localObject2).mRequestHeight = bdaq.a((Context)localObject1, 18.0F);
      ((URLDrawable.URLDrawableOptions)localObject2).mMemoryCacheKeySuffix = "askIcon";
      localObject2 = URLDrawable.getDrawable(paramayop.jdField_b_of_type_JavaLangString, (URLDrawable.URLDrawableOptions)localObject2);
      paramaywy.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable((Drawable)localObject2);
      if ((((URLDrawable)localObject2).getStatus() != 1) && (((URLDrawable)localObject2).getStatus() != 0)) {
        ((URLDrawable)localObject2).restartDownload();
      }
      paramaywy.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(0);
    }
    label290:
    for (;;)
    {
      label166:
      if (!TextUtils.isEmpty(paramayop.j))
      {
        int j = paramaywy.jdField_a_of_type_AndroidWidgetTextView.getContext().getResources().getDisplayMetrics().widthPixels;
        int i = (int)ayvm.a(paramaywy.jdField_a_of_type_AndroidWidgetTextView, " ");
        int k = bdaq.a((Context)localObject1, 22.0F) / i;
        localObject1 = "";
        i = 0;
        for (;;)
        {
          if (i < k)
          {
            localObject1 = (String)localObject1 + " ";
            i += 1;
            continue;
            paramaywy.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#262626"));
            paramaywy.jdField_b_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#737373"));
            break;
            paramaywy.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(8);
            break label166;
          }
        }
        localObject1 = ayvm.a(paramaywy.jdField_a_of_type_AndroidWidgetTextView, j, 2, (String)localObject1 + paramayop.j, paramayop.jdField_a_of_type_Ayvb.jdField_a_of_type_JavaUtilList, false, false, true);
        paramaywy.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject1);
      }
    }
    paramaywy.a(paramayop);
    if ((!TextUtils.isEmpty(paramayop.k)) && (paramayop.jdField_a_of_type_JavaUtilList != null) && (paramayop.jdField_a_of_type_JavaUtilList.size() != 0))
    {
      paramaywy.jdField_b_of_type_AndroidWidgetTextView.setText(paramayop.k);
      paramaywy.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      return;
    }
    paramaywy.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
  }
  
  protected void a(ayos paramayos, ayxc paramayxc)
  {
    if (!TextUtils.isEmpty(paramayos.jdField_b_of_type_JavaLangString))
    {
      paramayxc.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(0);
      Object localObject = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
      ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
      ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = paramayxc.jdField_a_of_type_ComTencentImageURLImageView.getLayoutParams().width;
      ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = paramayxc.jdField_a_of_type_ComTencentImageURLImageView.getLayoutParams().height;
      localObject = URLDrawable.getDrawable(paramayos.jdField_b_of_type_JavaLangString, (URLDrawable.URLDrawableOptions)localObject);
      paramayxc.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable((Drawable)localObject);
      if ((((URLDrawable)localObject).getStatus() != 1) && (((URLDrawable)localObject).getStatus() != 0)) {
        ((URLDrawable)localObject).restartDownload();
      }
      if (TextUtils.isEmpty(paramayos.j)) {
        break label345;
      }
      paramayxc.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      int i = paramayxc.jdField_a_of_type_AndroidWidgetTextView.getContext().getResources().getDisplayMetrics().widthPixels;
      localObject = ayvm.a(paramayxc.jdField_a_of_type_AndroidWidgetTextView, i, 1, paramayos.j, paramayos.jdField_a_of_type_Ayvb.jdField_a_of_type_JavaUtilList, false, false, true);
      paramayxc.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
      label183:
      if (TextUtils.isEmpty(paramayos.l)) {
        break label357;
      }
      paramayxc.jdField_b_of_type_AndroidWidgetTextView.setText(paramayos.l);
      paramayxc.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      paramayxc.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      label220:
      if (TextUtils.isEmpty(paramayos.k)) {
        break label378;
      }
      paramayxc.c.setText(paramayos.k);
      paramayxc.c.setVisibility(0);
    }
    for (;;)
    {
      if (!ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null)) {
        break label390;
      }
      paramayxc.jdField_a_of_type_AndroidWidgetTextView.setTextColor(paramayxc.jdField_a_of_type_AndroidWidgetTextView.getContext().getResources().getColor(2131166841));
      paramayxc.c.setTextColor(paramayxc.c.getContext().getResources().getColor(2131166840));
      paramayxc.jdField_b_of_type_AndroidWidgetTextView.setTextColor(paramayxc.jdField_b_of_type_AndroidWidgetTextView.getContext().getResources().getColor(2131166840));
      return;
      paramayxc.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(8);
      break;
      label345:
      paramayxc.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      break label183;
      label357:
      paramayxc.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      paramayxc.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      break label220;
      label378:
      paramayxc.c.setVisibility(8);
    }
    label390:
    paramayxc.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#262626"));
    paramayxc.c.setTextColor(Color.parseColor("#737373"));
    paramayxc.jdField_b_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#737373"));
  }
  
  public void a(SquareImageView paramSquareImageView, ImageView paramImageView, TextView paramTextView, int paramInt1, int paramInt2, boolean paramBoolean1, String paramString1, String paramString2, int paramInt3, boolean paramBoolean2)
  {
    ViewGroup.LayoutParams localLayoutParams = paramSquareImageView.getLayoutParams();
    if ((paramSquareImageView.getContext() instanceof PublicAcntSearchActivity))
    {
      localLayoutParams.width = bdaq.a(paramSquareImageView.getContext(), 50.0F);
      localLayoutParams.height = bdaq.a(paramSquareImageView.getContext(), 50.0F);
      paramSquareImageView.setLayoutParams(localLayoutParams);
      if (paramInt2 == 0) {
        break label273;
      }
      paramSquareImageView.setImageScale(paramInt1 * 1.0F / paramInt2, 0.0F);
      label71:
      if (!paramBoolean1) {
        break label282;
      }
      paramSquareImageView.setFilterColor(Color.parseColor("#66000000"));
      label86:
      if (paramInt3 == 0) {
        break label290;
      }
      paramImageView.setImageResource(paramInt3);
      paramImageView.setVisibility(0);
      label102:
      if ((paramString2 == null) || (TextUtils.isEmpty(paramString2))) {
        break label299;
      }
      paramTextView.setVisibility(0);
      paramTextView.setText(paramString2);
      label126:
      paramImageView = this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
      this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable.setBounds(0, 0, paramInt1, paramInt2);
      paramString2 = paramImageView;
    }
    for (;;)
    {
      label273:
      label282:
      label290:
      label299:
      try
      {
        if (!TextUtils.isEmpty(paramString1))
        {
          paramTextView = URLDrawable.URLDrawableOptions.obtain();
          paramTextView.mRequestWidth = paramInt1;
          paramTextView.mRequestHeight = paramInt2;
          paramTextView.mFailedDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
          paramTextView.mLoadingDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
          if (!paramBoolean2) {
            continue;
          }
          paramTextView.mMemoryCacheKeySuffix = "isAvatar";
          paramTextView = URLDrawable.getDrawable(paramString1, paramTextView);
          paramTextView.setDecodeHandler(bcyz.a);
          paramString2 = paramTextView;
          paramImageView = paramTextView;
          paramTextView = paramString2;
          paramString2 = paramTextView;
        }
      }
      catch (Exception paramTextView) {}
      try
      {
        if (paramTextView.getStatus() != 1)
        {
          paramString2 = paramTextView;
          if (paramTextView.getStatus() != 0)
          {
            paramTextView.restartDownload();
            paramString2 = paramTextView;
          }
        }
        paramSquareImageView.setImageDrawable(paramString2);
        return;
      }
      catch (Exception paramTextView)
      {
        break label326;
      }
      localLayoutParams.width = paramInt1;
      localLayoutParams.height = paramInt2;
      break;
      paramSquareImageView.setImageScale(1.0F, 0.0F);
      break label71;
      paramSquareImageView.setFilterColor(-1);
      break label86;
      paramImageView.setVisibility(8);
      break label102;
      paramTextView.setVisibility(8);
      break label126;
      paramTextView.mMemoryCacheKeySuffix = "isNotAvatar";
      paramTextView = URLDrawable.getDrawable(paramString1, paramTextView);
      continue;
      label326:
      QLog.e("Q.uniteSearch.SearchTemplatePresenter", 1, "imageUrl is not valid. imageUrl=" + paramString1, paramTextView);
      paramString2 = paramImageView;
    }
  }
  
  protected void b(ayod paramayod, aywk paramaywk)
  {
    if (paramaywk.a() != null) {
      paramaywk.a().setOnClickListener(new ayrp(this, paramayod));
    }
  }
  
  public void c(ayod paramayod, aywk paramaywk)
  {
    if ((paramaywk.b() != null) && ((paramayod instanceof aynr)) && (!TextUtils.isEmpty(paramayod.b()))) {
      paramaywk.b().setImageDrawable(ayvm.a(this.jdField_a_of_type_Bdbb, paramayod));
    }
  }
  
  public String getToken()
  {
    return QQPlayerService.a(7, ((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).c());
  }
  
  public void onPlaySongChanged(SongInfo paramSongInfo) {}
  
  public void onPlayStateChanged(int paramInt)
  {
    if ((this.jdField_a_of_type_JavaLangRefWeakReference == null) || (this.jdField_a_of_type_JavaLangRefWeakReference.get() == null)) {}
    ImageView localImageView;
    do
    {
      return;
      localImageView = (ImageView)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    } while (localImageView == null);
    boolean bool = ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null);
    Resources localResources = localImageView.getContext().getResources();
    if (paramInt == 1)
    {
      localImageView.post(new SearchTemplatePresenter.10(this, bool, localImageView));
      return;
    }
    if (paramInt == 2)
    {
      localImageView.getContext();
      ((Integer)localImageView.getTag()).intValue();
      ayvm.jdField_a_of_type_Long = this.jdField_a_of_type_Long;
      localImageView.post(new SearchTemplatePresenter.11(this, localImageView, bool));
      localImageView.setContentDescription(localResources.getString(2131690326));
      this.jdField_a_of_type_Ayjq.notifyDataSetChanged();
      return;
    }
    localImageView.post(new SearchTemplatePresenter.12(this, localImageView, bool));
    localImageView.setContentDescription(localResources.getString(2131690324));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayro
 * JD-Core Version:    0.7.0.1
 */