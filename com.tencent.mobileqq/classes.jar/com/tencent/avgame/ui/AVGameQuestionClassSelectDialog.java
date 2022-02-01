package com.tencent.avgame.ui;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.avgame.gamelogic.IGameEngine;
import com.tencent.avgame.gamelogic.data.EngineData;
import com.tencent.avgame.gamelogic.data.Player;
import com.tencent.avgame.gamelogic.data.QuestionClassInfoItem;
import com.tencent.avgame.gamelogic.data.RoomInfo;
import com.tencent.avgame.gameroom.gamelist.IGameListView;
import com.tencent.avgame.util.AVGameUtil;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import java.util.ArrayList;
import java.util.List;

public class AVGameQuestionClassSelectDialog
  extends ReportDialog
{
  public static final int a = ;
  private int b;
  private List<QuestionClassInfoItem> c = new ArrayList();
  private String d;
  private String e;
  private RecyclerView f;
  private AVGameQuestionClassSelectDialog.AVGameQuestionClassViewAdapter g;
  private GridLayoutManager h;
  private Button i;
  private IGameListView j;
  private boolean k;
  private int l;
  private Handler m;
  
  public AVGameQuestionClassSelectDialog(Context paramContext, int paramInt, List<QuestionClassInfoItem> paramList, String paramString1, String paramString2, IGameListView paramIGameListView)
  {
    super(paramContext, 2131953338);
    boolean bool = false;
    this.k = false;
    this.m = new Handler(new AVGameQuestionClassSelectDialog.1(this));
    this.b = paramInt;
    if ((this.k) && (paramList.size() >= 9)) {
      this.c.addAll(paramList.subList(0, 8));
    } else {
      this.c.addAll(paramList);
    }
    this.d = paramString1;
    this.e = paramString2;
    this.j = paramIGameListView;
    if (this.j != null) {
      bool = true;
    }
    this.k = bool;
    a();
    QLog.d("AVGameQuestionClassSelectDialog", 2, "AVGameQuestionClassSelectDialog init");
  }
  
  private void a()
  {
    setContentView(2131624308);
    getWindow().setLayout(-1, -1);
    Object localObject = (ImageView)findViewById(2131429196);
    TextView localTextView = (TextView)findViewById(2131429198);
    String str = this.d;
    if ((str != null) && (str.length() > 0))
    {
      ((ImageView)localObject).setImageDrawable(URLDrawable.getDrawable(this.d));
    }
    else
    {
      ((ImageView)localObject).setVisibility(8);
      localTextView.setVisibility(0);
    }
    this.i = ((Button)findViewById(2131429125));
    if (this.k)
    {
      this.l = a;
      this.i.setTypeface(AVGameText.getTypeface());
      b();
    }
    else
    {
      localObject = this.e;
      if ((localObject != null) && (((String)localObject).length() > 0))
      {
        localObject = URLDrawable.getDrawable(this.e);
        this.i.setBackgroundDrawable((Drawable)localObject);
      }
      else
      {
        this.i.setText(getContext().getString(2131887346));
      }
    }
    this.i.setOnClickListener(new AVGameQuestionClassSelectDialog.2(this));
    this.f = ((RecyclerView)findViewById(2131429123));
    this.f.setHasFixedSize(true);
    this.h = new GridLayoutManager(getContext(), 3);
    this.f.setLayoutManager(this.h);
    this.g = new AVGameQuestionClassSelectDialog.AVGameQuestionClassViewAdapter(this, this.c);
    this.f.setAdapter(this.g);
    this.f.setOverScrollMode(2);
    this.f.addItemDecoration(new AVGameQuestionClassSelectDialog.AVGameQuestionClassItemDecoration(this, 0, 0));
    findViewById(2131445137).setOnClickListener(new AVGameQuestionClassSelectDialog.3(this));
    findViewById(2131430430).setOnClickListener(new AVGameQuestionClassSelectDialog.4(this));
    if (this.k)
    {
      setCancelable(false);
      setCanceledOnTouchOutside(false);
    }
  }
  
  public static void a(Context paramContext, int paramInt, List<QuestionClassInfoItem> paramList, String paramString1, String paramString2, IGameListView paramIGameListView)
  {
    if ((paramContext != null) && (paramInt != 0) && (paramList != null) && (paramList.size() != 0) && (paramString1 != null))
    {
      if (paramString2 == null) {
        return;
      }
      new AVGameQuestionClassSelectDialog(paramContext, paramInt, paramList, paramString1, paramString2, paramIGameListView).show();
    }
  }
  
  private void a(String paramString)
  {
    if ((this.k) && (this.j != null))
    {
      localObject = c();
      if (!((List)localObject).isEmpty())
      {
        this.j.a(AVGameUtil.a(getContext(), (List)localObject));
        dismiss();
        return;
      }
    }
    IGameEngine.I().a(this.b, paramString);
    dismiss();
    Object localObject = paramString;
    if (paramString == null) {
      localObject = getContext().getString(2131887346);
    }
    ReportController.b(null, "dc00898", "", "", "0X800B1F0", "0X800B1F0", this.b, 0, "", "", (String)localObject, "");
  }
  
  private void b()
  {
    this.m.removeMessages(0);
    if (this.l > 0)
    {
      String str = getContext().getString(2131887347);
      this.i.setText(String.format(str, new Object[] { Integer.valueOf(this.l) }));
      this.m.sendEmptyMessageDelayed(0, 1000L);
      return;
    }
    a(null);
  }
  
  private static void b(String paramString, ImageView paramImageView)
  {
    if (paramString != null)
    {
      if (paramImageView == null) {
        return;
      }
      paramString = URLDrawable.getDrawable(paramString);
      if (paramString != null) {
        paramImageView.setImageDrawable(paramString);
      }
    }
  }
  
  private List<Player> c()
  {
    if (IGameEngine.J()) {
      return new ArrayList();
    }
    List localList = IGameEngine.I().s().e().getPlayers();
    ArrayList localArrayList = new ArrayList(localList.size());
    int n = 0;
    while (n < localList.size())
    {
      Player localPlayer = (Player)localList.get(n);
      if ((localPlayer != null) && (localPlayer.status == 0)) {
        localArrayList.add(localPlayer);
      }
      n += 1;
    }
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.ui.AVGameQuestionClassSelectDialog
 * JD-Core Version:    0.7.0.1
 */