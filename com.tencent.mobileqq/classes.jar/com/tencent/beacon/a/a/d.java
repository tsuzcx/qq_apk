package com.tencent.beacon.a.a;

import java.util.Locale;

public final class d
{
  public static final String[][] a = new String[7][];
  
  static
  {
    a[0] = { "t_event", String.format(Locale.US, "CREATE TABLE %s ( %s INTEGER PRIMARY KEY AUTOINCREMENT, %s int , %s int , %s int , %s int , %s blob)", new Object[] { "t_event", "_id", "_time", "_type", "_prority", "_length", "_datas" }) };
    a[1] = { "t_count_event", String.format(Locale.US, "CREATE TABLE %s ( %s INTEGER PRIMARY KEY AUTOINCREMENT, %s varchar(255) unique  , %s int , %s int , %s int , %s int , %s int , %s text)", new Object[] { "t_count_event", "_id", "_countid", "_prority", "_local", "_stime", "_utime", "_ctime", "_cparams" }) };
    a[2] = { "t_strategy", String.format(Locale.US, "CREATE TABLE %s ( %s INTEGER PRIMARY KEY AUTOINCREMENT, %s int unique , %s int , %s blob)", new Object[] { "t_strategy", "_id", "_key", "_ut", "_datas" }) };
    a[3] = { "t_file", String.format(Locale.US, "CREATE TABLE %s ( %s INTEGER PRIMARY KEY AUTOINCREMENT, %s text , %s int , %s int , %s text , %s text , %s text , %s text)", new Object[] { "t_file", "_id", "_n", "_ut", "_sz", "_ac", "_sa", "_t", "_p" }) };
    a[4] = { "t_req_data", String.format(Locale.US, "CREATE TABLE %s ( %s INTEGER PRIMARY KEY AUTOINCREMENT, %s text unique , %s int , %s int , %s blob)", new Object[] { "t_req_data", "_id", "_rid", "_time", "_cnt", "_datas" }) };
    a[5] = { "t_apple", String.format(Locale.US, "CREATE TABLE %s ( %s INTEGER PRIMARY KEY AUTOINCREMENT, %s blob unique , %s int , %s int, %s int)", new Object[] { "t_apple", "_id", "_a", "_b", "_c", "_d" }) };
    a[6] = { "t_conf", String.format(Locale.US, "CREATE TABLE %s ( %s INTEGER PRIMARY KEY AUTOINCREMENT, %s text unique , %s text , %s int , %s int)", new Object[] { "t_conf", "_id", "_key", "_value", "_vdate", "_time" }) };
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.beacon.a.a.d
 * JD-Core Version:    0.7.0.1
 */