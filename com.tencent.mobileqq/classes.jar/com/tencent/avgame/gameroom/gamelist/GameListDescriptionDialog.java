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
import com.tencent.avgame.util.AVGameUtil;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.urldrawable.URLDrawableHelperConstants;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;

public class GameListDescriptionDialog
  extends ReportDialog
{
  protected static final LruCache<String, URLDrawable> a = new LruCache(20);
  private View.OnClickListener b = new GameListDescriptionDialog.1(this);
  
  public GameListDescriptionDialog(Context paramContext, GameItem paramGameItem)
  {
    super(paramContext, 2131953338);
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
    setContentView(2131624296);
    getWindow().setLayout(-1, -1);
    View localView = findViewById(2131430318);
    localView.setOnClickListener(new GameListDescriptionDialog.2(this));
    Object localObject1 = (TextView)findViewById(2131439121);
    TextView localTextView = (TextView)findViewById(2131431757);
    Object localObject2 = findViewById(2131436800);
    ((View)localObject2).setOnTouchListener(new GameListDescriptionDialog.3(this));
    ((View)localObject2).setOnClickListener(this.b);
    findViewById(2131445137).setOnClickListener(this.b);
    localObject2 = findViewById(2131430806);
    ((View)localObject2).setBackgroundDrawable(AVGameUtil.a(getContext().getResources(), "avgame_guide_close_nor@2x.png", "avgame_guide_close_press@2x.png"));
    ((View)localObject2).setOnClickListener(this.b);
    if (paramGameItem != null)
    {
      if (!TextUtils.isEmpty(paramGameItem.s)) {
        ((TextView)localObject1).setBackgroundDrawable(URLDrawable.getDrawable(paramGameItem.s, URLDrawableHelperConstants.a, URLDrawableHelperConstants.a));
      } else if (paramGameItem.b != null) {
        ((TextView)localObject1).setText(paramGameItem.b);
      }
      localObject1 = AVGameUtil.c("avgame_list_card_bg@3x.png");
      if (localObject1 != null) {
        localObject2 = new BitmapDrawable((Bitmap)localObject1);
      } else {
        localObject2 = URLDrawableHelperConstants.a;
      }
      if (!TextUtils.isEmpty(paramGameItem.d))
      {
        localObject1 = null;
        Object localObject3 = a;
        if (localObject3 != null) {
          localObject1 = (URLDrawable)((LruCache)localObject3).get(paramGameItem.d);
        }
        localObject3 = localObject1;
        if (localObject1 == null)
        {
          localObject1 = URLDrawable.getDrawable(paramGameItem.d, (Drawable)localObject2, (Drawable)localObject2);
          ((URLDrawable)localObject1).startDownload();
          localObject2 = a;
          localObject3 = localObject1;
          if (localObject2 != null)
          {
            ((LruCache)localObject2).put(paramGameItem.d, localObject1);
            localObject3 = localObject1;
          }
        }
        localView.setBackgroundDrawable((Drawable)localObject3);
      }
      else
      {
        localView.setBackgroundDrawable((Drawable)localObject2);
      }
      if (!TextUtils.isEmpty(paramGameItem.c)) {
        localTextView.setText(paramGameItem.c);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gameroom.gamelist.GameListDescriptionDialog
 * JD-Core Version:    0.7.0.1
 */