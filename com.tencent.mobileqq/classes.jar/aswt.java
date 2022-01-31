import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.GradientDrawable.Orientation;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.image.DownloadParams.DecodeHandler;
import com.tencent.image.RegionDrawable;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.lyric.widget.LyricViewDetail;
import com.tencent.mobileqq.lyric.widget.LyricViewInternal;
import com.tencent.mobileqq.musicgene.MusicPlayerActivity;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class aswt
  extends Handler
{
  private final WeakReference<MusicPlayerActivity> a;
  
  public aswt(MusicPlayerActivity paramMusicPlayerActivity)
  {
    super(Looper.getMainLooper());
    this.a = new WeakReference(paramMusicPlayerActivity);
  }
  
  private void a(int[] paramArrayOfInt, boolean paramBoolean)
  {
    MusicPlayerActivity localMusicPlayerActivity = (MusicPlayerActivity)this.a.get();
    if ((paramArrayOfInt != null) && (paramArrayOfInt.length >= 2) && (localMusicPlayerActivity != null))
    {
      int i = paramArrayOfInt[0];
      int j = Color.argb(0, Color.red(i), Color.green(i), Color.blue(i));
      GradientDrawable localGradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[] { i, j, j, j, j, j, i });
      ((ImageView)localMusicPlayerActivity.findViewById(2131370571)).setImageDrawable(localGradientDrawable);
      localMusicPlayerActivity.findViewById(2131370574).setBackgroundColor(i);
      i = paramArrayOfInt[1];
      j = Color.argb(128, Color.red(i), Color.green(i), Color.blue(i));
      MusicPlayerActivity.a(localMusicPlayerActivity).setTextColor(i);
      MusicPlayerActivity.b(localMusicPlayerActivity).setTextColor(i);
      localMusicPlayerActivity.a.a().setLyricHilightColor(i);
      localMusicPlayerActivity.a.a().setLyricColor(j);
      MusicPlayerActivity.b(localMusicPlayerActivity).setTag(Integer.valueOf(i));
      MusicPlayerActivity.a(localMusicPlayerActivity).setTag(Integer.valueOf(i));
      MusicPlayerActivity.c(localMusicPlayerActivity).setTag(Integer.valueOf(i));
      MusicPlayerActivity.a(localMusicPlayerActivity, 2130841331, i);
      MusicPlayerActivity.a(localMusicPlayerActivity, 2130841332, i);
      MusicPlayerActivity.a(localMusicPlayerActivity, 2130839569, i);
      if (paramBoolean)
      {
        MusicPlayerActivity.a(localMusicPlayerActivity, 2130840927, i);
        MusicPlayerActivity.a(localMusicPlayerActivity, 2130840929, i);
        MusicPlayerActivity.a(localMusicPlayerActivity, 2130840928, i);
        MusicPlayerActivity.a(localMusicPlayerActivity, 2130837513, i);
      }
    }
  }
  
  public void handleMessage(Message paramMessage)
  {
    int i = 4;
    int j = 1;
    Object localObject1 = (MusicPlayerActivity)this.a.get();
    Object localObject2 = paramMessage.getData();
    if (localObject1 != null) {
      switch (paramMessage.what)
      {
      }
    }
    label495:
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  return;
                  a(((Bundle)localObject2).getIntArray("KEY_COLOR_LIST"), ((Bundle)localObject2).getBoolean("KEY_MATCH_SONG"));
                  return;
                  i = paramMessage.arg1;
                  paramMessage = MusicPlayerActivity.b((MusicPlayerActivity)localObject1).getTag();
                  if ((paramMessage instanceof Integer))
                  {
                    j = ((Integer)paramMessage).intValue();
                    MusicPlayerActivity.a((MusicPlayerActivity)localObject1, 2130841331, j);
                    MusicPlayerActivity.a((MusicPlayerActivity)localObject1, 2130841332, j);
                  }
                  if ((i == 3) || (i == 4)) {
                    MusicPlayerActivity.b((MusicPlayerActivity)localObject1).setImageResource(2130841332);
                  }
                  for (;;)
                  {
                    MusicPlayerActivity.a((MusicPlayerActivity)localObject1);
                    return;
                    MusicPlayerActivity.b((MusicPlayerActivity)localObject1).setImageResource(2130841331);
                  }
                } while (!(paramMessage.obj instanceof aswv));
                localObject2 = (aswv)paramMessage.obj;
                if (paramMessage.arg1 == 1) {
                  i = 0;
                }
                MusicPlayerActivity.a((MusicPlayerActivity)localObject1).setVisibility(i);
                if (MusicPlayerActivity.a((MusicPlayerActivity)localObject1).isSelected()) {
                  MusicPlayerActivity.a((MusicPlayerActivity)localObject1).setImageResource(2130840928);
                }
                for (;;)
                {
                  MusicPlayerActivity.c((MusicPlayerActivity)localObject1).setVisibility(i);
                  MusicPlayerActivity.c((MusicPlayerActivity)localObject1).setImageResource(2130840927);
                  MusicPlayerActivity.d((MusicPlayerActivity)localObject1).setVisibility(i);
                  MusicPlayerActivity.d((MusicPlayerActivity)localObject1).setImageResource(2130837513);
                  MusicPlayerActivity.d((MusicPlayerActivity)localObject1).setTag(localObject2);
                  return;
                  MusicPlayerActivity.a((MusicPlayerActivity)localObject1).setImageResource(2130840929);
                }
              } while (localObject2 == null);
              paramMessage = ((Bundle)localObject2).getString("KEY_SONG_NAME");
              ((Bundle)localObject2).getString("KEY_SINGER_NAME");
              Object localObject3 = ((Bundle)localObject2).getString("KEY_IMG_URL");
              boolean bool1 = ((Bundle)localObject2).getBoolean("KEY_MATCH_SONG");
              boolean bool2 = ((Bundle)localObject2).getBoolean("KEY_IS_FAVOURITE");
              if (!TextUtils.isEmpty(paramMessage)) {
                MusicPlayerActivity.a((MusicPlayerActivity)localObject1).setText(paramMessage);
              }
              if (bool1)
              {
                if (!bool2) {
                  break label495;
                }
                MusicPlayerActivity.a((MusicPlayerActivity)localObject1).setImageResource(2130840928);
              }
              URLDrawable localURLDrawable;
              Object localObject4;
              for (;;)
              {
                MusicPlayerActivity.a((MusicPlayerActivity)localObject1).setSelected(bool2);
                if ((TextUtils.isEmpty((CharSequence)localObject3)) || (!Patterns.WEB_URL.matcher((CharSequence)localObject3).matches())) {
                  break label522;
                }
                paramMessage = (URLImageView)((MusicPlayerActivity)localObject1).findViewById(2131370580);
                localURLDrawable = URLDrawable.getDrawable((String)localObject3, URLDrawable.URLDrawableOptions.obtain());
                localObject4 = aswb.a((String)localObject3);
                if (localObject4 == null) {
                  break label550;
                }
                localObject3 = new int[((List)localObject4).size()];
                i = 0;
                while (i < ((List)localObject4).size())
                {
                  localObject3[i] = ((Integer)((List)localObject4).get(i)).intValue();
                  i += 1;
                }
                MusicPlayerActivity.a((MusicPlayerActivity)localObject1).setImageResource(2130840929);
              }
              a((int[])localObject3, bool1);
              for (;;)
              {
                paramMessage.setImageDrawable(localURLDrawable);
                paramMessage = ((Bundle)localObject2).getString("KEY_SOURCE_NAME");
                if (!TextUtils.isEmpty(paramMessage)) {
                  break;
                }
                MusicPlayerActivity.b((MusicPlayerActivity)localObject1).setText(2131694483);
                return;
                localObject3 = new aswb((String)localObject3, MusicPlayerActivity.a((MusicPlayerActivity)localObject1), Boolean.valueOf(bool1));
                if (localURLDrawable.getStatus() == 1)
                {
                  localObject4 = localURLDrawable.getCurrDrawable();
                  if ((localObject4 instanceof RegionDrawable)) {
                    ((aswb)localObject3).run(null, ((RegionDrawable)localObject4).getBitmap());
                  }
                }
                else
                {
                  localURLDrawable.setDecodeHandler((DownloadParams.DecodeHandler)localObject3);
                }
              }
              MusicPlayerActivity.b((MusicPlayerActivity)localObject1).setText(((MusicPlayerActivity)localObject1).getString(2131694481, new Object[] { paramMessage }));
              return;
              MusicPlayerActivity.a((MusicPlayerActivity)localObject1);
              return;
            } while (!(paramMessage.obj instanceof View));
            localObject2 = (View)paramMessage.obj;
            paramMessage = bfxy.a((Context)localObject1).b(3).a(((MusicPlayerActivity)localObject1).getString(paramMessage.arg1)).a(paramMessage.arg2);
            paramMessage.c(49);
            paramMessage = new bfya(paramMessage).b(Color.argb(13, 255, 255, 255)).a(5).a();
          } while (paramMessage == null);
          paramMessage = paramMessage.a();
        } while (paramMessage == null);
        paramMessage.a((View)localObject2);
        return;
        localObject1 = MusicPlayerActivity.d((MusicPlayerActivity)localObject1).getTag();
      } while (!(localObject1 instanceof aswv));
      localObject1 = (aswv)localObject1;
    } while (!(paramMessage.obj instanceof Bitmap));
    label522:
    label550:
    localObject2 = (Bitmap)paramMessage.obj;
    long l = System.currentTimeMillis();
    i = j;
    if (paramMessage.arg1 == 2) {
      i = 0;
    }
    WXShareHelper.a().a(String.valueOf(l), ((aswv)localObject1).a, (Bitmap)localObject2, ((aswv)localObject1).b, ((aswv)localObject1).d, i, ((aswv)localObject1).e);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     aswt
 * JD-Core Version:    0.7.0.1
 */