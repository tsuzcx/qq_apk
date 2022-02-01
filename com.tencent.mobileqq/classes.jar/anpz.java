import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.apollo.data.ApolloGameRedDot;
import com.tencent.mobileqq.apollo.utils.ApolloGameUtil;
import com.tencent.mobileqq.apollo.view.pannel.viewbinder.ApolloGameViewBinder.GameListAdapter.1;
import com.tencent.mobileqq.apollo.view.pannel.viewbinder.ApolloGameViewBinder.GameListAdapter.2;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.ApolloGameData;
import com.tencent.mobileqq.data.ApolloGameRankData;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.redtouch.RedTouch;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.RedTypeInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class anpz
  extends BaseAdapter
  implements View.OnClickListener
{
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private blhb jdField_a_of_type_Blhb;
  private WeakReference<anpu> jdField_a_of_type_JavaLangRefWeakReference;
  private List<ApolloGameData> jdField_a_of_type_JavaUtilList;
  private int b;
  
  public anpz(Context paramContext, anpu paramanpu)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramanpu);
    long l = Math.min(DeviceInfoUtil.getPortraitWidth(), DeviceInfoUtil.getPortraitHeight());
    this.jdField_a_of_type_Int = ((int)((float)l - 30.0F * DeviceInfoUtil.getDesity()) / 3);
    this.b = ((int)(9.0D * (this.jdField_a_of_type_Int / 16.0D)));
    QLog.i("GameListAdapter", 1, "screenWidth:" + l + ",itemWidth:" + this.jdField_a_of_type_Int + ",itemHeight:" + this.b);
  }
  
  public void a()
  {
    b();
  }
  
  public void a(ViewGroup paramViewGroup, anqc paramanqc)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GameListAdapter", 2, "[showHighLightGame] ");
    }
    if (paramanqc.jdField_a_of_type_AndroidViewView != null)
    {
      paramViewGroup.removeView(paramanqc.jdField_a_of_type_AndroidViewView);
      paramanqc.jdField_a_of_type_AndroidViewView = null;
    }
    paramViewGroup.setClipChildren(true);
    paramViewGroup.setClipToPadding(true);
    Object localObject = new RelativeLayout.LayoutParams(-1, -1);
    ((RelativeLayout.LayoutParams)localObject).addRule(5, 2131369016);
    ((RelativeLayout.LayoutParams)localObject).addRule(7, 2131369016);
    ((RelativeLayout.LayoutParams)localObject).addRule(6, 2131369016);
    ((RelativeLayout.LayoutParams)localObject).addRule(8, 2131369016);
    RelativeLayout localRelativeLayout = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
    localRelativeLayout.setId(2131362763);
    localRelativeLayout.setBackgroundDrawable(null);
    paramViewGroup.addView(localRelativeLayout, (ViewGroup.LayoutParams)localObject);
    paramanqc.jdField_a_of_type_AndroidViewView = localRelativeLayout;
    localObject = new ImageView(this.jdField_a_of_type_AndroidContentContext);
    ((ImageView)localObject).setImageResource(2130838639);
    ((ImageView)localObject).setVisibility(8);
    ((ImageView)localObject).setScaleType(ImageView.ScaleType.FIT_XY);
    localRelativeLayout.addView((View)localObject, new RelativeLayout.LayoutParams(this.jdField_a_of_type_Int, this.b));
    ((ImageView)localObject).setVisibility(8);
    ((ImageView)localObject).postDelayed(new ApolloGameViewBinder.GameListAdapter.2(this, (ImageView)localObject, localRelativeLayout, paramViewGroup, paramanqc), 400L);
  }
  
  public void a(List<ApolloGameData> paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Blhb != null) {
      this.jdField_a_of_type_Blhb.dismiss();
    }
  }
  
  public int getCount()
  {
    int i;
    if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.size() == 0)) {
      i = 0;
    }
    int k;
    int j;
    do
    {
      return i;
      k = this.jdField_a_of_type_JavaUtilList.size();
      j = k / 3;
      i = j;
    } while (k % 3 == 0);
    return j + 1;
  }
  
  public Object getItem(int paramInt)
  {
    Object localObject;
    if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.size() == 0))
    {
      localObject = null;
      return localObject;
    }
    ArrayList localArrayList = new ArrayList(3);
    int i = paramInt * 3;
    paramInt = i;
    for (;;)
    {
      localObject = localArrayList;
      if (paramInt >= i + 3) {
        break;
      }
      localObject = localArrayList;
      if (paramInt < 0) {
        break;
      }
      localObject = localArrayList;
      if (paramInt >= this.jdField_a_of_type_JavaUtilList.size()) {
        break;
      }
      localArrayList.add(this.jdField_a_of_type_JavaUtilList.get(paramInt));
      paramInt += 1;
    }
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    anqc localanqc;
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558683, paramViewGroup, false);
      localanqc = new anqc(null);
      localanqc.jdField_a_of_type_ArrayOfAndroidViewViewGroup[0] = ((ViewGroup)paramView.findViewById(2131369009));
      localanqc.jdField_a_of_type_ArrayOfComTencentImageURLImageView[0] = ((URLImageView)paramView.findViewById(2131369010));
      localanqc.jdField_a_of_type_ArrayOfAndroidWidgetTextView[0] = ((TextView)paramView.findViewById(2131369011));
      localanqc.jdField_a_of_type_ArrayOfAndroidWidgetImageView[0] = ((ImageView)paramView.findViewById(2131369012));
      localanqc.jdField_a_of_type_ArrayOfComTencentImageURLImageView[0].setLayoutParams(new RelativeLayout.LayoutParams(this.jdField_a_of_type_Int, this.b));
      localanqc.b[0] = ((ImageView)paramView.findViewById(2131369013));
      localanqc.jdField_a_of_type_ArrayOfAndroidViewViewGroup[1] = ((ViewGroup)paramView.findViewById(2131369015));
      localanqc.jdField_a_of_type_ArrayOfComTencentImageURLImageView[1] = ((URLImageView)paramView.findViewById(2131369016));
      localanqc.jdField_a_of_type_ArrayOfAndroidWidgetTextView[1] = ((TextView)paramView.findViewById(2131369017));
      localanqc.jdField_a_of_type_ArrayOfAndroidWidgetImageView[1] = ((ImageView)paramView.findViewById(2131369018));
      localanqc.jdField_a_of_type_ArrayOfComTencentImageURLImageView[1].setLayoutParams(new RelativeLayout.LayoutParams(this.jdField_a_of_type_Int, this.b));
      localanqc.b[1] = ((ImageView)paramView.findViewById(2131369019));
      localanqc.jdField_a_of_type_ArrayOfAndroidViewViewGroup[2] = ((ViewGroup)paramView.findViewById(2131369021));
      localanqc.jdField_a_of_type_ArrayOfComTencentImageURLImageView[2] = ((URLImageView)paramView.findViewById(2131369022));
      localanqc.jdField_a_of_type_ArrayOfAndroidWidgetTextView[2] = ((TextView)paramView.findViewById(2131369023));
      localanqc.jdField_a_of_type_ArrayOfAndroidWidgetImageView[2] = ((ImageView)paramView.findViewById(2131369024));
      localanqc.jdField_a_of_type_ArrayOfComTencentImageURLImageView[2].setLayoutParams(new RelativeLayout.LayoutParams(this.jdField_a_of_type_Int, this.b));
      localanqc.b[2] = ((ImageView)paramView.findViewById(2131369025));
      paramView.setTag(localanqc);
      localObject1 = (anpu)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (localObject1 == null) {
        break label1635;
      }
      anpu.a((anpu)localObject1);
    }
    label417:
    label721:
    label1626:
    label1629:
    label1635:
    for (Object localObject1 = anpu.a((anpu)localObject1);; localObject1 = null)
    {
      ArrayList localArrayList = (ArrayList)getItem(paramInt);
      int i;
      ApolloGameData localApolloGameData;
      Object localObject3;
      if ((localArrayList != null) && (localArrayList.size() > 0))
      {
        i = 0;
        if (i >= 3) {
          break label1610;
        }
        if (i < localArrayList.size())
        {
          localApolloGameData = (ApolloGameData)localArrayList.get(i);
          localanqc.jdField_a_of_type_ArrayOfAndroidViewViewGroup[i].setVisibility(0);
          localanqc.jdField_a_of_type_ArrayOfAndroidViewViewGroup[i].setTag(localApolloGameData);
          localanqc.jdField_a_of_type_ArrayOfAndroidViewViewGroup[i].setOnClickListener(this);
          localanqc.jdField_a_of_type_ArrayOfAndroidWidgetTextView[i].setText(localApolloGameData.name);
          if (localObject1 == null) {
            break label1629;
          }
          localObject2 = (SparseArray)((SparseArray)localObject1).get(localApolloGameData.gameId);
          if ((localObject2 == null) || (((SparseArray)localObject2).size() <= 0)) {
            break label1629;
          }
          localObject3 = (ApolloGameRedDot)((SparseArray)localObject2).get(1002);
          localObject3 = (ApolloGameRedDot)((SparseArray)localObject2).get(1001);
          localObject3 = (ApolloGameRedDot)((SparseArray)localObject2).get(1005);
        }
      }
      for (Object localObject2 = (ApolloGameRedDot)((SparseArray)localObject2).get(1000);; localObject2 = null)
      {
        label617:
        int j;
        if (localApolloGameData.isGameApp)
        {
          localanqc.jdField_a_of_type_ArrayOfAndroidWidgetImageView[i].setImageResource(2130838543);
          localanqc.jdField_a_of_type_ArrayOfAndroidWidgetImageView[i].setVisibility(0);
          int k = 0;
          j = k;
          if (localObject2 != null)
          {
            j = k;
            if (!((ApolloGameRedDot)localObject2).mIsShow) {
              j = 1;
            }
          }
          if (j == 0) {
            break label1455;
          }
          localObject2 = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130850427);
          ((Drawable)localObject2).setBounds(0, 0, ((Drawable)localObject2).getIntrinsicWidth(), ((Drawable)localObject2).getIntrinsicHeight());
          localanqc.jdField_a_of_type_ArrayOfAndroidWidgetTextView[i].setCompoundDrawablePadding(AIOUtils.dp2px(5.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
          localanqc.jdField_a_of_type_ArrayOfAndroidWidgetTextView[i].setCompoundDrawables((Drawable)localObject2, null, null, null);
          if (TextUtils.isEmpty(localApolloGameData.listCoverUrl)) {
            break label1485;
          }
          localObject2 = this.jdField_a_of_type_AndroidContentContext.getResources();
          localObject3 = URLDrawable.URLDrawableOptions.obtain();
          ((URLDrawable.URLDrawableOptions)localObject3).mLoadingDrawable = ((Resources)localObject2).getDrawable(2130838613);
          ((URLDrawable.URLDrawableOptions)localObject3).mFailedDrawable = ((Resources)localObject2).getDrawable(2130838613);
          ((URLDrawable.URLDrawableOptions)localObject3).mRequestWidth = this.jdField_a_of_type_Int;
          ((URLDrawable.URLDrawableOptions)localObject3).mRequestHeight = this.b;
          localObject2 = URLDrawable.getDrawable(localApolloGameData.listCoverUrl, (URLDrawable.URLDrawableOptions)localObject3);
          localanqc.jdField_a_of_type_ArrayOfComTencentImageURLImageView[i].setImageDrawable((Drawable)localObject2);
          j = paramInt * 3 + i;
          if ((this.jdField_a_of_type_JavaLangRefWeakReference == null) || (this.jdField_a_of_type_JavaLangRefWeakReference.get() == null) || (amsn.a("aio.city.game", ((anpu)this.jdField_a_of_type_JavaLangRefWeakReference.get()).jdField_a_of_type_ComTencentMobileqqAppQQAppInterface) != amso.d)) {
            break label1626;
          }
          j -= 1;
        }
        for (;;)
        {
          if ((j < ApolloGameUtil.a()) && (this.jdField_a_of_type_JavaLangRefWeakReference != null) && (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null) && (((anpu)this.jdField_a_of_type_JavaLangRefWeakReference.get()).a(localApolloGameData.gameId)) && (localanqc.b[i].getVisibility() != 0))
          {
            localObject2 = localanqc.b[i];
            ((ImageView)localObject2).setVisibility(0);
            localObject3 = new RedTouch(this.jdField_a_of_type_AndroidContentContext, (View)localObject2).b(19).a();
            BusinessInfoCheckUpdate.RedTypeInfo localRedTypeInfo = new BusinessInfoCheckUpdate.RedTypeInfo();
            localRedTypeInfo.red_type.set(4);
            localRedTypeInfo.red_content.set(anvx.a(2131699847));
            localRedTypeInfo.red_desc.set("{'cn':'#FF0000', 'av':1}");
            ((RedTouch)localObject3).a(localRedTypeInfo);
            ((ImageView)localObject2).setTag(localObject3);
            if (anpu.jdField_a_of_type_Long == 0L) {
              anpu.jdField_a_of_type_Long = System.currentTimeMillis();
            }
            if ((this.jdField_a_of_type_JavaLangRefWeakReference != null) && (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null)) {
              VipUtils.a(((anpu)this.jdField_a_of_type_JavaLangRefWeakReference.get()).jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "cmshow", "Apollo", "beyond_notice", 0, 0, new String[] { String.valueOf(localApolloGameData.gameId) });
            }
            if (anpu.jdField_a_of_type_Boolean)
            {
              anpu.jdField_a_of_type_Boolean = false;
              localObject3 = ApolloGameUtil.a();
              if (localObject3 != null) {
                ((SharedPreferences)localObject3).edit().putBoolean("sp.aio.show", false).apply();
              }
              if (QLog.isColorLevel()) {
                QLog.d("GameListAdapter", 2, "show guide window");
              }
              ((ImageView)localObject2).postDelayed(new ApolloGameViewBinder.GameListAdapter.1(this, (ImageView)localObject2), 200L);
            }
            if ((this.jdField_a_of_type_JavaLangRefWeakReference != null) && (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null) && (anpu.a((anpu)this.jdField_a_of_type_JavaLangRefWeakReference.get()) != null) && (localApolloGameData.gameId == anpu.a((anpu)this.jdField_a_of_type_JavaLangRefWeakReference.get()).jdField_a_of_type_Int))
            {
              a(localanqc.jdField_a_of_type_ArrayOfAndroidViewViewGroup[i], localanqc);
              localObject2 = (amma)((anpu)this.jdField_a_of_type_JavaLangRefWeakReference.get()).jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.APOLLO_GAME_MANAGER);
              ((amma)localObject2).a(-1, -1);
              ((anpu)this.jdField_a_of_type_JavaLangRefWeakReference.get()).a(((amma)localObject2).a());
            }
          }
          for (;;)
          {
            i += 1;
            break label417;
            localanqc = (anqc)paramView.getTag();
            break;
            if (!TextUtils.isEmpty(localApolloGameData.tagUrl))
            {
              localanqc.jdField_a_of_type_ArrayOfAndroidWidgetImageView[i].setImageDrawable(anev.a(String.valueOf(localApolloGameData.tagUrl.hashCode()), null, localApolloGameData.tagUrl, true));
              localanqc.jdField_a_of_type_ArrayOfAndroidWidgetImageView[i].setVisibility(0);
              VipUtils.a(((anpu)this.jdField_a_of_type_JavaLangRefWeakReference.get()).jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "cmshow", "Apollo", "showtag", 0, 0, new String[] { String.valueOf(localApolloGameData.gameId), String.valueOf(paramInt * 3 + i), String.valueOf(localApolloGameData.tagType) });
              break label617;
            }
            localanqc.jdField_a_of_type_ArrayOfAndroidWidgetImageView[i].setVisibility(8);
            break label617;
            localanqc.jdField_a_of_type_ArrayOfAndroidWidgetTextView[i].setCompoundDrawablePadding(0);
            localanqc.jdField_a_of_type_ArrayOfAndroidWidgetTextView[i].setCompoundDrawables(null, null, null, null);
            break label721;
            localanqc.jdField_a_of_type_ArrayOfComTencentImageURLImageView[i].setImageResource(2130838613);
            break label815;
            if ((localanqc.b[i].getTag() != null) && ((localanqc.b[i].getTag() instanceof RedTouch))) {
              ((RedTouch)localanqc.b[i].getTag()).d();
            }
            localanqc.b[i].setVisibility(4);
            break label1175;
            localanqc.jdField_a_of_type_ArrayOfAndroidViewViewGroup[i].setVisibility(4);
          }
          i = 0;
          while (i < 3)
          {
            localanqc.jdField_a_of_type_ArrayOfAndroidViewViewGroup[i].setVisibility(4);
            i += 1;
          }
          EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
          return paramView;
        }
      }
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    ApolloGameData localApolloGameData;
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      localApolloGameData = (ApolloGameData)paramView.getTag();
      if (localApolloGameData != null) {
        break;
      }
      QLog.e("GameListAdapter", 1, "[onClick] no game data");
    }
    anpu localanpu = (anpu)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    Object localObject1;
    if (localanpu != null) {
      if (anpu.a(localanpu) != null) {
        if (paramView.getId() == 2131369009) {
          localObject1 = paramView.findViewById(2131369013);
        }
      }
    }
    for (;;)
    {
      label116:
      if ((localObject1 != null) && (((View)localObject1).getVisibility() == 0))
      {
        ((View)localObject1).setVisibility(8);
        if ((((View)localObject1).getTag() != null) && ((((View)localObject1).getTag() instanceof RedTouch))) {
          ((RedTouch)((View)localObject1).getTag()).d();
        }
        VipUtils.a(((anpu)this.jdField_a_of_type_JavaLangRefWeakReference.get()).jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "cmshow", "Apollo", "beyond_notice_disappear", 1, 0, new String[] { String.valueOf(localApolloGameData.gameId) });
      }
      localObject1 = anpu.a(localanpu);
      label231:
      Object localObject2;
      if ((localObject1 != null) && (((List)localObject1).size() > 0))
      {
        Iterator localIterator = ((List)localObject1).iterator();
        localObject1 = null;
        if (localIterator.hasNext())
        {
          localObject2 = (ApolloGameRankData)localIterator.next();
          if ((localObject2 == null) || (((ApolloGameRankData)localObject2).mGameId != localApolloGameData.gameId)) {
            break label421;
          }
          localObject1 = localObject2;
        }
      }
      label421:
      for (;;)
      {
        for (;;)
        {
          break label231;
          if (paramView.getId() == 2131369015)
          {
            localObject1 = paramView.findViewById(2131369019);
            break label116;
          }
          if (paramView.getId() != 2131369021) {
            break label424;
          }
          localObject1 = paramView.findViewById(2131369025);
          break label116;
          localObject2 = anpu.a(localanpu);
          if (localObject1 != null) {}
          try
          {
            ((ApolloGameRankData)localObject1).mValidTime = (System.currentTimeMillis() - 1000L);
            ApolloGameUtil.a(localanpu.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (ApolloGameRankData)localObject1);
            anpu.a(localanpu).remove(localObject1);
            if (QLog.isColorLevel()) {
              QLog.d("GameListAdapter", 2, new Object[] { "[onClick] remove red corner for ", Integer.valueOf(localApolloGameData.gameId) });
            }
            anpu.c(localanpu, localApolloGameData);
            break;
          }
          finally {}
        }
        QLog.e("GameListAdapter", 1, "[onClick] binder null");
        break;
      }
      label424:
      localObject1 = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anpz
 * JD-Core Version:    0.7.0.1
 */