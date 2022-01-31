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

public class awsa
  implements asvu, awra<awop, awww>
{
  public static int a;
  private long jdField_a_of_type_Long;
  public ColorDrawable a;
  public Drawable a;
  private awkf jdField_a_of_type_Awkf;
  private baxk jdField_a_of_type_Baxk;
  private WeakReference<ImageView> jdField_a_of_type_JavaLangRefWeakReference;
  
  public awsa(baxk parambaxk, awkf paramawkf)
  {
    this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable = new ColorDrawable(Color.parseColor("#e7e7e7"));
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = aywk.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
    this.jdField_a_of_type_Baxk = parambaxk;
    this.jdField_a_of_type_Awkf = paramawkf;
  }
  
  private float a(String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      return 7.0F;
    }
    return 3.5F;
  }
  
  private int a(awpf paramawpf, awxp paramawxp)
  {
    if ((paramawpf == null) || (paramawpf.jdField_a_of_type_Awpg == null) || (paramawxp == null) || (paramawxp.jdField_a_of_type_AndroidWidgetRelativeLayout == null))
    {
      if ((paramawxp != null) && (paramawxp.jdField_a_of_type_AndroidWidgetButton != null)) {
        paramawxp.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
      }
      if ((paramawxp != null) && (paramawxp.jdField_a_of_type_AndroidWidgetImageView != null)) {
        paramawxp.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      }
      return 0;
    }
    if (paramawpf.jdField_a_of_type_Awpg.jdField_a_of_type_Int == 1)
    {
      if (paramawxp.jdField_a_of_type_AndroidWidgetButton != null) {
        paramawxp.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
      }
      if (paramawxp.jdField_a_of_type_AndroidWidgetImageView != null) {
        paramawxp.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      }
      return 0;
    }
    boolean bool = ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null);
    Context localContext = paramawxp.jdField_a_of_type_AndroidWidgetRelativeLayout.getContext();
    int i;
    if (paramawpf.jdField_a_of_type_Awpg.jdField_a_of_type_Int == 2)
    {
      if (paramawxp.jdField_a_of_type_AndroidWidgetImageView != null) {
        paramawxp.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      }
      if (paramawxp.jdField_a_of_type_AndroidWidgetButton == null) {
        return 0;
      }
      if (!TextUtils.isEmpty(paramawpf.jdField_a_of_type_Awpg.jdField_a_of_type_JavaLangCharSequence))
      {
        paramawxp.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
        paramawxp.jdField_a_of_type_AndroidWidgetButton.setText(paramawpf.jdField_a_of_type_Awpg.jdField_a_of_type_JavaLangCharSequence);
        paramawxp.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(new awsh(this, localContext, paramawpf));
      }
      for (;;)
      {
        i = (int)(0 + (awvy.a(paramawxp.jdField_a_of_type_AndroidWidgetButton, paramawpf.jdField_a_of_type_Awpg.jdField_a_of_type_JavaLangCharSequence) + bawz.a(localContext, 32.0F) + bawz.a(localContext, 15.0F)));
        if (!bool) {
          break;
        }
        paramawxp.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130842695);
        paramawxp.jdField_a_of_type_AndroidWidgetButton.setTextColor(Color.parseColor("#6991B8"));
        return i;
        paramawxp.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
      }
      paramawxp.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130842694);
      paramawxp.jdField_a_of_type_AndroidWidgetButton.setTextColor(Color.parseColor("#000000"));
      return i;
    }
    int j;
    if (paramawpf.jdField_a_of_type_Awpg.jdField_a_of_type_Int == 3)
    {
      if (paramawxp.jdField_a_of_type_AndroidWidgetButton != null) {
        paramawxp.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
      }
      if ((paramawxp.jdField_a_of_type_AndroidWidgetRelativeLayout == null) || (paramawxp.jdField_a_of_type_AndroidWidgetImageView == null)) {
        return 0;
      }
      int k = ((Integer)paramawxp.a().getTag(2131379209)).intValue();
      SongInfo localSongInfo1 = new SongInfo();
      i = 0;
      j = i;
      for (;;)
      {
        try
        {
          JSONObject localJSONObject = new JSONObject(paramawpf.h);
          j = i;
          localSongInfo1.jdField_a_of_type_JavaLangString = localJSONObject.optString("audio_url");
          j = i;
          localSongInfo1.jdField_b_of_type_JavaLangString = localJSONObject.optString("title");
          j = i;
          localSongInfo1.jdField_c_of_type_JavaLangString = localJSONObject.optString("desc");
          j = i;
          localSongInfo1.d = localJSONObject.optString("image_url");
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
          awvy.jdField_a_of_type_Long = localSongInfo2.jdField_a_of_type_Long;
          continue;
          paramawxp.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130848577);
          continue;
          if (this.jdField_a_of_type_Long != awvy.jdField_a_of_type_Long) {
            continue;
          }
          paramawxp.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130848578);
          continue;
          paramawxp.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130848576);
          continue;
          paramawxp.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
          continue;
        }
        this.jdField_a_of_type_Long = localSongInfo1.jdField_a_of_type_Long;
        QQPlayerService.a(this);
        if (QQPlayerService.a() == 2) {
          continue;
        }
        awvy.jdField_a_of_type_Long = -1L;
        if (!bool) {
          continue;
        }
        if (this.jdField_a_of_type_Long != awvy.jdField_a_of_type_Long) {
          continue;
        }
        paramawxp.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130848579);
        if ((j == 0) || (i == 0) || (TextUtils.isEmpty(localSongInfo1.jdField_a_of_type_JavaLangString))) {
          continue;
        }
        paramawxp.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        paramawxp.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(new awsi(this, paramawxp, k, localContext, bool, localSongInfo1, paramawpf));
        return bawz.a(localContext, 39.0F) + 0;
        i = 0;
        continue;
        j = 0;
      }
    }
    paramawxp.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
    return 0;
  }
  
  private int a(awpf paramawpf, awxp paramawxp, int paramInt1, int paramInt2)
  {
    if ((paramawxp == null) || (paramawpf == null) || (paramawxp.jdField_a_of_type_AndroidWidgetLinearLayout == null)) {
      return 0;
    }
    Context localContext = paramawxp.jdField_a_of_type_AndroidWidgetLinearLayout.getContext();
    int i = localContext.getResources().getDisplayMetrics().widthPixels - paramInt1 - paramInt2 - bawz.a(localContext, 30.0F);
    if ((paramawpf.jdField_a_of_type_JavaUtilArrayList != null) && (paramawpf.jdField_a_of_type_JavaUtilArrayList.size() > 0))
    {
      paramawxp.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      if ((paramawpf.jdField_a_of_type_Awph != null) && (paramawpf.jdField_a_of_type_JavaUtilArrayList != null) && (paramawpf.jdField_a_of_type_JavaUtilArrayList.size() > 0))
      {
        paramawxp.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(0);
        if (paramawxp.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView != null) {
          paramawxp.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView.setVisibility(8);
        }
        if (paramawpf.jdField_a_of_type_Awph.jdField_a_of_type_Int == 1)
        {
          if (paramawxp.jdField_b_of_type_AndroidWidgetTextView != null) {
            paramawxp.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
          }
          if ((paramawxp.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView == null) || (TextUtils.isEmpty(paramawpf.jdField_a_of_type_Awph.jdField_a_of_type_JavaLangString))) {
            break label1007;
          }
          paramawxp.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView.setVisibility(0);
          a(paramawxp.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView, paramawpf.jdField_a_of_type_Awph.jdField_a_of_type_JavaLangString);
          paramInt1 = i - bawz.a(localContext, 24.0F);
        }
      }
    }
    for (;;)
    {
      Object localObject1;
      if ((paramawxp.jdField_a_of_type_AndroidWidgetTextView != null) && (!TextUtils.isEmpty(((awpi)paramawpf.jdField_a_of_type_JavaUtilArrayList.get(0)).jdField_a_of_type_JavaLangCharSequence)))
      {
        localObject1 = ((awpi)paramawpf.jdField_a_of_type_JavaUtilArrayList.get(0)).jdField_a_of_type_JavaLangCharSequence;
        if (!((awpi)paramawpf.jdField_a_of_type_JavaUtilArrayList.get(0)).jdField_a_of_type_Boolean) {
          break label635;
        }
        localObject1 = awvy.a(paramawxp.jdField_a_of_type_AndroidWidgetTextView, paramInt1, 1, ((CharSequence)localObject1).toString(), paramawpf.jdField_a_of_type_Awvn.jdField_a_of_type_JavaUtilList, false, false, true);
        label297:
        paramawxp.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject1);
      }
      for (paramInt1 = 1;; paramInt1 = 0)
      {
        if (paramawxp.c != null) {
          break label677;
        }
        return paramawxp.jdField_a_of_type_AndroidWidgetLinearLayout.getHeight();
        if (paramawpf.jdField_a_of_type_Awph.jdField_a_of_type_Int == 2)
        {
          if (paramawxp.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView != null) {
            paramawxp.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView.setVisibility(8);
          }
          if ((paramawxp.jdField_b_of_type_AndroidWidgetTextView == null) || (TextUtils.isEmpty(paramawpf.jdField_a_of_type_Awph.jdField_a_of_type_JavaLangCharSequence))) {
            break label1007;
          }
          if (awvy.d(paramawpf.jdField_a_of_type_Awph.jdField_b_of_type_JavaLangString)) {}
          for (localObject1 = paramawpf.jdField_a_of_type_Awph.jdField_b_of_type_JavaLangString;; localObject1 = "#fd7f32")
          {
            ((GradientDrawable)paramawxp.jdField_b_of_type_AndroidWidgetTextView.getBackground()).setColor(Color.parseColor((String)localObject1));
            paramawxp.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
            paramawxp.jdField_b_of_type_AndroidWidgetTextView.setText(paramawpf.jdField_a_of_type_Awph.jdField_a_of_type_JavaLangCharSequence);
            paramInt1 = (int)(i - (awvy.a(paramawxp.jdField_b_of_type_AndroidWidgetTextView, paramawpf.jdField_a_of_type_Awph.jdField_a_of_type_JavaLangCharSequence) + bawz.a(localContext, 10.0F)));
            break;
          }
        }
        if (paramawpf.jdField_a_of_type_Awph.jdField_a_of_type_Int != 3) {
          break label1007;
        }
        if (paramawxp.jdField_b_of_type_AndroidWidgetTextView != null) {
          paramawxp.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
        }
        if ((paramawxp.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView == null) || (TextUtils.isEmpty(paramawpf.jdField_a_of_type_Awph.jdField_a_of_type_JavaLangString))) {
          break label1007;
        }
        paramawxp.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView.setVisibility(0);
        if ((paramawpf.jdField_a_of_type_Awph.jdField_b_of_type_Int > 0) && (paramawpf.jdField_a_of_type_Awph.jdField_c_of_type_Int > 0))
        {
          a(paramawxp.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView, paramawpf.jdField_a_of_type_Awph.jdField_b_of_type_Int, paramawpf.jdField_a_of_type_Awph.jdField_c_of_type_Int, paramawpf.jdField_a_of_type_Awph.jdField_a_of_type_JavaLangString);
          paramInt1 = i - bawz.a(localContext, bawz.a(localContext, paramawpf.jdField_a_of_type_Awph.jdField_b_of_type_Int) + 4);
          break;
        }
        a(paramawxp.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView, paramawpf.jdField_a_of_type_Awph.jdField_a_of_type_JavaLangString);
        paramInt1 = i - bawz.a(localContext, 24.0F);
        break;
        label635:
        localObject1 = awvy.a(paramawxp.jdField_a_of_type_AndroidWidgetTextView, paramInt1, ((CharSequence)localObject1).toString());
        break label297;
        if (paramawxp.jdField_b_of_type_AndroidWidgetLinearLayout != null) {
          paramawxp.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
        }
      }
      label677:
      paramawxp.c.removeAllViews();
      awpi localawpi;
      TextView localTextView;
      if ((paramawpf.jdField_a_of_type_JavaUtilArrayList != null) && (paramawpf.jdField_a_of_type_JavaUtilArrayList.size() > 0)) {
        while (paramInt1 < paramawpf.jdField_a_of_type_JavaUtilArrayList.size())
        {
          localawpi = (awpi)paramawpf.jdField_a_of_type_JavaUtilArrayList.get(paramInt1);
          localTextView = new TextView(localContext);
          a(localTextView, localawpi.jdField_a_of_type_JavaLangString, localawpi.jdField_a_of_type_Int);
          localObject1 = localawpi.jdField_a_of_type_JavaLangCharSequence;
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
        paramInt2 = localawpi.jdField_a_of_type_Int;
        if ((localContext instanceof PublicAcntSearchActivity)) {
          paramInt2 = 1;
        }
        Object localObject2 = localObject1;
        if (localawpi.jdField_a_of_type_Boolean) {
          if ((!localawpi.jdField_a_of_type_JavaLangString.equals("A")) && (!localawpi.jdField_a_of_type_JavaLangString.equals("B"))) {
            break label952;
          }
        }
        for (boolean bool = true;; bool = false)
        {
          localObject2 = awvy.a(localTextView, i, paramInt2, ((CharSequence)localObject1).toString(), paramawpf.jdField_a_of_type_Awvn.jdField_a_of_type_JavaUtilList, false, bool, true);
          if (paramInt1 != 0) {
            localTextView.setPadding(0, bawz.a(localContext, 7.0F - a(((awpi)paramawpf.jdField_a_of_type_JavaUtilArrayList.get(paramInt1 - 1)).jdField_a_of_type_JavaLangString, localawpi.jdField_a_of_type_JavaLangString)), 0, 0);
          }
          localTextView.setText((CharSequence)localObject2);
          paramawxp.c.addView(localTextView);
          break;
        }
        paramawxp.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
        b(paramawpf, paramawxp);
        paramInt1 = View.MeasureSpec.makeMeasureSpec(0, 0);
        paramInt2 = View.MeasureSpec.makeMeasureSpec(0, 0);
        paramawxp.jdField_a_of_type_AndroidWidgetLinearLayout.measure(paramInt1, paramInt2);
        return paramawxp.jdField_a_of_type_AndroidWidgetLinearLayout.getMeasuredHeight();
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
      if (!awvy.d(paramString)) {
        localObject = "#F1F1F1";
      }
    }
  }
  
  public static Pair<Integer, Integer> a(awop paramawop, awww paramawww, boolean paramBoolean, int paramInt)
  {
    if ((paramawww == null) || (paramawww.jdField_b_of_type_AndroidWidgetRelativeLayout == null) || (paramawww.jdField_b_of_type_ComTencentMobileqqWidgetSquareImageView == null) || (paramawop == null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.uniteSearch.SearchTemplatePresenter", 2, "bindUniversalTemplateLeftImageview or item is null");
      }
      return new Pair(Integer.valueOf(0), Integer.valueOf(0));
    }
    SquareImageView localSquareImageView = paramawww.jdField_b_of_type_ComTencentMobileqqWidgetSquareImageView;
    awoq localawoq = paramawop.jdField_a_of_type_Awoq;
    if ((localawoq == null) || (TextUtils.isEmpty(localawoq.jdField_a_of_type_JavaLangString)))
    {
      paramawww.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      return new Pair(Integer.valueOf(0), Integer.valueOf(0));
    }
    paramawww.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
    Object localObject = localSquareImageView.getContext();
    paramawop = a(localSquareImageView, localawoq.jdField_a_of_type_Int, localawoq.jdField_a_of_type_JavaLangString, localawoq.jdField_b_of_type_Int, paramBoolean, paramInt, paramawop);
    paramInt = ((Integer)paramawop.first).intValue();
    int i = ((Integer)paramawop.second).intValue();
    paramawop = localSquareImageView.getLayoutParams();
    paramawop.width = paramInt;
    paramawop.height = i;
    localSquareImageView.setLayoutParams(paramawop);
    paramawop = (RelativeLayout.LayoutParams)paramawww.jdField_b_of_type_AndroidWidgetRelativeLayout.getLayoutParams();
    paramawop.width = paramInt;
    paramawop.height = i;
    paramawww.jdField_b_of_type_AndroidWidgetRelativeLayout.setLayoutParams(paramawop);
    int j = bawz.a((Context)localObject, 10.0F);
    if ((!TextUtils.isEmpty(localawoq.jdField_a_of_type_JavaLangCharSequence)) && (paramawww.e != null)) {
      if (awvy.d(localawoq.jdField_b_of_type_JavaLangString))
      {
        paramawop = localawoq.jdField_b_of_type_JavaLangString;
        ((GradientDrawable)paramawww.e.getBackground()).setColor(Color.parseColor(paramawop));
        paramawww.e.setVisibility(0);
        paramawww.e.setText(localawoq.jdField_a_of_type_JavaLangCharSequence);
        label303:
        if (paramawww.jdField_c_of_type_AndroidWidgetImageView != null)
        {
          if (!localawoq.jdField_a_of_type_Boolean) {
            break label565;
          }
          paramawww.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
        }
        label326:
        if (paramawww.f != null)
        {
          if (TextUtils.isEmpty(localawoq.jdField_b_of_type_JavaLangCharSequence)) {
            break label577;
          }
          paramawww.f.setVisibility(0);
          paramawww.f.setText(localawoq.jdField_b_of_type_JavaLangCharSequence);
        }
        label364:
        if (paramawww.jdField_c_of_type_ComTencentMobileqqWidgetSquareImageView != null)
        {
          if (TextUtils.isEmpty(localawoq.jdField_c_of_type_JavaLangString)) {
            break label589;
          }
          paramawww.jdField_c_of_type_ComTencentMobileqqWidgetSquareImageView.setVisibility(0);
          paramawop = URLDrawable.URLDrawableOptions.obtain();
          localObject = new ColorDrawable(-1);
          paramawop.mFailedDrawable = ((Drawable)localObject);
          paramawop.mLoadingDrawable = ((Drawable)localObject);
          paramawop.mRequestWidth = paramawww.jdField_c_of_type_ComTencentMobileqqWidgetSquareImageView.getLayoutParams().width;
          paramawop.mRequestHeight = paramawww.jdField_c_of_type_ComTencentMobileqqWidgetSquareImageView.getLayoutParams().height;
          paramawop = URLDrawable.getDrawable(localawoq.jdField_c_of_type_JavaLangString, paramawop);
          if ((paramawop.getStatus() != 1) && (paramawop.getStatus() != 0)) {
            paramawop.restartDownload();
          }
          paramawww.jdField_c_of_type_ComTencentMobileqqWidgetSquareImageView.setImageDrawable(paramawop);
        }
        label481:
        if (paramawww.g != null)
        {
          if (TextUtils.isEmpty(localawoq.jdField_c_of_type_JavaLangCharSequence)) {
            break label601;
          }
          paramawww.g.setVisibility(0);
          paramawww.g.setText(localawoq.jdField_c_of_type_JavaLangCharSequence);
        }
      }
    }
    for (;;)
    {
      return new Pair(Integer.valueOf(paramInt + j), Integer.valueOf(i));
      paramawop = "#fd7f32";
      break;
      if (paramawww.e == null) {
        break label303;
      }
      paramawww.e.setVisibility(8);
      break label303;
      label565:
      paramawww.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
      break label326;
      label577:
      paramawww.f.setVisibility(8);
      break label364;
      label589:
      paramawww.jdField_c_of_type_ComTencentMobileqqWidgetSquareImageView.setVisibility(8);
      break label481;
      label601:
      paramawww.g.setVisibility(8);
    }
  }
  
  public static Pair<Integer, Integer> a(SquareImageView paramSquareImageView, int paramInt1, String paramString, int paramInt2, boolean paramBoolean, int paramInt3, awop paramawop)
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
      paramInt1 = bawz.a((Context)localObject, 60.0F);
      i = bawz.a((Context)localObject, 60.0F);
      j = 0;
      localColorDrawable = new ColorDrawable(Color.parseColor("#e7e7e7"));
      if (paramBoolean)
      {
        paramInt1 = (int)(i * 1.0F / paramInt1 * paramInt3);
        if (j != 0)
        {
          i = (int)(paramInt3 * 0.2D / 2.0D);
          paramSquareImageView.setPadding(bawz.a((Context)localObject, 3.0F), bawz.a((Context)localObject, 3.0F), bawz.a((Context)localObject, 3.0F), bawz.a((Context)localObject, 3.0F));
          paramawop = (RelativeLayout.LayoutParams)paramSquareImageView.getLayoutParams();
          i -= bawz.a((Context)localObject, 3.0F);
          paramawop.rightMargin = i;
          paramawop.leftMargin = i;
          paramawop.topMargin = i;
          paramSquareImageView.setLayoutParams(paramawop);
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
          paramawop = URLDrawable.URLDrawableOptions.obtain();
          paramawop.mRequestWidth = paramInt3;
          paramawop.mRequestHeight = paramInt1;
          if (j == 0) {
            continue;
          }
          localObject = new GradientDrawable();
          ((GradientDrawable)localObject).setShape(0);
          ((GradientDrawable)localObject).setCornerRadius(paramInt3 / 2.0F);
          ((GradientDrawable)localObject).setColor(-1579033);
          paramawop.mLoadingDrawable = ((Drawable)localObject);
          paramawop.mFailedDrawable = ((Drawable)localObject);
          paramawop.mPlayGifImage = true;
          if (j == 0) {
            continue;
          }
          paramawop.mMemoryCacheKeySuffix = ("isAvatar" + paramInt3 + paramInt1);
          paramawop = URLDrawable.getDrawable(paramString, paramawop);
          paramawop.setDecodeHandler(bavi.a);
        }
        catch (Exception paramawop)
        {
          QLog.e("Q.uniteSearch.SearchTemplatePresenter", 1, "imageUrl is not valid. imageUrl=" + paramString, paramawop);
          localObject = localColorDrawable;
          continue;
          paramawop.mMemoryCacheKeySuffix = ("isNotAvatar" + paramInt3 + paramInt1 + paramInt2);
          paramawop = URLDrawable.getDrawable(paramString, paramawop);
          paramawop.setTag(bavi.b(paramInt3, paramInt1, paramInt2));
          paramawop.setDecodeHandler(bavi.i);
          continue;
        }
        localObject = paramawop;
        if (paramawop.getStatus() != 1)
        {
          localObject = paramawop;
          if (paramawop.getStatus() != 0)
          {
            paramawop.restartDownload();
            localObject = paramawop;
          }
        }
        paramSquareImageView.setImageDrawable((Drawable)localObject);
        return new Pair(Integer.valueOf(paramInt3), Integer.valueOf(paramInt1));
        paramInt1 = bawz.a((Context)localObject, 60.0F);
        i = bawz.a((Context)localObject, 60.0F);
        j = 0;
        break;
        paramInt1 = bawz.a((Context)localObject, 50.0F);
        i = bawz.a((Context)localObject, 50.0F);
        j = 0;
        break;
        if ((paramSquareImageView.getContext() instanceof PublicAcntSearchActivity))
        {
          paramInt1 = bawz.a(paramSquareImageView.getContext(), 50.0F);
          i = bawz.a(paramSquareImageView.getContext(), 50.0F);
          j = 1;
          break;
        }
        paramInt1 = bawz.a((Context)localObject, 60.0F);
        i = bawz.a((Context)localObject, 60.0F);
        continue;
        paramInt1 = bawz.a((Context)localObject, 50.0F);
        i = bawz.a((Context)localObject, 50.0F);
        j = 1;
        break;
        paramInt1 = bawz.a((Context)localObject, 60.0F);
        i = bawz.a((Context)localObject, 85.0F);
        j = 0;
        break;
        paramInt1 = bawz.a((Context)localObject, 113.0F);
        i = bawz.a((Context)localObject, 60.0F);
        j = 0;
        break;
        paramInt1 = bawz.a((Context)localObject, 100.0F);
        i = bawz.a((Context)localObject, 141.0F);
        j = 0;
        break;
        paramInt1 = j;
        if ((paramawop instanceof awpf))
        {
          paramInt1 = bawz.a((Context)localObject, paramawop.jdField_a_of_type_Awoq.jdField_c_of_type_Int / 2);
          i = bawz.a((Context)localObject, paramawop.jdField_a_of_type_Awoq.d / 2);
        }
        if ((paramInt2 == paramawop.jdField_a_of_type_Awoq.jdField_c_of_type_Int / 2) && (paramInt2 == paramawop.jdField_a_of_type_Awoq.d / 2))
        {
          j = 1;
          break;
        }
        j = 0;
        break;
        paramInt1 = bawz.a((Context)localObject, 220.0F);
        i = bawz.a((Context)localObject, 136.0F);
        j = 0;
        break;
        paramInt1 = bawz.a((Context)localObject, 162.0F);
        i = bawz.a((Context)localObject, 162.0F);
        j = 0;
        break;
        paramInt1 = bawz.a((Context)localObject, 162.0F);
        i = bawz.a((Context)localObject, 228.0F);
        j = 0;
        break;
        paramInt1 = bawz.a((Context)localObject, 162.0F);
        i = bawz.a((Context)localObject, 162.0F);
        j = 1;
        break;
        paramawop.mFailedDrawable = localColorDrawable;
        paramawop.mLoadingDrawable = localColorDrawable;
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
        paramTextView.setTextColor(localContext.getResources().getColor(2131166855));
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
        paramTextView.setTextColor(localContext.getResources().getColor(2131166855));
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
        paramTextView.setTextColor(localContext.getResources().getColor(2131166856));
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
        paramTextView.setTextColor(localContext.getResources().getColor(2131166856));
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
        paramTextView.setTextColor(localContext.getResources().getColor(2131166856));
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
      paramTextView.setTextColor(localContext.getResources().getColor(2131166990));
      return;
    }
    paramTextView.setTextSize(1, 17.0F);
    paramTextView.setTextColor(localContext.getResources().getColor(2131166861));
    paramTextView.setIncludeFontPadding(false);
  }
  
  private void a(awon paramawon, awwu paramawwu)
  {
    Object localObject1 = BaseApplicationImpl.getApplication().getRuntime();
    Object localObject3 = paramawwu.a().getContext();
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
      paramawwu.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#737373"));
      if (!TextUtils.isEmpty(paramawon.jdField_a_of_type_JavaLangCharSequence)) {
        break label593;
      }
      paramawwu.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      if (paramawon.jdField_a_of_type_Awoi == null) {
        break label775;
      }
      paramawwu.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      paramawwu.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      i = (int)(bbct.k() - vzo.a((Context)localObject3, 30.0F)) / 2 - vzo.a((Context)localObject3, 3.0F);
      localObject1 = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject1).mPlayGifImage = true;
      ((URLDrawable.URLDrawableOptions)localObject1).mFailedDrawable = new ColorDrawable(Color.parseColor("#e7e7e7"));
      ((URLDrawable.URLDrawableOptions)localObject1).mLoadingDrawable = new ColorDrawable(Color.parseColor("#e7e7e7"));
      ((URLDrawable.URLDrawableOptions)localObject1).mRequestWidth = i;
      ((URLDrawable.URLDrawableOptions)localObject1).mRequestHeight = i;
      localObject2 = URLDrawable.getDrawable(paramawon.jdField_a_of_type_Awoi.jdField_a_of_type_JavaLangString, (URLDrawable.URLDrawableOptions)localObject1);
      paramawwu.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable((Drawable)localObject2);
      if ((((URLDrawable)localObject2).getStatus() != 1) && (((URLDrawable)localObject2).getStatus() != 0)) {
        ((URLDrawable)localObject2).restartDownload();
      }
      localObject2 = (LinearLayout.LayoutParams)paramawwu.jdField_a_of_type_ComTencentImageURLImageView.getLayoutParams();
      ((LinearLayout.LayoutParams)localObject2).height = i;
      ((LinearLayout.LayoutParams)localObject2).width = i;
      paramawwu.jdField_a_of_type_ComTencentImageURLImageView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
      paramawwu.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(0);
      if (paramawon.jdField_a_of_type_JavaUtilList == null) {
        return;
      }
      m = Math.min(paramawon.jdField_a_of_type_JavaUtilList.size(), 4);
      n = (i - vzo.a((Context)localObject3, 3.0F)) / 2;
      localObject2 = new int[4];
      Object tmp295_293 = localObject2;
      tmp295_293[0] = 2131367810;
      Object tmp301_295 = tmp295_293;
      tmp301_295[1] = 2131367811;
      Object tmp307_301 = tmp301_295;
      tmp307_301[2] = 2131367812;
      Object tmp313_307 = tmp307_301;
      tmp313_307[3] = 2131367813;
      tmp313_307;
      i = 0;
      if (i >= m) {
        break label748;
      }
      localObject3 = (SquareImageView)paramawwu.jdField_b_of_type_AndroidWidgetLinearLayout.findViewById(localObject2[i]);
      localObject4 = ((awoi)paramawon.jdField_a_of_type_JavaUtilList.get(i)).jdField_a_of_type_JavaLangString;
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
      if ((i != 3) || (paramawon.jdField_a_of_type_Int <= 4)) {
        break label731;
      }
      ((SquareImageView)localObject3).setFilterColor(Color.parseColor("#66000000"));
      k = paramawon.jdField_a_of_type_Int - 4;
      localObject4 = new StringBuilder().append("+");
      j = k;
      if (k > 99) {
        j = 99;
      }
      ((SquareImageView)localObject3).setFilterText(j);
      ((SquareImageView)localObject3).setFilterTextSize(bawz.a(paramawwu.a().getContext(), 20.0F));
    }
    for (;;)
    {
      i += 1;
      break label322;
      paramawwu.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#262626"));
      break;
      label593:
      i = (int)(paramawwu.jdField_a_of_type_AndroidWidgetTextView.getContext().getResources().getDisplayMetrics().widthPixels - bawz.a(paramawwu.jdField_a_of_type_AndroidWidgetTextView.getContext(), 30.0F) - awvy.a(paramawwu.jdField_a_of_type_AndroidWidgetTextView, paramawon.jdField_a_of_type_JavaLangString));
      localObject2 = awvy.a(paramawwu.jdField_a_of_type_AndroidWidgetTextView, i, 1, paramawon.jdField_a_of_type_JavaLangCharSequence.toString(), paramawon.jdField_a_of_type_Awvn.jdField_a_of_type_JavaUtilList, false, false, true);
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      if (paramawon.jdField_a_of_type_JavaLangString == null) {
        paramawon.jdField_a_of_type_JavaLangString = "";
      }
      paramawwu.jdField_a_of_type_AndroidWidgetTextView.setText(new SpannableStringBuilder((CharSequence)localObject1).append(paramawon.jdField_a_of_type_JavaLangString));
      paramawwu.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      break label59;
      label731:
      ((SquareImageView)localObject3).setFilterColor(-1);
      ((SquareImageView)localObject3).setFilterText("");
    }
    label748:
    while (i < 4)
    {
      paramawwu.jdField_b_of_type_AndroidWidgetLinearLayout.findViewById(localObject2[i]).setVisibility(4);
      i += 1;
    }
    label775:
    paramawwu.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    paramawwu.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
    if (paramawon.jdField_a_of_type_JavaUtilList != null)
    {
      m = Math.min(paramawon.jdField_a_of_type_JavaUtilList.size(), paramawwu.jdField_a_of_type_Int);
      n = (int)(bbct.k() - vzo.a(paramawwu.a().getContext(), (m - 1) * 2 + 27));
      i = 0;
      if (i < m)
      {
        localObject1 = (SquareImageView)paramawwu.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(i);
        localObject2 = ((awoi)paramawon.jdField_a_of_type_JavaUtilList.get(i)).jdField_a_of_type_JavaLangString;
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
        if (paramawon.jdField_b_of_type_Int != 0)
        {
          ((SquareImageView)localObject1).setImageScale(n / 4 * 1.0F / bawz.a((Context)localObject3, paramawon.jdField_b_of_type_Int / 2), 0.0F);
          label1007:
          ((SquareImageView)localObject1).setVisibility(0);
          if ((i != paramawwu.jdField_a_of_type_Int - 1) || (paramawon.jdField_a_of_type_Int <= paramawwu.jdField_a_of_type_Int)) {
            break label1136;
          }
          ((SquareImageView)localObject1).setFilterColor(Color.parseColor("#66000000"));
          k = paramawon.jdField_a_of_type_Int - paramawwu.jdField_a_of_type_Int;
          localObject2 = new StringBuilder().append("+");
          j = k;
          if (k > 99) {
            j = 99;
          }
          ((SquareImageView)localObject1).setFilterText(j);
          ((SquareImageView)localObject1).setFilterTextSize(bawz.a(paramawwu.a().getContext(), 20.0F));
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
      while (i < paramawwu.jdField_a_of_type_Int)
      {
        paramawwu.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(i).setVisibility(4);
        i += 1;
      }
    }
  }
  
  private void a(awoo paramawoo, awwv paramawwv)
  {
    Object localObject = paramawwv.a().getContext();
    int i;
    if (!TextUtils.isEmpty(paramawoo.i))
    {
      paramawwv.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      a((Context)localObject, (SquareImageView)paramawwv.jdField_a_of_type_AndroidWidgetImageView, paramawwv.jdField_b_of_type_AndroidWidgetImageView, paramawwv.jdField_b_of_type_AndroidWidgetTextView, paramawoo.jdField_a_of_type_Int, paramawoo.i, paramawoo.jdField_b_of_type_JavaLangString, ((Context)localObject).getResources().getDimensionPixelSize(2131298204));
      i = ((Context)localObject).getResources().getDimensionPixelSize(2131298204);
      if ((paramawoo.jdField_a_of_type_Int == 6) || (paramawoo.jdField_a_of_type_Int == 8)) {
        i = bawz.a((Context)localObject, 100.0F);
      }
      if (paramawwv.jdField_a_of_type_AndroidWidgetRelativeLayout.getVisibility() != 8) {
        break label317;
      }
      i = 0;
      label127:
      float f = ((Context)localObject).getResources().getDisplayMetrics().widthPixels - bawz.a((Context)localObject, 30.0F);
      CharSequence localCharSequence = awvy.a(paramawwv.jdField_a_of_type_AndroidWidgetTextView, f, 2, paramawoo.jdField_a_of_type_JavaLangCharSequence.toString(), paramawoo.jdField_a_of_type_Awvn.jdField_a_of_type_JavaUtilList, false, true);
      paramawwv.jdField_a_of_type_AndroidWidgetTextView.setText(localCharSequence);
      f = ((Context)localObject).getResources().getDisplayMetrics().widthPixels - bawz.a((Context)localObject, 30.0F) - i;
      localObject = awvy.a(paramawwv.c, f, 2, paramawoo.jdField_b_of_type_JavaLangCharSequence.toString(), paramawoo.jdField_a_of_type_Awvn.jdField_a_of_type_JavaUtilList, false, false);
      if (!ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null)) {
        break label333;
      }
      paramawwv.c.setTextColor(Color.parseColor("#4A4A4A"));
      paramawwv.jdField_d_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#4A4A4A"));
    }
    for (;;)
    {
      a(paramawwv.c, (CharSequence)localObject, true);
      a(paramawwv.jdField_d_of_type_AndroidWidgetTextView, paramawoo.jdField_c_of_type_JavaLangCharSequence);
      return;
      paramawwv.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      break;
      label317:
      i += bawz.a((Context)localObject, 10.0F);
      break label127;
      label333:
      paramawwv.c.setTextColor(Color.parseColor("#737373"));
      paramawwv.jdField_d_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#737373"));
    }
  }
  
  private void a(awor paramawor, awwx paramawwx)
  {
    Context localContext = paramawwx.a().getContext();
    int j;
    int i;
    if (paramawor.jdField_a_of_type_Int == 1)
    {
      j = bawz.a(localContext, 375.0F);
      i = bawz.a(localContext, 150.0F);
    }
    for (;;)
    {
      int k;
      if ((j == 0) || (i == 0))
      {
        i = bawz.a(localContext, 375.0F);
        j = bawz.a(localContext, 150.0F);
        k = i;
        i = j;
      }
      for (;;)
      {
        if (!TextUtils.isEmpty(paramawor.jdField_b_of_type_JavaLangString))
        {
          localObject = URLDrawable.URLDrawableOptions.obtain();
          ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
          ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
          ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = k;
          ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = i;
          ((URLDrawable.URLDrawableOptions)localObject).mPlayGifImage = true;
          localObject = URLDrawable.getDrawable(paramawor.jdField_b_of_type_JavaLangString, (URLDrawable.URLDrawableOptions)localObject);
          paramawwx.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable((Drawable)localObject);
          if ((((URLDrawable)localObject).getStatus() != 1) && (((URLDrawable)localObject).getStatus() != 0)) {
            ((URLDrawable)localObject).restartDownload();
          }
          label164:
          paramawwx.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(0);
          localObject = (LinearLayout.LayoutParams)paramawwx.jdField_a_of_type_AndroidWidgetRelativeLayout.getLayoutParams();
          ((LinearLayout.LayoutParams)localObject).height = ((int)(i * vzo.a(localContext) * 1.0F / k));
          paramawwx.jdField_a_of_type_AndroidWidgetRelativeLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
          paramawwx.jdField_a_of_type_AndroidWidgetRelativeLayout.setPadding(0, 0, 0, 0);
          if (TextUtils.isEmpty(paramawor.jdField_a_of_type_JavaLangCharSequence)) {
            break label522;
          }
          paramawwx.jdField_b_of_type_AndroidWidgetTextView.setText(paramawor.jdField_a_of_type_JavaLangCharSequence);
          paramawwx.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
          label253:
          if (TextUtils.isEmpty(paramawor.jdField_b_of_type_JavaLangCharSequence)) {
            break label534;
          }
          paramawwx.c.setText(paramawor.jdField_b_of_type_JavaLangCharSequence);
          paramawwx.c.setVisibility(0);
          label282:
          if (TextUtils.isEmpty(paramawor.j)) {
            break label599;
          }
          paramawwx.jdField_d_of_type_AndroidWidgetTextView.setText(paramawor.j);
        }
        try
        {
          if (!paramawor.k.startsWith("#")) {
            paramawor.k = ("#" + paramawor.k);
          }
          paramawwx.jdField_d_of_type_AndroidWidgetTextView.setBackgroundColor(Color.parseColor(paramawor.k));
        }
        catch (Exception localException)
        {
          for (;;)
          {
            label365:
            paramawwx.jdField_d_of_type_AndroidWidgetTextView.setBackgroundColor(Color.parseColor("#FF00FF00"));
            if (QLog.isColorLevel()) {
              QLog.e("Q.uniteSearch.SearchTemplatePresenter", 2, "bigImageItem.topLeftTagColor = " + paramawor.k);
            }
          }
        }
        paramawwx.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
        Object localObject = ((ViewGroup)paramawwx.a()).getChildAt(((ViewGroup)paramawwx.a()).getChildCount() - 1);
        if ((localObject != null) && ((((View)localObject).getLayoutParams() instanceof LinearLayout.LayoutParams)))
        {
          if (paramawor.b() != 0) {
            break label611;
          }
          ((LinearLayout.LayoutParams)((View)localObject).getLayoutParams()).topMargin = 0;
          paramawwx.jdField_a_of_type_AndroidWidgetRelativeLayout.setPadding(0, 0, 0, bawz.a(localContext, 6.0F));
        }
        label522:
        label534:
        label599:
        label611:
        while (paramawor.b() != 2)
        {
          return;
          if (paramawor.jdField_a_of_type_Int == 2)
          {
            j = bawz.a(localContext, 375.0F);
            i = bawz.a(localContext, 180.0F);
            break;
          }
          if (paramawor.jdField_a_of_type_Int != 0) {
            break label639;
          }
          j = bawz.a(localContext, paramawor.jdField_a_of_type_Float / 2.0F);
          i = bawz.a(localContext, paramawor.jdField_b_of_type_Float / 2.0F);
          break;
          paramawwx.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
          break label164;
          paramawwx.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
          break label253;
          paramawwx.c.setVisibility(8);
          break label282;
          paramawwx.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
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
  
  private void a(awot paramawot, awwz paramawwz)
  {
    Object localObject1 = paramawwz.a().getContext();
    Object localObject2 = paramawwz.a();
    if (paramawot.jdField_b_of_type_Boolean) {
      ((View)localObject2).setPadding(((View)localObject2).getPaddingLeft(), vzo.a(((View)localObject2).getContext(), 6.0F), ((View)localObject2).getPaddingRight(), vzo.a(((View)localObject2).getContext(), 6.0F));
    }
    Object localObject3;
    int i;
    Object localObject4;
    for (;;)
    {
      localObject2 = (LinearLayout)((View)localObject2).findViewById(2131371647);
      localObject3 = new ArrayList();
      i = 0;
      while (i < ((LinearLayout)localObject2).getChildCount())
      {
        localObject4 = ((LinearLayout)localObject2).getChildAt(i).findViewById(2131367872);
        if ((localObject4 instanceof SquareImageView)) {
          ((List)localObject3).add((SquareImageView)localObject4);
        }
        i += 1;
      }
      ((View)localObject2).setPadding(((View)localObject2).getPaddingLeft(), vzo.a(((View)localObject2).getContext(), 3.0F), ((View)localObject2).getPaddingRight(), vzo.a(((View)localObject2).getContext(), 3.0F));
    }
    if (!((List)localObject3).isEmpty())
    {
      if (paramawot.jdField_c_of_type_Boolean)
      {
        i = 0;
        while (i < ((List)localObject3).size())
        {
          ((SquareImageView)((List)localObject3).get(i)).setRoundRect(vzo.a((Context)localObject1, 4.0F));
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
    if (!TextUtils.isEmpty(paramawot.i)) {
      a((Context)localObject1, (SquareImageView)paramawwz.b(), paramawwz.jdField_b_of_type_AndroidWidgetImageView, paramawwz.jdField_a_of_type_AndroidWidgetTextView, paramawot.jdField_a_of_type_Int, paramawot.i, null, bawz.a((Context)localObject1, 32.0F));
    }
    label687:
    Object localObject5;
    if (!TextUtils.isEmpty(paramawot.jdField_a_of_type_JavaLangString))
    {
      localObject2 = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
      ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
      ((URLDrawable.URLDrawableOptions)localObject2).mRequestWidth = paramawwz.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams().width;
      ((URLDrawable.URLDrawableOptions)localObject2).mRequestHeight = paramawwz.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams().height;
      localObject2 = URLDrawable.getDrawable(paramawot.jdField_a_of_type_JavaLangString, (URLDrawable.URLDrawableOptions)localObject2);
      paramawwz.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject2);
      if ((((URLDrawable)localObject2).getStatus() != 1) && (((URLDrawable)localObject2).getStatus() != 0)) {
        ((URLDrawable)localObject2).restartDownload();
      }
      paramawwz.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      i = ((Context)localObject1).getResources().getDimensionPixelSize(2131298204);
      if ((paramawot.jdField_a_of_type_Int == 6) || (paramawot.jdField_a_of_type_Int == 8)) {
        i = bawz.a((Context)localObject1, 100.0F);
      }
      localObject2 = awvy.a(paramawwz.a(), 10.0F * awvy.a(paramawwz.a(), ajyc.a(2131713661)), 1, paramawot.jdField_a_of_type_JavaLangCharSequence.toString(), paramawot.jdField_a_of_type_Awvn.jdField_a_of_type_JavaUtilList, false, false, true);
      paramawwz.a().setText((CharSequence)localObject2);
      paramawwz.a().setEllipsize(null);
      float f1 = ((Context)localObject1).getResources().getDisplayMetrics().widthPixels - bawz.a((Context)localObject1, 40.0F) - i;
      localObject2 = awvy.a(paramawwz.b(), f1, 2, paramawot.jdField_b_of_type_JavaLangCharSequence.toString(), "", false, false, true);
      a(paramawwz.b(), (CharSequence)localObject2, false);
      if (TextUtils.isEmpty(paramawot.jdField_c_of_type_JavaLangCharSequence)) {
        break label1047;
      }
      f1 = ((Context)localObject1).getResources().getDisplayMetrics().widthPixels - bawz.a((Context)localObject1, 30.0F);
      localObject2 = awvy.a(paramawwz.c(), f1, 2, paramawot.jdField_c_of_type_JavaLangCharSequence.toString(), paramawot.jdField_a_of_type_Awvn.jdField_a_of_type_JavaUtilList, false, false);
      paramawwz.c().setText((CharSequence)localObject2);
      paramawwz.c().setVisibility(0);
      if (paramawot.jdField_a_of_type_JavaUtilList == null) {
        break label1479;
      }
      if (paramawot.jdField_a_of_type_JavaUtilList.size() != 1) {
        break label1071;
      }
      paramawwz.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(0);
      paramawwz.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      localObject3 = paramawwz.a().getResources();
      if (jdField_a_of_type_Int == 0) {
        jdField_a_of_type_Int = ((Resources)localObject3).getDisplayMetrics().widthPixels;
      }
      localObject2 = paramawwz.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView;
      ((SquareImageView)localObject2).setImageScale((float)(1.0D / paramawot.jdField_a_of_type_Double), 0.0F);
      f1 = ((Resources)localObject3).getDimension(2131298197);
      float f2 = ((Resources)localObject3).getDimension(2131298197);
      i = bawz.a(paramawwz.a().getContext(), 2.0F);
      j = paramawwz.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount();
      j = (int)(jdField_a_of_type_Int - f1 - f2 - (j - 1) * i) / j;
      i = (int)(j * paramawot.jdField_b_of_type_Double);
      j = (int)(j * paramawot.jdField_b_of_type_Double);
      ((SquareImageView)localObject2).setLayoutParams(new FrameLayout.LayoutParams(i, j));
      localObject3 = (awoi)paramawot.jdField_a_of_type_JavaUtilList.get(0);
      localObject4 = ((awoi)localObject3).jdField_a_of_type_JavaLangString;
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
      if (((awoi)localObject3).jdField_a_of_type_Int != 2) {
        break label1059;
      }
      paramawwz.jdField_d_of_type_AndroidWidgetImageView.setVisibility(0);
    }
    for (;;)
    {
      if ((paramawot.jdField_c_of_type_JavaUtilList != null) || (!TextUtils.equals(paramawot.k, "0")) || (!TextUtils.equals(paramawot.m, "0"))) {
        break label1500;
      }
      paramawwz.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      return;
      paramawwz.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      break;
      label1047:
      paramawwz.c().setVisibility(8);
      break label687;
      label1059:
      paramawwz.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
      continue;
      label1071:
      paramawwz.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(8);
      paramawwz.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      int m = paramawwz.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount();
      i = 0;
      j = i;
      if (i < paramawot.jdField_a_of_type_JavaUtilList.size())
      {
        j = i;
        if (i < m)
        {
          localObject3 = paramawwz.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(i);
          ((View)localObject3).setVisibility(0);
          localObject2 = (SquareImageView)((View)localObject3).findViewById(2131367872);
          localObject3 = (ImageView)((View)localObject3).findViewById(2131368889);
          ((SquareImageView)localObject2).setImageScale((float)(1.0D / paramawot.jdField_a_of_type_Double), 0.0F);
          localObject4 = (awoi)paramawot.jdField_a_of_type_JavaUtilList.get(i);
          localObject5 = ((awoi)localObject4).jdField_a_of_type_JavaLangString;
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
          if (((awoi)localObject4).jdField_a_of_type_Int == 2)
          {
            ((ImageView)localObject3).setVisibility(0);
            label1312:
            if ((i != m - 1) || (paramawot.jdField_b_of_type_Int <= m)) {
              break label1433;
            }
            ((ImageView)localObject3).setVisibility(8);
            ((SquareImageView)localObject2).setFilterColor(Color.parseColor("#66000000"));
            int k = paramawot.jdField_b_of_type_Int - m;
            j = k;
            if (k > 99) {
              j = 99;
            }
            ((SquareImageView)localObject2).setFilterText("+" + j);
            ((SquareImageView)localObject2).setFilterTextSize(bawz.a(((SquareImageView)localObject2).getContext(), 20.0F));
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
        paramawwz.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(j).setVisibility(4);
        j += 1;
      }
      continue;
      label1479:
      paramawwz.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(8);
      paramawwz.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    }
    label1500:
    if (paramawot.jdField_c_of_type_JavaUtilList != null)
    {
      paramawwz.jdField_a_of_type_AndroidWidgetRelativeLayout.removeAllViews();
      i = paramawot.jdField_c_of_type_JavaUtilList.size() - 1;
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
    for (int j = bawz.a((Context)localObject1, 11.0F) * i;; j = 0)
    {
      localObject2 = (SquareImageView)LayoutInflater.from((Context)localObject1).inflate(2131559626, null, false);
      localObject3 = new RelativeLayout.LayoutParams(bawz.a((Context)localObject1, 16.0F), bawz.a((Context)localObject1, 16.0F));
      ((RelativeLayout.LayoutParams)localObject3).leftMargin = j;
      paramawwz.jdField_a_of_type_AndroidWidgetRelativeLayout.addView((View)localObject2, paramawot.jdField_c_of_type_JavaUtilList.size() - 1 - i, (ViewGroup.LayoutParams)localObject3);
      localObject3 = (String)paramawot.jdField_c_of_type_JavaUtilList.get(i);
      localObject4 = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject4).mFailedDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
      ((URLDrawable.URLDrawableOptions)localObject4).mLoadingDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
      ((URLDrawable.URLDrawableOptions)localObject4).mRequestWidth = ((SquareImageView)localObject2).getLayoutParams().width;
      ((URLDrawable.URLDrawableOptions)localObject4).mRequestHeight = ((SquareImageView)localObject2).getLayoutParams().height;
      localObject3 = URLDrawable.getDrawable((String)localObject3, (URLDrawable.URLDrawableOptions)localObject4);
      ((URLDrawable)localObject3).setDecodeHandler(bavi.a);
      ((SquareImageView)localObject2).setImageDrawable((Drawable)localObject3);
      if ((((URLDrawable)localObject3).getStatus() != 1) && (((URLDrawable)localObject3).getStatus() != 0)) {
        ((URLDrawable)localObject3).restartDownload();
      }
      ((SquareImageView)localObject2).setVisibility(0);
      i -= 1;
      break;
      paramawwz.jdField_a_of_type_AndroidWidgetRelativeLayout.removeAllViews();
      label1758:
      if (!TextUtils.isEmpty(paramawot.jdField_b_of_type_JavaLangString))
      {
        paramawwz.jdField_b_of_type_AndroidWidgetTextView.setText(paramawot.jdField_b_of_type_JavaLangString);
        paramawwz.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
        if (TextUtils.isEmpty(paramawot.j)) {
          break label2084;
        }
        localObject1 = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject1).mFailedDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
        ((URLDrawable.URLDrawableOptions)localObject1).mLoadingDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
        ((URLDrawable.URLDrawableOptions)localObject1).mRequestWidth = paramawwz.jdField_a_of_type_ComTencentImageURLImageView.getLayoutParams().width;
        ((URLDrawable.URLDrawableOptions)localObject1).mRequestHeight = paramawwz.jdField_a_of_type_ComTencentImageURLImageView.getLayoutParams().height;
        localObject1 = URLDrawable.getDrawable(paramawot.j, (URLDrawable.URLDrawableOptions)localObject1);
        paramawwz.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable((Drawable)localObject1);
        if ((((URLDrawable)localObject1).getStatus() != 1) && (((URLDrawable)localObject1).getStatus() != 0)) {
          ((URLDrawable)localObject1).restartDownload();
        }
        paramawwz.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(0);
        label1900:
        if (TextUtils.isEmpty(paramawot.k)) {
          break label2096;
        }
        paramawwz.c.setText(paramawot.k);
        paramawwz.c.setVisibility(0);
        if (TextUtils.isEmpty(paramawot.l)) {
          break label2108;
        }
        localObject1 = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject1).mFailedDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
        ((URLDrawable.URLDrawableOptions)localObject1).mLoadingDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
        ((URLDrawable.URLDrawableOptions)localObject1).mRequestWidth = paramawwz.jdField_b_of_type_ComTencentImageURLImageView.getLayoutParams().width;
        ((URLDrawable.URLDrawableOptions)localObject1).mRequestHeight = paramawwz.jdField_b_of_type_ComTencentImageURLImageView.getLayoutParams().height;
        localObject1 = URLDrawable.getDrawable(paramawot.l, (URLDrawable.URLDrawableOptions)localObject1);
        paramawwz.jdField_b_of_type_ComTencentImageURLImageView.setImageDrawable((Drawable)localObject1);
        if ((((URLDrawable)localObject1).getStatus() != 1) && (((URLDrawable)localObject1).getStatus() != 0)) {
          ((URLDrawable)localObject1).restartDownload();
        }
        paramawwz.jdField_b_of_type_ComTencentImageURLImageView.setVisibility(0);
      }
      for (;;)
      {
        if (TextUtils.isEmpty(paramawot.m)) {
          break label2120;
        }
        paramawwz.jdField_d_of_type_AndroidWidgetTextView.setText(paramawot.m);
        paramawwz.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
        return;
        paramawwz.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
        break;
        paramawwz.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(8);
        break label1900;
        paramawwz.c.setVisibility(8);
        break label1929;
        paramawwz.jdField_b_of_type_ComTencentImageURLImageView.setVisibility(8);
      }
      paramawwz.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
      return;
    }
  }
  
  private void a(awoz paramawoz, awxf paramawxf)
  {
    Object localObject = paramawxf.a();
    Context localContext = ((View)localObject).getContext();
    if (((localObject instanceof LinearLayout)) && (((LinearLayout)localObject).getChildCount() == 1))
    {
      localObject = ((LinearLayout)localObject).getChildAt(0);
      ((View)localObject).setPadding(((View)localObject).getPaddingLeft(), 0, ((View)localObject).getPaddingRight(), 0);
    }
    if (!TextUtils.isEmpty(paramawoz.jdField_b_of_type_JavaLangString))
    {
      localObject = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
      ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
      ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = bawz.a(localContext, 50.0F);
      ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = bawz.a(localContext, 50.0F);
      ((URLDrawable.URLDrawableOptions)localObject).mMemoryCacheKeySuffix = "leftIcon";
      localObject = URLDrawable.getDrawable(paramawoz.jdField_b_of_type_JavaLangString, (URLDrawable.URLDrawableOptions)localObject);
      paramawxf.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable((Drawable)localObject);
      if ((((URLDrawable)localObject).getStatus() != 1) && (((URLDrawable)localObject).getStatus() != 0)) {
        ((URLDrawable)localObject).restartDownload();
      }
      paramawxf.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(0);
      if (TextUtils.isEmpty(paramawoz.j)) {
        break label504;
      }
      paramawxf.jdField_a_of_type_AndroidWidgetTextView.setText(paramawoz.j);
      paramawxf.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      label204:
      if (TextUtils.isEmpty(paramawoz.g)) {
        break label516;
      }
      paramawxf.jdField_b_of_type_AndroidWidgetTextView.setText(paramawoz.g);
      paramawxf.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      label233:
      if (TextUtils.isEmpty(paramawoz.k)) {
        break label528;
      }
      paramawxf.c.setVisibility(0);
      paramawxf.c.setText(paramawoz.k);
      label262:
      if (TextUtils.isEmpty(paramawoz.l)) {
        break label540;
      }
      localObject = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
      ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
      ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = bawz.a(localContext, 30.0F);
      ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = bawz.a(localContext, 30.0F);
      ((URLDrawable.URLDrawableOptions)localObject).mMemoryCacheKeySuffix = "rightIcon";
      localObject = URLDrawable.getDrawable(paramawoz.l, (URLDrawable.URLDrawableOptions)localObject);
      paramawxf.jdField_b_of_type_ComTencentImageURLImageView.setImageDrawable((Drawable)localObject);
      if ((((URLDrawable)localObject).getStatus() != 1) && (((URLDrawable)localObject).getStatus() != 0)) {
        ((URLDrawable)localObject).restartDownload();
      }
      paramawxf.jdField_b_of_type_ComTencentImageURLImageView.setVisibility(0);
      label377:
      paramawxf.a(paramawoz);
      if (!ThemeUtil.isInNightMode(BaseApplicationImpl.getApplication().getRuntime())) {
        break label552;
      }
      paramawxf.jdField_a_of_type_AndroidWidgetLinearLayout.setBackgroundResource(2130839124);
      paramawxf.jdField_b_of_type_AndroidWidgetLinearLayout.setBackgroundResource(2130839124);
      paramawxf.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#737373"));
      paramawxf.c.setTextColor(Color.parseColor("#4A4A4A"));
    }
    for (;;)
    {
      if (paramawxf.jdField_b_of_type_AndroidWidgetTextView != null) {
        paramawxf.jdField_b_of_type_AndroidWidgetTextView.setTextColor(awvy.b());
      }
      paramawxf.jdField_a_of_type_AndroidWidgetLinearLayout.setOnClickListener(new awse(this, paramawoz, localContext));
      paramawxf.jdField_b_of_type_AndroidWidgetLinearLayout.setOnClickListener(new awsf(this, paramawoz, localContext));
      return;
      paramawxf.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(8);
      break;
      label504:
      paramawxf.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      break label204;
      label516:
      paramawxf.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      break label233;
      label528:
      paramawxf.c.setVisibility(8);
      break label262;
      label540:
      paramawxf.jdField_b_of_type_ComTencentImageURLImageView.setVisibility(8);
      break label377;
      label552:
      paramawxf.jdField_a_of_type_AndroidWidgetLinearLayout.setBackgroundResource(2130839123);
      paramawxf.jdField_b_of_type_AndroidWidgetLinearLayout.setBackgroundResource(2130839123);
      paramawxf.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#262626"));
      paramawxf.c.setTextColor(Color.parseColor("#737373"));
    }
  }
  
  private void a(awpa paramawpa, awxh paramawxh)
  {
    Object localObject = paramawxh.a();
    Context localContext = ((View)localObject).getContext();
    if (((localObject instanceof LinearLayout)) && (((LinearLayout)localObject).getChildCount() == 1))
    {
      localObject = ((LinearLayout)localObject).getChildAt(0);
      ((View)localObject).setPadding(((View)localObject).getPaddingLeft(), 0, ((View)localObject).getPaddingRight(), 0);
    }
    if (!TextUtils.isEmpty(paramawpa.jdField_b_of_type_JavaLangString))
    {
      localObject = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
      ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
      ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = bawz.a(localContext, 40.0F);
      ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = bawz.a(localContext, 40.0F);
      ((URLDrawable.URLDrawableOptions)localObject).mMemoryCacheKeySuffix = "leftIcon";
      localObject = URLDrawable.getDrawable(paramawpa.jdField_b_of_type_JavaLangString, (URLDrawable.URLDrawableOptions)localObject);
      paramawxh.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable((Drawable)localObject);
      if ((((URLDrawable)localObject).getStatus() != 1) && (((URLDrawable)localObject).getStatus() != 0)) {
        ((URLDrawable)localObject).restartDownload();
      }
      paramawxh.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(0);
      if (TextUtils.isEmpty(paramawpa.j)) {
        break label363;
      }
      paramawxh.jdField_a_of_type_AndroidWidgetTextView.setText(paramawpa.j);
      paramawxh.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      label204:
      if (TextUtils.isEmpty(paramawpa.g)) {
        break label375;
      }
      paramawxh.c.setText(paramawpa.g);
      paramawxh.c.setVisibility(0);
      label233:
      if (TextUtils.isEmpty(paramawpa.k)) {
        break label387;
      }
      paramawxh.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
      paramawxh.jdField_d_of_type_AndroidWidgetTextView.setText(paramawpa.k);
      label262:
      if (!paramawpa.jdField_b_of_type_Boolean) {
        break label399;
      }
      paramawxh.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    }
    for (;;)
    {
      awso.a(null, 0, paramawpa.jdField_c_of_type_Int, "0X8009D5C", 0, 0, null, null);
      if ((paramawpa.jdField_a_of_type_JavaUtilList != null) && (paramawpa.jdField_a_of_type_JavaUtilList.size() > 0)) {
        awso.a(null, 0, paramawpa.jdField_c_of_type_Int, "0X8009D5E", 0, 0, null, null);
      }
      paramawxh.a(paramawpa);
      paramawxh.jdField_a_of_type_AndroidWidgetLinearLayout.setOnClickListener(new awsd(this, paramawpa, localContext));
      return;
      paramawxh.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(8);
      break;
      label363:
      paramawxh.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      break label204;
      label375:
      paramawxh.c.setVisibility(8);
      break label233;
      label387:
      paramawxh.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
      break label262;
      label399:
      paramawxh.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    }
  }
  
  private void a(awpc paramawpc, awxn paramawxn)
  {
    if ((paramawpc == null) || (paramawxn == null)) {
      return;
    }
    paramawxn.jdField_a_of_type_AndroidWidgetLinearLayout.setPadding(paramawxn.jdField_a_of_type_AndroidWidgetLinearLayout.getPaddingLeft(), 0, paramawxn.jdField_a_of_type_AndroidWidgetLinearLayout.getPaddingRight(), 0);
    Object localObject = (RelativeLayout.LayoutParams)paramawxn.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams();
    boolean bool = ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null);
    if (paramawpc.jdField_b_of_type_Boolean)
    {
      ((RelativeLayout.LayoutParams)localObject).addRule(5, 0);
      ((RelativeLayout.LayoutParams)localObject).addRule(14);
      localObject = paramawxn.jdField_a_of_type_AndroidWidgetTextView.getContext();
      int i = ((Context)localObject).getResources().getDisplayMetrics().widthPixels - bawz.a((Context)localObject, 38.0F);
      if (TextUtils.isEmpty(paramawpc.jdField_b_of_type_JavaLangCharSequence)) {
        break label310;
      }
      paramawxn.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      if (!bool) {
        break label296;
      }
      paramawxn.jdField_b_of_type_AndroidWidgetTextView.setText(paramawpc.jdField_b_of_type_JavaLangCharSequence.toString());
      label148:
      float f1 = i;
      float f2 = awvy.a(paramawxn.jdField_b_of_type_AndroidWidgetTextView, paramawpc.jdField_b_of_type_JavaLangCharSequence);
      i = (int)(f1 - (bawz.a((Context)localObject, 10.0F) + f2));
      label182:
      if (TextUtils.isEmpty(paramawpc.jdField_a_of_type_JavaLangCharSequence)) {
        break label334;
      }
      paramawxn.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      localObject = paramawpc.jdField_a_of_type_JavaLangCharSequence;
      if (paramawpc.jdField_b_of_type_Boolean) {
        break label346;
      }
      localObject = awvy.a(paramawxn.jdField_a_of_type_AndroidWidgetTextView, i, (CharSequence)localObject);
    }
    label296:
    label310:
    label334:
    label346:
    for (;;)
    {
      if (bool) {
        paramawxn.jdField_a_of_type_AndroidWidgetTextView.setText(((CharSequence)localObject).toString());
      }
      for (;;)
      {
        paramawxn.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundDrawable(a(paramawpc.jdField_a_of_type_JavaLangString));
        paramawxn.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(new awsg(this, paramawpc, paramawxn));
        return;
        ((RelativeLayout.LayoutParams)localObject).addRule(14, 0);
        ((RelativeLayout.LayoutParams)localObject).addRule(5);
        break;
        paramawxn.jdField_b_of_type_AndroidWidgetTextView.setText(paramawpc.jdField_b_of_type_JavaLangCharSequence);
        break label148;
        paramawxn.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
        break label182;
        paramawxn.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
        continue;
        paramawxn.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      }
    }
  }
  
  private void a(awpd paramawpd, awxm paramawxm)
  {
    if ((paramawpd == null) || (paramawxm == null)) {}
    while ((TextUtils.isEmpty(paramawpd.jdField_a_of_type_JavaLangString)) || (paramawxm.jdField_a_of_type_AndroidWidgetTextView == null)) {
      return;
    }
    Context localContext = paramawxm.jdField_a_of_type_AndroidWidgetTextView.getContext();
    int j = localContext.getResources().getDisplayMetrics().widthPixels - bawz.a(localContext, 40.0F);
    int i;
    if ((!TextUtils.isEmpty(paramawpd.e)) && (paramawxm.jdField_a_of_type_AndroidWidgetLinearLayout != null))
    {
      paramawxm.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      i = j - bawz.a(localContext, 26.0F);
    }
    for (;;)
    {
      paramawpd = awvy.a(paramawxm.jdField_a_of_type_AndroidWidgetTextView, i, paramawpd.jdField_a_of_type_JavaLangString);
      paramawxm.jdField_a_of_type_AndroidWidgetTextView.setText(paramawpd);
      return;
      i = j;
      if (paramawxm.jdField_a_of_type_AndroidWidgetLinearLayout != null)
      {
        paramawxm.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
        i = j;
      }
    }
  }
  
  private void a(awpf paramawpf, awxp paramawxp)
  {
    Context localContext = paramawxp.jdField_b_of_type_AndroidWidgetRelativeLayout.getContext();
    Object localObject = (RelativeLayout.LayoutParams)paramawxp.jdField_a_of_type_AndroidWidgetLinearLayout.getLayoutParams();
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)paramawxp.jdField_b_of_type_AndroidWidgetRelativeLayout.getLayoutParams();
    if (paramawpf.jdField_b_of_type_Boolean)
    {
      ((RelativeLayout.LayoutParams)localObject).addRule(15);
      localLayoutParams.addRule(15);
      localLayoutParams.addRule(10, 0);
      localLayoutParams.addRule(10, 0);
    }
    for (;;)
    {
      localObject = a(paramawpf, paramawxp, false, 0);
      if (((Integer)((Pair)localObject).first).intValue() != 0) {
        ((RelativeLayout.LayoutParams)paramawxp.jdField_b_of_type_AndroidWidgetRelativeLayout.getLayoutParams()).rightMargin = bawz.a(localContext, 10.0F);
      }
      int i = a(paramawpf, paramawxp);
      int j = a(paramawpf, paramawxp, ((Integer)((Pair)localObject).first).intValue(), i);
      i = j;
      if (((Integer)((Pair)localObject).second).intValue() > j) {
        i = ((Integer)((Pair)localObject).second).intValue();
      }
      if (paramawxp.jdField_a_of_type_AndroidWidgetRelativeLayout != null) {
        ((RelativeLayout.LayoutParams)paramawxp.jdField_a_of_type_AndroidWidgetRelativeLayout.getLayoutParams()).height = i;
      }
      return;
      ((RelativeLayout.LayoutParams)localObject).addRule(10);
      localLayoutParams.addRule(10);
      ((RelativeLayout.LayoutParams)localObject).addRule(15, 0);
      localLayoutParams.addRule(15, 0);
    }
  }
  
  private void a(awpj paramawpj, awxq paramawxq)
  {
    Object localObject1 = paramawxq.a().getContext();
    Object localObject2 = paramawxq.a();
    if (paramawpj.jdField_b_of_type_Boolean) {
      ((View)localObject2).setPadding(((View)localObject2).getPaddingLeft(), vzo.a(((View)localObject2).getContext(), 9.0F), ((View)localObject2).getPaddingRight(), vzo.a(((View)localObject2).getContext(), 9.0F));
    }
    Object localObject3;
    int i;
    Object localObject4;
    for (;;)
    {
      localObject2 = (LinearLayout)((View)localObject2).findViewById(2131371647);
      localObject3 = new ArrayList();
      i = 0;
      while (i < ((LinearLayout)localObject2).getChildCount())
      {
        localObject4 = ((LinearLayout)localObject2).getChildAt(i).findViewById(2131367872);
        if ((localObject4 instanceof SquareImageView)) {
          ((List)localObject3).add((SquareImageView)localObject4);
        }
        i += 1;
      }
      ((View)localObject2).setPadding(((View)localObject2).getPaddingLeft(), vzo.a(((View)localObject2).getContext(), 6.0F), ((View)localObject2).getPaddingRight(), vzo.a(((View)localObject2).getContext(), 6.0F));
    }
    if (!((List)localObject3).isEmpty())
    {
      if (paramawpj.jdField_c_of_type_Boolean)
      {
        i = 0;
        while (i < ((List)localObject3).size())
        {
          ((SquareImageView)((List)localObject3).get(i)).setRoundRect(vzo.a((Context)localObject1, 4.0F));
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
      paramawxq.a().setTextColor(Color.parseColor("#6991B8"));
      paramawxq.c().setTextColor(Color.parseColor("#44608A"));
      paramawxq.b().setTextColor(Color.parseColor("#44608A"));
      if (!TextUtils.isEmpty(paramawpj.i)) {
        a((Context)localObject1, (SquareImageView)paramawxq.b(), paramawxq.jdField_b_of_type_AndroidWidgetImageView, paramawxq.jdField_a_of_type_AndroidWidgetTextView, paramawpj.jdField_a_of_type_Int, paramawpj.i, null, bawz.a((Context)localObject1, 21.0F));
      }
      if (TextUtils.isEmpty(paramawpj.jdField_a_of_type_JavaLangString)) {
        break label1085;
      }
      localObject2 = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
      ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
      ((URLDrawable.URLDrawableOptions)localObject2).mRequestWidth = paramawxq.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams().width;
      ((URLDrawable.URLDrawableOptions)localObject2).mRequestHeight = paramawxq.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams().height;
      localObject2 = URLDrawable.getDrawable(paramawpj.jdField_a_of_type_JavaLangString, (URLDrawable.URLDrawableOptions)localObject2);
      paramawxq.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject2);
      if ((((URLDrawable)localObject2).getStatus() != 1) && (((URLDrawable)localObject2).getStatus() != 0)) {
        ((URLDrawable)localObject2).restartDownload();
      }
      paramawxq.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      i = ((Context)localObject1).getResources().getDimensionPixelSize(2131298204);
      if ((paramawpj.jdField_a_of_type_Int == 6) || (paramawpj.jdField_a_of_type_Int == 8)) {
        i = bawz.a((Context)localObject1, 100.0F);
      }
      localObject2 = awvy.a(paramawxq.a(), 10.0F * awvy.a(paramawxq.a(), ajyc.a(2131713660)), 1, paramawpj.jdField_a_of_type_JavaLangCharSequence.toString(), paramawpj.jdField_a_of_type_Awvn.jdField_a_of_type_JavaUtilList, false, false, true);
      paramawxq.a().setText((CharSequence)localObject2);
      paramawxq.a().setEllipsize(null);
      float f1 = ((Context)localObject1).getResources().getDisplayMetrics().widthPixels - bawz.a((Context)localObject1, 40.0F) - i;
      localObject2 = awvy.a(paramawxq.b(), f1, 2, paramawpj.jdField_b_of_type_JavaLangCharSequence.toString(), "", false, false, true);
      a(paramawxq.b(), (CharSequence)localObject2, false);
      if (TextUtils.isEmpty(paramawpj.jdField_c_of_type_JavaLangCharSequence)) {
        break label1097;
      }
      f1 = ((Context)localObject1).getResources().getDisplayMetrics().widthPixels - bawz.a((Context)localObject1, 30.0F);
      localObject2 = awvy.a(paramawxq.c(), f1, 2, paramawpj.jdField_c_of_type_JavaLangCharSequence.toString(), paramawpj.jdField_a_of_type_Awvn.jdField_a_of_type_JavaUtilList, false, false);
      paramawxq.c().setText((CharSequence)localObject2);
      paramawxq.c().setVisibility(0);
      label740:
      if (paramawpj.jdField_a_of_type_JavaUtilList == null) {
        break label1546;
      }
      if (paramawpj.jdField_a_of_type_JavaUtilList.size() != 1) {
        break label1119;
      }
      paramawxq.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(0);
      paramawxq.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      localObject2 = paramawxq.a().getResources();
      if (jdField_a_of_type_Int == 0) {
        jdField_a_of_type_Int = ((Resources)localObject2).getDisplayMetrics().widthPixels;
      }
      localObject1 = paramawxq.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView;
      ((SquareImageView)localObject1).setImageScale((float)(1.0D / paramawpj.jdField_a_of_type_Double), 0.0F);
      f1 = ((Resources)localObject2).getDimension(2131298197);
      float f2 = ((Resources)localObject2).getDimension(2131298197);
      i = bawz.a(paramawxq.a().getContext(), 2.0F);
      j = paramawxq.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount();
      j = (int)(jdField_a_of_type_Int - f1 - f2 - (j - 1) * i) / j;
      i = (int)(j * paramawpj.jdField_b_of_type_Double);
      j = (int)(j * paramawpj.jdField_b_of_type_Double);
      ((SquareImageView)localObject1).setLayoutParams(new FrameLayout.LayoutParams(i, j));
      paramawpj = (awoi)paramawpj.jdField_a_of_type_JavaUtilList.get(0);
      localObject2 = paramawpj.jdField_a_of_type_JavaLangString;
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
      if (paramawpj.jdField_a_of_type_Int != 2) {
        break label1109;
      }
      paramawxq.jdField_d_of_type_AndroidWidgetImageView.setVisibility(0);
    }
    for (;;)
    {
      return;
      paramawxq.a().setTextColor(Color.parseColor("#262626"));
      paramawxq.c().setTextColor(Color.parseColor("#737373"));
      paramawxq.b().setTextColor(Color.parseColor("#737373"));
      break;
      label1085:
      paramawxq.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      break label496;
      label1097:
      paramawxq.c().setVisibility(8);
      break label740;
      label1109:
      paramawxq.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
      return;
      label1119:
      paramawxq.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(8);
      paramawxq.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      int m = paramawxq.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount();
      i = 0;
      j = i;
      if (i < paramawpj.jdField_a_of_type_JavaUtilList.size())
      {
        j = i;
        if (i < m)
        {
          localObject3 = paramawxq.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(i);
          ((View)localObject3).setVisibility(0);
          localObject2 = (SquareImageView)((View)localObject3).findViewById(2131367872);
          localObject3 = (ImageView)((View)localObject3).findViewById(2131368889);
          j = vzo.a((Context)localObject1) / m;
          int k = (int)(j * paramawpj.jdField_a_of_type_Double);
          ((SquareImageView)localObject2).setImageScale((float)(1.0D / paramawpj.jdField_a_of_type_Double), 0.0F);
          localObject4 = (awoi)paramawpj.jdField_a_of_type_JavaUtilList.get(i);
          Object localObject5 = ((awoi)localObject4).jdField_a_of_type_JavaLangString;
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
          if (((awoi)localObject4).jdField_a_of_type_Int == 2)
          {
            ((ImageView)localObject3).setVisibility(0);
            label1379:
            if ((i != m - 1) || (paramawpj.jdField_b_of_type_Int <= m)) {
              break label1500;
            }
            ((ImageView)localObject3).setVisibility(8);
            ((SquareImageView)localObject2).setFilterColor(Color.parseColor("#66000000"));
            k = paramawpj.jdField_b_of_type_Int - m;
            j = k;
            if (k > 99) {
              j = 99;
            }
            ((SquareImageView)localObject2).setFilterText("+" + j);
            ((SquareImageView)localObject2).setFilterTextSize(bawz.a(((SquareImageView)localObject2).getContext(), 20.0F));
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
        paramawxq.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(j).setVisibility(4);
        j += 1;
      }
    }
    label1546:
    paramawxq.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(8);
    paramawxq.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
  }
  
  private void a(SquareImageView paramSquareImageView, int paramInt1, int paramInt2, String paramString)
  {
    if ((paramSquareImageView == null) || (TextUtils.isEmpty(paramString))) {
      return;
    }
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mFailedDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
    localURLDrawableOptions.mLoadingDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
    paramSquareImageView.getLayoutParams().width = bawz.a(paramSquareImageView.getContext(), paramInt1);
    paramSquareImageView.getLayoutParams().height = bawz.a(paramSquareImageView.getContext(), paramInt2);
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
  
  private void b(awpf paramawpf, awxp paramawxp)
  {
    if ((paramawpf == null) || (paramawpf.jdField_a_of_type_Awpg == null) || (paramawxp == null)) {
      if ((paramawxp != null) && (paramawxp.jdField_b_of_type_AndroidWidgetButton != null)) {
        paramawxp.jdField_b_of_type_AndroidWidgetButton.setVisibility(8);
      }
    }
    while (paramawxp.jdField_b_of_type_AndroidWidgetButton == null) {
      return;
    }
    Context localContext = paramawxp.jdField_b_of_type_AndroidWidgetButton.getContext();
    if ((paramawpf.jdField_a_of_type_Awpg.jdField_a_of_type_Int == 1) && (!TextUtils.isEmpty(paramawpf.jdField_a_of_type_Awpg.jdField_a_of_type_JavaLangCharSequence)))
    {
      paramawxp.jdField_b_of_type_AndroidWidgetButton.setVisibility(0);
      paramawxp.jdField_b_of_type_AndroidWidgetButton.setText(paramawpf.jdField_a_of_type_Awpg.jdField_a_of_type_JavaLangCharSequence);
      paramawxp.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(new awsj(this, localContext, paramawpf));
      return;
    }
    paramawxp.jdField_b_of_type_AndroidWidgetButton.setVisibility(8);
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
      a(paramSquareImageView, paramImageView, paramTextView, paramInt2, paramInt2, false, paramString1, null, 2130841810, false);
      return;
    case 4: 
      a(paramSquareImageView, paramImageView, paramTextView, paramInt2, paramInt2, false, paramString1, null, 2130841810, false);
      return;
    case 5: 
      a(paramSquareImageView, paramImageView, paramTextView, paramInt2, paramInt2, false, paramString1, null, 0, true);
      return;
    case 6: 
      paramInt1 = bawz.a(paramContext, 62.0F);
      a(paramSquareImageView, paramImageView, paramTextView, bawz.a(paramContext, 100.0F), paramInt1, false, paramString1, null, 2130841810, false);
      return;
    case 7: 
      a(paramSquareImageView, paramImageView, paramTextView, bawz.a(paramContext, 100.0F), bawz.a(paramContext, 62.0F), false, paramString1, paramString2, 0, false);
      return;
    }
    a(paramSquareImageView, paramImageView, paramTextView, bawz.a(paramContext, 100.0F), bawz.a(paramContext, 62.0F), false, paramString1, null, 0, false);
  }
  
  public void a(ImageView paramImageView)
  {
    if (paramImageView == null) {}
    Animation localAnimation;
    do
    {
      return;
      localAnimation = AnimationUtils.loadAnimation(paramImageView.getContext(), 2130772182);
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
  
  public void a(awop paramawop, awww paramawww)
  {
    awwb.a(paramawop.a(), paramawop.b(), paramawww.a(), paramawop.jdField_a_of_type_Boolean, paramawop.r, paramawop.f);
    switch (paramawop.d())
    {
    }
    for (;;)
    {
      b(paramawop, paramawww);
      if (TextUtils.isEmpty(paramawop.i)) {
        c(paramawop, paramawww);
      }
      return;
      a((awon)paramawop, (awwu)paramawww);
      continue;
      a((awpj)paramawop, (awxq)paramawww);
      continue;
      a((awoo)paramawop, (awwv)paramawww);
      continue;
      a((awow)paramawop, (awxc)paramawww);
      continue;
      a((awpf)paramawop, (awxp)paramawww);
      continue;
      a((awpc)paramawop, (awxn)paramawww);
      continue;
      a((awpd)paramawop, (awxm)paramawww);
      continue;
      a((awot)paramawop, (awwz)paramawww);
      continue;
      a((awor)paramawop, (awwx)paramawww);
      continue;
      a((awou)paramawop, (awxa)paramawww);
      continue;
      a((awpe)paramawop, (awxo)paramawww);
      continue;
      a((awpb)paramawop, (awxk)paramawww);
      continue;
      a((awoz)paramawop, (awxf)paramawww);
      continue;
      a((awpa)paramawop, (awxh)paramawww);
      continue;
      a((awoy)paramawop, (awxe)paramawww);
    }
  }
  
  public void a(awop paramawop, awww paramawww, Bitmap paramBitmap)
  {
    if (paramawww.b() != null) {
      paramawww.b().setImageBitmap(paramBitmap);
    }
  }
  
  protected void a(awou paramawou, awxa paramawxa)
  {
    if ((paramawou.jdField_a_of_type_JavaUtilArrayList == null) || (paramawou.jdField_a_of_type_JavaUtilArrayList.size() == 0))
    {
      if (QLog.isColorLevel()) {
        QLog.e("Q.uniteSearch.SearchTemplatePresenter", 2, "bindHorSlidingContainerTemplateView, containerItem.horizontalModelItems is empty");
      }
      return;
    }
    awkg localawkg2 = (awkg)paramawxa.jdField_a_of_type_ComTencentWidgetHorizontalListView.getAdapter();
    awkg localawkg1;
    if (localawkg2 != null)
    {
      localawkg1 = localawkg2;
      if (localawkg2.a() == paramawou.jdField_a_of_type_JavaUtilArrayList) {}
    }
    else
    {
      localawkg1 = new awkg(paramawou, this.jdField_a_of_type_Awkf.jdField_b_of_type_Int, paramawxa.jdField_a_of_type_ComTencentWidgetHorizontalListView);
      paramawxa.jdField_a_of_type_ComTencentWidgetHorizontalListView.setAdapter(localawkg1);
    }
    if (localawkg1.a() != paramawou.jdField_a_of_type_JavaUtilArrayList)
    {
      paramawxa.jdField_a_of_type_Awou = paramawou;
      paramawxa.jdField_a_of_type_ComTencentWidgetHorizontalListView.resetCurrentX(paramawou.jdField_b_of_type_Int);
    }
    localawkg1.a(paramawou.jdField_a_of_type_JavaUtilArrayList);
  }
  
  protected void a(awow paramawow, awxc paramawxc)
  {
    paramawxc.a().getContext();
    paramawxc.a();
    if ((paramawow.jdField_a_of_type_JavaUtilArrayList == null) || (paramawow.jdField_a_of_type_JavaUtilArrayList.size() == 0)) {
      if (QLog.isColorLevel()) {
        QLog.e("Q.uniteSearch.SearchTemplatePresenter", 2, "bindHorizontalContainerTemplateView, containerItem.horizontalModelItems is empty");
      }
    }
    for (;;)
    {
      return;
      paramawxc.a(paramawow);
      if (paramawow.jdField_a_of_type_JavaUtilArrayList.size() != paramawxc.jdField_a_of_type_JavaUtilArrayList.size()) {
        QLog.e("Q.uniteSearch.SearchTemplatePresenter", 2, "bindHorizontalContainerTemplateView, view.size != model.size");
      }
      int j = paramawow.jdField_a_of_type_JavaUtilArrayList.size();
      int i = 0;
      while (i < j)
      {
        ((awov)paramawow.jdField_a_of_type_JavaUtilArrayList.get(i)).a((awxb)paramawxc.jdField_a_of_type_JavaUtilArrayList.get(i));
        i += 1;
      }
    }
  }
  
  protected void a(awoy paramawoy, awxe paramawxe)
  {
    Object localObject2 = (LinearLayout)paramawxe.b();
    Object localObject1;
    Object localObject3;
    awws localawws;
    if ((localObject2 != null) && (paramawoy.a != null))
    {
      ((LinearLayout)localObject2).removeAllViews();
      if (((LinearLayout)localObject2).getParent() != null) {
        ((View)((LinearLayout)localObject2).getParent()).setPadding(0, 0, 0, 0);
      }
      localObject1 = paramawoy.a;
      paramawoy = paramawxe.a().getContext();
      localObject3 = LayoutInflater.from(paramawoy).inflate(2131562390, null);
      localawws = new awws((View)localObject3);
      Object localObject4 = ((View)localObject3).findViewById(2131368325);
      int i = bbkx.a(6.0F);
      ((View)localObject4).setPadding(0, i, 0, i);
      ((LinearLayout)localObject2).addView((View)localObject3);
      if (((awol)localObject1).c() != null) {
        break label559;
      }
      if (localawws.c() != null) {
        localawws.c().setVisibility(8);
      }
      if (localawws.a() != null) {
        localawws.a().setVisibility(8);
      }
      localObject2 = localawws.a();
      if (localObject2 != null) {
        ((URLImageView)localObject2).setVisibility(8);
      }
      localObject2 = localawws.e();
      if (localObject2 != null)
      {
        ((TextView)localObject2).setVisibility(0);
        if (!TextUtils.isEmpty(((awol)localObject1).a())) {
          ((TextView)localObject2).setText(((awol)localObject1).a());
        }
      }
      if ((localawws.b() != null) && (!TextUtils.isEmpty(((awol)localObject1).g())))
      {
        localObject2 = ((awol)localObject1).g();
        localObject3 = new ColorDrawable(Color.parseColor("#e7e7e7"));
        localObject4 = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject4).mRequestWidth = bawz.a(paramawoy, 50.0F);
        ((URLDrawable.URLDrawableOptions)localObject4).mRequestHeight = bawz.a(paramawoy, 50.0F);
        ((URLDrawable.URLDrawableOptions)localObject4).mFailedDrawable = ((Drawable)localObject3);
        ((URLDrawable.URLDrawableOptions)localObject4).mLoadingDrawable = ((Drawable)localObject3);
        if (!bfng.a((String)localObject2)) {
          break label684;
        }
        localObject2 = URLDrawable.getDrawable((String)localObject2, (URLDrawable.URLDrawableOptions)localObject4);
        ((URLDrawable)localObject2).setTag(bavi.b(bawz.a(paramawoy, 50.0F), bawz.a(paramawxe.a().getContext(), 50.0F), bawz.a(paramawoy, 3.0F)));
        ((URLDrawable)localObject2).setDecodeHandler(bavi.i);
        localawws.b().setImageDrawable((Drawable)localObject2);
        if ((((URLDrawable)localObject2).getStatus() != 1) && (((URLDrawable)localObject2).getStatus() != 0)) {
          ((URLDrawable)localObject2).restartDownload();
        }
      }
    }
    for (;;)
    {
      localawws.a().setOnClickListener(new awsc(this, (awol)localObject1));
      if ((localawws.a() != null) && (((awol)localObject1).c()))
      {
        paramawxe = ((awol)localObject1).h();
        localObject1 = new ColorDrawable(Color.parseColor("#e7e7e7"));
        localObject2 = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject2).mRequestWidth = bawz.a(paramawoy, 40.0F);
        ((URLDrawable.URLDrawableOptions)localObject2).mRequestHeight = bawz.a(paramawoy, 12.0F);
        ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = ((Drawable)localObject1);
        ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = ((Drawable)localObject1);
        paramawxe = URLDrawable.getDrawable(paramawxe, (URLDrawable.URLDrawableOptions)localObject2);
        paramawxe.setTag(bavi.b(bawz.a(paramawoy, 38.0F), bawz.a(paramawoy, 12.0F), 0));
        paramawxe.setDecodeHandler(bavi.i);
        localawws.a().setImageDrawable(paramawxe);
        if ((paramawxe.getStatus() != 1) && (paramawxe.getStatus() != 0)) {
          paramawxe.restartDownload();
        }
      }
      return;
      label559:
      if ((localawws.c() != null) && (!TextUtils.isEmpty(((awol)localObject1).c())))
      {
        localawws.c().setVisibility(0);
        localawws.c().setText(((awol)localObject1).c());
      }
      for (;;)
      {
        if (localawws.a() != null) {
          localawws.a().setVisibility(0);
        }
        localObject2 = localawws.e();
        if (localObject2 != null) {
          ((TextView)localObject2).setVisibility(8);
        }
        if (TextUtils.isEmpty(((awol)localObject1).a())) {
          break;
        }
        localawws.a().setText(((awol)localObject1).a());
        break;
        if (localawws.c() != null) {
          localawws.c().setVisibility(8);
        }
      }
      label684:
      localawws.b().setImageDrawable((Drawable)localObject3);
    }
  }
  
  protected void a(awpb paramawpb, awxk paramawxk)
  {
    Object localObject1 = paramawxk.a().getContext();
    if (ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null))
    {
      paramawxk.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#737373"));
      paramawxk.jdField_b_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#4A4A4A"));
      if (TextUtils.isEmpty(paramawpb.jdField_b_of_type_JavaLangString)) {
        break label290;
      }
      Object localObject2 = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
      ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
      ((URLDrawable.URLDrawableOptions)localObject2).mRequestWidth = bawz.a((Context)localObject1, 18.0F);
      ((URLDrawable.URLDrawableOptions)localObject2).mRequestHeight = bawz.a((Context)localObject1, 18.0F);
      ((URLDrawable.URLDrawableOptions)localObject2).mMemoryCacheKeySuffix = "askIcon";
      localObject2 = URLDrawable.getDrawable(paramawpb.jdField_b_of_type_JavaLangString, (URLDrawable.URLDrawableOptions)localObject2);
      paramawxk.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable((Drawable)localObject2);
      if ((((URLDrawable)localObject2).getStatus() != 1) && (((URLDrawable)localObject2).getStatus() != 0)) {
        ((URLDrawable)localObject2).restartDownload();
      }
      paramawxk.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(0);
    }
    label290:
    for (;;)
    {
      label166:
      if (!TextUtils.isEmpty(paramawpb.j))
      {
        int j = paramawxk.jdField_a_of_type_AndroidWidgetTextView.getContext().getResources().getDisplayMetrics().widthPixels;
        int i = (int)awvy.a(paramawxk.jdField_a_of_type_AndroidWidgetTextView, " ");
        int k = bawz.a((Context)localObject1, 22.0F) / i;
        localObject1 = "";
        i = 0;
        for (;;)
        {
          if (i < k)
          {
            localObject1 = (String)localObject1 + " ";
            i += 1;
            continue;
            paramawxk.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#262626"));
            paramawxk.jdField_b_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#737373"));
            break;
            paramawxk.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(8);
            break label166;
          }
        }
        localObject1 = awvy.a(paramawxk.jdField_a_of_type_AndroidWidgetTextView, j, 2, (String)localObject1 + paramawpb.j, paramawpb.jdField_a_of_type_Awvn.jdField_a_of_type_JavaUtilList, false, false, true);
        paramawxk.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject1);
      }
    }
    paramawxk.a(paramawpb);
    if ((!TextUtils.isEmpty(paramawpb.k)) && (paramawpb.jdField_a_of_type_JavaUtilList != null) && (paramawpb.jdField_a_of_type_JavaUtilList.size() != 0))
    {
      paramawxk.jdField_b_of_type_AndroidWidgetTextView.setText(paramawpb.k);
      paramawxk.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      return;
    }
    paramawxk.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
  }
  
  protected void a(awpe paramawpe, awxo paramawxo)
  {
    if (!TextUtils.isEmpty(paramawpe.jdField_b_of_type_JavaLangString))
    {
      paramawxo.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(0);
      Object localObject = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
      ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
      ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = paramawxo.jdField_a_of_type_ComTencentImageURLImageView.getLayoutParams().width;
      ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = paramawxo.jdField_a_of_type_ComTencentImageURLImageView.getLayoutParams().height;
      localObject = URLDrawable.getDrawable(paramawpe.jdField_b_of_type_JavaLangString, (URLDrawable.URLDrawableOptions)localObject);
      paramawxo.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable((Drawable)localObject);
      if ((((URLDrawable)localObject).getStatus() != 1) && (((URLDrawable)localObject).getStatus() != 0)) {
        ((URLDrawable)localObject).restartDownload();
      }
      if (TextUtils.isEmpty(paramawpe.j)) {
        break label345;
      }
      paramawxo.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      int i = paramawxo.jdField_a_of_type_AndroidWidgetTextView.getContext().getResources().getDisplayMetrics().widthPixels;
      localObject = awvy.a(paramawxo.jdField_a_of_type_AndroidWidgetTextView, i, 1, paramawpe.j, paramawpe.jdField_a_of_type_Awvn.jdField_a_of_type_JavaUtilList, false, false, true);
      paramawxo.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
      label183:
      if (TextUtils.isEmpty(paramawpe.l)) {
        break label357;
      }
      paramawxo.jdField_b_of_type_AndroidWidgetTextView.setText(paramawpe.l);
      paramawxo.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      paramawxo.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      label220:
      if (TextUtils.isEmpty(paramawpe.k)) {
        break label378;
      }
      paramawxo.c.setText(paramawpe.k);
      paramawxo.c.setVisibility(0);
    }
    for (;;)
    {
      if (!ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null)) {
        break label390;
      }
      paramawxo.jdField_a_of_type_AndroidWidgetTextView.setTextColor(paramawxo.jdField_a_of_type_AndroidWidgetTextView.getContext().getResources().getColor(2131166792));
      paramawxo.c.setTextColor(paramawxo.c.getContext().getResources().getColor(2131166791));
      paramawxo.jdField_b_of_type_AndroidWidgetTextView.setTextColor(paramawxo.jdField_b_of_type_AndroidWidgetTextView.getContext().getResources().getColor(2131166791));
      return;
      paramawxo.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(8);
      break;
      label345:
      paramawxo.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      break label183;
      label357:
      paramawxo.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      paramawxo.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      break label220;
      label378:
      paramawxo.c.setVisibility(8);
    }
    label390:
    paramawxo.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#262626"));
    paramawxo.c.setTextColor(Color.parseColor("#737373"));
    paramawxo.jdField_b_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#737373"));
  }
  
  public void a(SquareImageView paramSquareImageView, ImageView paramImageView, TextView paramTextView, int paramInt1, int paramInt2, boolean paramBoolean1, String paramString1, String paramString2, int paramInt3, boolean paramBoolean2)
  {
    ViewGroup.LayoutParams localLayoutParams = paramSquareImageView.getLayoutParams();
    if ((paramSquareImageView.getContext() instanceof PublicAcntSearchActivity))
    {
      localLayoutParams.width = bawz.a(paramSquareImageView.getContext(), 50.0F);
      localLayoutParams.height = bawz.a(paramSquareImageView.getContext(), 50.0F);
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
          paramTextView.setDecodeHandler(bavi.a);
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
  
  protected void b(awop paramawop, awww paramawww)
  {
    if (paramawww.a() != null) {
      paramawww.a().setOnClickListener(new awsb(this, paramawop));
    }
  }
  
  public void c(awop paramawop, awww paramawww)
  {
    if ((paramawww.b() != null) && ((paramawop instanceof awod)) && (!TextUtils.isEmpty(paramawop.b()))) {
      paramawww.b().setImageDrawable(awvy.a(this.jdField_a_of_type_Baxk, paramawop));
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
      awvy.jdField_a_of_type_Long = this.jdField_a_of_type_Long;
      localImageView.post(new SearchTemplatePresenter.11(this, localImageView, bool));
      localImageView.setContentDescription(localResources.getString(2131690275));
      this.jdField_a_of_type_Awkf.notifyDataSetChanged();
      return;
    }
    localImageView.post(new SearchTemplatePresenter.12(this, localImageView, bool));
    localImageView.setContentDescription(localResources.getString(2131690273));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awsa
 * JD-Core Version:    0.7.0.1
 */