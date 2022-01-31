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

public class awsc
  implements asvw, awrc<awor, awwy>
{
  public static int a;
  private long jdField_a_of_type_Long;
  public ColorDrawable a;
  public Drawable a;
  private awkh jdField_a_of_type_Awkh;
  private baxy jdField_a_of_type_Baxy;
  private WeakReference<ImageView> jdField_a_of_type_JavaLangRefWeakReference;
  
  public awsc(baxy parambaxy, awkh paramawkh)
  {
    this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable = new ColorDrawable(Color.parseColor("#e7e7e7"));
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = aywm.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
    this.jdField_a_of_type_Baxy = parambaxy;
    this.jdField_a_of_type_Awkh = paramawkh;
  }
  
  private float a(String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      return 7.0F;
    }
    return 3.5F;
  }
  
  private int a(awph paramawph, awxr paramawxr)
  {
    if ((paramawph == null) || (paramawph.jdField_a_of_type_Awpi == null) || (paramawxr == null) || (paramawxr.jdField_a_of_type_AndroidWidgetRelativeLayout == null))
    {
      if ((paramawxr != null) && (paramawxr.jdField_a_of_type_AndroidWidgetButton != null)) {
        paramawxr.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
      }
      if ((paramawxr != null) && (paramawxr.jdField_a_of_type_AndroidWidgetImageView != null)) {
        paramawxr.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      }
      return 0;
    }
    if (paramawph.jdField_a_of_type_Awpi.jdField_a_of_type_Int == 1)
    {
      if (paramawxr.jdField_a_of_type_AndroidWidgetButton != null) {
        paramawxr.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
      }
      if (paramawxr.jdField_a_of_type_AndroidWidgetImageView != null) {
        paramawxr.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      }
      return 0;
    }
    boolean bool = ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null);
    Context localContext = paramawxr.jdField_a_of_type_AndroidWidgetRelativeLayout.getContext();
    int i;
    if (paramawph.jdField_a_of_type_Awpi.jdField_a_of_type_Int == 2)
    {
      if (paramawxr.jdField_a_of_type_AndroidWidgetImageView != null) {
        paramawxr.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      }
      if (paramawxr.jdField_a_of_type_AndroidWidgetButton == null) {
        return 0;
      }
      if (!TextUtils.isEmpty(paramawph.jdField_a_of_type_Awpi.jdField_a_of_type_JavaLangCharSequence))
      {
        paramawxr.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
        paramawxr.jdField_a_of_type_AndroidWidgetButton.setText(paramawph.jdField_a_of_type_Awpi.jdField_a_of_type_JavaLangCharSequence);
        paramawxr.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(new awsj(this, localContext, paramawph));
      }
      for (;;)
      {
        i = (int)(0 + (awwa.a(paramawxr.jdField_a_of_type_AndroidWidgetButton, paramawph.jdField_a_of_type_Awpi.jdField_a_of_type_JavaLangCharSequence) + baxn.a(localContext, 32.0F) + baxn.a(localContext, 15.0F)));
        if (!bool) {
          break;
        }
        paramawxr.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130842696);
        paramawxr.jdField_a_of_type_AndroidWidgetButton.setTextColor(Color.parseColor("#6991B8"));
        return i;
        paramawxr.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
      }
      paramawxr.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130842695);
      paramawxr.jdField_a_of_type_AndroidWidgetButton.setTextColor(Color.parseColor("#000000"));
      return i;
    }
    int j;
    if (paramawph.jdField_a_of_type_Awpi.jdField_a_of_type_Int == 3)
    {
      if (paramawxr.jdField_a_of_type_AndroidWidgetButton != null) {
        paramawxr.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
      }
      if ((paramawxr.jdField_a_of_type_AndroidWidgetRelativeLayout == null) || (paramawxr.jdField_a_of_type_AndroidWidgetImageView == null)) {
        return 0;
      }
      int k = ((Integer)paramawxr.a().getTag(2131379214)).intValue();
      SongInfo localSongInfo1 = new SongInfo();
      i = 0;
      j = i;
      for (;;)
      {
        try
        {
          JSONObject localJSONObject = new JSONObject(paramawph.h);
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
          awwa.jdField_a_of_type_Long = localSongInfo2.jdField_a_of_type_Long;
          continue;
          paramawxr.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130848583);
          continue;
          if (this.jdField_a_of_type_Long != awwa.jdField_a_of_type_Long) {
            continue;
          }
          paramawxr.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130848584);
          continue;
          paramawxr.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130848582);
          continue;
          paramawxr.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
          continue;
        }
        this.jdField_a_of_type_Long = localSongInfo1.jdField_a_of_type_Long;
        QQPlayerService.a(this);
        if (QQPlayerService.a() == 2) {
          continue;
        }
        awwa.jdField_a_of_type_Long = -1L;
        if (!bool) {
          continue;
        }
        if (this.jdField_a_of_type_Long != awwa.jdField_a_of_type_Long) {
          continue;
        }
        paramawxr.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130848585);
        if ((j == 0) || (i == 0) || (TextUtils.isEmpty(localSongInfo1.jdField_a_of_type_JavaLangString))) {
          continue;
        }
        paramawxr.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        paramawxr.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(new awsk(this, paramawxr, k, localContext, bool, localSongInfo1, paramawph));
        return baxn.a(localContext, 39.0F) + 0;
        i = 0;
        continue;
        j = 0;
      }
    }
    paramawxr.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
    return 0;
  }
  
  private int a(awph paramawph, awxr paramawxr, int paramInt1, int paramInt2)
  {
    if ((paramawxr == null) || (paramawph == null) || (paramawxr.jdField_a_of_type_AndroidWidgetLinearLayout == null)) {
      return 0;
    }
    Context localContext = paramawxr.jdField_a_of_type_AndroidWidgetLinearLayout.getContext();
    int i = localContext.getResources().getDisplayMetrics().widthPixels - paramInt1 - paramInt2 - baxn.a(localContext, 30.0F);
    if ((paramawph.jdField_a_of_type_JavaUtilArrayList != null) && (paramawph.jdField_a_of_type_JavaUtilArrayList.size() > 0))
    {
      paramawxr.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      if ((paramawph.jdField_a_of_type_Awpj != null) && (paramawph.jdField_a_of_type_JavaUtilArrayList != null) && (paramawph.jdField_a_of_type_JavaUtilArrayList.size() > 0))
      {
        paramawxr.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(0);
        if (paramawxr.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView != null) {
          paramawxr.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView.setVisibility(8);
        }
        if (paramawph.jdField_a_of_type_Awpj.jdField_a_of_type_Int == 1)
        {
          if (paramawxr.jdField_b_of_type_AndroidWidgetTextView != null) {
            paramawxr.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
          }
          if ((paramawxr.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView == null) || (TextUtils.isEmpty(paramawph.jdField_a_of_type_Awpj.jdField_a_of_type_JavaLangString))) {
            break label1007;
          }
          paramawxr.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView.setVisibility(0);
          a(paramawxr.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView, paramawph.jdField_a_of_type_Awpj.jdField_a_of_type_JavaLangString);
          paramInt1 = i - baxn.a(localContext, 24.0F);
        }
      }
    }
    for (;;)
    {
      Object localObject1;
      if ((paramawxr.jdField_a_of_type_AndroidWidgetTextView != null) && (!TextUtils.isEmpty(((awpk)paramawph.jdField_a_of_type_JavaUtilArrayList.get(0)).jdField_a_of_type_JavaLangCharSequence)))
      {
        localObject1 = ((awpk)paramawph.jdField_a_of_type_JavaUtilArrayList.get(0)).jdField_a_of_type_JavaLangCharSequence;
        if (!((awpk)paramawph.jdField_a_of_type_JavaUtilArrayList.get(0)).jdField_a_of_type_Boolean) {
          break label635;
        }
        localObject1 = awwa.a(paramawxr.jdField_a_of_type_AndroidWidgetTextView, paramInt1, 1, ((CharSequence)localObject1).toString(), paramawph.jdField_a_of_type_Awvp.jdField_a_of_type_JavaUtilList, false, false, true);
        label297:
        paramawxr.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject1);
      }
      for (paramInt1 = 1;; paramInt1 = 0)
      {
        if (paramawxr.c != null) {
          break label677;
        }
        return paramawxr.jdField_a_of_type_AndroidWidgetLinearLayout.getHeight();
        if (paramawph.jdField_a_of_type_Awpj.jdField_a_of_type_Int == 2)
        {
          if (paramawxr.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView != null) {
            paramawxr.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView.setVisibility(8);
          }
          if ((paramawxr.jdField_b_of_type_AndroidWidgetTextView == null) || (TextUtils.isEmpty(paramawph.jdField_a_of_type_Awpj.jdField_a_of_type_JavaLangCharSequence))) {
            break label1007;
          }
          if (awwa.d(paramawph.jdField_a_of_type_Awpj.jdField_b_of_type_JavaLangString)) {}
          for (localObject1 = paramawph.jdField_a_of_type_Awpj.jdField_b_of_type_JavaLangString;; localObject1 = "#fd7f32")
          {
            ((GradientDrawable)paramawxr.jdField_b_of_type_AndroidWidgetTextView.getBackground()).setColor(Color.parseColor((String)localObject1));
            paramawxr.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
            paramawxr.jdField_b_of_type_AndroidWidgetTextView.setText(paramawph.jdField_a_of_type_Awpj.jdField_a_of_type_JavaLangCharSequence);
            paramInt1 = (int)(i - (awwa.a(paramawxr.jdField_b_of_type_AndroidWidgetTextView, paramawph.jdField_a_of_type_Awpj.jdField_a_of_type_JavaLangCharSequence) + baxn.a(localContext, 10.0F)));
            break;
          }
        }
        if (paramawph.jdField_a_of_type_Awpj.jdField_a_of_type_Int != 3) {
          break label1007;
        }
        if (paramawxr.jdField_b_of_type_AndroidWidgetTextView != null) {
          paramawxr.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
        }
        if ((paramawxr.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView == null) || (TextUtils.isEmpty(paramawph.jdField_a_of_type_Awpj.jdField_a_of_type_JavaLangString))) {
          break label1007;
        }
        paramawxr.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView.setVisibility(0);
        if ((paramawph.jdField_a_of_type_Awpj.jdField_b_of_type_Int > 0) && (paramawph.jdField_a_of_type_Awpj.jdField_c_of_type_Int > 0))
        {
          a(paramawxr.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView, paramawph.jdField_a_of_type_Awpj.jdField_b_of_type_Int, paramawph.jdField_a_of_type_Awpj.jdField_c_of_type_Int, paramawph.jdField_a_of_type_Awpj.jdField_a_of_type_JavaLangString);
          paramInt1 = i - baxn.a(localContext, baxn.a(localContext, paramawph.jdField_a_of_type_Awpj.jdField_b_of_type_Int) + 4);
          break;
        }
        a(paramawxr.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView, paramawph.jdField_a_of_type_Awpj.jdField_a_of_type_JavaLangString);
        paramInt1 = i - baxn.a(localContext, 24.0F);
        break;
        label635:
        localObject1 = awwa.a(paramawxr.jdField_a_of_type_AndroidWidgetTextView, paramInt1, ((CharSequence)localObject1).toString());
        break label297;
        if (paramawxr.jdField_b_of_type_AndroidWidgetLinearLayout != null) {
          paramawxr.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
        }
      }
      label677:
      paramawxr.c.removeAllViews();
      awpk localawpk;
      TextView localTextView;
      if ((paramawph.jdField_a_of_type_JavaUtilArrayList != null) && (paramawph.jdField_a_of_type_JavaUtilArrayList.size() > 0)) {
        while (paramInt1 < paramawph.jdField_a_of_type_JavaUtilArrayList.size())
        {
          localawpk = (awpk)paramawph.jdField_a_of_type_JavaUtilArrayList.get(paramInt1);
          localTextView = new TextView(localContext);
          a(localTextView, localawpk.jdField_a_of_type_JavaLangString, localawpk.jdField_a_of_type_Int);
          localObject1 = localawpk.jdField_a_of_type_JavaLangCharSequence;
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
        paramInt2 = localawpk.jdField_a_of_type_Int;
        if ((localContext instanceof PublicAcntSearchActivity)) {
          paramInt2 = 1;
        }
        Object localObject2 = localObject1;
        if (localawpk.jdField_a_of_type_Boolean) {
          if ((!localawpk.jdField_a_of_type_JavaLangString.equals("A")) && (!localawpk.jdField_a_of_type_JavaLangString.equals("B"))) {
            break label952;
          }
        }
        for (boolean bool = true;; bool = false)
        {
          localObject2 = awwa.a(localTextView, i, paramInt2, ((CharSequence)localObject1).toString(), paramawph.jdField_a_of_type_Awvp.jdField_a_of_type_JavaUtilList, false, bool, true);
          if (paramInt1 != 0) {
            localTextView.setPadding(0, baxn.a(localContext, 7.0F - a(((awpk)paramawph.jdField_a_of_type_JavaUtilArrayList.get(paramInt1 - 1)).jdField_a_of_type_JavaLangString, localawpk.jdField_a_of_type_JavaLangString)), 0, 0);
          }
          localTextView.setText((CharSequence)localObject2);
          paramawxr.c.addView(localTextView);
          break;
        }
        paramawxr.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
        b(paramawph, paramawxr);
        paramInt1 = View.MeasureSpec.makeMeasureSpec(0, 0);
        paramInt2 = View.MeasureSpec.makeMeasureSpec(0, 0);
        paramawxr.jdField_a_of_type_AndroidWidgetLinearLayout.measure(paramInt1, paramInt2);
        return paramawxr.jdField_a_of_type_AndroidWidgetLinearLayout.getMeasuredHeight();
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
      if (!awwa.d(paramString)) {
        localObject = "#F1F1F1";
      }
    }
  }
  
  public static Pair<Integer, Integer> a(awor paramawor, awwy paramawwy, boolean paramBoolean, int paramInt)
  {
    if ((paramawwy == null) || (paramawwy.jdField_b_of_type_AndroidWidgetRelativeLayout == null) || (paramawwy.jdField_b_of_type_ComTencentMobileqqWidgetSquareImageView == null) || (paramawor == null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.uniteSearch.SearchTemplatePresenter", 2, "bindUniversalTemplateLeftImageview or item is null");
      }
      return new Pair(Integer.valueOf(0), Integer.valueOf(0));
    }
    SquareImageView localSquareImageView = paramawwy.jdField_b_of_type_ComTencentMobileqqWidgetSquareImageView;
    awos localawos = paramawor.jdField_a_of_type_Awos;
    if ((localawos == null) || (TextUtils.isEmpty(localawos.jdField_a_of_type_JavaLangString)))
    {
      paramawwy.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      return new Pair(Integer.valueOf(0), Integer.valueOf(0));
    }
    paramawwy.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
    Object localObject = localSquareImageView.getContext();
    paramawor = a(localSquareImageView, localawos.jdField_a_of_type_Int, localawos.jdField_a_of_type_JavaLangString, localawos.jdField_b_of_type_Int, paramBoolean, paramInt, paramawor);
    paramInt = ((Integer)paramawor.first).intValue();
    int i = ((Integer)paramawor.second).intValue();
    paramawor = localSquareImageView.getLayoutParams();
    paramawor.width = paramInt;
    paramawor.height = i;
    localSquareImageView.setLayoutParams(paramawor);
    paramawor = (RelativeLayout.LayoutParams)paramawwy.jdField_b_of_type_AndroidWidgetRelativeLayout.getLayoutParams();
    paramawor.width = paramInt;
    paramawor.height = i;
    paramawwy.jdField_b_of_type_AndroidWidgetRelativeLayout.setLayoutParams(paramawor);
    int j = baxn.a((Context)localObject, 10.0F);
    if ((!TextUtils.isEmpty(localawos.jdField_a_of_type_JavaLangCharSequence)) && (paramawwy.e != null)) {
      if (awwa.d(localawos.jdField_b_of_type_JavaLangString))
      {
        paramawor = localawos.jdField_b_of_type_JavaLangString;
        ((GradientDrawable)paramawwy.e.getBackground()).setColor(Color.parseColor(paramawor));
        paramawwy.e.setVisibility(0);
        paramawwy.e.setText(localawos.jdField_a_of_type_JavaLangCharSequence);
        label303:
        if (paramawwy.jdField_c_of_type_AndroidWidgetImageView != null)
        {
          if (!localawos.jdField_a_of_type_Boolean) {
            break label565;
          }
          paramawwy.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
        }
        label326:
        if (paramawwy.f != null)
        {
          if (TextUtils.isEmpty(localawos.jdField_b_of_type_JavaLangCharSequence)) {
            break label577;
          }
          paramawwy.f.setVisibility(0);
          paramawwy.f.setText(localawos.jdField_b_of_type_JavaLangCharSequence);
        }
        label364:
        if (paramawwy.jdField_c_of_type_ComTencentMobileqqWidgetSquareImageView != null)
        {
          if (TextUtils.isEmpty(localawos.jdField_c_of_type_JavaLangString)) {
            break label589;
          }
          paramawwy.jdField_c_of_type_ComTencentMobileqqWidgetSquareImageView.setVisibility(0);
          paramawor = URLDrawable.URLDrawableOptions.obtain();
          localObject = new ColorDrawable(-1);
          paramawor.mFailedDrawable = ((Drawable)localObject);
          paramawor.mLoadingDrawable = ((Drawable)localObject);
          paramawor.mRequestWidth = paramawwy.jdField_c_of_type_ComTencentMobileqqWidgetSquareImageView.getLayoutParams().width;
          paramawor.mRequestHeight = paramawwy.jdField_c_of_type_ComTencentMobileqqWidgetSquareImageView.getLayoutParams().height;
          paramawor = URLDrawable.getDrawable(localawos.jdField_c_of_type_JavaLangString, paramawor);
          if ((paramawor.getStatus() != 1) && (paramawor.getStatus() != 0)) {
            paramawor.restartDownload();
          }
          paramawwy.jdField_c_of_type_ComTencentMobileqqWidgetSquareImageView.setImageDrawable(paramawor);
        }
        label481:
        if (paramawwy.g != null)
        {
          if (TextUtils.isEmpty(localawos.jdField_c_of_type_JavaLangCharSequence)) {
            break label601;
          }
          paramawwy.g.setVisibility(0);
          paramawwy.g.setText(localawos.jdField_c_of_type_JavaLangCharSequence);
        }
      }
    }
    for (;;)
    {
      return new Pair(Integer.valueOf(paramInt + j), Integer.valueOf(i));
      paramawor = "#fd7f32";
      break;
      if (paramawwy.e == null) {
        break label303;
      }
      paramawwy.e.setVisibility(8);
      break label303;
      label565:
      paramawwy.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
      break label326;
      label577:
      paramawwy.f.setVisibility(8);
      break label364;
      label589:
      paramawwy.jdField_c_of_type_ComTencentMobileqqWidgetSquareImageView.setVisibility(8);
      break label481;
      label601:
      paramawwy.g.setVisibility(8);
    }
  }
  
  public static Pair<Integer, Integer> a(SquareImageView paramSquareImageView, int paramInt1, String paramString, int paramInt2, boolean paramBoolean, int paramInt3, awor paramawor)
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
      paramInt1 = baxn.a((Context)localObject, 60.0F);
      i = baxn.a((Context)localObject, 60.0F);
      j = 0;
      localColorDrawable = new ColorDrawable(Color.parseColor("#e7e7e7"));
      if (paramBoolean)
      {
        paramInt1 = (int)(i * 1.0F / paramInt1 * paramInt3);
        if (j != 0)
        {
          i = (int)(paramInt3 * 0.2D / 2.0D);
          paramSquareImageView.setPadding(baxn.a((Context)localObject, 3.0F), baxn.a((Context)localObject, 3.0F), baxn.a((Context)localObject, 3.0F), baxn.a((Context)localObject, 3.0F));
          paramawor = (RelativeLayout.LayoutParams)paramSquareImageView.getLayoutParams();
          i -= baxn.a((Context)localObject, 3.0F);
          paramawor.rightMargin = i;
          paramawor.leftMargin = i;
          paramawor.topMargin = i;
          paramSquareImageView.setLayoutParams(paramawor);
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
          paramawor = URLDrawable.URLDrawableOptions.obtain();
          paramawor.mRequestWidth = paramInt3;
          paramawor.mRequestHeight = paramInt1;
          if (j == 0) {
            continue;
          }
          localObject = new GradientDrawable();
          ((GradientDrawable)localObject).setShape(0);
          ((GradientDrawable)localObject).setCornerRadius(paramInt3 / 2.0F);
          ((GradientDrawable)localObject).setColor(-1579033);
          paramawor.mLoadingDrawable = ((Drawable)localObject);
          paramawor.mFailedDrawable = ((Drawable)localObject);
          paramawor.mPlayGifImage = true;
          if (j == 0) {
            continue;
          }
          paramawor.mMemoryCacheKeySuffix = ("isAvatar" + paramInt3 + paramInt1);
          paramawor = URLDrawable.getDrawable(paramString, paramawor);
          paramawor.setDecodeHandler(bavw.a);
        }
        catch (Exception paramawor)
        {
          QLog.e("Q.uniteSearch.SearchTemplatePresenter", 1, "imageUrl is not valid. imageUrl=" + paramString, paramawor);
          localObject = localColorDrawable;
          continue;
          paramawor.mMemoryCacheKeySuffix = ("isNotAvatar" + paramInt3 + paramInt1 + paramInt2);
          paramawor = URLDrawable.getDrawable(paramString, paramawor);
          paramawor.setTag(bavw.b(paramInt3, paramInt1, paramInt2));
          paramawor.setDecodeHandler(bavw.i);
          continue;
        }
        localObject = paramawor;
        if (paramawor.getStatus() != 1)
        {
          localObject = paramawor;
          if (paramawor.getStatus() != 0)
          {
            paramawor.restartDownload();
            localObject = paramawor;
          }
        }
        paramSquareImageView.setImageDrawable((Drawable)localObject);
        return new Pair(Integer.valueOf(paramInt3), Integer.valueOf(paramInt1));
        paramInt1 = baxn.a((Context)localObject, 60.0F);
        i = baxn.a((Context)localObject, 60.0F);
        j = 0;
        break;
        paramInt1 = baxn.a((Context)localObject, 50.0F);
        i = baxn.a((Context)localObject, 50.0F);
        j = 0;
        break;
        if ((paramSquareImageView.getContext() instanceof PublicAcntSearchActivity))
        {
          paramInt1 = baxn.a(paramSquareImageView.getContext(), 50.0F);
          i = baxn.a(paramSquareImageView.getContext(), 50.0F);
          j = 1;
          break;
        }
        paramInt1 = baxn.a((Context)localObject, 60.0F);
        i = baxn.a((Context)localObject, 60.0F);
        continue;
        paramInt1 = baxn.a((Context)localObject, 50.0F);
        i = baxn.a((Context)localObject, 50.0F);
        j = 1;
        break;
        paramInt1 = baxn.a((Context)localObject, 60.0F);
        i = baxn.a((Context)localObject, 85.0F);
        j = 0;
        break;
        paramInt1 = baxn.a((Context)localObject, 113.0F);
        i = baxn.a((Context)localObject, 60.0F);
        j = 0;
        break;
        paramInt1 = baxn.a((Context)localObject, 100.0F);
        i = baxn.a((Context)localObject, 141.0F);
        j = 0;
        break;
        paramInt1 = j;
        if ((paramawor instanceof awph))
        {
          paramInt1 = baxn.a((Context)localObject, paramawor.jdField_a_of_type_Awos.jdField_c_of_type_Int / 2);
          i = baxn.a((Context)localObject, paramawor.jdField_a_of_type_Awos.d / 2);
        }
        if ((paramInt2 == paramawor.jdField_a_of_type_Awos.jdField_c_of_type_Int / 2) && (paramInt2 == paramawor.jdField_a_of_type_Awos.d / 2))
        {
          j = 1;
          break;
        }
        j = 0;
        break;
        paramInt1 = baxn.a((Context)localObject, 220.0F);
        i = baxn.a((Context)localObject, 136.0F);
        j = 0;
        break;
        paramInt1 = baxn.a((Context)localObject, 162.0F);
        i = baxn.a((Context)localObject, 162.0F);
        j = 0;
        break;
        paramInt1 = baxn.a((Context)localObject, 162.0F);
        i = baxn.a((Context)localObject, 228.0F);
        j = 0;
        break;
        paramInt1 = baxn.a((Context)localObject, 162.0F);
        i = baxn.a((Context)localObject, 162.0F);
        j = 1;
        break;
        paramawor.mFailedDrawable = localColorDrawable;
        paramawor.mLoadingDrawable = localColorDrawable;
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
  
  private void a(awop paramawop, awww paramawww)
  {
    Object localObject1 = BaseApplicationImpl.getApplication().getRuntime();
    Object localObject3 = paramawww.a().getContext();
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
      paramawww.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#737373"));
      if (!TextUtils.isEmpty(paramawop.jdField_a_of_type_JavaLangCharSequence)) {
        break label593;
      }
      paramawww.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      if (paramawop.jdField_a_of_type_Awok == null) {
        break label775;
      }
      paramawww.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      paramawww.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      i = (int)(bbdh.k() - vzl.a((Context)localObject3, 30.0F)) / 2 - vzl.a((Context)localObject3, 3.0F);
      localObject1 = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject1).mPlayGifImage = true;
      ((URLDrawable.URLDrawableOptions)localObject1).mFailedDrawable = new ColorDrawable(Color.parseColor("#e7e7e7"));
      ((URLDrawable.URLDrawableOptions)localObject1).mLoadingDrawable = new ColorDrawable(Color.parseColor("#e7e7e7"));
      ((URLDrawable.URLDrawableOptions)localObject1).mRequestWidth = i;
      ((URLDrawable.URLDrawableOptions)localObject1).mRequestHeight = i;
      localObject2 = URLDrawable.getDrawable(paramawop.jdField_a_of_type_Awok.jdField_a_of_type_JavaLangString, (URLDrawable.URLDrawableOptions)localObject1);
      paramawww.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable((Drawable)localObject2);
      if ((((URLDrawable)localObject2).getStatus() != 1) && (((URLDrawable)localObject2).getStatus() != 0)) {
        ((URLDrawable)localObject2).restartDownload();
      }
      localObject2 = (LinearLayout.LayoutParams)paramawww.jdField_a_of_type_ComTencentImageURLImageView.getLayoutParams();
      ((LinearLayout.LayoutParams)localObject2).height = i;
      ((LinearLayout.LayoutParams)localObject2).width = i;
      paramawww.jdField_a_of_type_ComTencentImageURLImageView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
      paramawww.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(0);
      if (paramawop.jdField_a_of_type_JavaUtilList == null) {
        return;
      }
      m = Math.min(paramawop.jdField_a_of_type_JavaUtilList.size(), 4);
      n = (i - vzl.a((Context)localObject3, 3.0F)) / 2;
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
      localObject3 = (SquareImageView)paramawww.jdField_b_of_type_AndroidWidgetLinearLayout.findViewById(localObject2[i]);
      localObject4 = ((awok)paramawop.jdField_a_of_type_JavaUtilList.get(i)).jdField_a_of_type_JavaLangString;
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
      if ((i != 3) || (paramawop.jdField_a_of_type_Int <= 4)) {
        break label731;
      }
      ((SquareImageView)localObject3).setFilterColor(Color.parseColor("#66000000"));
      k = paramawop.jdField_a_of_type_Int - 4;
      localObject4 = new StringBuilder().append("+");
      j = k;
      if (k > 99) {
        j = 99;
      }
      ((SquareImageView)localObject3).setFilterText(j);
      ((SquareImageView)localObject3).setFilterTextSize(baxn.a(paramawww.a().getContext(), 20.0F));
    }
    for (;;)
    {
      i += 1;
      break label322;
      paramawww.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#262626"));
      break;
      label593:
      i = (int)(paramawww.jdField_a_of_type_AndroidWidgetTextView.getContext().getResources().getDisplayMetrics().widthPixels - baxn.a(paramawww.jdField_a_of_type_AndroidWidgetTextView.getContext(), 30.0F) - awwa.a(paramawww.jdField_a_of_type_AndroidWidgetTextView, paramawop.jdField_a_of_type_JavaLangString));
      localObject2 = awwa.a(paramawww.jdField_a_of_type_AndroidWidgetTextView, i, 1, paramawop.jdField_a_of_type_JavaLangCharSequence.toString(), paramawop.jdField_a_of_type_Awvp.jdField_a_of_type_JavaUtilList, false, false, true);
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      if (paramawop.jdField_a_of_type_JavaLangString == null) {
        paramawop.jdField_a_of_type_JavaLangString = "";
      }
      paramawww.jdField_a_of_type_AndroidWidgetTextView.setText(new SpannableStringBuilder((CharSequence)localObject1).append(paramawop.jdField_a_of_type_JavaLangString));
      paramawww.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      break label59;
      label731:
      ((SquareImageView)localObject3).setFilterColor(-1);
      ((SquareImageView)localObject3).setFilterText("");
    }
    label748:
    while (i < 4)
    {
      paramawww.jdField_b_of_type_AndroidWidgetLinearLayout.findViewById(localObject2[i]).setVisibility(4);
      i += 1;
    }
    label775:
    paramawww.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    paramawww.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
    if (paramawop.jdField_a_of_type_JavaUtilList != null)
    {
      m = Math.min(paramawop.jdField_a_of_type_JavaUtilList.size(), paramawww.jdField_a_of_type_Int);
      n = (int)(bbdh.k() - vzl.a(paramawww.a().getContext(), (m - 1) * 2 + 27));
      i = 0;
      if (i < m)
      {
        localObject1 = (SquareImageView)paramawww.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(i);
        localObject2 = ((awok)paramawop.jdField_a_of_type_JavaUtilList.get(i)).jdField_a_of_type_JavaLangString;
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
        if (paramawop.jdField_b_of_type_Int != 0)
        {
          ((SquareImageView)localObject1).setImageScale(n / 4 * 1.0F / baxn.a((Context)localObject3, paramawop.jdField_b_of_type_Int / 2), 0.0F);
          label1007:
          ((SquareImageView)localObject1).setVisibility(0);
          if ((i != paramawww.jdField_a_of_type_Int - 1) || (paramawop.jdField_a_of_type_Int <= paramawww.jdField_a_of_type_Int)) {
            break label1136;
          }
          ((SquareImageView)localObject1).setFilterColor(Color.parseColor("#66000000"));
          k = paramawop.jdField_a_of_type_Int - paramawww.jdField_a_of_type_Int;
          localObject2 = new StringBuilder().append("+");
          j = k;
          if (k > 99) {
            j = 99;
          }
          ((SquareImageView)localObject1).setFilterText(j);
          ((SquareImageView)localObject1).setFilterTextSize(baxn.a(paramawww.a().getContext(), 20.0F));
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
      while (i < paramawww.jdField_a_of_type_Int)
      {
        paramawww.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(i).setVisibility(4);
        i += 1;
      }
    }
  }
  
  private void a(awoq paramawoq, awwx paramawwx)
  {
    Object localObject = paramawwx.a().getContext();
    int i;
    if (!TextUtils.isEmpty(paramawoq.i))
    {
      paramawwx.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      a((Context)localObject, (SquareImageView)paramawwx.jdField_a_of_type_AndroidWidgetImageView, paramawwx.jdField_b_of_type_AndroidWidgetImageView, paramawwx.jdField_b_of_type_AndroidWidgetTextView, paramawoq.jdField_a_of_type_Int, paramawoq.i, paramawoq.jdField_b_of_type_JavaLangString, ((Context)localObject).getResources().getDimensionPixelSize(2131298204));
      i = ((Context)localObject).getResources().getDimensionPixelSize(2131298204);
      if ((paramawoq.jdField_a_of_type_Int == 6) || (paramawoq.jdField_a_of_type_Int == 8)) {
        i = baxn.a((Context)localObject, 100.0F);
      }
      if (paramawwx.jdField_a_of_type_AndroidWidgetRelativeLayout.getVisibility() != 8) {
        break label317;
      }
      i = 0;
      label127:
      float f = ((Context)localObject).getResources().getDisplayMetrics().widthPixels - baxn.a((Context)localObject, 30.0F);
      CharSequence localCharSequence = awwa.a(paramawwx.jdField_a_of_type_AndroidWidgetTextView, f, 2, paramawoq.jdField_a_of_type_JavaLangCharSequence.toString(), paramawoq.jdField_a_of_type_Awvp.jdField_a_of_type_JavaUtilList, false, true);
      paramawwx.jdField_a_of_type_AndroidWidgetTextView.setText(localCharSequence);
      f = ((Context)localObject).getResources().getDisplayMetrics().widthPixels - baxn.a((Context)localObject, 30.0F) - i;
      localObject = awwa.a(paramawwx.c, f, 2, paramawoq.jdField_b_of_type_JavaLangCharSequence.toString(), paramawoq.jdField_a_of_type_Awvp.jdField_a_of_type_JavaUtilList, false, false);
      if (!ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null)) {
        break label333;
      }
      paramawwx.c.setTextColor(Color.parseColor("#4A4A4A"));
      paramawwx.jdField_d_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#4A4A4A"));
    }
    for (;;)
    {
      a(paramawwx.c, (CharSequence)localObject, true);
      a(paramawwx.jdField_d_of_type_AndroidWidgetTextView, paramawoq.jdField_c_of_type_JavaLangCharSequence);
      return;
      paramawwx.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      break;
      label317:
      i += baxn.a((Context)localObject, 10.0F);
      break label127;
      label333:
      paramawwx.c.setTextColor(Color.parseColor("#737373"));
      paramawwx.jdField_d_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#737373"));
    }
  }
  
  private void a(awot paramawot, awwz paramawwz)
  {
    Context localContext = paramawwz.a().getContext();
    int j;
    int i;
    if (paramawot.jdField_a_of_type_Int == 1)
    {
      j = baxn.a(localContext, 375.0F);
      i = baxn.a(localContext, 150.0F);
    }
    for (;;)
    {
      int k;
      if ((j == 0) || (i == 0))
      {
        i = baxn.a(localContext, 375.0F);
        j = baxn.a(localContext, 150.0F);
        k = i;
        i = j;
      }
      for (;;)
      {
        if (!TextUtils.isEmpty(paramawot.jdField_b_of_type_JavaLangString))
        {
          localObject = URLDrawable.URLDrawableOptions.obtain();
          ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
          ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
          ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = k;
          ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = i;
          ((URLDrawable.URLDrawableOptions)localObject).mPlayGifImage = true;
          localObject = URLDrawable.getDrawable(paramawot.jdField_b_of_type_JavaLangString, (URLDrawable.URLDrawableOptions)localObject);
          paramawwz.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable((Drawable)localObject);
          if ((((URLDrawable)localObject).getStatus() != 1) && (((URLDrawable)localObject).getStatus() != 0)) {
            ((URLDrawable)localObject).restartDownload();
          }
          label164:
          paramawwz.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(0);
          localObject = (LinearLayout.LayoutParams)paramawwz.jdField_a_of_type_AndroidWidgetRelativeLayout.getLayoutParams();
          ((LinearLayout.LayoutParams)localObject).height = ((int)(i * vzl.a(localContext) * 1.0F / k));
          paramawwz.jdField_a_of_type_AndroidWidgetRelativeLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
          paramawwz.jdField_a_of_type_AndroidWidgetRelativeLayout.setPadding(0, 0, 0, 0);
          if (TextUtils.isEmpty(paramawot.jdField_a_of_type_JavaLangCharSequence)) {
            break label522;
          }
          paramawwz.jdField_b_of_type_AndroidWidgetTextView.setText(paramawot.jdField_a_of_type_JavaLangCharSequence);
          paramawwz.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
          label253:
          if (TextUtils.isEmpty(paramawot.jdField_b_of_type_JavaLangCharSequence)) {
            break label534;
          }
          paramawwz.c.setText(paramawot.jdField_b_of_type_JavaLangCharSequence);
          paramawwz.c.setVisibility(0);
          label282:
          if (TextUtils.isEmpty(paramawot.j)) {
            break label599;
          }
          paramawwz.jdField_d_of_type_AndroidWidgetTextView.setText(paramawot.j);
        }
        try
        {
          if (!paramawot.k.startsWith("#")) {
            paramawot.k = ("#" + paramawot.k);
          }
          paramawwz.jdField_d_of_type_AndroidWidgetTextView.setBackgroundColor(Color.parseColor(paramawot.k));
        }
        catch (Exception localException)
        {
          for (;;)
          {
            label365:
            paramawwz.jdField_d_of_type_AndroidWidgetTextView.setBackgroundColor(Color.parseColor("#FF00FF00"));
            if (QLog.isColorLevel()) {
              QLog.e("Q.uniteSearch.SearchTemplatePresenter", 2, "bigImageItem.topLeftTagColor = " + paramawot.k);
            }
          }
        }
        paramawwz.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
        Object localObject = ((ViewGroup)paramawwz.a()).getChildAt(((ViewGroup)paramawwz.a()).getChildCount() - 1);
        if ((localObject != null) && ((((View)localObject).getLayoutParams() instanceof LinearLayout.LayoutParams)))
        {
          if (paramawot.b() != 0) {
            break label611;
          }
          ((LinearLayout.LayoutParams)((View)localObject).getLayoutParams()).topMargin = 0;
          paramawwz.jdField_a_of_type_AndroidWidgetRelativeLayout.setPadding(0, 0, 0, baxn.a(localContext, 6.0F));
        }
        label522:
        label534:
        label599:
        label611:
        while (paramawot.b() != 2)
        {
          return;
          if (paramawot.jdField_a_of_type_Int == 2)
          {
            j = baxn.a(localContext, 375.0F);
            i = baxn.a(localContext, 180.0F);
            break;
          }
          if (paramawot.jdField_a_of_type_Int != 0) {
            break label639;
          }
          j = baxn.a(localContext, paramawot.jdField_a_of_type_Float / 2.0F);
          i = baxn.a(localContext, paramawot.jdField_b_of_type_Float / 2.0F);
          break;
          paramawwz.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
          break label164;
          paramawwz.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
          break label253;
          paramawwz.c.setVisibility(8);
          break label282;
          paramawwz.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
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
  
  private void a(awov paramawov, awxb paramawxb)
  {
    Object localObject1 = paramawxb.a().getContext();
    Object localObject2 = paramawxb.a();
    if (paramawov.jdField_b_of_type_Boolean) {
      ((View)localObject2).setPadding(((View)localObject2).getPaddingLeft(), vzl.a(((View)localObject2).getContext(), 6.0F), ((View)localObject2).getPaddingRight(), vzl.a(((View)localObject2).getContext(), 6.0F));
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
      ((View)localObject2).setPadding(((View)localObject2).getPaddingLeft(), vzl.a(((View)localObject2).getContext(), 3.0F), ((View)localObject2).getPaddingRight(), vzl.a(((View)localObject2).getContext(), 3.0F));
    }
    if (!((List)localObject3).isEmpty())
    {
      if (paramawov.jdField_c_of_type_Boolean)
      {
        i = 0;
        while (i < ((List)localObject3).size())
        {
          ((SquareImageView)((List)localObject3).get(i)).setRoundRect(vzl.a((Context)localObject1, 4.0F));
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
    if (!TextUtils.isEmpty(paramawov.i)) {
      a((Context)localObject1, (SquareImageView)paramawxb.b(), paramawxb.jdField_b_of_type_AndroidWidgetImageView, paramawxb.jdField_a_of_type_AndroidWidgetTextView, paramawov.jdField_a_of_type_Int, paramawov.i, null, baxn.a((Context)localObject1, 32.0F));
    }
    label687:
    Object localObject5;
    if (!TextUtils.isEmpty(paramawov.jdField_a_of_type_JavaLangString))
    {
      localObject2 = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
      ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
      ((URLDrawable.URLDrawableOptions)localObject2).mRequestWidth = paramawxb.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams().width;
      ((URLDrawable.URLDrawableOptions)localObject2).mRequestHeight = paramawxb.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams().height;
      localObject2 = URLDrawable.getDrawable(paramawov.jdField_a_of_type_JavaLangString, (URLDrawable.URLDrawableOptions)localObject2);
      paramawxb.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject2);
      if ((((URLDrawable)localObject2).getStatus() != 1) && (((URLDrawable)localObject2).getStatus() != 0)) {
        ((URLDrawable)localObject2).restartDownload();
      }
      paramawxb.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      i = ((Context)localObject1).getResources().getDimensionPixelSize(2131298204);
      if ((paramawov.jdField_a_of_type_Int == 6) || (paramawov.jdField_a_of_type_Int == 8)) {
        i = baxn.a((Context)localObject1, 100.0F);
      }
      localObject2 = awwa.a(paramawxb.a(), 10.0F * awwa.a(paramawxb.a(), ajya.a(2131713672)), 1, paramawov.jdField_a_of_type_JavaLangCharSequence.toString(), paramawov.jdField_a_of_type_Awvp.jdField_a_of_type_JavaUtilList, false, false, true);
      paramawxb.a().setText((CharSequence)localObject2);
      paramawxb.a().setEllipsize(null);
      float f1 = ((Context)localObject1).getResources().getDisplayMetrics().widthPixels - baxn.a((Context)localObject1, 40.0F) - i;
      localObject2 = awwa.a(paramawxb.b(), f1, 2, paramawov.jdField_b_of_type_JavaLangCharSequence.toString(), "", false, false, true);
      a(paramawxb.b(), (CharSequence)localObject2, false);
      if (TextUtils.isEmpty(paramawov.jdField_c_of_type_JavaLangCharSequence)) {
        break label1047;
      }
      f1 = ((Context)localObject1).getResources().getDisplayMetrics().widthPixels - baxn.a((Context)localObject1, 30.0F);
      localObject2 = awwa.a(paramawxb.c(), f1, 2, paramawov.jdField_c_of_type_JavaLangCharSequence.toString(), paramawov.jdField_a_of_type_Awvp.jdField_a_of_type_JavaUtilList, false, false);
      paramawxb.c().setText((CharSequence)localObject2);
      paramawxb.c().setVisibility(0);
      if (paramawov.jdField_a_of_type_JavaUtilList == null) {
        break label1479;
      }
      if (paramawov.jdField_a_of_type_JavaUtilList.size() != 1) {
        break label1071;
      }
      paramawxb.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(0);
      paramawxb.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      localObject3 = paramawxb.a().getResources();
      if (jdField_a_of_type_Int == 0) {
        jdField_a_of_type_Int = ((Resources)localObject3).getDisplayMetrics().widthPixels;
      }
      localObject2 = paramawxb.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView;
      ((SquareImageView)localObject2).setImageScale((float)(1.0D / paramawov.jdField_a_of_type_Double), 0.0F);
      f1 = ((Resources)localObject3).getDimension(2131298197);
      float f2 = ((Resources)localObject3).getDimension(2131298197);
      i = baxn.a(paramawxb.a().getContext(), 2.0F);
      j = paramawxb.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount();
      j = (int)(jdField_a_of_type_Int - f1 - f2 - (j - 1) * i) / j;
      i = (int)(j * paramawov.jdField_b_of_type_Double);
      j = (int)(j * paramawov.jdField_b_of_type_Double);
      ((SquareImageView)localObject2).setLayoutParams(new FrameLayout.LayoutParams(i, j));
      localObject3 = (awok)paramawov.jdField_a_of_type_JavaUtilList.get(0);
      localObject4 = ((awok)localObject3).jdField_a_of_type_JavaLangString;
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
      if (((awok)localObject3).jdField_a_of_type_Int != 2) {
        break label1059;
      }
      paramawxb.jdField_d_of_type_AndroidWidgetImageView.setVisibility(0);
    }
    for (;;)
    {
      if ((paramawov.jdField_c_of_type_JavaUtilList != null) || (!TextUtils.equals(paramawov.k, "0")) || (!TextUtils.equals(paramawov.m, "0"))) {
        break label1500;
      }
      paramawxb.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      return;
      paramawxb.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      break;
      label1047:
      paramawxb.c().setVisibility(8);
      break label687;
      label1059:
      paramawxb.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
      continue;
      label1071:
      paramawxb.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(8);
      paramawxb.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      int m = paramawxb.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount();
      i = 0;
      j = i;
      if (i < paramawov.jdField_a_of_type_JavaUtilList.size())
      {
        j = i;
        if (i < m)
        {
          localObject3 = paramawxb.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(i);
          ((View)localObject3).setVisibility(0);
          localObject2 = (SquareImageView)((View)localObject3).findViewById(2131367872);
          localObject3 = (ImageView)((View)localObject3).findViewById(2131368889);
          ((SquareImageView)localObject2).setImageScale((float)(1.0D / paramawov.jdField_a_of_type_Double), 0.0F);
          localObject4 = (awok)paramawov.jdField_a_of_type_JavaUtilList.get(i);
          localObject5 = ((awok)localObject4).jdField_a_of_type_JavaLangString;
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
          if (((awok)localObject4).jdField_a_of_type_Int == 2)
          {
            ((ImageView)localObject3).setVisibility(0);
            label1312:
            if ((i != m - 1) || (paramawov.jdField_b_of_type_Int <= m)) {
              break label1433;
            }
            ((ImageView)localObject3).setVisibility(8);
            ((SquareImageView)localObject2).setFilterColor(Color.parseColor("#66000000"));
            int k = paramawov.jdField_b_of_type_Int - m;
            j = k;
            if (k > 99) {
              j = 99;
            }
            ((SquareImageView)localObject2).setFilterText("+" + j);
            ((SquareImageView)localObject2).setFilterTextSize(baxn.a(((SquareImageView)localObject2).getContext(), 20.0F));
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
        paramawxb.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(j).setVisibility(4);
        j += 1;
      }
      continue;
      label1479:
      paramawxb.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(8);
      paramawxb.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    }
    label1500:
    if (paramawov.jdField_c_of_type_JavaUtilList != null)
    {
      paramawxb.jdField_a_of_type_AndroidWidgetRelativeLayout.removeAllViews();
      i = paramawov.jdField_c_of_type_JavaUtilList.size() - 1;
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
    for (int j = baxn.a((Context)localObject1, 11.0F) * i;; j = 0)
    {
      localObject2 = (SquareImageView)LayoutInflater.from((Context)localObject1).inflate(2131559626, null, false);
      localObject3 = new RelativeLayout.LayoutParams(baxn.a((Context)localObject1, 16.0F), baxn.a((Context)localObject1, 16.0F));
      ((RelativeLayout.LayoutParams)localObject3).leftMargin = j;
      paramawxb.jdField_a_of_type_AndroidWidgetRelativeLayout.addView((View)localObject2, paramawov.jdField_c_of_type_JavaUtilList.size() - 1 - i, (ViewGroup.LayoutParams)localObject3);
      localObject3 = (String)paramawov.jdField_c_of_type_JavaUtilList.get(i);
      localObject4 = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject4).mFailedDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
      ((URLDrawable.URLDrawableOptions)localObject4).mLoadingDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
      ((URLDrawable.URLDrawableOptions)localObject4).mRequestWidth = ((SquareImageView)localObject2).getLayoutParams().width;
      ((URLDrawable.URLDrawableOptions)localObject4).mRequestHeight = ((SquareImageView)localObject2).getLayoutParams().height;
      localObject3 = URLDrawable.getDrawable((String)localObject3, (URLDrawable.URLDrawableOptions)localObject4);
      ((URLDrawable)localObject3).setDecodeHandler(bavw.a);
      ((SquareImageView)localObject2).setImageDrawable((Drawable)localObject3);
      if ((((URLDrawable)localObject3).getStatus() != 1) && (((URLDrawable)localObject3).getStatus() != 0)) {
        ((URLDrawable)localObject3).restartDownload();
      }
      ((SquareImageView)localObject2).setVisibility(0);
      i -= 1;
      break;
      paramawxb.jdField_a_of_type_AndroidWidgetRelativeLayout.removeAllViews();
      label1758:
      if (!TextUtils.isEmpty(paramawov.jdField_b_of_type_JavaLangString))
      {
        paramawxb.jdField_b_of_type_AndroidWidgetTextView.setText(paramawov.jdField_b_of_type_JavaLangString);
        paramawxb.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
        if (TextUtils.isEmpty(paramawov.j)) {
          break label2084;
        }
        localObject1 = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject1).mFailedDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
        ((URLDrawable.URLDrawableOptions)localObject1).mLoadingDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
        ((URLDrawable.URLDrawableOptions)localObject1).mRequestWidth = paramawxb.jdField_a_of_type_ComTencentImageURLImageView.getLayoutParams().width;
        ((URLDrawable.URLDrawableOptions)localObject1).mRequestHeight = paramawxb.jdField_a_of_type_ComTencentImageURLImageView.getLayoutParams().height;
        localObject1 = URLDrawable.getDrawable(paramawov.j, (URLDrawable.URLDrawableOptions)localObject1);
        paramawxb.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable((Drawable)localObject1);
        if ((((URLDrawable)localObject1).getStatus() != 1) && (((URLDrawable)localObject1).getStatus() != 0)) {
          ((URLDrawable)localObject1).restartDownload();
        }
        paramawxb.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(0);
        label1900:
        if (TextUtils.isEmpty(paramawov.k)) {
          break label2096;
        }
        paramawxb.c.setText(paramawov.k);
        paramawxb.c.setVisibility(0);
        if (TextUtils.isEmpty(paramawov.l)) {
          break label2108;
        }
        localObject1 = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject1).mFailedDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
        ((URLDrawable.URLDrawableOptions)localObject1).mLoadingDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
        ((URLDrawable.URLDrawableOptions)localObject1).mRequestWidth = paramawxb.jdField_b_of_type_ComTencentImageURLImageView.getLayoutParams().width;
        ((URLDrawable.URLDrawableOptions)localObject1).mRequestHeight = paramawxb.jdField_b_of_type_ComTencentImageURLImageView.getLayoutParams().height;
        localObject1 = URLDrawable.getDrawable(paramawov.l, (URLDrawable.URLDrawableOptions)localObject1);
        paramawxb.jdField_b_of_type_ComTencentImageURLImageView.setImageDrawable((Drawable)localObject1);
        if ((((URLDrawable)localObject1).getStatus() != 1) && (((URLDrawable)localObject1).getStatus() != 0)) {
          ((URLDrawable)localObject1).restartDownload();
        }
        paramawxb.jdField_b_of_type_ComTencentImageURLImageView.setVisibility(0);
      }
      for (;;)
      {
        if (TextUtils.isEmpty(paramawov.m)) {
          break label2120;
        }
        paramawxb.jdField_d_of_type_AndroidWidgetTextView.setText(paramawov.m);
        paramawxb.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
        return;
        paramawxb.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
        break;
        paramawxb.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(8);
        break label1900;
        paramawxb.c.setVisibility(8);
        break label1929;
        paramawxb.jdField_b_of_type_ComTencentImageURLImageView.setVisibility(8);
      }
      paramawxb.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
      return;
    }
  }
  
  private void a(awpb paramawpb, awxh paramawxh)
  {
    Object localObject = paramawxh.a();
    Context localContext = ((View)localObject).getContext();
    if (((localObject instanceof LinearLayout)) && (((LinearLayout)localObject).getChildCount() == 1))
    {
      localObject = ((LinearLayout)localObject).getChildAt(0);
      ((View)localObject).setPadding(((View)localObject).getPaddingLeft(), 0, ((View)localObject).getPaddingRight(), 0);
    }
    if (!TextUtils.isEmpty(paramawpb.jdField_b_of_type_JavaLangString))
    {
      localObject = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
      ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
      ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = baxn.a(localContext, 50.0F);
      ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = baxn.a(localContext, 50.0F);
      ((URLDrawable.URLDrawableOptions)localObject).mMemoryCacheKeySuffix = "leftIcon";
      localObject = URLDrawable.getDrawable(paramawpb.jdField_b_of_type_JavaLangString, (URLDrawable.URLDrawableOptions)localObject);
      paramawxh.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable((Drawable)localObject);
      if ((((URLDrawable)localObject).getStatus() != 1) && (((URLDrawable)localObject).getStatus() != 0)) {
        ((URLDrawable)localObject).restartDownload();
      }
      paramawxh.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(0);
      if (TextUtils.isEmpty(paramawpb.j)) {
        break label504;
      }
      paramawxh.jdField_a_of_type_AndroidWidgetTextView.setText(paramawpb.j);
      paramawxh.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      label204:
      if (TextUtils.isEmpty(paramawpb.g)) {
        break label516;
      }
      paramawxh.jdField_b_of_type_AndroidWidgetTextView.setText(paramawpb.g);
      paramawxh.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      label233:
      if (TextUtils.isEmpty(paramawpb.k)) {
        break label528;
      }
      paramawxh.c.setVisibility(0);
      paramawxh.c.setText(paramawpb.k);
      label262:
      if (TextUtils.isEmpty(paramawpb.l)) {
        break label540;
      }
      localObject = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
      ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
      ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = baxn.a(localContext, 30.0F);
      ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = baxn.a(localContext, 30.0F);
      ((URLDrawable.URLDrawableOptions)localObject).mMemoryCacheKeySuffix = "rightIcon";
      localObject = URLDrawable.getDrawable(paramawpb.l, (URLDrawable.URLDrawableOptions)localObject);
      paramawxh.jdField_b_of_type_ComTencentImageURLImageView.setImageDrawable((Drawable)localObject);
      if ((((URLDrawable)localObject).getStatus() != 1) && (((URLDrawable)localObject).getStatus() != 0)) {
        ((URLDrawable)localObject).restartDownload();
      }
      paramawxh.jdField_b_of_type_ComTencentImageURLImageView.setVisibility(0);
      label377:
      paramawxh.a(paramawpb);
      if (!ThemeUtil.isInNightMode(BaseApplicationImpl.getApplication().getRuntime())) {
        break label552;
      }
      paramawxh.jdField_a_of_type_AndroidWidgetLinearLayout.setBackgroundResource(2130839124);
      paramawxh.jdField_b_of_type_AndroidWidgetLinearLayout.setBackgroundResource(2130839124);
      paramawxh.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#737373"));
      paramawxh.c.setTextColor(Color.parseColor("#4A4A4A"));
    }
    for (;;)
    {
      if (paramawxh.jdField_b_of_type_AndroidWidgetTextView != null) {
        paramawxh.jdField_b_of_type_AndroidWidgetTextView.setTextColor(awwa.b());
      }
      paramawxh.jdField_a_of_type_AndroidWidgetLinearLayout.setOnClickListener(new awsg(this, paramawpb, localContext));
      paramawxh.jdField_b_of_type_AndroidWidgetLinearLayout.setOnClickListener(new awsh(this, paramawpb, localContext));
      return;
      paramawxh.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(8);
      break;
      label504:
      paramawxh.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      break label204;
      label516:
      paramawxh.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      break label233;
      label528:
      paramawxh.c.setVisibility(8);
      break label262;
      label540:
      paramawxh.jdField_b_of_type_ComTencentImageURLImageView.setVisibility(8);
      break label377;
      label552:
      paramawxh.jdField_a_of_type_AndroidWidgetLinearLayout.setBackgroundResource(2130839123);
      paramawxh.jdField_b_of_type_AndroidWidgetLinearLayout.setBackgroundResource(2130839123);
      paramawxh.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#262626"));
      paramawxh.c.setTextColor(Color.parseColor("#737373"));
    }
  }
  
  private void a(awpc paramawpc, awxj paramawxj)
  {
    Object localObject = paramawxj.a();
    Context localContext = ((View)localObject).getContext();
    if (((localObject instanceof LinearLayout)) && (((LinearLayout)localObject).getChildCount() == 1))
    {
      localObject = ((LinearLayout)localObject).getChildAt(0);
      ((View)localObject).setPadding(((View)localObject).getPaddingLeft(), 0, ((View)localObject).getPaddingRight(), 0);
    }
    if (!TextUtils.isEmpty(paramawpc.jdField_b_of_type_JavaLangString))
    {
      localObject = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
      ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
      ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = baxn.a(localContext, 40.0F);
      ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = baxn.a(localContext, 40.0F);
      ((URLDrawable.URLDrawableOptions)localObject).mMemoryCacheKeySuffix = "leftIcon";
      localObject = URLDrawable.getDrawable(paramawpc.jdField_b_of_type_JavaLangString, (URLDrawable.URLDrawableOptions)localObject);
      paramawxj.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable((Drawable)localObject);
      if ((((URLDrawable)localObject).getStatus() != 1) && (((URLDrawable)localObject).getStatus() != 0)) {
        ((URLDrawable)localObject).restartDownload();
      }
      paramawxj.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(0);
      if (TextUtils.isEmpty(paramawpc.j)) {
        break label363;
      }
      paramawxj.jdField_a_of_type_AndroidWidgetTextView.setText(paramawpc.j);
      paramawxj.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      label204:
      if (TextUtils.isEmpty(paramawpc.g)) {
        break label375;
      }
      paramawxj.c.setText(paramawpc.g);
      paramawxj.c.setVisibility(0);
      label233:
      if (TextUtils.isEmpty(paramawpc.k)) {
        break label387;
      }
      paramawxj.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
      paramawxj.jdField_d_of_type_AndroidWidgetTextView.setText(paramawpc.k);
      label262:
      if (!paramawpc.jdField_b_of_type_Boolean) {
        break label399;
      }
      paramawxj.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    }
    for (;;)
    {
      awsq.a(null, 0, paramawpc.jdField_c_of_type_Int, "0X8009D5C", 0, 0, null, null);
      if ((paramawpc.jdField_a_of_type_JavaUtilList != null) && (paramawpc.jdField_a_of_type_JavaUtilList.size() > 0)) {
        awsq.a(null, 0, paramawpc.jdField_c_of_type_Int, "0X8009D5E", 0, 0, null, null);
      }
      paramawxj.a(paramawpc);
      paramawxj.jdField_a_of_type_AndroidWidgetLinearLayout.setOnClickListener(new awsf(this, paramawpc, localContext));
      return;
      paramawxj.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(8);
      break;
      label363:
      paramawxj.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      break label204;
      label375:
      paramawxj.c.setVisibility(8);
      break label233;
      label387:
      paramawxj.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
      break label262;
      label399:
      paramawxj.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    }
  }
  
  private void a(awpe paramawpe, awxp paramawxp)
  {
    if ((paramawpe == null) || (paramawxp == null)) {
      return;
    }
    paramawxp.jdField_a_of_type_AndroidWidgetLinearLayout.setPadding(paramawxp.jdField_a_of_type_AndroidWidgetLinearLayout.getPaddingLeft(), 0, paramawxp.jdField_a_of_type_AndroidWidgetLinearLayout.getPaddingRight(), 0);
    Object localObject = (RelativeLayout.LayoutParams)paramawxp.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams();
    boolean bool = ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null);
    if (paramawpe.jdField_b_of_type_Boolean)
    {
      ((RelativeLayout.LayoutParams)localObject).addRule(5, 0);
      ((RelativeLayout.LayoutParams)localObject).addRule(14);
      localObject = paramawxp.jdField_a_of_type_AndroidWidgetTextView.getContext();
      int i = ((Context)localObject).getResources().getDisplayMetrics().widthPixels - baxn.a((Context)localObject, 38.0F);
      if (TextUtils.isEmpty(paramawpe.jdField_b_of_type_JavaLangCharSequence)) {
        break label310;
      }
      paramawxp.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      if (!bool) {
        break label296;
      }
      paramawxp.jdField_b_of_type_AndroidWidgetTextView.setText(paramawpe.jdField_b_of_type_JavaLangCharSequence.toString());
      label148:
      float f1 = i;
      float f2 = awwa.a(paramawxp.jdField_b_of_type_AndroidWidgetTextView, paramawpe.jdField_b_of_type_JavaLangCharSequence);
      i = (int)(f1 - (baxn.a((Context)localObject, 10.0F) + f2));
      label182:
      if (TextUtils.isEmpty(paramawpe.jdField_a_of_type_JavaLangCharSequence)) {
        break label334;
      }
      paramawxp.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      localObject = paramawpe.jdField_a_of_type_JavaLangCharSequence;
      if (paramawpe.jdField_b_of_type_Boolean) {
        break label346;
      }
      localObject = awwa.a(paramawxp.jdField_a_of_type_AndroidWidgetTextView, i, (CharSequence)localObject);
    }
    label296:
    label310:
    label334:
    label346:
    for (;;)
    {
      if (bool) {
        paramawxp.jdField_a_of_type_AndroidWidgetTextView.setText(((CharSequence)localObject).toString());
      }
      for (;;)
      {
        paramawxp.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundDrawable(a(paramawpe.jdField_a_of_type_JavaLangString));
        paramawxp.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(new awsi(this, paramawpe, paramawxp));
        return;
        ((RelativeLayout.LayoutParams)localObject).addRule(14, 0);
        ((RelativeLayout.LayoutParams)localObject).addRule(5);
        break;
        paramawxp.jdField_b_of_type_AndroidWidgetTextView.setText(paramawpe.jdField_b_of_type_JavaLangCharSequence);
        break label148;
        paramawxp.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
        break label182;
        paramawxp.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
        continue;
        paramawxp.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      }
    }
  }
  
  private void a(awpf paramawpf, awxo paramawxo)
  {
    if ((paramawpf == null) || (paramawxo == null)) {}
    while ((TextUtils.isEmpty(paramawpf.jdField_a_of_type_JavaLangString)) || (paramawxo.jdField_a_of_type_AndroidWidgetTextView == null)) {
      return;
    }
    Context localContext = paramawxo.jdField_a_of_type_AndroidWidgetTextView.getContext();
    int j = localContext.getResources().getDisplayMetrics().widthPixels - baxn.a(localContext, 40.0F);
    int i;
    if ((!TextUtils.isEmpty(paramawpf.e)) && (paramawxo.jdField_a_of_type_AndroidWidgetLinearLayout != null))
    {
      paramawxo.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      i = j - baxn.a(localContext, 26.0F);
    }
    for (;;)
    {
      paramawpf = awwa.a(paramawxo.jdField_a_of_type_AndroidWidgetTextView, i, paramawpf.jdField_a_of_type_JavaLangString);
      paramawxo.jdField_a_of_type_AndroidWidgetTextView.setText(paramawpf);
      return;
      i = j;
      if (paramawxo.jdField_a_of_type_AndroidWidgetLinearLayout != null)
      {
        paramawxo.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
        i = j;
      }
    }
  }
  
  private void a(awph paramawph, awxr paramawxr)
  {
    Context localContext = paramawxr.jdField_b_of_type_AndroidWidgetRelativeLayout.getContext();
    Object localObject = (RelativeLayout.LayoutParams)paramawxr.jdField_a_of_type_AndroidWidgetLinearLayout.getLayoutParams();
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)paramawxr.jdField_b_of_type_AndroidWidgetRelativeLayout.getLayoutParams();
    if (paramawph.jdField_b_of_type_Boolean)
    {
      ((RelativeLayout.LayoutParams)localObject).addRule(15);
      localLayoutParams.addRule(15);
      localLayoutParams.addRule(10, 0);
      localLayoutParams.addRule(10, 0);
    }
    for (;;)
    {
      localObject = a(paramawph, paramawxr, false, 0);
      if (((Integer)((Pair)localObject).first).intValue() != 0) {
        ((RelativeLayout.LayoutParams)paramawxr.jdField_b_of_type_AndroidWidgetRelativeLayout.getLayoutParams()).rightMargin = baxn.a(localContext, 10.0F);
      }
      int i = a(paramawph, paramawxr);
      int j = a(paramawph, paramawxr, ((Integer)((Pair)localObject).first).intValue(), i);
      i = j;
      if (((Integer)((Pair)localObject).second).intValue() > j) {
        i = ((Integer)((Pair)localObject).second).intValue();
      }
      if (paramawxr.jdField_a_of_type_AndroidWidgetRelativeLayout != null) {
        ((RelativeLayout.LayoutParams)paramawxr.jdField_a_of_type_AndroidWidgetRelativeLayout.getLayoutParams()).height = i;
      }
      return;
      ((RelativeLayout.LayoutParams)localObject).addRule(10);
      localLayoutParams.addRule(10);
      ((RelativeLayout.LayoutParams)localObject).addRule(15, 0);
      localLayoutParams.addRule(15, 0);
    }
  }
  
  private void a(awpl paramawpl, awxs paramawxs)
  {
    Object localObject1 = paramawxs.a().getContext();
    Object localObject2 = paramawxs.a();
    if (paramawpl.jdField_b_of_type_Boolean) {
      ((View)localObject2).setPadding(((View)localObject2).getPaddingLeft(), vzl.a(((View)localObject2).getContext(), 9.0F), ((View)localObject2).getPaddingRight(), vzl.a(((View)localObject2).getContext(), 9.0F));
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
      ((View)localObject2).setPadding(((View)localObject2).getPaddingLeft(), vzl.a(((View)localObject2).getContext(), 6.0F), ((View)localObject2).getPaddingRight(), vzl.a(((View)localObject2).getContext(), 6.0F));
    }
    if (!((List)localObject3).isEmpty())
    {
      if (paramawpl.jdField_c_of_type_Boolean)
      {
        i = 0;
        while (i < ((List)localObject3).size())
        {
          ((SquareImageView)((List)localObject3).get(i)).setRoundRect(vzl.a((Context)localObject1, 4.0F));
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
      paramawxs.a().setTextColor(Color.parseColor("#6991B8"));
      paramawxs.c().setTextColor(Color.parseColor("#44608A"));
      paramawxs.b().setTextColor(Color.parseColor("#44608A"));
      if (!TextUtils.isEmpty(paramawpl.i)) {
        a((Context)localObject1, (SquareImageView)paramawxs.b(), paramawxs.jdField_b_of_type_AndroidWidgetImageView, paramawxs.jdField_a_of_type_AndroidWidgetTextView, paramawpl.jdField_a_of_type_Int, paramawpl.i, null, baxn.a((Context)localObject1, 21.0F));
      }
      if (TextUtils.isEmpty(paramawpl.jdField_a_of_type_JavaLangString)) {
        break label1085;
      }
      localObject2 = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
      ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
      ((URLDrawable.URLDrawableOptions)localObject2).mRequestWidth = paramawxs.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams().width;
      ((URLDrawable.URLDrawableOptions)localObject2).mRequestHeight = paramawxs.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams().height;
      localObject2 = URLDrawable.getDrawable(paramawpl.jdField_a_of_type_JavaLangString, (URLDrawable.URLDrawableOptions)localObject2);
      paramawxs.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject2);
      if ((((URLDrawable)localObject2).getStatus() != 1) && (((URLDrawable)localObject2).getStatus() != 0)) {
        ((URLDrawable)localObject2).restartDownload();
      }
      paramawxs.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      i = ((Context)localObject1).getResources().getDimensionPixelSize(2131298204);
      if ((paramawpl.jdField_a_of_type_Int == 6) || (paramawpl.jdField_a_of_type_Int == 8)) {
        i = baxn.a((Context)localObject1, 100.0F);
      }
      localObject2 = awwa.a(paramawxs.a(), 10.0F * awwa.a(paramawxs.a(), ajya.a(2131713671)), 1, paramawpl.jdField_a_of_type_JavaLangCharSequence.toString(), paramawpl.jdField_a_of_type_Awvp.jdField_a_of_type_JavaUtilList, false, false, true);
      paramawxs.a().setText((CharSequence)localObject2);
      paramawxs.a().setEllipsize(null);
      float f1 = ((Context)localObject1).getResources().getDisplayMetrics().widthPixels - baxn.a((Context)localObject1, 40.0F) - i;
      localObject2 = awwa.a(paramawxs.b(), f1, 2, paramawpl.jdField_b_of_type_JavaLangCharSequence.toString(), "", false, false, true);
      a(paramawxs.b(), (CharSequence)localObject2, false);
      if (TextUtils.isEmpty(paramawpl.jdField_c_of_type_JavaLangCharSequence)) {
        break label1097;
      }
      f1 = ((Context)localObject1).getResources().getDisplayMetrics().widthPixels - baxn.a((Context)localObject1, 30.0F);
      localObject2 = awwa.a(paramawxs.c(), f1, 2, paramawpl.jdField_c_of_type_JavaLangCharSequence.toString(), paramawpl.jdField_a_of_type_Awvp.jdField_a_of_type_JavaUtilList, false, false);
      paramawxs.c().setText((CharSequence)localObject2);
      paramawxs.c().setVisibility(0);
      label740:
      if (paramawpl.jdField_a_of_type_JavaUtilList == null) {
        break label1546;
      }
      if (paramawpl.jdField_a_of_type_JavaUtilList.size() != 1) {
        break label1119;
      }
      paramawxs.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(0);
      paramawxs.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      localObject2 = paramawxs.a().getResources();
      if (jdField_a_of_type_Int == 0) {
        jdField_a_of_type_Int = ((Resources)localObject2).getDisplayMetrics().widthPixels;
      }
      localObject1 = paramawxs.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView;
      ((SquareImageView)localObject1).setImageScale((float)(1.0D / paramawpl.jdField_a_of_type_Double), 0.0F);
      f1 = ((Resources)localObject2).getDimension(2131298197);
      float f2 = ((Resources)localObject2).getDimension(2131298197);
      i = baxn.a(paramawxs.a().getContext(), 2.0F);
      j = paramawxs.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount();
      j = (int)(jdField_a_of_type_Int - f1 - f2 - (j - 1) * i) / j;
      i = (int)(j * paramawpl.jdField_b_of_type_Double);
      j = (int)(j * paramawpl.jdField_b_of_type_Double);
      ((SquareImageView)localObject1).setLayoutParams(new FrameLayout.LayoutParams(i, j));
      paramawpl = (awok)paramawpl.jdField_a_of_type_JavaUtilList.get(0);
      localObject2 = paramawpl.jdField_a_of_type_JavaLangString;
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
      if (paramawpl.jdField_a_of_type_Int != 2) {
        break label1109;
      }
      paramawxs.jdField_d_of_type_AndroidWidgetImageView.setVisibility(0);
    }
    for (;;)
    {
      return;
      paramawxs.a().setTextColor(Color.parseColor("#262626"));
      paramawxs.c().setTextColor(Color.parseColor("#737373"));
      paramawxs.b().setTextColor(Color.parseColor("#737373"));
      break;
      label1085:
      paramawxs.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      break label496;
      label1097:
      paramawxs.c().setVisibility(8);
      break label740;
      label1109:
      paramawxs.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
      return;
      label1119:
      paramawxs.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(8);
      paramawxs.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      int m = paramawxs.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount();
      i = 0;
      j = i;
      if (i < paramawpl.jdField_a_of_type_JavaUtilList.size())
      {
        j = i;
        if (i < m)
        {
          localObject3 = paramawxs.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(i);
          ((View)localObject3).setVisibility(0);
          localObject2 = (SquareImageView)((View)localObject3).findViewById(2131367872);
          localObject3 = (ImageView)((View)localObject3).findViewById(2131368889);
          j = vzl.a((Context)localObject1) / m;
          int k = (int)(j * paramawpl.jdField_a_of_type_Double);
          ((SquareImageView)localObject2).setImageScale((float)(1.0D / paramawpl.jdField_a_of_type_Double), 0.0F);
          localObject4 = (awok)paramawpl.jdField_a_of_type_JavaUtilList.get(i);
          Object localObject5 = ((awok)localObject4).jdField_a_of_type_JavaLangString;
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
          if (((awok)localObject4).jdField_a_of_type_Int == 2)
          {
            ((ImageView)localObject3).setVisibility(0);
            label1379:
            if ((i != m - 1) || (paramawpl.jdField_b_of_type_Int <= m)) {
              break label1500;
            }
            ((ImageView)localObject3).setVisibility(8);
            ((SquareImageView)localObject2).setFilterColor(Color.parseColor("#66000000"));
            k = paramawpl.jdField_b_of_type_Int - m;
            j = k;
            if (k > 99) {
              j = 99;
            }
            ((SquareImageView)localObject2).setFilterText("+" + j);
            ((SquareImageView)localObject2).setFilterTextSize(baxn.a(((SquareImageView)localObject2).getContext(), 20.0F));
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
        paramawxs.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(j).setVisibility(4);
        j += 1;
      }
    }
    label1546:
    paramawxs.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(8);
    paramawxs.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
  }
  
  private void a(SquareImageView paramSquareImageView, int paramInt1, int paramInt2, String paramString)
  {
    if ((paramSquareImageView == null) || (TextUtils.isEmpty(paramString))) {
      return;
    }
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mFailedDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
    localURLDrawableOptions.mLoadingDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
    paramSquareImageView.getLayoutParams().width = baxn.a(paramSquareImageView.getContext(), paramInt1);
    paramSquareImageView.getLayoutParams().height = baxn.a(paramSquareImageView.getContext(), paramInt2);
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
  
  private void b(awph paramawph, awxr paramawxr)
  {
    if ((paramawph == null) || (paramawph.jdField_a_of_type_Awpi == null) || (paramawxr == null)) {
      if ((paramawxr != null) && (paramawxr.jdField_b_of_type_AndroidWidgetButton != null)) {
        paramawxr.jdField_b_of_type_AndroidWidgetButton.setVisibility(8);
      }
    }
    while (paramawxr.jdField_b_of_type_AndroidWidgetButton == null) {
      return;
    }
    Context localContext = paramawxr.jdField_b_of_type_AndroidWidgetButton.getContext();
    if ((paramawph.jdField_a_of_type_Awpi.jdField_a_of_type_Int == 1) && (!TextUtils.isEmpty(paramawph.jdField_a_of_type_Awpi.jdField_a_of_type_JavaLangCharSequence)))
    {
      paramawxr.jdField_b_of_type_AndroidWidgetButton.setVisibility(0);
      paramawxr.jdField_b_of_type_AndroidWidgetButton.setText(paramawph.jdField_a_of_type_Awpi.jdField_a_of_type_JavaLangCharSequence);
      paramawxr.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(new awsl(this, localContext, paramawph));
      return;
    }
    paramawxr.jdField_b_of_type_AndroidWidgetButton.setVisibility(8);
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
      paramInt1 = baxn.a(paramContext, 62.0F);
      a(paramSquareImageView, paramImageView, paramTextView, baxn.a(paramContext, 100.0F), paramInt1, false, paramString1, null, 2130841810, false);
      return;
    case 7: 
      a(paramSquareImageView, paramImageView, paramTextView, baxn.a(paramContext, 100.0F), baxn.a(paramContext, 62.0F), false, paramString1, paramString2, 0, false);
      return;
    }
    a(paramSquareImageView, paramImageView, paramTextView, baxn.a(paramContext, 100.0F), baxn.a(paramContext, 62.0F), false, paramString1, null, 0, false);
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
  
  public void a(awor paramawor, awwy paramawwy)
  {
    awwd.a(paramawor.a(), paramawor.b(), paramawwy.a(), paramawor.jdField_a_of_type_Boolean, paramawor.r, paramawor.f);
    switch (paramawor.d())
    {
    }
    for (;;)
    {
      b(paramawor, paramawwy);
      if (TextUtils.isEmpty(paramawor.i)) {
        c(paramawor, paramawwy);
      }
      return;
      a((awop)paramawor, (awww)paramawwy);
      continue;
      a((awpl)paramawor, (awxs)paramawwy);
      continue;
      a((awoq)paramawor, (awwx)paramawwy);
      continue;
      a((awoy)paramawor, (awxe)paramawwy);
      continue;
      a((awph)paramawor, (awxr)paramawwy);
      continue;
      a((awpe)paramawor, (awxp)paramawwy);
      continue;
      a((awpf)paramawor, (awxo)paramawwy);
      continue;
      a((awov)paramawor, (awxb)paramawwy);
      continue;
      a((awot)paramawor, (awwz)paramawwy);
      continue;
      a((awow)paramawor, (awxc)paramawwy);
      continue;
      a((awpg)paramawor, (awxq)paramawwy);
      continue;
      a((awpd)paramawor, (awxm)paramawwy);
      continue;
      a((awpb)paramawor, (awxh)paramawwy);
      continue;
      a((awpc)paramawor, (awxj)paramawwy);
      continue;
      a((awpa)paramawor, (awxg)paramawwy);
    }
  }
  
  public void a(awor paramawor, awwy paramawwy, Bitmap paramBitmap)
  {
    if (paramawwy.b() != null) {
      paramawwy.b().setImageBitmap(paramBitmap);
    }
  }
  
  protected void a(awow paramawow, awxc paramawxc)
  {
    if ((paramawow.jdField_a_of_type_JavaUtilArrayList == null) || (paramawow.jdField_a_of_type_JavaUtilArrayList.size() == 0))
    {
      if (QLog.isColorLevel()) {
        QLog.e("Q.uniteSearch.SearchTemplatePresenter", 2, "bindHorSlidingContainerTemplateView, containerItem.horizontalModelItems is empty");
      }
      return;
    }
    awki localawki2 = (awki)paramawxc.jdField_a_of_type_ComTencentWidgetHorizontalListView.getAdapter();
    awki localawki1;
    if (localawki2 != null)
    {
      localawki1 = localawki2;
      if (localawki2.a() == paramawow.jdField_a_of_type_JavaUtilArrayList) {}
    }
    else
    {
      localawki1 = new awki(paramawow, this.jdField_a_of_type_Awkh.jdField_b_of_type_Int, paramawxc.jdField_a_of_type_ComTencentWidgetHorizontalListView);
      paramawxc.jdField_a_of_type_ComTencentWidgetHorizontalListView.setAdapter(localawki1);
    }
    if (localawki1.a() != paramawow.jdField_a_of_type_JavaUtilArrayList)
    {
      paramawxc.jdField_a_of_type_Awow = paramawow;
      paramawxc.jdField_a_of_type_ComTencentWidgetHorizontalListView.resetCurrentX(paramawow.jdField_b_of_type_Int);
    }
    localawki1.a(paramawow.jdField_a_of_type_JavaUtilArrayList);
  }
  
  protected void a(awoy paramawoy, awxe paramawxe)
  {
    paramawxe.a().getContext();
    paramawxe.a();
    if ((paramawoy.jdField_a_of_type_JavaUtilArrayList == null) || (paramawoy.jdField_a_of_type_JavaUtilArrayList.size() == 0)) {
      if (QLog.isColorLevel()) {
        QLog.e("Q.uniteSearch.SearchTemplatePresenter", 2, "bindHorizontalContainerTemplateView, containerItem.horizontalModelItems is empty");
      }
    }
    for (;;)
    {
      return;
      paramawxe.a(paramawoy);
      if (paramawoy.jdField_a_of_type_JavaUtilArrayList.size() != paramawxe.jdField_a_of_type_JavaUtilArrayList.size()) {
        QLog.e("Q.uniteSearch.SearchTemplatePresenter", 2, "bindHorizontalContainerTemplateView, view.size != model.size");
      }
      int j = paramawoy.jdField_a_of_type_JavaUtilArrayList.size();
      int i = 0;
      while (i < j)
      {
        ((awox)paramawoy.jdField_a_of_type_JavaUtilArrayList.get(i)).a((awxd)paramawxe.jdField_a_of_type_JavaUtilArrayList.get(i));
        i += 1;
      }
    }
  }
  
  protected void a(awpa paramawpa, awxg paramawxg)
  {
    Object localObject2 = (LinearLayout)paramawxg.b();
    Object localObject1;
    Object localObject3;
    awwu localawwu;
    if ((localObject2 != null) && (paramawpa.a != null))
    {
      ((LinearLayout)localObject2).removeAllViews();
      if (((LinearLayout)localObject2).getParent() != null) {
        ((View)((LinearLayout)localObject2).getParent()).setPadding(0, 0, 0, 0);
      }
      localObject1 = paramawpa.a;
      paramawpa = paramawxg.a().getContext();
      localObject3 = LayoutInflater.from(paramawpa).inflate(2131562389, null);
      localawwu = new awwu((View)localObject3);
      Object localObject4 = ((View)localObject3).findViewById(2131368325);
      int i = bbll.a(6.0F);
      ((View)localObject4).setPadding(0, i, 0, i);
      ((LinearLayout)localObject2).addView((View)localObject3);
      if (((awon)localObject1).c() != null) {
        break label559;
      }
      if (localawwu.c() != null) {
        localawwu.c().setVisibility(8);
      }
      if (localawwu.a() != null) {
        localawwu.a().setVisibility(8);
      }
      localObject2 = localawwu.a();
      if (localObject2 != null) {
        ((URLImageView)localObject2).setVisibility(8);
      }
      localObject2 = localawwu.e();
      if (localObject2 != null)
      {
        ((TextView)localObject2).setVisibility(0);
        if (!TextUtils.isEmpty(((awon)localObject1).a())) {
          ((TextView)localObject2).setText(((awon)localObject1).a());
        }
      }
      if ((localawwu.b() != null) && (!TextUtils.isEmpty(((awon)localObject1).g())))
      {
        localObject2 = ((awon)localObject1).g();
        localObject3 = new ColorDrawable(Color.parseColor("#e7e7e7"));
        localObject4 = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject4).mRequestWidth = baxn.a(paramawpa, 50.0F);
        ((URLDrawable.URLDrawableOptions)localObject4).mRequestHeight = baxn.a(paramawpa, 50.0F);
        ((URLDrawable.URLDrawableOptions)localObject4).mFailedDrawable = ((Drawable)localObject3);
        ((URLDrawable.URLDrawableOptions)localObject4).mLoadingDrawable = ((Drawable)localObject3);
        if (!bfnx.a((String)localObject2)) {
          break label684;
        }
        localObject2 = URLDrawable.getDrawable((String)localObject2, (URLDrawable.URLDrawableOptions)localObject4);
        ((URLDrawable)localObject2).setTag(bavw.b(baxn.a(paramawpa, 50.0F), baxn.a(paramawxg.a().getContext(), 50.0F), baxn.a(paramawpa, 3.0F)));
        ((URLDrawable)localObject2).setDecodeHandler(bavw.i);
        localawwu.b().setImageDrawable((Drawable)localObject2);
        if ((((URLDrawable)localObject2).getStatus() != 1) && (((URLDrawable)localObject2).getStatus() != 0)) {
          ((URLDrawable)localObject2).restartDownload();
        }
      }
    }
    for (;;)
    {
      localawwu.a().setOnClickListener(new awse(this, (awon)localObject1));
      if ((localawwu.a() != null) && (((awon)localObject1).c()))
      {
        paramawxg = ((awon)localObject1).h();
        localObject1 = new ColorDrawable(Color.parseColor("#e7e7e7"));
        localObject2 = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject2).mRequestWidth = baxn.a(paramawpa, 40.0F);
        ((URLDrawable.URLDrawableOptions)localObject2).mRequestHeight = baxn.a(paramawpa, 12.0F);
        ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = ((Drawable)localObject1);
        ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = ((Drawable)localObject1);
        paramawxg = URLDrawable.getDrawable(paramawxg, (URLDrawable.URLDrawableOptions)localObject2);
        paramawxg.setTag(bavw.b(baxn.a(paramawpa, 38.0F), baxn.a(paramawpa, 12.0F), 0));
        paramawxg.setDecodeHandler(bavw.i);
        localawwu.a().setImageDrawable(paramawxg);
        if ((paramawxg.getStatus() != 1) && (paramawxg.getStatus() != 0)) {
          paramawxg.restartDownload();
        }
      }
      return;
      label559:
      if ((localawwu.c() != null) && (!TextUtils.isEmpty(((awon)localObject1).c())))
      {
        localawwu.c().setVisibility(0);
        localawwu.c().setText(((awon)localObject1).c());
      }
      for (;;)
      {
        if (localawwu.a() != null) {
          localawwu.a().setVisibility(0);
        }
        localObject2 = localawwu.e();
        if (localObject2 != null) {
          ((TextView)localObject2).setVisibility(8);
        }
        if (TextUtils.isEmpty(((awon)localObject1).a())) {
          break;
        }
        localawwu.a().setText(((awon)localObject1).a());
        break;
        if (localawwu.c() != null) {
          localawwu.c().setVisibility(8);
        }
      }
      label684:
      localawwu.b().setImageDrawable((Drawable)localObject3);
    }
  }
  
  protected void a(awpd paramawpd, awxm paramawxm)
  {
    Object localObject1 = paramawxm.a().getContext();
    if (ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null))
    {
      paramawxm.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#737373"));
      paramawxm.jdField_b_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#4A4A4A"));
      if (TextUtils.isEmpty(paramawpd.jdField_b_of_type_JavaLangString)) {
        break label290;
      }
      Object localObject2 = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
      ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
      ((URLDrawable.URLDrawableOptions)localObject2).mRequestWidth = baxn.a((Context)localObject1, 18.0F);
      ((URLDrawable.URLDrawableOptions)localObject2).mRequestHeight = baxn.a((Context)localObject1, 18.0F);
      ((URLDrawable.URLDrawableOptions)localObject2).mMemoryCacheKeySuffix = "askIcon";
      localObject2 = URLDrawable.getDrawable(paramawpd.jdField_b_of_type_JavaLangString, (URLDrawable.URLDrawableOptions)localObject2);
      paramawxm.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable((Drawable)localObject2);
      if ((((URLDrawable)localObject2).getStatus() != 1) && (((URLDrawable)localObject2).getStatus() != 0)) {
        ((URLDrawable)localObject2).restartDownload();
      }
      paramawxm.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(0);
    }
    label290:
    for (;;)
    {
      label166:
      if (!TextUtils.isEmpty(paramawpd.j))
      {
        int j = paramawxm.jdField_a_of_type_AndroidWidgetTextView.getContext().getResources().getDisplayMetrics().widthPixels;
        int i = (int)awwa.a(paramawxm.jdField_a_of_type_AndroidWidgetTextView, " ");
        int k = baxn.a((Context)localObject1, 22.0F) / i;
        localObject1 = "";
        i = 0;
        for (;;)
        {
          if (i < k)
          {
            localObject1 = (String)localObject1 + " ";
            i += 1;
            continue;
            paramawxm.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#262626"));
            paramawxm.jdField_b_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#737373"));
            break;
            paramawxm.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(8);
            break label166;
          }
        }
        localObject1 = awwa.a(paramawxm.jdField_a_of_type_AndroidWidgetTextView, j, 2, (String)localObject1 + paramawpd.j, paramawpd.jdField_a_of_type_Awvp.jdField_a_of_type_JavaUtilList, false, false, true);
        paramawxm.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject1);
      }
    }
    paramawxm.a(paramawpd);
    if ((!TextUtils.isEmpty(paramawpd.k)) && (paramawpd.jdField_a_of_type_JavaUtilList != null) && (paramawpd.jdField_a_of_type_JavaUtilList.size() != 0))
    {
      paramawxm.jdField_b_of_type_AndroidWidgetTextView.setText(paramawpd.k);
      paramawxm.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      return;
    }
    paramawxm.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
  }
  
  protected void a(awpg paramawpg, awxq paramawxq)
  {
    if (!TextUtils.isEmpty(paramawpg.jdField_b_of_type_JavaLangString))
    {
      paramawxq.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(0);
      Object localObject = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
      ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
      ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = paramawxq.jdField_a_of_type_ComTencentImageURLImageView.getLayoutParams().width;
      ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = paramawxq.jdField_a_of_type_ComTencentImageURLImageView.getLayoutParams().height;
      localObject = URLDrawable.getDrawable(paramawpg.jdField_b_of_type_JavaLangString, (URLDrawable.URLDrawableOptions)localObject);
      paramawxq.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable((Drawable)localObject);
      if ((((URLDrawable)localObject).getStatus() != 1) && (((URLDrawable)localObject).getStatus() != 0)) {
        ((URLDrawable)localObject).restartDownload();
      }
      if (TextUtils.isEmpty(paramawpg.j)) {
        break label345;
      }
      paramawxq.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      int i = paramawxq.jdField_a_of_type_AndroidWidgetTextView.getContext().getResources().getDisplayMetrics().widthPixels;
      localObject = awwa.a(paramawxq.jdField_a_of_type_AndroidWidgetTextView, i, 1, paramawpg.j, paramawpg.jdField_a_of_type_Awvp.jdField_a_of_type_JavaUtilList, false, false, true);
      paramawxq.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
      label183:
      if (TextUtils.isEmpty(paramawpg.l)) {
        break label357;
      }
      paramawxq.jdField_b_of_type_AndroidWidgetTextView.setText(paramawpg.l);
      paramawxq.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      paramawxq.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      label220:
      if (TextUtils.isEmpty(paramawpg.k)) {
        break label378;
      }
      paramawxq.c.setText(paramawpg.k);
      paramawxq.c.setVisibility(0);
    }
    for (;;)
    {
      if (!ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null)) {
        break label390;
      }
      paramawxq.jdField_a_of_type_AndroidWidgetTextView.setTextColor(paramawxq.jdField_a_of_type_AndroidWidgetTextView.getContext().getResources().getColor(2131166792));
      paramawxq.c.setTextColor(paramawxq.c.getContext().getResources().getColor(2131166791));
      paramawxq.jdField_b_of_type_AndroidWidgetTextView.setTextColor(paramawxq.jdField_b_of_type_AndroidWidgetTextView.getContext().getResources().getColor(2131166791));
      return;
      paramawxq.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(8);
      break;
      label345:
      paramawxq.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      break label183;
      label357:
      paramawxq.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      paramawxq.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      break label220;
      label378:
      paramawxq.c.setVisibility(8);
    }
    label390:
    paramawxq.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#262626"));
    paramawxq.c.setTextColor(Color.parseColor("#737373"));
    paramawxq.jdField_b_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#737373"));
  }
  
  public void a(SquareImageView paramSquareImageView, ImageView paramImageView, TextView paramTextView, int paramInt1, int paramInt2, boolean paramBoolean1, String paramString1, String paramString2, int paramInt3, boolean paramBoolean2)
  {
    ViewGroup.LayoutParams localLayoutParams = paramSquareImageView.getLayoutParams();
    if ((paramSquareImageView.getContext() instanceof PublicAcntSearchActivity))
    {
      localLayoutParams.width = baxn.a(paramSquareImageView.getContext(), 50.0F);
      localLayoutParams.height = baxn.a(paramSquareImageView.getContext(), 50.0F);
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
          paramTextView.setDecodeHandler(bavw.a);
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
  
  protected void b(awor paramawor, awwy paramawwy)
  {
    if (paramawwy.a() != null) {
      paramawwy.a().setOnClickListener(new awsd(this, paramawor));
    }
  }
  
  public void c(awor paramawor, awwy paramawwy)
  {
    if ((paramawwy.b() != null) && ((paramawor instanceof awof)) && (!TextUtils.isEmpty(paramawor.b()))) {
      paramawwy.b().setImageDrawable(awwa.a(this.jdField_a_of_type_Baxy, paramawor));
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
      awwa.jdField_a_of_type_Long = this.jdField_a_of_type_Long;
      localImageView.post(new SearchTemplatePresenter.11(this, localImageView, bool));
      localImageView.setContentDescription(localResources.getString(2131690275));
      this.jdField_a_of_type_Awkh.notifyDataSetChanged();
      return;
    }
    localImageView.post(new SearchTemplatePresenter.12(this, localImageView, bool));
    localImageView.setContentDescription(localResources.getString(2131690273));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awsc
 * JD-Core Version:    0.7.0.1
 */