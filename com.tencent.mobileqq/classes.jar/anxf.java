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

public class anxf
  extends anxd
{
  public ColorDrawable a;
  public Drawable a;
  public URLDrawable.URLDrawableListener a;
  private BaseChatPie a;
  public EmoticonPackage a;
  private int f;
  
  public anxf(QQAppInterface paramQQAppInterface, Context paramContext, int paramInt1, int paramInt2, int paramInt3, EmoticonPackage paramEmoticonPackage, anyb paramanyb, BaseChatPie paramBaseChatPie, int paramInt4)
  {
    super(paramQQAppInterface, paramContext, paramInt1, paramInt2, paramInt3, paramanyb);
    this.jdField_a_of_type_ComTencentImageURLDrawable$URLDrawableListener = new anxm(this);
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
        i = bbev.a(this.jdField_a_of_type_AndroidContentContext);
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
            ((TextView)localObject10).setText(ajyc.a(2131701090));
            localImageView.setVisibility(8);
            localObject3 = localException2;
            if (localException2 == null) {
              localObject3 = new RelativeLayout.LayoutParams(actn.a(75.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), actn.a(75.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
            }
            ((RelativeLayout.LayoutParams)localObject3).width = actn.a(75.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
            ((RelativeLayout.LayoutParams)localObject3).height = actn.a(75.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
            ((TextView)localObject7).setMaxWidth(actn.a(126.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
            ((TextView)localObject8).setMaxWidth(actn.a(126.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
            continue;
            ((TextView)localObject10).setText(ajyc.a(2131701083));
            localImageView.setVisibility(0);
            localObject3 = localException2;
            if (localException2 == null) {
              localObject3 = new RelativeLayout.LayoutParams(actn.a(140.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), actn.a(75.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
            }
            ((RelativeLayout.LayoutParams)localObject3).width = actn.a(140.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
            ((RelativeLayout.LayoutParams)localObject3).height = actn.a(75.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
            ((TextView)localObject7).setMaxWidth(actn.a(90.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
            ((TextView)localObject8).setMaxWidth(actn.a(90.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
          }
          VasWebviewUtil.reportCommercialDrainage(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "IP", "aio_comicshow", "", 0, 0, 0, str2, str3, "", "", "", "", "", 0, 0, 0, 0);
          paramVipIPSiteInfo = (VipIPSiteInfo)localObject4;
        }
        localObject5 = new anxh(this, paramVipIPSiteInfo, str1, str3);
        localObject1 = paramVipIPSiteInfo.strType;
        if ("comic".equals(localObject1))
        {
          localObject4 = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131559028, null, false);
          localObject1 = (TextView)((View)localObject4).findViewById(2131362298);
          localObject3 = (TextView)((View)localObject4).findViewById(2131362279);
          ((RelativeLayout)((View)localObject4).findViewById(2131362294)).setOnClickListener((View.OnClickListener)localObject5);
          localObject5 = (RelativeLayout)((View)localObject4).findViewById(2131362271);
          localObject6 = (ImageView)((View)localObject4).findViewById(2131362275);
          localObject7 = (TextView)((View)localObject4).findViewById(2131362277);
          localObject8 = (TextView)((View)localObject4).findViewById(2131362272);
          localObject9 = (Button)((View)localObject4).findViewById(2131362300);
          localObject10 = (TextView)((View)localObject4).findViewById(2131362278);
          localRelativeLayout = (RelativeLayout)((View)localObject4).findViewById(2131362273);
          localImageView = (ImageView)((View)localObject4).findViewById(2131362274);
          ((TextView)localObject1).setText(paramVipIPSiteInfo.ipName + ajyc.a(2131701085));
          ((TextView)localObject3).setText(bbkv.a(paramVipIPSiteInfo.ipContent));
          if (paramVipIPSiteInfo.ipList != null)
          {
            i = 0;
            while (i < paramVipIPSiteInfo.ipList.size())
            {
              localObject1 = paramVipIPSiteInfo.ipList.get(i);
              IPSiteModel.Comic localComic;
              anxi localanxi;
              if ((localObject1 instanceof IPSiteModel.Comic))
              {
                localComic = (IPSiteModel.Comic)localObject1;
                localanxi = new anxi(this, localComic, str1, str3);
                localObject1 = (RelativeLayout.LayoutParams)localRelativeLayout.getLayoutParams();
              }
              switch (localComic.comicType)
              {
              default: 
                ((ImageView)localObject6).setImageDrawable(bbkv.a(localComic.cover, this.jdField_a_of_type_ComTencentImageURLDrawable$URLDrawableListener, this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable));
                ((TextView)localObject7).setText(localComic.name);
                ((TextView)localObject8).setText(localComic.desc);
                ((Button)localObject9).setOnClickListener(localanxi);
                ((RelativeLayout)localObject5).setOnClickListener(localanxi);
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
          localObject2 = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131559026, null, false);
          localObject8 = (TextView)((View)localObject2).findViewById(2131362298);
          localObject9 = (TextView)((View)localObject2).findViewById(2131362279);
          ((RelativeLayout)((View)localObject2).findViewById(2131362292)).setOnClickListener((View.OnClickListener)localObject5);
          localObject3 = (RelativeLayout)((View)localObject2).findViewById(2131362281);
          localObject4 = (ImageView)((View)localObject2).findViewById(2131362283);
          localObject5 = (TextView)((View)localObject2).findViewById(2131362285);
          localObject6 = (TextView)((View)localObject2).findViewById(2131362282);
          localObject7 = (Button)((View)localObject2).findViewById(2131362301);
          ((TextView)localObject8).setText(paramVipIPSiteInfo.ipName + ajyc.a(2131701088));
          ((TextView)localObject9).setText(bbkv.a(paramVipIPSiteInfo.ipContent));
          if (paramVipIPSiteInfo.ipList != null)
          {
            i = 0;
            while (i < paramVipIPSiteInfo.ipList.size())
            {
              localObject8 = paramVipIPSiteInfo.ipList.get(i);
              if ((localObject8 instanceof IPSiteModel.Game))
              {
                localObject8 = (IPSiteModel.Game)localObject8;
                localObject9 = new anxj(this, (IPSiteModel.Game)localObject8, str2, str3);
                ((ImageView)localObject4).setImageDrawable(bbkv.a(((IPSiteModel.Game)localObject8).cover, this.jdField_a_of_type_ComTencentImageURLDrawable$URLDrawableListener, this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable));
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
          localObject2 = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131559025, null, false);
          localObject3 = (TextView)((View)localObject2).findViewById(2131362298);
          localObject4 = (TextView)((View)localObject2).findViewById(2131362279);
          ((RelativeLayout)((View)localObject2).findViewById(2131362291)).setOnClickListener((View.OnClickListener)localObject5);
          ((TextView)localObject3).setText(paramVipIPSiteInfo.ipName + ajyc.a(2131701081));
          ((TextView)localObject4).setText(bbkv.a(paramVipIPSiteInfo.ipContent));
          localObject3 = (HorizontalListView)((View)localObject2).findViewById(2131362296);
          if (paramVipIPSiteInfo.ipList != null)
          {
            paramVipIPSiteInfo = new aobc(this.jdField_a_of_type_AndroidContentContext, paramVipIPSiteInfo.ipList, this.jdField_a_of_type_ComTencentImageURLDrawable$URLDrawableListener, this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), str3, str2);
            ((HorizontalListView)localObject3).setDividerWidth(actn.a(10.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
            ((HorizontalListView)localObject3).setAdapter(paramVipIPSiteInfo);
          }
          VasWebviewUtil.reportCommercialDrainage(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "IP", "aio_productshow", "", 0, 0, 0, str2, str3, "", "", "", "", "", 0, 0, 0, 0);
          paramVipIPSiteInfo = (VipIPSiteInfo)localObject2;
        }
        else if ("video".equals(localObject2))
        {
          localObject3 = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131559027, null, false);
          localObject2 = (TextView)((View)localObject3).findViewById(2131362298);
          localObject9 = (TextView)((View)localObject3).findViewById(2131362279);
          ((RelativeLayout)((View)localObject3).findViewById(2131362293)).setOnClickListener((View.OnClickListener)localObject5);
          localObject4 = (RelativeLayout)((View)localObject3).findViewById(2131362303);
          localObject5 = (ImageView)((View)localObject3).findViewById(2131362306);
          localObject6 = (TextView)((View)localObject3).findViewById(2131362308);
          localObject7 = (TextView)((View)localObject3).findViewById(2131362304);
          localObject8 = (Button)((View)localObject3).findViewById(2131362302);
          ((TextView)localObject2).setText(paramVipIPSiteInfo.ipName + ajyc.a(2131701089));
          ((TextView)localObject9).setText(bbkv.a(paramVipIPSiteInfo.ipContent));
          if (paramVipIPSiteInfo.ipList != null)
          {
            i = 0;
            if (i < paramVipIPSiteInfo.ipList.size())
            {
              localObject2 = paramVipIPSiteInfo.ipList.get(i);
              if ((localObject2 instanceof IPSiteModel.Video))
              {
                localObject9 = (IPSiteModel.Video)localObject2;
                localObject10 = new anxk(this, (IPSiteModel.Video)localObject9, str2, str3);
                if (!TextUtils.isEmpty(((IPSiteModel.Video)localObject9).buttonDesc)) {
                  break label1874;
                }
                localObject2 = ajyc.a(2131701080);
                label1736:
                ((ImageView)localObject5).setImageDrawable(bbkv.a(((IPSiteModel.Video)localObject9).cover, this.jdField_a_of_type_ComTencentImageURLDrawable$URLDrawableListener, this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable));
                ((TextView)localObject6).setText(((IPSiteModel.Video)localObject9).name);
                if (!TextUtils.isEmpty(((IPSiteModel.Video)localObject9).showDate)) {
                  break label1884;
                }
                ((TextView)localObject7).setText(((IPSiteModel.Video)localObject9).desc);
                label1788:
                ((Button)localObject8).setText((CharSequence)localObject2);
                if (!((String)localObject2).equals(ajyc.a(2131701086))) {
                  break label1919;
                }
                j = 2130839363;
                label1813:
                ((Button)localObject8).setBackgroundResource(j);
                if (!((String)localObject2).equals(ajyc.a(2131701079))) {
                  break label1926;
                }
              }
              label1926:
              for (int j = this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131165359);; j = this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131165413))
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
                ((TextView)localObject7).setText(((IPSiteModel.Video)localObject9).showDate + ajyc.a(2131701078));
                break label1788;
                label1919:
                j = 2130839362;
                break label1813;
              }
            }
          }
          VasWebviewUtil.reportCommercialDrainage(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "IP", "aio_movieshow", "", 0, 0, 0, str2, str3, "", "", "", "", "", 0, 0, 0, 0);
          paramVipIPSiteInfo = (VipIPSiteInfo)localObject3;
        }
        else if ("book".equals(localObject2))
        {
          localObject2 = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131559029, null, false);
          localObject8 = (TextView)((View)localObject2).findViewById(2131362298);
          localObject9 = (TextView)((View)localObject2).findViewById(2131362279);
          ((RelativeLayout)((View)localObject2).findViewById(2131362295)).setOnClickListener((View.OnClickListener)localObject5);
          localObject3 = (RelativeLayout)((View)localObject2).findViewById(2131362265);
          localObject4 = (ImageView)((View)localObject2).findViewById(2131362267);
          localObject5 = (TextView)((View)localObject2).findViewById(2131362269);
          localObject6 = (TextView)((View)localObject2).findViewById(2131362266);
          localObject7 = (Button)((View)localObject2).findViewById(2131362299);
          ((TextView)localObject8).setText(paramVipIPSiteInfo.ipName + ajyc.a(2131701087));
          ((TextView)localObject9).setText(bbkv.a(paramVipIPSiteInfo.ipContent));
          if (paramVipIPSiteInfo.ipList != null)
          {
            i = 0;
            while (i < paramVipIPSiteInfo.ipList.size())
            {
              localObject8 = paramVipIPSiteInfo.ipList.get(i);
              if ((localObject8 instanceof IPSiteModel.Book))
              {
                localObject8 = (IPSiteModel.Book)localObject8;
                localObject9 = new anxl(this, (IPSiteModel.Book)localObject8, str2, str3);
                ((ImageView)localObject4).setImageDrawable(bbkv.a(((IPSiteModel.Book)localObject8).cover, this.jdField_a_of_type_ComTencentImageURLDrawable$URLDrawableListener, this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable));
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
  
  public View a(anxe paramanxe, int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    long l1 = System.currentTimeMillis();
    Object localObject1 = (anxn)paramanxe;
    int i;
    if (getItemViewType(paramInt) == 0)
    {
      if (paramView != null) {
        break label1080;
      }
      paramView = aoap.a().a(this.c);
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
            paramanxe = paramView;
            if (i >= this.jdField_a_of_type_Int) {
              break;
            }
            paramanxe = super.a();
            paramanxe.setVisibility(8);
            paramanxe.setFocusable(true);
            paramanxe.setFocusableInTouchMode(true);
            paramView.addView(paramanxe);
            i += 1;
          }
          paramView.setPadding(0, (int)(14.0F * this.jdField_a_of_type_Float), 0, 0);
        }
      }
      paramanxe = paramView;
      if (QLog.isColorLevel())
      {
        QLog.d("BigEmotionDownloadedAdapter", 2, "getEmotionView position = " + paramInt + ";view from cache");
        paramanxe = paramView;
      }
      ((EmoticonPanelLinearLayout)paramanxe).setCallBack(this.jdField_a_of_type_Anyb);
      a(this.c, paramanxe);
      paramView = (ViewGroup)paramanxe;
      ((anxn)localObject1).jdField_a_of_type_ArrayOfAndroidWidgetRelativeLayout = new RelativeLayout[this.jdField_a_of_type_Int];
      i = 0;
      while (i < this.jdField_a_of_type_Int)
      {
        ((anxn)localObject1).jdField_a_of_type_ArrayOfAndroidWidgetRelativeLayout[i] = ((RelativeLayout)paramView.getChildAt(i));
        i += 1;
      }
      paramanxe.setTag(localObject1);
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
          paramViewGroup = (aoah)this.jdField_a_of_type_JavaUtilList.get(j);
          if (paramView != null)
          {
            if (paramViewGroup == paramView.getTag(2131379208)) {
              paramView.setVisibility(0);
            } else {
              paramView.setTag(2131379208, paramViewGroup);
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
        return paramanxe;
        paramanxe = paramView;
      } while (paramView != null);
      paramViewGroup = (askc)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(200);
      Object localObject2 = (askd)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(14);
      paramanxe = this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.ipSiteInfo;
      if ((paramanxe == null) && (this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.ipSiteInfoBytes != null) && (this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.ipSiteInfoBytes.length > 0)) {
        paramanxe = ((askd)localObject2).a(this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.ipSiteInfoBytes);
      }
      for (;;)
      {
        if (paramViewGroup != null) {}
        for (boolean bool = paramViewGroup.a(paramanxe);; bool = false)
        {
          if (bool)
          {
            paramViewGroup = a(paramanxe);
            paramanxe = paramView;
            if (paramViewGroup == null) {
              break;
            }
            paramViewGroup.setTag(localObject1);
            paramanxe = paramViewGroup;
            break;
          }
          paramView = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
          paramView.setLayoutParams(new AbsListView.LayoutParams(-1, (int)(46.0F * this.jdField_a_of_type_Float)));
          localObject2 = new LinearLayout(this.jdField_a_of_type_AndroidContentContext);
          paramanxe = new RelativeLayout.LayoutParams(-2, -2);
          paramanxe.addRule(13, -1);
          ((LinearLayout)localObject2).setLayoutParams(paramanxe);
          paramViewGroup = anzi.a(this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.epId, true);
          Object localObject3 = new LinearLayout.LayoutParams(-2, -2);
          ((LinearLayout)localObject2).setOrientation(0);
          ((LinearLayout.LayoutParams)localObject3).gravity = 16;
          TextView localTextView = new TextView(this.jdField_a_of_type_AndroidContentContext);
          localTextView.setTextSize(14.0F);
          if (paramViewGroup.a)
          {
            paramanxe = ajyc.a(2131701082);
            label826:
            localTextView.setText(paramanxe);
            localTextView.setTextColor(-8947849);
            ((LinearLayout)localObject2).addView(localTextView, (ViewGroup.LayoutParams)localObject3);
            paramanxe = new LinearLayout.LayoutParams(-2, -2);
            paramanxe.leftMargin = ((int)(5.0F * this.jdField_a_of_type_Float));
            paramanxe.gravity = 16;
            localObject3 = new ImageView(this.jdField_a_of_type_AndroidContentContext);
            ((ImageView)localObject3).setBackgroundDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130846200));
            ((LinearLayout)localObject2).addView((View)localObject3, paramanxe);
            paramView.addView((View)localObject2);
            ((anxn)localObject1).jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)localObject2);
            ((anxn)localObject1).jdField_a_of_type_AndroidWidgetLinearLayout.setOnClickListener(new anxg(this, paramViewGroup));
            ((anxn)localObject1).jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
            paramView.setTag(localObject1);
            axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "ep_mall", "exp_bq_detail", 0, 0, "", this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.epId, "", "");
            localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
            localObject2 = this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.epId;
            if (!paramViewGroup.a) {
              break label1064;
            }
          }
          label1064:
          for (paramanxe = "1";; paramanxe = "2")
          {
            VasWebviewUtil.reportCommercialDrainage((String)localObject1, "ep_mall", "exp_bq_detail", null, 1, 0, 0, null, (String)localObject2, paramanxe);
            paramanxe = paramView;
            break;
            paramanxe = ajyc.a(2131701084);
            break label826;
          }
        }
      }
      label1080:
      paramanxe = paramView;
    }
  }
  
  public anxe a()
  {
    return new anxn();
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
 * Qualified Name:     anxf
 * JD-Core Version:    0.7.0.1
 */