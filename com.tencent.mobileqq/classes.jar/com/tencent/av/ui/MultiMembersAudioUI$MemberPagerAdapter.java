package com.tencent.av.ui;

import android.annotation.TargetApi;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.View.OnLayoutChangeListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.viewpager.widget.PagerAdapter;
import com.tencent.av.VideoController;
import com.tencent.av.VideoController.GAudioFriends;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.gaudio.AVPhoneUserInfo;
import com.tencent.av.gaudio.AVPhoneUserInfo.TelInfo;
import com.tencent.av.utils.PstnUtils;
import com.tencent.av.utils.UITools;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.QQAudioHelper;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class MultiMembersAudioUI$MemberPagerAdapter
  extends PagerAdapter
{
  MultiMembersAudioUI$MemberPagerAdapter(MultiMembersAudioUI paramMultiMembersAudioUI) {}
  
  public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    paramViewGroup.removeView((View)paramObject);
  }
  
  public int getCount()
  {
    ArrayList localArrayList = this.a.k;
    int i = 0;
    if (localArrayList == null) {
      return 0;
    }
    int j = this.a.l / 8;
    if (this.a.l % 8 != 0) {
      i = 1;
    }
    return j + i;
  }
  
  public int getItemPosition(Object paramObject)
  {
    return -2;
  }
  
  @TargetApi(11)
  public Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
  {
    QLog.isColorLevel();
    if ((this.a.k != null) && (this.a.l != 0))
    {
      View localView1 = View.inflate(paramViewGroup.getContext(), 2131625770, null);
      if (QQAudioHelper.b(0) == 1)
      {
        localView1.setBackgroundColor(2130706687);
        localView1.addOnLayoutChangeListener(new MultiMembersAudioUI.MemberPagerAdapter.1(this));
        if (paramViewGroup.getTag(2131435466) == null)
        {
          paramViewGroup.setBackgroundColor(-553615360);
          localObject1 = new MultiMembersAudioUI.MemberPagerAdapter.2(this);
          paramViewGroup.addOnLayoutChangeListener((View.OnLayoutChangeListener)localObject1);
          paramViewGroup.setTag(2131435466, localObject1);
        }
      }
      int i;
      if (paramInt == getCount() - 1) {
        i = this.a.l - paramInt * 8;
      } else {
        i = 8;
      }
      this.a.a(localView1, i);
      int j = 0;
      while (j < i)
      {
        int k = paramInt * 8 + j;
        if (k > this.a.l - 1) {
          break;
        }
        MultiMembersUI.MVMembersInfo localMVMembersInfo = (MultiMembersUI.MVMembersInfo)this.a.k.get(k);
        if (localMVMembersInfo != null)
        {
          MultiMembersUI.Holder localHolder;
          for (;;)
          {
            int m = this.a.a(i, j);
            View localView2;
            Object localObject2;
            if (m != -1)
            {
              localView2 = localView1.findViewById(m);
              if (localView2 != null)
              {
                localHolder = this.a.a(localView2);
                localHolder.q = localMVMembersInfo.o;
                localView2.setTag(localHolder);
                if (this.a.o != null) {
                  localView2.setOnClickListener(this.a.o);
                }
                if ((localMVMembersInfo.g != null) && (localMVMembersInfo.i != null) && (localMVMembersInfo.f)) {
                  break label958;
                }
                if (localMVMembersInfo.j == 0)
                {
                  localObject1 = String.valueOf(localMVMembersInfo.a);
                  if (this.a.i == 7)
                  {
                    localObject2 = this.a.d.m((String)localObject1);
                    if (localObject2 != null)
                    {
                      if (this.a.m) {
                        localMVMembersInfo.g = ((VideoController.GAudioFriends)localObject2).i;
                      } else {
                        localMVMembersInfo.g = ((VideoController.GAudioFriends)localObject2).h;
                      }
                      if ((((String)localObject1).equals(this.a.c.getCurrentAccountUin())) && (localMVMembersInfo.g != null))
                      {
                        localObject2 = new StringBuilder();
                        ((StringBuilder)localObject2).append(localMVMembersInfo.g);
                        ((StringBuilder)localObject2).append(this.a.getResources().getString(2131893493));
                        localMVMembersInfo.g = ((StringBuilder)localObject2).toString();
                      }
                    }
                  }
                  else
                  {
                    localMVMembersInfo.g = this.a.d.a((String)localObject1, String.valueOf(this.a.h), this.a.i);
                  }
                  if (localMVMembersInfo.g == null) {
                    localMVMembersInfo.g = ((String)localObject1);
                  }
                  if (localMVMembersInfo.g.compareTo((String)localObject1) != 0) {
                    localMVMembersInfo.f = true;
                  } else {
                    localMVMembersInfo.f = false;
                  }
                  if (this.a.i == 7)
                  {
                    localObject2 = new BitmapFactory.Options();
                    ((BitmapFactory.Options)localObject2).inJustDecodeBounds = true;
                    localObject1 = BitmapFactory.decodeResource(this.a.getResources(), 2130843237, (BitmapFactory.Options)localObject2);
                    ((BitmapFactory.Options)localObject2).inJustDecodeBounds = false;
                  }
                }
              }
            }
            try
            {
              localObject2 = BitmapFactory.decodeResource(this.a.getResources(), 2130843237, (BitmapFactory.Options)localObject2);
              localObject1 = localObject2;
            }
            catch (OutOfMemoryError localOutOfMemoryError)
            {
              label628:
              long l;
              break label628;
            }
            localMVMembersInfo.f = false;
            break label670;
            localObject1 = this.a.d.a((String)localObject1, String.valueOf(this.a.h), this.a.i, false, true);
            label670:
            if (localObject1 != null)
            {
              localMVMembersInfo.i = ((Bitmap)localObject1);
            }
            else
            {
              localMVMembersInfo.i = null;
              localMVMembersInfo.f = false;
              break label958;
              l = localMVMembersInfo.a;
              if (localMVMembersInfo.l != null) {
                localObject1 = localMVMembersInfo.l;
              } else {
                localObject1 = this.a.d.b(l, this.a.d.k().bm);
              }
              if ((localObject1 != null) && (((AVPhoneUserInfo)localObject1).telInfo.mobile != null))
              {
                localMVMembersInfo.g = ((AVPhoneUserInfo)localObject1).telInfo.mobile;
                localObject2 = this.a.d.d(((AVPhoneUserInfo)localObject1).telInfo.mobile);
                if (localObject2 != null)
                {
                  localMVMembersInfo.h = ContactUtils.b((String)localObject2);
                  localMVMembersInfo.g = ((String)localObject2);
                }
                else
                {
                  localMVMembersInfo.h = null;
                  localMVMembersInfo.g = PstnUtils.a(((AVPhoneUserInfo)localObject1).telInfo.mobile, 4);
                }
              }
              else
              {
                if ((localObject1 != null) && (QLog.isColorLevel()))
                {
                  localObject2 = new StringBuilder();
                  ((StringBuilder)localObject2).append("getView --> can not get Open Id. PhoneInfo = ");
                  ((StringBuilder)localObject2).append(((AVPhoneUserInfo)localObject1).toString());
                  QLog.d("MemberPagerAdapter", 2, ((StringBuilder)localObject2).toString());
                }
                localMVMembersInfo.h = null;
                localMVMembersInfo.g = this.a.getResources().getString(2131890648);
              }
              localMVMembersInfo.i = ((BitmapDrawable)this.a.getResources().getDrawable(2130843137)).getBitmap();
              localMVMembersInfo.f = true;
            }
            label958:
            if ((this.a.i != 1) && (this.a.i != 2)) {
              if (this.a.i != 7) {
                break;
              }
            }
            if ((k != 7) || (this.a.k.size() <= 8)) {
              break;
            }
            localHolder.l = false;
            localObject1 = new GradientDrawable();
            ((GradientDrawable)localObject1).setShape(1);
            ((GradientDrawable)localObject1).setColor(Color.parseColor("#4C000000"));
            localHolder.g.setImageDrawable((Drawable)localObject1);
            localHolder.i = ((TextView)localView2.findViewById(2131441085));
            localObject1 = new StringBuilder("");
            ((StringBuilder)localObject1).append(this.a.k.size() - 8 + 1);
            ((StringBuilder)localObject1).append("+");
            localHolder.i.setText(((StringBuilder)localObject1).toString());
            localHolder.i.setTextColor(-1);
            localHolder.i.setVisibility(0);
            localHolder.h.setText("");
            localHolder.n = true;
            localView2.setContentDescription(this.a.getResources().getString(2131890647));
          }
          if (this.a.i == 7)
          {
            localHolder.o = localMVMembersInfo.n;
            k = localHolder.o;
            if (k != 1)
            {
              if (k != 2)
              {
                if (k == 4) {
                  localHolder.e.setImageResource(2130842897);
                }
              }
              else {
                localHolder.e.setImageResource(2130842895);
              }
            }
            else {
              localHolder.e.setImageResource(2130842899);
            }
            if (localHolder.o != 0) {
              localHolder.e.setVisibility(0);
            }
            if (String.valueOf(localMVMembersInfo.a).endsWith(this.a.c.getCurrentAccountUin())) {
              localHolder.h.setTextColor(this.a.getResources().getColor(2131165706));
            } else {
              localHolder.h.setTextColor(this.a.getResources().getColor(2131168464));
            }
          }
          localHolder.l = true;
          localHolder.a = localMVMembersInfo.a;
          l = localMVMembersInfo.a;
          if (localMVMembersInfo.g != null)
          {
            localHolder.h.setText(localMVMembersInfo.g);
            if ((this.a.d.k().aQ == 7) && (!localHolder.h.isShown()) && (!localMVMembersInfo.g.equals(String.valueOf(l)))) {
              localHolder.h.setVisibility(0);
            }
          }
          else
          {
            if ((this.a.d.k().aQ == 7) && (localHolder.h.isShown())) {
              localHolder.h.setVisibility(4);
            }
            localHolder.h.setText(String.valueOf(localMVMembersInfo.a));
          }
          if (localMVMembersInfo.i != null)
          {
            if ((localMVMembersInfo.j != 0) && (localMVMembersInfo.h != null))
            {
              localHolder.i.setVisibility(0);
              localHolder.i.setText(localMVMembersInfo.h);
              localObject1 = ((BitmapDrawable)this.a.getResources().getDrawable(2130843087)).getBitmap();
              localHolder.g.setImageBitmap((Bitmap)localObject1);
            }
            else
            {
              localHolder.i.setVisibility(8);
              localHolder.g.setImageBitmap(localMVMembersInfo.i);
            }
          }
          else
          {
            localHolder.i.setVisibility(8);
            localHolder.g.setImageResource(2130841060);
          }
          if (((this.a.d.k().aQ == 1) && (this.a.d.k().o == 10)) || (this.a.d.k().aQ == 2) || (this.a.d.k().aQ == 7)) {
            if (localMVMembersInfo.m)
            {
              if (localHolder.m.getVisibility() != 0) {
                localHolder.m.setVisibility(0);
              }
              if (localHolder.c.getVisibility() == 0)
              {
                localHolder.c.setVisibility(8);
                MultiMembersAudioUI.a(this.a, localHolder.d, 8);
              }
              localMVMembersInfo.b = false;
            }
            else if (localHolder.m.getVisibility() == 0)
            {
              localHolder.m.setVisibility(8);
            }
          }
          localHolder.k = localMVMembersInfo.b;
          if (localHolder.k)
          {
            localHolder.c.setVisibility(0);
            MultiMembersAudioUI.a(this.a, localHolder.d, 0);
          }
          else
          {
            localHolder.c.setVisibility(8);
            MultiMembersAudioUI.a(this.a, localHolder.d, 8);
          }
          if (localMVMembersInfo.d == 2) {
            localHolder.b = 5;
          }
          for (;;)
          {
            break;
            if (localMVMembersInfo.e) {
              localHolder.b = 3;
            } else if (localMVMembersInfo.d == 1) {
              localHolder.b = 2;
            } else if (localMVMembersInfo.c) {
              localHolder.b = 1;
            } else {
              localHolder.b = 0;
            }
          }
          if ((this.a.n) && (ThemeUtil.isInNightMode(this.a.c)) && (localHolder.g != null))
          {
            localObject1 = localHolder.g.getDrawable();
            if ((localObject1 != null) && ((localObject1 instanceof BitmapDrawable)))
            {
              localObject1 = UITools.a(((BitmapDrawable)localObject1).getBitmap(), "#4C000000", true);
              localHolder.g.setImageBitmap((Bitmap)localObject1);
            }
          }
          if ((localHolder.g != null) && (((this.a.d.k().aQ == 1) && (this.a.d.k().o == 10)) || ((this.a.i == 2) && (!localHolder.q))))
          {
            localObject1 = localHolder.g.getDrawable();
            if ((localObject1 != null) && ((localObject1 instanceof BitmapDrawable)))
            {
              localObject1 = ImageUtil.a(((BitmapDrawable)localObject1).getBitmap(), true);
              localHolder.g.setImageBitmap((Bitmap)localObject1);
            }
          }
        }
        j += 1;
      }
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("MemberPagerAdapter_");
      ((StringBuilder)localObject1).append(paramInt);
      localView1.setTag(((StringBuilder)localObject1).toString());
      paramViewGroup.addView(localView1);
      return localView1;
    }
    QLog.isColorLevel();
    return null;
  }
  
  public boolean isViewFromObject(View paramView, Object paramObject)
  {
    return paramView == paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.MultiMembersAudioUI.MemberPagerAdapter
 * JD-Core Version:    0.7.0.1
 */