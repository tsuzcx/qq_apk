package com.tencent.mobileqq.activity.recent.gamemsgbox;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.TranslateAnimation;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GameSyncOptionFragment
  extends QPublicBaseFragment
{
  private static final ArrayList<String> h = new ArrayList();
  private Intent a;
  private LinearLayout b;
  private LinearLayout c;
  private ListView d;
  private LinearLayout e;
  private TextView f;
  private int g;
  
  static
  {
    h.add(0, HardCodeUtil.a(2131896932));
    h.add(1, HardCodeUtil.a(2131896930));
    h.add(2, HardCodeUtil.a(2131896916));
  }
  
  private void a(int paramInt)
  {
    this.a.putExtra("new_option", paramInt - 1);
    getActivity().setResult(-1, this.a);
    f();
  }
  
  private void a(View paramView1, View paramView2, String paramString)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("pgid", "pg_gb_switch");
    VideoReport.setElementId(paramView2, paramString);
    VideoReport.setPageId(paramView1, "pg_gb_switch");
    VideoReport.reportEvent("clck", paramView1, localHashMap);
  }
  
  private void a(View paramView, String paramString, int paramInt)
  {
    if (paramInt != this.g)
    {
      paramView.setContentDescription(paramString);
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("已选中");
    paramView.setContentDescription(localStringBuilder.toString());
  }
  
  private void a(String paramString, GameSyncOptionFragment.AlertDialogCallback paramAlertDialogCallback)
  {
    AlertDialog.Builder localBuilder = new AlertDialog.Builder(getContext());
    localBuilder.setMessage(paramString);
    localBuilder.setCancelable(false);
    localBuilder.setPositiveButton("继续设置", new GameSyncOptionFragment.2(this, paramAlertDialogCallback));
    localBuilder.setNegativeButton("取消", new GameSyncOptionFragment.3(this, paramAlertDialogCallback));
    paramString = localBuilder.create();
    paramString.setOnShowListener(new GameSyncOptionFragment.4(this));
    paramString.setOnCancelListener(new GameSyncOptionFragment.5(this));
    paramString.show();
  }
  
  private void b()
  {
    d();
    Object localObject = new ArrayList();
    int i = 0;
    while (i < 3)
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("option_text", h.get(i));
      if (i == this.g) {
        localHashMap.put("option_selection", Integer.valueOf(2130839345));
      } else {
        localHashMap.put("option_selection", Integer.valueOf(0));
      }
      ((ArrayList)localObject).add(localHashMap);
      i += 1;
    }
    localObject = new GameSyncOptionFragment.1(this, getContext(), (List)localObject, 2131624895, new String[] { "option_text", "option_selection" }, new int[] { 2131439691, 2131439690 });
    this.d.setAdapter((ListAdapter)localObject);
  }
  
  private void c()
  {
    this.b.setBackgroundColor(Color.rgb(0, 0, 0));
    this.b.getBackground().setAlpha(127);
    e();
    this.f.setOnClickListener(new -..Lambda.GameSyncOptionFragment.bfur7-4WnMnafQJFkWSa5JUvJMI(this));
    this.f.setGravity(17);
  }
  
  private void d()
  {
    TextView localTextView = new TextView(getContext());
    localTextView.setText(2131896933);
    localTextView.setGravity(17);
    localTextView.setHeight(ViewUtils.dpToPx(40.0F));
    this.d.addHeaderView(localTextView, null, false);
    this.d.setOnItemClickListener(new -..Lambda.GameSyncOptionFragment.Yl10aBGTZ8iHOuhrPLFKaZs_0zs(this));
  }
  
  private void e()
  {
    TranslateAnimation localTranslateAnimation = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, 1.0F, 1, 0.0F);
    localTranslateAnimation.setDuration(400L);
    this.b.post(new -..Lambda.GameSyncOptionFragment.Ogk1oqZZfYLxpEH5pepTy-wwR2Y(this, localTranslateAnimation));
  }
  
  private void f()
  {
    TranslateAnimation localTranslateAnimation = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, 0.0F, 1, 1.0F);
    localTranslateAnimation.setDuration(400L);
    this.b.post(new -..Lambda.GameSyncOptionFragment.waXHY4YJjPWjStd9YrvasXLKXbI(this, localTranslateAnimation));
    this.b.postDelayed(new -..Lambda.GameSyncOptionFragment.jf9qveFSWAKEvSY5ooJNUQ58i04(this), 400L);
  }
  
  public void onCreate(@Nullable Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.a = getQBaseActivity().getIntent();
    this.g = this.a.getIntExtra("pos", 0);
  }
  
  @Nullable
  public View onCreateView(@NonNull LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, @Nullable Bundle paramBundle)
  {
    this.b = ((LinearLayout)paramLayoutInflater.inflate(2131624894, paramViewGroup, false));
    this.c = ((LinearLayout)this.b.findViewById(2131434370));
    this.e = ((LinearLayout)this.b.findViewById(2131439693));
    this.d = ((ListView)this.b.findViewById(2131439685));
    this.f = ((TextView)this.b.findViewById(2131430281));
    b();
    c();
    paramLayoutInflater = this.b;
    AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.gamemsgbox.GameSyncOptionFragment
 * JD-Core Version:    0.7.0.1
 */