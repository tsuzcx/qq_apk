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

public class bcjk
  implements axrb, bcik<bcga, bcog>
{
  public static int a;
  private long jdField_a_of_type_Long;
  public ColorDrawable a;
  public Drawable a;
  private aoof jdField_a_of_type_Aoof;
  private bcbl jdField_a_of_type_Bcbl;
  private WeakReference<ImageView> jdField_a_of_type_JavaLangRefWeakReference;
  
  public bcjk(aoof paramaoof, bcbl parambcbl)
  {
    this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable = new ColorDrawable(Color.parseColor("#e7e7e7"));
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = beyq.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
    this.jdField_a_of_type_Aoof = paramaoof;
    this.jdField_a_of_type_Bcbl = parambcbl;
  }
  
  private float a(String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      return 7.0F;
    }
    return 3.5F;
  }
  
  private int a(bcgq parambcgq, bcoz parambcoz)
  {
    if ((parambcgq == null) || (parambcgq.jdField_a_of_type_Bcgr == null) || (parambcoz == null) || (parambcoz.jdField_a_of_type_AndroidWidgetRelativeLayout == null))
    {
      if ((parambcoz != null) && (parambcoz.jdField_a_of_type_AndroidWidgetButton != null)) {
        parambcoz.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
      }
      if ((parambcoz != null) && (parambcoz.jdField_a_of_type_AndroidWidgetImageView != null)) {
        parambcoz.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      }
      return 0;
    }
    if (parambcgq.jdField_a_of_type_Bcgr.jdField_a_of_type_Int == 1)
    {
      if (parambcoz.jdField_a_of_type_AndroidWidgetButton != null) {
        parambcoz.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
      }
      if (parambcoz.jdField_a_of_type_AndroidWidgetImageView != null) {
        parambcoz.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      }
      return 0;
    }
    boolean bool = ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null);
    Context localContext = parambcoz.jdField_a_of_type_AndroidWidgetRelativeLayout.getContext();
    int i;
    if (parambcgq.jdField_a_of_type_Bcgr.jdField_a_of_type_Int == 2)
    {
      if (parambcoz.jdField_a_of_type_AndroidWidgetImageView != null) {
        parambcoz.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      }
      if (parambcoz.jdField_a_of_type_AndroidWidgetButton == null) {
        return 0;
      }
      if (!TextUtils.isEmpty(parambcgq.jdField_a_of_type_Bcgr.jdField_a_of_type_JavaLangCharSequence))
      {
        parambcoz.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
        parambcoz.jdField_a_of_type_AndroidWidgetButton.setText(parambcgq.jdField_a_of_type_Bcgr.jdField_a_of_type_JavaLangCharSequence);
        parambcoz.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(new bcjr(this, localContext, parambcgq));
      }
      for (;;)
      {
        i = (int)(0 + (bcni.a(parambcoz.jdField_a_of_type_AndroidWidgetButton, parambcgq.jdField_a_of_type_Bcgr.jdField_a_of_type_JavaLangCharSequence) + bhgr.a(localContext, 32.0F) + bhgr.a(localContext, 15.0F)));
        if (!bool) {
          break;
        }
        parambcoz.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130843259);
        parambcoz.jdField_a_of_type_AndroidWidgetButton.setTextColor(Color.parseColor("#6991B8"));
        return i;
        parambcoz.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
      }
      parambcoz.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130843258);
      parambcoz.jdField_a_of_type_AndroidWidgetButton.setTextColor(Color.parseColor("#000000"));
      return i;
    }
    int j;
    if (parambcgq.jdField_a_of_type_Bcgr.jdField_a_of_type_Int == 3)
    {
      if (parambcoz.jdField_a_of_type_AndroidWidgetButton != null) {
        parambcoz.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
      }
      if ((parambcoz.jdField_a_of_type_AndroidWidgetRelativeLayout == null) || (parambcoz.jdField_a_of_type_AndroidWidgetImageView == null)) {
        return 0;
      }
      int k = ((Integer)parambcoz.a().getTag(2131381110)).intValue();
      SongInfo localSongInfo1 = new SongInfo();
      i = 0;
      j = i;
      for (;;)
      {
        try
        {
          JSONObject localJSONObject = new JSONObject(parambcgq.h);
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
          bcni.jdField_a_of_type_Long = localSongInfo2.jdField_a_of_type_Long;
          continue;
          parambcoz.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130849636);
          continue;
          if (this.jdField_a_of_type_Long != bcni.jdField_a_of_type_Long) {
            continue;
          }
          parambcoz.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130849637);
          continue;
          parambcoz.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130849635);
          continue;
          parambcoz.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
          continue;
        }
        this.jdField_a_of_type_Long = localSongInfo1.jdField_a_of_type_Long;
        QQPlayerService.a(this);
        if (QQPlayerService.a() == 2) {
          continue;
        }
        bcni.jdField_a_of_type_Long = -1L;
        if (!bool) {
          continue;
        }
        if (this.jdField_a_of_type_Long != bcni.jdField_a_of_type_Long) {
          continue;
        }
        parambcoz.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130849638);
        if ((j == 0) || (i == 0) || (TextUtils.isEmpty(localSongInfo1.jdField_b_of_type_JavaLangString))) {
          continue;
        }
        parambcoz.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        parambcoz.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(new bcjs(this, parambcoz, k, localContext, bool, localSongInfo1, parambcgq));
        return bhgr.a(localContext, 39.0F) + 0;
        i = 0;
        continue;
        j = 0;
      }
    }
    parambcoz.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
    return 0;
  }
  
  private int a(bcgq parambcgq, bcoz parambcoz, int paramInt1, int paramInt2)
  {
    if ((parambcoz == null) || (parambcgq == null) || (parambcoz.jdField_a_of_type_AndroidWidgetLinearLayout == null)) {
      return 0;
    }
    Context localContext = parambcoz.jdField_a_of_type_AndroidWidgetLinearLayout.getContext();
    int i = localContext.getResources().getDisplayMetrics().widthPixels - paramInt1 - paramInt2 - bhgr.a(localContext, 30.0F);
    if ((parambcgq.jdField_a_of_type_JavaUtilArrayList != null) && (parambcgq.jdField_a_of_type_JavaUtilArrayList.size() > 0))
    {
      parambcoz.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      if ((parambcgq.jdField_a_of_type_Bcgs != null) && (parambcgq.jdField_a_of_type_JavaUtilArrayList != null) && (parambcgq.jdField_a_of_type_JavaUtilArrayList.size() > 0))
      {
        parambcoz.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(0);
        if (parambcoz.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView != null) {
          parambcoz.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView.setVisibility(8);
        }
        if (parambcgq.jdField_a_of_type_Bcgs.jdField_a_of_type_Int == 1)
        {
          if (parambcoz.jdField_b_of_type_AndroidWidgetTextView != null) {
            parambcoz.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
          }
          if ((parambcoz.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView == null) || (TextUtils.isEmpty(parambcgq.jdField_a_of_type_Bcgs.jdField_a_of_type_JavaLangString))) {
            break label1007;
          }
          parambcoz.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView.setVisibility(0);
          a(parambcoz.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView, parambcgq.jdField_a_of_type_Bcgs.jdField_a_of_type_JavaLangString);
          paramInt1 = i - bhgr.a(localContext, 24.0F);
        }
      }
    }
    for (;;)
    {
      Object localObject1;
      if ((parambcoz.jdField_a_of_type_AndroidWidgetTextView != null) && (!TextUtils.isEmpty(((bcgt)parambcgq.jdField_a_of_type_JavaUtilArrayList.get(0)).jdField_a_of_type_JavaLangCharSequence)))
      {
        localObject1 = ((bcgt)parambcgq.jdField_a_of_type_JavaUtilArrayList.get(0)).jdField_a_of_type_JavaLangCharSequence;
        if (!((bcgt)parambcgq.jdField_a_of_type_JavaUtilArrayList.get(0)).jdField_a_of_type_Boolean) {
          break label635;
        }
        localObject1 = bcni.a(parambcoz.jdField_a_of_type_AndroidWidgetTextView, paramInt1, 1, ((CharSequence)localObject1).toString(), parambcgq.jdField_a_of_type_Bcmx.jdField_a_of_type_JavaUtilList, false, false, true);
        label297:
        parambcoz.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject1);
      }
      for (paramInt1 = 1;; paramInt1 = 0)
      {
        if (parambcoz.c != null) {
          break label677;
        }
        return parambcoz.jdField_a_of_type_AndroidWidgetLinearLayout.getHeight();
        if (parambcgq.jdField_a_of_type_Bcgs.jdField_a_of_type_Int == 2)
        {
          if (parambcoz.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView != null) {
            parambcoz.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView.setVisibility(8);
          }
          if ((parambcoz.jdField_b_of_type_AndroidWidgetTextView == null) || (TextUtils.isEmpty(parambcgq.jdField_a_of_type_Bcgs.jdField_a_of_type_JavaLangCharSequence))) {
            break label1007;
          }
          if (bcni.e(parambcgq.jdField_a_of_type_Bcgs.jdField_b_of_type_JavaLangString)) {}
          for (localObject1 = parambcgq.jdField_a_of_type_Bcgs.jdField_b_of_type_JavaLangString;; localObject1 = "#fd7f32")
          {
            ((GradientDrawable)parambcoz.jdField_b_of_type_AndroidWidgetTextView.getBackground()).setColor(Color.parseColor((String)localObject1));
            parambcoz.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
            parambcoz.jdField_b_of_type_AndroidWidgetTextView.setText(parambcgq.jdField_a_of_type_Bcgs.jdField_a_of_type_JavaLangCharSequence);
            paramInt1 = (int)(i - (bcni.a(parambcoz.jdField_b_of_type_AndroidWidgetTextView, parambcgq.jdField_a_of_type_Bcgs.jdField_a_of_type_JavaLangCharSequence) + bhgr.a(localContext, 10.0F)));
            break;
          }
        }
        if (parambcgq.jdField_a_of_type_Bcgs.jdField_a_of_type_Int != 3) {
          break label1007;
        }
        if (parambcoz.jdField_b_of_type_AndroidWidgetTextView != null) {
          parambcoz.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
        }
        if ((parambcoz.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView == null) || (TextUtils.isEmpty(parambcgq.jdField_a_of_type_Bcgs.jdField_a_of_type_JavaLangString))) {
          break label1007;
        }
        parambcoz.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView.setVisibility(0);
        if ((parambcgq.jdField_a_of_type_Bcgs.jdField_b_of_type_Int > 0) && (parambcgq.jdField_a_of_type_Bcgs.jdField_c_of_type_Int > 0))
        {
          a(parambcoz.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView, parambcgq.jdField_a_of_type_Bcgs.jdField_b_of_type_Int, parambcgq.jdField_a_of_type_Bcgs.jdField_c_of_type_Int, parambcgq.jdField_a_of_type_Bcgs.jdField_a_of_type_JavaLangString);
          paramInt1 = i - bhgr.a(localContext, bhgr.a(localContext, parambcgq.jdField_a_of_type_Bcgs.jdField_b_of_type_Int) + 4);
          break;
        }
        a(parambcoz.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView, parambcgq.jdField_a_of_type_Bcgs.jdField_a_of_type_JavaLangString);
        paramInt1 = i - bhgr.a(localContext, 24.0F);
        break;
        label635:
        localObject1 = bcni.a(parambcoz.jdField_a_of_type_AndroidWidgetTextView, paramInt1, ((CharSequence)localObject1).toString());
        break label297;
        if (parambcoz.jdField_b_of_type_AndroidWidgetLinearLayout != null) {
          parambcoz.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
        }
      }
      label677:
      parambcoz.c.removeAllViews();
      bcgt localbcgt;
      TextView localTextView;
      if ((parambcgq.jdField_a_of_type_JavaUtilArrayList != null) && (parambcgq.jdField_a_of_type_JavaUtilArrayList.size() > 0)) {
        while (paramInt1 < parambcgq.jdField_a_of_type_JavaUtilArrayList.size())
        {
          localbcgt = (bcgt)parambcgq.jdField_a_of_type_JavaUtilArrayList.get(paramInt1);
          localTextView = new TextView(localContext);
          a(localTextView, localbcgt.jdField_a_of_type_JavaLangString, localbcgt.jdField_a_of_type_Int);
          localObject1 = localbcgt.jdField_a_of_type_JavaLangCharSequence;
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
        paramInt2 = localbcgt.jdField_a_of_type_Int;
        if ((localContext instanceof PublicAcntSearchActivity)) {
          paramInt2 = 1;
        }
        Object localObject2 = localObject1;
        if (localbcgt.jdField_a_of_type_Boolean) {
          if ((!localbcgt.jdField_a_of_type_JavaLangString.equals("A")) && (!localbcgt.jdField_a_of_type_JavaLangString.equals("B"))) {
            break label952;
          }
        }
        for (boolean bool = true;; bool = false)
        {
          localObject2 = bcni.a(localTextView, i, paramInt2, ((CharSequence)localObject1).toString(), parambcgq.jdField_a_of_type_Bcmx.jdField_a_of_type_JavaUtilList, false, bool, true);
          if (paramInt1 != 0) {
            localTextView.setPadding(0, bhgr.a(localContext, 7.0F - a(((bcgt)parambcgq.jdField_a_of_type_JavaUtilArrayList.get(paramInt1 - 1)).jdField_a_of_type_JavaLangString, localbcgt.jdField_a_of_type_JavaLangString)), 0, 0);
          }
          localTextView.setText((CharSequence)localObject2);
          parambcoz.c.addView(localTextView);
          break;
        }
        parambcoz.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
        b(parambcgq, parambcoz);
        paramInt1 = View.MeasureSpec.makeMeasureSpec(0, 0);
        paramInt2 = View.MeasureSpec.makeMeasureSpec(0, 0);
        parambcoz.jdField_a_of_type_AndroidWidgetLinearLayout.measure(paramInt1, paramInt2);
        return parambcoz.jdField_a_of_type_AndroidWidgetLinearLayout.getMeasuredHeight();
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
      if (!bcni.e(paramString)) {
        localObject = "#F1F1F1";
      }
    }
  }
  
  public static Pair<Integer, Integer> a(bcga parambcga, bcog parambcog, boolean paramBoolean, int paramInt)
  {
    if ((parambcog == null) || (parambcog.jdField_b_of_type_AndroidWidgetRelativeLayout == null) || (parambcog.jdField_b_of_type_ComTencentMobileqqWidgetSquareImageView == null) || (parambcga == null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.uniteSearch.SearchTemplatePresenter", 2, "bindUniversalTemplateLeftImageview or item is null");
      }
      return new Pair(Integer.valueOf(0), Integer.valueOf(0));
    }
    SquareImageView localSquareImageView = parambcog.jdField_b_of_type_ComTencentMobileqqWidgetSquareImageView;
    bcgb localbcgb = parambcga.jdField_a_of_type_Bcgb;
    if ((localbcgb == null) || (TextUtils.isEmpty(localbcgb.jdField_a_of_type_JavaLangString)))
    {
      parambcog.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      return new Pair(Integer.valueOf(0), Integer.valueOf(0));
    }
    parambcog.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
    Object localObject = localSquareImageView.getContext();
    parambcga = a(localSquareImageView, localbcgb.jdField_a_of_type_Int, localbcgb.jdField_a_of_type_JavaLangString, localbcgb.jdField_b_of_type_Int, paramBoolean, paramInt, parambcga);
    paramInt = ((Integer)parambcga.first).intValue();
    int i = ((Integer)parambcga.second).intValue();
    parambcga = localSquareImageView.getLayoutParams();
    parambcga.width = paramInt;
    parambcga.height = i;
    localSquareImageView.setLayoutParams(parambcga);
    parambcga = (RelativeLayout.LayoutParams)parambcog.jdField_b_of_type_AndroidWidgetRelativeLayout.getLayoutParams();
    parambcga.width = paramInt;
    parambcga.height = i;
    parambcog.jdField_b_of_type_AndroidWidgetRelativeLayout.setLayoutParams(parambcga);
    int j = bhgr.a((Context)localObject, 10.0F);
    if ((!TextUtils.isEmpty(localbcgb.jdField_a_of_type_JavaLangCharSequence)) && (parambcog.e != null)) {
      if (bcni.e(localbcgb.jdField_b_of_type_JavaLangString))
      {
        parambcga = localbcgb.jdField_b_of_type_JavaLangString;
        ((GradientDrawable)parambcog.e.getBackground()).setColor(Color.parseColor(parambcga));
        parambcog.e.setVisibility(0);
        parambcog.e.setText(localbcgb.jdField_a_of_type_JavaLangCharSequence);
        label303:
        if (parambcog.jdField_c_of_type_AndroidWidgetImageView != null)
        {
          if (!localbcgb.jdField_a_of_type_Boolean) {
            break label565;
          }
          parambcog.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
        }
        label326:
        if (parambcog.f != null)
        {
          if (TextUtils.isEmpty(localbcgb.jdField_b_of_type_JavaLangCharSequence)) {
            break label577;
          }
          parambcog.f.setVisibility(0);
          parambcog.f.setText(localbcgb.jdField_b_of_type_JavaLangCharSequence);
        }
        label364:
        if (parambcog.jdField_c_of_type_ComTencentMobileqqWidgetSquareImageView != null)
        {
          if (TextUtils.isEmpty(localbcgb.jdField_c_of_type_JavaLangString)) {
            break label589;
          }
          parambcog.jdField_c_of_type_ComTencentMobileqqWidgetSquareImageView.setVisibility(0);
          parambcga = URLDrawable.URLDrawableOptions.obtain();
          localObject = new ColorDrawable(-1);
          parambcga.mFailedDrawable = ((Drawable)localObject);
          parambcga.mLoadingDrawable = ((Drawable)localObject);
          parambcga.mRequestWidth = parambcog.jdField_c_of_type_ComTencentMobileqqWidgetSquareImageView.getLayoutParams().width;
          parambcga.mRequestHeight = parambcog.jdField_c_of_type_ComTencentMobileqqWidgetSquareImageView.getLayoutParams().height;
          parambcga = URLDrawable.getDrawable(localbcgb.jdField_c_of_type_JavaLangString, parambcga);
          if ((parambcga.getStatus() != 1) && (parambcga.getStatus() != 0)) {
            parambcga.restartDownload();
          }
          parambcog.jdField_c_of_type_ComTencentMobileqqWidgetSquareImageView.setImageDrawable(parambcga);
        }
        label481:
        if (parambcog.g != null)
        {
          if (TextUtils.isEmpty(localbcgb.jdField_c_of_type_JavaLangCharSequence)) {
            break label601;
          }
          parambcog.g.setVisibility(0);
          parambcog.g.setText(localbcgb.jdField_c_of_type_JavaLangCharSequence);
        }
      }
    }
    for (;;)
    {
      return new Pair(Integer.valueOf(paramInt + j), Integer.valueOf(i));
      parambcga = "#fd7f32";
      break;
      if (parambcog.e == null) {
        break label303;
      }
      parambcog.e.setVisibility(8);
      break label303;
      label565:
      parambcog.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
      break label326;
      label577:
      parambcog.f.setVisibility(8);
      break label364;
      label589:
      parambcog.jdField_c_of_type_ComTencentMobileqqWidgetSquareImageView.setVisibility(8);
      break label481;
      label601:
      parambcog.g.setVisibility(8);
    }
  }
  
  public static Pair<Integer, Integer> a(SquareImageView paramSquareImageView, int paramInt1, String paramString, int paramInt2, boolean paramBoolean, int paramInt3, bcga parambcga)
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
      paramInt1 = bhgr.a((Context)localObject, 60.0F);
      i = bhgr.a((Context)localObject, 60.0F);
      j = 0;
      localColorDrawable = new ColorDrawable(Color.parseColor("#e7e7e7"));
      if (paramBoolean)
      {
        paramInt1 = (int)(i * 1.0F / paramInt1 * paramInt3);
        if (j != 0)
        {
          i = (int)(paramInt3 * 0.2D / 2.0D);
          paramSquareImageView.setPadding(bhgr.a((Context)localObject, 3.0F), bhgr.a((Context)localObject, 3.0F), bhgr.a((Context)localObject, 3.0F), bhgr.a((Context)localObject, 3.0F));
          parambcga = (RelativeLayout.LayoutParams)paramSquareImageView.getLayoutParams();
          i -= bhgr.a((Context)localObject, 3.0F);
          parambcga.rightMargin = i;
          parambcga.leftMargin = i;
          parambcga.topMargin = i;
          paramSquareImageView.setLayoutParams(parambcga);
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
          parambcga = URLDrawable.URLDrawableOptions.obtain();
          parambcga.mRequestWidth = paramInt3;
          parambcga.mRequestHeight = paramInt1;
          if (j == 0) {
            continue;
          }
          localObject = new GradientDrawable();
          ((GradientDrawable)localObject).setShape(0);
          ((GradientDrawable)localObject).setCornerRadius(paramInt3 / 2.0F);
          ((GradientDrawable)localObject).setColor(-1579033);
          parambcga.mLoadingDrawable = ((Drawable)localObject);
          parambcga.mFailedDrawable = ((Drawable)localObject);
          parambcga.mPlayGifImage = true;
          if (j == 0) {
            continue;
          }
          parambcga.mMemoryCacheKeySuffix = ("isAvatar" + paramInt3 + paramInt1);
          parambcga = URLDrawable.getDrawable(paramString, parambcga);
          parambcga.setDecodeHandler(bhez.a);
        }
        catch (Exception parambcga)
        {
          QLog.e("Q.uniteSearch.SearchTemplatePresenter", 1, "imageUrl is not valid. imageUrl=" + paramString, parambcga);
          localObject = localColorDrawable;
          continue;
          parambcga.mMemoryCacheKeySuffix = ("isNotAvatar" + paramInt3 + paramInt1 + paramInt2);
          parambcga = URLDrawable.getDrawable(paramString, parambcga);
          parambcga.setTag(bhez.b(paramInt3, paramInt1, paramInt2));
          parambcga.setDecodeHandler(bhez.j);
          continue;
        }
        localObject = parambcga;
        if (parambcga.getStatus() != 1)
        {
          localObject = parambcga;
          if (parambcga.getStatus() != 0)
          {
            parambcga.restartDownload();
            localObject = parambcga;
          }
        }
        paramSquareImageView.setImageDrawable((Drawable)localObject);
        return new Pair(Integer.valueOf(paramInt3), Integer.valueOf(paramInt1));
        paramInt1 = bhgr.a((Context)localObject, 60.0F);
        i = bhgr.a((Context)localObject, 60.0F);
        j = 0;
        break;
        paramInt1 = bhgr.a((Context)localObject, 50.0F);
        i = bhgr.a((Context)localObject, 50.0F);
        j = 0;
        break;
        if ((paramSquareImageView.getContext() instanceof PublicAcntSearchActivity))
        {
          paramInt1 = bhgr.a(paramSquareImageView.getContext(), 50.0F);
          i = bhgr.a(paramSquareImageView.getContext(), 50.0F);
          j = 1;
          break;
        }
        paramInt1 = bhgr.a((Context)localObject, 60.0F);
        i = bhgr.a((Context)localObject, 60.0F);
        continue;
        paramInt1 = bhgr.a((Context)localObject, 50.0F);
        i = bhgr.a((Context)localObject, 50.0F);
        j = 1;
        break;
        paramInt1 = bhgr.a((Context)localObject, 60.0F);
        i = bhgr.a((Context)localObject, 85.0F);
        j = 0;
        break;
        paramInt1 = bhgr.a((Context)localObject, 113.0F);
        i = bhgr.a((Context)localObject, 60.0F);
        j = 0;
        break;
        paramInt1 = bhgr.a((Context)localObject, 100.0F);
        i = bhgr.a((Context)localObject, 141.0F);
        j = 0;
        break;
        paramInt1 = j;
        if ((parambcga instanceof bcgq))
        {
          paramInt1 = bhgr.a((Context)localObject, parambcga.jdField_a_of_type_Bcgb.jdField_c_of_type_Int / 2);
          i = bhgr.a((Context)localObject, parambcga.jdField_a_of_type_Bcgb.d / 2);
        }
        if ((paramInt2 == parambcga.jdField_a_of_type_Bcgb.jdField_c_of_type_Int / 2) && (paramInt2 == parambcga.jdField_a_of_type_Bcgb.d / 2))
        {
          j = 1;
          break;
        }
        j = 0;
        break;
        paramInt1 = bhgr.a((Context)localObject, 220.0F);
        i = bhgr.a((Context)localObject, 136.0F);
        j = 0;
        break;
        paramInt1 = bhgr.a((Context)localObject, 162.0F);
        i = bhgr.a((Context)localObject, 162.0F);
        j = 0;
        break;
        paramInt1 = bhgr.a((Context)localObject, 162.0F);
        i = bhgr.a((Context)localObject, 228.0F);
        j = 0;
        break;
        paramInt1 = bhgr.a((Context)localObject, 162.0F);
        i = bhgr.a((Context)localObject, 162.0F);
        j = 1;
        break;
        parambcga.mFailedDrawable = localColorDrawable;
        parambcga.mLoadingDrawable = localColorDrawable;
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
        paramTextView.setTextColor(localContext.getResources().getColor(2131166991));
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
        paramTextView.setTextColor(localContext.getResources().getColor(2131166991));
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
        paramTextView.setTextColor(localContext.getResources().getColor(2131166992));
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
        paramTextView.setTextColor(localContext.getResources().getColor(2131166992));
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
        paramTextView.setTextColor(localContext.getResources().getColor(2131166992));
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
      paramTextView.setTextColor(localContext.getResources().getColor(2131167137));
      return;
    }
    paramTextView.setTextSize(1, 17.0F);
    paramTextView.setTextColor(localContext.getResources().getColor(2131166997));
    paramTextView.setIncludeFontPadding(false);
  }
  
  private void a(bcfy parambcfy, bcoe parambcoe)
  {
    Object localObject1 = BaseApplicationImpl.getApplication().getRuntime();
    Object localObject3 = parambcoe.a().getContext();
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
      parambcoe.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#737373"));
      if (!TextUtils.isEmpty(parambcfy.jdField_a_of_type_JavaLangCharSequence)) {
        break label593;
      }
      parambcoe.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      if (parambcfy.jdField_a_of_type_Bcft == null) {
        break label775;
      }
      parambcoe.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      parambcoe.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      i = (int)(bhlo.k() - zps.a((Context)localObject3, 30.0F)) / 2 - zps.a((Context)localObject3, 3.0F);
      localObject1 = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject1).mPlayGifImage = true;
      ((URLDrawable.URLDrawableOptions)localObject1).mFailedDrawable = new ColorDrawable(Color.parseColor("#e7e7e7"));
      ((URLDrawable.URLDrawableOptions)localObject1).mLoadingDrawable = new ColorDrawable(Color.parseColor("#e7e7e7"));
      ((URLDrawable.URLDrawableOptions)localObject1).mRequestWidth = i;
      ((URLDrawable.URLDrawableOptions)localObject1).mRequestHeight = i;
      localObject2 = URLDrawable.getDrawable(parambcfy.jdField_a_of_type_Bcft.jdField_a_of_type_JavaLangString, (URLDrawable.URLDrawableOptions)localObject1);
      parambcoe.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable((Drawable)localObject2);
      if ((((URLDrawable)localObject2).getStatus() != 1) && (((URLDrawable)localObject2).getStatus() != 0)) {
        ((URLDrawable)localObject2).restartDownload();
      }
      localObject2 = (LinearLayout.LayoutParams)parambcoe.jdField_a_of_type_ComTencentImageURLImageView.getLayoutParams();
      ((LinearLayout.LayoutParams)localObject2).height = i;
      ((LinearLayout.LayoutParams)localObject2).width = i;
      parambcoe.jdField_a_of_type_ComTencentImageURLImageView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
      parambcoe.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(0);
      if (parambcfy.jdField_a_of_type_JavaUtilList == null) {
        return;
      }
      m = Math.min(parambcfy.jdField_a_of_type_JavaUtilList.size(), 4);
      n = (i - zps.a((Context)localObject3, 3.0F)) / 2;
      localObject2 = new int[4];
      Object tmp295_293 = localObject2;
      tmp295_293[0] = 2131368354;
      Object tmp301_295 = tmp295_293;
      tmp301_295[1] = 2131368355;
      Object tmp307_301 = tmp301_295;
      tmp307_301[2] = 2131368356;
      Object tmp313_307 = tmp307_301;
      tmp313_307[3] = 2131368357;
      tmp313_307;
      i = 0;
      if (i >= m) {
        break label748;
      }
      localObject3 = (SquareImageView)parambcoe.jdField_b_of_type_AndroidWidgetLinearLayout.findViewById(localObject2[i]);
      localObject4 = ((bcft)parambcfy.jdField_a_of_type_JavaUtilList.get(i)).jdField_a_of_type_JavaLangString;
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
      if ((i != 3) || (parambcfy.jdField_a_of_type_Int <= 4)) {
        break label731;
      }
      ((SquareImageView)localObject3).setFilterColor(Color.parseColor("#66000000"));
      k = parambcfy.jdField_a_of_type_Int - 4;
      localObject4 = new StringBuilder().append("+");
      j = k;
      if (k > 99) {
        j = 99;
      }
      ((SquareImageView)localObject3).setFilterText(j);
      ((SquareImageView)localObject3).setFilterTextSize(bhgr.a(parambcoe.a().getContext(), 20.0F));
    }
    for (;;)
    {
      i += 1;
      break label322;
      parambcoe.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#262626"));
      break;
      label593:
      i = (int)(parambcoe.jdField_a_of_type_AndroidWidgetTextView.getContext().getResources().getDisplayMetrics().widthPixels - bhgr.a(parambcoe.jdField_a_of_type_AndroidWidgetTextView.getContext(), 30.0F) - bcni.a(parambcoe.jdField_a_of_type_AndroidWidgetTextView, parambcfy.jdField_a_of_type_JavaLangString));
      localObject2 = bcni.a(parambcoe.jdField_a_of_type_AndroidWidgetTextView, i, 1, parambcfy.jdField_a_of_type_JavaLangCharSequence.toString(), parambcfy.jdField_a_of_type_Bcmx.jdField_a_of_type_JavaUtilList, false, false, true);
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      if (parambcfy.jdField_a_of_type_JavaLangString == null) {
        parambcfy.jdField_a_of_type_JavaLangString = "";
      }
      parambcoe.jdField_a_of_type_AndroidWidgetTextView.setText(new SpannableStringBuilder((CharSequence)localObject1).append(parambcfy.jdField_a_of_type_JavaLangString));
      parambcoe.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      break label59;
      label731:
      ((SquareImageView)localObject3).setFilterColor(-1);
      ((SquareImageView)localObject3).setFilterText("");
    }
    label748:
    while (i < 4)
    {
      parambcoe.jdField_b_of_type_AndroidWidgetLinearLayout.findViewById(localObject2[i]).setVisibility(4);
      i += 1;
    }
    label775:
    parambcoe.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    parambcoe.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
    if (parambcfy.jdField_a_of_type_JavaUtilList != null)
    {
      m = Math.min(parambcfy.jdField_a_of_type_JavaUtilList.size(), parambcoe.jdField_a_of_type_Int);
      n = (int)(bhlo.k() - zps.a(parambcoe.a().getContext(), (m - 1) * 2 + 27));
      i = 0;
      if (i < m)
      {
        localObject1 = (SquareImageView)parambcoe.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(i);
        localObject2 = ((bcft)parambcfy.jdField_a_of_type_JavaUtilList.get(i)).jdField_a_of_type_JavaLangString;
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
        if (parambcfy.jdField_b_of_type_Int != 0)
        {
          ((SquareImageView)localObject1).setImageScale(n / 4 * 1.0F / bhgr.a((Context)localObject3, parambcfy.jdField_b_of_type_Int / 2), 0.0F);
          label1007:
          ((SquareImageView)localObject1).setVisibility(0);
          if ((i != parambcoe.jdField_a_of_type_Int - 1) || (parambcfy.jdField_a_of_type_Int <= parambcoe.jdField_a_of_type_Int)) {
            break label1136;
          }
          ((SquareImageView)localObject1).setFilterColor(Color.parseColor("#66000000"));
          k = parambcfy.jdField_a_of_type_Int - parambcoe.jdField_a_of_type_Int;
          localObject2 = new StringBuilder().append("+");
          j = k;
          if (k > 99) {
            j = 99;
          }
          ((SquareImageView)localObject1).setFilterText(j);
          ((SquareImageView)localObject1).setFilterTextSize(bhgr.a(parambcoe.a().getContext(), 20.0F));
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
      while (i < parambcoe.jdField_a_of_type_Int)
      {
        parambcoe.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(i).setVisibility(4);
        i += 1;
      }
    }
  }
  
  private void a(bcfz parambcfz, bcof parambcof)
  {
    Object localObject = parambcof.a().getContext();
    int i;
    if (!TextUtils.isEmpty(parambcfz.i))
    {
      parambcof.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      a((Context)localObject, (SquareImageView)parambcof.jdField_a_of_type_AndroidWidgetImageView, parambcof.jdField_b_of_type_AndroidWidgetImageView, parambcof.jdField_b_of_type_AndroidWidgetTextView, parambcfz.jdField_a_of_type_Int, parambcfz.i, parambcfz.jdField_b_of_type_JavaLangString, ((Context)localObject).getResources().getDimensionPixelSize(2131298324));
      i = ((Context)localObject).getResources().getDimensionPixelSize(2131298324);
      if ((parambcfz.jdField_a_of_type_Int == 6) || (parambcfz.jdField_a_of_type_Int == 8)) {
        i = bhgr.a((Context)localObject, 100.0F);
      }
      if (parambcof.jdField_a_of_type_AndroidWidgetRelativeLayout.getVisibility() != 8) {
        break label317;
      }
      i = 0;
      label127:
      float f = ((Context)localObject).getResources().getDisplayMetrics().widthPixels - bhgr.a((Context)localObject, 30.0F);
      CharSequence localCharSequence = bcni.a(parambcof.jdField_a_of_type_AndroidWidgetTextView, f, 2, parambcfz.jdField_a_of_type_JavaLangCharSequence.toString(), parambcfz.jdField_a_of_type_Bcmx.jdField_a_of_type_JavaUtilList, false, true);
      parambcof.jdField_a_of_type_AndroidWidgetTextView.setText(localCharSequence);
      f = ((Context)localObject).getResources().getDisplayMetrics().widthPixels - bhgr.a((Context)localObject, 30.0F) - i;
      localObject = bcni.a(parambcof.c, f, 2, parambcfz.jdField_b_of_type_JavaLangCharSequence.toString(), parambcfz.jdField_a_of_type_Bcmx.jdField_a_of_type_JavaUtilList, false, false);
      if (!ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null)) {
        break label333;
      }
      parambcof.c.setTextColor(Color.parseColor("#4A4A4A"));
      parambcof.jdField_d_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#4A4A4A"));
    }
    for (;;)
    {
      a(parambcof.c, (CharSequence)localObject, true);
      a(parambcof.jdField_d_of_type_AndroidWidgetTextView, parambcfz.jdField_c_of_type_JavaLangCharSequence);
      return;
      parambcof.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      break;
      label317:
      i += bhgr.a((Context)localObject, 10.0F);
      break label127;
      label333:
      parambcof.c.setTextColor(Color.parseColor("#737373"));
      parambcof.jdField_d_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#737373"));
    }
  }
  
  private void a(bcgc parambcgc, bcoh parambcoh)
  {
    Context localContext = parambcoh.a().getContext();
    int j;
    int i;
    if (parambcgc.jdField_a_of_type_Int == 1)
    {
      j = bhgr.a(localContext, 375.0F);
      i = bhgr.a(localContext, 150.0F);
    }
    for (;;)
    {
      int k;
      if ((j == 0) || (i == 0))
      {
        i = bhgr.a(localContext, 375.0F);
        j = bhgr.a(localContext, 150.0F);
        k = i;
        i = j;
      }
      for (;;)
      {
        if (!TextUtils.isEmpty(parambcgc.jdField_b_of_type_JavaLangString))
        {
          localObject = URLDrawable.URLDrawableOptions.obtain();
          ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
          ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
          ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = k;
          ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = i;
          ((URLDrawable.URLDrawableOptions)localObject).mPlayGifImage = true;
          localObject = URLDrawable.getDrawable(parambcgc.jdField_b_of_type_JavaLangString, (URLDrawable.URLDrawableOptions)localObject);
          parambcoh.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable((Drawable)localObject);
          if ((((URLDrawable)localObject).getStatus() != 1) && (((URLDrawable)localObject).getStatus() != 0)) {
            ((URLDrawable)localObject).restartDownload();
          }
          label164:
          parambcoh.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(0);
          localObject = (LinearLayout.LayoutParams)parambcoh.jdField_a_of_type_AndroidWidgetRelativeLayout.getLayoutParams();
          ((LinearLayout.LayoutParams)localObject).height = ((int)(i * zps.a(localContext) * 1.0F / k));
          parambcoh.jdField_a_of_type_AndroidWidgetRelativeLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
          parambcoh.jdField_a_of_type_AndroidWidgetRelativeLayout.setPadding(0, 0, 0, 0);
          if (TextUtils.isEmpty(parambcgc.jdField_a_of_type_JavaLangCharSequence)) {
            break label522;
          }
          parambcoh.jdField_b_of_type_AndroidWidgetTextView.setText(parambcgc.jdField_a_of_type_JavaLangCharSequence);
          parambcoh.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
          label253:
          if (TextUtils.isEmpty(parambcgc.jdField_b_of_type_JavaLangCharSequence)) {
            break label534;
          }
          parambcoh.c.setText(parambcgc.jdField_b_of_type_JavaLangCharSequence);
          parambcoh.c.setVisibility(0);
          label282:
          if (TextUtils.isEmpty(parambcgc.j)) {
            break label599;
          }
          parambcoh.jdField_d_of_type_AndroidWidgetTextView.setText(parambcgc.j);
        }
        try
        {
          if (!parambcgc.k.startsWith("#")) {
            parambcgc.k = ("#" + parambcgc.k);
          }
          parambcoh.jdField_d_of_type_AndroidWidgetTextView.setBackgroundColor(Color.parseColor(parambcgc.k));
        }
        catch (Exception localException)
        {
          for (;;)
          {
            label365:
            parambcoh.jdField_d_of_type_AndroidWidgetTextView.setBackgroundColor(Color.parseColor("#FF00FF00"));
            if (QLog.isColorLevel()) {
              QLog.e("Q.uniteSearch.SearchTemplatePresenter", 2, "bigImageItem.topLeftTagColor = " + parambcgc.k);
            }
          }
        }
        parambcoh.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
        Object localObject = ((ViewGroup)parambcoh.a()).getChildAt(((ViewGroup)parambcoh.a()).getChildCount() - 1);
        if ((localObject != null) && ((((View)localObject).getLayoutParams() instanceof LinearLayout.LayoutParams)))
        {
          if (parambcgc.b() != 0) {
            break label611;
          }
          ((LinearLayout.LayoutParams)((View)localObject).getLayoutParams()).topMargin = 0;
          parambcoh.jdField_a_of_type_AndroidWidgetRelativeLayout.setPadding(0, 0, 0, bhgr.a(localContext, 6.0F));
        }
        label522:
        label534:
        label599:
        label611:
        while (parambcgc.b() != 2)
        {
          return;
          if (parambcgc.jdField_a_of_type_Int == 2)
          {
            j = bhgr.a(localContext, 375.0F);
            i = bhgr.a(localContext, 180.0F);
            break;
          }
          if (parambcgc.jdField_a_of_type_Int != 0) {
            break label639;
          }
          j = bhgr.a(localContext, parambcgc.jdField_a_of_type_Float / 2.0F);
          i = bhgr.a(localContext, parambcgc.jdField_b_of_type_Float / 2.0F);
          break;
          parambcoh.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
          break label164;
          parambcoh.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
          break label253;
          parambcoh.c.setVisibility(8);
          break label282;
          parambcoh.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
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
  
  private void a(bcge parambcge, bcoj parambcoj)
  {
    Object localObject1 = parambcoj.a().getContext();
    Object localObject2 = parambcoj.a();
    if (parambcge.jdField_b_of_type_Boolean) {
      ((View)localObject2).setPadding(((View)localObject2).getPaddingLeft(), zps.a(((View)localObject2).getContext(), 6.0F), ((View)localObject2).getPaddingRight(), zps.a(((View)localObject2).getContext(), 6.0F));
    }
    Object localObject3;
    int i;
    Object localObject4;
    for (;;)
    {
      localObject2 = (LinearLayout)((View)localObject2).findViewById(2131372666);
      localObject3 = new ArrayList();
      i = 0;
      while (i < ((LinearLayout)localObject2).getChildCount())
      {
        localObject4 = ((LinearLayout)localObject2).getChildAt(i).findViewById(2131368416);
        if ((localObject4 instanceof SquareImageView)) {
          ((List)localObject3).add((SquareImageView)localObject4);
        }
        i += 1;
      }
      ((View)localObject2).setPadding(((View)localObject2).getPaddingLeft(), zps.a(((View)localObject2).getContext(), 3.0F), ((View)localObject2).getPaddingRight(), zps.a(((View)localObject2).getContext(), 3.0F));
    }
    if (!((List)localObject3).isEmpty())
    {
      if (parambcge.jdField_c_of_type_Boolean)
      {
        i = 0;
        while (i < ((List)localObject3).size())
        {
          ((SquareImageView)((List)localObject3).get(i)).setRoundRect(zps.a((Context)localObject1, 4.0F));
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
    if (!TextUtils.isEmpty(parambcge.i)) {
      a((Context)localObject1, (SquareImageView)parambcoj.b(), parambcoj.jdField_b_of_type_AndroidWidgetImageView, parambcoj.jdField_a_of_type_AndroidWidgetTextView, parambcge.jdField_a_of_type_Int, parambcge.i, null, bhgr.a((Context)localObject1, 32.0F));
    }
    label687:
    Object localObject5;
    if (!TextUtils.isEmpty(parambcge.jdField_a_of_type_JavaLangString))
    {
      localObject2 = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
      ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
      ((URLDrawable.URLDrawableOptions)localObject2).mRequestWidth = parambcoj.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams().width;
      ((URLDrawable.URLDrawableOptions)localObject2).mRequestHeight = parambcoj.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams().height;
      localObject2 = URLDrawable.getDrawable(parambcge.jdField_a_of_type_JavaLangString, (URLDrawable.URLDrawableOptions)localObject2);
      parambcoj.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject2);
      if ((((URLDrawable)localObject2).getStatus() != 1) && (((URLDrawable)localObject2).getStatus() != 0)) {
        ((URLDrawable)localObject2).restartDownload();
      }
      parambcoj.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      i = ((Context)localObject1).getResources().getDimensionPixelSize(2131298324);
      if ((parambcge.jdField_a_of_type_Int == 6) || (parambcge.jdField_a_of_type_Int == 8)) {
        i = bhgr.a((Context)localObject1, 100.0F);
      }
      localObject2 = bcni.a(parambcoj.a(), 10.0F * bcni.a(parambcoj.a(), anzj.a(2131712544)), 1, parambcge.jdField_a_of_type_JavaLangCharSequence.toString(), parambcge.jdField_a_of_type_Bcmx.jdField_a_of_type_JavaUtilList, false, false, true);
      parambcoj.a().setText((CharSequence)localObject2);
      parambcoj.a().setEllipsize(null);
      float f1 = ((Context)localObject1).getResources().getDisplayMetrics().widthPixels - bhgr.a((Context)localObject1, 40.0F) - i;
      localObject2 = bcni.a(parambcoj.b(), f1, 2, parambcge.jdField_b_of_type_JavaLangCharSequence.toString(), "", false, false, true);
      a(parambcoj.b(), (CharSequence)localObject2, false);
      if (TextUtils.isEmpty(parambcge.jdField_c_of_type_JavaLangCharSequence)) {
        break label1047;
      }
      f1 = ((Context)localObject1).getResources().getDisplayMetrics().widthPixels - bhgr.a((Context)localObject1, 30.0F);
      localObject2 = bcni.a(parambcoj.c(), f1, 2, parambcge.jdField_c_of_type_JavaLangCharSequence.toString(), parambcge.jdField_a_of_type_Bcmx.jdField_a_of_type_JavaUtilList, false, false);
      parambcoj.c().setText((CharSequence)localObject2);
      parambcoj.c().setVisibility(0);
      if (parambcge.jdField_a_of_type_JavaUtilList == null) {
        break label1479;
      }
      if (parambcge.jdField_a_of_type_JavaUtilList.size() != 1) {
        break label1071;
      }
      parambcoj.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(0);
      parambcoj.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      localObject3 = parambcoj.a().getResources();
      if (jdField_a_of_type_Int == 0) {
        jdField_a_of_type_Int = ((Resources)localObject3).getDisplayMetrics().widthPixels;
      }
      localObject2 = parambcoj.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView;
      ((SquareImageView)localObject2).setImageScale((float)(1.0D / parambcge.jdField_a_of_type_Double), 0.0F);
      f1 = ((Resources)localObject3).getDimension(2131298317);
      float f2 = ((Resources)localObject3).getDimension(2131298317);
      i = bhgr.a(parambcoj.a().getContext(), 2.0F);
      j = parambcoj.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount();
      j = (int)(jdField_a_of_type_Int - f1 - f2 - (j - 1) * i) / j;
      i = (int)(j * parambcge.jdField_b_of_type_Double);
      j = (int)(j * parambcge.jdField_b_of_type_Double);
      ((SquareImageView)localObject2).setLayoutParams(new FrameLayout.LayoutParams(i, j));
      localObject3 = (bcft)parambcge.jdField_a_of_type_JavaUtilList.get(0);
      localObject4 = ((bcft)localObject3).jdField_a_of_type_JavaLangString;
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
      if (((bcft)localObject3).jdField_a_of_type_Int != 2) {
        break label1059;
      }
      parambcoj.jdField_d_of_type_AndroidWidgetImageView.setVisibility(0);
    }
    for (;;)
    {
      if ((parambcge.jdField_c_of_type_JavaUtilList != null) || (!TextUtils.equals(parambcge.k, "0")) || (!TextUtils.equals(parambcge.m, "0"))) {
        break label1500;
      }
      parambcoj.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      return;
      parambcoj.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      break;
      label1047:
      parambcoj.c().setVisibility(8);
      break label687;
      label1059:
      parambcoj.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
      continue;
      label1071:
      parambcoj.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(8);
      parambcoj.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      int m = parambcoj.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount();
      i = 0;
      j = i;
      if (i < parambcge.jdField_a_of_type_JavaUtilList.size())
      {
        j = i;
        if (i < m)
        {
          localObject3 = parambcoj.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(i);
          ((View)localObject3).setVisibility(0);
          localObject2 = (SquareImageView)((View)localObject3).findViewById(2131368416);
          localObject3 = (ImageView)((View)localObject3).findViewById(2131369619);
          ((SquareImageView)localObject2).setImageScale((float)(1.0D / parambcge.jdField_a_of_type_Double), 0.0F);
          localObject4 = (bcft)parambcge.jdField_a_of_type_JavaUtilList.get(i);
          localObject5 = ((bcft)localObject4).jdField_a_of_type_JavaLangString;
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
          if (((bcft)localObject4).jdField_a_of_type_Int == 2)
          {
            ((ImageView)localObject3).setVisibility(0);
            label1312:
            if ((i != m - 1) || (parambcge.jdField_b_of_type_Int <= m)) {
              break label1433;
            }
            ((ImageView)localObject3).setVisibility(8);
            ((SquareImageView)localObject2).setFilterColor(Color.parseColor("#66000000"));
            int k = parambcge.jdField_b_of_type_Int - m;
            j = k;
            if (k > 99) {
              j = 99;
            }
            ((SquareImageView)localObject2).setFilterText("+" + j);
            ((SquareImageView)localObject2).setFilterTextSize(bhgr.a(((SquareImageView)localObject2).getContext(), 20.0F));
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
        parambcoj.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(j).setVisibility(4);
        j += 1;
      }
      continue;
      label1479:
      parambcoj.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(8);
      parambcoj.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    }
    label1500:
    if (parambcge.jdField_c_of_type_JavaUtilList != null)
    {
      parambcoj.jdField_a_of_type_AndroidWidgetRelativeLayout.removeAllViews();
      i = parambcge.jdField_c_of_type_JavaUtilList.size() - 1;
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
    for (int j = bhgr.a((Context)localObject1, 11.0F) * i;; j = 0)
    {
      localObject2 = (SquareImageView)LayoutInflater.from((Context)localObject1).inflate(2131559820, null, false);
      localObject3 = new RelativeLayout.LayoutParams(bhgr.a((Context)localObject1, 16.0F), bhgr.a((Context)localObject1, 16.0F));
      ((RelativeLayout.LayoutParams)localObject3).leftMargin = j;
      parambcoj.jdField_a_of_type_AndroidWidgetRelativeLayout.addView((View)localObject2, parambcge.jdField_c_of_type_JavaUtilList.size() - 1 - i, (ViewGroup.LayoutParams)localObject3);
      localObject3 = (String)parambcge.jdField_c_of_type_JavaUtilList.get(i);
      localObject4 = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject4).mFailedDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
      ((URLDrawable.URLDrawableOptions)localObject4).mLoadingDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
      ((URLDrawable.URLDrawableOptions)localObject4).mRequestWidth = ((SquareImageView)localObject2).getLayoutParams().width;
      ((URLDrawable.URLDrawableOptions)localObject4).mRequestHeight = ((SquareImageView)localObject2).getLayoutParams().height;
      localObject3 = URLDrawable.getDrawable((String)localObject3, (URLDrawable.URLDrawableOptions)localObject4);
      ((URLDrawable)localObject3).setDecodeHandler(bhez.a);
      ((SquareImageView)localObject2).setImageDrawable((Drawable)localObject3);
      if ((((URLDrawable)localObject3).getStatus() != 1) && (((URLDrawable)localObject3).getStatus() != 0)) {
        ((URLDrawable)localObject3).restartDownload();
      }
      ((SquareImageView)localObject2).setVisibility(0);
      i -= 1;
      break;
      parambcoj.jdField_a_of_type_AndroidWidgetRelativeLayout.removeAllViews();
      label1758:
      if (!TextUtils.isEmpty(parambcge.jdField_b_of_type_JavaLangString))
      {
        parambcoj.jdField_b_of_type_AndroidWidgetTextView.setText(parambcge.jdField_b_of_type_JavaLangString);
        parambcoj.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
        if (TextUtils.isEmpty(parambcge.j)) {
          break label2084;
        }
        localObject1 = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject1).mFailedDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
        ((URLDrawable.URLDrawableOptions)localObject1).mLoadingDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
        ((URLDrawable.URLDrawableOptions)localObject1).mRequestWidth = parambcoj.jdField_a_of_type_ComTencentImageURLImageView.getLayoutParams().width;
        ((URLDrawable.URLDrawableOptions)localObject1).mRequestHeight = parambcoj.jdField_a_of_type_ComTencentImageURLImageView.getLayoutParams().height;
        localObject1 = URLDrawable.getDrawable(parambcge.j, (URLDrawable.URLDrawableOptions)localObject1);
        parambcoj.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable((Drawable)localObject1);
        if ((((URLDrawable)localObject1).getStatus() != 1) && (((URLDrawable)localObject1).getStatus() != 0)) {
          ((URLDrawable)localObject1).restartDownload();
        }
        parambcoj.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(0);
        label1900:
        if (TextUtils.isEmpty(parambcge.k)) {
          break label2096;
        }
        parambcoj.c.setText(parambcge.k);
        parambcoj.c.setVisibility(0);
        if (TextUtils.isEmpty(parambcge.l)) {
          break label2108;
        }
        localObject1 = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject1).mFailedDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
        ((URLDrawable.URLDrawableOptions)localObject1).mLoadingDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
        ((URLDrawable.URLDrawableOptions)localObject1).mRequestWidth = parambcoj.jdField_b_of_type_ComTencentImageURLImageView.getLayoutParams().width;
        ((URLDrawable.URLDrawableOptions)localObject1).mRequestHeight = parambcoj.jdField_b_of_type_ComTencentImageURLImageView.getLayoutParams().height;
        localObject1 = URLDrawable.getDrawable(parambcge.l, (URLDrawable.URLDrawableOptions)localObject1);
        parambcoj.jdField_b_of_type_ComTencentImageURLImageView.setImageDrawable((Drawable)localObject1);
        if ((((URLDrawable)localObject1).getStatus() != 1) && (((URLDrawable)localObject1).getStatus() != 0)) {
          ((URLDrawable)localObject1).restartDownload();
        }
        parambcoj.jdField_b_of_type_ComTencentImageURLImageView.setVisibility(0);
      }
      for (;;)
      {
        if (TextUtils.isEmpty(parambcge.m)) {
          break label2120;
        }
        parambcoj.jdField_d_of_type_AndroidWidgetTextView.setText(parambcge.m);
        parambcoj.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
        return;
        parambcoj.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
        break;
        parambcoj.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(8);
        break label1900;
        parambcoj.c.setVisibility(8);
        break label1929;
        parambcoj.jdField_b_of_type_ComTencentImageURLImageView.setVisibility(8);
      }
      parambcoj.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
      return;
    }
  }
  
  private void a(bcgk parambcgk, bcop parambcop)
  {
    Object localObject = parambcop.a();
    Context localContext = ((View)localObject).getContext();
    if (((localObject instanceof LinearLayout)) && (((LinearLayout)localObject).getChildCount() == 1))
    {
      localObject = ((LinearLayout)localObject).getChildAt(0);
      ((View)localObject).setPadding(((View)localObject).getPaddingLeft(), 0, ((View)localObject).getPaddingRight(), 0);
    }
    if (!TextUtils.isEmpty(parambcgk.jdField_b_of_type_JavaLangString))
    {
      localObject = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
      ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
      ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = bhgr.a(localContext, 50.0F);
      ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = bhgr.a(localContext, 50.0F);
      ((URLDrawable.URLDrawableOptions)localObject).mMemoryCacheKeySuffix = "leftIcon";
      localObject = URLDrawable.getDrawable(parambcgk.jdField_b_of_type_JavaLangString, (URLDrawable.URLDrawableOptions)localObject);
      parambcop.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable((Drawable)localObject);
      if ((((URLDrawable)localObject).getStatus() != 1) && (((URLDrawable)localObject).getStatus() != 0)) {
        ((URLDrawable)localObject).restartDownload();
      }
      parambcop.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(0);
      if (TextUtils.isEmpty(parambcgk.j)) {
        break label504;
      }
      parambcop.jdField_a_of_type_AndroidWidgetTextView.setText(parambcgk.j);
      parambcop.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      label204:
      if (TextUtils.isEmpty(parambcgk.g)) {
        break label516;
      }
      parambcop.jdField_b_of_type_AndroidWidgetTextView.setText(parambcgk.g);
      parambcop.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      label233:
      if (TextUtils.isEmpty(parambcgk.k)) {
        break label528;
      }
      parambcop.c.setVisibility(0);
      parambcop.c.setText(parambcgk.k);
      label262:
      if (TextUtils.isEmpty(parambcgk.l)) {
        break label540;
      }
      localObject = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
      ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
      ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = bhgr.a(localContext, 30.0F);
      ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = bhgr.a(localContext, 30.0F);
      ((URLDrawable.URLDrawableOptions)localObject).mMemoryCacheKeySuffix = "rightIcon";
      localObject = URLDrawable.getDrawable(parambcgk.l, (URLDrawable.URLDrawableOptions)localObject);
      parambcop.jdField_b_of_type_ComTencentImageURLImageView.setImageDrawable((Drawable)localObject);
      if ((((URLDrawable)localObject).getStatus() != 1) && (((URLDrawable)localObject).getStatus() != 0)) {
        ((URLDrawable)localObject).restartDownload();
      }
      parambcop.jdField_b_of_type_ComTencentImageURLImageView.setVisibility(0);
      label377:
      parambcop.a(parambcgk);
      if (!ThemeUtil.isInNightMode(BaseApplicationImpl.getApplication().getRuntime())) {
        break label552;
      }
      parambcop.jdField_a_of_type_AndroidWidgetLinearLayout.setBackgroundResource(2130839394);
      parambcop.jdField_b_of_type_AndroidWidgetLinearLayout.setBackgroundResource(2130839394);
      parambcop.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#737373"));
      parambcop.c.setTextColor(Color.parseColor("#4A4A4A"));
    }
    for (;;)
    {
      if (parambcop.jdField_b_of_type_AndroidWidgetTextView != null) {
        parambcop.jdField_b_of_type_AndroidWidgetTextView.setTextColor(bcni.b());
      }
      parambcop.jdField_a_of_type_AndroidWidgetLinearLayout.setOnClickListener(new bcjo(this, parambcgk, localContext));
      parambcop.jdField_b_of_type_AndroidWidgetLinearLayout.setOnClickListener(new bcjp(this, parambcgk, localContext));
      return;
      parambcop.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(8);
      break;
      label504:
      parambcop.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      break label204;
      label516:
      parambcop.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      break label233;
      label528:
      parambcop.c.setVisibility(8);
      break label262;
      label540:
      parambcop.jdField_b_of_type_ComTencentImageURLImageView.setVisibility(8);
      break label377;
      label552:
      parambcop.jdField_a_of_type_AndroidWidgetLinearLayout.setBackgroundResource(2130839393);
      parambcop.jdField_b_of_type_AndroidWidgetLinearLayout.setBackgroundResource(2130839393);
      parambcop.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#262626"));
      parambcop.c.setTextColor(Color.parseColor("#737373"));
    }
  }
  
  private void a(bcgl parambcgl, bcor parambcor)
  {
    Object localObject = parambcor.a();
    Context localContext = ((View)localObject).getContext();
    if (((localObject instanceof LinearLayout)) && (((LinearLayout)localObject).getChildCount() == 1))
    {
      localObject = ((LinearLayout)localObject).getChildAt(0);
      ((View)localObject).setPadding(((View)localObject).getPaddingLeft(), 0, ((View)localObject).getPaddingRight(), 0);
    }
    if (!TextUtils.isEmpty(parambcgl.jdField_b_of_type_JavaLangString))
    {
      localObject = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
      ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
      ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = bhgr.a(localContext, 40.0F);
      ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = bhgr.a(localContext, 40.0F);
      ((URLDrawable.URLDrawableOptions)localObject).mMemoryCacheKeySuffix = "leftIcon";
      localObject = URLDrawable.getDrawable(parambcgl.jdField_b_of_type_JavaLangString, (URLDrawable.URLDrawableOptions)localObject);
      parambcor.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable((Drawable)localObject);
      if ((((URLDrawable)localObject).getStatus() != 1) && (((URLDrawable)localObject).getStatus() != 0)) {
        ((URLDrawable)localObject).restartDownload();
      }
      parambcor.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(0);
      if (TextUtils.isEmpty(parambcgl.j)) {
        break label363;
      }
      parambcor.jdField_a_of_type_AndroidWidgetTextView.setText(parambcgl.j);
      parambcor.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      label204:
      if (TextUtils.isEmpty(parambcgl.g)) {
        break label375;
      }
      parambcor.c.setText(parambcgl.g);
      parambcor.c.setVisibility(0);
      label233:
      if (TextUtils.isEmpty(parambcgl.k)) {
        break label387;
      }
      parambcor.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
      parambcor.jdField_d_of_type_AndroidWidgetTextView.setText(parambcgl.k);
      label262:
      if (!parambcgl.jdField_b_of_type_Boolean) {
        break label399;
      }
      parambcor.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    }
    for (;;)
    {
      bcjy.a(null, 0, parambcgl.jdField_c_of_type_Int, "0X8009D5C", 0, 0, null, null);
      if ((parambcgl.jdField_a_of_type_JavaUtilList != null) && (parambcgl.jdField_a_of_type_JavaUtilList.size() > 0)) {
        bcjy.a(null, 0, parambcgl.jdField_c_of_type_Int, "0X8009D5E", 0, 0, null, null);
      }
      parambcor.a(parambcgl);
      parambcor.jdField_a_of_type_AndroidWidgetLinearLayout.setOnClickListener(new bcjn(this, parambcgl, localContext));
      return;
      parambcor.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(8);
      break;
      label363:
      parambcor.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      break label204;
      label375:
      parambcor.c.setVisibility(8);
      break label233;
      label387:
      parambcor.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
      break label262;
      label399:
      parambcor.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    }
  }
  
  private void a(bcgn parambcgn, bcox parambcox)
  {
    if ((parambcgn == null) || (parambcox == null)) {
      return;
    }
    parambcox.jdField_a_of_type_AndroidWidgetLinearLayout.setPadding(parambcox.jdField_a_of_type_AndroidWidgetLinearLayout.getPaddingLeft(), 0, parambcox.jdField_a_of_type_AndroidWidgetLinearLayout.getPaddingRight(), 0);
    Object localObject = (RelativeLayout.LayoutParams)parambcox.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams();
    boolean bool = ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null);
    if (parambcgn.jdField_b_of_type_Boolean)
    {
      ((RelativeLayout.LayoutParams)localObject).addRule(5, 0);
      ((RelativeLayout.LayoutParams)localObject).addRule(14);
      localObject = parambcox.jdField_a_of_type_AndroidWidgetTextView.getContext();
      int i = ((Context)localObject).getResources().getDisplayMetrics().widthPixels - bhgr.a((Context)localObject, 38.0F);
      if (TextUtils.isEmpty(parambcgn.jdField_b_of_type_JavaLangCharSequence)) {
        break label310;
      }
      parambcox.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      if (!bool) {
        break label296;
      }
      parambcox.jdField_b_of_type_AndroidWidgetTextView.setText(parambcgn.jdField_b_of_type_JavaLangCharSequence.toString());
      label148:
      float f1 = i;
      float f2 = bcni.a(parambcox.jdField_b_of_type_AndroidWidgetTextView, parambcgn.jdField_b_of_type_JavaLangCharSequence);
      i = (int)(f1 - (bhgr.a((Context)localObject, 10.0F) + f2));
      label182:
      if (TextUtils.isEmpty(parambcgn.jdField_a_of_type_JavaLangCharSequence)) {
        break label334;
      }
      parambcox.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      localObject = parambcgn.jdField_a_of_type_JavaLangCharSequence;
      if (parambcgn.jdField_b_of_type_Boolean) {
        break label346;
      }
      localObject = bcni.a(parambcox.jdField_a_of_type_AndroidWidgetTextView, i, (CharSequence)localObject);
    }
    label296:
    label310:
    label334:
    label346:
    for (;;)
    {
      if (bool) {
        parambcox.jdField_a_of_type_AndroidWidgetTextView.setText(((CharSequence)localObject).toString());
      }
      for (;;)
      {
        parambcox.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundDrawable(a(parambcgn.jdField_a_of_type_JavaLangString));
        parambcox.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(new bcjq(this, parambcgn, parambcox));
        return;
        ((RelativeLayout.LayoutParams)localObject).addRule(14, 0);
        ((RelativeLayout.LayoutParams)localObject).addRule(5);
        break;
        parambcox.jdField_b_of_type_AndroidWidgetTextView.setText(parambcgn.jdField_b_of_type_JavaLangCharSequence);
        break label148;
        parambcox.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
        break label182;
        parambcox.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
        continue;
        parambcox.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      }
    }
  }
  
  private void a(bcgo parambcgo, bcow parambcow)
  {
    if ((parambcgo == null) || (parambcow == null)) {}
    while ((TextUtils.isEmpty(parambcgo.jdField_a_of_type_JavaLangString)) || (parambcow.jdField_a_of_type_AndroidWidgetTextView == null)) {
      return;
    }
    Context localContext = parambcow.jdField_a_of_type_AndroidWidgetTextView.getContext();
    int j = localContext.getResources().getDisplayMetrics().widthPixels - bhgr.a(localContext, 40.0F);
    int i;
    if ((!TextUtils.isEmpty(parambcgo.e)) && (parambcow.jdField_a_of_type_AndroidWidgetLinearLayout != null))
    {
      parambcow.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      i = j - bhgr.a(localContext, 26.0F);
    }
    for (;;)
    {
      parambcgo = bcni.a(parambcow.jdField_a_of_type_AndroidWidgetTextView, i, parambcgo.jdField_a_of_type_JavaLangString);
      parambcow.jdField_a_of_type_AndroidWidgetTextView.setText(parambcgo);
      return;
      i = j;
      if (parambcow.jdField_a_of_type_AndroidWidgetLinearLayout != null)
      {
        parambcow.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
        i = j;
      }
    }
  }
  
  private void a(bcgq parambcgq, bcoz parambcoz)
  {
    Context localContext = parambcoz.jdField_b_of_type_AndroidWidgetRelativeLayout.getContext();
    Object localObject = (RelativeLayout.LayoutParams)parambcoz.jdField_a_of_type_AndroidWidgetLinearLayout.getLayoutParams();
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)parambcoz.jdField_b_of_type_AndroidWidgetRelativeLayout.getLayoutParams();
    if (parambcgq.jdField_b_of_type_Boolean)
    {
      ((RelativeLayout.LayoutParams)localObject).addRule(15);
      localLayoutParams.addRule(15);
      localLayoutParams.addRule(10, 0);
      localLayoutParams.addRule(10, 0);
    }
    for (;;)
    {
      localObject = a(parambcgq, parambcoz, false, 0);
      if (((Integer)((Pair)localObject).first).intValue() != 0) {
        ((RelativeLayout.LayoutParams)parambcoz.jdField_b_of_type_AndroidWidgetRelativeLayout.getLayoutParams()).rightMargin = bhgr.a(localContext, 10.0F);
      }
      int i = a(parambcgq, parambcoz);
      int j = a(parambcgq, parambcoz, ((Integer)((Pair)localObject).first).intValue(), i);
      i = j;
      if (((Integer)((Pair)localObject).second).intValue() > j) {
        i = ((Integer)((Pair)localObject).second).intValue();
      }
      if (parambcoz.jdField_a_of_type_AndroidWidgetRelativeLayout != null) {
        ((RelativeLayout.LayoutParams)parambcoz.jdField_a_of_type_AndroidWidgetRelativeLayout.getLayoutParams()).height = i;
      }
      return;
      ((RelativeLayout.LayoutParams)localObject).addRule(10);
      localLayoutParams.addRule(10);
      ((RelativeLayout.LayoutParams)localObject).addRule(15, 0);
      localLayoutParams.addRule(15, 0);
    }
  }
  
  private void a(bcgu parambcgu, bcpa parambcpa)
  {
    Object localObject1 = parambcpa.a().getContext();
    Object localObject2 = parambcpa.a();
    if (parambcgu.jdField_b_of_type_Boolean) {
      ((View)localObject2).setPadding(((View)localObject2).getPaddingLeft(), zps.a(((View)localObject2).getContext(), 9.0F), ((View)localObject2).getPaddingRight(), zps.a(((View)localObject2).getContext(), 9.0F));
    }
    Object localObject3;
    int i;
    Object localObject4;
    for (;;)
    {
      localObject2 = (LinearLayout)((View)localObject2).findViewById(2131372666);
      localObject3 = new ArrayList();
      i = 0;
      while (i < ((LinearLayout)localObject2).getChildCount())
      {
        localObject4 = ((LinearLayout)localObject2).getChildAt(i).findViewById(2131368416);
        if ((localObject4 instanceof SquareImageView)) {
          ((List)localObject3).add((SquareImageView)localObject4);
        }
        i += 1;
      }
      ((View)localObject2).setPadding(((View)localObject2).getPaddingLeft(), zps.a(((View)localObject2).getContext(), 6.0F), ((View)localObject2).getPaddingRight(), zps.a(((View)localObject2).getContext(), 6.0F));
    }
    if (!((List)localObject3).isEmpty())
    {
      if (parambcgu.jdField_c_of_type_Boolean)
      {
        i = 0;
        while (i < ((List)localObject3).size())
        {
          ((SquareImageView)((List)localObject3).get(i)).setRoundRect(zps.a((Context)localObject1, 4.0F));
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
      parambcpa.a().setTextColor(Color.parseColor("#6991B8"));
      parambcpa.c().setTextColor(Color.parseColor("#44608A"));
      parambcpa.b().setTextColor(Color.parseColor("#44608A"));
      if (!TextUtils.isEmpty(parambcgu.i)) {
        a((Context)localObject1, (SquareImageView)parambcpa.b(), parambcpa.jdField_b_of_type_AndroidWidgetImageView, parambcpa.jdField_a_of_type_AndroidWidgetTextView, parambcgu.jdField_a_of_type_Int, parambcgu.i, null, bhgr.a((Context)localObject1, 21.0F));
      }
      if (TextUtils.isEmpty(parambcgu.jdField_a_of_type_JavaLangString)) {
        break label1085;
      }
      localObject2 = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
      ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
      ((URLDrawable.URLDrawableOptions)localObject2).mRequestWidth = parambcpa.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams().width;
      ((URLDrawable.URLDrawableOptions)localObject2).mRequestHeight = parambcpa.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams().height;
      localObject2 = URLDrawable.getDrawable(parambcgu.jdField_a_of_type_JavaLangString, (URLDrawable.URLDrawableOptions)localObject2);
      parambcpa.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject2);
      if ((((URLDrawable)localObject2).getStatus() != 1) && (((URLDrawable)localObject2).getStatus() != 0)) {
        ((URLDrawable)localObject2).restartDownload();
      }
      parambcpa.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      i = ((Context)localObject1).getResources().getDimensionPixelSize(2131298324);
      if ((parambcgu.jdField_a_of_type_Int == 6) || (parambcgu.jdField_a_of_type_Int == 8)) {
        i = bhgr.a((Context)localObject1, 100.0F);
      }
      localObject2 = bcni.a(parambcpa.a(), 10.0F * bcni.a(parambcpa.a(), anzj.a(2131712543)), 1, parambcgu.jdField_a_of_type_JavaLangCharSequence.toString(), parambcgu.jdField_a_of_type_Bcmx.jdField_a_of_type_JavaUtilList, false, false, true);
      parambcpa.a().setText((CharSequence)localObject2);
      parambcpa.a().setEllipsize(null);
      float f1 = ((Context)localObject1).getResources().getDisplayMetrics().widthPixels - bhgr.a((Context)localObject1, 40.0F) - i;
      localObject2 = bcni.a(parambcpa.b(), f1, 2, parambcgu.jdField_b_of_type_JavaLangCharSequence.toString(), "", false, false, true);
      a(parambcpa.b(), (CharSequence)localObject2, false);
      if (TextUtils.isEmpty(parambcgu.jdField_c_of_type_JavaLangCharSequence)) {
        break label1097;
      }
      f1 = ((Context)localObject1).getResources().getDisplayMetrics().widthPixels - bhgr.a((Context)localObject1, 30.0F);
      localObject2 = bcni.a(parambcpa.c(), f1, 2, parambcgu.jdField_c_of_type_JavaLangCharSequence.toString(), parambcgu.jdField_a_of_type_Bcmx.jdField_a_of_type_JavaUtilList, false, false);
      parambcpa.c().setText((CharSequence)localObject2);
      parambcpa.c().setVisibility(0);
      label740:
      if (parambcgu.jdField_a_of_type_JavaUtilList == null) {
        break label1546;
      }
      if (parambcgu.jdField_a_of_type_JavaUtilList.size() != 1) {
        break label1119;
      }
      parambcpa.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(0);
      parambcpa.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      localObject2 = parambcpa.a().getResources();
      if (jdField_a_of_type_Int == 0) {
        jdField_a_of_type_Int = ((Resources)localObject2).getDisplayMetrics().widthPixels;
      }
      localObject1 = parambcpa.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView;
      ((SquareImageView)localObject1).setImageScale((float)(1.0D / parambcgu.jdField_a_of_type_Double), 0.0F);
      f1 = ((Resources)localObject2).getDimension(2131298317);
      float f2 = ((Resources)localObject2).getDimension(2131298317);
      i = bhgr.a(parambcpa.a().getContext(), 2.0F);
      j = parambcpa.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount();
      j = (int)(jdField_a_of_type_Int - f1 - f2 - (j - 1) * i) / j;
      i = (int)(j * parambcgu.jdField_b_of_type_Double);
      j = (int)(j * parambcgu.jdField_b_of_type_Double);
      ((SquareImageView)localObject1).setLayoutParams(new FrameLayout.LayoutParams(i, j));
      parambcgu = (bcft)parambcgu.jdField_a_of_type_JavaUtilList.get(0);
      localObject2 = parambcgu.jdField_a_of_type_JavaLangString;
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
      if (parambcgu.jdField_a_of_type_Int != 2) {
        break label1109;
      }
      parambcpa.jdField_d_of_type_AndroidWidgetImageView.setVisibility(0);
    }
    for (;;)
    {
      return;
      parambcpa.a().setTextColor(Color.parseColor("#262626"));
      parambcpa.c().setTextColor(Color.parseColor("#737373"));
      parambcpa.b().setTextColor(Color.parseColor("#737373"));
      break;
      label1085:
      parambcpa.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      break label496;
      label1097:
      parambcpa.c().setVisibility(8);
      break label740;
      label1109:
      parambcpa.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
      return;
      label1119:
      parambcpa.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(8);
      parambcpa.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      int m = parambcpa.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount();
      i = 0;
      j = i;
      if (i < parambcgu.jdField_a_of_type_JavaUtilList.size())
      {
        j = i;
        if (i < m)
        {
          localObject3 = parambcpa.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(i);
          ((View)localObject3).setVisibility(0);
          localObject2 = (SquareImageView)((View)localObject3).findViewById(2131368416);
          localObject3 = (ImageView)((View)localObject3).findViewById(2131369619);
          j = zps.a((Context)localObject1) / m;
          int k = (int)(j * parambcgu.jdField_a_of_type_Double);
          ((SquareImageView)localObject2).setImageScale((float)(1.0D / parambcgu.jdField_a_of_type_Double), 0.0F);
          localObject4 = (bcft)parambcgu.jdField_a_of_type_JavaUtilList.get(i);
          Object localObject5 = ((bcft)localObject4).jdField_a_of_type_JavaLangString;
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
          if (((bcft)localObject4).jdField_a_of_type_Int == 2)
          {
            ((ImageView)localObject3).setVisibility(0);
            label1379:
            if ((i != m - 1) || (parambcgu.jdField_b_of_type_Int <= m)) {
              break label1500;
            }
            ((ImageView)localObject3).setVisibility(8);
            ((SquareImageView)localObject2).setFilterColor(Color.parseColor("#66000000"));
            k = parambcgu.jdField_b_of_type_Int - m;
            j = k;
            if (k > 99) {
              j = 99;
            }
            ((SquareImageView)localObject2).setFilterText("+" + j);
            ((SquareImageView)localObject2).setFilterTextSize(bhgr.a(((SquareImageView)localObject2).getContext(), 20.0F));
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
        parambcpa.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(j).setVisibility(4);
        j += 1;
      }
    }
    label1546:
    parambcpa.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(8);
    parambcpa.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
  }
  
  private void a(SquareImageView paramSquareImageView, int paramInt1, int paramInt2, String paramString)
  {
    if ((paramSquareImageView == null) || (TextUtils.isEmpty(paramString))) {
      return;
    }
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mFailedDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
    localURLDrawableOptions.mLoadingDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
    paramSquareImageView.getLayoutParams().width = bhgr.a(paramSquareImageView.getContext(), paramInt1);
    paramSquareImageView.getLayoutParams().height = bhgr.a(paramSquareImageView.getContext(), paramInt2);
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
  
  private void b(bcgq parambcgq, bcoz parambcoz)
  {
    if ((parambcgq == null) || (parambcgq.jdField_a_of_type_Bcgr == null) || (parambcoz == null)) {
      if ((parambcoz != null) && (parambcoz.jdField_b_of_type_AndroidWidgetButton != null)) {
        parambcoz.jdField_b_of_type_AndroidWidgetButton.setVisibility(8);
      }
    }
    while (parambcoz.jdField_b_of_type_AndroidWidgetButton == null) {
      return;
    }
    Context localContext = parambcoz.jdField_b_of_type_AndroidWidgetButton.getContext();
    if ((parambcgq.jdField_a_of_type_Bcgr.jdField_a_of_type_Int == 1) && (!TextUtils.isEmpty(parambcgq.jdField_a_of_type_Bcgr.jdField_a_of_type_JavaLangCharSequence)))
    {
      parambcoz.jdField_b_of_type_AndroidWidgetButton.setVisibility(0);
      parambcoz.jdField_b_of_type_AndroidWidgetButton.setText(parambcgq.jdField_a_of_type_Bcgr.jdField_a_of_type_JavaLangCharSequence);
      parambcoz.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(new bcjt(this, localContext, parambcgq));
      return;
    }
    parambcoz.jdField_b_of_type_AndroidWidgetButton.setVisibility(8);
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
      a(paramSquareImageView, paramImageView, paramTextView, paramInt2, paramInt2, false, paramString1, null, 2130842297, false);
      return;
    case 4: 
      a(paramSquareImageView, paramImageView, paramTextView, paramInt2, paramInt2, false, paramString1, null, 2130842297, false);
      return;
    case 5: 
      a(paramSquareImageView, paramImageView, paramTextView, paramInt2, paramInt2, false, paramString1, null, 0, true);
      return;
    case 6: 
      paramInt1 = bhgr.a(paramContext, 62.0F);
      a(paramSquareImageView, paramImageView, paramTextView, bhgr.a(paramContext, 100.0F), paramInt1, false, paramString1, null, 2130842297, false);
      return;
    case 7: 
      a(paramSquareImageView, paramImageView, paramTextView, bhgr.a(paramContext, 100.0F), bhgr.a(paramContext, 62.0F), false, paramString1, paramString2, 0, false);
      return;
    }
    a(paramSquareImageView, paramImageView, paramTextView, bhgr.a(paramContext, 100.0F), bhgr.a(paramContext, 62.0F), false, paramString1, null, 0, false);
  }
  
  public void a(ImageView paramImageView)
  {
    if (paramImageView == null) {}
    Animation localAnimation;
    do
    {
      return;
      localAnimation = AnimationUtils.loadAnimation(paramImageView.getContext(), 2130772197);
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
  
  public void a(bcga parambcga, bcog parambcog)
  {
    bcnl.a(parambcga.a(), parambcga.b(), parambcog.a(), parambcga.jdField_a_of_type_Boolean, parambcga.u, parambcga.g);
    switch (parambcga.d())
    {
    }
    for (;;)
    {
      b(parambcga, parambcog);
      if (TextUtils.isEmpty(parambcga.i)) {
        c(parambcga, parambcog);
      }
      return;
      a((bcfy)parambcga, (bcoe)parambcog);
      continue;
      a((bcgu)parambcga, (bcpa)parambcog);
      continue;
      a((bcfz)parambcga, (bcof)parambcog);
      continue;
      a((bcgh)parambcga, (bcom)parambcog);
      continue;
      a((bcgq)parambcga, (bcoz)parambcog);
      continue;
      a((bcgn)parambcga, (bcox)parambcog);
      continue;
      a((bcgo)parambcga, (bcow)parambcog);
      continue;
      a((bcge)parambcga, (bcoj)parambcog);
      continue;
      a((bcgc)parambcga, (bcoh)parambcog);
      continue;
      a((bcgf)parambcga, (bcok)parambcog);
      continue;
      a((bcgp)parambcga, (bcoy)parambcog);
      continue;
      a((bcgm)parambcga, (bcou)parambcog);
      continue;
      a((bcgk)parambcga, (bcop)parambcog);
      continue;
      a((bcgl)parambcga, (bcor)parambcog);
      continue;
      a((bcgj)parambcga, (bcoo)parambcog);
    }
  }
  
  public void a(bcga parambcga, bcog parambcog, Bitmap paramBitmap)
  {
    if (parambcog.b() != null) {
      parambcog.b().setImageBitmap(paramBitmap);
    }
  }
  
  protected void a(bcgf parambcgf, bcok parambcok)
  {
    if ((parambcgf.jdField_a_of_type_JavaUtilArrayList == null) || (parambcgf.jdField_a_of_type_JavaUtilArrayList.size() == 0))
    {
      if (QLog.isColorLevel()) {
        QLog.e("Q.uniteSearch.SearchTemplatePresenter", 2, "bindHorSlidingContainerTemplateView, containerItem.horizontalModelItems is empty");
      }
      return;
    }
    bcbo localbcbo2 = (bcbo)parambcok.jdField_a_of_type_ComTencentWidgetHorizontalListView.getAdapter();
    bcbo localbcbo1;
    if (localbcbo2 != null)
    {
      localbcbo1 = localbcbo2;
      if (localbcbo2.a() == parambcgf.jdField_a_of_type_JavaUtilArrayList) {}
    }
    else
    {
      localbcbo1 = new bcbo(parambcgf, this.jdField_a_of_type_Bcbl.jdField_b_of_type_Int, parambcok.jdField_a_of_type_ComTencentWidgetHorizontalListView);
      parambcok.jdField_a_of_type_ComTencentWidgetHorizontalListView.setAdapter(localbcbo1);
    }
    if (localbcbo1.a() != parambcgf.jdField_a_of_type_JavaUtilArrayList)
    {
      parambcok.jdField_a_of_type_Bcgf = parambcgf;
      parambcok.jdField_a_of_type_ComTencentWidgetHorizontalListView.resetCurrentX(parambcgf.jdField_b_of_type_Int);
    }
    localbcbo1.a(parambcgf.jdField_a_of_type_JavaUtilArrayList);
  }
  
  protected void a(bcgh parambcgh, bcom parambcom)
  {
    parambcom.a().getContext();
    parambcom.a();
    if ((parambcgh.jdField_a_of_type_JavaUtilArrayList == null) || (parambcgh.jdField_a_of_type_JavaUtilArrayList.size() == 0)) {
      if (QLog.isColorLevel()) {
        QLog.e("Q.uniteSearch.SearchTemplatePresenter", 2, "bindHorizontalContainerTemplateView, containerItem.horizontalModelItems is empty");
      }
    }
    for (;;)
    {
      return;
      parambcom.a(parambcgh);
      if (parambcgh.jdField_a_of_type_JavaUtilArrayList.size() != parambcom.jdField_a_of_type_JavaUtilArrayList.size()) {
        QLog.e("Q.uniteSearch.SearchTemplatePresenter", 2, "bindHorizontalContainerTemplateView, view.size != model.size");
      }
      int j = parambcgh.jdField_a_of_type_JavaUtilArrayList.size();
      int i = 0;
      while (i < j)
      {
        ((bcgg)parambcgh.jdField_a_of_type_JavaUtilArrayList.get(i)).a((bcol)parambcom.jdField_a_of_type_JavaUtilArrayList.get(i));
        i += 1;
      }
    }
  }
  
  protected void a(bcgj parambcgj, bcoo parambcoo)
  {
    Object localObject2 = (LinearLayout)parambcoo.b();
    Object localObject1;
    Object localObject3;
    bcoc localbcoc;
    if ((localObject2 != null) && (parambcgj.a != null))
    {
      ((LinearLayout)localObject2).removeAllViews();
      if (((LinearLayout)localObject2).getParent() != null) {
        ((View)((LinearLayout)localObject2).getParent()).setPadding(0, 0, 0, 0);
      }
      localObject1 = parambcgj.a;
      parambcgj = parambcoo.a().getContext();
      localObject3 = LayoutInflater.from(parambcgj).inflate(2131562883, null);
      localbcoc = new bcoc((View)localObject3);
      Object localObject4 = ((View)localObject3).findViewById(2131368866);
      int i = bhtq.a(6.0F);
      ((View)localObject4).setPadding(0, i, 0, i);
      ((LinearLayout)localObject2).addView((View)localObject3);
      if (((bcfw)localObject1).c() != null) {
        break label559;
      }
      if (localbcoc.c() != null) {
        localbcoc.c().setVisibility(8);
      }
      if (localbcoc.a() != null) {
        localbcoc.a().setVisibility(8);
      }
      localObject2 = localbcoc.a();
      if (localObject2 != null) {
        ((URLImageView)localObject2).setVisibility(8);
      }
      localObject2 = localbcoc.e();
      if (localObject2 != null)
      {
        ((TextView)localObject2).setVisibility(0);
        if (!TextUtils.isEmpty(((bcfw)localObject1).a())) {
          ((TextView)localObject2).setText(((bcfw)localObject1).a());
        }
      }
      if ((localbcoc.b() != null) && (!TextUtils.isEmpty(((bcfw)localObject1).g())))
      {
        localObject2 = ((bcfw)localObject1).g();
        localObject3 = new ColorDrawable(Color.parseColor("#e7e7e7"));
        localObject4 = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject4).mRequestWidth = bhgr.a(parambcgj, 50.0F);
        ((URLDrawable.URLDrawableOptions)localObject4).mRequestHeight = bhgr.a(parambcgj, 50.0F);
        ((URLDrawable.URLDrawableOptions)localObject4).mFailedDrawable = ((Drawable)localObject3);
        ((URLDrawable.URLDrawableOptions)localObject4).mLoadingDrawable = ((Drawable)localObject3);
        if (!blhn.a((String)localObject2)) {
          break label684;
        }
        localObject2 = URLDrawable.getDrawable((String)localObject2, (URLDrawable.URLDrawableOptions)localObject4);
        ((URLDrawable)localObject2).setTag(bhez.b(bhgr.a(parambcgj, 50.0F), bhgr.a(parambcoo.a().getContext(), 50.0F), bhgr.a(parambcgj, 3.0F)));
        ((URLDrawable)localObject2).setDecodeHandler(bhez.j);
        localbcoc.b().setImageDrawable((Drawable)localObject2);
        if ((((URLDrawable)localObject2).getStatus() != 1) && (((URLDrawable)localObject2).getStatus() != 0)) {
          ((URLDrawable)localObject2).restartDownload();
        }
      }
    }
    for (;;)
    {
      localbcoc.a().setOnClickListener(new bcjm(this, (bcfw)localObject1));
      if ((localbcoc.a() != null) && (((bcfw)localObject1).c()))
      {
        parambcoo = ((bcfw)localObject1).h();
        localObject1 = new ColorDrawable(Color.parseColor("#e7e7e7"));
        localObject2 = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject2).mRequestWidth = bhgr.a(parambcgj, 40.0F);
        ((URLDrawable.URLDrawableOptions)localObject2).mRequestHeight = bhgr.a(parambcgj, 12.0F);
        ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = ((Drawable)localObject1);
        ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = ((Drawable)localObject1);
        parambcoo = URLDrawable.getDrawable(parambcoo, (URLDrawable.URLDrawableOptions)localObject2);
        parambcoo.setTag(bhez.b(bhgr.a(parambcgj, 38.0F), bhgr.a(parambcgj, 12.0F), 0));
        parambcoo.setDecodeHandler(bhez.j);
        localbcoc.a().setImageDrawable(parambcoo);
        if ((parambcoo.getStatus() != 1) && (parambcoo.getStatus() != 0)) {
          parambcoo.restartDownload();
        }
      }
      return;
      label559:
      if ((localbcoc.c() != null) && (!TextUtils.isEmpty(((bcfw)localObject1).c())))
      {
        localbcoc.c().setVisibility(0);
        localbcoc.c().setText(((bcfw)localObject1).c());
      }
      for (;;)
      {
        if (localbcoc.a() != null) {
          localbcoc.a().setVisibility(0);
        }
        localObject2 = localbcoc.e();
        if (localObject2 != null) {
          ((TextView)localObject2).setVisibility(8);
        }
        if (TextUtils.isEmpty(((bcfw)localObject1).a())) {
          break;
        }
        localbcoc.a().setText(((bcfw)localObject1).a());
        break;
        if (localbcoc.c() != null) {
          localbcoc.c().setVisibility(8);
        }
      }
      label684:
      localbcoc.b().setImageDrawable((Drawable)localObject3);
    }
  }
  
  protected void a(bcgm parambcgm, bcou parambcou)
  {
    Object localObject1 = parambcou.a().getContext();
    if (ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null))
    {
      parambcou.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#737373"));
      parambcou.jdField_b_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#4A4A4A"));
      if (TextUtils.isEmpty(parambcgm.jdField_b_of_type_JavaLangString)) {
        break label290;
      }
      Object localObject2 = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
      ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
      ((URLDrawable.URLDrawableOptions)localObject2).mRequestWidth = bhgr.a((Context)localObject1, 18.0F);
      ((URLDrawable.URLDrawableOptions)localObject2).mRequestHeight = bhgr.a((Context)localObject1, 18.0F);
      ((URLDrawable.URLDrawableOptions)localObject2).mMemoryCacheKeySuffix = "askIcon";
      localObject2 = URLDrawable.getDrawable(parambcgm.jdField_b_of_type_JavaLangString, (URLDrawable.URLDrawableOptions)localObject2);
      parambcou.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable((Drawable)localObject2);
      if ((((URLDrawable)localObject2).getStatus() != 1) && (((URLDrawable)localObject2).getStatus() != 0)) {
        ((URLDrawable)localObject2).restartDownload();
      }
      parambcou.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(0);
    }
    label290:
    for (;;)
    {
      label166:
      if (!TextUtils.isEmpty(parambcgm.j))
      {
        int j = parambcou.jdField_a_of_type_AndroidWidgetTextView.getContext().getResources().getDisplayMetrics().widthPixels;
        int i = (int)bcni.a(parambcou.jdField_a_of_type_AndroidWidgetTextView, " ");
        int k = bhgr.a((Context)localObject1, 22.0F) / i;
        localObject1 = "";
        i = 0;
        for (;;)
        {
          if (i < k)
          {
            localObject1 = (String)localObject1 + " ";
            i += 1;
            continue;
            parambcou.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#262626"));
            parambcou.jdField_b_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#737373"));
            break;
            parambcou.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(8);
            break label166;
          }
        }
        localObject1 = bcni.a(parambcou.jdField_a_of_type_AndroidWidgetTextView, j, 2, (String)localObject1 + parambcgm.j, parambcgm.jdField_a_of_type_Bcmx.jdField_a_of_type_JavaUtilList, false, false, true);
        parambcou.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject1);
      }
    }
    parambcou.a(parambcgm);
    if ((!TextUtils.isEmpty(parambcgm.k)) && (parambcgm.jdField_a_of_type_JavaUtilList != null) && (parambcgm.jdField_a_of_type_JavaUtilList.size() != 0))
    {
      parambcou.jdField_b_of_type_AndroidWidgetTextView.setText(parambcgm.k);
      parambcou.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      return;
    }
    parambcou.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
  }
  
  protected void a(bcgp parambcgp, bcoy parambcoy)
  {
    if (!TextUtils.isEmpty(parambcgp.jdField_b_of_type_JavaLangString))
    {
      parambcoy.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(0);
      Object localObject = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
      ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
      ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = parambcoy.jdField_a_of_type_ComTencentImageURLImageView.getLayoutParams().width;
      ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = parambcoy.jdField_a_of_type_ComTencentImageURLImageView.getLayoutParams().height;
      localObject = URLDrawable.getDrawable(parambcgp.jdField_b_of_type_JavaLangString, (URLDrawable.URLDrawableOptions)localObject);
      parambcoy.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable((Drawable)localObject);
      if ((((URLDrawable)localObject).getStatus() != 1) && (((URLDrawable)localObject).getStatus() != 0)) {
        ((URLDrawable)localObject).restartDownload();
      }
      if (TextUtils.isEmpty(parambcgp.j)) {
        break label345;
      }
      parambcoy.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      int i = parambcoy.jdField_a_of_type_AndroidWidgetTextView.getContext().getResources().getDisplayMetrics().widthPixels;
      localObject = bcni.a(parambcoy.jdField_a_of_type_AndroidWidgetTextView, i, 1, parambcgp.j, parambcgp.jdField_a_of_type_Bcmx.jdField_a_of_type_JavaUtilList, false, false, true);
      parambcoy.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
      label183:
      if (TextUtils.isEmpty(parambcgp.l)) {
        break label357;
      }
      parambcoy.jdField_b_of_type_AndroidWidgetTextView.setText(parambcgp.l);
      parambcoy.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      parambcoy.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      label220:
      if (TextUtils.isEmpty(parambcgp.k)) {
        break label378;
      }
      parambcoy.c.setText(parambcgp.k);
      parambcoy.c.setVisibility(0);
    }
    for (;;)
    {
      if (!ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null)) {
        break label390;
      }
      parambcoy.jdField_a_of_type_AndroidWidgetTextView.setTextColor(parambcoy.jdField_a_of_type_AndroidWidgetTextView.getContext().getResources().getColor(2131166926));
      parambcoy.c.setTextColor(parambcoy.c.getContext().getResources().getColor(2131166925));
      parambcoy.jdField_b_of_type_AndroidWidgetTextView.setTextColor(parambcoy.jdField_b_of_type_AndroidWidgetTextView.getContext().getResources().getColor(2131166925));
      return;
      parambcoy.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(8);
      break;
      label345:
      parambcoy.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      break label183;
      label357:
      parambcoy.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      parambcoy.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      break label220;
      label378:
      parambcoy.c.setVisibility(8);
    }
    label390:
    parambcoy.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#262626"));
    parambcoy.c.setTextColor(Color.parseColor("#737373"));
    parambcoy.jdField_b_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#737373"));
  }
  
  public void a(SquareImageView paramSquareImageView, ImageView paramImageView, TextView paramTextView, int paramInt1, int paramInt2, boolean paramBoolean1, String paramString1, String paramString2, int paramInt3, boolean paramBoolean2)
  {
    ViewGroup.LayoutParams localLayoutParams = paramSquareImageView.getLayoutParams();
    if ((paramSquareImageView.getContext() instanceof PublicAcntSearchActivity))
    {
      localLayoutParams.width = bhgr.a(paramSquareImageView.getContext(), 50.0F);
      localLayoutParams.height = bhgr.a(paramSquareImageView.getContext(), 50.0F);
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
          paramTextView.setDecodeHandler(bhez.a);
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
  
  protected void b(bcga parambcga, bcog parambcog)
  {
    if (parambcog.a() != null) {
      parambcog.a().setOnClickListener(new bcjl(this, parambcga));
    }
  }
  
  public void c(bcga parambcga, bcog parambcog)
  {
    if ((parambcog.b() != null) && ((parambcga instanceof bcfo)) && (!TextUtils.isEmpty(parambcga.b()))) {
      parambcog.b().setImageDrawable(bcni.a(this.jdField_a_of_type_Aoof, parambcga));
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
      bcni.jdField_a_of_type_Long = this.jdField_a_of_type_Long;
      localImageView.post(new SearchTemplatePresenter.11(this, localImageView, bool));
      localImageView.setContentDescription(localResources.getString(2131690168));
      this.jdField_a_of_type_Bcbl.notifyDataSetChanged();
      return;
    }
    localImageView.post(new SearchTemplatePresenter.12(this, localImageView, bool));
    localImageView.setContentDescription(localResources.getString(2131690166));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcjk
 * JD-Core Version:    0.7.0.1
 */