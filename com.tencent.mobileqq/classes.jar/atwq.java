import android.content.Context;
import android.content.res.Resources;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.qqstory.database.PublishVideoEntry;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class atwq
  extends atwp
{
  public atwq(Context paramContext, QQAppInterface paramQQAppInterface)
  {
    super(paramContext, paramQQAppInterface);
  }
  
  public int a(atva paramatva)
  {
    return 1;
  }
  
  public View a(ViewGroup paramViewGroup, atva paramatva)
  {
    paramatva = (atwr)paramatva;
    paramViewGroup = LayoutInflater.from(this.a).inflate(2131560895, paramViewGroup, false);
    paramatva.g = ((TextView)paramViewGroup.findViewById(2131378373));
    paramatva.e = ((ImageView)paramViewGroup.findViewById(2131368543));
    paramatva.f = ((ImageView)paramViewGroup.findViewById(2131368639));
    return paramViewGroup;
  }
  
  public atva a()
  {
    return new atwr(this);
  }
  
  public String a(atva paramatva)
  {
    long l = ((atxa)((atwr)paramatva).a).jdField_b_of_type_Long;
    if (l % 1000L > 500L) {}
    for (l = (int)l / 1000 + 1;; l = (int)l / 1000) {
      return String.valueOf(l);
    }
  }
  
  public void d(atva paramatva)
  {
    atxa localatxa = (atxa)paramatva.a;
    if ((localatxa.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry != null) && (localatxa.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.publishState != 0))
    {
      atwl.a(this.a, localatxa.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry, 2);
      return;
    }
    super.d(paramatva);
  }
  
  public void f(atva paramatva)
  {
    atwr localatwr = (atwr)paramatva;
    atxa localatxa = (atxa)localatwr.a;
    paramatva = bbkr.a(this.a, localatwr.a.a, localatxa.n);
    int j;
    String str;
    File localFile;
    boolean bool;
    if (TextUtils.isEmpty(paramatva))
    {
      localatwr.g.setVisibility(8);
      j = vzl.a(this.a, 180.0F);
      str = (String)localatwr.e.getTag(2131376882);
      if (localatxa.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry == null) {
        break label544;
      }
      localFile = new File(localatxa.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.thumbPath + "");
      bool = localFile.exists();
    }
    for (;;)
    {
      Object localObject;
      int i;
      if (bool)
      {
        localObject = localatxa.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.thumbPath;
        paramatva = (atva)localObject;
        if (localatxa.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.videoWidth <= 0) {
          break label539;
        }
        paramatva = (atva)localObject;
        if (localatxa.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.videoHeight <= 0) {
          break label539;
        }
        i = localatxa.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.videoHeight * j / localatxa.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.videoWidth;
        paramatva = (atva)localObject;
      }
      for (;;)
      {
        label195:
        if (i * 3 > j * 4) {
          i = j * 4 / 3;
        }
        for (;;)
        {
          if (!TextUtils.equals(str, paramatva))
          {
            localatwr.e.setTag(2131376882, paramatva);
            localObject = (FrameLayout.LayoutParams)localatwr.e.getLayoutParams();
            if (localObject != null) {
              break label444;
            }
            localObject = new FrameLayout.LayoutParams(j, i);
            localatwr.e.setLayoutParams((ViewGroup.LayoutParams)localObject);
          }
          for (;;)
          {
            try
            {
              localObject = URLDrawable.URLDrawableOptions.obtain();
              ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = this.a.getResources().getDrawable(2130844649);
              ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = this.a.getResources().getDrawable(2130844649);
              if (!bool) {
                continue;
              }
              paramatva = URLDrawable.getDrawable(localFile, (URLDrawable.URLDrawableOptions)localObject);
              paramatva.setTag(bavw.b(j, i, baxn.a(this.a, 3.0F)));
              paramatva.setDecodeHandler(bavw.e);
              localatwr.e.setImageDrawable(paramatva);
              return;
            }
            catch (Exception paramatva)
            {
              label444:
              localatwr.e.setImageDrawable(this.a.getResources().getDrawable(2130844649));
              if (!QLog.isColorLevel()) {
                continue;
              }
              QLog.i("ShortVideoMomentItemBuilder", 1, paramatva.toString());
              return;
            }
            localatwr.g.setVisibility(0);
            if ((paramatva instanceof SpannableString)) {
              localatwr.g.setMovementMethod(LinkMovementMethod.getInstance());
            }
            localatwr.g.setText(paramatva);
            break;
            localObject = localatxa.jdField_a_of_type_JavaLangString;
            paramatva = (atva)localObject;
            if (localatxa.jdField_a_of_type_Int <= 0) {
              break label539;
            }
            paramatva = (atva)localObject;
            if (localatxa.jdField_b_of_type_Int <= 0) {
              break label539;
            }
            i = localatxa.jdField_b_of_type_Int * j / localatxa.jdField_a_of_type_Int;
            paramatva = (atva)localObject;
            break label195;
            if ((((FrameLayout.LayoutParams)localObject).width != j) || (((FrameLayout.LayoutParams)localObject).height != i))
            {
              ((FrameLayout.LayoutParams)localObject).width = j;
              ((FrameLayout.LayoutParams)localObject).height = i;
              localatwr.e.setLayoutParams((ViewGroup.LayoutParams)localObject);
              continue;
              paramatva = URLDrawable.getDrawable(paramatva, (URLDrawable.URLDrawableOptions)localObject);
            }
          }
        }
        label539:
        i = j;
      }
      label544:
      bool = false;
      localFile = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atwq
 * JD-Core Version:    0.7.0.1
 */