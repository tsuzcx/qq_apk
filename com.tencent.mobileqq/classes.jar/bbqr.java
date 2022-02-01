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

public class bbqr
  implements awyi, bbpr<bbnh, bbvn>
{
  public static int a;
  private long jdField_a_of_type_Long;
  public ColorDrawable a;
  public Drawable a;
  private aobu jdField_a_of_type_Aobu;
  private bbir jdField_a_of_type_Bbir;
  private WeakReference<ImageView> jdField_a_of_type_JavaLangRefWeakReference;
  
  public bbqr(aobu paramaobu, bbir parambbir)
  {
    this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable = new ColorDrawable(Color.parseColor("#e7e7e7"));
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = bdzx.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
    this.jdField_a_of_type_Aobu = paramaobu;
    this.jdField_a_of_type_Bbir = parambbir;
  }
  
  private float a(String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      return 7.0F;
    }
    return 3.5F;
  }
  
  private int a(bbnx parambbnx, bbwg parambbwg)
  {
    if ((parambbnx == null) || (parambbnx.jdField_a_of_type_Bbny == null) || (parambbwg == null) || (parambbwg.jdField_a_of_type_AndroidWidgetRelativeLayout == null))
    {
      if ((parambbwg != null) && (parambbwg.jdField_a_of_type_AndroidWidgetButton != null)) {
        parambbwg.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
      }
      if ((parambbwg != null) && (parambbwg.jdField_a_of_type_AndroidWidgetImageView != null)) {
        parambbwg.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      }
      return 0;
    }
    if (parambbnx.jdField_a_of_type_Bbny.jdField_a_of_type_Int == 1)
    {
      if (parambbwg.jdField_a_of_type_AndroidWidgetButton != null) {
        parambbwg.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
      }
      if (parambbwg.jdField_a_of_type_AndroidWidgetImageView != null) {
        parambbwg.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      }
      return 0;
    }
    boolean bool = ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null);
    Context localContext = parambbwg.jdField_a_of_type_AndroidWidgetRelativeLayout.getContext();
    int i;
    if (parambbnx.jdField_a_of_type_Bbny.jdField_a_of_type_Int == 2)
    {
      if (parambbwg.jdField_a_of_type_AndroidWidgetImageView != null) {
        parambbwg.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      }
      if (parambbwg.jdField_a_of_type_AndroidWidgetButton == null) {
        return 0;
      }
      if (!TextUtils.isEmpty(parambbnx.jdField_a_of_type_Bbny.jdField_a_of_type_JavaLangCharSequence))
      {
        parambbwg.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
        parambbwg.jdField_a_of_type_AndroidWidgetButton.setText(parambbnx.jdField_a_of_type_Bbny.jdField_a_of_type_JavaLangCharSequence);
        parambbwg.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(new bbqy(this, localContext, parambbnx));
      }
      for (;;)
      {
        i = (int)(0 + (bbup.a(parambbwg.jdField_a_of_type_AndroidWidgetButton, parambbnx.jdField_a_of_type_Bbny.jdField_a_of_type_JavaLangCharSequence) + bggq.a(localContext, 32.0F) + bggq.a(localContext, 15.0F)));
        if (!bool) {
          break;
        }
        parambbwg.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130843241);
        parambbwg.jdField_a_of_type_AndroidWidgetButton.setTextColor(Color.parseColor("#6991B8"));
        return i;
        parambbwg.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
      }
      parambbwg.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130843240);
      parambbwg.jdField_a_of_type_AndroidWidgetButton.setTextColor(Color.parseColor("#000000"));
      return i;
    }
    int j;
    if (parambbnx.jdField_a_of_type_Bbny.jdField_a_of_type_Int == 3)
    {
      if (parambbwg.jdField_a_of_type_AndroidWidgetButton != null) {
        parambbwg.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
      }
      if ((parambbwg.jdField_a_of_type_AndroidWidgetRelativeLayout == null) || (parambbwg.jdField_a_of_type_AndroidWidgetImageView == null)) {
        return 0;
      }
      int k = ((Integer)parambbwg.a().getTag(2131380930)).intValue();
      SongInfo localSongInfo1 = new SongInfo();
      i = 0;
      j = i;
      for (;;)
      {
        try
        {
          JSONObject localJSONObject = new JSONObject(parambbnx.h);
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
          bbup.jdField_a_of_type_Long = localSongInfo2.jdField_a_of_type_Long;
          continue;
          parambbwg.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130849626);
          continue;
          if (this.jdField_a_of_type_Long != bbup.jdField_a_of_type_Long) {
            continue;
          }
          parambbwg.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130849627);
          continue;
          parambbwg.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130849625);
          continue;
          parambbwg.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
          continue;
        }
        this.jdField_a_of_type_Long = localSongInfo1.jdField_a_of_type_Long;
        QQPlayerService.a(this);
        if (QQPlayerService.a() == 2) {
          continue;
        }
        bbup.jdField_a_of_type_Long = -1L;
        if (!bool) {
          continue;
        }
        if (this.jdField_a_of_type_Long != bbup.jdField_a_of_type_Long) {
          continue;
        }
        parambbwg.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130849628);
        if ((j == 0) || (i == 0) || (TextUtils.isEmpty(localSongInfo1.jdField_b_of_type_JavaLangString))) {
          continue;
        }
        parambbwg.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        parambbwg.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(new bbqz(this, parambbwg, k, localContext, bool, localSongInfo1, parambbnx));
        return bggq.a(localContext, 39.0F) + 0;
        i = 0;
        continue;
        j = 0;
      }
    }
    parambbwg.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
    return 0;
  }
  
  private int a(bbnx parambbnx, bbwg parambbwg, int paramInt1, int paramInt2)
  {
    if ((parambbwg == null) || (parambbnx == null) || (parambbwg.jdField_a_of_type_AndroidWidgetLinearLayout == null)) {
      return 0;
    }
    Context localContext = parambbwg.jdField_a_of_type_AndroidWidgetLinearLayout.getContext();
    int i = localContext.getResources().getDisplayMetrics().widthPixels - paramInt1 - paramInt2 - bggq.a(localContext, 30.0F);
    if ((parambbnx.jdField_a_of_type_JavaUtilArrayList != null) && (parambbnx.jdField_a_of_type_JavaUtilArrayList.size() > 0))
    {
      parambbwg.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      if ((parambbnx.jdField_a_of_type_Bbnz != null) && (parambbnx.jdField_a_of_type_JavaUtilArrayList != null) && (parambbnx.jdField_a_of_type_JavaUtilArrayList.size() > 0))
      {
        parambbwg.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(0);
        if (parambbwg.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView != null) {
          parambbwg.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView.setVisibility(8);
        }
        if (parambbnx.jdField_a_of_type_Bbnz.jdField_a_of_type_Int == 1)
        {
          if (parambbwg.jdField_b_of_type_AndroidWidgetTextView != null) {
            parambbwg.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
          }
          if ((parambbwg.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView == null) || (TextUtils.isEmpty(parambbnx.jdField_a_of_type_Bbnz.jdField_a_of_type_JavaLangString))) {
            break label1007;
          }
          parambbwg.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView.setVisibility(0);
          a(parambbwg.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView, parambbnx.jdField_a_of_type_Bbnz.jdField_a_of_type_JavaLangString);
          paramInt1 = i - bggq.a(localContext, 24.0F);
        }
      }
    }
    for (;;)
    {
      Object localObject1;
      if ((parambbwg.jdField_a_of_type_AndroidWidgetTextView != null) && (!TextUtils.isEmpty(((bboa)parambbnx.jdField_a_of_type_JavaUtilArrayList.get(0)).jdField_a_of_type_JavaLangCharSequence)))
      {
        localObject1 = ((bboa)parambbnx.jdField_a_of_type_JavaUtilArrayList.get(0)).jdField_a_of_type_JavaLangCharSequence;
        if (!((bboa)parambbnx.jdField_a_of_type_JavaUtilArrayList.get(0)).jdField_a_of_type_Boolean) {
          break label635;
        }
        localObject1 = bbup.a(parambbwg.jdField_a_of_type_AndroidWidgetTextView, paramInt1, 1, ((CharSequence)localObject1).toString(), parambbnx.jdField_a_of_type_Bbue.jdField_a_of_type_JavaUtilList, false, false, true);
        label297:
        parambbwg.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject1);
      }
      for (paramInt1 = 1;; paramInt1 = 0)
      {
        if (parambbwg.c != null) {
          break label677;
        }
        return parambbwg.jdField_a_of_type_AndroidWidgetLinearLayout.getHeight();
        if (parambbnx.jdField_a_of_type_Bbnz.jdField_a_of_type_Int == 2)
        {
          if (parambbwg.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView != null) {
            parambbwg.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView.setVisibility(8);
          }
          if ((parambbwg.jdField_b_of_type_AndroidWidgetTextView == null) || (TextUtils.isEmpty(parambbnx.jdField_a_of_type_Bbnz.jdField_a_of_type_JavaLangCharSequence))) {
            break label1007;
          }
          if (bbup.e(parambbnx.jdField_a_of_type_Bbnz.jdField_b_of_type_JavaLangString)) {}
          for (localObject1 = parambbnx.jdField_a_of_type_Bbnz.jdField_b_of_type_JavaLangString;; localObject1 = "#fd7f32")
          {
            ((GradientDrawable)parambbwg.jdField_b_of_type_AndroidWidgetTextView.getBackground()).setColor(Color.parseColor((String)localObject1));
            parambbwg.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
            parambbwg.jdField_b_of_type_AndroidWidgetTextView.setText(parambbnx.jdField_a_of_type_Bbnz.jdField_a_of_type_JavaLangCharSequence);
            paramInt1 = (int)(i - (bbup.a(parambbwg.jdField_b_of_type_AndroidWidgetTextView, parambbnx.jdField_a_of_type_Bbnz.jdField_a_of_type_JavaLangCharSequence) + bggq.a(localContext, 10.0F)));
            break;
          }
        }
        if (parambbnx.jdField_a_of_type_Bbnz.jdField_a_of_type_Int != 3) {
          break label1007;
        }
        if (parambbwg.jdField_b_of_type_AndroidWidgetTextView != null) {
          parambbwg.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
        }
        if ((parambbwg.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView == null) || (TextUtils.isEmpty(parambbnx.jdField_a_of_type_Bbnz.jdField_a_of_type_JavaLangString))) {
          break label1007;
        }
        parambbwg.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView.setVisibility(0);
        if ((parambbnx.jdField_a_of_type_Bbnz.jdField_b_of_type_Int > 0) && (parambbnx.jdField_a_of_type_Bbnz.jdField_c_of_type_Int > 0))
        {
          a(parambbwg.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView, parambbnx.jdField_a_of_type_Bbnz.jdField_b_of_type_Int, parambbnx.jdField_a_of_type_Bbnz.jdField_c_of_type_Int, parambbnx.jdField_a_of_type_Bbnz.jdField_a_of_type_JavaLangString);
          paramInt1 = i - bggq.a(localContext, bggq.a(localContext, parambbnx.jdField_a_of_type_Bbnz.jdField_b_of_type_Int) + 4);
          break;
        }
        a(parambbwg.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView, parambbnx.jdField_a_of_type_Bbnz.jdField_a_of_type_JavaLangString);
        paramInt1 = i - bggq.a(localContext, 24.0F);
        break;
        label635:
        localObject1 = bbup.a(parambbwg.jdField_a_of_type_AndroidWidgetTextView, paramInt1, ((CharSequence)localObject1).toString());
        break label297;
        if (parambbwg.jdField_b_of_type_AndroidWidgetLinearLayout != null) {
          parambbwg.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
        }
      }
      label677:
      parambbwg.c.removeAllViews();
      bboa localbboa;
      TextView localTextView;
      if ((parambbnx.jdField_a_of_type_JavaUtilArrayList != null) && (parambbnx.jdField_a_of_type_JavaUtilArrayList.size() > 0)) {
        while (paramInt1 < parambbnx.jdField_a_of_type_JavaUtilArrayList.size())
        {
          localbboa = (bboa)parambbnx.jdField_a_of_type_JavaUtilArrayList.get(paramInt1);
          localTextView = new TextView(localContext);
          a(localTextView, localbboa.jdField_a_of_type_JavaLangString, localbboa.jdField_a_of_type_Int);
          localObject1 = localbboa.jdField_a_of_type_JavaLangCharSequence;
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
        paramInt2 = localbboa.jdField_a_of_type_Int;
        if ((localContext instanceof PublicAcntSearchActivity)) {
          paramInt2 = 1;
        }
        Object localObject2 = localObject1;
        if (localbboa.jdField_a_of_type_Boolean) {
          if ((!localbboa.jdField_a_of_type_JavaLangString.equals("A")) && (!localbboa.jdField_a_of_type_JavaLangString.equals("B"))) {
            break label952;
          }
        }
        for (boolean bool = true;; bool = false)
        {
          localObject2 = bbup.a(localTextView, i, paramInt2, ((CharSequence)localObject1).toString(), parambbnx.jdField_a_of_type_Bbue.jdField_a_of_type_JavaUtilList, false, bool, true);
          if (paramInt1 != 0) {
            localTextView.setPadding(0, bggq.a(localContext, 7.0F - a(((bboa)parambbnx.jdField_a_of_type_JavaUtilArrayList.get(paramInt1 - 1)).jdField_a_of_type_JavaLangString, localbboa.jdField_a_of_type_JavaLangString)), 0, 0);
          }
          localTextView.setText((CharSequence)localObject2);
          parambbwg.c.addView(localTextView);
          break;
        }
        parambbwg.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
        b(parambbnx, parambbwg);
        paramInt1 = View.MeasureSpec.makeMeasureSpec(0, 0);
        paramInt2 = View.MeasureSpec.makeMeasureSpec(0, 0);
        parambbwg.jdField_a_of_type_AndroidWidgetLinearLayout.measure(paramInt1, paramInt2);
        return parambbwg.jdField_a_of_type_AndroidWidgetLinearLayout.getMeasuredHeight();
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
      if (!bbup.e(paramString)) {
        localObject = "#F1F1F1";
      }
    }
  }
  
  public static Pair<Integer, Integer> a(bbnh parambbnh, bbvn parambbvn, boolean paramBoolean, int paramInt)
  {
    if ((parambbvn == null) || (parambbvn.jdField_b_of_type_AndroidWidgetRelativeLayout == null) || (parambbvn.jdField_b_of_type_ComTencentMobileqqWidgetSquareImageView == null) || (parambbnh == null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.uniteSearch.SearchTemplatePresenter", 2, "bindUniversalTemplateLeftImageview or item is null");
      }
      return new Pair(Integer.valueOf(0), Integer.valueOf(0));
    }
    SquareImageView localSquareImageView = parambbvn.jdField_b_of_type_ComTencentMobileqqWidgetSquareImageView;
    bbni localbbni = parambbnh.jdField_a_of_type_Bbni;
    if ((localbbni == null) || (TextUtils.isEmpty(localbbni.jdField_a_of_type_JavaLangString)))
    {
      parambbvn.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      return new Pair(Integer.valueOf(0), Integer.valueOf(0));
    }
    parambbvn.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
    Object localObject = localSquareImageView.getContext();
    parambbnh = a(localSquareImageView, localbbni.jdField_a_of_type_Int, localbbni.jdField_a_of_type_JavaLangString, localbbni.jdField_b_of_type_Int, paramBoolean, paramInt, parambbnh);
    paramInt = ((Integer)parambbnh.first).intValue();
    int i = ((Integer)parambbnh.second).intValue();
    parambbnh = localSquareImageView.getLayoutParams();
    parambbnh.width = paramInt;
    parambbnh.height = i;
    localSquareImageView.setLayoutParams(parambbnh);
    parambbnh = (RelativeLayout.LayoutParams)parambbvn.jdField_b_of_type_AndroidWidgetRelativeLayout.getLayoutParams();
    parambbnh.width = paramInt;
    parambbnh.height = i;
    parambbvn.jdField_b_of_type_AndroidWidgetRelativeLayout.setLayoutParams(parambbnh);
    int j = bggq.a((Context)localObject, 10.0F);
    if ((!TextUtils.isEmpty(localbbni.jdField_a_of_type_JavaLangCharSequence)) && (parambbvn.e != null)) {
      if (bbup.e(localbbni.jdField_b_of_type_JavaLangString))
      {
        parambbnh = localbbni.jdField_b_of_type_JavaLangString;
        ((GradientDrawable)parambbvn.e.getBackground()).setColor(Color.parseColor(parambbnh));
        parambbvn.e.setVisibility(0);
        parambbvn.e.setText(localbbni.jdField_a_of_type_JavaLangCharSequence);
        label303:
        if (parambbvn.jdField_c_of_type_AndroidWidgetImageView != null)
        {
          if (!localbbni.jdField_a_of_type_Boolean) {
            break label565;
          }
          parambbvn.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
        }
        label326:
        if (parambbvn.f != null)
        {
          if (TextUtils.isEmpty(localbbni.jdField_b_of_type_JavaLangCharSequence)) {
            break label577;
          }
          parambbvn.f.setVisibility(0);
          parambbvn.f.setText(localbbni.jdField_b_of_type_JavaLangCharSequence);
        }
        label364:
        if (parambbvn.jdField_c_of_type_ComTencentMobileqqWidgetSquareImageView != null)
        {
          if (TextUtils.isEmpty(localbbni.jdField_c_of_type_JavaLangString)) {
            break label589;
          }
          parambbvn.jdField_c_of_type_ComTencentMobileqqWidgetSquareImageView.setVisibility(0);
          parambbnh = URLDrawable.URLDrawableOptions.obtain();
          localObject = new ColorDrawable(-1);
          parambbnh.mFailedDrawable = ((Drawable)localObject);
          parambbnh.mLoadingDrawable = ((Drawable)localObject);
          parambbnh.mRequestWidth = parambbvn.jdField_c_of_type_ComTencentMobileqqWidgetSquareImageView.getLayoutParams().width;
          parambbnh.mRequestHeight = parambbvn.jdField_c_of_type_ComTencentMobileqqWidgetSquareImageView.getLayoutParams().height;
          parambbnh = URLDrawable.getDrawable(localbbni.jdField_c_of_type_JavaLangString, parambbnh);
          if ((parambbnh.getStatus() != 1) && (parambbnh.getStatus() != 0)) {
            parambbnh.restartDownload();
          }
          parambbvn.jdField_c_of_type_ComTencentMobileqqWidgetSquareImageView.setImageDrawable(parambbnh);
        }
        label481:
        if (parambbvn.g != null)
        {
          if (TextUtils.isEmpty(localbbni.jdField_c_of_type_JavaLangCharSequence)) {
            break label601;
          }
          parambbvn.g.setVisibility(0);
          parambbvn.g.setText(localbbni.jdField_c_of_type_JavaLangCharSequence);
        }
      }
    }
    for (;;)
    {
      return new Pair(Integer.valueOf(paramInt + j), Integer.valueOf(i));
      parambbnh = "#fd7f32";
      break;
      if (parambbvn.e == null) {
        break label303;
      }
      parambbvn.e.setVisibility(8);
      break label303;
      label565:
      parambbvn.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
      break label326;
      label577:
      parambbvn.f.setVisibility(8);
      break label364;
      label589:
      parambbvn.jdField_c_of_type_ComTencentMobileqqWidgetSquareImageView.setVisibility(8);
      break label481;
      label601:
      parambbvn.g.setVisibility(8);
    }
  }
  
  public static Pair<Integer, Integer> a(SquareImageView paramSquareImageView, int paramInt1, String paramString, int paramInt2, boolean paramBoolean, int paramInt3, bbnh parambbnh)
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
      paramInt1 = bggq.a((Context)localObject, 60.0F);
      i = bggq.a((Context)localObject, 60.0F);
      j = 0;
      localColorDrawable = new ColorDrawable(Color.parseColor("#e7e7e7"));
      if (paramBoolean)
      {
        paramInt1 = (int)(i * 1.0F / paramInt1 * paramInt3);
        if (j != 0)
        {
          i = (int)(paramInt3 * 0.2D / 2.0D);
          paramSquareImageView.setPadding(bggq.a((Context)localObject, 3.0F), bggq.a((Context)localObject, 3.0F), bggq.a((Context)localObject, 3.0F), bggq.a((Context)localObject, 3.0F));
          parambbnh = (RelativeLayout.LayoutParams)paramSquareImageView.getLayoutParams();
          i -= bggq.a((Context)localObject, 3.0F);
          parambbnh.rightMargin = i;
          parambbnh.leftMargin = i;
          parambbnh.topMargin = i;
          paramSquareImageView.setLayoutParams(parambbnh);
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
          parambbnh = URLDrawable.URLDrawableOptions.obtain();
          parambbnh.mRequestWidth = paramInt3;
          parambbnh.mRequestHeight = paramInt1;
          if (j == 0) {
            continue;
          }
          localObject = new GradientDrawable();
          ((GradientDrawable)localObject).setShape(0);
          ((GradientDrawable)localObject).setCornerRadius(paramInt3 / 2.0F);
          ((GradientDrawable)localObject).setColor(-1579033);
          parambbnh.mLoadingDrawable = ((Drawable)localObject);
          parambbnh.mFailedDrawable = ((Drawable)localObject);
          parambbnh.mPlayGifImage = true;
          if (j == 0) {
            continue;
          }
          parambbnh.mMemoryCacheKeySuffix = ("isAvatar" + paramInt3 + paramInt1);
          parambbnh = URLDrawable.getDrawable(paramString, parambbnh);
          parambbnh.setDecodeHandler(bgey.a);
        }
        catch (Exception parambbnh)
        {
          QLog.e("Q.uniteSearch.SearchTemplatePresenter", 1, "imageUrl is not valid. imageUrl=" + paramString, parambbnh);
          localObject = localColorDrawable;
          continue;
          parambbnh.mMemoryCacheKeySuffix = ("isNotAvatar" + paramInt3 + paramInt1 + paramInt2);
          parambbnh = URLDrawable.getDrawable(paramString, parambbnh);
          parambbnh.setTag(bgey.b(paramInt3, paramInt1, paramInt2));
          parambbnh.setDecodeHandler(bgey.j);
          continue;
        }
        localObject = parambbnh;
        if (parambbnh.getStatus() != 1)
        {
          localObject = parambbnh;
          if (parambbnh.getStatus() != 0)
          {
            parambbnh.restartDownload();
            localObject = parambbnh;
          }
        }
        paramSquareImageView.setImageDrawable((Drawable)localObject);
        return new Pair(Integer.valueOf(paramInt3), Integer.valueOf(paramInt1));
        paramInt1 = bggq.a((Context)localObject, 60.0F);
        i = bggq.a((Context)localObject, 60.0F);
        j = 0;
        break;
        paramInt1 = bggq.a((Context)localObject, 50.0F);
        i = bggq.a((Context)localObject, 50.0F);
        j = 0;
        break;
        if ((paramSquareImageView.getContext() instanceof PublicAcntSearchActivity))
        {
          paramInt1 = bggq.a(paramSquareImageView.getContext(), 50.0F);
          i = bggq.a(paramSquareImageView.getContext(), 50.0F);
          j = 1;
          break;
        }
        paramInt1 = bggq.a((Context)localObject, 60.0F);
        i = bggq.a((Context)localObject, 60.0F);
        continue;
        paramInt1 = bggq.a((Context)localObject, 50.0F);
        i = bggq.a((Context)localObject, 50.0F);
        j = 1;
        break;
        paramInt1 = bggq.a((Context)localObject, 60.0F);
        i = bggq.a((Context)localObject, 85.0F);
        j = 0;
        break;
        paramInt1 = bggq.a((Context)localObject, 113.0F);
        i = bggq.a((Context)localObject, 60.0F);
        j = 0;
        break;
        paramInt1 = bggq.a((Context)localObject, 100.0F);
        i = bggq.a((Context)localObject, 141.0F);
        j = 0;
        break;
        paramInt1 = j;
        if ((parambbnh instanceof bbnx))
        {
          paramInt1 = bggq.a((Context)localObject, parambbnh.jdField_a_of_type_Bbni.jdField_c_of_type_Int / 2);
          i = bggq.a((Context)localObject, parambbnh.jdField_a_of_type_Bbni.d / 2);
        }
        if ((paramInt2 == parambbnh.jdField_a_of_type_Bbni.jdField_c_of_type_Int / 2) && (paramInt2 == parambbnh.jdField_a_of_type_Bbni.d / 2))
        {
          j = 1;
          break;
        }
        j = 0;
        break;
        paramInt1 = bggq.a((Context)localObject, 220.0F);
        i = bggq.a((Context)localObject, 136.0F);
        j = 0;
        break;
        paramInt1 = bggq.a((Context)localObject, 162.0F);
        i = bggq.a((Context)localObject, 162.0F);
        j = 0;
        break;
        paramInt1 = bggq.a((Context)localObject, 162.0F);
        i = bggq.a((Context)localObject, 228.0F);
        j = 0;
        break;
        paramInt1 = bggq.a((Context)localObject, 162.0F);
        i = bggq.a((Context)localObject, 162.0F);
        j = 1;
        break;
        parambbnh.mFailedDrawable = localColorDrawable;
        parambbnh.mLoadingDrawable = localColorDrawable;
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
        paramTextView.setTextColor(localContext.getResources().getColor(2131166987));
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
        paramTextView.setTextColor(localContext.getResources().getColor(2131166987));
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
        paramTextView.setTextColor(localContext.getResources().getColor(2131166988));
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
        paramTextView.setTextColor(localContext.getResources().getColor(2131166988));
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
        paramTextView.setTextColor(localContext.getResources().getColor(2131166988));
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
      paramTextView.setTextColor(localContext.getResources().getColor(2131167127));
      return;
    }
    paramTextView.setTextSize(1, 17.0F);
    paramTextView.setTextColor(localContext.getResources().getColor(2131166993));
    paramTextView.setIncludeFontPadding(false);
  }
  
  private void a(bbnf parambbnf, bbvl parambbvl)
  {
    Object localObject1 = BaseApplicationImpl.getApplication().getRuntime();
    Object localObject3 = parambbvl.a().getContext();
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
      parambbvl.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#737373"));
      if (!TextUtils.isEmpty(parambbnf.jdField_a_of_type_JavaLangCharSequence)) {
        break label593;
      }
      parambbvl.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      if (parambbnf.jdField_a_of_type_Bbna == null) {
        break label775;
      }
      parambbvl.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      parambbvl.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      i = (int)(bgln.k() - zlx.a((Context)localObject3, 30.0F)) / 2 - zlx.a((Context)localObject3, 3.0F);
      localObject1 = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject1).mPlayGifImage = true;
      ((URLDrawable.URLDrawableOptions)localObject1).mFailedDrawable = new ColorDrawable(Color.parseColor("#e7e7e7"));
      ((URLDrawable.URLDrawableOptions)localObject1).mLoadingDrawable = new ColorDrawable(Color.parseColor("#e7e7e7"));
      ((URLDrawable.URLDrawableOptions)localObject1).mRequestWidth = i;
      ((URLDrawable.URLDrawableOptions)localObject1).mRequestHeight = i;
      localObject2 = URLDrawable.getDrawable(parambbnf.jdField_a_of_type_Bbna.jdField_a_of_type_JavaLangString, (URLDrawable.URLDrawableOptions)localObject1);
      parambbvl.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable((Drawable)localObject2);
      if ((((URLDrawable)localObject2).getStatus() != 1) && (((URLDrawable)localObject2).getStatus() != 0)) {
        ((URLDrawable)localObject2).restartDownload();
      }
      localObject2 = (LinearLayout.LayoutParams)parambbvl.jdField_a_of_type_ComTencentImageURLImageView.getLayoutParams();
      ((LinearLayout.LayoutParams)localObject2).height = i;
      ((LinearLayout.LayoutParams)localObject2).width = i;
      parambbvl.jdField_a_of_type_ComTencentImageURLImageView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
      parambbvl.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(0);
      if (parambbnf.jdField_a_of_type_JavaUtilList == null) {
        return;
      }
      m = Math.min(parambbnf.jdField_a_of_type_JavaUtilList.size(), 4);
      n = (i - zlx.a((Context)localObject3, 3.0F)) / 2;
      localObject2 = new int[4];
      Object tmp295_293 = localObject2;
      tmp295_293[0] = 2131368280;
      Object tmp301_295 = tmp295_293;
      tmp301_295[1] = 2131368281;
      Object tmp307_301 = tmp301_295;
      tmp307_301[2] = 2131368282;
      Object tmp313_307 = tmp307_301;
      tmp313_307[3] = 2131368283;
      tmp313_307;
      i = 0;
      if (i >= m) {
        break label748;
      }
      localObject3 = (SquareImageView)parambbvl.jdField_b_of_type_AndroidWidgetLinearLayout.findViewById(localObject2[i]);
      localObject4 = ((bbna)parambbnf.jdField_a_of_type_JavaUtilList.get(i)).jdField_a_of_type_JavaLangString;
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
      if ((i != 3) || (parambbnf.jdField_a_of_type_Int <= 4)) {
        break label731;
      }
      ((SquareImageView)localObject3).setFilterColor(Color.parseColor("#66000000"));
      k = parambbnf.jdField_a_of_type_Int - 4;
      localObject4 = new StringBuilder().append("+");
      j = k;
      if (k > 99) {
        j = 99;
      }
      ((SquareImageView)localObject3).setFilterText(j);
      ((SquareImageView)localObject3).setFilterTextSize(bggq.a(parambbvl.a().getContext(), 20.0F));
    }
    for (;;)
    {
      i += 1;
      break label322;
      parambbvl.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#262626"));
      break;
      label593:
      i = (int)(parambbvl.jdField_a_of_type_AndroidWidgetTextView.getContext().getResources().getDisplayMetrics().widthPixels - bggq.a(parambbvl.jdField_a_of_type_AndroidWidgetTextView.getContext(), 30.0F) - bbup.a(parambbvl.jdField_a_of_type_AndroidWidgetTextView, parambbnf.jdField_a_of_type_JavaLangString));
      localObject2 = bbup.a(parambbvl.jdField_a_of_type_AndroidWidgetTextView, i, 1, parambbnf.jdField_a_of_type_JavaLangCharSequence.toString(), parambbnf.jdField_a_of_type_Bbue.jdField_a_of_type_JavaUtilList, false, false, true);
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      if (parambbnf.jdField_a_of_type_JavaLangString == null) {
        parambbnf.jdField_a_of_type_JavaLangString = "";
      }
      parambbvl.jdField_a_of_type_AndroidWidgetTextView.setText(new SpannableStringBuilder((CharSequence)localObject1).append(parambbnf.jdField_a_of_type_JavaLangString));
      parambbvl.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      break label59;
      label731:
      ((SquareImageView)localObject3).setFilterColor(-1);
      ((SquareImageView)localObject3).setFilterText("");
    }
    label748:
    while (i < 4)
    {
      parambbvl.jdField_b_of_type_AndroidWidgetLinearLayout.findViewById(localObject2[i]).setVisibility(4);
      i += 1;
    }
    label775:
    parambbvl.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    parambbvl.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
    if (parambbnf.jdField_a_of_type_JavaUtilList != null)
    {
      m = Math.min(parambbnf.jdField_a_of_type_JavaUtilList.size(), parambbvl.jdField_a_of_type_Int);
      n = (int)(bgln.k() - zlx.a(parambbvl.a().getContext(), (m - 1) * 2 + 27));
      i = 0;
      if (i < m)
      {
        localObject1 = (SquareImageView)parambbvl.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(i);
        localObject2 = ((bbna)parambbnf.jdField_a_of_type_JavaUtilList.get(i)).jdField_a_of_type_JavaLangString;
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
        if (parambbnf.jdField_b_of_type_Int != 0)
        {
          ((SquareImageView)localObject1).setImageScale(n / 4 * 1.0F / bggq.a((Context)localObject3, parambbnf.jdField_b_of_type_Int / 2), 0.0F);
          label1007:
          ((SquareImageView)localObject1).setVisibility(0);
          if ((i != parambbvl.jdField_a_of_type_Int - 1) || (parambbnf.jdField_a_of_type_Int <= parambbvl.jdField_a_of_type_Int)) {
            break label1136;
          }
          ((SquareImageView)localObject1).setFilterColor(Color.parseColor("#66000000"));
          k = parambbnf.jdField_a_of_type_Int - parambbvl.jdField_a_of_type_Int;
          localObject2 = new StringBuilder().append("+");
          j = k;
          if (k > 99) {
            j = 99;
          }
          ((SquareImageView)localObject1).setFilterText(j);
          ((SquareImageView)localObject1).setFilterTextSize(bggq.a(parambbvl.a().getContext(), 20.0F));
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
      while (i < parambbvl.jdField_a_of_type_Int)
      {
        parambbvl.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(i).setVisibility(4);
        i += 1;
      }
    }
  }
  
  private void a(bbng parambbng, bbvm parambbvm)
  {
    Object localObject = parambbvm.a().getContext();
    int i;
    if (!TextUtils.isEmpty(parambbng.i))
    {
      parambbvm.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      a((Context)localObject, (SquareImageView)parambbvm.jdField_a_of_type_AndroidWidgetImageView, parambbvm.jdField_b_of_type_AndroidWidgetImageView, parambbvm.jdField_b_of_type_AndroidWidgetTextView, parambbng.jdField_a_of_type_Int, parambbng.i, parambbng.jdField_b_of_type_JavaLangString, ((Context)localObject).getResources().getDimensionPixelSize(2131298311));
      i = ((Context)localObject).getResources().getDimensionPixelSize(2131298311);
      if ((parambbng.jdField_a_of_type_Int == 6) || (parambbng.jdField_a_of_type_Int == 8)) {
        i = bggq.a((Context)localObject, 100.0F);
      }
      if (parambbvm.jdField_a_of_type_AndroidWidgetRelativeLayout.getVisibility() != 8) {
        break label317;
      }
      i = 0;
      label127:
      float f = ((Context)localObject).getResources().getDisplayMetrics().widthPixels - bggq.a((Context)localObject, 30.0F);
      CharSequence localCharSequence = bbup.a(parambbvm.jdField_a_of_type_AndroidWidgetTextView, f, 2, parambbng.jdField_a_of_type_JavaLangCharSequence.toString(), parambbng.jdField_a_of_type_Bbue.jdField_a_of_type_JavaUtilList, false, true);
      parambbvm.jdField_a_of_type_AndroidWidgetTextView.setText(localCharSequence);
      f = ((Context)localObject).getResources().getDisplayMetrics().widthPixels - bggq.a((Context)localObject, 30.0F) - i;
      localObject = bbup.a(parambbvm.c, f, 2, parambbng.jdField_b_of_type_JavaLangCharSequence.toString(), parambbng.jdField_a_of_type_Bbue.jdField_a_of_type_JavaUtilList, false, false);
      if (!ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null)) {
        break label333;
      }
      parambbvm.c.setTextColor(Color.parseColor("#4A4A4A"));
      parambbvm.jdField_d_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#4A4A4A"));
    }
    for (;;)
    {
      a(parambbvm.c, (CharSequence)localObject, true);
      a(parambbvm.jdField_d_of_type_AndroidWidgetTextView, parambbng.jdField_c_of_type_JavaLangCharSequence);
      return;
      parambbvm.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      break;
      label317:
      i += bggq.a((Context)localObject, 10.0F);
      break label127;
      label333:
      parambbvm.c.setTextColor(Color.parseColor("#737373"));
      parambbvm.jdField_d_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#737373"));
    }
  }
  
  private void a(bbnj parambbnj, bbvo parambbvo)
  {
    Context localContext = parambbvo.a().getContext();
    int j;
    int i;
    if (parambbnj.jdField_a_of_type_Int == 1)
    {
      j = bggq.a(localContext, 375.0F);
      i = bggq.a(localContext, 150.0F);
    }
    for (;;)
    {
      int k;
      if ((j == 0) || (i == 0))
      {
        i = bggq.a(localContext, 375.0F);
        j = bggq.a(localContext, 150.0F);
        k = i;
        i = j;
      }
      for (;;)
      {
        if (!TextUtils.isEmpty(parambbnj.jdField_b_of_type_JavaLangString))
        {
          localObject = URLDrawable.URLDrawableOptions.obtain();
          ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
          ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
          ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = k;
          ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = i;
          ((URLDrawable.URLDrawableOptions)localObject).mPlayGifImage = true;
          localObject = URLDrawable.getDrawable(parambbnj.jdField_b_of_type_JavaLangString, (URLDrawable.URLDrawableOptions)localObject);
          parambbvo.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable((Drawable)localObject);
          if ((((URLDrawable)localObject).getStatus() != 1) && (((URLDrawable)localObject).getStatus() != 0)) {
            ((URLDrawable)localObject).restartDownload();
          }
          label164:
          parambbvo.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(0);
          localObject = (LinearLayout.LayoutParams)parambbvo.jdField_a_of_type_AndroidWidgetRelativeLayout.getLayoutParams();
          ((LinearLayout.LayoutParams)localObject).height = ((int)(i * zlx.a(localContext) * 1.0F / k));
          parambbvo.jdField_a_of_type_AndroidWidgetRelativeLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
          parambbvo.jdField_a_of_type_AndroidWidgetRelativeLayout.setPadding(0, 0, 0, 0);
          if (TextUtils.isEmpty(parambbnj.jdField_a_of_type_JavaLangCharSequence)) {
            break label522;
          }
          parambbvo.jdField_b_of_type_AndroidWidgetTextView.setText(parambbnj.jdField_a_of_type_JavaLangCharSequence);
          parambbvo.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
          label253:
          if (TextUtils.isEmpty(parambbnj.jdField_b_of_type_JavaLangCharSequence)) {
            break label534;
          }
          parambbvo.c.setText(parambbnj.jdField_b_of_type_JavaLangCharSequence);
          parambbvo.c.setVisibility(0);
          label282:
          if (TextUtils.isEmpty(parambbnj.j)) {
            break label599;
          }
          parambbvo.jdField_d_of_type_AndroidWidgetTextView.setText(parambbnj.j);
        }
        try
        {
          if (!parambbnj.k.startsWith("#")) {
            parambbnj.k = ("#" + parambbnj.k);
          }
          parambbvo.jdField_d_of_type_AndroidWidgetTextView.setBackgroundColor(Color.parseColor(parambbnj.k));
        }
        catch (Exception localException)
        {
          for (;;)
          {
            label365:
            parambbvo.jdField_d_of_type_AndroidWidgetTextView.setBackgroundColor(Color.parseColor("#FF00FF00"));
            if (QLog.isColorLevel()) {
              QLog.e("Q.uniteSearch.SearchTemplatePresenter", 2, "bigImageItem.topLeftTagColor = " + parambbnj.k);
            }
          }
        }
        parambbvo.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
        Object localObject = ((ViewGroup)parambbvo.a()).getChildAt(((ViewGroup)parambbvo.a()).getChildCount() - 1);
        if ((localObject != null) && ((((View)localObject).getLayoutParams() instanceof LinearLayout.LayoutParams)))
        {
          if (parambbnj.b() != 0) {
            break label611;
          }
          ((LinearLayout.LayoutParams)((View)localObject).getLayoutParams()).topMargin = 0;
          parambbvo.jdField_a_of_type_AndroidWidgetRelativeLayout.setPadding(0, 0, 0, bggq.a(localContext, 6.0F));
        }
        label522:
        label534:
        label599:
        label611:
        while (parambbnj.b() != 2)
        {
          return;
          if (parambbnj.jdField_a_of_type_Int == 2)
          {
            j = bggq.a(localContext, 375.0F);
            i = bggq.a(localContext, 180.0F);
            break;
          }
          if (parambbnj.jdField_a_of_type_Int != 0) {
            break label639;
          }
          j = bggq.a(localContext, parambbnj.jdField_a_of_type_Float / 2.0F);
          i = bggq.a(localContext, parambbnj.jdField_b_of_type_Float / 2.0F);
          break;
          parambbvo.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
          break label164;
          parambbvo.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
          break label253;
          parambbvo.c.setVisibility(8);
          break label282;
          parambbvo.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
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
  
  private void a(bbnl parambbnl, bbvq parambbvq)
  {
    Object localObject1 = parambbvq.a().getContext();
    Object localObject2 = parambbvq.a();
    if (parambbnl.jdField_b_of_type_Boolean) {
      ((View)localObject2).setPadding(((View)localObject2).getPaddingLeft(), zlx.a(((View)localObject2).getContext(), 6.0F), ((View)localObject2).getPaddingRight(), zlx.a(((View)localObject2).getContext(), 6.0F));
    }
    Object localObject3;
    int i;
    Object localObject4;
    for (;;)
    {
      localObject2 = (LinearLayout)((View)localObject2).findViewById(2131372555);
      localObject3 = new ArrayList();
      i = 0;
      while (i < ((LinearLayout)localObject2).getChildCount())
      {
        localObject4 = ((LinearLayout)localObject2).getChildAt(i).findViewById(2131368343);
        if ((localObject4 instanceof SquareImageView)) {
          ((List)localObject3).add((SquareImageView)localObject4);
        }
        i += 1;
      }
      ((View)localObject2).setPadding(((View)localObject2).getPaddingLeft(), zlx.a(((View)localObject2).getContext(), 3.0F), ((View)localObject2).getPaddingRight(), zlx.a(((View)localObject2).getContext(), 3.0F));
    }
    if (!((List)localObject3).isEmpty())
    {
      if (parambbnl.jdField_c_of_type_Boolean)
      {
        i = 0;
        while (i < ((List)localObject3).size())
        {
          ((SquareImageView)((List)localObject3).get(i)).setRoundRect(zlx.a((Context)localObject1, 4.0F));
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
    if (!TextUtils.isEmpty(parambbnl.i)) {
      a((Context)localObject1, (SquareImageView)parambbvq.b(), parambbvq.jdField_b_of_type_AndroidWidgetImageView, parambbvq.jdField_a_of_type_AndroidWidgetTextView, parambbnl.jdField_a_of_type_Int, parambbnl.i, null, bggq.a((Context)localObject1, 32.0F));
    }
    label687:
    Object localObject5;
    if (!TextUtils.isEmpty(parambbnl.jdField_a_of_type_JavaLangString))
    {
      localObject2 = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
      ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
      ((URLDrawable.URLDrawableOptions)localObject2).mRequestWidth = parambbvq.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams().width;
      ((URLDrawable.URLDrawableOptions)localObject2).mRequestHeight = parambbvq.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams().height;
      localObject2 = URLDrawable.getDrawable(parambbnl.jdField_a_of_type_JavaLangString, (URLDrawable.URLDrawableOptions)localObject2);
      parambbvq.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject2);
      if ((((URLDrawable)localObject2).getStatus() != 1) && (((URLDrawable)localObject2).getStatus() != 0)) {
        ((URLDrawable)localObject2).restartDownload();
      }
      parambbvq.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      i = ((Context)localObject1).getResources().getDimensionPixelSize(2131298311);
      if ((parambbnl.jdField_a_of_type_Int == 6) || (parambbnl.jdField_a_of_type_Int == 8)) {
        i = bggq.a((Context)localObject1, 100.0F);
      }
      localObject2 = bbup.a(parambbvq.a(), 10.0F * bbup.a(parambbvq.a(), anni.a(2131712435)), 1, parambbnl.jdField_a_of_type_JavaLangCharSequence.toString(), parambbnl.jdField_a_of_type_Bbue.jdField_a_of_type_JavaUtilList, false, false, true);
      parambbvq.a().setText((CharSequence)localObject2);
      parambbvq.a().setEllipsize(null);
      float f1 = ((Context)localObject1).getResources().getDisplayMetrics().widthPixels - bggq.a((Context)localObject1, 40.0F) - i;
      localObject2 = bbup.a(parambbvq.b(), f1, 2, parambbnl.jdField_b_of_type_JavaLangCharSequence.toString(), "", false, false, true);
      a(parambbvq.b(), (CharSequence)localObject2, false);
      if (TextUtils.isEmpty(parambbnl.jdField_c_of_type_JavaLangCharSequence)) {
        break label1047;
      }
      f1 = ((Context)localObject1).getResources().getDisplayMetrics().widthPixels - bggq.a((Context)localObject1, 30.0F);
      localObject2 = bbup.a(parambbvq.c(), f1, 2, parambbnl.jdField_c_of_type_JavaLangCharSequence.toString(), parambbnl.jdField_a_of_type_Bbue.jdField_a_of_type_JavaUtilList, false, false);
      parambbvq.c().setText((CharSequence)localObject2);
      parambbvq.c().setVisibility(0);
      if (parambbnl.jdField_a_of_type_JavaUtilList == null) {
        break label1479;
      }
      if (parambbnl.jdField_a_of_type_JavaUtilList.size() != 1) {
        break label1071;
      }
      parambbvq.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(0);
      parambbvq.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      localObject3 = parambbvq.a().getResources();
      if (jdField_a_of_type_Int == 0) {
        jdField_a_of_type_Int = ((Resources)localObject3).getDisplayMetrics().widthPixels;
      }
      localObject2 = parambbvq.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView;
      ((SquareImageView)localObject2).setImageScale((float)(1.0D / parambbnl.jdField_a_of_type_Double), 0.0F);
      f1 = ((Resources)localObject3).getDimension(2131298304);
      float f2 = ((Resources)localObject3).getDimension(2131298304);
      i = bggq.a(parambbvq.a().getContext(), 2.0F);
      j = parambbvq.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount();
      j = (int)(jdField_a_of_type_Int - f1 - f2 - (j - 1) * i) / j;
      i = (int)(j * parambbnl.jdField_b_of_type_Double);
      j = (int)(j * parambbnl.jdField_b_of_type_Double);
      ((SquareImageView)localObject2).setLayoutParams(new FrameLayout.LayoutParams(i, j));
      localObject3 = (bbna)parambbnl.jdField_a_of_type_JavaUtilList.get(0);
      localObject4 = ((bbna)localObject3).jdField_a_of_type_JavaLangString;
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
      if (((bbna)localObject3).jdField_a_of_type_Int != 2) {
        break label1059;
      }
      parambbvq.jdField_d_of_type_AndroidWidgetImageView.setVisibility(0);
    }
    for (;;)
    {
      if ((parambbnl.jdField_c_of_type_JavaUtilList != null) || (!TextUtils.equals(parambbnl.k, "0")) || (!TextUtils.equals(parambbnl.m, "0"))) {
        break label1500;
      }
      parambbvq.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      return;
      parambbvq.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      break;
      label1047:
      parambbvq.c().setVisibility(8);
      break label687;
      label1059:
      parambbvq.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
      continue;
      label1071:
      parambbvq.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(8);
      parambbvq.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      int m = parambbvq.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount();
      i = 0;
      j = i;
      if (i < parambbnl.jdField_a_of_type_JavaUtilList.size())
      {
        j = i;
        if (i < m)
        {
          localObject3 = parambbvq.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(i);
          ((View)localObject3).setVisibility(0);
          localObject2 = (SquareImageView)((View)localObject3).findViewById(2131368343);
          localObject3 = (ImageView)((View)localObject3).findViewById(2131369526);
          ((SquareImageView)localObject2).setImageScale((float)(1.0D / parambbnl.jdField_a_of_type_Double), 0.0F);
          localObject4 = (bbna)parambbnl.jdField_a_of_type_JavaUtilList.get(i);
          localObject5 = ((bbna)localObject4).jdField_a_of_type_JavaLangString;
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
          if (((bbna)localObject4).jdField_a_of_type_Int == 2)
          {
            ((ImageView)localObject3).setVisibility(0);
            label1312:
            if ((i != m - 1) || (parambbnl.jdField_b_of_type_Int <= m)) {
              break label1433;
            }
            ((ImageView)localObject3).setVisibility(8);
            ((SquareImageView)localObject2).setFilterColor(Color.parseColor("#66000000"));
            int k = parambbnl.jdField_b_of_type_Int - m;
            j = k;
            if (k > 99) {
              j = 99;
            }
            ((SquareImageView)localObject2).setFilterText("+" + j);
            ((SquareImageView)localObject2).setFilterTextSize(bggq.a(((SquareImageView)localObject2).getContext(), 20.0F));
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
        parambbvq.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(j).setVisibility(4);
        j += 1;
      }
      continue;
      label1479:
      parambbvq.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(8);
      parambbvq.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    }
    label1500:
    if (parambbnl.jdField_c_of_type_JavaUtilList != null)
    {
      parambbvq.jdField_a_of_type_AndroidWidgetRelativeLayout.removeAllViews();
      i = parambbnl.jdField_c_of_type_JavaUtilList.size() - 1;
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
    for (int j = bggq.a((Context)localObject1, 11.0F) * i;; j = 0)
    {
      localObject2 = (SquareImageView)LayoutInflater.from((Context)localObject1).inflate(2131559814, null, false);
      localObject3 = new RelativeLayout.LayoutParams(bggq.a((Context)localObject1, 16.0F), bggq.a((Context)localObject1, 16.0F));
      ((RelativeLayout.LayoutParams)localObject3).leftMargin = j;
      parambbvq.jdField_a_of_type_AndroidWidgetRelativeLayout.addView((View)localObject2, parambbnl.jdField_c_of_type_JavaUtilList.size() - 1 - i, (ViewGroup.LayoutParams)localObject3);
      localObject3 = (String)parambbnl.jdField_c_of_type_JavaUtilList.get(i);
      localObject4 = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject4).mFailedDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
      ((URLDrawable.URLDrawableOptions)localObject4).mLoadingDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
      ((URLDrawable.URLDrawableOptions)localObject4).mRequestWidth = ((SquareImageView)localObject2).getLayoutParams().width;
      ((URLDrawable.URLDrawableOptions)localObject4).mRequestHeight = ((SquareImageView)localObject2).getLayoutParams().height;
      localObject3 = URLDrawable.getDrawable((String)localObject3, (URLDrawable.URLDrawableOptions)localObject4);
      ((URLDrawable)localObject3).setDecodeHandler(bgey.a);
      ((SquareImageView)localObject2).setImageDrawable((Drawable)localObject3);
      if ((((URLDrawable)localObject3).getStatus() != 1) && (((URLDrawable)localObject3).getStatus() != 0)) {
        ((URLDrawable)localObject3).restartDownload();
      }
      ((SquareImageView)localObject2).setVisibility(0);
      i -= 1;
      break;
      parambbvq.jdField_a_of_type_AndroidWidgetRelativeLayout.removeAllViews();
      label1758:
      if (!TextUtils.isEmpty(parambbnl.jdField_b_of_type_JavaLangString))
      {
        parambbvq.jdField_b_of_type_AndroidWidgetTextView.setText(parambbnl.jdField_b_of_type_JavaLangString);
        parambbvq.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
        if (TextUtils.isEmpty(parambbnl.j)) {
          break label2084;
        }
        localObject1 = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject1).mFailedDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
        ((URLDrawable.URLDrawableOptions)localObject1).mLoadingDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
        ((URLDrawable.URLDrawableOptions)localObject1).mRequestWidth = parambbvq.jdField_a_of_type_ComTencentImageURLImageView.getLayoutParams().width;
        ((URLDrawable.URLDrawableOptions)localObject1).mRequestHeight = parambbvq.jdField_a_of_type_ComTencentImageURLImageView.getLayoutParams().height;
        localObject1 = URLDrawable.getDrawable(parambbnl.j, (URLDrawable.URLDrawableOptions)localObject1);
        parambbvq.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable((Drawable)localObject1);
        if ((((URLDrawable)localObject1).getStatus() != 1) && (((URLDrawable)localObject1).getStatus() != 0)) {
          ((URLDrawable)localObject1).restartDownload();
        }
        parambbvq.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(0);
        label1900:
        if (TextUtils.isEmpty(parambbnl.k)) {
          break label2096;
        }
        parambbvq.c.setText(parambbnl.k);
        parambbvq.c.setVisibility(0);
        if (TextUtils.isEmpty(parambbnl.l)) {
          break label2108;
        }
        localObject1 = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject1).mFailedDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
        ((URLDrawable.URLDrawableOptions)localObject1).mLoadingDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
        ((URLDrawable.URLDrawableOptions)localObject1).mRequestWidth = parambbvq.jdField_b_of_type_ComTencentImageURLImageView.getLayoutParams().width;
        ((URLDrawable.URLDrawableOptions)localObject1).mRequestHeight = parambbvq.jdField_b_of_type_ComTencentImageURLImageView.getLayoutParams().height;
        localObject1 = URLDrawable.getDrawable(parambbnl.l, (URLDrawable.URLDrawableOptions)localObject1);
        parambbvq.jdField_b_of_type_ComTencentImageURLImageView.setImageDrawable((Drawable)localObject1);
        if ((((URLDrawable)localObject1).getStatus() != 1) && (((URLDrawable)localObject1).getStatus() != 0)) {
          ((URLDrawable)localObject1).restartDownload();
        }
        parambbvq.jdField_b_of_type_ComTencentImageURLImageView.setVisibility(0);
      }
      for (;;)
      {
        if (TextUtils.isEmpty(parambbnl.m)) {
          break label2120;
        }
        parambbvq.jdField_d_of_type_AndroidWidgetTextView.setText(parambbnl.m);
        parambbvq.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
        return;
        parambbvq.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
        break;
        parambbvq.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(8);
        break label1900;
        parambbvq.c.setVisibility(8);
        break label1929;
        parambbvq.jdField_b_of_type_ComTencentImageURLImageView.setVisibility(8);
      }
      parambbvq.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
      return;
    }
  }
  
  private void a(bbnr parambbnr, bbvw parambbvw)
  {
    Object localObject = parambbvw.a();
    Context localContext = ((View)localObject).getContext();
    if (((localObject instanceof LinearLayout)) && (((LinearLayout)localObject).getChildCount() == 1))
    {
      localObject = ((LinearLayout)localObject).getChildAt(0);
      ((View)localObject).setPadding(((View)localObject).getPaddingLeft(), 0, ((View)localObject).getPaddingRight(), 0);
    }
    if (!TextUtils.isEmpty(parambbnr.jdField_b_of_type_JavaLangString))
    {
      localObject = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
      ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
      ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = bggq.a(localContext, 50.0F);
      ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = bggq.a(localContext, 50.0F);
      ((URLDrawable.URLDrawableOptions)localObject).mMemoryCacheKeySuffix = "leftIcon";
      localObject = URLDrawable.getDrawable(parambbnr.jdField_b_of_type_JavaLangString, (URLDrawable.URLDrawableOptions)localObject);
      parambbvw.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable((Drawable)localObject);
      if ((((URLDrawable)localObject).getStatus() != 1) && (((URLDrawable)localObject).getStatus() != 0)) {
        ((URLDrawable)localObject).restartDownload();
      }
      parambbvw.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(0);
      if (TextUtils.isEmpty(parambbnr.j)) {
        break label504;
      }
      parambbvw.jdField_a_of_type_AndroidWidgetTextView.setText(parambbnr.j);
      parambbvw.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      label204:
      if (TextUtils.isEmpty(parambbnr.g)) {
        break label516;
      }
      parambbvw.jdField_b_of_type_AndroidWidgetTextView.setText(parambbnr.g);
      parambbvw.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      label233:
      if (TextUtils.isEmpty(parambbnr.k)) {
        break label528;
      }
      parambbvw.c.setVisibility(0);
      parambbvw.c.setText(parambbnr.k);
      label262:
      if (TextUtils.isEmpty(parambbnr.l)) {
        break label540;
      }
      localObject = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
      ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
      ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = bggq.a(localContext, 30.0F);
      ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = bggq.a(localContext, 30.0F);
      ((URLDrawable.URLDrawableOptions)localObject).mMemoryCacheKeySuffix = "rightIcon";
      localObject = URLDrawable.getDrawable(parambbnr.l, (URLDrawable.URLDrawableOptions)localObject);
      parambbvw.jdField_b_of_type_ComTencentImageURLImageView.setImageDrawable((Drawable)localObject);
      if ((((URLDrawable)localObject).getStatus() != 1) && (((URLDrawable)localObject).getStatus() != 0)) {
        ((URLDrawable)localObject).restartDownload();
      }
      parambbvw.jdField_b_of_type_ComTencentImageURLImageView.setVisibility(0);
      label377:
      parambbvw.a(parambbnr);
      if (!ThemeUtil.isInNightMode(BaseApplicationImpl.getApplication().getRuntime())) {
        break label552;
      }
      parambbvw.jdField_a_of_type_AndroidWidgetLinearLayout.setBackgroundResource(2130839386);
      parambbvw.jdField_b_of_type_AndroidWidgetLinearLayout.setBackgroundResource(2130839386);
      parambbvw.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#737373"));
      parambbvw.c.setTextColor(Color.parseColor("#4A4A4A"));
    }
    for (;;)
    {
      if (parambbvw.jdField_b_of_type_AndroidWidgetTextView != null) {
        parambbvw.jdField_b_of_type_AndroidWidgetTextView.setTextColor(bbup.b());
      }
      parambbvw.jdField_a_of_type_AndroidWidgetLinearLayout.setOnClickListener(new bbqv(this, parambbnr, localContext));
      parambbvw.jdField_b_of_type_AndroidWidgetLinearLayout.setOnClickListener(new bbqw(this, parambbnr, localContext));
      return;
      parambbvw.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(8);
      break;
      label504:
      parambbvw.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      break label204;
      label516:
      parambbvw.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      break label233;
      label528:
      parambbvw.c.setVisibility(8);
      break label262;
      label540:
      parambbvw.jdField_b_of_type_ComTencentImageURLImageView.setVisibility(8);
      break label377;
      label552:
      parambbvw.jdField_a_of_type_AndroidWidgetLinearLayout.setBackgroundResource(2130839385);
      parambbvw.jdField_b_of_type_AndroidWidgetLinearLayout.setBackgroundResource(2130839385);
      parambbvw.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#262626"));
      parambbvw.c.setTextColor(Color.parseColor("#737373"));
    }
  }
  
  private void a(bbns parambbns, bbvy parambbvy)
  {
    Object localObject = parambbvy.a();
    Context localContext = ((View)localObject).getContext();
    if (((localObject instanceof LinearLayout)) && (((LinearLayout)localObject).getChildCount() == 1))
    {
      localObject = ((LinearLayout)localObject).getChildAt(0);
      ((View)localObject).setPadding(((View)localObject).getPaddingLeft(), 0, ((View)localObject).getPaddingRight(), 0);
    }
    if (!TextUtils.isEmpty(parambbns.jdField_b_of_type_JavaLangString))
    {
      localObject = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
      ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
      ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = bggq.a(localContext, 40.0F);
      ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = bggq.a(localContext, 40.0F);
      ((URLDrawable.URLDrawableOptions)localObject).mMemoryCacheKeySuffix = "leftIcon";
      localObject = URLDrawable.getDrawable(parambbns.jdField_b_of_type_JavaLangString, (URLDrawable.URLDrawableOptions)localObject);
      parambbvy.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable((Drawable)localObject);
      if ((((URLDrawable)localObject).getStatus() != 1) && (((URLDrawable)localObject).getStatus() != 0)) {
        ((URLDrawable)localObject).restartDownload();
      }
      parambbvy.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(0);
      if (TextUtils.isEmpty(parambbns.j)) {
        break label363;
      }
      parambbvy.jdField_a_of_type_AndroidWidgetTextView.setText(parambbns.j);
      parambbvy.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      label204:
      if (TextUtils.isEmpty(parambbns.g)) {
        break label375;
      }
      parambbvy.c.setText(parambbns.g);
      parambbvy.c.setVisibility(0);
      label233:
      if (TextUtils.isEmpty(parambbns.k)) {
        break label387;
      }
      parambbvy.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
      parambbvy.jdField_d_of_type_AndroidWidgetTextView.setText(parambbns.k);
      label262:
      if (!parambbns.jdField_b_of_type_Boolean) {
        break label399;
      }
      parambbvy.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    }
    for (;;)
    {
      bbrf.a(null, 0, parambbns.jdField_c_of_type_Int, "0X8009D5C", 0, 0, null, null);
      if ((parambbns.jdField_a_of_type_JavaUtilList != null) && (parambbns.jdField_a_of_type_JavaUtilList.size() > 0)) {
        bbrf.a(null, 0, parambbns.jdField_c_of_type_Int, "0X8009D5E", 0, 0, null, null);
      }
      parambbvy.a(parambbns);
      parambbvy.jdField_a_of_type_AndroidWidgetLinearLayout.setOnClickListener(new bbqu(this, parambbns, localContext));
      return;
      parambbvy.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(8);
      break;
      label363:
      parambbvy.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      break label204;
      label375:
      parambbvy.c.setVisibility(8);
      break label233;
      label387:
      parambbvy.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
      break label262;
      label399:
      parambbvy.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    }
  }
  
  private void a(bbnu parambbnu, bbwe parambbwe)
  {
    if ((parambbnu == null) || (parambbwe == null)) {
      return;
    }
    parambbwe.jdField_a_of_type_AndroidWidgetLinearLayout.setPadding(parambbwe.jdField_a_of_type_AndroidWidgetLinearLayout.getPaddingLeft(), 0, parambbwe.jdField_a_of_type_AndroidWidgetLinearLayout.getPaddingRight(), 0);
    Object localObject = (RelativeLayout.LayoutParams)parambbwe.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams();
    boolean bool = ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null);
    if (parambbnu.jdField_b_of_type_Boolean)
    {
      ((RelativeLayout.LayoutParams)localObject).addRule(5, 0);
      ((RelativeLayout.LayoutParams)localObject).addRule(14);
      localObject = parambbwe.jdField_a_of_type_AndroidWidgetTextView.getContext();
      int i = ((Context)localObject).getResources().getDisplayMetrics().widthPixels - bggq.a((Context)localObject, 38.0F);
      if (TextUtils.isEmpty(parambbnu.jdField_b_of_type_JavaLangCharSequence)) {
        break label310;
      }
      parambbwe.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      if (!bool) {
        break label296;
      }
      parambbwe.jdField_b_of_type_AndroidWidgetTextView.setText(parambbnu.jdField_b_of_type_JavaLangCharSequence.toString());
      label148:
      float f1 = i;
      float f2 = bbup.a(parambbwe.jdField_b_of_type_AndroidWidgetTextView, parambbnu.jdField_b_of_type_JavaLangCharSequence);
      i = (int)(f1 - (bggq.a((Context)localObject, 10.0F) + f2));
      label182:
      if (TextUtils.isEmpty(parambbnu.jdField_a_of_type_JavaLangCharSequence)) {
        break label334;
      }
      parambbwe.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      localObject = parambbnu.jdField_a_of_type_JavaLangCharSequence;
      if (parambbnu.jdField_b_of_type_Boolean) {
        break label346;
      }
      localObject = bbup.a(parambbwe.jdField_a_of_type_AndroidWidgetTextView, i, (CharSequence)localObject);
    }
    label296:
    label310:
    label334:
    label346:
    for (;;)
    {
      if (bool) {
        parambbwe.jdField_a_of_type_AndroidWidgetTextView.setText(((CharSequence)localObject).toString());
      }
      for (;;)
      {
        parambbwe.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundDrawable(a(parambbnu.jdField_a_of_type_JavaLangString));
        parambbwe.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(new bbqx(this, parambbnu, parambbwe));
        return;
        ((RelativeLayout.LayoutParams)localObject).addRule(14, 0);
        ((RelativeLayout.LayoutParams)localObject).addRule(5);
        break;
        parambbwe.jdField_b_of_type_AndroidWidgetTextView.setText(parambbnu.jdField_b_of_type_JavaLangCharSequence);
        break label148;
        parambbwe.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
        break label182;
        parambbwe.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
        continue;
        parambbwe.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      }
    }
  }
  
  private void a(bbnv parambbnv, bbwd parambbwd)
  {
    if ((parambbnv == null) || (parambbwd == null)) {}
    while ((TextUtils.isEmpty(parambbnv.jdField_a_of_type_JavaLangString)) || (parambbwd.jdField_a_of_type_AndroidWidgetTextView == null)) {
      return;
    }
    Context localContext = parambbwd.jdField_a_of_type_AndroidWidgetTextView.getContext();
    int j = localContext.getResources().getDisplayMetrics().widthPixels - bggq.a(localContext, 40.0F);
    int i;
    if ((!TextUtils.isEmpty(parambbnv.e)) && (parambbwd.jdField_a_of_type_AndroidWidgetLinearLayout != null))
    {
      parambbwd.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      i = j - bggq.a(localContext, 26.0F);
    }
    for (;;)
    {
      parambbnv = bbup.a(parambbwd.jdField_a_of_type_AndroidWidgetTextView, i, parambbnv.jdField_a_of_type_JavaLangString);
      parambbwd.jdField_a_of_type_AndroidWidgetTextView.setText(parambbnv);
      return;
      i = j;
      if (parambbwd.jdField_a_of_type_AndroidWidgetLinearLayout != null)
      {
        parambbwd.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
        i = j;
      }
    }
  }
  
  private void a(bbnx parambbnx, bbwg parambbwg)
  {
    Context localContext = parambbwg.jdField_b_of_type_AndroidWidgetRelativeLayout.getContext();
    Object localObject = (RelativeLayout.LayoutParams)parambbwg.jdField_a_of_type_AndroidWidgetLinearLayout.getLayoutParams();
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)parambbwg.jdField_b_of_type_AndroidWidgetRelativeLayout.getLayoutParams();
    if (parambbnx.jdField_b_of_type_Boolean)
    {
      ((RelativeLayout.LayoutParams)localObject).addRule(15);
      localLayoutParams.addRule(15);
      localLayoutParams.addRule(10, 0);
      localLayoutParams.addRule(10, 0);
    }
    for (;;)
    {
      localObject = a(parambbnx, parambbwg, false, 0);
      if (((Integer)((Pair)localObject).first).intValue() != 0) {
        ((RelativeLayout.LayoutParams)parambbwg.jdField_b_of_type_AndroidWidgetRelativeLayout.getLayoutParams()).rightMargin = bggq.a(localContext, 10.0F);
      }
      int i = a(parambbnx, parambbwg);
      int j = a(parambbnx, parambbwg, ((Integer)((Pair)localObject).first).intValue(), i);
      i = j;
      if (((Integer)((Pair)localObject).second).intValue() > j) {
        i = ((Integer)((Pair)localObject).second).intValue();
      }
      if (parambbwg.jdField_a_of_type_AndroidWidgetRelativeLayout != null) {
        ((RelativeLayout.LayoutParams)parambbwg.jdField_a_of_type_AndroidWidgetRelativeLayout.getLayoutParams()).height = i;
      }
      return;
      ((RelativeLayout.LayoutParams)localObject).addRule(10);
      localLayoutParams.addRule(10);
      ((RelativeLayout.LayoutParams)localObject).addRule(15, 0);
      localLayoutParams.addRule(15, 0);
    }
  }
  
  private void a(bbob parambbob, bbwh parambbwh)
  {
    Object localObject1 = parambbwh.a().getContext();
    Object localObject2 = parambbwh.a();
    if (parambbob.jdField_b_of_type_Boolean) {
      ((View)localObject2).setPadding(((View)localObject2).getPaddingLeft(), zlx.a(((View)localObject2).getContext(), 9.0F), ((View)localObject2).getPaddingRight(), zlx.a(((View)localObject2).getContext(), 9.0F));
    }
    Object localObject3;
    int i;
    Object localObject4;
    for (;;)
    {
      localObject2 = (LinearLayout)((View)localObject2).findViewById(2131372555);
      localObject3 = new ArrayList();
      i = 0;
      while (i < ((LinearLayout)localObject2).getChildCount())
      {
        localObject4 = ((LinearLayout)localObject2).getChildAt(i).findViewById(2131368343);
        if ((localObject4 instanceof SquareImageView)) {
          ((List)localObject3).add((SquareImageView)localObject4);
        }
        i += 1;
      }
      ((View)localObject2).setPadding(((View)localObject2).getPaddingLeft(), zlx.a(((View)localObject2).getContext(), 6.0F), ((View)localObject2).getPaddingRight(), zlx.a(((View)localObject2).getContext(), 6.0F));
    }
    if (!((List)localObject3).isEmpty())
    {
      if (parambbob.jdField_c_of_type_Boolean)
      {
        i = 0;
        while (i < ((List)localObject3).size())
        {
          ((SquareImageView)((List)localObject3).get(i)).setRoundRect(zlx.a((Context)localObject1, 4.0F));
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
      parambbwh.a().setTextColor(Color.parseColor("#6991B8"));
      parambbwh.c().setTextColor(Color.parseColor("#44608A"));
      parambbwh.b().setTextColor(Color.parseColor("#44608A"));
      if (!TextUtils.isEmpty(parambbob.i)) {
        a((Context)localObject1, (SquareImageView)parambbwh.b(), parambbwh.jdField_b_of_type_AndroidWidgetImageView, parambbwh.jdField_a_of_type_AndroidWidgetTextView, parambbob.jdField_a_of_type_Int, parambbob.i, null, bggq.a((Context)localObject1, 21.0F));
      }
      if (TextUtils.isEmpty(parambbob.jdField_a_of_type_JavaLangString)) {
        break label1085;
      }
      localObject2 = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
      ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
      ((URLDrawable.URLDrawableOptions)localObject2).mRequestWidth = parambbwh.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams().width;
      ((URLDrawable.URLDrawableOptions)localObject2).mRequestHeight = parambbwh.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams().height;
      localObject2 = URLDrawable.getDrawable(parambbob.jdField_a_of_type_JavaLangString, (URLDrawable.URLDrawableOptions)localObject2);
      parambbwh.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject2);
      if ((((URLDrawable)localObject2).getStatus() != 1) && (((URLDrawable)localObject2).getStatus() != 0)) {
        ((URLDrawable)localObject2).restartDownload();
      }
      parambbwh.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      i = ((Context)localObject1).getResources().getDimensionPixelSize(2131298311);
      if ((parambbob.jdField_a_of_type_Int == 6) || (parambbob.jdField_a_of_type_Int == 8)) {
        i = bggq.a((Context)localObject1, 100.0F);
      }
      localObject2 = bbup.a(parambbwh.a(), 10.0F * bbup.a(parambbwh.a(), anni.a(2131712434)), 1, parambbob.jdField_a_of_type_JavaLangCharSequence.toString(), parambbob.jdField_a_of_type_Bbue.jdField_a_of_type_JavaUtilList, false, false, true);
      parambbwh.a().setText((CharSequence)localObject2);
      parambbwh.a().setEllipsize(null);
      float f1 = ((Context)localObject1).getResources().getDisplayMetrics().widthPixels - bggq.a((Context)localObject1, 40.0F) - i;
      localObject2 = bbup.a(parambbwh.b(), f1, 2, parambbob.jdField_b_of_type_JavaLangCharSequence.toString(), "", false, false, true);
      a(parambbwh.b(), (CharSequence)localObject2, false);
      if (TextUtils.isEmpty(parambbob.jdField_c_of_type_JavaLangCharSequence)) {
        break label1097;
      }
      f1 = ((Context)localObject1).getResources().getDisplayMetrics().widthPixels - bggq.a((Context)localObject1, 30.0F);
      localObject2 = bbup.a(parambbwh.c(), f1, 2, parambbob.jdField_c_of_type_JavaLangCharSequence.toString(), parambbob.jdField_a_of_type_Bbue.jdField_a_of_type_JavaUtilList, false, false);
      parambbwh.c().setText((CharSequence)localObject2);
      parambbwh.c().setVisibility(0);
      label740:
      if (parambbob.jdField_a_of_type_JavaUtilList == null) {
        break label1546;
      }
      if (parambbob.jdField_a_of_type_JavaUtilList.size() != 1) {
        break label1119;
      }
      parambbwh.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(0);
      parambbwh.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      localObject2 = parambbwh.a().getResources();
      if (jdField_a_of_type_Int == 0) {
        jdField_a_of_type_Int = ((Resources)localObject2).getDisplayMetrics().widthPixels;
      }
      localObject1 = parambbwh.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView;
      ((SquareImageView)localObject1).setImageScale((float)(1.0D / parambbob.jdField_a_of_type_Double), 0.0F);
      f1 = ((Resources)localObject2).getDimension(2131298304);
      float f2 = ((Resources)localObject2).getDimension(2131298304);
      i = bggq.a(parambbwh.a().getContext(), 2.0F);
      j = parambbwh.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount();
      j = (int)(jdField_a_of_type_Int - f1 - f2 - (j - 1) * i) / j;
      i = (int)(j * parambbob.jdField_b_of_type_Double);
      j = (int)(j * parambbob.jdField_b_of_type_Double);
      ((SquareImageView)localObject1).setLayoutParams(new FrameLayout.LayoutParams(i, j));
      parambbob = (bbna)parambbob.jdField_a_of_type_JavaUtilList.get(0);
      localObject2 = parambbob.jdField_a_of_type_JavaLangString;
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
      if (parambbob.jdField_a_of_type_Int != 2) {
        break label1109;
      }
      parambbwh.jdField_d_of_type_AndroidWidgetImageView.setVisibility(0);
    }
    for (;;)
    {
      return;
      parambbwh.a().setTextColor(Color.parseColor("#262626"));
      parambbwh.c().setTextColor(Color.parseColor("#737373"));
      parambbwh.b().setTextColor(Color.parseColor("#737373"));
      break;
      label1085:
      parambbwh.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      break label496;
      label1097:
      parambbwh.c().setVisibility(8);
      break label740;
      label1109:
      parambbwh.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
      return;
      label1119:
      parambbwh.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(8);
      parambbwh.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      int m = parambbwh.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount();
      i = 0;
      j = i;
      if (i < parambbob.jdField_a_of_type_JavaUtilList.size())
      {
        j = i;
        if (i < m)
        {
          localObject3 = parambbwh.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(i);
          ((View)localObject3).setVisibility(0);
          localObject2 = (SquareImageView)((View)localObject3).findViewById(2131368343);
          localObject3 = (ImageView)((View)localObject3).findViewById(2131369526);
          j = zlx.a((Context)localObject1) / m;
          int k = (int)(j * parambbob.jdField_a_of_type_Double);
          ((SquareImageView)localObject2).setImageScale((float)(1.0D / parambbob.jdField_a_of_type_Double), 0.0F);
          localObject4 = (bbna)parambbob.jdField_a_of_type_JavaUtilList.get(i);
          Object localObject5 = ((bbna)localObject4).jdField_a_of_type_JavaLangString;
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
          if (((bbna)localObject4).jdField_a_of_type_Int == 2)
          {
            ((ImageView)localObject3).setVisibility(0);
            label1379:
            if ((i != m - 1) || (parambbob.jdField_b_of_type_Int <= m)) {
              break label1500;
            }
            ((ImageView)localObject3).setVisibility(8);
            ((SquareImageView)localObject2).setFilterColor(Color.parseColor("#66000000"));
            k = parambbob.jdField_b_of_type_Int - m;
            j = k;
            if (k > 99) {
              j = 99;
            }
            ((SquareImageView)localObject2).setFilterText("+" + j);
            ((SquareImageView)localObject2).setFilterTextSize(bggq.a(((SquareImageView)localObject2).getContext(), 20.0F));
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
        parambbwh.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(j).setVisibility(4);
        j += 1;
      }
    }
    label1546:
    parambbwh.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(8);
    parambbwh.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
  }
  
  private void a(SquareImageView paramSquareImageView, int paramInt1, int paramInt2, String paramString)
  {
    if ((paramSquareImageView == null) || (TextUtils.isEmpty(paramString))) {
      return;
    }
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mFailedDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
    localURLDrawableOptions.mLoadingDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
    paramSquareImageView.getLayoutParams().width = bggq.a(paramSquareImageView.getContext(), paramInt1);
    paramSquareImageView.getLayoutParams().height = bggq.a(paramSquareImageView.getContext(), paramInt2);
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
  
  private void b(bbnx parambbnx, bbwg parambbwg)
  {
    if ((parambbnx == null) || (parambbnx.jdField_a_of_type_Bbny == null) || (parambbwg == null)) {
      if ((parambbwg != null) && (parambbwg.jdField_b_of_type_AndroidWidgetButton != null)) {
        parambbwg.jdField_b_of_type_AndroidWidgetButton.setVisibility(8);
      }
    }
    while (parambbwg.jdField_b_of_type_AndroidWidgetButton == null) {
      return;
    }
    Context localContext = parambbwg.jdField_b_of_type_AndroidWidgetButton.getContext();
    if ((parambbnx.jdField_a_of_type_Bbny.jdField_a_of_type_Int == 1) && (!TextUtils.isEmpty(parambbnx.jdField_a_of_type_Bbny.jdField_a_of_type_JavaLangCharSequence)))
    {
      parambbwg.jdField_b_of_type_AndroidWidgetButton.setVisibility(0);
      parambbwg.jdField_b_of_type_AndroidWidgetButton.setText(parambbnx.jdField_a_of_type_Bbny.jdField_a_of_type_JavaLangCharSequence);
      parambbwg.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(new bbra(this, localContext, parambbnx));
      return;
    }
    parambbwg.jdField_b_of_type_AndroidWidgetButton.setVisibility(8);
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
      a(paramSquareImageView, paramImageView, paramTextView, paramInt2, paramInt2, false, paramString1, null, 2130842285, false);
      return;
    case 4: 
      a(paramSquareImageView, paramImageView, paramTextView, paramInt2, paramInt2, false, paramString1, null, 2130842285, false);
      return;
    case 5: 
      a(paramSquareImageView, paramImageView, paramTextView, paramInt2, paramInt2, false, paramString1, null, 0, true);
      return;
    case 6: 
      paramInt1 = bggq.a(paramContext, 62.0F);
      a(paramSquareImageView, paramImageView, paramTextView, bggq.a(paramContext, 100.0F), paramInt1, false, paramString1, null, 2130842285, false);
      return;
    case 7: 
      a(paramSquareImageView, paramImageView, paramTextView, bggq.a(paramContext, 100.0F), bggq.a(paramContext, 62.0F), false, paramString1, paramString2, 0, false);
      return;
    }
    a(paramSquareImageView, paramImageView, paramTextView, bggq.a(paramContext, 100.0F), bggq.a(paramContext, 62.0F), false, paramString1, null, 0, false);
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
  
  public void a(bbnh parambbnh, bbvn parambbvn)
  {
    bbus.a(parambbnh.a(), parambbnh.b(), parambbvn.a(), parambbnh.jdField_a_of_type_Boolean, parambbnh.s, parambbnh.g);
    switch (parambbnh.d())
    {
    }
    for (;;)
    {
      b(parambbnh, parambbvn);
      if (TextUtils.isEmpty(parambbnh.i)) {
        c(parambbnh, parambbvn);
      }
      return;
      a((bbnf)parambbnh, (bbvl)parambbvn);
      continue;
      a((bbob)parambbnh, (bbwh)parambbvn);
      continue;
      a((bbng)parambbnh, (bbvm)parambbvn);
      continue;
      a((bbno)parambbnh, (bbvt)parambbvn);
      continue;
      a((bbnx)parambbnh, (bbwg)parambbvn);
      continue;
      a((bbnu)parambbnh, (bbwe)parambbvn);
      continue;
      a((bbnv)parambbnh, (bbwd)parambbvn);
      continue;
      a((bbnl)parambbnh, (bbvq)parambbvn);
      continue;
      a((bbnj)parambbnh, (bbvo)parambbvn);
      continue;
      a((bbnm)parambbnh, (bbvr)parambbvn);
      continue;
      a((bbnw)parambbnh, (bbwf)parambbvn);
      continue;
      a((bbnt)parambbnh, (bbwb)parambbvn);
      continue;
      a((bbnr)parambbnh, (bbvw)parambbvn);
      continue;
      a((bbns)parambbnh, (bbvy)parambbvn);
      continue;
      a((bbnq)parambbnh, (bbvv)parambbvn);
    }
  }
  
  public void a(bbnh parambbnh, bbvn parambbvn, Bitmap paramBitmap)
  {
    if (parambbvn.b() != null) {
      parambbvn.b().setImageBitmap(paramBitmap);
    }
  }
  
  protected void a(bbnm parambbnm, bbvr parambbvr)
  {
    if ((parambbnm.jdField_a_of_type_JavaUtilArrayList == null) || (parambbnm.jdField_a_of_type_JavaUtilArrayList.size() == 0))
    {
      if (QLog.isColorLevel()) {
        QLog.e("Q.uniteSearch.SearchTemplatePresenter", 2, "bindHorSlidingContainerTemplateView, containerItem.horizontalModelItems is empty");
      }
      return;
    }
    bbiu localbbiu2 = (bbiu)parambbvr.jdField_a_of_type_ComTencentWidgetHorizontalListView.getAdapter();
    bbiu localbbiu1;
    if (localbbiu2 != null)
    {
      localbbiu1 = localbbiu2;
      if (localbbiu2.a() == parambbnm.jdField_a_of_type_JavaUtilArrayList) {}
    }
    else
    {
      localbbiu1 = new bbiu(parambbnm, this.jdField_a_of_type_Bbir.jdField_b_of_type_Int, parambbvr.jdField_a_of_type_ComTencentWidgetHorizontalListView);
      parambbvr.jdField_a_of_type_ComTencentWidgetHorizontalListView.setAdapter(localbbiu1);
    }
    if (localbbiu1.a() != parambbnm.jdField_a_of_type_JavaUtilArrayList)
    {
      parambbvr.jdField_a_of_type_Bbnm = parambbnm;
      parambbvr.jdField_a_of_type_ComTencentWidgetHorizontalListView.resetCurrentX(parambbnm.jdField_b_of_type_Int);
    }
    localbbiu1.a(parambbnm.jdField_a_of_type_JavaUtilArrayList);
  }
  
  protected void a(bbno parambbno, bbvt parambbvt)
  {
    parambbvt.a().getContext();
    parambbvt.a();
    if ((parambbno.jdField_a_of_type_JavaUtilArrayList == null) || (parambbno.jdField_a_of_type_JavaUtilArrayList.size() == 0)) {
      if (QLog.isColorLevel()) {
        QLog.e("Q.uniteSearch.SearchTemplatePresenter", 2, "bindHorizontalContainerTemplateView, containerItem.horizontalModelItems is empty");
      }
    }
    for (;;)
    {
      return;
      parambbvt.a(parambbno);
      if (parambbno.jdField_a_of_type_JavaUtilArrayList.size() != parambbvt.jdField_a_of_type_JavaUtilArrayList.size()) {
        QLog.e("Q.uniteSearch.SearchTemplatePresenter", 2, "bindHorizontalContainerTemplateView, view.size != model.size");
      }
      int j = parambbno.jdField_a_of_type_JavaUtilArrayList.size();
      int i = 0;
      while (i < j)
      {
        ((bbnn)parambbno.jdField_a_of_type_JavaUtilArrayList.get(i)).a((bbvs)parambbvt.jdField_a_of_type_JavaUtilArrayList.get(i));
        i += 1;
      }
    }
  }
  
  protected void a(bbnq parambbnq, bbvv parambbvv)
  {
    Object localObject2 = (LinearLayout)parambbvv.b();
    Object localObject1;
    Object localObject3;
    bbvj localbbvj;
    if ((localObject2 != null) && (parambbnq.a != null))
    {
      ((LinearLayout)localObject2).removeAllViews();
      if (((LinearLayout)localObject2).getParent() != null) {
        ((View)((LinearLayout)localObject2).getParent()).setPadding(0, 0, 0, 0);
      }
      localObject1 = parambbnq.a;
      parambbnq = parambbvv.a().getContext();
      localObject3 = LayoutInflater.from(parambbnq).inflate(2131562849, null);
      localbbvj = new bbvj((View)localObject3);
      Object localObject4 = ((View)localObject3).findViewById(2131368791);
      int i = bgtn.a(6.0F);
      ((View)localObject4).setPadding(0, i, 0, i);
      ((LinearLayout)localObject2).addView((View)localObject3);
      if (((bbnd)localObject1).c() != null) {
        break label559;
      }
      if (localbbvj.c() != null) {
        localbbvj.c().setVisibility(8);
      }
      if (localbbvj.a() != null) {
        localbbvj.a().setVisibility(8);
      }
      localObject2 = localbbvj.a();
      if (localObject2 != null) {
        ((URLImageView)localObject2).setVisibility(8);
      }
      localObject2 = localbbvj.e();
      if (localObject2 != null)
      {
        ((TextView)localObject2).setVisibility(0);
        if (!TextUtils.isEmpty(((bbnd)localObject1).a())) {
          ((TextView)localObject2).setText(((bbnd)localObject1).a());
        }
      }
      if ((localbbvj.b() != null) && (!TextUtils.isEmpty(((bbnd)localObject1).g())))
      {
        localObject2 = ((bbnd)localObject1).g();
        localObject3 = new ColorDrawable(Color.parseColor("#e7e7e7"));
        localObject4 = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject4).mRequestWidth = bggq.a(parambbnq, 50.0F);
        ((URLDrawable.URLDrawableOptions)localObject4).mRequestHeight = bggq.a(parambbnq, 50.0F);
        ((URLDrawable.URLDrawableOptions)localObject4).mFailedDrawable = ((Drawable)localObject3);
        ((URLDrawable.URLDrawableOptions)localObject4).mLoadingDrawable = ((Drawable)localObject3);
        if (!bkgj.a((String)localObject2)) {
          break label684;
        }
        localObject2 = URLDrawable.getDrawable((String)localObject2, (URLDrawable.URLDrawableOptions)localObject4);
        ((URLDrawable)localObject2).setTag(bgey.b(bggq.a(parambbnq, 50.0F), bggq.a(parambbvv.a().getContext(), 50.0F), bggq.a(parambbnq, 3.0F)));
        ((URLDrawable)localObject2).setDecodeHandler(bgey.j);
        localbbvj.b().setImageDrawable((Drawable)localObject2);
        if ((((URLDrawable)localObject2).getStatus() != 1) && (((URLDrawable)localObject2).getStatus() != 0)) {
          ((URLDrawable)localObject2).restartDownload();
        }
      }
    }
    for (;;)
    {
      localbbvj.a().setOnClickListener(new bbqt(this, (bbnd)localObject1));
      if ((localbbvj.a() != null) && (((bbnd)localObject1).c()))
      {
        parambbvv = ((bbnd)localObject1).h();
        localObject1 = new ColorDrawable(Color.parseColor("#e7e7e7"));
        localObject2 = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject2).mRequestWidth = bggq.a(parambbnq, 40.0F);
        ((URLDrawable.URLDrawableOptions)localObject2).mRequestHeight = bggq.a(parambbnq, 12.0F);
        ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = ((Drawable)localObject1);
        ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = ((Drawable)localObject1);
        parambbvv = URLDrawable.getDrawable(parambbvv, (URLDrawable.URLDrawableOptions)localObject2);
        parambbvv.setTag(bgey.b(bggq.a(parambbnq, 38.0F), bggq.a(parambbnq, 12.0F), 0));
        parambbvv.setDecodeHandler(bgey.j);
        localbbvj.a().setImageDrawable(parambbvv);
        if ((parambbvv.getStatus() != 1) && (parambbvv.getStatus() != 0)) {
          parambbvv.restartDownload();
        }
      }
      return;
      label559:
      if ((localbbvj.c() != null) && (!TextUtils.isEmpty(((bbnd)localObject1).c())))
      {
        localbbvj.c().setVisibility(0);
        localbbvj.c().setText(((bbnd)localObject1).c());
      }
      for (;;)
      {
        if (localbbvj.a() != null) {
          localbbvj.a().setVisibility(0);
        }
        localObject2 = localbbvj.e();
        if (localObject2 != null) {
          ((TextView)localObject2).setVisibility(8);
        }
        if (TextUtils.isEmpty(((bbnd)localObject1).a())) {
          break;
        }
        localbbvj.a().setText(((bbnd)localObject1).a());
        break;
        if (localbbvj.c() != null) {
          localbbvj.c().setVisibility(8);
        }
      }
      label684:
      localbbvj.b().setImageDrawable((Drawable)localObject3);
    }
  }
  
  protected void a(bbnt parambbnt, bbwb parambbwb)
  {
    Object localObject1 = parambbwb.a().getContext();
    if (ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null))
    {
      parambbwb.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#737373"));
      parambbwb.jdField_b_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#4A4A4A"));
      if (TextUtils.isEmpty(parambbnt.jdField_b_of_type_JavaLangString)) {
        break label290;
      }
      Object localObject2 = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
      ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
      ((URLDrawable.URLDrawableOptions)localObject2).mRequestWidth = bggq.a((Context)localObject1, 18.0F);
      ((URLDrawable.URLDrawableOptions)localObject2).mRequestHeight = bggq.a((Context)localObject1, 18.0F);
      ((URLDrawable.URLDrawableOptions)localObject2).mMemoryCacheKeySuffix = "askIcon";
      localObject2 = URLDrawable.getDrawable(parambbnt.jdField_b_of_type_JavaLangString, (URLDrawable.URLDrawableOptions)localObject2);
      parambbwb.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable((Drawable)localObject2);
      if ((((URLDrawable)localObject2).getStatus() != 1) && (((URLDrawable)localObject2).getStatus() != 0)) {
        ((URLDrawable)localObject2).restartDownload();
      }
      parambbwb.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(0);
    }
    label290:
    for (;;)
    {
      label166:
      if (!TextUtils.isEmpty(parambbnt.j))
      {
        int j = parambbwb.jdField_a_of_type_AndroidWidgetTextView.getContext().getResources().getDisplayMetrics().widthPixels;
        int i = (int)bbup.a(parambbwb.jdField_a_of_type_AndroidWidgetTextView, " ");
        int k = bggq.a((Context)localObject1, 22.0F) / i;
        localObject1 = "";
        i = 0;
        for (;;)
        {
          if (i < k)
          {
            localObject1 = (String)localObject1 + " ";
            i += 1;
            continue;
            parambbwb.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#262626"));
            parambbwb.jdField_b_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#737373"));
            break;
            parambbwb.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(8);
            break label166;
          }
        }
        localObject1 = bbup.a(parambbwb.jdField_a_of_type_AndroidWidgetTextView, j, 2, (String)localObject1 + parambbnt.j, parambbnt.jdField_a_of_type_Bbue.jdField_a_of_type_JavaUtilList, false, false, true);
        parambbwb.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject1);
      }
    }
    parambbwb.a(parambbnt);
    if ((!TextUtils.isEmpty(parambbnt.k)) && (parambbnt.jdField_a_of_type_JavaUtilList != null) && (parambbnt.jdField_a_of_type_JavaUtilList.size() != 0))
    {
      parambbwb.jdField_b_of_type_AndroidWidgetTextView.setText(parambbnt.k);
      parambbwb.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      return;
    }
    parambbwb.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
  }
  
  protected void a(bbnw parambbnw, bbwf parambbwf)
  {
    if (!TextUtils.isEmpty(parambbnw.jdField_b_of_type_JavaLangString))
    {
      parambbwf.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(0);
      Object localObject = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
      ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
      ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = parambbwf.jdField_a_of_type_ComTencentImageURLImageView.getLayoutParams().width;
      ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = parambbwf.jdField_a_of_type_ComTencentImageURLImageView.getLayoutParams().height;
      localObject = URLDrawable.getDrawable(parambbnw.jdField_b_of_type_JavaLangString, (URLDrawable.URLDrawableOptions)localObject);
      parambbwf.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable((Drawable)localObject);
      if ((((URLDrawable)localObject).getStatus() != 1) && (((URLDrawable)localObject).getStatus() != 0)) {
        ((URLDrawable)localObject).restartDownload();
      }
      if (TextUtils.isEmpty(parambbnw.j)) {
        break label345;
      }
      parambbwf.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      int i = parambbwf.jdField_a_of_type_AndroidWidgetTextView.getContext().getResources().getDisplayMetrics().widthPixels;
      localObject = bbup.a(parambbwf.jdField_a_of_type_AndroidWidgetTextView, i, 1, parambbnw.j, parambbnw.jdField_a_of_type_Bbue.jdField_a_of_type_JavaUtilList, false, false, true);
      parambbwf.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
      label183:
      if (TextUtils.isEmpty(parambbnw.l)) {
        break label357;
      }
      parambbwf.jdField_b_of_type_AndroidWidgetTextView.setText(parambbnw.l);
      parambbwf.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      parambbwf.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      label220:
      if (TextUtils.isEmpty(parambbnw.k)) {
        break label378;
      }
      parambbwf.c.setText(parambbnw.k);
      parambbwf.c.setVisibility(0);
    }
    for (;;)
    {
      if (!ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null)) {
        break label390;
      }
      parambbwf.jdField_a_of_type_AndroidWidgetTextView.setTextColor(parambbwf.jdField_a_of_type_AndroidWidgetTextView.getContext().getResources().getColor(2131166922));
      parambbwf.c.setTextColor(parambbwf.c.getContext().getResources().getColor(2131166921));
      parambbwf.jdField_b_of_type_AndroidWidgetTextView.setTextColor(parambbwf.jdField_b_of_type_AndroidWidgetTextView.getContext().getResources().getColor(2131166921));
      return;
      parambbwf.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(8);
      break;
      label345:
      parambbwf.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      break label183;
      label357:
      parambbwf.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      parambbwf.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      break label220;
      label378:
      parambbwf.c.setVisibility(8);
    }
    label390:
    parambbwf.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#262626"));
    parambbwf.c.setTextColor(Color.parseColor("#737373"));
    parambbwf.jdField_b_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#737373"));
  }
  
  public void a(SquareImageView paramSquareImageView, ImageView paramImageView, TextView paramTextView, int paramInt1, int paramInt2, boolean paramBoolean1, String paramString1, String paramString2, int paramInt3, boolean paramBoolean2)
  {
    ViewGroup.LayoutParams localLayoutParams = paramSquareImageView.getLayoutParams();
    if ((paramSquareImageView.getContext() instanceof PublicAcntSearchActivity))
    {
      localLayoutParams.width = bggq.a(paramSquareImageView.getContext(), 50.0F);
      localLayoutParams.height = bggq.a(paramSquareImageView.getContext(), 50.0F);
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
          paramTextView.setDecodeHandler(bgey.a);
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
  
  protected void b(bbnh parambbnh, bbvn parambbvn)
  {
    if (parambbvn.a() != null) {
      parambbvn.a().setOnClickListener(new bbqs(this, parambbnh));
    }
  }
  
  public void c(bbnh parambbnh, bbvn parambbvn)
  {
    if ((parambbvn.b() != null) && ((parambbnh instanceof bbmv)) && (!TextUtils.isEmpty(parambbnh.b()))) {
      parambbvn.b().setImageDrawable(bbup.a(this.jdField_a_of_type_Aobu, parambbnh));
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
      bbup.jdField_a_of_type_Long = this.jdField_a_of_type_Long;
      localImageView.post(new SearchTemplatePresenter.11(this, localImageView, bool));
      localImageView.setContentDescription(localResources.getString(2131690158));
      this.jdField_a_of_type_Bbir.notifyDataSetChanged();
      return;
    }
    localImageView.post(new SearchTemplatePresenter.12(this, localImageView, bool));
    localImageView.setContentDescription(localResources.getString(2131690156));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbqr
 * JD-Core Version:    0.7.0.1
 */