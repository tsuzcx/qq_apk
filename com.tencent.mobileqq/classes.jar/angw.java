import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.data.IPSiteModel.Book;
import com.tencent.mobileqq.data.IPSiteModel.Comic;
import com.tencent.mobileqq.data.IPSiteModel.Game;
import com.tencent.mobileqq.data.IPSiteModel.Video;
import com.tencent.mobileqq.data.VipIPSiteInfo;
import com.tencent.mobileqq.emoticonview.BigEmotionDownloadedAdapter.1;
import com.tencent.mobileqq.emoticonview.EmoticonPanelLinearLayout;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView.LayoutParams;
import com.tencent.widget.HorizontalListView;
import java.util.List;

public class angw
  extends angu
{
  public ColorDrawable a;
  public Drawable a;
  public URLDrawable.URLDrawableListener a;
  private BaseChatPie a;
  public EmoticonPackage a;
  private int f;
  
  public angw(QQAppInterface paramQQAppInterface, Context paramContext, int paramInt1, int paramInt2, int paramInt3, EmoticonPackage paramEmoticonPackage, anhs paramanhs, BaseChatPie paramBaseChatPie, int paramInt4)
  {
    super(paramQQAppInterface, paramContext, paramInt1, paramInt2, paramInt3, paramanhs);
    this.jdField_a_of_type_ComTencentImageURLDrawable$URLDrawableListener = new anhd(this);
    this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage = paramEmoticonPackage;
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = paramBaseChatPie;
    this.f = paramInt4;
    ThreadManager.post(new BigEmotionDownloadedAdapter.1(this, paramContext), 8, null, true);
  }
  
  private View a(VipIPSiteInfo paramVipIPSiteInfo)
  {
    if (paramVipIPSiteInfo != null)
    {
      if (this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable == null) {
        this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable = new ColorDrawable(-1513240);
      }
      int i;
      String str3;
      Object localObject5;
      Object localObject4;
      Object localObject3;
      Object localObject6;
      Object localObject7;
      Object localObject8;
      Object localObject9;
      Object localObject10;
      String str2;
      try
      {
        i = badq.a(this.jdField_a_of_type_AndroidContentContext);
        String str1 = "";
        switch (i)
        {
        default: 
          str3 = "";
        }
        try
        {
          i = paramVipIPSiteInfo.ipID;
          str3 = String.valueOf(i);
        }
        catch (Exception localException2)
        {
          for (;;)
          {
            Object localObject1;
            RelativeLayout localRelativeLayout;
            ImageView localImageView;
            QLog.e("BigEmotionDownloadedAdapter", 1, "fillIPSiteViewPagerMode ipId error = " + localException2);
            continue;
            ((TextView)localObject10).setText(ajjy.a(2131635306));
            localImageView.setVisibility(8);
            localObject3 = localException2;
            if (localException2 == null) {
              localObject3 = new RelativeLayout.LayoutParams(aciy.a(75.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), aciy.a(75.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
            }
            ((RelativeLayout.LayoutParams)localObject3).width = aciy.a(75.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
            ((RelativeLayout.LayoutParams)localObject3).height = aciy.a(75.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
            ((TextView)localObject7).setMaxWidth(aciy.a(126.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
            ((TextView)localObject8).setMaxWidth(aciy.a(126.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
            continue;
            ((TextView)localObject10).setText(ajjy.a(2131635299));
            localImageView.setVisibility(0);
            localObject3 = localException2;
            if (localException2 == null) {
              localObject3 = new RelativeLayout.LayoutParams(aciy.a(140.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), aciy.a(75.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
            }
            ((RelativeLayout.LayoutParams)localObject3).width = aciy.a(140.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
            ((RelativeLayout.LayoutParams)localObject3).height = aciy.a(75.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
            ((TextView)localObject7).setMaxWidth(aciy.a(90.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
            ((TextView)localObject8).setMaxWidth(aciy.a(90.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
          }
          VasWebviewUtil.reportCommercialDrainage(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "IP", "aio_comicshow", "", 0, 0, 0, str2, str3, "", "", "", "", "", 0, 0, 0, 0);
          paramVipIPSiteInfo = (VipIPSiteInfo)localObject4;
        }
        localObject5 = new angy(this, paramVipIPSiteInfo, str1, str3);
        localObject1 = paramVipIPSiteInfo.strType;
        if ("comic".equals(localObject1))
        {
          localObject4 = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131493465, null, false);
          localObject1 = (TextView)((View)localObject4).findViewById(2131296757);
          localObject3 = (TextView)((View)localObject4).findViewById(2131296738);
          ((RelativeLayout)((View)localObject4).findViewById(2131296753)).setOnClickListener((View.OnClickListener)localObject5);
          localObject5 = (RelativeLayout)((View)localObject4).findViewById(2131296730);
          localObject6 = (ImageView)((View)localObject4).findViewById(2131296734);
          localObject7 = (TextView)((View)localObject4).findViewById(2131296736);
          localObject8 = (TextView)((View)localObject4).findViewById(2131296731);
          localObject9 = (Button)((View)localObject4).findViewById(2131296759);
          localObject10 = (TextView)((View)localObject4).findViewById(2131296737);
          localRelativeLayout = (RelativeLayout)((View)localObject4).findViewById(2131296732);
          localImageView = (ImageView)((View)localObject4).findViewById(2131296733);
          ((TextView)localObject1).setText(paramVipIPSiteInfo.ipName + ajjy.a(2131635301));
          ((TextView)localObject3).setText(bajo.a(paramVipIPSiteInfo.ipContent));
          if (paramVipIPSiteInfo.ipList != null)
          {
            i = 0;
            while (i < paramVipIPSiteInfo.ipList.size())
            {
              localObject1 = paramVipIPSiteInfo.ipList.get(i);
              IPSiteModel.Comic localComic;
              angz localangz;
              if ((localObject1 instanceof IPSiteModel.Comic))
              {
                localComic = (IPSiteModel.Comic)localObject1;
                localangz = new angz(this, localComic, str1, str3);
                localObject1 = (RelativeLayout.LayoutParams)localRelativeLayout.getLayoutParams();
              }
              switch (localComic.comicType)
              {
              default: 
                ((ImageView)localObject6).setImageDrawable(bajo.a(localComic.cover, this.jdField_a_of_type_ComTencentImageURLDrawable$URLDrawableListener, this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable));
                ((TextView)localObject7).setText(localComic.name);
                ((TextView)localObject8).setText(localComic.desc);
                ((Button)localObject9).setOnClickListener(localangz);
                ((RelativeLayout)localObject5).setOnClickListener(localangz);
                i += 1;
              }
            }
          }
        }
      }
      catch (Exception localException1)
      {
        for (;;)
        {
          i = 0;
          continue;
          str2 = "2G";
          continue;
          str2 = "3G";
          continue;
          str2 = "4G";
          continue;
          str2 = "wifi";
        }
      }
      for (;;)
      {
        if (paramVipIPSiteInfo != null) {
          VasWebviewUtil.reportCommercialDrainage(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "IP", "aio_entershow", "", 0, 0, 0, str2, str3, "", "", "", "", "", 0, 0, 0, 0);
        }
        return paramVipIPSiteInfo;
        Object localObject2;
        if ("game".equals(localException2))
        {
          localObject2 = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131493463, null, false);
          localObject8 = (TextView)((View)localObject2).findViewById(2131296757);
          localObject9 = (TextView)((View)localObject2).findViewById(2131296738);
          ((RelativeLayout)((View)localObject2).findViewById(2131296751)).setOnClickListener((View.OnClickListener)localObject5);
          localObject3 = (RelativeLayout)((View)localObject2).findViewById(2131296740);
          localObject4 = (ImageView)((View)localObject2).findViewById(2131296742);
          localObject5 = (TextView)((View)localObject2).findViewById(2131296744);
          localObject6 = (TextView)((View)localObject2).findViewById(2131296741);
          localObject7 = (Button)((View)localObject2).findViewById(2131296760);
          ((TextView)localObject8).setText(paramVipIPSiteInfo.ipName + ajjy.a(2131635304));
          ((TextView)localObject9).setText(bajo.a(paramVipIPSiteInfo.ipContent));
          if (paramVipIPSiteInfo.ipList != null)
          {
            i = 0;
            while (i < paramVipIPSiteInfo.ipList.size())
            {
              localObject8 = paramVipIPSiteInfo.ipList.get(i);
              if ((localObject8 instanceof IPSiteModel.Game))
              {
                localObject8 = (IPSiteModel.Game)localObject8;
                localObject9 = new anha(this, (IPSiteModel.Game)localObject8, str2, str3);
                ((ImageView)localObject4).setImageDrawable(bajo.a(((IPSiteModel.Game)localObject8).cover, this.jdField_a_of_type_ComTencentImageURLDrawable$URLDrawableListener, this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable));
                ((TextView)localObject5).setText(((IPSiteModel.Game)localObject8).name);
                ((TextView)localObject6).setText(((IPSiteModel.Game)localObject8).recommDesc);
                ((Button)localObject7).setOnClickListener((View.OnClickListener)localObject9);
                ((RelativeLayout)localObject3).setOnClickListener((View.OnClickListener)localObject9);
              }
              i += 1;
            }
          }
          VasWebviewUtil.reportCommercialDrainage(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "IP", "aio_gameshow", "", 0, 0, 0, str2, str3, "", "", "", "", "", 0, 0, 0, 0);
          paramVipIPSiteInfo = (VipIPSiteInfo)localObject2;
        }
        else if ("goods".equals(localObject2))
        {
          localObject2 = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131493462, null, false);
          localObject3 = (TextView)((View)localObject2).findViewById(2131296757);
          localObject4 = (TextView)((View)localObject2).findViewById(2131296738);
          ((RelativeLayout)((View)localObject2).findViewById(2131296750)).setOnClickListener((View.OnClickListener)localObject5);
          ((TextView)localObject3).setText(paramVipIPSiteInfo.ipName + ajjy.a(2131635297));
          ((TextView)localObject4).setText(bajo.a(paramVipIPSiteInfo.ipContent));
          localObject3 = (HorizontalListView)((View)localObject2).findViewById(2131296755);
          if (paramVipIPSiteInfo.ipList != null)
          {
            paramVipIPSiteInfo = new anks(this.jdField_a_of_type_AndroidContentContext, paramVipIPSiteInfo.ipList, this.jdField_a_of_type_ComTencentImageURLDrawable$URLDrawableListener, this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), str3, str2);
            ((HorizontalListView)localObject3).setDividerWidth(aciy.a(10.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
            ((HorizontalListView)localObject3).setAdapter(paramVipIPSiteInfo);
          }
          VasWebviewUtil.reportCommercialDrainage(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "IP", "aio_productshow", "", 0, 0, 0, str2, str3, "", "", "", "", "", 0, 0, 0, 0);
          paramVipIPSiteInfo = (VipIPSiteInfo)localObject2;
        }
        else if ("video".equals(localObject2))
        {
          localObject3 = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131493464, null, false);
          localObject2 = (TextView)((View)localObject3).findViewById(2131296757);
          localObject9 = (TextView)((View)localObject3).findViewById(2131296738);
          ((RelativeLayout)((View)localObject3).findViewById(2131296752)).setOnClickListener((View.OnClickListener)localObject5);
          localObject4 = (RelativeLayout)((View)localObject3).findViewById(2131296762);
          localObject5 = (ImageView)((View)localObject3).findViewById(2131296765);
          localObject6 = (TextView)((View)localObject3).findViewById(2131296767);
          localObject7 = (TextView)((View)localObject3).findViewById(2131296763);
          localObject8 = (Button)((View)localObject3).findViewById(2131296761);
          ((TextView)localObject2).setText(paramVipIPSiteInfo.ipName + ajjy.a(2131635305));
          ((TextView)localObject9).setText(bajo.a(paramVipIPSiteInfo.ipContent));
          if (paramVipIPSiteInfo.ipList != null)
          {
            i = 0;
            if (i < paramVipIPSiteInfo.ipList.size())
            {
              localObject2 = paramVipIPSiteInfo.ipList.get(i);
              if ((localObject2 instanceof IPSiteModel.Video))
              {
                localObject9 = (IPSiteModel.Video)localObject2;
                localObject10 = new anhb(this, (IPSiteModel.Video)localObject9, str2, str3);
                if (!TextUtils.isEmpty(((IPSiteModel.Video)localObject9).buttonDesc)) {
                  break label1874;
                }
                localObject2 = ajjy.a(2131635296);
                label1736:
                ((ImageView)localObject5).setImageDrawable(bajo.a(((IPSiteModel.Video)localObject9).cover, this.jdField_a_of_type_ComTencentImageURLDrawable$URLDrawableListener, this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable));
                ((TextView)localObject6).setText(((IPSiteModel.Video)localObject9).name);
                if (!TextUtils.isEmpty(((IPSiteModel.Video)localObject9).showDate)) {
                  break label1884;
                }
                ((TextView)localObject7).setText(((IPSiteModel.Video)localObject9).desc);
                label1788:
                ((Button)localObject8).setText((CharSequence)localObject2);
                if (!((String)localObject2).equals(ajjy.a(2131635302))) {
                  break label1919;
                }
                j = 2130839339;
                label1813:
                ((Button)localObject8).setBackgroundResource(j);
                if (!((String)localObject2).equals(ajjy.a(2131635295))) {
                  break label1926;
                }
              }
              label1926:
              for (int j = this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131099822);; j = this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131099854))
              {
                ((Button)localObject8).setTextColor(j);
                ((Button)localObject8).setOnClickListener((View.OnClickListener)localObject10);
                ((RelativeLayout)localObject4).setOnClickListener((View.OnClickListener)localObject10);
                i += 1;
                break;
                label1874:
                localObject2 = ((IPSiteModel.Video)localObject9).buttonDesc;
                break label1736;
                label1884:
                ((TextView)localObject7).setText(((IPSiteModel.Video)localObject9).showDate + ajjy.a(2131635294));
                break label1788;
                label1919:
                j = 2130839338;
                break label1813;
              }
            }
          }
          VasWebviewUtil.reportCommercialDrainage(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "IP", "aio_movieshow", "", 0, 0, 0, str2, str3, "", "", "", "", "", 0, 0, 0, 0);
          paramVipIPSiteInfo = (VipIPSiteInfo)localObject3;
        }
        else if ("book".equals(localObject2))
        {
          localObject2 = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131493466, null, false);
          localObject8 = (TextView)((View)localObject2).findViewById(2131296757);
          localObject9 = (TextView)((View)localObject2).findViewById(2131296738);
          ((RelativeLayout)((View)localObject2).findViewById(2131296754)).setOnClickListener((View.OnClickListener)localObject5);
          localObject3 = (RelativeLayout)((View)localObject2).findViewById(2131296724);
          localObject4 = (ImageView)((View)localObject2).findViewById(2131296726);
          localObject5 = (TextView)((View)localObject2).findViewById(2131296728);
          localObject6 = (TextView)((View)localObject2).findViewById(2131296725);
          localObject7 = (Button)((View)localObject2).findViewById(2131296758);
          ((TextView)localObject8).setText(paramVipIPSiteInfo.ipName + ajjy.a(2131635303));
          ((TextView)localObject9).setText(bajo.a(paramVipIPSiteInfo.ipContent));
          if (paramVipIPSiteInfo.ipList != null)
          {
            i = 0;
            while (i < paramVipIPSiteInfo.ipList.size())
            {
              localObject8 = paramVipIPSiteInfo.ipList.get(i);
              if ((localObject8 instanceof IPSiteModel.Book))
              {
                localObject8 = (IPSiteModel.Book)localObject8;
                localObject9 = new anhc(this, (IPSiteModel.Book)localObject8, str2, str3);
                ((ImageView)localObject4).setImageDrawable(bajo.a(((IPSiteModel.Book)localObject8).cover, this.jdField_a_of_type_ComTencentImageURLDrawable$URLDrawableListener, this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable));
                ((TextView)localObject5).setText(((IPSiteModel.Book)localObject8).name);
                ((TextView)localObject6).setText(((IPSiteModel.Book)localObject8).recommDesc);
                ((Button)localObject7).setOnClickListener((View.OnClickListener)localObject9);
                ((RelativeLayout)localObject3).setOnClickListener((View.OnClickListener)localObject9);
              }
              i += 1;
            }
          }
          VasWebviewUtil.reportCommercialDrainage(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "IP", "aio_bookshow", "", 0, 0, 0, str2, str3, "", "", "", "", "", 0, 0, 0, 0);
          paramVipIPSiteInfo = (VipIPSiteInfo)localObject2;
        }
        else
        {
          paramVipIPSiteInfo = null;
        }
      }
    }
    return null;
  }
  
  public View a(angv paramangv, int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    long l1 = System.currentTimeMillis();
    Object localObject1 = (anhe)paramangv;
    int i;
    if (getItemViewType(paramInt) == 0)
    {
      if (paramView != null) {
        break label1080;
      }
      paramView = ankg.a().a(this.c);
      if (paramView == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("BigEmotionDownloadedAdapter", 2, "getEmotionView position = " + paramInt + ";view from inflater");
        }
        paramView = new EmoticonPanelLinearLayout(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie, this.f);
        paramView.setPanelType(EmoticonPanelLinearLayout.b);
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
            paramangv = super.a();
            paramangv.setVisibility(8);
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
        QLog.d("BigEmotionDownloadedAdapter", 2, "getEmotionView position = " + paramInt + ";view from cache");
        paramangv = paramView;
      }
      ((EmoticonPanelLinearLayout)paramangv).setCallBack(this.jdField_a_of_type_Anhs);
      a(this.c, paramangv);
      paramView = (ViewGroup)paramangv;
      ((anhe)localObject1).jdField_a_of_type_ArrayOfAndroidWidgetRelativeLayout = new RelativeLayout[this.jdField_a_of_type_Int];
      i = 0;
      while (i < this.jdField_a_of_type_Int)
      {
        ((anhe)localObject1).jdField_a_of_type_ArrayOfAndroidWidgetRelativeLayout[i] = ((RelativeLayout)paramView.getChildAt(i));
        i += 1;
      }
      paramangv.setTag(localObject1);
    }
    for (;;)
    {
      i = 0;
      if (i < this.jdField_a_of_type_Int)
      {
        int j = this.jdField_a_of_type_Int * paramInt + i;
        if (j > this.jdField_a_of_type_JavaUtilList.size() - 1)
        {
          localObject1.jdField_a_of_type_ArrayOfAndroidWidgetRelativeLayout[i].setTag(null);
          localObject1.jdField_a_of_type_ArrayOfAndroidWidgetRelativeLayout[i].setVisibility(8);
        }
        for (;;)
        {
          i += 1;
          break;
          paramView = localObject1.jdField_a_of_type_ArrayOfAndroidWidgetRelativeLayout[i];
          paramViewGroup = (anjy)this.jdField_a_of_type_JavaUtilList.get(j);
          if (paramView != null)
          {
            if (paramViewGroup == paramView.getTag(2131313373)) {
              paramView.setVisibility(0);
            } else {
              paramView.setTag(2131313373, paramViewGroup);
            }
          }
          else
          {
            long l2 = System.currentTimeMillis();
            super.a(paramView, paramViewGroup);
            if (QLog.isColorLevel()) {
              QLog.d("BigEmotionDownloadedAdapter", 2, "updateUi cost = " + (System.currentTimeMillis() - l2));
            }
          }
        }
      }
      do
      {
        if (QLog.isColorLevel()) {
          QLog.d("BigEmotionDownloadedAdapter", 2, "getEmotionView cost = " + (System.currentTimeMillis() - l1));
        }
        return paramangv;
        paramangv = paramView;
      } while (paramView != null);
      paramViewGroup = (arny)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(200);
      Object localObject2 = (arnz)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(14);
      paramangv = this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.ipSiteInfo;
      if ((paramangv == null) && (this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.ipSiteInfoBytes != null) && (this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.ipSiteInfoBytes.length > 0)) {
        paramangv = ((arnz)localObject2).a(this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.ipSiteInfoBytes);
      }
      for (;;)
      {
        if (paramViewGroup != null) {}
        for (boolean bool = paramViewGroup.a(paramangv);; bool = false)
        {
          if (bool)
          {
            paramViewGroup = a(paramangv);
            paramangv = paramView;
            if (paramViewGroup == null) {
              break;
            }
            paramViewGroup.setTag(localObject1);
            paramangv = paramViewGroup;
            break;
          }
          paramView = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
          paramView.setLayoutParams(new AbsListView.LayoutParams(-1, (int)(46.0F * this.jdField_a_of_type_Float)));
          localObject2 = new LinearLayout(this.jdField_a_of_type_AndroidContentContext);
          paramangv = new RelativeLayout.LayoutParams(-2, -2);
          paramangv.addRule(13, -1);
          ((LinearLayout)localObject2).setLayoutParams(paramangv);
          paramViewGroup = aniz.a(this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.epId, true);
          Object localObject3 = new LinearLayout.LayoutParams(-2, -2);
          ((LinearLayout)localObject2).setOrientation(0);
          ((LinearLayout.LayoutParams)localObject3).gravity = 16;
          TextView localTextView = new TextView(this.jdField_a_of_type_AndroidContentContext);
          localTextView.setTextSize(14.0F);
          if (paramViewGroup.a)
          {
            paramangv = ajjy.a(2131635298);
            label826:
            localTextView.setText(paramangv);
            localTextView.setTextColor(-8947849);
            ((LinearLayout)localObject2).addView(localTextView, (ViewGroup.LayoutParams)localObject3);
            paramangv = new LinearLayout.LayoutParams(-2, -2);
            paramangv.leftMargin = ((int)(5.0F * this.jdField_a_of_type_Float));
            paramangv.gravity = 16;
            localObject3 = new ImageView(this.jdField_a_of_type_AndroidContentContext);
            ((ImageView)localObject3).setBackgroundDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130846019));
            ((LinearLayout)localObject2).addView((View)localObject3, paramangv);
            paramView.addView((View)localObject2);
            ((anhe)localObject1).jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)localObject2);
            ((anhe)localObject1).jdField_a_of_type_AndroidWidgetLinearLayout.setOnClickListener(new angx(this, paramViewGroup));
            ((anhe)localObject1).jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
            paramView.setTag(localObject1);
            awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "ep_mall", "exp_bq_detail", 0, 0, "", this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.epId, "", "");
            localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
            localObject2 = this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.epId;
            if (!paramViewGroup.a) {
              break label1064;
            }
          }
          label1064:
          for (paramangv = "1";; paramangv = "2")
          {
            VasWebviewUtil.reportCommercialDrainage((String)localObject1, "ep_mall", "exp_bq_detail", null, 1, 0, 0, null, (String)localObject2, paramangv);
            paramangv = paramView;
            break;
            paramangv = ajjy.a(2131635300);
            break label826;
          }
        }
      }
      label1080:
      paramangv = paramView;
    }
  }
  
  public angv a()
  {
    return new anhe();
  }
  
  public EmoticonPackage a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage;
  }
  
  public int getCount()
  {
    int i = super.getCount();
    if (i > 0)
    {
      if (this.f == 1) {
        return i;
      }
      return i + 1;
    }
    return 0;
  }
  
  public int getItemViewType(int paramInt)
  {
    if (this.f == 1) {}
    while (paramInt != getCount() - 1) {
      return 0;
    }
    return 1;
  }
  
  public int getViewTypeCount()
  {
    if (this.f == 1) {
      return 1;
    }
    return 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     angw
 * JD-Core Version:    0.7.0.1
 */