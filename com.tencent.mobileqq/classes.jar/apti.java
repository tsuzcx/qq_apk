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

public class apti
  extends apsf
  implements Handler.Callback
{
  private MqqHandler a;
  List<ProgressBar> d;
  
  public apti(QQAppInterface paramQQAppInterface, Context paramContext, int paramInt1, int paramInt2, int paramInt3, appt paramappt)
  {
    super(paramQQAppInterface, paramContext, paramInt1, paramInt2, paramInt3, paramappt);
    this.jdField_a_of_type_MqqOsMqqHandler = new bhoe(Looper.getMainLooper(), this, true);
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
  
  private void a(URLImageView paramURLImageView, aptm paramaptm)
  {
    if ((paramURLImageView == null) || (paramaptm == null))
    {
      QLog.e("MagicFaceAdapter", 1, "updateImageView view or info = null");
      return;
    }
    Object localObject = (RelativeLayout.LayoutParams)paramURLImageView.getLayoutParams();
    if ("push".equals(paramaptm.i))
    {
      ((RelativeLayout.LayoutParams)localObject).width = ((int)(this.jdField_a_of_type_Float * 63.0F));
      ((RelativeLayout.LayoutParams)localObject).height = ((int)(this.jdField_a_of_type_Float * 63.0F));
      if (QLog.isColorLevel()) {
        QLog.d("MagicFaceAdapter", 2, "show push_btn drawable.");
      }
      paramaptm = this.jdField_a_of_type_AndroidContentContext.getSharedPreferences("mobileQQ", 0);
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
      boolean bool = paramaptm.getBoolean("magic_promotion_is_new_content_" + (String)localObject, false);
      localObject = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130846583);
      if (bool)
      {
        paramaptm = paramaptm.getString("magic_promotion_gifUrl", "");
        ((URLDrawable.URLDrawableOptions)localObject).mPlayGifImage = true;
        if (TextUtils.isEmpty(paramaptm)) {
          break label241;
        }
      }
      for (;;)
      {
        try
        {
          paramURLImageView.setImageDrawable(URLDrawable.getDrawable(paramaptm, (URLDrawable.URLDrawableOptions)localObject));
          if (!AppSetting.c) {
            break;
          }
          paramURLImageView.setContentDescription(alpo.a(2131706795));
          return;
          paramaptm = paramaptm.getString("magic_promotion_imgUrl", "");
        }
        catch (IllegalArgumentException paramaptm)
        {
          if (QLog.isColorLevel()) {
            QLog.w("MagicFaceAdapter", 2, paramaptm.getMessage());
          }
          paramURLImageView.setImageDrawable(null);
          continue;
        }
        label241:
        paramURLImageView.setImageDrawable(null);
      }
    }
    Emoticon localEmoticon = paramaptm.a;
    if ((localEmoticon == null) || (TextUtils.isEmpty(localEmoticon.epId)))
    {
      QLog.e("MagicFaceAdapter", 1, "updateImageView emotion is null or epid is null");
      return;
    }
    EmoticonPackage localEmoticonPackage = ((aube)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(14)).a(localEmoticon.epId);
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
        if (!paramaptm.b) {
          localObject = str + "_panel_magic_gray";
        }
      }
    }
    try
    {
      paramaptm = new URL("emotion_pic", "fromPanel", (String)localObject);
      if (paramaptm != null)
      {
        localObject = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130837906);
        ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130843327);
        paramaptm = URLDrawable.getDrawable(paramaptm, (URLDrawable.URLDrawableOptions)localObject);
        paramaptm.setTag(localEmoticon);
        paramaptm.addHeader("my_uin", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
        if (paramaptm != null)
        {
          paramURLImageView.setImageDrawable(paramaptm);
          paramURLImageView.setBackgroundDrawable(null);
          return;
        }
      }
    }
    catch (MalformedURLException paramaptm)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("MagicFaceAdapter", 2, "updateImageView ,", paramaptm);
        }
        paramaptm = null;
        continue;
        paramURLImageView.setVisibility(4);
        continue;
        paramaptm = null;
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
    ((URLImageView)localObject).setId(2131365666);
    RelativeLayout.LayoutParams localLayoutParams1 = new RelativeLayout.LayoutParams((int)(56.0F * this.jdField_a_of_type_Float), (int)(56.0F * this.jdField_a_of_type_Float));
    localLayoutParams1.addRule(10, -1);
    localLayoutParams1.addRule(14, -1);
    ((URLImageView)localObject).setScaleType(ImageView.ScaleType.FIT_XY);
    ((URLImageView)localObject).setAdjustViewBounds(false);
    ((URLImageView)localObject).setLayoutParams(localLayoutParams1);
    localRelativeLayout.addView((View)localObject);
    localObject = new TextView(this.jdField_a_of_type_AndroidContentContext);
    ((TextView)localObject).setVisibility(8);
    ((TextView)localObject).setId(2131365671);
    ((TextView)localObject).setTextSize(11.0F);
    localLayoutParams1 = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams1.addRule(3, 2131365666);
    localLayoutParams1.topMargin = ((int)(5.0F * this.jdField_a_of_type_Float));
    localLayoutParams1.addRule(14, -1);
    localRelativeLayout.addView((View)localObject, localLayoutParams1);
    localObject = new ImageView(this.jdField_a_of_type_AndroidContentContext);
    ((ImageView)localObject).setVisibility(8);
    ((ImageView)localObject).setId(2131365672);
    localLayoutParams1 = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams1.addRule(8, 2131365666);
    localLayoutParams1.addRule(7, 2131365666);
    localRelativeLayout.addView((View)localObject, localLayoutParams1);
    localObject = new ImageView(this.jdField_a_of_type_AndroidContentContext);
    ((ImageView)localObject).setId(2131365673);
    localLayoutParams1 = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams1.addRule(5, 2131365666);
    localLayoutParams1.addRule(6, 2131365666);
    ProgressBar localProgressBar = new ProgressBar(this.jdField_a_of_type_AndroidContentContext);
    localProgressBar.setVisibility(8);
    localProgressBar.setId(2131365670);
    localProgressBar.setIndeterminateDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130839224));
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
  
  private void b(View paramView, apsj paramapsj)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MagicFaceAdapter", 2, "updateUI");
    }
    if ((paramView == null) || (paramapsj == null)) {
      return;
    }
    if ((paramapsj instanceof appw)) {}
    for (paramapsj = (aptm)paramapsj;; paramapsj = null)
    {
      if (paramapsj == null)
      {
        QLog.e("MagicFaceAdapter", 1, "updateUI emotionInfo = null");
        return;
      }
      paramView.setVisibility(0);
      paramView.setTag(paramapsj);
      Object localObject1 = (URLImageView)paramView.findViewById(2131365666);
      ((URLImageView)localObject1).setVisibility(0);
      a((URLImageView)localObject1, paramapsj);
      Object localObject2 = (TextView)paramView.findViewById(2131365671);
      ImageView localImageView = (ImageView)paramView.findViewById(2131365673);
      localObject1 = (ImageView)paramView.findViewById(2131365672);
      paramView = (ProgressBar)paramView.findViewById(2131365670);
      if ("push".equals(paramapsj.i))
      {
        ((TextView)localObject2).setVisibility(8);
        localImageView.setVisibility(8);
        ((ImageView)localObject1).setVisibility(8);
        paramView.setVisibility(8);
        return;
      }
      paramapsj = paramapsj.a;
      if ((paramapsj == null) || (TextUtils.isEmpty(paramapsj.epId)))
      {
        QLog.e("MagicFaceAdapter", 1, "updateUI emotion is null or epid is null");
        return;
      }
      String str = paramapsj.name;
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
          localObject2 = ((aube)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(14)).a(paramapsj.epId);
          if ((localObject2 != null) && (!((EmoticonPackage)localObject2).valid))
          {
            ((ImageView)localObject1).setImageResource(2130846592);
            ((ImageView)localObject1).setVisibility(0);
          }
          paramView.setVisibility(8);
          paramView.setTag(paramapsj.epId);
          if (!this.jdField_d_of_type_JavaUtilList.contains(paramView)) {
            this.jdField_d_of_type_JavaUtilList.add(paramView);
          }
          if (((apnf)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(43)).a(paramapsj.epId) < 0.0F) {
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
  
  public View a(apow paramapow, int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    int j = 0;
    paramViewGroup = (aptk)paramapow;
    int i;
    if (paramView == null)
    {
      paramView = apsr.a().a(this.c);
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
            paramapow = paramView;
            if (i >= this.jdField_a_of_type_Int) {
              break;
            }
            paramapow = b();
            LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(this.jdField_d_of_type_Int / this.jdField_a_of_type_Int, -1);
            paramapow.setGravity(17);
            paramapow.setVisibility(8);
            paramapow.setLayoutParams(localLayoutParams);
            paramapow.setFocusable(true);
            paramapow.setFocusableInTouchMode(true);
            paramView.addView(paramapow);
            i += 1;
          }
          paramView.setPadding(0, (int)(14.0F * this.jdField_a_of_type_Float), 0, 0);
        }
      }
      paramapow = paramView;
      if (QLog.isColorLevel())
      {
        QLog.d("MagicFaceAdapter", 2, "getEmotionView position = " + paramInt + ";view from cache");
        paramapow = paramView;
      }
      ((EmoticonPanelLinearLayout)paramapow).setCallBack(this.jdField_a_of_type_Appt);
      a(this.c, paramapow);
      paramView = (ViewGroup)paramapow;
      paramViewGroup.a = new RelativeLayout[this.jdField_a_of_type_Int];
      i = 0;
      while (i < this.jdField_a_of_type_Int)
      {
        paramViewGroup.a[i] = ((RelativeLayout)paramView.getChildAt(i));
        i += 1;
      }
      paramapow.setTag(paramViewGroup);
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
            b(paramViewGroup.a[i], (apsj)this.jdField_a_of_type_JavaUtilList.get(j));
          }
        }
      }
      catch (OutOfMemoryError paramView)
      {
        QLog.e("MagicFaceAdapter", 1, "updateUI oom");
      }
      return paramapow;
      paramapow = paramView;
      i = j;
      continue;
      i += 1;
    }
  }
  
  public apow a()
  {
    return new aptk();
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
    apsk.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.c, null, -1, 0, false, new aptj(this));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apti
 * JD-Core Version:    0.7.0.1
 */