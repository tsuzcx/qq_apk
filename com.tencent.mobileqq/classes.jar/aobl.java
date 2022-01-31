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

public class aobl
  extends aoai
  implements Handler.Callback
{
  private MqqHandler a;
  List<ProgressBar> d;
  
  public aobl(QQAppInterface paramQQAppInterface, Context paramContext, int paramInt1, int paramInt2, int paramInt3, anyg paramanyg)
  {
    super(paramQQAppInterface, paramContext, paramInt1, paramInt2, paramInt3, paramanyg);
    this.jdField_a_of_type_MqqOsMqqHandler = new bfnk(Looper.getMainLooper(), this, true);
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
  
  private void a(URLImageView paramURLImageView, aobp paramaobp)
  {
    if ((paramURLImageView == null) || (paramaobp == null))
    {
      QLog.e("MagicFaceAdapter", 1, "updateImageView view or info = null");
      return;
    }
    Object localObject = (RelativeLayout.LayoutParams)paramURLImageView.getLayoutParams();
    if ("push".equals(paramaobp.h))
    {
      ((RelativeLayout.LayoutParams)localObject).width = ((int)(this.jdField_a_of_type_Float * 63.0F));
      ((RelativeLayout.LayoutParams)localObject).height = ((int)(this.jdField_a_of_type_Float * 63.0F));
      if (QLog.isColorLevel()) {
        QLog.d("MagicFaceAdapter", 2, "show push_btn drawable.");
      }
      paramaobp = this.jdField_a_of_type_AndroidContentContext.getSharedPreferences("mobileQQ", 0);
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
      boolean bool = paramaobp.getBoolean("magic_promotion_is_new_content_" + (String)localObject, false);
      localObject = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130846204);
      if (bool)
      {
        paramaobp = paramaobp.getString("magic_promotion_gifUrl", "");
        ((URLDrawable.URLDrawableOptions)localObject).mPlayGifImage = true;
        if (TextUtils.isEmpty(paramaobp)) {
          break label241;
        }
      }
      for (;;)
      {
        try
        {
          paramURLImageView.setImageDrawable(URLDrawable.getDrawable(paramaobp, (URLDrawable.URLDrawableOptions)localObject));
          if (!AppSetting.d) {
            break;
          }
          paramURLImageView.setContentDescription(ajya.a(2131706423));
          return;
          paramaobp = paramaobp.getString("magic_promotion_imgUrl", "");
        }
        catch (IllegalArgumentException paramaobp)
        {
          if (QLog.isColorLevel()) {
            QLog.w("MagicFaceAdapter", 2, paramaobp.getMessage());
          }
          paramURLImageView.setImageDrawable(null);
          continue;
        }
        label241:
        paramURLImageView.setImageDrawable(null);
      }
    }
    Emoticon localEmoticon = paramaobp.a;
    if ((localEmoticon == null) || (TextUtils.isEmpty(localEmoticon.epId)))
    {
      QLog.e("MagicFaceAdapter", 1, "updateImageView emotion is null or epid is null");
      return;
    }
    EmoticonPackage localEmoticonPackage = ((askf)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(14)).a(localEmoticon.epId);
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
        if (!paramaobp.b) {
          localObject = str + "_panel_magic_gray";
        }
      }
    }
    try
    {
      paramaobp = new URL("emotion_pic", "fromPanel", (String)localObject);
      if (paramaobp != null)
      {
        localObject = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130837710);
        ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130843143);
        paramaobp = URLDrawable.getDrawable(paramaobp, (URLDrawable.URLDrawableOptions)localObject);
        paramaobp.setTag(localEmoticon);
        paramaobp.addHeader("my_uin", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
        if (paramaobp != null)
        {
          paramURLImageView.setImageDrawable(paramaobp);
          paramURLImageView.setBackgroundDrawable(null);
          return;
        }
      }
    }
    catch (MalformedURLException paramaobp)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("MagicFaceAdapter", 2, "updateImageView ,", paramaobp);
        }
        paramaobp = null;
        continue;
        paramURLImageView.setVisibility(4);
        continue;
        paramaobp = null;
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
    ((URLImageView)localObject).setId(2131365583);
    RelativeLayout.LayoutParams localLayoutParams1 = new RelativeLayout.LayoutParams((int)(56.0F * this.jdField_a_of_type_Float), (int)(56.0F * this.jdField_a_of_type_Float));
    localLayoutParams1.addRule(10, -1);
    localLayoutParams1.addRule(14, -1);
    ((URLImageView)localObject).setScaleType(ImageView.ScaleType.FIT_XY);
    ((URLImageView)localObject).setAdjustViewBounds(false);
    ((URLImageView)localObject).setLayoutParams(localLayoutParams1);
    localRelativeLayout.addView((View)localObject);
    localObject = new TextView(this.jdField_a_of_type_AndroidContentContext);
    ((TextView)localObject).setVisibility(8);
    ((TextView)localObject).setId(2131365588);
    ((TextView)localObject).setTextSize(11.0F);
    localLayoutParams1 = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams1.addRule(3, 2131365583);
    localLayoutParams1.topMargin = ((int)(5.0F * this.jdField_a_of_type_Float));
    localLayoutParams1.addRule(14, -1);
    localRelativeLayout.addView((View)localObject, localLayoutParams1);
    localObject = new ImageView(this.jdField_a_of_type_AndroidContentContext);
    ((ImageView)localObject).setVisibility(8);
    ((ImageView)localObject).setId(2131365589);
    localLayoutParams1 = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams1.addRule(8, 2131365583);
    localLayoutParams1.addRule(7, 2131365583);
    localRelativeLayout.addView((View)localObject, localLayoutParams1);
    localObject = new ImageView(this.jdField_a_of_type_AndroidContentContext);
    ((ImageView)localObject).setId(2131365590);
    localLayoutParams1 = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams1.addRule(5, 2131365583);
    localLayoutParams1.addRule(6, 2131365583);
    ProgressBar localProgressBar = new ProgressBar(this.jdField_a_of_type_AndroidContentContext);
    localProgressBar.setVisibility(8);
    localProgressBar.setId(2131365587);
    localProgressBar.setIndeterminateDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130839140));
    RelativeLayout.LayoutParams localLayoutParams2 = new RelativeLayout.LayoutParams((int)(16.0F * this.jdField_a_of_type_Float), (int)(16.0F * this.jdField_a_of_type_Float));
    localLayoutParams2.addRule(14, -1);
    localLayoutParams2.topMargin = ((int)(20.0F * this.jdField_a_of_type_Float));
    localRelativeLayout.addView(localProgressBar, localLayoutParams2);
    localRelativeLayout.addView((View)localObject, localLayoutParams1);
    if (AppSetting.d) {
      localRelativeLayout.setFocusable(true);
    }
    return localRelativeLayout;
  }
  
  private void b(View paramView, aoam paramaoam)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MagicFaceAdapter", 2, "updateUI");
    }
    if ((paramView == null) || (paramaoam == null)) {
      return;
    }
    if ((paramaoam instanceof anyh)) {}
    for (paramaoam = (aobp)paramaoam;; paramaoam = null)
    {
      if (paramaoam == null)
      {
        QLog.e("MagicFaceAdapter", 1, "updateUI emotionInfo = null");
        return;
      }
      paramView.setVisibility(0);
      paramView.setTag(paramaoam);
      Object localObject1 = (URLImageView)paramView.findViewById(2131365583);
      ((URLImageView)localObject1).setVisibility(0);
      a((URLImageView)localObject1, paramaoam);
      Object localObject2 = (TextView)paramView.findViewById(2131365588);
      ImageView localImageView = (ImageView)paramView.findViewById(2131365590);
      localObject1 = (ImageView)paramView.findViewById(2131365589);
      paramView = (ProgressBar)paramView.findViewById(2131365587);
      if ("push".equals(paramaoam.h))
      {
        ((TextView)localObject2).setVisibility(8);
        localImageView.setVisibility(8);
        ((ImageView)localObject1).setVisibility(8);
        paramView.setVisibility(8);
        return;
      }
      paramaoam = paramaoam.a;
      if ((paramaoam == null) || (TextUtils.isEmpty(paramaoam.epId)))
      {
        QLog.e("MagicFaceAdapter", 1, "updateUI emotion is null or epid is null");
        return;
      }
      String str = paramaoam.name;
      if (!TextUtils.isEmpty(str))
      {
        ((TextView)localObject2).setVisibility(0);
        if (str.length() > 5)
        {
          ((TextView)localObject2).setText(str.substring(0, 4) + "...");
          if (AppSetting.d) {
            ((TextView)localObject2).setContentDescription(str);
          }
          label274:
          localImageView.setVisibility(8);
          ((ImageView)localObject1).setVisibility(8);
          localObject2 = ((askf)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(14)).a(paramaoam.epId);
          if ((localObject2 != null) && (!((EmoticonPackage)localObject2).valid))
          {
            ((ImageView)localObject1).setImageResource(2130846213);
            ((ImageView)localObject1).setVisibility(0);
          }
          paramView.setVisibility(8);
          paramView.setTag(paramaoam.epId);
          if (!this.jdField_d_of_type_JavaUtilList.contains(paramView)) {
            this.jdField_d_of_type_JavaUtilList.add(paramView);
          }
          if (((anvx)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(43)).a(paramaoam.epId) < 0.0F) {
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
  
  public View a(anxj paramanxj, int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    int j = 0;
    paramViewGroup = (aobn)paramanxj;
    int i;
    if (paramView == null)
    {
      paramView = aoau.a().a(this.c);
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
            paramanxj = paramView;
            if (i >= this.jdField_a_of_type_Int) {
              break;
            }
            paramanxj = b();
            LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(this.jdField_d_of_type_Int / this.jdField_a_of_type_Int, -1);
            paramanxj.setGravity(17);
            paramanxj.setVisibility(8);
            paramanxj.setLayoutParams(localLayoutParams);
            paramanxj.setFocusable(true);
            paramanxj.setFocusableInTouchMode(true);
            paramView.addView(paramanxj);
            i += 1;
          }
          paramView.setPadding(0, (int)(14.0F * this.jdField_a_of_type_Float), 0, 0);
        }
      }
      paramanxj = paramView;
      if (QLog.isColorLevel())
      {
        QLog.d("MagicFaceAdapter", 2, "getEmotionView position = " + paramInt + ";view from cache");
        paramanxj = paramView;
      }
      ((EmoticonPanelLinearLayout)paramanxj).setCallBack(this.jdField_a_of_type_Anyg);
      a(this.c, paramanxj);
      paramView = (ViewGroup)paramanxj;
      paramViewGroup.a = new RelativeLayout[this.jdField_a_of_type_Int];
      i = 0;
      while (i < this.jdField_a_of_type_Int)
      {
        paramViewGroup.a[i] = ((RelativeLayout)paramView.getChildAt(i));
        i += 1;
      }
      paramanxj.setTag(paramViewGroup);
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
            b(paramViewGroup.a[i], (aoam)this.jdField_a_of_type_JavaUtilList.get(j));
          }
        }
      }
      catch (OutOfMemoryError paramView)
      {
        QLog.e("MagicFaceAdapter", 1, "updateUI oom");
      }
      return paramanxj;
      paramanxj = paramView;
      i = j;
      continue;
      i += 1;
    }
  }
  
  public anxj a()
  {
    return new aobn();
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
    aoan.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.c, null, -1, 0, false, new aobm(this));
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
 * Qualified Name:     aobl
 * JD-Core Version:    0.7.0.1
 */