package com.tencent.mobileqq.activity.contact.addcontact;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.biz.pubaccount.api.IPublicAccountSearchRecommendManager;
import com.tencent.biz.pubaccount.api.IPublicAccountSearchRecommendManager.GetRecommendListListener;
import com.tencent.biz.pubaccount.api.IPublicAccountSearchRecommendManager.PublicAccountSearchRecommendItem;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.recent.RecentFaceDecoder;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.GridView;
import java.util.ArrayList;
import java.util.Iterator;

public class ClassificationSearchFragment$HistoryGridAdapter
  extends BaseAdapter
  implements IPublicAccountSearchRecommendManager.GetRecommendListListener, DecodeTaskCompletionListener
{
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new ClassificationSearchFragment.HistoryGridAdapter.1(this);
  private RecentFaceDecoder jdField_a_of_type_ComTencentMobileqqActivityRecentRecentFaceDecoder = new RecentFaceDecoder(paramClassificationSearchFragment.a, this, false);
  private String jdField_a_of_type_JavaLangString;
  private ArrayList<IPublicAccountSearchRecommendManager.PublicAccountSearchRecommendItem> jdField_a_of_type_JavaUtilArrayList;
  private boolean jdField_a_of_type_Boolean = false;
  
  public ClassificationSearchFragment$HistoryGridAdapter(ClassificationSearchFragment paramClassificationSearchFragment)
  {
    a(true);
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public ArrayList<IPublicAccountSearchRecommendManager.PublicAccountSearchRecommendItem> a()
  {
    return this.jdField_a_of_type_JavaUtilArrayList;
  }
  
  public void a()
  {
    RecentFaceDecoder localRecentFaceDecoder = this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentFaceDecoder;
    if (localRecentFaceDecoder != null) {
      localRecentFaceDecoder.a();
    }
  }
  
  public void a(ArrayList<IPublicAccountSearchRecommendManager.PublicAccountSearchRecommendItem> paramArrayList, String paramString, boolean paramBoolean)
  {
    this.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Boolean = paramBoolean;
    if (ClassificationSearchFragment.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactClassificationSearchFragment) != null) {
      if (getCount() == 0)
      {
        ((TextView)ClassificationSearchFragment.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactClassificationSearchFragment).findViewById(2131377061)).setText(HardCodeUtil.a(2131702114));
        ClassificationSearchFragment.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactClassificationSearchFragment).setVisibility(8);
      }
      else
      {
        if (TextUtils.isEmpty(paramString)) {
          ((TextView)ClassificationSearchFragment.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactClassificationSearchFragment).findViewById(2131377061)).setText(HardCodeUtil.a(2131702119));
        } else {
          ((TextView)ClassificationSearchFragment.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactClassificationSearchFragment).findViewById(2131377061)).setText(paramString);
        }
        ClassificationSearchFragment.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactClassificationSearchFragment).setVisibility(0);
        notifyDataSetChanged();
      }
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onGetRecommendSuccess->isFromRecommend:");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append(", title:");
      localStringBuilder.append(paramString);
      localStringBuilder.append(", list:");
      paramString = new StringBuilder(localStringBuilder.toString());
      if (paramArrayList == null)
      {
        paramString.append("null");
      }
      else
      {
        paramString.append("size:");
        paramString.append(paramArrayList.size());
      }
      QLog.d("ClassificationSearchFragment", 2, paramString.toString());
      if ((paramArrayList != null) && (paramArrayList.size() > 0))
      {
        paramArrayList = paramArrayList.iterator();
        while (paramArrayList.hasNext())
        {
          paramString = (IPublicAccountSearchRecommendManager.PublicAccountSearchRecommendItem)paramArrayList.next();
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("onGetRecommendSuccess->");
          localStringBuilder.append(paramString.toString());
          QLog.d("ClassificationSearchFragment", 2, localStringBuilder.toString());
        }
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    ((IPublicAccountSearchRecommendManager)QRoute.api(IPublicAccountSearchRecommendManager.class)).getRecommendList(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactClassificationSearchFragment.a, paramBoolean, this);
  }
  
  public int getCount()
  {
    ArrayList localArrayList = this.jdField_a_of_type_JavaUtilArrayList;
    if (localArrayList == null) {
      return 0;
    }
    return localArrayList.size();
  }
  
  public Object getItem(int paramInt)
  {
    ArrayList localArrayList = this.jdField_a_of_type_JavaUtilArrayList;
    if ((localArrayList != null) && (paramInt < localArrayList.size())) {
      return this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView = paramView;
    if (paramView == null) {
      localView = LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactClassificationSearchFragment.getBaseActivity()).inflate(2131559626, null);
    }
    paramView = (IPublicAccountSearchRecommendManager.PublicAccountSearchRecommendItem)getItem(paramInt);
    if (paramView != null)
    {
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentFaceDecoder;
      if (localObject != null)
      {
        localObject = ((RecentFaceDecoder)localObject).a(1008, paramView.jdField_a_of_type_JavaLangString);
        ((URLImageView)localView.findViewById(2131368033)).setImageDrawable((Drawable)localObject);
      }
      ((TextView)localView.findViewById(2131371697)).setText(paramView.b);
      localView.findViewById(2131365132).setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      localView.findViewById(2131365132).setTag(paramView);
      localView.setTag(paramView);
    }
    EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
    return localView;
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    if (ClassificationSearchFragment.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactClassificationSearchFragment) != null)
    {
      if (TextUtils.isEmpty(paramString)) {
        return;
      }
      if ((paramBitmap == null) && (paramInt1 > 0)) {
        return;
      }
      if (paramBitmap != null)
      {
        GridView localGridView = (GridView)ClassificationSearchFragment.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactClassificationSearchFragment).findViewById(2131377058);
        paramInt2 = localGridView.getChildCount();
        paramInt1 = 0;
        while (paramInt1 < paramInt2)
        {
          View localView = localGridView.getChildAt(paramInt1);
          if (paramString.equals(((IPublicAccountSearchRecommendManager.PublicAccountSearchRecommendItem)localView.getTag()).jdField_a_of_type_JavaLangString)) {
            ((URLImageView)localView.findViewById(2131368033)).setImageBitmap(paramBitmap);
          }
          paramInt1 += 1;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.addcontact.ClassificationSearchFragment.HistoryGridAdapter
 * JD-Core Version:    0.7.0.1
 */