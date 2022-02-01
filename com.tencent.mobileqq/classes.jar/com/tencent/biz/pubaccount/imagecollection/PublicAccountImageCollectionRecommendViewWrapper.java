package com.tencent.biz.pubaccount.imagecollection;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.os.Build.VERSION;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.pubaccount.imagecollection.api.IPublicAccountImageCollectionUtils.RecommendItemInfo;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.kandian.base.view.widget.VideoFeedsAlphaMaskView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AdapterView.OnItemClickListener;
import com.tencent.widget.GridView;
import java.util.ArrayList;

public class PublicAccountImageCollectionRecommendViewWrapper
{
  static boolean a = false;
  static ArrayList<IPublicAccountImageCollectionUtils.RecommendItemInfo> b = new ArrayList();
  private static Context d;
  private static int f;
  private static int g;
  protected AdapterView.OnItemClickListener c = new PublicAccountImageCollectionRecommendViewWrapper.1(this);
  private Activity e;
  
  public PublicAccountImageCollectionRecommendViewWrapper(Activity paramActivity, ArrayList<IPublicAccountImageCollectionUtils.RecommendItemInfo> paramArrayList, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    this.e = paramActivity;
    d = paramActivity.getApplicationContext();
    f = paramInt1;
    g = paramInt2;
    a = paramBoolean;
    b = b(paramArrayList);
  }
  
  static int a()
  {
    ArrayList localArrayList = b;
    if (localArrayList == null) {
      return 0;
    }
    int i = localArrayList.size();
    int j = (f - AIOUtils.b(110.0F, d.getResources())) / 3;
    if (i % 2 == 0) {
      i /= 2;
    } else {
      i = (i + 1) / 2;
    }
    return i * j;
  }
  
  @TargetApi(9)
  private void a(RelativeLayout paramRelativeLayout)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PublicAccountImageCollectionRecommendViewWrapper", 2, "buildView!");
    }
    int i = AIOUtils.b(2.0F, d.getResources());
    int j = (g - i) / 2;
    paramRelativeLayout = (GridView)paramRelativeLayout.findViewById(2131444447);
    paramRelativeLayout.setColumnWidth(j);
    paramRelativeLayout.setStretchMode(0);
    paramRelativeLayout.setHorizontalSpacing(i);
    paramRelativeLayout.setLayoutParams(new RelativeLayout.LayoutParams(-1, a()));
    paramRelativeLayout.setNumColumns(2);
    paramRelativeLayout.setOnItemClickListener(this.c);
    if (Build.VERSION.SDK_INT >= 9) {
      paramRelativeLayout.setOverScrollMode(2);
    }
    paramRelativeLayout.setAdapter(new PublicAccountImageCollectionRecommendViewWrapper.PhotoAdapter(this));
  }
  
  private ArrayList<IPublicAccountImageCollectionUtils.RecommendItemInfo> b(ArrayList<IPublicAccountImageCollectionUtils.RecommendItemInfo> paramArrayList)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramArrayList == null) {
      return null;
    }
    if (paramArrayList.size() <= 6)
    {
      localArrayList.addAll(paramArrayList);
      return localArrayList;
    }
    int i = 0;
    while (i < 6)
    {
      localArrayList.add(paramArrayList.get(i));
      i += 1;
    }
    return localArrayList;
  }
  
  public View a(Activity paramActivity, View paramView, ViewGroup paramViewGroup)
  {
    if ((paramView != null) && ((paramView instanceof RelativeLayout)))
    {
      paramView = (RelativeLayout)paramView;
      Object localObject = paramView.getTag();
      if ((localObject != null) && ((localObject instanceof PublicAccountImageCollectionRecommendViewWrapper.RecommendHolder)))
      {
        if (QLog.isDevelopLevel()) {
          QLog.d("PublicAccountImageCollectionRecommendViewWrapper", 2, "createView reuse!");
        }
        return paramView;
      }
    }
    if (QLog.isDevelopLevel()) {
      QLog.d("PublicAccountImageCollectionRecommendViewWrapper", 2, "createView new create!");
    }
    paramActivity = (RelativeLayout)LayoutInflater.from(paramActivity).inflate(2131625614, paramViewGroup, false);
    paramView = paramActivity.getLayoutParams();
    paramView.height = f;
    paramActivity.setLayoutParams(paramView);
    paramView = new PublicAccountImageCollectionRecommendViewWrapper.RecommendHolder();
    paramView.a = ((GridView)paramActivity.findViewById(2131444447));
    paramView.b = ((VideoFeedsAlphaMaskView)paramActivity.findViewById(2131437989));
    paramView.c = ((TextView)paramActivity.findViewById(2131444433));
    paramActivity.setTag(paramView);
    if ((b == null) && (a))
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("PublicAccountImageCollectionRecommendViewWrapper", 2, "createView getRecommendInfo error");
      }
      paramView.a.setVisibility(8);
      paramView.c.setVisibility(0);
      paramViewGroup = paramView.b.getLayoutParams();
      int i = AIOUtils.b(66.0F, d.getResources());
      paramViewGroup.height = (f - i);
      paramView.b.setLayoutParams(paramViewGroup);
      return paramActivity;
    }
    paramViewGroup = paramView.b.getLayoutParams();
    paramViewGroup.height = a();
    paramView.b.setLayoutParams(paramViewGroup);
    paramView.a.setVisibility(0);
    paramView.c.setVisibility(8);
    a(paramActivity);
    return paramActivity;
  }
  
  public void a(ArrayList<IPublicAccountImageCollectionUtils.RecommendItemInfo> paramArrayList)
  {
    b = b(paramArrayList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.imagecollection.PublicAccountImageCollectionRecommendViewWrapper
 * JD-Core Version:    0.7.0.1
 */