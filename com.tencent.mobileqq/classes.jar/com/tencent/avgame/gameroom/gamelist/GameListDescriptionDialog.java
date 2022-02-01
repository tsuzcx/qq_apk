package com.tencent.avgame.gameroom.gamelist;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.LruCache;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.TextView;
import com.tencent.avgame.gamelogic.data.GameItem;
import com.tencent.avgame.util.AVGameUtils;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;

public class GameListDescriptionDialog
  extends ReportDialog
{
  protected static final LruCache<String, URLDrawable> a;
  private View.OnClickListener a;
  
  static
  {
    jdField_a_of_type_AndroidUtilLruCache = new LruCache(20);
  }
  
  public GameListDescriptionDialog(Context paramContext, GameItem paramGameItem)
  {
    super(paramContext, 2131755842);
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new GameListDescriptionDialog.1(this);
    if (QLog.isColorLevel()) {
      QLog.i("GameListDescriptionDialog", 2, "GameListDescriptionDialog show");
    }
    a(paramGameItem);
  }
  
  public static Dialog a(Context paramContext, GameItem paramGameItem)
  {
    paramContext = new GameListDescriptionDialog(paramContext, paramGameItem);
    paramContext.show();
    return paramContext;
  }
  
  private void a(GameItem paramGameItem)
  {
    setContentView(2131558780);
    getWindow().setLayout(-1, -1);
    View localView = findViewById(2131364405);
    localView.setOnClickListener(new GameListDescriptionDialog.2(this));
    Object localObject1 = (TextView)findViewById(2131372115);
    TextView localTextView = (TextView)findViewById(2131365699);
    Object localObject2 = findViewById(2131370004);
    ((View)localObject2).setOnTouchListener(new GameListDescriptionDialog.3(this));
    ((View)localObject2).setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    findViewById(2131377356).setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    localObject2 = findViewById(2131364815);
    ((View)localObject2).setBackgroundDrawable(AVGameUtils.a(getContext().getResources(), "avgame_guide_close_nor@2x.png", "avgame_guide_close_press@2x.png"));
    ((View)localObject2).setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    if (paramGameItem != null)
    {
      if (TextUtils.isEmpty(paramGameItem.m)) {
        break label284;
      }
      ((TextView)localObject1).setBackgroundDrawable(URLDrawable.getDrawable(paramGameItem.m, URLDrawableHelper.TRANSPARENT, URLDrawableHelper.TRANSPARENT));
      localObject1 = AVGameUtils.a("avgame_list_card_bg@3x.png");
      if (localObject1 == null) {
        break label302;
      }
      localObject2 = new BitmapDrawable((Bitmap)localObject1);
      label180:
      if (TextUtils.isEmpty(paramGameItem.c)) {
        break label309;
      }
      localObject1 = null;
      if (jdField_a_of_type_AndroidUtilLruCache != null) {
        localObject1 = (URLDrawable)jdField_a_of_type_AndroidUtilLruCache.get(paramGameItem.c);
      }
      Object localObject3 = localObject1;
      if (localObject1 == null)
      {
        localObject1 = URLDrawable.getDrawable(paramGameItem.c, (Drawable)localObject2, (Drawable)localObject2);
        ((URLDrawable)localObject1).startDownload();
        localObject3 = localObject1;
        if (jdField_a_of_type_AndroidUtilLruCache != null)
        {
          jdField_a_of_type_AndroidUtilLruCache.put(paramGameItem.c, localObject1);
          localObject3 = localObject1;
        }
      }
      localView.setBackgroundDrawable(localObject3);
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(paramGameItem.b)) {
        localTextView.setText(paramGameItem.b);
      }
      return;
      label284:
      if (paramGameItem.a == null) {
        break;
      }
      ((TextView)localObject1).setText(paramGameItem.a);
      break;
      label302:
      localObject2 = URLDrawableHelper.TRANSPARENT;
      break label180;
      label309:
      localView.setBackgroundDrawable((Drawable)localObject2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.avgame.gameroom.gamelist.GameListDescriptionDialog
 * JD-Core Version:    0.7.0.1
 */