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

public class aynf
  implements aumt, aymf<ayju, aysb>
{
  public static int a;
  private long jdField_a_of_type_Long;
  public ColorDrawable a;
  public Drawable a;
  private ayfh jdField_a_of_type_Ayfh;
  private bcws jdField_a_of_type_Bcws;
  private WeakReference<ImageView> jdField_a_of_type_JavaLangRefWeakReference;
  
  public aynf(bcws parambcws, ayfh paramayfh)
  {
    this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable = new ColorDrawable(Color.parseColor("#e7e7e7"));
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = baul.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
    this.jdField_a_of_type_Bcws = parambcws;
    this.jdField_a_of_type_Ayfh = paramayfh;
  }
  
  private float a(String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      return 7.0F;
    }
    return 3.5F;
  }
  
  private int a(aykk paramaykk, aysu paramaysu)
  {
    if ((paramaykk == null) || (paramaykk.jdField_a_of_type_Aykl == null) || (paramaysu == null) || (paramaysu.jdField_a_of_type_AndroidWidgetRelativeLayout == null))
    {
      if ((paramaysu != null) && (paramaysu.jdField_a_of_type_AndroidWidgetButton != null)) {
        paramaysu.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
      }
      if ((paramaysu != null) && (paramaysu.jdField_a_of_type_AndroidWidgetImageView != null)) {
        paramaysu.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      }
      return 0;
    }
    if (paramaykk.jdField_a_of_type_Aykl.jdField_a_of_type_Int == 1)
    {
      if (paramaysu.jdField_a_of_type_AndroidWidgetButton != null) {
        paramaysu.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
      }
      if (paramaysu.jdField_a_of_type_AndroidWidgetImageView != null) {
        paramaysu.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      }
      return 0;
    }
    boolean bool = ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null);
    Context localContext = paramaysu.jdField_a_of_type_AndroidWidgetRelativeLayout.getContext();
    int i;
    if (paramaykk.jdField_a_of_type_Aykl.jdField_a_of_type_Int == 2)
    {
      if (paramaysu.jdField_a_of_type_AndroidWidgetImageView != null) {
        paramaysu.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      }
      if (paramaysu.jdField_a_of_type_AndroidWidgetButton == null) {
        return 0;
      }
      if (!TextUtils.isEmpty(paramaykk.jdField_a_of_type_Aykl.jdField_a_of_type_JavaLangCharSequence))
      {
        paramaysu.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
        paramaysu.jdField_a_of_type_AndroidWidgetButton.setText(paramaykk.jdField_a_of_type_Aykl.jdField_a_of_type_JavaLangCharSequence);
        paramaysu.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(new aynm(this, localContext, paramaykk));
      }
      for (;;)
      {
        i = (int)(0 + (ayrd.a(paramaysu.jdField_a_of_type_AndroidWidgetButton, paramaykk.jdField_a_of_type_Aykl.jdField_a_of_type_JavaLangCharSequence) + bcwh.a(localContext, 32.0F) + bcwh.a(localContext, 15.0F)));
        if (!bool) {
          break;
        }
        paramaysu.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130842880);
        paramaysu.jdField_a_of_type_AndroidWidgetButton.setTextColor(Color.parseColor("#6991B8"));
        return i;
        paramaysu.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
      }
      paramaysu.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130842879);
      paramaysu.jdField_a_of_type_AndroidWidgetButton.setTextColor(Color.parseColor("#000000"));
      return i;
    }
    int j;
    if (paramaykk.jdField_a_of_type_Aykl.jdField_a_of_type_Int == 3)
    {
      if (paramaysu.jdField_a_of_type_AndroidWidgetButton != null) {
        paramaysu.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
      }
      if ((paramaysu.jdField_a_of_type_AndroidWidgetRelativeLayout == null) || (paramaysu.jdField_a_of_type_AndroidWidgetImageView == null)) {
        return 0;
      }
      int k = ((Integer)paramaysu.a().getTag(2131379914)).intValue();
      SongInfo localSongInfo1 = new SongInfo();
      i = 0;
      j = i;
      for (;;)
      {
        try
        {
          JSONObject localJSONObject = new JSONObject(paramaykk.h);
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
          ayrd.jdField_a_of_type_Long = localSongInfo2.jdField_a_of_type_Long;
          continue;
          paramaysu.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130849013);
          continue;
          if (this.jdField_a_of_type_Long != ayrd.jdField_a_of_type_Long) {
            continue;
          }
          paramaysu.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130849014);
          continue;
          paramaysu.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130849012);
          continue;
          paramaysu.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
          continue;
        }
        this.jdField_a_of_type_Long = localSongInfo1.jdField_a_of_type_Long;
        QQPlayerService.a(this);
        if (QQPlayerService.a() == 2) {
          continue;
        }
        ayrd.jdField_a_of_type_Long = -1L;
        if (!bool) {
          continue;
        }
        if (this.jdField_a_of_type_Long != ayrd.jdField_a_of_type_Long) {
          continue;
        }
        paramaysu.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130849015);
        if ((j == 0) || (i == 0) || (TextUtils.isEmpty(localSongInfo1.jdField_b_of_type_JavaLangString))) {
          continue;
        }
        paramaysu.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        paramaysu.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(new aynn(this, paramaysu, k, localContext, bool, localSongInfo1, paramaykk));
        return bcwh.a(localContext, 39.0F) + 0;
        i = 0;
        continue;
        j = 0;
      }
    }
    paramaysu.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
    return 0;
  }
  
  private int a(aykk paramaykk, aysu paramaysu, int paramInt1, int paramInt2)
  {
    if ((paramaysu == null) || (paramaykk == null) || (paramaysu.jdField_a_of_type_AndroidWidgetLinearLayout == null)) {
      return 0;
    }
    Context localContext = paramaysu.jdField_a_of_type_AndroidWidgetLinearLayout.getContext();
    int i = localContext.getResources().getDisplayMetrics().widthPixels - paramInt1 - paramInt2 - bcwh.a(localContext, 30.0F);
    if ((paramaykk.jdField_a_of_type_JavaUtilArrayList != null) && (paramaykk.jdField_a_of_type_JavaUtilArrayList.size() > 0))
    {
      paramaysu.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      if ((paramaykk.jdField_a_of_type_Aykm != null) && (paramaykk.jdField_a_of_type_JavaUtilArrayList != null) && (paramaykk.jdField_a_of_type_JavaUtilArrayList.size() > 0))
      {
        paramaysu.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(0);
        if (paramaysu.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView != null) {
          paramaysu.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView.setVisibility(8);
        }
        if (paramaykk.jdField_a_of_type_Aykm.jdField_a_of_type_Int == 1)
        {
          if (paramaysu.jdField_b_of_type_AndroidWidgetTextView != null) {
            paramaysu.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
          }
          if ((paramaysu.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView == null) || (TextUtils.isEmpty(paramaykk.jdField_a_of_type_Aykm.jdField_a_of_type_JavaLangString))) {
            break label1007;
          }
          paramaysu.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView.setVisibility(0);
          a(paramaysu.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView, paramaykk.jdField_a_of_type_Aykm.jdField_a_of_type_JavaLangString);
          paramInt1 = i - bcwh.a(localContext, 24.0F);
        }
      }
    }
    for (;;)
    {
      Object localObject1;
      if ((paramaysu.jdField_a_of_type_AndroidWidgetTextView != null) && (!TextUtils.isEmpty(((aykn)paramaykk.jdField_a_of_type_JavaUtilArrayList.get(0)).jdField_a_of_type_JavaLangCharSequence)))
      {
        localObject1 = ((aykn)paramaykk.jdField_a_of_type_JavaUtilArrayList.get(0)).jdField_a_of_type_JavaLangCharSequence;
        if (!((aykn)paramaykk.jdField_a_of_type_JavaUtilArrayList.get(0)).jdField_a_of_type_Boolean) {
          break label635;
        }
        localObject1 = ayrd.a(paramaysu.jdField_a_of_type_AndroidWidgetTextView, paramInt1, 1, ((CharSequence)localObject1).toString(), paramaykk.jdField_a_of_type_Ayqs.jdField_a_of_type_JavaUtilList, false, false, true);
        label297:
        paramaysu.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject1);
      }
      for (paramInt1 = 1;; paramInt1 = 0)
      {
        if (paramaysu.c != null) {
          break label677;
        }
        return paramaysu.jdField_a_of_type_AndroidWidgetLinearLayout.getHeight();
        if (paramaykk.jdField_a_of_type_Aykm.jdField_a_of_type_Int == 2)
        {
          if (paramaysu.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView != null) {
            paramaysu.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView.setVisibility(8);
          }
          if ((paramaysu.jdField_b_of_type_AndroidWidgetTextView == null) || (TextUtils.isEmpty(paramaykk.jdField_a_of_type_Aykm.jdField_a_of_type_JavaLangCharSequence))) {
            break label1007;
          }
          if (ayrd.e(paramaykk.jdField_a_of_type_Aykm.jdField_b_of_type_JavaLangString)) {}
          for (localObject1 = paramaykk.jdField_a_of_type_Aykm.jdField_b_of_type_JavaLangString;; localObject1 = "#fd7f32")
          {
            ((GradientDrawable)paramaysu.jdField_b_of_type_AndroidWidgetTextView.getBackground()).setColor(Color.parseColor((String)localObject1));
            paramaysu.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
            paramaysu.jdField_b_of_type_AndroidWidgetTextView.setText(paramaykk.jdField_a_of_type_Aykm.jdField_a_of_type_JavaLangCharSequence);
            paramInt1 = (int)(i - (ayrd.a(paramaysu.jdField_b_of_type_AndroidWidgetTextView, paramaykk.jdField_a_of_type_Aykm.jdField_a_of_type_JavaLangCharSequence) + bcwh.a(localContext, 10.0F)));
            break;
          }
        }
        if (paramaykk.jdField_a_of_type_Aykm.jdField_a_of_type_Int != 3) {
          break label1007;
        }
        if (paramaysu.jdField_b_of_type_AndroidWidgetTextView != null) {
          paramaysu.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
        }
        if ((paramaysu.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView == null) || (TextUtils.isEmpty(paramaykk.jdField_a_of_type_Aykm.jdField_a_of_type_JavaLangString))) {
          break label1007;
        }
        paramaysu.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView.setVisibility(0);
        if ((paramaykk.jdField_a_of_type_Aykm.jdField_b_of_type_Int > 0) && (paramaykk.jdField_a_of_type_Aykm.jdField_c_of_type_Int > 0))
        {
          a(paramaysu.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView, paramaykk.jdField_a_of_type_Aykm.jdField_b_of_type_Int, paramaykk.jdField_a_of_type_Aykm.jdField_c_of_type_Int, paramaykk.jdField_a_of_type_Aykm.jdField_a_of_type_JavaLangString);
          paramInt1 = i - bcwh.a(localContext, bcwh.a(localContext, paramaykk.jdField_a_of_type_Aykm.jdField_b_of_type_Int) + 4);
          break;
        }
        a(paramaysu.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView, paramaykk.jdField_a_of_type_Aykm.jdField_a_of_type_JavaLangString);
        paramInt1 = i - bcwh.a(localContext, 24.0F);
        break;
        label635:
        localObject1 = ayrd.a(paramaysu.jdField_a_of_type_AndroidWidgetTextView, paramInt1, ((CharSequence)localObject1).toString());
        break label297;
        if (paramaysu.jdField_b_of_type_AndroidWidgetLinearLayout != null) {
          paramaysu.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
        }
      }
      label677:
      paramaysu.c.removeAllViews();
      aykn localaykn;
      TextView localTextView;
      if ((paramaykk.jdField_a_of_type_JavaUtilArrayList != null) && (paramaykk.jdField_a_of_type_JavaUtilArrayList.size() > 0)) {
        while (paramInt1 < paramaykk.jdField_a_of_type_JavaUtilArrayList.size())
        {
          localaykn = (aykn)paramaykk.jdField_a_of_type_JavaUtilArrayList.get(paramInt1);
          localTextView = new TextView(localContext);
          a(localTextView, localaykn.jdField_a_of_type_JavaLangString, localaykn.jdField_a_of_type_Int);
          localObject1 = localaykn.jdField_a_of_type_JavaLangCharSequence;
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
        paramInt2 = localaykn.jdField_a_of_type_Int;
        if ((localContext instanceof PublicAcntSearchActivity)) {
          paramInt2 = 1;
        }
        Object localObject2 = localObject1;
        if (localaykn.jdField_a_of_type_Boolean) {
          if ((!localaykn.jdField_a_of_type_JavaLangString.equals("A")) && (!localaykn.jdField_a_of_type_JavaLangString.equals("B"))) {
            break label952;
          }
        }
        for (boolean bool = true;; bool = false)
        {
          localObject2 = ayrd.a(localTextView, i, paramInt2, ((CharSequence)localObject1).toString(), paramaykk.jdField_a_of_type_Ayqs.jdField_a_of_type_JavaUtilList, false, bool, true);
          if (paramInt1 != 0) {
            localTextView.setPadding(0, bcwh.a(localContext, 7.0F - a(((aykn)paramaykk.jdField_a_of_type_JavaUtilArrayList.get(paramInt1 - 1)).jdField_a_of_type_JavaLangString, localaykn.jdField_a_of_type_JavaLangString)), 0, 0);
          }
          localTextView.setText((CharSequence)localObject2);
          paramaysu.c.addView(localTextView);
          break;
        }
        paramaysu.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
        b(paramaykk, paramaysu);
        paramInt1 = View.MeasureSpec.makeMeasureSpec(0, 0);
        paramInt2 = View.MeasureSpec.makeMeasureSpec(0, 0);
        paramaysu.jdField_a_of_type_AndroidWidgetLinearLayout.measure(paramInt1, paramInt2);
        return paramaysu.jdField_a_of_type_AndroidWidgetLinearLayout.getMeasuredHeight();
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
      if (!ayrd.e(paramString)) {
        localObject = "#F1F1F1";
      }
    }
  }
  
  public static Pair<Integer, Integer> a(ayju paramayju, aysb paramaysb, boolean paramBoolean, int paramInt)
  {
    if ((paramaysb == null) || (paramaysb.jdField_b_of_type_AndroidWidgetRelativeLayout == null) || (paramaysb.jdField_b_of_type_ComTencentMobileqqWidgetSquareImageView == null) || (paramayju == null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.uniteSearch.SearchTemplatePresenter", 2, "bindUniversalTemplateLeftImageview or item is null");
      }
      return new Pair(Integer.valueOf(0), Integer.valueOf(0));
    }
    SquareImageView localSquareImageView = paramaysb.jdField_b_of_type_ComTencentMobileqqWidgetSquareImageView;
    ayjv localayjv = paramayju.jdField_a_of_type_Ayjv;
    if ((localayjv == null) || (TextUtils.isEmpty(localayjv.jdField_a_of_type_JavaLangString)))
    {
      paramaysb.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      return new Pair(Integer.valueOf(0), Integer.valueOf(0));
    }
    paramaysb.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
    Object localObject = localSquareImageView.getContext();
    paramayju = a(localSquareImageView, localayjv.jdField_a_of_type_Int, localayjv.jdField_a_of_type_JavaLangString, localayjv.jdField_b_of_type_Int, paramBoolean, paramInt, paramayju);
    paramInt = ((Integer)paramayju.first).intValue();
    int i = ((Integer)paramayju.second).intValue();
    paramayju = localSquareImageView.getLayoutParams();
    paramayju.width = paramInt;
    paramayju.height = i;
    localSquareImageView.setLayoutParams(paramayju);
    paramayju = (RelativeLayout.LayoutParams)paramaysb.jdField_b_of_type_AndroidWidgetRelativeLayout.getLayoutParams();
    paramayju.width = paramInt;
    paramayju.height = i;
    paramaysb.jdField_b_of_type_AndroidWidgetRelativeLayout.setLayoutParams(paramayju);
    int j = bcwh.a((Context)localObject, 10.0F);
    if ((!TextUtils.isEmpty(localayjv.jdField_a_of_type_JavaLangCharSequence)) && (paramaysb.e != null)) {
      if (ayrd.e(localayjv.jdField_b_of_type_JavaLangString))
      {
        paramayju = localayjv.jdField_b_of_type_JavaLangString;
        ((GradientDrawable)paramaysb.e.getBackground()).setColor(Color.parseColor(paramayju));
        paramaysb.e.setVisibility(0);
        paramaysb.e.setText(localayjv.jdField_a_of_type_JavaLangCharSequence);
        label303:
        if (paramaysb.jdField_c_of_type_AndroidWidgetImageView != null)
        {
          if (!localayjv.jdField_a_of_type_Boolean) {
            break label565;
          }
          paramaysb.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
        }
        label326:
        if (paramaysb.f != null)
        {
          if (TextUtils.isEmpty(localayjv.jdField_b_of_type_JavaLangCharSequence)) {
            break label577;
          }
          paramaysb.f.setVisibility(0);
          paramaysb.f.setText(localayjv.jdField_b_of_type_JavaLangCharSequence);
        }
        label364:
        if (paramaysb.jdField_c_of_type_ComTencentMobileqqWidgetSquareImageView != null)
        {
          if (TextUtils.isEmpty(localayjv.jdField_c_of_type_JavaLangString)) {
            break label589;
          }
          paramaysb.jdField_c_of_type_ComTencentMobileqqWidgetSquareImageView.setVisibility(0);
          paramayju = URLDrawable.URLDrawableOptions.obtain();
          localObject = new ColorDrawable(-1);
          paramayju.mFailedDrawable = ((Drawable)localObject);
          paramayju.mLoadingDrawable = ((Drawable)localObject);
          paramayju.mRequestWidth = paramaysb.jdField_c_of_type_ComTencentMobileqqWidgetSquareImageView.getLayoutParams().width;
          paramayju.mRequestHeight = paramaysb.jdField_c_of_type_ComTencentMobileqqWidgetSquareImageView.getLayoutParams().height;
          paramayju = URLDrawable.getDrawable(localayjv.jdField_c_of_type_JavaLangString, paramayju);
          if ((paramayju.getStatus() != 1) && (paramayju.getStatus() != 0)) {
            paramayju.restartDownload();
          }
          paramaysb.jdField_c_of_type_ComTencentMobileqqWidgetSquareImageView.setImageDrawable(paramayju);
        }
        label481:
        if (paramaysb.g != null)
        {
          if (TextUtils.isEmpty(localayjv.jdField_c_of_type_JavaLangCharSequence)) {
            break label601;
          }
          paramaysb.g.setVisibility(0);
          paramaysb.g.setText(localayjv.jdField_c_of_type_JavaLangCharSequence);
        }
      }
    }
    for (;;)
    {
      return new Pair(Integer.valueOf(paramInt + j), Integer.valueOf(i));
      paramayju = "#fd7f32";
      break;
      if (paramaysb.e == null) {
        break label303;
      }
      paramaysb.e.setVisibility(8);
      break label303;
      label565:
      paramaysb.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
      break label326;
      label577:
      paramaysb.f.setVisibility(8);
      break label364;
      label589:
      paramaysb.jdField_c_of_type_ComTencentMobileqqWidgetSquareImageView.setVisibility(8);
      break label481;
      label601:
      paramaysb.g.setVisibility(8);
    }
  }
  
  public static Pair<Integer, Integer> a(SquareImageView paramSquareImageView, int paramInt1, String paramString, int paramInt2, boolean paramBoolean, int paramInt3, ayju paramayju)
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
      paramInt1 = bcwh.a((Context)localObject, 60.0F);
      i = bcwh.a((Context)localObject, 60.0F);
      j = 0;
      localColorDrawable = new ColorDrawable(Color.parseColor("#e7e7e7"));
      if (paramBoolean)
      {
        paramInt1 = (int)(i * 1.0F / paramInt1 * paramInt3);
        if (j != 0)
        {
          i = (int)(paramInt3 * 0.2D / 2.0D);
          paramSquareImageView.setPadding(bcwh.a((Context)localObject, 3.0F), bcwh.a((Context)localObject, 3.0F), bcwh.a((Context)localObject, 3.0F), bcwh.a((Context)localObject, 3.0F));
          paramayju = (RelativeLayout.LayoutParams)paramSquareImageView.getLayoutParams();
          i -= bcwh.a((Context)localObject, 3.0F);
          paramayju.rightMargin = i;
          paramayju.leftMargin = i;
          paramayju.topMargin = i;
          paramSquareImageView.setLayoutParams(paramayju);
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
          paramayju = URLDrawable.URLDrawableOptions.obtain();
          paramayju.mRequestWidth = paramInt3;
          paramayju.mRequestHeight = paramInt1;
          if (j == 0) {
            continue;
          }
          localObject = new GradientDrawable();
          ((GradientDrawable)localObject).setShape(0);
          ((GradientDrawable)localObject).setCornerRadius(paramInt3 / 2.0F);
          ((GradientDrawable)localObject).setColor(-1579033);
          paramayju.mLoadingDrawable = ((Drawable)localObject);
          paramayju.mFailedDrawable = ((Drawable)localObject);
          paramayju.mPlayGifImage = true;
          if (j == 0) {
            continue;
          }
          paramayju.mMemoryCacheKeySuffix = ("isAvatar" + paramInt3 + paramInt1);
          paramayju = URLDrawable.getDrawable(paramString, paramayju);
          paramayju.setDecodeHandler(bcuq.a);
        }
        catch (Exception paramayju)
        {
          QLog.e("Q.uniteSearch.SearchTemplatePresenter", 1, "imageUrl is not valid. imageUrl=" + paramString, paramayju);
          localObject = localColorDrawable;
          continue;
          paramayju.mMemoryCacheKeySuffix = ("isNotAvatar" + paramInt3 + paramInt1 + paramInt2);
          paramayju = URLDrawable.getDrawable(paramString, paramayju);
          paramayju.setTag(bcuq.b(paramInt3, paramInt1, paramInt2));
          paramayju.setDecodeHandler(bcuq.i);
          continue;
        }
        localObject = paramayju;
        if (paramayju.getStatus() != 1)
        {
          localObject = paramayju;
          if (paramayju.getStatus() != 0)
          {
            paramayju.restartDownload();
            localObject = paramayju;
          }
        }
        paramSquareImageView.setImageDrawable((Drawable)localObject);
        return new Pair(Integer.valueOf(paramInt3), Integer.valueOf(paramInt1));
        paramInt1 = bcwh.a((Context)localObject, 60.0F);
        i = bcwh.a((Context)localObject, 60.0F);
        j = 0;
        break;
        paramInt1 = bcwh.a((Context)localObject, 50.0F);
        i = bcwh.a((Context)localObject, 50.0F);
        j = 0;
        break;
        if ((paramSquareImageView.getContext() instanceof PublicAcntSearchActivity))
        {
          paramInt1 = bcwh.a(paramSquareImageView.getContext(), 50.0F);
          i = bcwh.a(paramSquareImageView.getContext(), 50.0F);
          j = 1;
          break;
        }
        paramInt1 = bcwh.a((Context)localObject, 60.0F);
        i = bcwh.a((Context)localObject, 60.0F);
        continue;
        paramInt1 = bcwh.a((Context)localObject, 50.0F);
        i = bcwh.a((Context)localObject, 50.0F);
        j = 1;
        break;
        paramInt1 = bcwh.a((Context)localObject, 60.0F);
        i = bcwh.a((Context)localObject, 85.0F);
        j = 0;
        break;
        paramInt1 = bcwh.a((Context)localObject, 113.0F);
        i = bcwh.a((Context)localObject, 60.0F);
        j = 0;
        break;
        paramInt1 = bcwh.a((Context)localObject, 100.0F);
        i = bcwh.a((Context)localObject, 141.0F);
        j = 0;
        break;
        paramInt1 = j;
        if ((paramayju instanceof aykk))
        {
          paramInt1 = bcwh.a((Context)localObject, paramayju.jdField_a_of_type_Ayjv.jdField_c_of_type_Int / 2);
          i = bcwh.a((Context)localObject, paramayju.jdField_a_of_type_Ayjv.d / 2);
        }
        if ((paramInt2 == paramayju.jdField_a_of_type_Ayjv.jdField_c_of_type_Int / 2) && (paramInt2 == paramayju.jdField_a_of_type_Ayjv.d / 2))
        {
          j = 1;
          break;
        }
        j = 0;
        break;
        paramInt1 = bcwh.a((Context)localObject, 220.0F);
        i = bcwh.a((Context)localObject, 136.0F);
        j = 0;
        break;
        paramInt1 = bcwh.a((Context)localObject, 162.0F);
        i = bcwh.a((Context)localObject, 162.0F);
        j = 0;
        break;
        paramInt1 = bcwh.a((Context)localObject, 162.0F);
        i = bcwh.a((Context)localObject, 228.0F);
        j = 0;
        break;
        paramInt1 = bcwh.a((Context)localObject, 162.0F);
        i = bcwh.a((Context)localObject, 162.0F);
        j = 1;
        break;
        paramayju.mFailedDrawable = localColorDrawable;
        paramayju.mLoadingDrawable = localColorDrawable;
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
        paramTextView.setTextColor(localContext.getResources().getColor(2131166902));
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
        paramTextView.setTextColor(localContext.getResources().getColor(2131166902));
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
        paramTextView.setTextColor(localContext.getResources().getColor(2131166903));
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
        paramTextView.setTextColor(localContext.getResources().getColor(2131166903));
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
        paramTextView.setTextColor(localContext.getResources().getColor(2131166903));
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
      paramTextView.setTextColor(localContext.getResources().getColor(2131167041));
      return;
    }
    paramTextView.setTextSize(1, 17.0F);
    paramTextView.setTextColor(localContext.getResources().getColor(2131166908));
    paramTextView.setIncludeFontPadding(false);
  }
  
  private void a(ayjs paramayjs, ayrz paramayrz)
  {
    Object localObject1 = BaseApplicationImpl.getApplication().getRuntime();
    Object localObject3 = paramayrz.a().getContext();
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
      paramayrz.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#737373"));
      if (!TextUtils.isEmpty(paramayjs.jdField_a_of_type_JavaLangCharSequence)) {
        break label593;
      }
      paramayrz.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      if (paramayjs.jdField_a_of_type_Ayjn == null) {
        break label775;
      }
      paramayrz.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      paramayrz.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      i = (int)(bdcb.k() - xod.a((Context)localObject3, 30.0F)) / 2 - xod.a((Context)localObject3, 3.0F);
      localObject1 = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject1).mPlayGifImage = true;
      ((URLDrawable.URLDrawableOptions)localObject1).mFailedDrawable = new ColorDrawable(Color.parseColor("#e7e7e7"));
      ((URLDrawable.URLDrawableOptions)localObject1).mLoadingDrawable = new ColorDrawable(Color.parseColor("#e7e7e7"));
      ((URLDrawable.URLDrawableOptions)localObject1).mRequestWidth = i;
      ((URLDrawable.URLDrawableOptions)localObject1).mRequestHeight = i;
      localObject2 = URLDrawable.getDrawable(paramayjs.jdField_a_of_type_Ayjn.jdField_a_of_type_JavaLangString, (URLDrawable.URLDrawableOptions)localObject1);
      paramayrz.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable((Drawable)localObject2);
      if ((((URLDrawable)localObject2).getStatus() != 1) && (((URLDrawable)localObject2).getStatus() != 0)) {
        ((URLDrawable)localObject2).restartDownload();
      }
      localObject2 = (LinearLayout.LayoutParams)paramayrz.jdField_a_of_type_ComTencentImageURLImageView.getLayoutParams();
      ((LinearLayout.LayoutParams)localObject2).height = i;
      ((LinearLayout.LayoutParams)localObject2).width = i;
      paramayrz.jdField_a_of_type_ComTencentImageURLImageView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
      paramayrz.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(0);
      if (paramayjs.jdField_a_of_type_JavaUtilList == null) {
        return;
      }
      m = Math.min(paramayjs.jdField_a_of_type_JavaUtilList.size(), 4);
      n = (i - xod.a((Context)localObject3, 3.0F)) / 2;
      localObject2 = new int[4];
      Object tmp295_293 = localObject2;
      tmp295_293[0] = 2131367944;
      Object tmp301_295 = tmp295_293;
      tmp301_295[1] = 2131367945;
      Object tmp307_301 = tmp301_295;
      tmp307_301[2] = 2131367946;
      Object tmp313_307 = tmp307_301;
      tmp313_307[3] = 2131367947;
      tmp313_307;
      i = 0;
      if (i >= m) {
        break label748;
      }
      localObject3 = (SquareImageView)paramayrz.jdField_b_of_type_AndroidWidgetLinearLayout.findViewById(localObject2[i]);
      localObject4 = ((ayjn)paramayjs.jdField_a_of_type_JavaUtilList.get(i)).jdField_a_of_type_JavaLangString;
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
      if ((i != 3) || (paramayjs.jdField_a_of_type_Int <= 4)) {
        break label731;
      }
      ((SquareImageView)localObject3).setFilterColor(Color.parseColor("#66000000"));
      k = paramayjs.jdField_a_of_type_Int - 4;
      localObject4 = new StringBuilder().append("+");
      j = k;
      if (k > 99) {
        j = 99;
      }
      ((SquareImageView)localObject3).setFilterText(j);
      ((SquareImageView)localObject3).setFilterTextSize(bcwh.a(paramayrz.a().getContext(), 20.0F));
    }
    for (;;)
    {
      i += 1;
      break label322;
      paramayrz.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#262626"));
      break;
      label593:
      i = (int)(paramayrz.jdField_a_of_type_AndroidWidgetTextView.getContext().getResources().getDisplayMetrics().widthPixels - bcwh.a(paramayrz.jdField_a_of_type_AndroidWidgetTextView.getContext(), 30.0F) - ayrd.a(paramayrz.jdField_a_of_type_AndroidWidgetTextView, paramayjs.jdField_a_of_type_JavaLangString));
      localObject2 = ayrd.a(paramayrz.jdField_a_of_type_AndroidWidgetTextView, i, 1, paramayjs.jdField_a_of_type_JavaLangCharSequence.toString(), paramayjs.jdField_a_of_type_Ayqs.jdField_a_of_type_JavaUtilList, false, false, true);
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      if (paramayjs.jdField_a_of_type_JavaLangString == null) {
        paramayjs.jdField_a_of_type_JavaLangString = "";
      }
      paramayrz.jdField_a_of_type_AndroidWidgetTextView.setText(new SpannableStringBuilder((CharSequence)localObject1).append(paramayjs.jdField_a_of_type_JavaLangString));
      paramayrz.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      break label59;
      label731:
      ((SquareImageView)localObject3).setFilterColor(-1);
      ((SquareImageView)localObject3).setFilterText("");
    }
    label748:
    while (i < 4)
    {
      paramayrz.jdField_b_of_type_AndroidWidgetLinearLayout.findViewById(localObject2[i]).setVisibility(4);
      i += 1;
    }
    label775:
    paramayrz.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    paramayrz.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
    if (paramayjs.jdField_a_of_type_JavaUtilList != null)
    {
      m = Math.min(paramayjs.jdField_a_of_type_JavaUtilList.size(), paramayrz.jdField_a_of_type_Int);
      n = (int)(bdcb.k() - xod.a(paramayrz.a().getContext(), (m - 1) * 2 + 27));
      i = 0;
      if (i < m)
      {
        localObject1 = (SquareImageView)paramayrz.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(i);
        localObject2 = ((ayjn)paramayjs.jdField_a_of_type_JavaUtilList.get(i)).jdField_a_of_type_JavaLangString;
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
        if (paramayjs.jdField_b_of_type_Int != 0)
        {
          ((SquareImageView)localObject1).setImageScale(n / 4 * 1.0F / bcwh.a((Context)localObject3, paramayjs.jdField_b_of_type_Int / 2), 0.0F);
          label1007:
          ((SquareImageView)localObject1).setVisibility(0);
          if ((i != paramayrz.jdField_a_of_type_Int - 1) || (paramayjs.jdField_a_of_type_Int <= paramayrz.jdField_a_of_type_Int)) {
            break label1136;
          }
          ((SquareImageView)localObject1).setFilterColor(Color.parseColor("#66000000"));
          k = paramayjs.jdField_a_of_type_Int - paramayrz.jdField_a_of_type_Int;
          localObject2 = new StringBuilder().append("+");
          j = k;
          if (k > 99) {
            j = 99;
          }
          ((SquareImageView)localObject1).setFilterText(j);
          ((SquareImageView)localObject1).setFilterTextSize(bcwh.a(paramayrz.a().getContext(), 20.0F));
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
      while (i < paramayrz.jdField_a_of_type_Int)
      {
        paramayrz.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(i).setVisibility(4);
        i += 1;
      }
    }
  }
  
  private void a(ayjt paramayjt, aysa paramaysa)
  {
    Object localObject = paramaysa.a().getContext();
    int i;
    if (!TextUtils.isEmpty(paramayjt.i))
    {
      paramaysa.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      a((Context)localObject, (SquareImageView)paramaysa.jdField_a_of_type_AndroidWidgetImageView, paramaysa.jdField_b_of_type_AndroidWidgetImageView, paramaysa.jdField_b_of_type_AndroidWidgetTextView, paramayjt.jdField_a_of_type_Int, paramayjt.i, paramayjt.jdField_b_of_type_JavaLangString, ((Context)localObject).getResources().getDimensionPixelSize(2131298229));
      i = ((Context)localObject).getResources().getDimensionPixelSize(2131298229);
      if ((paramayjt.jdField_a_of_type_Int == 6) || (paramayjt.jdField_a_of_type_Int == 8)) {
        i = bcwh.a((Context)localObject, 100.0F);
      }
      if (paramaysa.jdField_a_of_type_AndroidWidgetRelativeLayout.getVisibility() != 8) {
        break label317;
      }
      i = 0;
      label127:
      float f = ((Context)localObject).getResources().getDisplayMetrics().widthPixels - bcwh.a((Context)localObject, 30.0F);
      CharSequence localCharSequence = ayrd.a(paramaysa.jdField_a_of_type_AndroidWidgetTextView, f, 2, paramayjt.jdField_a_of_type_JavaLangCharSequence.toString(), paramayjt.jdField_a_of_type_Ayqs.jdField_a_of_type_JavaUtilList, false, true);
      paramaysa.jdField_a_of_type_AndroidWidgetTextView.setText(localCharSequence);
      f = ((Context)localObject).getResources().getDisplayMetrics().widthPixels - bcwh.a((Context)localObject, 30.0F) - i;
      localObject = ayrd.a(paramaysa.c, f, 2, paramayjt.jdField_b_of_type_JavaLangCharSequence.toString(), paramayjt.jdField_a_of_type_Ayqs.jdField_a_of_type_JavaUtilList, false, false);
      if (!ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null)) {
        break label333;
      }
      paramaysa.c.setTextColor(Color.parseColor("#4A4A4A"));
      paramaysa.jdField_d_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#4A4A4A"));
    }
    for (;;)
    {
      a(paramaysa.c, (CharSequence)localObject, true);
      a(paramaysa.jdField_d_of_type_AndroidWidgetTextView, paramayjt.jdField_c_of_type_JavaLangCharSequence);
      return;
      paramaysa.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      break;
      label317:
      i += bcwh.a((Context)localObject, 10.0F);
      break label127;
      label333:
      paramaysa.c.setTextColor(Color.parseColor("#737373"));
      paramaysa.jdField_d_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#737373"));
    }
  }
  
  private void a(ayjw paramayjw, aysc paramaysc)
  {
    Context localContext = paramaysc.a().getContext();
    int j;
    int i;
    if (paramayjw.jdField_a_of_type_Int == 1)
    {
      j = bcwh.a(localContext, 375.0F);
      i = bcwh.a(localContext, 150.0F);
    }
    for (;;)
    {
      int k;
      if ((j == 0) || (i == 0))
      {
        i = bcwh.a(localContext, 375.0F);
        j = bcwh.a(localContext, 150.0F);
        k = i;
        i = j;
      }
      for (;;)
      {
        if (!TextUtils.isEmpty(paramayjw.jdField_b_of_type_JavaLangString))
        {
          localObject = URLDrawable.URLDrawableOptions.obtain();
          ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
          ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
          ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = k;
          ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = i;
          ((URLDrawable.URLDrawableOptions)localObject).mPlayGifImage = true;
          localObject = URLDrawable.getDrawable(paramayjw.jdField_b_of_type_JavaLangString, (URLDrawable.URLDrawableOptions)localObject);
          paramaysc.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable((Drawable)localObject);
          if ((((URLDrawable)localObject).getStatus() != 1) && (((URLDrawable)localObject).getStatus() != 0)) {
            ((URLDrawable)localObject).restartDownload();
          }
          label164:
          paramaysc.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(0);
          localObject = (LinearLayout.LayoutParams)paramaysc.jdField_a_of_type_AndroidWidgetRelativeLayout.getLayoutParams();
          ((LinearLayout.LayoutParams)localObject).height = ((int)(i * xod.a(localContext) * 1.0F / k));
          paramaysc.jdField_a_of_type_AndroidWidgetRelativeLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
          paramaysc.jdField_a_of_type_AndroidWidgetRelativeLayout.setPadding(0, 0, 0, 0);
          if (TextUtils.isEmpty(paramayjw.jdField_a_of_type_JavaLangCharSequence)) {
            break label522;
          }
          paramaysc.jdField_b_of_type_AndroidWidgetTextView.setText(paramayjw.jdField_a_of_type_JavaLangCharSequence);
          paramaysc.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
          label253:
          if (TextUtils.isEmpty(paramayjw.jdField_b_of_type_JavaLangCharSequence)) {
            break label534;
          }
          paramaysc.c.setText(paramayjw.jdField_b_of_type_JavaLangCharSequence);
          paramaysc.c.setVisibility(0);
          label282:
          if (TextUtils.isEmpty(paramayjw.j)) {
            break label599;
          }
          paramaysc.jdField_d_of_type_AndroidWidgetTextView.setText(paramayjw.j);
        }
        try
        {
          if (!paramayjw.k.startsWith("#")) {
            paramayjw.k = ("#" + paramayjw.k);
          }
          paramaysc.jdField_d_of_type_AndroidWidgetTextView.setBackgroundColor(Color.parseColor(paramayjw.k));
        }
        catch (Exception localException)
        {
          for (;;)
          {
            label365:
            paramaysc.jdField_d_of_type_AndroidWidgetTextView.setBackgroundColor(Color.parseColor("#FF00FF00"));
            if (QLog.isColorLevel()) {
              QLog.e("Q.uniteSearch.SearchTemplatePresenter", 2, "bigImageItem.topLeftTagColor = " + paramayjw.k);
            }
          }
        }
        paramaysc.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
        Object localObject = ((ViewGroup)paramaysc.a()).getChildAt(((ViewGroup)paramaysc.a()).getChildCount() - 1);
        if ((localObject != null) && ((((View)localObject).getLayoutParams() instanceof LinearLayout.LayoutParams)))
        {
          if (paramayjw.b() != 0) {
            break label611;
          }
          ((LinearLayout.LayoutParams)((View)localObject).getLayoutParams()).topMargin = 0;
          paramaysc.jdField_a_of_type_AndroidWidgetRelativeLayout.setPadding(0, 0, 0, bcwh.a(localContext, 6.0F));
        }
        label522:
        label534:
        label599:
        label611:
        while (paramayjw.b() != 2)
        {
          return;
          if (paramayjw.jdField_a_of_type_Int == 2)
          {
            j = bcwh.a(localContext, 375.0F);
            i = bcwh.a(localContext, 180.0F);
            break;
          }
          if (paramayjw.jdField_a_of_type_Int != 0) {
            break label639;
          }
          j = bcwh.a(localContext, paramayjw.jdField_a_of_type_Float / 2.0F);
          i = bcwh.a(localContext, paramayjw.jdField_b_of_type_Float / 2.0F);
          break;
          paramaysc.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
          break label164;
          paramaysc.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
          break label253;
          paramaysc.c.setVisibility(8);
          break label282;
          paramaysc.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
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
  
  private void a(ayjy paramayjy, ayse paramayse)
  {
    Object localObject1 = paramayse.a().getContext();
    Object localObject2 = paramayse.a();
    if (paramayjy.jdField_b_of_type_Boolean) {
      ((View)localObject2).setPadding(((View)localObject2).getPaddingLeft(), xod.a(((View)localObject2).getContext(), 6.0F), ((View)localObject2).getPaddingRight(), xod.a(((View)localObject2).getContext(), 6.0F));
    }
    Object localObject3;
    int i;
    Object localObject4;
    for (;;)
    {
      localObject2 = (LinearLayout)((View)localObject2).findViewById(2131371964);
      localObject3 = new ArrayList();
      i = 0;
      while (i < ((LinearLayout)localObject2).getChildCount())
      {
        localObject4 = ((LinearLayout)localObject2).getChildAt(i).findViewById(2131368007);
        if ((localObject4 instanceof SquareImageView)) {
          ((List)localObject3).add((SquareImageView)localObject4);
        }
        i += 1;
      }
      ((View)localObject2).setPadding(((View)localObject2).getPaddingLeft(), xod.a(((View)localObject2).getContext(), 3.0F), ((View)localObject2).getPaddingRight(), xod.a(((View)localObject2).getContext(), 3.0F));
    }
    if (!((List)localObject3).isEmpty())
    {
      if (paramayjy.jdField_c_of_type_Boolean)
      {
        i = 0;
        while (i < ((List)localObject3).size())
        {
          ((SquareImageView)((List)localObject3).get(i)).setRoundRect(xod.a((Context)localObject1, 4.0F));
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
    if (!TextUtils.isEmpty(paramayjy.i)) {
      a((Context)localObject1, (SquareImageView)paramayse.b(), paramayse.jdField_b_of_type_AndroidWidgetImageView, paramayse.jdField_a_of_type_AndroidWidgetTextView, paramayjy.jdField_a_of_type_Int, paramayjy.i, null, bcwh.a((Context)localObject1, 32.0F));
    }
    label687:
    Object localObject5;
    if (!TextUtils.isEmpty(paramayjy.jdField_a_of_type_JavaLangString))
    {
      localObject2 = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
      ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
      ((URLDrawable.URLDrawableOptions)localObject2).mRequestWidth = paramayse.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams().width;
      ((URLDrawable.URLDrawableOptions)localObject2).mRequestHeight = paramayse.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams().height;
      localObject2 = URLDrawable.getDrawable(paramayjy.jdField_a_of_type_JavaLangString, (URLDrawable.URLDrawableOptions)localObject2);
      paramayse.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject2);
      if ((((URLDrawable)localObject2).getStatus() != 1) && (((URLDrawable)localObject2).getStatus() != 0)) {
        ((URLDrawable)localObject2).restartDownload();
      }
      paramayse.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      i = ((Context)localObject1).getResources().getDimensionPixelSize(2131298229);
      if ((paramayjy.jdField_a_of_type_Int == 6) || (paramayjy.jdField_a_of_type_Int == 8)) {
        i = bcwh.a((Context)localObject1, 100.0F);
      }
      localObject2 = ayrd.a(paramayse.a(), 10.0F * ayrd.a(paramayse.a(), alpo.a(2131714044)), 1, paramayjy.jdField_a_of_type_JavaLangCharSequence.toString(), paramayjy.jdField_a_of_type_Ayqs.jdField_a_of_type_JavaUtilList, false, false, true);
      paramayse.a().setText((CharSequence)localObject2);
      paramayse.a().setEllipsize(null);
      float f1 = ((Context)localObject1).getResources().getDisplayMetrics().widthPixels - bcwh.a((Context)localObject1, 40.0F) - i;
      localObject2 = ayrd.a(paramayse.b(), f1, 2, paramayjy.jdField_b_of_type_JavaLangCharSequence.toString(), "", false, false, true);
      a(paramayse.b(), (CharSequence)localObject2, false);
      if (TextUtils.isEmpty(paramayjy.jdField_c_of_type_JavaLangCharSequence)) {
        break label1047;
      }
      f1 = ((Context)localObject1).getResources().getDisplayMetrics().widthPixels - bcwh.a((Context)localObject1, 30.0F);
      localObject2 = ayrd.a(paramayse.c(), f1, 2, paramayjy.jdField_c_of_type_JavaLangCharSequence.toString(), paramayjy.jdField_a_of_type_Ayqs.jdField_a_of_type_JavaUtilList, false, false);
      paramayse.c().setText((CharSequence)localObject2);
      paramayse.c().setVisibility(0);
      if (paramayjy.jdField_a_of_type_JavaUtilList == null) {
        break label1479;
      }
      if (paramayjy.jdField_a_of_type_JavaUtilList.size() != 1) {
        break label1071;
      }
      paramayse.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(0);
      paramayse.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      localObject3 = paramayse.a().getResources();
      if (jdField_a_of_type_Int == 0) {
        jdField_a_of_type_Int = ((Resources)localObject3).getDisplayMetrics().widthPixels;
      }
      localObject2 = paramayse.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView;
      ((SquareImageView)localObject2).setImageScale((float)(1.0D / paramayjy.jdField_a_of_type_Double), 0.0F);
      f1 = ((Resources)localObject3).getDimension(2131298222);
      float f2 = ((Resources)localObject3).getDimension(2131298222);
      i = bcwh.a(paramayse.a().getContext(), 2.0F);
      j = paramayse.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount();
      j = (int)(jdField_a_of_type_Int - f1 - f2 - (j - 1) * i) / j;
      i = (int)(j * paramayjy.jdField_b_of_type_Double);
      j = (int)(j * paramayjy.jdField_b_of_type_Double);
      ((SquareImageView)localObject2).setLayoutParams(new FrameLayout.LayoutParams(i, j));
      localObject3 = (ayjn)paramayjy.jdField_a_of_type_JavaUtilList.get(0);
      localObject4 = ((ayjn)localObject3).jdField_a_of_type_JavaLangString;
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
      if (((ayjn)localObject3).jdField_a_of_type_Int != 2) {
        break label1059;
      }
      paramayse.jdField_d_of_type_AndroidWidgetImageView.setVisibility(0);
    }
    for (;;)
    {
      if ((paramayjy.jdField_c_of_type_JavaUtilList != null) || (!TextUtils.equals(paramayjy.k, "0")) || (!TextUtils.equals(paramayjy.m, "0"))) {
        break label1500;
      }
      paramayse.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      return;
      paramayse.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      break;
      label1047:
      paramayse.c().setVisibility(8);
      break label687;
      label1059:
      paramayse.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
      continue;
      label1071:
      paramayse.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(8);
      paramayse.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      int m = paramayse.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount();
      i = 0;
      j = i;
      if (i < paramayjy.jdField_a_of_type_JavaUtilList.size())
      {
        j = i;
        if (i < m)
        {
          localObject3 = paramayse.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(i);
          ((View)localObject3).setVisibility(0);
          localObject2 = (SquareImageView)((View)localObject3).findViewById(2131368007);
          localObject3 = (ImageView)((View)localObject3).findViewById(2131369119);
          ((SquareImageView)localObject2).setImageScale((float)(1.0D / paramayjy.jdField_a_of_type_Double), 0.0F);
          localObject4 = (ayjn)paramayjy.jdField_a_of_type_JavaUtilList.get(i);
          localObject5 = ((ayjn)localObject4).jdField_a_of_type_JavaLangString;
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
          if (((ayjn)localObject4).jdField_a_of_type_Int == 2)
          {
            ((ImageView)localObject3).setVisibility(0);
            label1312:
            if ((i != m - 1) || (paramayjy.jdField_b_of_type_Int <= m)) {
              break label1433;
            }
            ((ImageView)localObject3).setVisibility(8);
            ((SquareImageView)localObject2).setFilterColor(Color.parseColor("#66000000"));
            int k = paramayjy.jdField_b_of_type_Int - m;
            j = k;
            if (k > 99) {
              j = 99;
            }
            ((SquareImageView)localObject2).setFilterText("+" + j);
            ((SquareImageView)localObject2).setFilterTextSize(bcwh.a(((SquareImageView)localObject2).getContext(), 20.0F));
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
        paramayse.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(j).setVisibility(4);
        j += 1;
      }
      continue;
      label1479:
      paramayse.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(8);
      paramayse.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    }
    label1500:
    if (paramayjy.jdField_c_of_type_JavaUtilList != null)
    {
      paramayse.jdField_a_of_type_AndroidWidgetRelativeLayout.removeAllViews();
      i = paramayjy.jdField_c_of_type_JavaUtilList.size() - 1;
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
    for (int j = bcwh.a((Context)localObject1, 11.0F) * i;; j = 0)
    {
      localObject2 = (SquareImageView)LayoutInflater.from((Context)localObject1).inflate(2131559678, null, false);
      localObject3 = new RelativeLayout.LayoutParams(bcwh.a((Context)localObject1, 16.0F), bcwh.a((Context)localObject1, 16.0F));
      ((RelativeLayout.LayoutParams)localObject3).leftMargin = j;
      paramayse.jdField_a_of_type_AndroidWidgetRelativeLayout.addView((View)localObject2, paramayjy.jdField_c_of_type_JavaUtilList.size() - 1 - i, (ViewGroup.LayoutParams)localObject3);
      localObject3 = (String)paramayjy.jdField_c_of_type_JavaUtilList.get(i);
      localObject4 = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject4).mFailedDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
      ((URLDrawable.URLDrawableOptions)localObject4).mLoadingDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
      ((URLDrawable.URLDrawableOptions)localObject4).mRequestWidth = ((SquareImageView)localObject2).getLayoutParams().width;
      ((URLDrawable.URLDrawableOptions)localObject4).mRequestHeight = ((SquareImageView)localObject2).getLayoutParams().height;
      localObject3 = URLDrawable.getDrawable((String)localObject3, (URLDrawable.URLDrawableOptions)localObject4);
      ((URLDrawable)localObject3).setDecodeHandler(bcuq.a);
      ((SquareImageView)localObject2).setImageDrawable((Drawable)localObject3);
      if ((((URLDrawable)localObject3).getStatus() != 1) && (((URLDrawable)localObject3).getStatus() != 0)) {
        ((URLDrawable)localObject3).restartDownload();
      }
      ((SquareImageView)localObject2).setVisibility(0);
      i -= 1;
      break;
      paramayse.jdField_a_of_type_AndroidWidgetRelativeLayout.removeAllViews();
      label1758:
      if (!TextUtils.isEmpty(paramayjy.jdField_b_of_type_JavaLangString))
      {
        paramayse.jdField_b_of_type_AndroidWidgetTextView.setText(paramayjy.jdField_b_of_type_JavaLangString);
        paramayse.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
        if (TextUtils.isEmpty(paramayjy.j)) {
          break label2084;
        }
        localObject1 = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject1).mFailedDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
        ((URLDrawable.URLDrawableOptions)localObject1).mLoadingDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
        ((URLDrawable.URLDrawableOptions)localObject1).mRequestWidth = paramayse.jdField_a_of_type_ComTencentImageURLImageView.getLayoutParams().width;
        ((URLDrawable.URLDrawableOptions)localObject1).mRequestHeight = paramayse.jdField_a_of_type_ComTencentImageURLImageView.getLayoutParams().height;
        localObject1 = URLDrawable.getDrawable(paramayjy.j, (URLDrawable.URLDrawableOptions)localObject1);
        paramayse.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable((Drawable)localObject1);
        if ((((URLDrawable)localObject1).getStatus() != 1) && (((URLDrawable)localObject1).getStatus() != 0)) {
          ((URLDrawable)localObject1).restartDownload();
        }
        paramayse.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(0);
        label1900:
        if (TextUtils.isEmpty(paramayjy.k)) {
          break label2096;
        }
        paramayse.c.setText(paramayjy.k);
        paramayse.c.setVisibility(0);
        if (TextUtils.isEmpty(paramayjy.l)) {
          break label2108;
        }
        localObject1 = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject1).mFailedDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
        ((URLDrawable.URLDrawableOptions)localObject1).mLoadingDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
        ((URLDrawable.URLDrawableOptions)localObject1).mRequestWidth = paramayse.jdField_b_of_type_ComTencentImageURLImageView.getLayoutParams().width;
        ((URLDrawable.URLDrawableOptions)localObject1).mRequestHeight = paramayse.jdField_b_of_type_ComTencentImageURLImageView.getLayoutParams().height;
        localObject1 = URLDrawable.getDrawable(paramayjy.l, (URLDrawable.URLDrawableOptions)localObject1);
        paramayse.jdField_b_of_type_ComTencentImageURLImageView.setImageDrawable((Drawable)localObject1);
        if ((((URLDrawable)localObject1).getStatus() != 1) && (((URLDrawable)localObject1).getStatus() != 0)) {
          ((URLDrawable)localObject1).restartDownload();
        }
        paramayse.jdField_b_of_type_ComTencentImageURLImageView.setVisibility(0);
      }
      for (;;)
      {
        if (TextUtils.isEmpty(paramayjy.m)) {
          break label2120;
        }
        paramayse.jdField_d_of_type_AndroidWidgetTextView.setText(paramayjy.m);
        paramayse.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
        return;
        paramayse.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
        break;
        paramayse.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(8);
        break label1900;
        paramayse.c.setVisibility(8);
        break label1929;
        paramayse.jdField_b_of_type_ComTencentImageURLImageView.setVisibility(8);
      }
      paramayse.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
      return;
    }
  }
  
  private void a(ayke paramayke, aysk paramaysk)
  {
    Object localObject = paramaysk.a();
    Context localContext = ((View)localObject).getContext();
    if (((localObject instanceof LinearLayout)) && (((LinearLayout)localObject).getChildCount() == 1))
    {
      localObject = ((LinearLayout)localObject).getChildAt(0);
      ((View)localObject).setPadding(((View)localObject).getPaddingLeft(), 0, ((View)localObject).getPaddingRight(), 0);
    }
    if (!TextUtils.isEmpty(paramayke.jdField_b_of_type_JavaLangString))
    {
      localObject = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
      ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
      ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = bcwh.a(localContext, 50.0F);
      ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = bcwh.a(localContext, 50.0F);
      ((URLDrawable.URLDrawableOptions)localObject).mMemoryCacheKeySuffix = "leftIcon";
      localObject = URLDrawable.getDrawable(paramayke.jdField_b_of_type_JavaLangString, (URLDrawable.URLDrawableOptions)localObject);
      paramaysk.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable((Drawable)localObject);
      if ((((URLDrawable)localObject).getStatus() != 1) && (((URLDrawable)localObject).getStatus() != 0)) {
        ((URLDrawable)localObject).restartDownload();
      }
      paramaysk.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(0);
      if (TextUtils.isEmpty(paramayke.j)) {
        break label504;
      }
      paramaysk.jdField_a_of_type_AndroidWidgetTextView.setText(paramayke.j);
      paramaysk.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      label204:
      if (TextUtils.isEmpty(paramayke.g)) {
        break label516;
      }
      paramaysk.jdField_b_of_type_AndroidWidgetTextView.setText(paramayke.g);
      paramaysk.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      label233:
      if (TextUtils.isEmpty(paramayke.k)) {
        break label528;
      }
      paramaysk.c.setVisibility(0);
      paramaysk.c.setText(paramayke.k);
      label262:
      if (TextUtils.isEmpty(paramayke.l)) {
        break label540;
      }
      localObject = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
      ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
      ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = bcwh.a(localContext, 30.0F);
      ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = bcwh.a(localContext, 30.0F);
      ((URLDrawable.URLDrawableOptions)localObject).mMemoryCacheKeySuffix = "rightIcon";
      localObject = URLDrawable.getDrawable(paramayke.l, (URLDrawable.URLDrawableOptions)localObject);
      paramaysk.jdField_b_of_type_ComTencentImageURLImageView.setImageDrawable((Drawable)localObject);
      if ((((URLDrawable)localObject).getStatus() != 1) && (((URLDrawable)localObject).getStatus() != 0)) {
        ((URLDrawable)localObject).restartDownload();
      }
      paramaysk.jdField_b_of_type_ComTencentImageURLImageView.setVisibility(0);
      label377:
      paramaysk.a(paramayke);
      if (!ThemeUtil.isInNightMode(BaseApplicationImpl.getApplication().getRuntime())) {
        break label552;
      }
      paramaysk.jdField_a_of_type_AndroidWidgetLinearLayout.setBackgroundResource(2130839208);
      paramaysk.jdField_b_of_type_AndroidWidgetLinearLayout.setBackgroundResource(2130839208);
      paramaysk.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#737373"));
      paramaysk.c.setTextColor(Color.parseColor("#4A4A4A"));
    }
    for (;;)
    {
      if (paramaysk.jdField_b_of_type_AndroidWidgetTextView != null) {
        paramaysk.jdField_b_of_type_AndroidWidgetTextView.setTextColor(ayrd.b());
      }
      paramaysk.jdField_a_of_type_AndroidWidgetLinearLayout.setOnClickListener(new aynj(this, paramayke, localContext));
      paramaysk.jdField_b_of_type_AndroidWidgetLinearLayout.setOnClickListener(new aynk(this, paramayke, localContext));
      return;
      paramaysk.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(8);
      break;
      label504:
      paramaysk.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      break label204;
      label516:
      paramaysk.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      break label233;
      label528:
      paramaysk.c.setVisibility(8);
      break label262;
      label540:
      paramaysk.jdField_b_of_type_ComTencentImageURLImageView.setVisibility(8);
      break label377;
      label552:
      paramaysk.jdField_a_of_type_AndroidWidgetLinearLayout.setBackgroundResource(2130839207);
      paramaysk.jdField_b_of_type_AndroidWidgetLinearLayout.setBackgroundResource(2130839207);
      paramaysk.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#262626"));
      paramaysk.c.setTextColor(Color.parseColor("#737373"));
    }
  }
  
  private void a(aykf paramaykf, aysm paramaysm)
  {
    Object localObject = paramaysm.a();
    Context localContext = ((View)localObject).getContext();
    if (((localObject instanceof LinearLayout)) && (((LinearLayout)localObject).getChildCount() == 1))
    {
      localObject = ((LinearLayout)localObject).getChildAt(0);
      ((View)localObject).setPadding(((View)localObject).getPaddingLeft(), 0, ((View)localObject).getPaddingRight(), 0);
    }
    if (!TextUtils.isEmpty(paramaykf.jdField_b_of_type_JavaLangString))
    {
      localObject = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
      ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
      ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = bcwh.a(localContext, 40.0F);
      ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = bcwh.a(localContext, 40.0F);
      ((URLDrawable.URLDrawableOptions)localObject).mMemoryCacheKeySuffix = "leftIcon";
      localObject = URLDrawable.getDrawable(paramaykf.jdField_b_of_type_JavaLangString, (URLDrawable.URLDrawableOptions)localObject);
      paramaysm.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable((Drawable)localObject);
      if ((((URLDrawable)localObject).getStatus() != 1) && (((URLDrawable)localObject).getStatus() != 0)) {
        ((URLDrawable)localObject).restartDownload();
      }
      paramaysm.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(0);
      if (TextUtils.isEmpty(paramaykf.j)) {
        break label363;
      }
      paramaysm.jdField_a_of_type_AndroidWidgetTextView.setText(paramaykf.j);
      paramaysm.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      label204:
      if (TextUtils.isEmpty(paramaykf.g)) {
        break label375;
      }
      paramaysm.c.setText(paramaykf.g);
      paramaysm.c.setVisibility(0);
      label233:
      if (TextUtils.isEmpty(paramaykf.k)) {
        break label387;
      }
      paramaysm.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
      paramaysm.jdField_d_of_type_AndroidWidgetTextView.setText(paramaykf.k);
      label262:
      if (!paramaykf.jdField_b_of_type_Boolean) {
        break label399;
      }
      paramaysm.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    }
    for (;;)
    {
      aynt.a(null, 0, paramaykf.jdField_c_of_type_Int, "0X8009D5C", 0, 0, null, null);
      if ((paramaykf.jdField_a_of_type_JavaUtilList != null) && (paramaykf.jdField_a_of_type_JavaUtilList.size() > 0)) {
        aynt.a(null, 0, paramaykf.jdField_c_of_type_Int, "0X8009D5E", 0, 0, null, null);
      }
      paramaysm.a(paramaykf);
      paramaysm.jdField_a_of_type_AndroidWidgetLinearLayout.setOnClickListener(new ayni(this, paramaykf, localContext));
      return;
      paramaysm.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(8);
      break;
      label363:
      paramaysm.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      break label204;
      label375:
      paramaysm.c.setVisibility(8);
      break label233;
      label387:
      paramaysm.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
      break label262;
      label399:
      paramaysm.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    }
  }
  
  private void a(aykh paramaykh, ayss paramayss)
  {
    if ((paramaykh == null) || (paramayss == null)) {
      return;
    }
    paramayss.jdField_a_of_type_AndroidWidgetLinearLayout.setPadding(paramayss.jdField_a_of_type_AndroidWidgetLinearLayout.getPaddingLeft(), 0, paramayss.jdField_a_of_type_AndroidWidgetLinearLayout.getPaddingRight(), 0);
    Object localObject = (RelativeLayout.LayoutParams)paramayss.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams();
    boolean bool = ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null);
    if (paramaykh.jdField_b_of_type_Boolean)
    {
      ((RelativeLayout.LayoutParams)localObject).addRule(5, 0);
      ((RelativeLayout.LayoutParams)localObject).addRule(14);
      localObject = paramayss.jdField_a_of_type_AndroidWidgetTextView.getContext();
      int i = ((Context)localObject).getResources().getDisplayMetrics().widthPixels - bcwh.a((Context)localObject, 38.0F);
      if (TextUtils.isEmpty(paramaykh.jdField_b_of_type_JavaLangCharSequence)) {
        break label310;
      }
      paramayss.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      if (!bool) {
        break label296;
      }
      paramayss.jdField_b_of_type_AndroidWidgetTextView.setText(paramaykh.jdField_b_of_type_JavaLangCharSequence.toString());
      label148:
      float f1 = i;
      float f2 = ayrd.a(paramayss.jdField_b_of_type_AndroidWidgetTextView, paramaykh.jdField_b_of_type_JavaLangCharSequence);
      i = (int)(f1 - (bcwh.a((Context)localObject, 10.0F) + f2));
      label182:
      if (TextUtils.isEmpty(paramaykh.jdField_a_of_type_JavaLangCharSequence)) {
        break label334;
      }
      paramayss.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      localObject = paramaykh.jdField_a_of_type_JavaLangCharSequence;
      if (paramaykh.jdField_b_of_type_Boolean) {
        break label346;
      }
      localObject = ayrd.a(paramayss.jdField_a_of_type_AndroidWidgetTextView, i, (CharSequence)localObject);
    }
    label296:
    label310:
    label334:
    label346:
    for (;;)
    {
      if (bool) {
        paramayss.jdField_a_of_type_AndroidWidgetTextView.setText(((CharSequence)localObject).toString());
      }
      for (;;)
      {
        paramayss.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundDrawable(a(paramaykh.jdField_a_of_type_JavaLangString));
        paramayss.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(new aynl(this, paramaykh, paramayss));
        return;
        ((RelativeLayout.LayoutParams)localObject).addRule(14, 0);
        ((RelativeLayout.LayoutParams)localObject).addRule(5);
        break;
        paramayss.jdField_b_of_type_AndroidWidgetTextView.setText(paramaykh.jdField_b_of_type_JavaLangCharSequence);
        break label148;
        paramayss.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
        break label182;
        paramayss.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
        continue;
        paramayss.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      }
    }
  }
  
  private void a(ayki paramayki, aysr paramaysr)
  {
    if ((paramayki == null) || (paramaysr == null)) {}
    while ((TextUtils.isEmpty(paramayki.jdField_a_of_type_JavaLangString)) || (paramaysr.jdField_a_of_type_AndroidWidgetTextView == null)) {
      return;
    }
    Context localContext = paramaysr.jdField_a_of_type_AndroidWidgetTextView.getContext();
    int j = localContext.getResources().getDisplayMetrics().widthPixels - bcwh.a(localContext, 40.0F);
    int i;
    if ((!TextUtils.isEmpty(paramayki.e)) && (paramaysr.jdField_a_of_type_AndroidWidgetLinearLayout != null))
    {
      paramaysr.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      i = j - bcwh.a(localContext, 26.0F);
    }
    for (;;)
    {
      paramayki = ayrd.a(paramaysr.jdField_a_of_type_AndroidWidgetTextView, i, paramayki.jdField_a_of_type_JavaLangString);
      paramaysr.jdField_a_of_type_AndroidWidgetTextView.setText(paramayki);
      return;
      i = j;
      if (paramaysr.jdField_a_of_type_AndroidWidgetLinearLayout != null)
      {
        paramaysr.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
        i = j;
      }
    }
  }
  
  private void a(aykk paramaykk, aysu paramaysu)
  {
    Context localContext = paramaysu.jdField_b_of_type_AndroidWidgetRelativeLayout.getContext();
    Object localObject = (RelativeLayout.LayoutParams)paramaysu.jdField_a_of_type_AndroidWidgetLinearLayout.getLayoutParams();
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)paramaysu.jdField_b_of_type_AndroidWidgetRelativeLayout.getLayoutParams();
    if (paramaykk.jdField_b_of_type_Boolean)
    {
      ((RelativeLayout.LayoutParams)localObject).addRule(15);
      localLayoutParams.addRule(15);
      localLayoutParams.addRule(10, 0);
      localLayoutParams.addRule(10, 0);
    }
    for (;;)
    {
      localObject = a(paramaykk, paramaysu, false, 0);
      if (((Integer)((Pair)localObject).first).intValue() != 0) {
        ((RelativeLayout.LayoutParams)paramaysu.jdField_b_of_type_AndroidWidgetRelativeLayout.getLayoutParams()).rightMargin = bcwh.a(localContext, 10.0F);
      }
      int i = a(paramaykk, paramaysu);
      int j = a(paramaykk, paramaysu, ((Integer)((Pair)localObject).first).intValue(), i);
      i = j;
      if (((Integer)((Pair)localObject).second).intValue() > j) {
        i = ((Integer)((Pair)localObject).second).intValue();
      }
      if (paramaysu.jdField_a_of_type_AndroidWidgetRelativeLayout != null) {
        ((RelativeLayout.LayoutParams)paramaysu.jdField_a_of_type_AndroidWidgetRelativeLayout.getLayoutParams()).height = i;
      }
      return;
      ((RelativeLayout.LayoutParams)localObject).addRule(10);
      localLayoutParams.addRule(10);
      ((RelativeLayout.LayoutParams)localObject).addRule(15, 0);
      localLayoutParams.addRule(15, 0);
    }
  }
  
  private void a(ayko paramayko, aysv paramaysv)
  {
    Object localObject1 = paramaysv.a().getContext();
    Object localObject2 = paramaysv.a();
    if (paramayko.jdField_b_of_type_Boolean) {
      ((View)localObject2).setPadding(((View)localObject2).getPaddingLeft(), xod.a(((View)localObject2).getContext(), 9.0F), ((View)localObject2).getPaddingRight(), xod.a(((View)localObject2).getContext(), 9.0F));
    }
    Object localObject3;
    int i;
    Object localObject4;
    for (;;)
    {
      localObject2 = (LinearLayout)((View)localObject2).findViewById(2131371964);
      localObject3 = new ArrayList();
      i = 0;
      while (i < ((LinearLayout)localObject2).getChildCount())
      {
        localObject4 = ((LinearLayout)localObject2).getChildAt(i).findViewById(2131368007);
        if ((localObject4 instanceof SquareImageView)) {
          ((List)localObject3).add((SquareImageView)localObject4);
        }
        i += 1;
      }
      ((View)localObject2).setPadding(((View)localObject2).getPaddingLeft(), xod.a(((View)localObject2).getContext(), 6.0F), ((View)localObject2).getPaddingRight(), xod.a(((View)localObject2).getContext(), 6.0F));
    }
    if (!((List)localObject3).isEmpty())
    {
      if (paramayko.jdField_c_of_type_Boolean)
      {
        i = 0;
        while (i < ((List)localObject3).size())
        {
          ((SquareImageView)((List)localObject3).get(i)).setRoundRect(xod.a((Context)localObject1, 4.0F));
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
      paramaysv.a().setTextColor(Color.parseColor("#6991B8"));
      paramaysv.c().setTextColor(Color.parseColor("#44608A"));
      paramaysv.b().setTextColor(Color.parseColor("#44608A"));
      if (!TextUtils.isEmpty(paramayko.i)) {
        a((Context)localObject1, (SquareImageView)paramaysv.b(), paramaysv.jdField_b_of_type_AndroidWidgetImageView, paramaysv.jdField_a_of_type_AndroidWidgetTextView, paramayko.jdField_a_of_type_Int, paramayko.i, null, bcwh.a((Context)localObject1, 21.0F));
      }
      if (TextUtils.isEmpty(paramayko.jdField_a_of_type_JavaLangString)) {
        break label1085;
      }
      localObject2 = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
      ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
      ((URLDrawable.URLDrawableOptions)localObject2).mRequestWidth = paramaysv.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams().width;
      ((URLDrawable.URLDrawableOptions)localObject2).mRequestHeight = paramaysv.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams().height;
      localObject2 = URLDrawable.getDrawable(paramayko.jdField_a_of_type_JavaLangString, (URLDrawable.URLDrawableOptions)localObject2);
      paramaysv.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject2);
      if ((((URLDrawable)localObject2).getStatus() != 1) && (((URLDrawable)localObject2).getStatus() != 0)) {
        ((URLDrawable)localObject2).restartDownload();
      }
      paramaysv.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      i = ((Context)localObject1).getResources().getDimensionPixelSize(2131298229);
      if ((paramayko.jdField_a_of_type_Int == 6) || (paramayko.jdField_a_of_type_Int == 8)) {
        i = bcwh.a((Context)localObject1, 100.0F);
      }
      localObject2 = ayrd.a(paramaysv.a(), 10.0F * ayrd.a(paramaysv.a(), alpo.a(2131714043)), 1, paramayko.jdField_a_of_type_JavaLangCharSequence.toString(), paramayko.jdField_a_of_type_Ayqs.jdField_a_of_type_JavaUtilList, false, false, true);
      paramaysv.a().setText((CharSequence)localObject2);
      paramaysv.a().setEllipsize(null);
      float f1 = ((Context)localObject1).getResources().getDisplayMetrics().widthPixels - bcwh.a((Context)localObject1, 40.0F) - i;
      localObject2 = ayrd.a(paramaysv.b(), f1, 2, paramayko.jdField_b_of_type_JavaLangCharSequence.toString(), "", false, false, true);
      a(paramaysv.b(), (CharSequence)localObject2, false);
      if (TextUtils.isEmpty(paramayko.jdField_c_of_type_JavaLangCharSequence)) {
        break label1097;
      }
      f1 = ((Context)localObject1).getResources().getDisplayMetrics().widthPixels - bcwh.a((Context)localObject1, 30.0F);
      localObject2 = ayrd.a(paramaysv.c(), f1, 2, paramayko.jdField_c_of_type_JavaLangCharSequence.toString(), paramayko.jdField_a_of_type_Ayqs.jdField_a_of_type_JavaUtilList, false, false);
      paramaysv.c().setText((CharSequence)localObject2);
      paramaysv.c().setVisibility(0);
      label740:
      if (paramayko.jdField_a_of_type_JavaUtilList == null) {
        break label1546;
      }
      if (paramayko.jdField_a_of_type_JavaUtilList.size() != 1) {
        break label1119;
      }
      paramaysv.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(0);
      paramaysv.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      localObject2 = paramaysv.a().getResources();
      if (jdField_a_of_type_Int == 0) {
        jdField_a_of_type_Int = ((Resources)localObject2).getDisplayMetrics().widthPixels;
      }
      localObject1 = paramaysv.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView;
      ((SquareImageView)localObject1).setImageScale((float)(1.0D / paramayko.jdField_a_of_type_Double), 0.0F);
      f1 = ((Resources)localObject2).getDimension(2131298222);
      float f2 = ((Resources)localObject2).getDimension(2131298222);
      i = bcwh.a(paramaysv.a().getContext(), 2.0F);
      j = paramaysv.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount();
      j = (int)(jdField_a_of_type_Int - f1 - f2 - (j - 1) * i) / j;
      i = (int)(j * paramayko.jdField_b_of_type_Double);
      j = (int)(j * paramayko.jdField_b_of_type_Double);
      ((SquareImageView)localObject1).setLayoutParams(new FrameLayout.LayoutParams(i, j));
      paramayko = (ayjn)paramayko.jdField_a_of_type_JavaUtilList.get(0);
      localObject2 = paramayko.jdField_a_of_type_JavaLangString;
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
      if (paramayko.jdField_a_of_type_Int != 2) {
        break label1109;
      }
      paramaysv.jdField_d_of_type_AndroidWidgetImageView.setVisibility(0);
    }
    for (;;)
    {
      return;
      paramaysv.a().setTextColor(Color.parseColor("#262626"));
      paramaysv.c().setTextColor(Color.parseColor("#737373"));
      paramaysv.b().setTextColor(Color.parseColor("#737373"));
      break;
      label1085:
      paramaysv.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      break label496;
      label1097:
      paramaysv.c().setVisibility(8);
      break label740;
      label1109:
      paramaysv.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
      return;
      label1119:
      paramaysv.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(8);
      paramaysv.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      int m = paramaysv.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount();
      i = 0;
      j = i;
      if (i < paramayko.jdField_a_of_type_JavaUtilList.size())
      {
        j = i;
        if (i < m)
        {
          localObject3 = paramaysv.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(i);
          ((View)localObject3).setVisibility(0);
          localObject2 = (SquareImageView)((View)localObject3).findViewById(2131368007);
          localObject3 = (ImageView)((View)localObject3).findViewById(2131369119);
          j = xod.a((Context)localObject1) / m;
          int k = (int)(j * paramayko.jdField_a_of_type_Double);
          ((SquareImageView)localObject2).setImageScale((float)(1.0D / paramayko.jdField_a_of_type_Double), 0.0F);
          localObject4 = (ayjn)paramayko.jdField_a_of_type_JavaUtilList.get(i);
          Object localObject5 = ((ayjn)localObject4).jdField_a_of_type_JavaLangString;
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
          if (((ayjn)localObject4).jdField_a_of_type_Int == 2)
          {
            ((ImageView)localObject3).setVisibility(0);
            label1379:
            if ((i != m - 1) || (paramayko.jdField_b_of_type_Int <= m)) {
              break label1500;
            }
            ((ImageView)localObject3).setVisibility(8);
            ((SquareImageView)localObject2).setFilterColor(Color.parseColor("#66000000"));
            k = paramayko.jdField_b_of_type_Int - m;
            j = k;
            if (k > 99) {
              j = 99;
            }
            ((SquareImageView)localObject2).setFilterText("+" + j);
            ((SquareImageView)localObject2).setFilterTextSize(bcwh.a(((SquareImageView)localObject2).getContext(), 20.0F));
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
        paramaysv.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(j).setVisibility(4);
        j += 1;
      }
    }
    label1546:
    paramaysv.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(8);
    paramaysv.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
  }
  
  private void a(SquareImageView paramSquareImageView, int paramInt1, int paramInt2, String paramString)
  {
    if ((paramSquareImageView == null) || (TextUtils.isEmpty(paramString))) {
      return;
    }
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mFailedDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
    localURLDrawableOptions.mLoadingDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
    paramSquareImageView.getLayoutParams().width = bcwh.a(paramSquareImageView.getContext(), paramInt1);
    paramSquareImageView.getLayoutParams().height = bcwh.a(paramSquareImageView.getContext(), paramInt2);
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
  
  private void b(aykk paramaykk, aysu paramaysu)
  {
    if ((paramaykk == null) || (paramaykk.jdField_a_of_type_Aykl == null) || (paramaysu == null)) {
      if ((paramaysu != null) && (paramaysu.jdField_b_of_type_AndroidWidgetButton != null)) {
        paramaysu.jdField_b_of_type_AndroidWidgetButton.setVisibility(8);
      }
    }
    while (paramaysu.jdField_b_of_type_AndroidWidgetButton == null) {
      return;
    }
    Context localContext = paramaysu.jdField_b_of_type_AndroidWidgetButton.getContext();
    if ((paramaykk.jdField_a_of_type_Aykl.jdField_a_of_type_Int == 1) && (!TextUtils.isEmpty(paramaykk.jdField_a_of_type_Aykl.jdField_a_of_type_JavaLangCharSequence)))
    {
      paramaysu.jdField_b_of_type_AndroidWidgetButton.setVisibility(0);
      paramaysu.jdField_b_of_type_AndroidWidgetButton.setText(paramaykk.jdField_a_of_type_Aykl.jdField_a_of_type_JavaLangCharSequence);
      paramaysu.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(new ayno(this, localContext, paramaykk));
      return;
    }
    paramaysu.jdField_b_of_type_AndroidWidgetButton.setVisibility(8);
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
      a(paramSquareImageView, paramImageView, paramTextView, paramInt2, paramInt2, false, paramString1, null, 2130841963, false);
      return;
    case 4: 
      a(paramSquareImageView, paramImageView, paramTextView, paramInt2, paramInt2, false, paramString1, null, 2130841963, false);
      return;
    case 5: 
      a(paramSquareImageView, paramImageView, paramTextView, paramInt2, paramInt2, false, paramString1, null, 0, true);
      return;
    case 6: 
      paramInt1 = bcwh.a(paramContext, 62.0F);
      a(paramSquareImageView, paramImageView, paramTextView, bcwh.a(paramContext, 100.0F), paramInt1, false, paramString1, null, 2130841963, false);
      return;
    case 7: 
      a(paramSquareImageView, paramImageView, paramTextView, bcwh.a(paramContext, 100.0F), bcwh.a(paramContext, 62.0F), false, paramString1, paramString2, 0, false);
      return;
    }
    a(paramSquareImageView, paramImageView, paramTextView, bcwh.a(paramContext, 100.0F), bcwh.a(paramContext, 62.0F), false, paramString1, null, 0, false);
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
  
  public void a(ayju paramayju, aysb paramaysb)
  {
    ayrg.a(paramayju.a(), paramayju.b(), paramaysb.a(), paramayju.jdField_a_of_type_Boolean, paramayju.r, paramayju.f);
    switch (paramayju.d())
    {
    }
    for (;;)
    {
      b(paramayju, paramaysb);
      if (TextUtils.isEmpty(paramayju.i)) {
        c(paramayju, paramaysb);
      }
      return;
      a((ayjs)paramayju, (ayrz)paramaysb);
      continue;
      a((ayko)paramayju, (aysv)paramaysb);
      continue;
      a((ayjt)paramayju, (aysa)paramaysb);
      continue;
      a((aykb)paramayju, (aysh)paramaysb);
      continue;
      a((aykk)paramayju, (aysu)paramaysb);
      continue;
      a((aykh)paramayju, (ayss)paramaysb);
      continue;
      a((ayki)paramayju, (aysr)paramaysb);
      continue;
      a((ayjy)paramayju, (ayse)paramaysb);
      continue;
      a((ayjw)paramayju, (aysc)paramaysb);
      continue;
      a((ayjz)paramayju, (aysf)paramaysb);
      continue;
      a((aykj)paramayju, (ayst)paramaysb);
      continue;
      a((aykg)paramayju, (aysp)paramaysb);
      continue;
      a((ayke)paramayju, (aysk)paramaysb);
      continue;
      a((aykf)paramayju, (aysm)paramaysb);
      continue;
      a((aykd)paramayju, (aysj)paramaysb);
    }
  }
  
  public void a(ayju paramayju, aysb paramaysb, Bitmap paramBitmap)
  {
    if (paramaysb.b() != null) {
      paramaysb.b().setImageBitmap(paramBitmap);
    }
  }
  
  protected void a(ayjz paramayjz, aysf paramaysf)
  {
    if ((paramayjz.jdField_a_of_type_JavaUtilArrayList == null) || (paramayjz.jdField_a_of_type_JavaUtilArrayList.size() == 0))
    {
      if (QLog.isColorLevel()) {
        QLog.e("Q.uniteSearch.SearchTemplatePresenter", 2, "bindHorSlidingContainerTemplateView, containerItem.horizontalModelItems is empty");
      }
      return;
    }
    ayfi localayfi2 = (ayfi)paramaysf.jdField_a_of_type_ComTencentWidgetHorizontalListView.getAdapter();
    ayfi localayfi1;
    if (localayfi2 != null)
    {
      localayfi1 = localayfi2;
      if (localayfi2.a() == paramayjz.jdField_a_of_type_JavaUtilArrayList) {}
    }
    else
    {
      localayfi1 = new ayfi(paramayjz, this.jdField_a_of_type_Ayfh.jdField_b_of_type_Int, paramaysf.jdField_a_of_type_ComTencentWidgetHorizontalListView);
      paramaysf.jdField_a_of_type_ComTencentWidgetHorizontalListView.setAdapter(localayfi1);
    }
    if (localayfi1.a() != paramayjz.jdField_a_of_type_JavaUtilArrayList)
    {
      paramaysf.jdField_a_of_type_Ayjz = paramayjz;
      paramaysf.jdField_a_of_type_ComTencentWidgetHorizontalListView.resetCurrentX(paramayjz.jdField_b_of_type_Int);
    }
    localayfi1.a(paramayjz.jdField_a_of_type_JavaUtilArrayList);
  }
  
  protected void a(aykb paramaykb, aysh paramaysh)
  {
    paramaysh.a().getContext();
    paramaysh.a();
    if ((paramaykb.jdField_a_of_type_JavaUtilArrayList == null) || (paramaykb.jdField_a_of_type_JavaUtilArrayList.size() == 0)) {
      if (QLog.isColorLevel()) {
        QLog.e("Q.uniteSearch.SearchTemplatePresenter", 2, "bindHorizontalContainerTemplateView, containerItem.horizontalModelItems is empty");
      }
    }
    for (;;)
    {
      return;
      paramaysh.a(paramaykb);
      if (paramaykb.jdField_a_of_type_JavaUtilArrayList.size() != paramaysh.jdField_a_of_type_JavaUtilArrayList.size()) {
        QLog.e("Q.uniteSearch.SearchTemplatePresenter", 2, "bindHorizontalContainerTemplateView, view.size != model.size");
      }
      int j = paramaykb.jdField_a_of_type_JavaUtilArrayList.size();
      int i = 0;
      while (i < j)
      {
        ((ayka)paramaykb.jdField_a_of_type_JavaUtilArrayList.get(i)).a((aysg)paramaysh.jdField_a_of_type_JavaUtilArrayList.get(i));
        i += 1;
      }
    }
  }
  
  protected void a(aykd paramaykd, aysj paramaysj)
  {
    Object localObject2 = (LinearLayout)paramaysj.b();
    Object localObject1;
    Object localObject3;
    ayrx localayrx;
    if ((localObject2 != null) && (paramaykd.a != null))
    {
      ((LinearLayout)localObject2).removeAllViews();
      if (((LinearLayout)localObject2).getParent() != null) {
        ((View)((LinearLayout)localObject2).getParent()).setPadding(0, 0, 0, 0);
      }
      localObject1 = paramaykd.a;
      paramaykd = paramaysj.a().getContext();
      localObject3 = LayoutInflater.from(paramaykd).inflate(2131562593, null);
      localayrx = new ayrx((View)localObject3);
      Object localObject4 = ((View)localObject3).findViewById(2131368472);
      int i = bdkf.a(6.0F);
      ((View)localObject4).setPadding(0, i, 0, i);
      ((LinearLayout)localObject2).addView((View)localObject3);
      if (((ayjq)localObject1).c() != null) {
        break label559;
      }
      if (localayrx.c() != null) {
        localayrx.c().setVisibility(8);
      }
      if (localayrx.a() != null) {
        localayrx.a().setVisibility(8);
      }
      localObject2 = localayrx.a();
      if (localObject2 != null) {
        ((URLImageView)localObject2).setVisibility(8);
      }
      localObject2 = localayrx.e();
      if (localObject2 != null)
      {
        ((TextView)localObject2).setVisibility(0);
        if (!TextUtils.isEmpty(((ayjq)localObject1).a())) {
          ((TextView)localObject2).setText(((ayjq)localObject1).a());
        }
      }
      if ((localayrx.b() != null) && (!TextUtils.isEmpty(((ayjq)localObject1).g())))
      {
        localObject2 = ((ayjq)localObject1).g();
        localObject3 = new ColorDrawable(Color.parseColor("#e7e7e7"));
        localObject4 = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject4).mRequestWidth = bcwh.a(paramaykd, 50.0F);
        ((URLDrawable.URLDrawableOptions)localObject4).mRequestHeight = bcwh.a(paramaykd, 50.0F);
        ((URLDrawable.URLDrawableOptions)localObject4).mFailedDrawable = ((Drawable)localObject3);
        ((URLDrawable.URLDrawableOptions)localObject4).mLoadingDrawable = ((Drawable)localObject3);
        if (!bhos.a((String)localObject2)) {
          break label684;
        }
        localObject2 = URLDrawable.getDrawable((String)localObject2, (URLDrawable.URLDrawableOptions)localObject4);
        ((URLDrawable)localObject2).setTag(bcuq.b(bcwh.a(paramaykd, 50.0F), bcwh.a(paramaysj.a().getContext(), 50.0F), bcwh.a(paramaykd, 3.0F)));
        ((URLDrawable)localObject2).setDecodeHandler(bcuq.i);
        localayrx.b().setImageDrawable((Drawable)localObject2);
        if ((((URLDrawable)localObject2).getStatus() != 1) && (((URLDrawable)localObject2).getStatus() != 0)) {
          ((URLDrawable)localObject2).restartDownload();
        }
      }
    }
    for (;;)
    {
      localayrx.a().setOnClickListener(new aynh(this, (ayjq)localObject1));
      if ((localayrx.a() != null) && (((ayjq)localObject1).c()))
      {
        paramaysj = ((ayjq)localObject1).h();
        localObject1 = new ColorDrawable(Color.parseColor("#e7e7e7"));
        localObject2 = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject2).mRequestWidth = bcwh.a(paramaykd, 40.0F);
        ((URLDrawable.URLDrawableOptions)localObject2).mRequestHeight = bcwh.a(paramaykd, 12.0F);
        ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = ((Drawable)localObject1);
        ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = ((Drawable)localObject1);
        paramaysj = URLDrawable.getDrawable(paramaysj, (URLDrawable.URLDrawableOptions)localObject2);
        paramaysj.setTag(bcuq.b(bcwh.a(paramaykd, 38.0F), bcwh.a(paramaykd, 12.0F), 0));
        paramaysj.setDecodeHandler(bcuq.i);
        localayrx.a().setImageDrawable(paramaysj);
        if ((paramaysj.getStatus() != 1) && (paramaysj.getStatus() != 0)) {
          paramaysj.restartDownload();
        }
      }
      return;
      label559:
      if ((localayrx.c() != null) && (!TextUtils.isEmpty(((ayjq)localObject1).c())))
      {
        localayrx.c().setVisibility(0);
        localayrx.c().setText(((ayjq)localObject1).c());
      }
      for (;;)
      {
        if (localayrx.a() != null) {
          localayrx.a().setVisibility(0);
        }
        localObject2 = localayrx.e();
        if (localObject2 != null) {
          ((TextView)localObject2).setVisibility(8);
        }
        if (TextUtils.isEmpty(((ayjq)localObject1).a())) {
          break;
        }
        localayrx.a().setText(((ayjq)localObject1).a());
        break;
        if (localayrx.c() != null) {
          localayrx.c().setVisibility(8);
        }
      }
      label684:
      localayrx.b().setImageDrawable((Drawable)localObject3);
    }
  }
  
  protected void a(aykg paramaykg, aysp paramaysp)
  {
    Object localObject1 = paramaysp.a().getContext();
    if (ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null))
    {
      paramaysp.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#737373"));
      paramaysp.jdField_b_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#4A4A4A"));
      if (TextUtils.isEmpty(paramaykg.jdField_b_of_type_JavaLangString)) {
        break label290;
      }
      Object localObject2 = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
      ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
      ((URLDrawable.URLDrawableOptions)localObject2).mRequestWidth = bcwh.a((Context)localObject1, 18.0F);
      ((URLDrawable.URLDrawableOptions)localObject2).mRequestHeight = bcwh.a((Context)localObject1, 18.0F);
      ((URLDrawable.URLDrawableOptions)localObject2).mMemoryCacheKeySuffix = "askIcon";
      localObject2 = URLDrawable.getDrawable(paramaykg.jdField_b_of_type_JavaLangString, (URLDrawable.URLDrawableOptions)localObject2);
      paramaysp.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable((Drawable)localObject2);
      if ((((URLDrawable)localObject2).getStatus() != 1) && (((URLDrawable)localObject2).getStatus() != 0)) {
        ((URLDrawable)localObject2).restartDownload();
      }
      paramaysp.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(0);
    }
    label290:
    for (;;)
    {
      label166:
      if (!TextUtils.isEmpty(paramaykg.j))
      {
        int j = paramaysp.jdField_a_of_type_AndroidWidgetTextView.getContext().getResources().getDisplayMetrics().widthPixels;
        int i = (int)ayrd.a(paramaysp.jdField_a_of_type_AndroidWidgetTextView, " ");
        int k = bcwh.a((Context)localObject1, 22.0F) / i;
        localObject1 = "";
        i = 0;
        for (;;)
        {
          if (i < k)
          {
            localObject1 = (String)localObject1 + " ";
            i += 1;
            continue;
            paramaysp.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#262626"));
            paramaysp.jdField_b_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#737373"));
            break;
            paramaysp.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(8);
            break label166;
          }
        }
        localObject1 = ayrd.a(paramaysp.jdField_a_of_type_AndroidWidgetTextView, j, 2, (String)localObject1 + paramaykg.j, paramaykg.jdField_a_of_type_Ayqs.jdField_a_of_type_JavaUtilList, false, false, true);
        paramaysp.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject1);
      }
    }
    paramaysp.a(paramaykg);
    if ((!TextUtils.isEmpty(paramaykg.k)) && (paramaykg.jdField_a_of_type_JavaUtilList != null) && (paramaykg.jdField_a_of_type_JavaUtilList.size() != 0))
    {
      paramaysp.jdField_b_of_type_AndroidWidgetTextView.setText(paramaykg.k);
      paramaysp.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      return;
    }
    paramaysp.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
  }
  
  protected void a(aykj paramaykj, ayst paramayst)
  {
    if (!TextUtils.isEmpty(paramaykj.jdField_b_of_type_JavaLangString))
    {
      paramayst.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(0);
      Object localObject = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
      ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
      ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = paramayst.jdField_a_of_type_ComTencentImageURLImageView.getLayoutParams().width;
      ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = paramayst.jdField_a_of_type_ComTencentImageURLImageView.getLayoutParams().height;
      localObject = URLDrawable.getDrawable(paramaykj.jdField_b_of_type_JavaLangString, (URLDrawable.URLDrawableOptions)localObject);
      paramayst.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable((Drawable)localObject);
      if ((((URLDrawable)localObject).getStatus() != 1) && (((URLDrawable)localObject).getStatus() != 0)) {
        ((URLDrawable)localObject).restartDownload();
      }
      if (TextUtils.isEmpty(paramaykj.j)) {
        break label345;
      }
      paramayst.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      int i = paramayst.jdField_a_of_type_AndroidWidgetTextView.getContext().getResources().getDisplayMetrics().widthPixels;
      localObject = ayrd.a(paramayst.jdField_a_of_type_AndroidWidgetTextView, i, 1, paramaykj.j, paramaykj.jdField_a_of_type_Ayqs.jdField_a_of_type_JavaUtilList, false, false, true);
      paramayst.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
      label183:
      if (TextUtils.isEmpty(paramaykj.l)) {
        break label357;
      }
      paramayst.jdField_b_of_type_AndroidWidgetTextView.setText(paramaykj.l);
      paramayst.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      paramayst.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      label220:
      if (TextUtils.isEmpty(paramaykj.k)) {
        break label378;
      }
      paramayst.c.setText(paramaykj.k);
      paramayst.c.setVisibility(0);
    }
    for (;;)
    {
      if (!ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null)) {
        break label390;
      }
      paramayst.jdField_a_of_type_AndroidWidgetTextView.setTextColor(paramayst.jdField_a_of_type_AndroidWidgetTextView.getContext().getResources().getColor(2131166839));
      paramayst.c.setTextColor(paramayst.c.getContext().getResources().getColor(2131166838));
      paramayst.jdField_b_of_type_AndroidWidgetTextView.setTextColor(paramayst.jdField_b_of_type_AndroidWidgetTextView.getContext().getResources().getColor(2131166838));
      return;
      paramayst.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(8);
      break;
      label345:
      paramayst.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      break label183;
      label357:
      paramayst.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      paramayst.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      break label220;
      label378:
      paramayst.c.setVisibility(8);
    }
    label390:
    paramayst.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#262626"));
    paramayst.c.setTextColor(Color.parseColor("#737373"));
    paramayst.jdField_b_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#737373"));
  }
  
  public void a(SquareImageView paramSquareImageView, ImageView paramImageView, TextView paramTextView, int paramInt1, int paramInt2, boolean paramBoolean1, String paramString1, String paramString2, int paramInt3, boolean paramBoolean2)
  {
    ViewGroup.LayoutParams localLayoutParams = paramSquareImageView.getLayoutParams();
    if ((paramSquareImageView.getContext() instanceof PublicAcntSearchActivity))
    {
      localLayoutParams.width = bcwh.a(paramSquareImageView.getContext(), 50.0F);
      localLayoutParams.height = bcwh.a(paramSquareImageView.getContext(), 50.0F);
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
          paramTextView.setDecodeHandler(bcuq.a);
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
  
  protected void b(ayju paramayju, aysb paramaysb)
  {
    if (paramaysb.a() != null) {
      paramaysb.a().setOnClickListener(new ayng(this, paramayju));
    }
  }
  
  public void c(ayju paramayju, aysb paramaysb)
  {
    if ((paramaysb.b() != null) && ((paramayju instanceof ayji)) && (!TextUtils.isEmpty(paramayju.b()))) {
      paramaysb.b().setImageDrawable(ayrd.a(this.jdField_a_of_type_Bcws, paramayju));
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
      ayrd.jdField_a_of_type_Long = this.jdField_a_of_type_Long;
      localImageView.post(new SearchTemplatePresenter.11(this, localImageView, bool));
      localImageView.setContentDescription(localResources.getString(2131690326));
      this.jdField_a_of_type_Ayfh.notifyDataSetChanged();
      return;
    }
    localImageView.post(new SearchTemplatePresenter.12(this, localImageView, bool));
    localImageView.setContentDescription(localResources.getString(2131690324));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aynf
 * JD-Core Version:    0.7.0.1
 */