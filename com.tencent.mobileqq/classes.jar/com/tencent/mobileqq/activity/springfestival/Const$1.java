package com.tencent.mobileqq.activity.springfestival;

import com.tencent.mobileqq.activity.springfestival.entry.model.ITime;
import com.tencent.mobileqq.activity.springfestival.entry.model.TimeInfo;
import java.util.Comparator;

final class Const$1
  implements Comparator<ITime>
{
  public int a(ITime paramITime1, ITime paramITime2)
  {
    if (paramITime1.getConfigTime().begin == paramITime2.getConfigTime().begin) {
      return Const.a(paramITime1.getConfigTime().end, paramITime2.getConfigTime().end);
    }
    return Const.a(paramITime1.getConfigTime().begin, paramITime2.getConfigTime().begin);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.springfestival.Const.1
 * JD-Core Version:    0.7.0.1
 */