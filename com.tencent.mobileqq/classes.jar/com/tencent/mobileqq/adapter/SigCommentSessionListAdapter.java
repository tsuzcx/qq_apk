package com.tencent.mobileqq.adapter;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.SigCommentListActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.SignatureManager;
import com.tencent.mobileqq.app.SignatureManager.SigCommentInfo;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AbsListView.LayoutParams;
import com.tencent.widget.XListView;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import mqq.os.MqqHandler;

public class SigCommentSessionListAdapter
  extends BaseAdapter
  implements View.OnClickListener
{
  public int a = -1;
  private QQAppInterface b;
  private SigCommentListActivity c;
  private LayoutInflater d;
  private ArrayList<SignatureManager.SigCommentInfo> e = new ArrayList();
  private SignatureManager f = null;
  private XListView g;
  private View h;
  private View i;
  private boolean j;
  
  public SigCommentSessionListAdapter(SigCommentListActivity paramSigCommentListActivity, QQAppInterface paramQQAppInterface, XListView paramXListView, View paramView)
  {
    this.c = paramSigCommentListActivity;
    this.d = LayoutInflater.from(paramSigCommentListActivity);
    this.g = paramXListView;
    this.b = paramQQAppInterface;
    this.f = ((SignatureManager)this.b.getManager(QQManagerFactory.SIGNATURE_MANAGER));
    this.h = paramView;
  }
  
  private void a(String paramString, TextView paramTextView)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    Object localObject = (SignatureManager)this.b.getManager(QQManagerFactory.SIGNATURE_MANAGER);
    if (localObject != null)
    {
      paramString = ((SignatureManager)localObject).a(paramString);
      if (paramString != null)
      {
        localObject = new StringBuilder();
        if (!TextUtils.isEmpty(paramString.actionText))
        {
          ((StringBuilder)localObject).append(paramString.actionText);
          if (!TextUtils.isEmpty(paramString.dataText)) {
            ((StringBuilder)localObject).append(paramString.dataText);
          }
          ((StringBuilder)localObject).append(' ');
        }
        if (!TextUtils.isEmpty(paramString.getPlainText())) {
          ((StringBuilder)localObject).append(paramString.getPlainText());
        }
        paramTextView.setText(((StringBuilder)localObject).toString());
      }
    }
  }
  
  public SignatureManager.SigCommentInfo a(int paramInt)
  {
    ArrayList localArrayList = this.e;
    if ((localArrayList != null) && (paramInt >= 0) && (paramInt < localArrayList.size())) {
      return (SignatureManager.SigCommentInfo)this.e.get(paramInt);
    }
    return null;
  }
  
  public List<SignatureManager.SigCommentInfo> a()
  {
    if (this.e.size() == 0) {
      return null;
    }
    return (ArrayList)this.e.clone();
  }
  
  public void a(List<SignatureManager.SigCommentInfo> paramList, boolean paramBoolean)
  {
    if (paramList != this.e) {
      this.e = ((ArrayList)paramList);
    }
    this.j = paramBoolean;
  }
  
  public void b(int paramInt)
  {
    View localView = this.i;
    if (localView != null) {
      ((SigCommentSessionListAdapter.MoreViewHolder)localView.getTag()).a.setText(paramInt);
    }
  }
  
  public int getCount()
  {
    ArrayList localArrayList = this.e;
    int k;
    if (localArrayList != null) {
      k = localArrayList.size();
    } else {
      k = 0;
    }
    if (k == 0) {
      return 1;
    }
    return k + (true ^ this.j);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public int getItemViewType(int paramInt)
  {
    ArrayList localArrayList = this.e;
    if ((localArrayList != null) && (localArrayList.size() != 0))
    {
      if (paramInt == this.e.size()) {
        return 2;
      }
      return 1;
    }
    return 0;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    int k = getItemViewType(paramInt);
    Object localObject1;
    if (k == 0)
    {
      this.h.setLayoutParams(new AbsListView.LayoutParams(this.g.getWidth(), this.g.getHeight()));
      localObject1 = this.h;
    }
    else if (1 == k)
    {
      if (paramView == null)
      {
        paramView = this.d.inflate(2131629309, this.g, false);
        localObject1 = new SigCommentSessionListAdapter.ViewHolder();
        ((SigCommentSessionListAdapter.ViewHolder)localObject1).a = ((ImageView)paramView.findViewById(2131445993));
        ((SigCommentSessionListAdapter.ViewHolder)localObject1).b = ((TextView)paramView.findViewById(2131445994));
        ((SigCommentSessionListAdapter.ViewHolder)localObject1).c = ((ImageView)paramView.findViewById(2131445991));
        ((SigCommentSessionListAdapter.ViewHolder)localObject1).d = ((TextView)paramView.findViewById(2131445992));
        ((SigCommentSessionListAdapter.ViewHolder)localObject1).e = ((TextView)paramView.findViewById(2131445995));
        paramView.setTag(localObject1);
      }
      else
      {
        localObject1 = (SigCommentSessionListAdapter.ViewHolder)paramView.getTag();
      }
      SignatureManager.SigCommentInfo localSigCommentInfo = a(paramInt);
      Object localObject2 = String.valueOf(localSigCommentInfo.uin);
      Object localObject3 = FaceDrawable.getFaceDrawable(this.b, 1, (String)localObject2);
      if (localObject3 != null) {
        ((SigCommentSessionListAdapter.ViewHolder)localObject1).a.setImageDrawable((Drawable)localObject3);
      }
      localObject2 = ContactUtils.g(this.b, (String)localObject2);
      ((SigCommentSessionListAdapter.ViewHolder)localObject1).b.setText((CharSequence)localObject2);
      ((SigCommentSessionListAdapter.ViewHolder)localObject1).c.setBackgroundResource(2130852161);
      localObject2 = Calendar.getInstance();
      ((Calendar)localObject2).setTimeInMillis(localSigCommentInfo.time * 1000L);
      k = ((Calendar)localObject2).get(9);
      localObject2 = new SimpleDateFormat("hh:mm").format(new Date(localSigCommentInfo.time * 1000L));
      if (k == 0)
      {
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append(HardCodeUtil.a(2131911514));
        ((StringBuilder)localObject3).append((String)localObject2);
        localObject2 = ((StringBuilder)localObject3).toString();
      }
      else
      {
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append(HardCodeUtil.a(2131911511));
        ((StringBuilder)localObject3).append((String)localObject2);
        localObject2 = ((StringBuilder)localObject3).toString();
      }
      ((SigCommentSessionListAdapter.ViewHolder)localObject1).d.setText((CharSequence)localObject2);
      a(localSigCommentInfo.feedsid, ((SigCommentSessionListAdapter.ViewHolder)localObject1).e);
      localObject1 = paramView;
    }
    else
    {
      localObject1 = paramView;
      if (2 == k)
      {
        if (paramView == null)
        {
          paramView = this.d.inflate(2131628473, this.g, false);
          paramView.setOnClickListener(this);
          localObject1 = new SigCommentSessionListAdapter.MoreViewHolder();
          paramView.setTag(localObject1);
          paramView.findViewById(2131437616).setVisibility(8);
          ((SigCommentSessionListAdapter.MoreViewHolder)localObject1).a = ((TextView)paramView.findViewById(2131438894));
          this.i = paramView;
        }
        else
        {
          paramView = (SigCommentSessionListAdapter.MoreViewHolder)paramView.getTag();
        }
        localObject1 = this.i;
      }
    }
    EventCollector.getInstance().onListGetView(paramInt, (View)localObject1, paramViewGroup, getItemId(paramInt));
    return localObject1;
  }
  
  public int getViewTypeCount()
  {
    return 3;
  }
  
  public void onClick(View paramView)
  {
    if (this.i == paramView)
    {
      MqqHandler localMqqHandler = this.b.getHandler(SigCommentListActivity.class);
      if (localMqqHandler != null) {
        localMqqHandler.sendMessageDelayed(localMqqHandler.obtainMessage(0, 1, 0), 200L);
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.adapter.SigCommentSessionListAdapter
 * JD-Core Version:    0.7.0.1
 */