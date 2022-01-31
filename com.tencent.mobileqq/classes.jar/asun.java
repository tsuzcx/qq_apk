import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView.Adapter;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.hotpic.HotPicData;
import com.tencent.mobileqq.hotpic.HotPicMainPanel;
import com.tencent.mobileqq.hotpic.HotPicPageView;
import com.tencent.mobileqq.hotpic.HotPicTagInfo;
import com.tencent.mobileqq.hotpic.HotVideoData;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class asun
  extends RecyclerView.Adapter<asut>
{
  public asvx a;
  public List<HotPicData> a;
  
  public asun(HotPicPageView paramHotPicPageView, int paramInt)
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  public asut a(ViewGroup paramViewGroup, int paramInt)
  {
    if (asub.a(this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPageView.jdField_a_of_type_ComTencentMobileqqHotpicHotPicMainPanel.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPageView.jdField_a_of_type_Int)) {
      return new asuq(this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPageView, LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPageView.jdField_a_of_type_AndroidContentContext).inflate(2131558582, paramViewGroup, false), this.jdField_a_of_type_Asvx);
    }
    return new asut(this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPageView, LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPageView.jdField_a_of_type_AndroidContentContext).inflate(2131558581, paramViewGroup, false), this.jdField_a_of_type_Asvx);
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilList.clear();
  }
  
  public void a(asut paramasut, int paramInt)
  {
    asuq localasuq;
    Object localObject1;
    if ((paramasut instanceof asuq))
    {
      localasuq = (asuq)paramasut;
      localasuq.d();
      localObject1 = localasuq.a();
      if (localObject1 != null)
      {
        ((HotVideoData)localObject1).SetPreviewDownloadListener(null);
        if (this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPageView.jdField_a_of_type_Asve != null) {
          this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPageView.jdField_a_of_type_Asve.a((HotVideoData)localObject1);
        }
      }
      localasuq.a(null);
    }
    for (;;)
    {
      HotPicData localHotPicData = (HotPicData)this.jdField_a_of_type_JavaUtilList.get(paramInt);
      ViewGroup.MarginLayoutParams localMarginLayoutParams1 = (ViewGroup.MarginLayoutParams)paramasut.d.getLayoutParams();
      localMarginLayoutParams1.rightMargin = HotPicPageView.e;
      localMarginLayoutParams1.leftMargin = HotPicPageView.e;
      int i;
      int k;
      int j;
      Object localObject2;
      float f;
      if ((paramInt != 0) && (paramInt != 1) && (paramInt != 2))
      {
        localMarginLayoutParams1.topMargin = (HotPicPageView.e * 2);
        i = localHotPicData.width;
        k = localHotPicData.height;
        j = HotPicPageView.d;
        if ((localHotPicData.getDataType() != 2) || (localasuq == null)) {
          break label790;
        }
        ViewGroup.MarginLayoutParams localMarginLayoutParams2 = (ViewGroup.MarginLayoutParams)localasuq.c.getLayoutParams();
        localMarginLayoutParams1.topMargin = 0;
        localMarginLayoutParams1.rightMargin = 0;
        localMarginLayoutParams1.leftMargin = 0;
        HotVideoData localHotVideoData = (HotVideoData)localHotPicData;
        localasuq.a(localHotVideoData);
        localHotVideoData.SetPreviewDownloadListener(localasuq);
        j = HotPicPageView.g;
        localObject2 = HotPicPageView.a(HotPicPageView.g, localHotVideoData.width, localHotVideoData.height, HotPicPageView.jdField_a_of_type_Double);
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = new ajsu(localHotVideoData.width, localHotVideoData.height);
        }
        f = i / ((ajsu)localObject1).a();
        i = ((ajsu)localObject1).b();
        localasuq.jdField_b_of_type_AndroidWidgetTextView.setText(localHotVideoData.getVideoLengthString());
        localasuq.a.setText(localHotVideoData.name);
        localMarginLayoutParams2.width = j;
        localMarginLayoutParams2.height = i;
        localObject1 = (ViewGroup.MarginLayoutParams)localasuq.jdField_b_of_type_AndroidWidgetImageView.getLayoutParams();
        ((ViewGroup.MarginLayoutParams)localObject1).width = j;
        ((ViewGroup.MarginLayoutParams)localObject1).height = i;
        label355:
        localMarginLayoutParams1.width = j;
        localMarginLayoutParams1.height = i;
        k = (int)(160.0F / f + 0.5F);
        localObject1 = HotPicPageView.a(localHotPicData);
        if ((localObject1 == null) || (localHotPicData.getDataType() != 2) || (localasuq == null)) {
          break label1219;
        }
        azqs.b(this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPageView.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8007EDC", "0X8007EDC", 0, 0, this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPageView.jdField_a_of_type_ComTencentMobileqqHotpicHotPicTagInfo.position + "", paramInt + "", localHotPicData.name + "", localHotPicData.url + "");
        localObject2 = (HotVideoData)localHotPicData;
        i = ((URLDrawable)localObject1).getStatus();
        if ((i != 1) && (i != 4)) {
          break label892;
        }
        if (asvr.a((HotVideoData)localObject2)) {
          break label812;
        }
        localasuq.a(-11);
        i = 1;
      }
      for (;;)
      {
        label564:
        if (localObject1 != null)
        {
          if (this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPageView.jdField_a_of_type_Int != -20)
          {
            localObject2 = this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPageView;
            if (paramInt < HotPicPageView.a(this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPageView)) {
              break label976;
            }
            j = paramInt;
            label601:
            HotPicPageView.a((HotPicPageView)localObject2, j);
            this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPageView.b.add(Integer.valueOf(paramInt));
            if (((URLDrawable)localObject1).getStatus() == 1) {
              break label988;
            }
            this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPageView.jdField_a_of_type_Asvw.a((URLDrawable)localObject1, paramInt);
            j = 16;
            if (localHotPicData.getDataType() == 2) {
              j = 8;
            }
            if (paramInt % j == 1) {
              this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPageView.m();
            }
          }
          if (localHotPicData.getDataType() == 2) {
            break label1014;
          }
          ((URLDrawable)localObject1).setTargetDensity(k);
          label696:
          if (i != 0)
          {
            if (localHotPicData.getDataType() != 2) {
              break label1025;
            }
            localasuq.a((Drawable)localObject1);
          }
          label717:
          if (this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPageView.jdField_a_of_type_ComTencentMobileqqHotpicHotPicMainPanel != null)
          {
            paramasut = this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPageView.jdField_a_of_type_ComTencentMobileqqHotpicHotPicTagInfo.position + "_" + paramInt;
            if (!this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPageView.jdField_a_of_type_ComTencentMobileqqHotpicHotPicMainPanel.jdField_a_of_type_JavaUtilSet.contains(paramasut)) {
              break label1037;
            }
          }
        }
        label648:
        label790:
        label812:
        label892:
        while (this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPageView.jdField_a_of_type_ComTencentMobileqqHotpicHotPicMainPanel.jdField_a_of_type_AndroidSupportV4ViewViewPager == null)
        {
          return;
          localMarginLayoutParams1.topMargin = 0;
          break;
          f = i / j;
          i = (int)(k / f + 0.5F);
          break label355;
          localasuq.a(0);
          if (!((HotVideoData)localObject2).CheckIsNeedBlurBackground()) {
            break label1219;
          }
          localasuq.b(new ColorDrawable(Color.parseColor("#7f000000")));
          if ((!this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPageView.a()) || (Build.VERSION.SDK_INT < 17) || (this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPageView.jdField_a_of_type_Asve == null)) {
            break label1219;
          }
          this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPageView.jdField_a_of_type_Asve.a(localasuq, (HotVideoData)localObject2);
          i = 1;
          break label564;
          if (((HotVideoData)localObject2).url.isEmpty())
          {
            i = 0;
            localasuq.a(-10);
            ((HotVideoData)localObject2).GetPreviewURLAsync(this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPageView.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 0, "0", new asuo(this, (HotVideoData)localObject2, localasuq, (URLDrawable)localObject1));
            break label564;
          }
          j = 1;
          i = j;
          if (localHotPicData.getDataType() != 2) {
            break label564;
          }
          localObject2 = (HotVideoData)localHotPicData;
          i = j;
          break label564;
          j = HotPicPageView.a(this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPageView);
          break label601;
          this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPageView.jdField_a_of_type_JavaUtilSet.add(Integer.valueOf(paramInt));
          ((URLDrawable)localObject1).setAutoDownload(true);
          break label648;
          ((URLDrawable)localObject1).setTargetDensity(160);
          break label696;
          paramasut.d.setImageDrawable((Drawable)localObject1);
          break label717;
        }
        label976:
        label988:
        label1014:
        if (this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPageView.jdField_a_of_type_ComTencentMobileqqHotpicHotPicMainPanel.jdField_a_of_type_AndroidSupportV4ViewViewPager.getCurrentItem() == this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPageView.jdField_a_of_type_ComTencentMobileqqHotpicHotPicTagInfo.position)
        {
          this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPageView.a("0X8007EDD", this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPageView.jdField_a_of_type_ComTencentMobileqqHotpicHotPicTagInfo.position + "", paramInt + "", this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPageView.jdField_a_of_type_ComTencentMobileqqHotpicHotPicTagInfo.tagName + "", localHotPicData.url + "");
          this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPageView.jdField_a_of_type_ComTencentMobileqqHotpicHotPicMainPanel.jdField_a_of_type_JavaUtilSet.add(paramasut);
          return;
        }
        label1025:
        label1037:
        HotPicPageView.a(this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPageView).put(paramInt, localHotPicData.url);
        return;
        label1219:
        i = 1;
      }
      localasuq = null;
    }
  }
  
  public void a(List<? extends HotPicData> paramList)
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_JavaUtilList.addAll(paramList);
  }
  
  public int getItemCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asun
 * JD-Core Version:    0.7.0.1
 */