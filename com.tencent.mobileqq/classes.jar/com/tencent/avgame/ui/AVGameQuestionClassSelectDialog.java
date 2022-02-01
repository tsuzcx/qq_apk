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
import com.tencent.avgame.gamelogic.GameEngine;
import com.tencent.avgame.gamelogic.data.EngineData;
import com.tencent.avgame.gamelogic.data.Player;
import com.tencent.avgame.gamelogic.data.QuestionClassInfoItem;
import com.tencent.avgame.gamelogic.data.RoomInfo;
import com.tencent.avgame.gameroom.gamelist.IGameListView;
import com.tencent.avgame.util.AVGameUtils;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import java.util.ArrayList;
import java.util.List;

public class AVGameQuestionClassSelectDialog
  extends ReportDialog
{
  public static final int a;
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(new AVGameQuestionClassSelectDialog.1(this));
  private GridLayoutManager jdField_a_of_type_AndroidSupportV7WidgetGridLayoutManager;
  private RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private IGameListView jdField_a_of_type_ComTencentAvgameGameroomGamelistIGameListView;
  private AVGameQuestionClassSelectDialog.AVGameQuestionClassViewAdapter jdField_a_of_type_ComTencentAvgameUiAVGameQuestionClassSelectDialog$AVGameQuestionClassViewAdapter;
  private String jdField_a_of_type_JavaLangString;
  private List<QuestionClassInfoItem> jdField_a_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_a_of_type_Boolean = false;
  private int jdField_b_of_type_Int;
  private String jdField_b_of_type_JavaLangString;
  private int c;
  
  static
  {
    jdField_a_of_type_Int = AVGameUtils.d();
  }
  
  public AVGameQuestionClassSelectDialog(Context paramContext, int paramInt, List<QuestionClassInfoItem> paramList, String paramString1, String paramString2, IGameListView paramIGameListView)
  {
    super(paramContext, 2131755842);
    this.jdField_b_of_type_Int = paramInt;
    if ((this.jdField_a_of_type_Boolean) && (paramList.size() >= 9)) {
      this.jdField_a_of_type_JavaUtilList.addAll(paramList.subList(0, 8));
    }
    for (;;)
    {
      this.jdField_a_of_type_JavaLangString = paramString1;
      this.jdField_b_of_type_JavaLangString = paramString2;
      this.jdField_a_of_type_ComTencentAvgameGameroomGamelistIGameListView = paramIGameListView;
      if (this.jdField_a_of_type_ComTencentAvgameGameroomGamelistIGameListView != null) {
        bool = true;
      }
      this.jdField_a_of_type_Boolean = bool;
      a();
      QLog.d("AVGameQuestionClassSelectDialog", 2, "AVGameQuestionClassSelectDialog init");
      return;
      this.jdField_a_of_type_JavaUtilList.addAll(paramList);
    }
  }
  
  private List<Player> a()
  {
    List localList = GameEngine.a().a().a().getPlayers();
    ArrayList localArrayList = new ArrayList(localList.size());
    int i = 0;
    while (i < localList.size())
    {
      Player localPlayer = (Player)localList.get(i);
      if ((localPlayer != null) && (localPlayer.status == 0)) {
        localArrayList.add(localPlayer);
      }
      i += 1;
    }
    return localArrayList;
  }
  
  private void a()
  {
    setContentView(2131558792);
    getWindow().setLayout(-1, -1);
    Object localObject = (ImageView)findViewById(2131363390);
    TextView localTextView = (TextView)findViewById(2131363392);
    if ((this.jdField_a_of_type_JavaLangString != null) && (this.jdField_a_of_type_JavaLangString.length() > 0))
    {
      ((ImageView)localObject).setImageDrawable(URLDrawable.getDrawable(this.jdField_a_of_type_JavaLangString));
      this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131363319));
      if (!this.jdField_a_of_type_Boolean) {
        break label285;
      }
      this.c = jdField_a_of_type_Int;
      this.jdField_a_of_type_AndroidWidgetButton.setTypeface(AVGameText.a());
      b();
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(new AVGameQuestionClassSelectDialog.2(this));
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = ((RecyclerView)findViewById(2131363317));
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setHasFixedSize(true);
      this.jdField_a_of_type_AndroidSupportV7WidgetGridLayoutManager = new GridLayoutManager(getContext(), 3);
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setLayoutManager(this.jdField_a_of_type_AndroidSupportV7WidgetGridLayoutManager);
      this.jdField_a_of_type_ComTencentAvgameUiAVGameQuestionClassSelectDialog$AVGameQuestionClassViewAdapter = new AVGameQuestionClassSelectDialog.AVGameQuestionClassViewAdapter(this, this.jdField_a_of_type_JavaUtilList);
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setAdapter(this.jdField_a_of_type_ComTencentAvgameUiAVGameQuestionClassSelectDialog$AVGameQuestionClassViewAdapter);
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setOverScrollMode(2);
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.addItemDecoration(new AVGameQuestionClassSelectDialog.AVGameQuestionClassItemDecoration(this, 0, 0));
      findViewById(2131377356).setOnClickListener(new AVGameQuestionClassSelectDialog.3(this));
      findViewById(2131364512).setOnClickListener(new AVGameQuestionClassSelectDialog.4(this));
      if (this.jdField_a_of_type_Boolean)
      {
        setCancelable(false);
        setCanceledOnTouchOutside(false);
      }
      return;
      ((ImageView)localObject).setVisibility(8);
      localTextView.setVisibility(0);
      break;
      label285:
      if ((this.jdField_b_of_type_JavaLangString != null) && (this.jdField_b_of_type_JavaLangString.length() > 0))
      {
        localObject = URLDrawable.getDrawable(this.jdField_b_of_type_JavaLangString);
        this.jdField_a_of_type_AndroidWidgetButton.setBackgroundDrawable((Drawable)localObject);
      }
      else
      {
        this.jdField_a_of_type_AndroidWidgetButton.setText(getContext().getString(2131690510));
      }
    }
  }
  
  public static void a(Context paramContext, int paramInt, List<QuestionClassInfoItem> paramList, String paramString1, String paramString2, IGameListView paramIGameListView)
  {
    if ((paramContext == null) || (paramInt == 0) || (paramList == null) || (paramList.size() == 0) || (paramString1 == null) || (paramString2 == null)) {
      return;
    }
    new AVGameQuestionClassSelectDialog(paramContext, paramInt, paramList, paramString1, paramString2, paramIGameListView).show();
  }
  
  private void a(String paramString)
  {
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentAvgameGameroomGamelistIGameListView != null))
    {
      List localList = a();
      if (!localList.isEmpty())
      {
        this.jdField_a_of_type_ComTencentAvgameGameroomGamelistIGameListView.a(AVGameUtils.a(getContext(), localList));
        dismiss();
        return;
      }
    }
    GameEngine.a().a(this.jdField_b_of_type_Int, paramString);
    dismiss();
    if (paramString == null) {
      paramString = getContext().getString(2131690510);
    }
    for (;;)
    {
      ReportController.b(null, "dc00898", "", "", "0X800B1F0", "0X800B1F0", this.jdField_b_of_type_Int, 0, "", "", paramString, "");
      return;
    }
  }
  
  private void b()
  {
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(0);
    if (this.c > 0)
    {
      String str = getContext().getString(2131690511);
      this.jdField_a_of_type_AndroidWidgetButton.setText(String.format(str, new Object[] { Integer.valueOf(this.c) }));
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(0, 1000L);
      return;
    }
    a(null);
  }
  
  private static void b(String paramString, ImageView paramImageView)
  {
    if ((paramString == null) || (paramImageView == null)) {}
    do
    {
      return;
      paramString = URLDrawable.getDrawable(paramString);
    } while (paramString == null);
    paramImageView.setImageDrawable(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.avgame.ui.AVGameQuestionClassSelectDialog
 * JD-Core Version:    0.7.0.1
 */