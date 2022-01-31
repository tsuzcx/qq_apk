import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emoticonview.EmoticonPanelLinearLayout;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView.LayoutParams;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;

public class ankw
  extends anju
  implements Handler.Callback
{
  private MqqHandler a;
  List<ProgressBar> d;
  
  public ankw(QQAppInterface paramQQAppInterface, Context paramContext, int paramInt1, int paramInt2, int paramInt3, anhs paramanhs)
  {
    super(paramQQAppInterface, paramContext, paramInt1, paramInt2, paramInt3, paramanhs);
    this.jdField_a_of_type_MqqOsMqqHandler = new beez(Looper.getMainLooper(), this, true);
    this.jdField_d_of_type_JavaUtilList = new ArrayList();
  }
  
  private ProgressBar a(EmoticonPackage paramEmoticonPackage)
  {
    if ((paramEmoticonPackage == null) || (TextUtils.isEmpty(paramEmoticonPackage.epId))) {}
    while ((this.jdField_d_of_type_JavaUtilList == null) || (this.jdField_d_of_type_JavaUtilList.size() <= 0)) {
      return null;
    }
    Iterator localIterator = this.jdField_d_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      ProgressBar localProgressBar = (ProgressBar)localIterator.next();
      Object localObject = localProgressBar.getTag();
      if ((localObject instanceof String)) {}
      for (localObject = (String)localObject; (!TextUtils.isEmpty((CharSequence)localObject)) && (paramEmoticonPackage.epId.equals(localObject)); localObject = null) {
        return localProgressBar;
      }
    }
  }
  
  private void a(URLImageView paramURLImageView, anla paramanla)
  {
    if ((paramURLImageView == null) || (paramanla == null))
    {
      QLog.e("MagicFaceAdapter", 1, "updateImageView view or info = null");
      return;
    }
    Object localObject = (RelativeLayout.LayoutParams)paramURLImageView.getLayoutParams();
    if ("push".equals(paramanla.h))
    {
      ((RelativeLayout.LayoutParams)localObject).width = ((int)(this.jdField_a_of_type_Float * 63.0F));
      ((RelativeLayout.LayoutParams)localObject).height = ((int)(this.jdField_a_of_type_Float * 63.0F));
      if (QLog.isColorLevel()) {
        QLog.d("MagicFaceAdapter", 2, "show push_btn drawable.");
      }
      paramanla = this.jdField_a_of_type_AndroidContentContext.getSharedPreferences("mobileQQ", 0);
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
      boolean bool = paramanla.getBoolean("magic_promotion_is_new_content_" + (String)localObject, false);
      localObject = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130846017);
      if (bool)
      {
        paramanla = paramanla.getString("magic_promotion_gifUrl", "");
        ((URLDrawable.URLDrawableOptions)localObject).mPlayGifImage = true;
        if (TextUtils.isEmpty(paramanla)) {
          break label241;
        }
      }
      for (;;)
      {
        try
        {
          paramURLImageView.setImageDrawable(URLDrawable.getDrawable(paramanla, (URLDrawable.URLDrawableOptions)localObject));
          if (!AppSetting.c) {
            break;
          }
          paramURLImageView.setContentDescription(ajjy.a(2131640627));
          return;
          paramanla = paramanla.getString("magic_promotion_imgUrl", "");
        }
        catch (IllegalArgumentException paramanla)
        {
          if (QLog.isColorLevel()) {
            QLog.w("MagicFaceAdapter", 2, paramanla.getMessage());
          }
          paramURLImageView.setImageDrawable(null);
          continue;
        }
        label241:
        paramURLImageView.setImageDrawable(null);
      }
    }
    Emoticon localEmoticon = paramanla.a;
    if ((localEmoticon == null) || (TextUtils.isEmpty(localEmoticon.epId)))
    {
      QLog.e("MagicFaceAdapter", 1, "updateImageView emotion is null or epid is null");
      return;
    }
    EmoticonPackage localEmoticonPackage = ((arnz)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(14)).a(localEmoticon.epId);
    String str = localEmoticon.epId + "_" + localEmoticon.eId;
    localObject = str;
    if (localEmoticonPackage != null) {
      if (localEmoticonPackage.valid)
      {
        localObject = str;
        if (2 == localEmoticonPackage.status) {}
      }
      else
      {
        localObject = str;
        if (!paramanla.b) {
          localObject = str + "_panel_magic_gray";
        }
      }
    }
    try
    {
      paramanla = new URL("emotion_pic", "fromPanel", (String)localObject);
      if (paramanla != null)
      {
        localObject = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130837700);
        ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130843059);
        paramanla = URLDrawable.getDrawable(paramanla, (URLDrawable.URLDrawableOptions)localObject);
        paramanla.setTag(localEmoticon);
        paramanla.addHeader("my_uin", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
        if (paramanla != null)
        {
          paramURLImageView.setImageDrawable(paramanla);
          paramURLImageView.setBackgroundDrawable(null);
          return;
        }
      }
    }
    catch (MalformedURLException paramanla)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("MagicFaceAdapter", 2, "updateImageView ,", paramanla);
        }
        paramanla = null;
        continue;
        paramURLImageView.setVisibility(4);
        continue;
        paramanla = null;
      }
    }
  }
  
  private RelativeLayout b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MagicFaceAdapter", 2, "getMagicView");
    }
    RelativeLayout localRelativeLayout = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
    localRelativeLayout.setLayoutParams(new LinearLayout.LayoutParams(this.jdField_d_of_type_Int / this.jdField_a_of_type_Int, (int)(72.0F * this.jdField_a_of_type_Float)));
    Object localObject = new URLImageView(this.jdField_a_of_type_AndroidContentContext);
    ((URLImageView)localObject).setId(2131300003);
    RelativeLayout.LayoutParams localLayoutParams1 = new RelativeLayout.LayoutParams((int)(56.0F * this.jdField_a_of_type_Float), (int)(56.0F * this.jdField_a_of_type_Float));
    localLayoutParams1.addRule(10, -1);
    localLayoutParams1.addRule(14, -1);
    ((URLImageView)localObject).setScaleType(ImageView.ScaleType.FIT_XY);
    ((URLImageView)localObject).setAdjustViewBounds(false);
    ((URLImageView)localObject).setLayoutParams(localLayoutParams1);
    localRelativeLayout.addView((View)localObject);
    localObject = new TextView(this.jdField_a_of_type_AndroidContentContext);
    ((TextView)localObject).setVisibility(8);
    ((TextView)localObject).setId(2131300008);
    ((TextView)localObject).setTextSize(11.0F);
    localLayoutParams1 = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams1.addRule(3, 2131300003);
    localLayoutParams1.topMargin = ((int)(5.0F * this.jdField_a_of_type_Float));
    localLayoutParams1.addRule(14, -1);
    localRelativeLayout.addView((View)localObject, localLayoutParams1);
    localObject = new ImageView(this.jdField_a_of_type_AndroidContentContext);
    ((ImageView)localObject).setVisibility(8);
    ((ImageView)localObject).setId(2131300009);
    localLayoutParams1 = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams1.addRule(8, 2131300003);
    localLayoutParams1.addRule(7, 2131300003);
    localRelativeLayout.addView((View)localObject, localLayoutParams1);
    localObject = new ImageView(this.jdField_a_of_type_AndroidContentContext);
    ((ImageView)localObject).setId(2131300010);
    localLayoutParams1 = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams1.addRule(5, 2131300003);
    localLayoutParams1.addRule(6, 2131300003);
    ProgressBar localProgressBar = new ProgressBar(this.jdField_a_of_type_AndroidContentContext);
    localProgressBar.setVisibility(8);
    localProgressBar.setId(2131300007);
    localProgressBar.setIndeterminateDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130839113));
    RelativeLayout.LayoutParams localLayoutParams2 = new RelativeLayout.LayoutParams((int)(16.0F * this.jdField_a_of_type_Float), (int)(16.0F * this.jdField_a_of_type_Float));
    localLayoutParams2.addRule(14, -1);
    localLayoutParams2.topMargin = ((int)(20.0F * this.jdField_a_of_type_Float));
    localRelativeLayout.addView(localProgressBar, localLayoutParams2);
    localRelativeLayout.addView((View)localObject, localLayoutParams1);
    if (AppSetting.c) {
      localRelativeLayout.setFocusable(true);
    }
    return localRelativeLayout;
  }
  
  private void b(View paramView, anjy paramanjy)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MagicFaceAdapter", 2, "updateUI");
    }
    if ((paramView == null) || (paramanjy == null)) {
      return;
    }
    if ((paramanjy instanceof anht)) {}
    for (paramanjy = (anla)paramanjy;; paramanjy = null)
    {
      if (paramanjy == null)
      {
        QLog.e("MagicFaceAdapter", 1, "updateUI emotionInfo = null");
        return;
      }
      paramView.setVisibility(0);
      paramView.setTag(paramanjy);
      Object localObject1 = (URLImageView)paramView.findViewById(2131300003);
      ((URLImageView)localObject1).setVisibility(0);
      a((URLImageView)localObject1, paramanjy);
      Object localObject2 = (TextView)paramView.findViewById(2131300008);
      ImageView localImageView = (ImageView)paramView.findViewById(2131300010);
      localObject1 = (ImageView)paramView.findViewById(2131300009);
      paramView = (ProgressBar)paramView.findViewById(2131300007);
      if ("push".equals(paramanjy.h))
      {
        ((TextView)localObject2).setVisibility(8);
        localImageView.setVisibility(8);
        ((ImageView)localObject1).setVisibility(8);
        paramView.setVisibility(8);
        return;
      }
      paramanjy = paramanjy.a;
      if ((paramanjy == null) || (TextUtils.isEmpty(paramanjy.epId)))
      {
        QLog.e("MagicFaceAdapter", 1, "updateUI emotion is null or epid is null");
        return;
      }
      String str = paramanjy.name;
      if (!TextUtils.isEmpty(str))
      {
        ((TextView)localObject2).setVisibility(0);
        if (str.length() > 5)
        {
          ((TextView)localObject2).setText(str.substring(0, 4) + "...");
          if (AppSetting.c) {
            ((TextView)localObject2).setContentDescription(str);
          }
          label274:
          localImageView.setVisibility(8);
          ((ImageView)localObject1).setVisibility(8);
          localObject2 = ((arnz)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(14)).a(paramanjy.epId);
          if ((localObject2 != null) && (!((EmoticonPackage)localObject2).valid))
          {
            ((ImageView)localObject1).setImageResource(2130846026);
            ((ImageView)localObject1).setVisibility(0);
          }
          paramView.setVisibility(8);
          paramView.setTag(paramanjy.epId);
          if (!this.jdField_d_of_type_JavaUtilList.contains(paramView)) {
            this.jdField_d_of_type_JavaUtilList.add(paramView);
          }
          if (((anfj)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(43)).a(paramanjy.epId) < 0.0F) {
            break label430;
          }
        }
      }
      label430:
      for (int i = 1;; i = 0)
      {
        if (i == 0) {
          break label435;
        }
        paramView.setVisibility(0);
        return;
        ((TextView)localObject2).setText(str);
        break;
        ((TextView)localObject2).setVisibility(8);
        break label274;
      }
      label435:
      paramView.setVisibility(8);
      return;
    }
  }
  
  public View a(angv paramangv, int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    int j = 0;
    paramViewGroup = (anky)paramangv;
    int i;
    if (paramView == null)
    {
      paramView = ankg.a().a(this.c);
      if (paramView == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("MagicFaceAdapter", 2, "getEmotionView position = " + paramInt + ";view from infalter");
        }
        paramView = new EmoticonPanelLinearLayout(this.jdField_a_of_type_AndroidContentContext);
        paramView.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
        paramView.setOrientation(0);
        if (paramInt == 0) {
          paramView.setPadding(0, (int)(16.0F * this.jdField_a_of_type_Float), 0, 0);
        }
        for (;;)
        {
          i = 0;
          for (;;)
          {
            paramangv = paramView;
            if (i >= this.jdField_a_of_type_Int) {
              break;
            }
            paramangv = b();
            LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(this.jdField_d_of_type_Int / this.jdField_a_of_type_Int, -1);
            paramangv.setGravity(17);
            paramangv.setVisibility(8);
            paramangv.setLayoutParams(localLayoutParams);
            paramangv.setFocusable(true);
            paramangv.setFocusableInTouchMode(true);
            paramView.addView(paramangv);
            i += 1;
          }
          paramView.setPadding(0, (int)(14.0F * this.jdField_a_of_type_Float), 0, 0);
        }
      }
      paramangv = paramView;
      if (QLog.isColorLevel())
      {
        QLog.d("MagicFaceAdapter", 2, "getEmotionView position = " + paramInt + ";view from cache");
        paramangv = paramView;
      }
      ((EmoticonPanelLinearLayout)paramangv).setCallBack(this.jdField_a_of_type_Anhs);
      a(this.c, paramangv);
      paramView = (ViewGroup)paramangv;
      paramViewGroup.a = new RelativeLayout[this.jdField_a_of_type_Int];
      i = 0;
      while (i < this.jdField_a_of_type_Int)
      {
        paramViewGroup.a[i] = ((RelativeLayout)paramView.getChildAt(i));
        i += 1;
      }
      paramangv.setTag(paramViewGroup);
      i = j;
    }
    for (;;)
    {
      try
      {
        if (i < this.jdField_a_of_type_Int)
        {
          j = this.jdField_a_of_type_Int * paramInt + i;
          if (j > this.jdField_a_of_type_JavaUtilList.size() - 1)
          {
            paramViewGroup.a[i].setTag(null);
            paramViewGroup.a[i].setVisibility(8);
          }
          else
          {
            b(paramViewGroup.a[i], (anjy)this.jdField_a_of_type_JavaUtilList.get(j));
          }
        }
      }
      catch (OutOfMemoryError paramView)
      {
        QLog.e("MagicFaceAdapter", 1, "updateUI oom");
      }
      return paramangv;
      paramangv = paramView;
      i = j;
      continue;
      i += 1;
    }
  }
  
  public angv a()
  {
    return new anky();
  }
  
  public void a(EmoticonPackage paramEmoticonPackage, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MagicFaceAdapter", 2, "packageDownloadEnd");
    }
    if (paramEmoticonPackage == null) {
      return;
    }
    Message localMessage = Message.obtain();
    localMessage.what = 101;
    localMessage.arg1 = paramInt;
    localMessage.obj = paramEmoticonPackage;
    this.jdField_a_of_type_MqqOsMqqHandler.sendMessage(localMessage);
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MagicFaceAdapter", 2, "refreshPanelData");
    }
    anjz.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.c, null, -1, 0, false, new ankx(this));
  }
  
  public void b(EmoticonPackage paramEmoticonPackage)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MagicFaceAdapter", 2, "packageDownloadStart");
    }
    if (paramEmoticonPackage == null) {
      return;
    }
    Message localMessage = Message.obtain();
    localMessage.what = 100;
    localMessage.obj = paramEmoticonPackage;
    this.jdField_a_of_type_MqqOsMqqHandler.sendMessage(localMessage);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return true;
      paramMessage = a((EmoticonPackage)paramMessage.obj);
      if (paramMessage != null)
      {
        paramMessage.setVisibility(0);
        continue;
        ProgressBar localProgressBar = a((EmoticonPackage)paramMessage.obj);
        int i = paramMessage.arg1;
        if (localProgressBar != null)
        {
          localProgressBar.setVisibility(8);
          if (i == 0) {
            b();
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ankw
 * JD-Core Version:    0.7.0.1
 */